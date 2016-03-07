
var TreeData = null;
var SelForCenterType = null;	//1=数据中心    2=资源中心 	3=网络区域
var SelForCenterId = null;

var SelForCenterType1 = null;	//1=数据中心    2=资源中心 	3=网络区域
var SelForCenterId1 = null;

var mouseenter = false;
var mouseenter1 = false;

var CurrDataMap = {};
var bgcolors = ["emerald-bg","red-bg","yellow-bg","green-bg","purple-bg","gray-bg"];

var ParamApplyPageNum = 1;

var ParentLeftWidth = 0;
var ParentHeaderHeight = 0;


function init() {
	initData(function() {
		initComponent();
		initListener();
		initFace();
		queryRes();
		if(!CU.isEmpty(ParamApplyPageNum)) {
			$("#tab_1").removeClass("active");
			$("#tab_2").addClass("active");
			$("#tab_mntres").removeClass("in active");
			$("#tab_mntapply").addClass("in active");
		}
		queryGrid(ParamApplyPageNum);
	});
	
}


function initData(cb) {
	var pb = CC.getParentLayoutBorder();
	ParentLeftWidth = pb.width;
	ParentHeaderHeight = pb.height;
	
	ParamApplyPageNum = PRQ.get("pageNum");
	
	var statusselhtml = PU.getSelectOptionsHtml("V_PS_RES_APPLY_CHECK_STATUS");
	$("#cdtStatus").html(statusselhtml);
	
	RS.ajax({url:"/res/res/getResRegionDropListMap",ps:{addEmpty:true, addAttr:true, opts:"dc|rc|nc"},cb:function(result) {
		DROP["DV_DATA_CENTER_CODE"] = result["dc"];
		DROP["DV_RES_CENTER_CODE"] = result["rc"];
		DROP["DV_NET_ZONE_CODE"] = result["nc"];
		
		var dropList = [];
		for(var i=1; i<result["dc"].length; i++) dropList.push(result["dc"][i]);
		for(var i=1; i<result["rc"].length; i++) dropList.push(result["rc"][i]);
		for(var i=1; i<result["nc"].length; i++) dropList.push(result["nc"][i]);
		TreeData = toTreeData(dropList);
		
		if(CU.isFunction(cb))cb();
	}});
}
function initComponent() {
	$("#cdtApplyTime").datetimepicker({
		minView: "month",
		format: "yyyy-mm-dd", 
		language: "zh-CN",
		autoclose:true
	});
	
	$("#sel_forcenter1").treeview({data:TreeData,color:"#428bca",selectedBackColor:"#f0f8ff",selectedColor:"#428bca",collapseIcon:"fa fa-minus-square-o",expandIcon:"fa fa-plus-square-o",onNodeSelected: function(e, node) {
		if(CU.isEmpty(node.id)) {
			SelForCenterType1 = null;
			SelForCenterId1 = null;
			$("#forcenter1").val("");
		}else {
			SelForCenterType1 = node.param1;
			SelForCenterId1 = node.id;
			$("#forcenter1").val(node.text);
		}
		$('#sel_forcenter1').hide();
		queryRes();
	}});
	$("#sel_forcenter1").treeview("collapseAll", {silent:true});
	
	$("#sel_forcenter").treeview({data:TreeData,color:"#428bca",selectedBackColor:"#f0f8ff",selectedColor:"#428bca",collapseIcon:"fa fa-minus-square-o",expandIcon:"fa fa-plus-square-o",onNodeSelected: function(e, node) {
		if(CU.isEmpty(node.id)) {
			SelForCenterType = null;
			SelForCenterId = null;
			$("#forcenter").val("");
		}else {
			SelForCenterType = node.param1;
			SelForCenterId = node.id;
			$("#forcenter").val(node.text);
		}
		$('#sel_forcenter').hide();
		queryGrid();
	}});
	$("#sel_forcenter").treeview("collapseAll", {silent:true});
}
function initListener() {
	$("#cdtApplyTime").bind("change", function(){queryGrid();});
	$("#cdtStatus").bind("change", function(){queryGrid();});
	
	
	$("#forcenter1").bind("focus",function(){
		var sul = $('#sel_forcenter1');
		sul.css("top", $("#forcenter1").offset().top-$("#forcenter1").height()+ParentHeaderHeight+10);
		sul.css("left", $("#forcenter1").offset().left-$("#forcenter1").width()-50+ParentLeftWidth+5);
		sul.show(); 
	});
	$("#forcenter1").on("blur", function() {
		if(!mouseenter1) $("#sel_forcenter1").hide();
	});
	$("#sel_forcenter1").on("mouseenter",function(){mouseenter1=true;});
	$("#sel_forcenter1").on("mouseleave",function(){mouseenter1=false;});
	$("#sel_forcenter1").bind("click", function() {
		if(!$("#sel_forcenter1").is(":hidden")) $("#forcenter1").focus();
	});
	
	
	$("#forcenter").bind("focus",function(){
		var sul = $('#sel_forcenter');
		sul.css("top", $("#forcenter").offset().top-$("#forcenter").height()+ParentHeaderHeight+10);
		sul.css("left", $("#forcenter").offset().left-$("#forcenter").width()-90+ParentLeftWidth+5);
		sul.show(); 
	});
	$("#forcenter").on("blur", function() {
		if(!mouseenter) $("#sel_forcenter").hide();
	});
	$("#sel_forcenter").on("mouseenter",function(){mouseenter=true;});
	$("#sel_forcenter").on("mouseleave",function(){mouseenter=false;});
	$("#sel_forcenter").bind("click", function() {
		if(!$("#sel_forcenter").is(":hidden")) $("#forcenter").focus();
	});
	
	
	$("#btn_query").bind("click",function(){queryGrid();});
	$("#grid_pageSize").bind("change",function(){query();});
	$("#btn_addApply").bind("click", function(){forwardApplyForm();});
	
	$("#btn_myres").bind("click", function() {
		window.location = ContextPath + "/dispatch/mc/10201";
	});
}
function initFace() {
}


/** 执行条件文本框回车查询 **/
function doCdtTFKeyUp(e) {
	if(e.keyCode === 13) queryGrid();
}


function toTreeData(dropList) {
	var tree = [{}];
	var pnobj = {};
	for(var i=0; i<dropList.length; i++) {
		var item = dropList[i];
		var type = item.param1;
		
		item.id = item.code;
		item.text = item.name;
		
		pnobj[item.code+"_"+type] = item;
		
		if(type == "1") {
			item.icon = "fa fa-database";
			tree.push(item);
		}else {
			item.icon = type=="2" ? "fa fa-sitemap" : "fa fa-flash";
			var pn = pnobj[item.parentCode+"_"+(parseInt(type, 10)-1)];
			if(CU.isEmpty(pn)) continue ;
			if(CU.isEmpty(pn.childNodes)) pn.childNodes = [];
			pn.childNodes.push(item);
		}
	}
	return tree;
}



function queryRes(){
	$("#div_mntResList").html("");
	
	var cdt = {orders:"DATA_CENTER_ID,RES_CENTER_ID"};
	
	if(!CU.isEmpty(SelForCenterType1) && !CU.isEmpty(SelForCenterId1)) {
		switch (SelForCenterType1) {		//1=数据中心    2=资源中心 	3=网络区域 
			case "1": cdt.dataCenterId = SelForCenterId1; break;
			case "2": cdt.resCenterId = SelForCenterId1; break;
			case "3": cdt.netZoneId = SelForCenterId1; break;
		}
	}
	
	RS.ajax({url:"/res/mntres/getMntResList",ps:cdt,cb:function(rs) {
		if(CU.isEmpty(rs)) {
			$("#div_mntResList").html("<h2 style='color:blue;'>无资源</h2>");
			return ;
		}
		
		for(var i=0; i<rs.length; i++) {
			var row = rs[i];
			row.titlebg = bgcolors[i%bgcolors.length]; 
			
			var dc = CU.getDropItemRecord("DV_DATA_CENTER_CODE", row.dataCenterId);
			var rc = CU.getDropItemRecord("DV_RES_CENTER_CODE", row.resCenterId);
			var nc = CU.getDropItemRecord("DV_NET_ZONE_CODE", row.netZoneId);
			if(!CU.isEmpty(dc)) row.dataCenterName = "[" + dc.attributes.code + "] " + dc.name;
			if(!CU.isEmpty(rc)) row.resCenterName = "[" + rc.attributes.resCode + "] " + rc.name;
			if(!CU.isEmpty(nc)) row.netZoneName = "[" + nc.attributes.zoneCode + "] " + nc.name;
		}
		$("#div_mntResList-tmpl").tmpl({data:rs}).appendTo("#div_mntResList");
	}});
	
	
}

function queryGrid(pageNum){
	if(CU.isEmpty(pageNum)) pageNum = 1;
	
	$("#applyTabList").html("");
	$("#ul_pagination").remove();
	$("#pagination_box").html('<ul id="ul_pagination" class="pagination-sm"></ul>');
	delete CurrDataMap;
	CurrDataMap = {};
	
	var pageSize = $("#grid_pageSize").val();
	var applyTime = $("#cdtApplyTime").val();
	var status = $("#cdtStatus").val();
	var orders = " ID DESC ";
	
	var cdt = {pageNum:pageNum,pageSize:pageSize,orders:orders};
	if(!CU.isEmpty(SelForCenterType) && !CU.isEmpty(SelForCenterId)) {
		switch (SelForCenterType) {		//1=数据中心    2=资源中心 	3=网络区域 
			case "1": cdt.dataCenterId = SelForCenterId; break;
			case "2": cdt.resCenterId = SelForCenterId; break;
			case "3": cdt.netZoneId = SelForCenterId; break;
		}
	}
	
	if(!CU.isEmpty(status)) cdt.status = status;
	if(!CU.isEmpty(applyTime)) {
		applyTime = applyTime.replace(/-/g, "");
		cdt.startApplyTime = applyTime + "000000";
		cdt.endApplyTime = applyTime + "235959";
	}
	
	RS.ajax({url:"/res/mntres/queryApplyPage",ps:cdt,cb:function(r) {
		if(!CU.isEmpty(r)){
			var data = r.data;
			for(var i=0; i<data.length; i++) {
				CurrDataMap["key_"+data[i].id] = data[i];
			}
			
			ParamApplyPageNum = r.pageNum;
			$("#ul_pagination").twbsPagination({
		        totalPages: r.totalPages?r.totalPages:1,
		        visiblePages: 7,
		        startPage: r.pageNum,
		        first:"首页",
		        prev:"上一页",
		        next:"下一页",
		        last:"尾页",
		        onPageClick: function (event, page) {
		        	query(page);
		        }
		    });
			$('#applyTabList-tmpl').tmpl(r).appendTo("#applyTabList");
			
			for(var i=0;i<data.length;i++){
				$("#a_apply_"+data[i].id).bind("click", function() {
					var applyId = this.id.substring(this.id.lastIndexOf("_")+1);
					forwardApplyForm(applyId);
				});
				
				$("#btn_cancel_"+data[i].id).bind("click", function() {
					var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
					cancelApply(obj);
				});
				$("#btn_check_view_"+data[i].id).bind("click", function() {
					var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
					showCheckView(obj);
				});
			}
		}
	}});
}


function replaceDesc(desc) {
	if(CU.isEmpty(desc)) return "";
	return (desc+"").replace(/\n/g, "<br>");
}



function cancelApply(obj) {
	CC.showMsg({msg:"您确定要撤销申请单[<font color='blue'>"+obj.code+"</font>]吗?",option:2,callback:function(r) {
		if(r != "ok") return ;
		RS.ajax({url:"/res/mntres/cannelApply",ps:{applyId:obj.id},cb:function(rr) {
			queryGrid(ParamApplyPageNum);
		}});
	}});
}

function showCheckView(apply) {
	$("#tabCheckView").html("");
	$("#div_checkViewTitle").html("资源申请单[<font color='#008800'>"+apply.code+"</font>]审核情况");
	$('#tabCheckView-tmpl').tmpl(apply).appendTo("#tabCheckView");
	$('#div_checkView').modal('show');
}



function forwardApplyForm(applyId) {
	var url = ContextPath + "/dispatch/mc/1020101?1=1";
	if(!CU.isEmpty(ParamApplyPageNum)) url += "&pageNum="+ParamApplyPageNum;
	if(!CU.isEmpty(applyId)) url += "&id="+applyId;
	window.location = url;
}

