var ParamPageNum = 1;
var CurrDataMap = {};

var TreeData = null;
var SelForCenterType = null;	//1=数据中心    2=资源中心    3=网络区域
var SelForCenterId = null;

var mouseenter = false;

var ParentLeftWidth = 0;
var ParentHeaderHeight = 0;


function init() {
	initData(function() {
		initComponent();
		initListener();
		initFace();
		query(ParamPageNum);
	});
	
}

function initData(cb) {
	var pb = CC.getParentLayoutBorder();
	ParentLeftWidth = pb.width;
	ParentHeaderHeight = pb.height;
	
	ParamPageNum = PRQ.get("pageNum");
	if(CU.isEmpty(ParamPageNum)) ParamPageNum = 1;
	RS.ajax({url:"/res/res/getResRegionDropListMap",ps:{addEmpty:true, addAttr:true,opts:"dc|rc|nc"},cb:function(result) {
		DROP["DV_DATA_CENTER_CODE"] = result["dc"];
		DROP["DV_RES_CENTER_CODE"] = result["rc"];
		DROP["DV_NET_ZONE_CODE"] = result["nc"];
		var dropList = [];
		for(var i=0; i<result["dc"].length; i++) dropList.push(result["dc"][i]);
		for(var i=0; i<result["rc"].length; i++) dropList.push(result["rc"][i]);
		TreeData = toTreeData(dropList);
		if(CU.isFunction(cb))cb();
	}});
}
function initComponent() {
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
		query(1);
	}});
	$("#sel_forcenter").treeview("collapseAll", {silent:true});
}
function initListener() {
	$("#appCode").bind("keyup", doCdtTFKeyUp);
	$("#appName").bind("keyup", doCdtTFKeyUp);
	$("#forcenter").bind("focus",function(){
		var sul = $('#sel_forcenter');
		sul.css("top", $("#forcenter").offset().top-$("#forcenter").height()+ParentHeaderHeight+10);
		sul.css("left", $("#forcenter").offset().left-$("#forcenter").width()-130+ParentLeftWidth+5);
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
	$("#btn_query").bind("click",function(){query();});
	$("#grid_pageSize").bind("change",function(){query();});
}
function initFace() {
}

/** 执行条件文本框回车查询 **/
function doCdtTFKeyUp(e) {
	if(e.keyCode === 13) query(1);
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

function getNetZoneName(netZoneId) {
	if(CU.isEmpty(netZoneId)) return "";
	var item = CU.getDropItemRecord("DV_NET_ZONE_CODE", netZoneId);
	if(CU.isEmpty(item)) return "";
	return "["+item.attributes.zoneCode+"] "+item.name;
}

function query(pageNum){
	if(CU.isEmpty(pageNum)) pageNum = 1;
	$("#appImageTable").html("");
	$("#ul_pagination").remove();
	$("#pagination_box").html('<ul id="ul_pagination" class="pagination-sm"></ul>');
	var pageSize = $("#grid_pageSize").val();
	var appCode = $("#appCode").val();
	var appName = $("#appName").val();
	var orders = "APP_CODE , ID";
	
	var ps = {pageNum:pageNum,pageSize:pageSize,appCode:appCode,appName:appName,orders:orders};
	
	if(!CU.isEmpty(SelForCenterType) && !CU.isEmpty(SelForCenterId)) {
		switch (SelForCenterType) {		//1=数据中心    2=资源中心 
			case "1": ps.dataCenterId = SelForCenterId; break;
			case "2": ps.resCenterId = SelForCenterId; break;
		}
	}
	RS.ajax({url:"/dep/app/queryMgrResInfoPage",ps:ps,cb:function(r) {
		if(!CU.isEmpty(r)){
			var data = r.data;
			for(var i=0;i<data.length;i++){
				CurrDataMap["key_"+data[i].app.id] = data[i];
			}
			ParamPageNum = r.pageNum;
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
			$("#appImageTable-tmpl").tmpl(r).appendTo("#appImageTable");
			for(var i=0;i<data.length;i++) {
				$("#a_app_res_use_"+data[i].app.id).bind("click",function(){
					var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
					showAppResUseModal(obj.app.id, obj.app.versionId);
				});
//				
				$("#a_app_image_setup_"+data[i].app.id).editable({
					display:false,
					showbuttons: false,
			        value:"",
					tpl:getSelectAppVnoTpl(data[i].app.id)
				});
			}
		}
	}});
	
}

function getSelectAppVnoTpl(appId) {
	var tpl = [];
	var obj = CurrDataMap["key_"+appId];
	var height = 30;
	
	if(!CU.isEmpty(obj) && !CU.isEmpty(obj.appVnos)) {
		var appVnos = obj.appVnos;
		for(var i=0; i<appVnos.length; i++) {
			tpl.push("<input id='a_app_image_setup_"+appId+"_"+appVnos[i].id+"' name=id='a_app_image_setup_"+appId+"' type='radio' onclick='selectAppVnoTplClick(this)'>"
						+ "<span style='padding-left:5px;'></span>"
						+ "<label for='a_app_image_setup_"+appId+"_"+appVnos[i].id+"'>" + appVnos[i].versionNo 
						+ "<span style='padding-left:25px;'></span>"
						+ "<font color='"+(appVnos[i].setupStatus==1?"#008800":"#ff0000")+"'>["+(appVnos[i].setupStatus==1?"已完成":"未完成")+"]</font></label>");
		}
		
		height *= appVnos.length;
	}
		
	return "<div style='height:"+height+"px;'>"+tpl.join("<br>")+"</div>";
}

function selectAppVnoTplClick(rb) {
	var id = rb.id;
	var appVnoId = id.substring(id.lastIndexOf('_')+1);
	id = id.substring(0, id.lastIndexOf('_'));
	var appId = id.substring(id.lastIndexOf('_')+1);
	$("#a_app_image_setup_"+appId).editable("hide");
	forwardSetup(CurrDataMap["key_"+appId], appVnoId);
}


function showAppResUseModal(appId, appVnoId){
	var obj =  CurrDataMap["key_"+appId];
	$("#div_title").html("应用[<font color='blue'>"+obj.app.appCode+"</font>]资源占用情况");
	$("#appResUseTable").html("");
	RS.ajax({url:"/dep/app/queryAppNetZoneResInfo",ps:{appId:appId, appVnoId:appVnoId},cb:function(rs) {
		if(!CU.isEmpty(rs)){
			var row = CurrDataMap["key_"+appId];
			row.FLAG_SUMMARY = true;
			rs.push(row);
			$("#appResUseTable-tmpl").tmpl({data:rs}).appendTo("#appResUseTable");
		}
	}});
	$("#div_appResUse").modal("show");
}




function forwardSetup(appinfo, appVnoId) {
	if(CU.isEmpty(appinfo.totalRes)) {
		CC.showMsg({msg:"应用[<font color='blue'>"+appinfo.app.appCode+"</font>]没有资源，请先申请资源。"});
		return ;
	}
	
	if(CU.isEmpty(appinfo.imageTotal)) {
		window.location = ContextPath + "/dispatch/mc/104050102?appId="+appinfo.app.id+"&appVnoId="+appVnoId;
	}else {
		window.location = ContextPath + "/dispatch/mc/1040501?appId="+appinfo.app.id+"&appVnoId="+appVnoId+"&pageNum="+ParamPageNum;
	}
}




