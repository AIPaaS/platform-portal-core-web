

var AppId = "";
var AppVnoId = "";
var AppImageId = "";
var APP = null;
var AppType = "";
var ParamPageNum = 1;

var BTN_TYPE = 1;	//-1=prev 0=save 1=next

var GridAddId = 1;

var SvcId = "";

/** 初始化 **/
function init() {
	setPageHeaderSetupNum(2);
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
	
	RS.ajax({url:"/dep/appimage/getAppImageFormInit",ps:{appId:AppId},cb:function(rs) {
		if(CU.isEmpty(rs)) {
			alert("没有找到应用["+AppId+"]!");
			pageBack();
			return;
		}
		
		APP = rs.app;
		AppType = APP.appType;
		
		if(AppType == 2){
			$("#isOpen").prop("disabled",true);
		}
		
		$("#protocol").html("");
		$("#paramsTable").html("");
//		$("#div_isOpen_yes").hide();
		var selhtml = PU.getSelectOptionsHtml("V_PC_SERVICE_PROTOCOL");
		$("#protocol").html(selhtml);
		if(CU.isFunction(cb))cb();
	}});
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
//	$("#isOpen").bind("change",function(){
//		if($("#isOpen").prop("checked")){
//			$("#div_isOpen_yes").show();
//		}else{
//			$("#div_isOpen_yes").hide();
//		}
//	});
	$("#a_add_param").bind("click",function(){addParamRow();});
	$("#btn_prev").bind("click", function(){BTN_TYPE=-1;});
	$("#btn_save").bind("click", function(){BTN_TYPE=0;});
	$("#btn_next").bind("click", function(){BTN_TYPE=1;});
	$("#form_openSvc").submit(function(e){
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
	var value = CU.isEmpty(obj)||CU.isEmpty(obj.keyDesc) ? "" : obj.keyDesc;
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
	tr.append($("<td class=\"text-center\"><input type=\"text\" class=\"form-control\" name=\"param_keyDesc\" value=\""+value+"\" maxlength=\"200\"  /></td>"));
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
	var param_descs = $("input[name='param_keyDesc']");
	for(var i=0;i<param_keys.length;i++){
		var v = $.trim($(param_keys[i]).val());
		var desc = $.trim($(param_descs[i]).val());
		if(v.length == 0) {
			CC.showMsg({msg:"第["+(i+1)+"]行，参数名不可以为空!"});
			return false;
		}
		
		if(keys.indexOf(v) > -1) {
 			CC.showMsg({msg:"参数名<font color='blue'>["+$(param_keys[i]).val()+"]</font>不可以重复!"});
    		return false;
 		}
		
 		keys.push(v);
 		
		var param = {};
		param.kvKey = v;
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
	RS.ajax({url:"/dep/appimage/getAppImageOpenService",ps:{appImageId:AppImageId},cb:function(rs) {
		if(!CU.isEmpty(rs)){
//			$("#div_isOpen_yes").show();
			PU.setFormData(rs.svc, "form_openSvc");
			if(!CU.isEmpty(rs.params)) setTableParams(rs.params);
			$("#isOpen").prop("checked",true);
			SvcId = rs.svc.id;
		}else {
			$("#isOpen").prop("checked",false);
			RS.ajax({url:"/dep/appimage/queryAppImageById",ps:{appImageId:AppImageId},cb:function(rs) {
				if(!CU.isEmpty(rs)){
					PU.setFormData(rs, "form_openSvc");
//					if(!CU.isEmpty(rs.params)) setTableParams(rs.params);
				}
				}
			});
		}	
	}});
}

/**提交表单**/
function submitForm(cb){
	var bean = PU.getFormData("form_openSvc");
	
	bean.isOpen = $("#isOpen").prop("checked") ? 1 : 0;
//	if(!bean.isOpen){
//		delete bean.protocol;
//		delete bean.port;
//		delete bean.svcUrl;
//		delete bean.monitorUrl;
//	}else {
//		var protocol = $("#protocol").val();
//		var port = $("#port").val();
//		var svcUrl = $("#svcUrl").val();
//		if(CU.isEmpty(protocol)){CC.showMsg({msg:"开放协议不能为空"}); return;}
//		if(CU.isEmpty(port)){CC.showMsg({msg:"开放端口不能为空"}); return;}
//		if(CU.isEmpty(svcUrl)){CC.showMsg({msg:"开放URL不能为空"}); return;}
//	}
	
	if(CU.isEmpty($("#protocol").val())){CC.showMsg({msg:"开放协议不能为空"}); return;}
	if(CU.isEmpty($("#port").val())){CC.showMsg({msg:"开放端口不能为空"}); return;}
	if(CU.isEmpty($("#svcUrl").val())){CC.showMsg({msg:"开放URL不能为空"}); return;}
	
	bean.appId = AppId;
	bean.appVnoId = AppVnoId;
	var strParams =  getTableParams();
	if(strParams === false) return;
	
	var ps = {isOpen:bean.isOpen,appImageId:AppImageId,isAccess:bean.isAccess,svcUrl:bean.svcUrl,protocol:bean.protocol,port:bean.port,monitorUrl:bean.monitorUrl,strParams:strParams};
	if(!CU.isEmpty(SvcId)) ps.id = SvcId;
	
	RS.ajax({url:"/dep/appimage/saveAppImageOpenService",ps:ps,cb:function(rs) {
		SvcId = rs;
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
	var url = ContextPath + "/dispatch/mc/104050102?appId=" + AppId + "&appVnoId=" + AppVnoId + "&appImageId="+AppImageId;
	if(!CU.isEmpty(ParamPageNum)) url += "&pageNum="+ParamPageNum;
	window.location = url;
}

function nextForm() {
	submitForm(function() {
		var url = ContextPath + "/dispatch/mc/104050104?appId=" + AppId + "&appVnoId=" + AppVnoId + "&appImageId="+AppImageId;
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


