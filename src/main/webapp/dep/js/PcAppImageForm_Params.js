

var AppId = "";
var AppImageId = "";
var AppVnoId = "";
var ParamPageNum = 1;

var BTN_TYPE = 1;	//-1=prev 0=save 1=next

var GridAddId = 1;


/** 初始化 **/
function init() {
	setPageHeaderSetupNum(4);
	initData(function() {
		initComponent();
		initListener();
		initFace();
		queryInfo();
	});
}

/** 初始化页面、内存等基本数据 **/
function initData(cb) {
	AppId = PRQ.get("appId");
	AppImageId = PRQ.get("appImageId");
	AppVnoId = PRQ.get("appVnoId");
	ParamPageNum = PRQ.get("pageNum");
	if(CU.isEmpty(ParamPageNum)) ParamPageNum = 1;
	
	if(CU.isEmpty(AppId) || CU.isEmpty(AppImageId) || CU.isEmpty(AppVnoId)) {
		alert("没有找到应用["+AppId+"]或镜像["+AppImageId+"]!");
		pageBack();
		return;
	}
	if(CU.isFunction(cb))cb();
}

/** 初始化组件 **/
function initComponent() {
	CC.onBreadLineClick = function(moduId, moduCode, url) {
		if(moduCode == "1040501") {
			url += "?appId=" + AppId + "&appVnoId=" + AppVnoId;
			if(!CU.isEmpty(ParamPageNum)) url += "&pageNum="+ParamPageNum;
			return url;
		}
	};
}

/** 对组件设置监听 **/
function initListener() {
	$("#a_add_param").bind("click",function(){addParamRow();});
	$("#btn_prev").bind("click", function(){BTN_TYPE=-1;});
	$("#btn_save").bind("click", function() {BTN_TYPE=0;});
	$("#btn_next").bind("click", function(){BTN_TYPE=1;});
	$("#form_params").submit(function(e){
	    e.preventDefault();
	    switch(BTN_TYPE) {
	    	case -1: prevForm(); break;
	    	case 0: submitForm(); break;
	    	case 1: nextForm(); break;
	    }
	});
	RS.setAjaxLodingButton("btn_save");
}

/** 初始化界面 **/
function initFace() {
}






function addParamRow(obj) {
	var key = CU.isEmpty(obj)||CU.isEmpty(obj.kvKey) ? "" : obj.kvKey;
	var value = CU.isEmpty(obj)||CU.isEmpty(obj.kvVal) ? "" : obj.kvVal;
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
	tr.append($("<td class=\"text-center\"><input type=\"text\" class=\"form-control\" name=\"param_keyDesc\" value=\""+desc+"\" maxlength=\"200\"  /></td>"));
	tr.append($("<td class=\"text-center\"><input type=\"text\" class=\"form-control\" name=\"param_value\" value=\""+value+"\" maxlength=\"50\" /></td>"));
	tr.append($("<td class=\"text-center\"></td>").append(a));
	a.bind("click", function() {removeParam(trid);});
	$("#paramsTable").append(tr);
}


function setTableParams(params){
	$("#paramsTable").html("");
	for(var i=0;i<params.length;i++){
		addParamRow(params[i]);
	}
}

function getTableParams(){
	var params = [];
	var keys = [];
	
	var param_keys = $("input[name='param_key']");
	var param_values = $("input[name='param_value']");
	var param_descs = $("input[name='param_keyDesc']");
	for(var i=0;i<param_keys.length;i++){
		var v = $.trim($(param_keys[i]).val());
		var value = $.trim($(param_values[i]).val());
		var desc = $.trim($(param_descs[i]).val());
		if(v.length == 0){
			CC.showMsg({msg:"第["+(i+1)+"]行，参数名不可以为空!"});
		}
		if(value.length == 0){
			CC.showMsg({msg:"第["+(i+1)+"]行，参数值不可以为空!"});
		}
		if(keys.indexOf(v) > -1) {
 			CC.showMsg({msg:"参数名<font color='blue'>["+v+"]</font>不可以重复!"});
    		return false;
 		}
 		keys.push(v);
 		
 		var param = {};
		param.kvKey = v;
		param.kvVal = value;
		param.keyDesc = desc;
		params.push(param);
	}
	if(params.length>0){
		return CU.toString(params);
	}
	return "";
}

function removeParam(elId){
	$("#"+elId).remove();
}






function queryInfo(cb){
	RS.ajax({url:"/dep/appimage/getAppImageParams",ps:{appImageId:AppImageId},cb:function(rs) {
		setTableParams(rs);
	}});
}

/**提交表单**/
function submitForm(cb){
	var strParams =  getTableParams();
	if(strParams === false) return;
	
	RS.ajax({url:"/dep/appimage/saveAppImageParams",ps:{appImageId:AppImageId,strParams:strParams},cb:function(rs) {
		$("#btn_save").prop("title", "保存成功");
		$("#btn_save").tooltip("show");
		setTimeout(function(){
			$("#btn_save").prop("title", "");
			$("#btn_save").tooltip("destroy");
		}, 2000);
		
		if(CU.isFunction(cb))cb(); 
	}});
}



function prevForm(){
	var url = ContextPath + "/dispatch/mc/104050104?appId=" + AppId + "&appVnoId=" + AppVnoId + "&appImageId="+AppImageId;
	if(!CU.isEmpty(ParamPageNum)) url += "&pageNum="+ParamPageNum;
	window.location = url;
}

function nextForm() {
	submitForm(function() {
		var url = ContextPath + "/dispatch/mc/104050106?appId=" + AppId + "&appVnoId=" + AppVnoId + "&appImageId="+AppImageId;
		if(!CU.isEmpty(ParamPageNum)) url += "&pageNum="+ParamPageNum;
		window.location = url;
	});
}


function pageBack() {
	var url = ContextPath + "/dispatch/mc/1040501?1=1&appImageId="+AppImageId;
	if(!CU.isEmpty(AppId)) url += "&appId="+AppId;
	if(!CU.isEmpty(AppVnoId)) url += "&appVnoId="+AppVnoId;
	if(!CU.isEmpty(ParamPageNum)) url += "&pageNum="+ParamPageNum;
	window.location = url;
}


