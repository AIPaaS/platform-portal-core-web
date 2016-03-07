var CurrDataMap = {};
var CurrSvcId = "";

var ParamPageNum = 1;

var GridAddId = 1;

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
		query();
	});
	
}


function initData(cb) {
	var pb = CC.getParentLayoutBorder();
	ParentLeftWidth = pb.width;
	ParentHeaderHeight = pb.height;
	
	ParamPageNum = PRQ.get("pageNum");
	if(CU.isEmpty(ParamPageNum)) ParamPageNum = 1;
	RS.ajax({url:"/res/res/getResRegionDropListMap",ps:{addEmpty:true, addAttr:true ,opts:"dc|rc"},cb:function(result) {
		DROP["DV_DATA_CENTER_CODE"] = result["dc"];
		DROP["DV_RES_CENTER_CODE"] = result["rc"];
		var dropList = [];
		for(var i=1; i<result["dc"].length; i++) dropList.push(result["dc"][i]);
		for(var i=1; i<result["rc"].length; i++) dropList.push(result["rc"][i]);
		TreeData = toTreeData(dropList);
		if(CU.isFunction(cb)) cb();
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
	$("#svcCode").bind("keyup", doCdtTFKeyUp);
	$("#svcName").bind("keyup", doCdtTFKeyUp);
	
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
	$("#btn_add").bind("click",function(){window.location = ContextPath + "/dispatch/mc/1040401?pageNum="+ParamPageNum;});
	$("#a_add_param").bind("click",function(){addParamRow();});
	$("#btn_Ok").bind("click",function(){saveSvcParams();});
	
	RS.setAjaxLodingButton("btn_Ok");
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

function query(pageNum){
	if(CU.isEmpty(pageNum)) pageNum = 1;
	$("#externalSvcTable").html("");
	$("#ul_pagination").remove();
	$("#pagination_box").html('<ul id="ul_pagination" class="pagination-sm"></ul>');
	var pageSize = $("#grid_pageSize").val();
	var svcCode = $("#svcCode").val();
	var svcName = $("#svcName").val();
	var orders = "SVC_CODE ,ID";
	
	var ps = {pageNum:pageNum,pageSize:pageSize,svcCode:svcCode,svcName:svcName,orders:orders};
	
	if(!CU.isEmpty(SelForCenterType) && !CU.isEmpty(SelForCenterId)) {
		switch (SelForCenterType) {		//1=数据中心    2=资源中心 
			case "1": ps.dataCenterId = SelForCenterId; break;
			case "2": ps.resCenterId = SelForCenterId; break;
		}
	}
	
	RS.ajax({url:"/external/service/queryPage",ps:ps,cb:function(r) {
		if(!CU.isEmpty(r)){
			var data = r.data;
			for(var i=0;i<data.length;i++){
				CurrDataMap["key_"+data[i].id] = data[i];
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
			$('#externalSvcTable-tmpl').tmpl(r).appendTo("#externalSvcTable");
			for(var i=0;i<data.length;i++){
				$("#a_svc_params_"+data[i].id).bind("click",function(){
					var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
					showSvcParams(obj.id);
				});
			}
		}
	}});
	
}
function showSvcParams(id){
	CurrSvcId = id;
	var obj =  CurrDataMap["key_"+id];
	$("#div_SvcParamsTitle").html("服务[<font color='blue'>"+obj.svcName+"</font>]参数列表");
	$("#SvcParamsTable").html("");
	RS.ajax({url:"/external/service/queryParams",ps:{svcId:obj.id, orders:"ID"},cb:function(rs) {
		for(var i=0;i<rs.length;i++){
			addParamRow(rs[i]);
		}
	}});
	$('#div_compTags').modal('show');
}




function addParamRow(obj) {
	var key = CU.isEmpty(obj)||CU.isEmpty(obj.kvKey) ? "" : obj.kvKey;
	var desc = CU.isEmpty(obj)||CU.isEmpty(obj.keyDesc) ? "" : obj.keyDesc;
	
	GridAddId ++ ;
	var trid = "tr_add_" + GridAddId;
	var tr = $("<tr id='"+trid+"'></tr>");
	var a = $("<a href=\"###\" class=\"table-link  danger\" title=\"删除参数\">"
			+ "<span class=\"fa-stack\">"
			+ "<i class=\"fa fa-square fa-stack-2x\"></i>"
			+ "<i class=\"fa fa-minus fa-stack-1x fa-inverse\"></i>"
			+ "</span>"
			+ "</a>");
	tr.append($("<td class=\"text-center\"><input type=\"text\" class=\"form-control\" name=\"param_key\" value=\""+key+"\" maxlength=\"50\" /></td>"));
	tr.append($("<td class=\"text-center\"><input type=\"text\" class=\"form-control\" name=\"param_desc\" value=\""+desc+"\" maxlength=\"200\"  /></td>"));
	tr.append($("<td class=\"text-center\"></td>").append(a));
	a.bind("click", function() {removeTag(trid);});
	$("#SvcParamsTable").append(tr);
}
function saveSvcParams(){
	var params = [];
	var keys = [];
	
	var param_keys = $("input[name='param_key']");
	var param_descs = $("input[name='param_desc']");
	for(var i=0;i<param_keys.length;i++){
		var v = $.trim($(param_keys[i]).val());
		var desc = $.trim($(param_descs[i]).val());
		if(v.length == 0) {
			CC.showMsg({msg:"第["+(i+1)+"]行，参数名不可以为空!"});
			return false;
		}
		if(keys.indexOf(v) > -1) {
 			CC.showMsg({msg:"参数名<font color='blue'>["+v+"]</font>不可以重复!"});
    		return;
 		}
 		keys.push(v);
 		
 		var param = {};
		param.kvKey = v;
		param.keyDesc = desc;
		params.push(param);
 		
	}
	var paramsStr = "";
	if(params.length>0){
		paramsStr = CU.toString(params);
	}
	RS.ajax({url:"/external/service/resetParams",ps:{svcId:CurrSvcId, paramsStr:paramsStr},cb:function(r) {
		$("#btn_Ok").prop("title", "保存成功");
		$("#btn_Ok").tooltip("show");
		setTimeout(function(){
			$("#btn_Ok").prop("title", "");
			$("#btn_Ok").tooltip("destroy");
		}, 2000);
	}});
}
function removeTag(elId){
	$("#"+elId).remove();
}

