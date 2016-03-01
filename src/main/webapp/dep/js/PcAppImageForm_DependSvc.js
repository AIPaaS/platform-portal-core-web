

var AppId = "";

var AppImageId = "";
var AppVnoId = "";
var ParamPageNum = 1;

var BTN_TYPE = 1;	//-1=prev 0=save 1=next
var GridAddId = 1;

var ImagesList = [];
var ServiceList = [];
var ServiceMap = {};

var SelectImageIds = [];


/** 初始化 **/
function init() {
	setPageHeaderSetupNum(3);
	initData(function() {
		initComponent();
		initListener();
		initFace();
		queryInfo(function() {
			createAppImagesSelector();
			createServiceSelector();
		});
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
	
	RS.ajax({url:"/dep/appimage/queryAppImageDependsSelectData",ps:{appId:AppId,appVnoId:AppVnoId,appImageId:AppImageId},cb:function(rs) {
		ImagesList = rs.imgs;
		ServiceList = rs.svcs;
		for(var i=0; i<ServiceList.length; i++) {
			ServiceMap["SVC_"+ServiceList[i].svc.id] = ServiceList[i];
		}
		if(CU.isFunction(cb)) cb();
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
	$("#btn_prev").bind("click", function(){BTN_TYPE=-1;});
	$("#btn_save").bind("click", function() {BTN_TYPE=0;});
	$("#btn_next").bind("click", function(){BTN_TYPE=1;});
	$("#form_dependSvc").submit(function(e){
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


function createAppImagesSelector() {
	$("#btn_select_imgs").editable({
		display:false,
		showbuttons: "bottom",
        source: getSelectAppImageSource,
        value: getSelectAppImageInitValue(),
		url: setSelectAppImageValue2Input
	});
}


function getSelectAppImageSource() {
	var ss = [];
	var ls = ImagesList;
	for(var i=0;i<ls.length;i++){
		var value = ls[i].id+"|"+ls[i].containerName;
		var text = ls[i].containerName;
		ss.push({value:value,text:text});
	}
	return ss;
}
function getSelectAppImageInitValue() {
	var arr = [];
	for(var i=0; i<SelectImageIds.length; i++) {
		for(var j=0; j<ImagesList.length; j++) {
			var img = ImagesList[j];
			if(img.id == SelectImageIds[i]) {
				arr.push(img.id+"|"+img.containerName);
				break;
			}
		}
	}
	return arr;
}
function setSelectAppImageValue2Input(pps) {
	$("#imageIds").val("");
	delete SelectImageIds;
	SelectImageIds = [];
	var arr = pps.value;
	
	if(!CU.isEmpty(arr)) {
		var v = [];
		for(var i=0; i<arr.length; i++) {
			v.push(arr[i].substring(arr[i].lastIndexOf('|')+1));
			SelectImageIds.push(arr[i].substring(0,arr[i].lastIndexOf('|')));
		}
		$("#imageIds").val(v.join(","));
	}
}







function createServiceSelector() {
	$("#a_select_svc").editable({
		display:false,
		showbuttons: "bottom",
        source: getSelectServiceSource,
		url: setSelectService
	});
}


function getSelectServiceSource() {
	var exists = [];
	var trs = $("#serviceTable").find("tr");
	for(var i=0; i<trs.length; i++) {
		var trid = $(trs[i]).prop("id");
		var svcid = trid.substring(trid.lastIndexOf("_")+1);
		exists.push(svcid);
	}
	
	var ss = [];
	for(var i=0; i<ServiceList.length; i++) {
		var svc = ServiceList[i].svc;
		if(exists.indexOf(""+svc.id) > -1) {
			continue ;
		}
		
		var text = "["+svc.svcCode+"] " + svc.svcName + " - ["+PU.getDropValue("V_PC_SERVICE_SVC_TYPE", svc.svcType, false)+"]";
		ss.push({value:svc.id,text:text});
	}
	return ss;
}


function setSelectService(pps) {
	var svcIds = pps.value;
	if(CU.isEmpty(svcIds)) return ;
	
	for(var i=0; i<svcIds.length; i++) {
		var svcinfo = ServiceMap["SVC_"+svcIds[i]];
		var svc = svcinfo.svc;
		var params = svcinfo.params;
		addServiceTableRow(svc, params);
	}
}




function addServiceTableRow(svc, params, callType) {
	GridAddId ++ ;
	var trid = "tr_add_" + GridAddId + "_" + svc.svcType + "_" + svc.id;
	var tr = $("<tr id='"+trid+"'></tr>");
	var a = $("<a href=\"###\" class=\"table-link  danger\" title=\"删除参数\">"
			+ "<span class=\"fa-stack\">"
			+ "<i class=\"fa fa-square fa-stack-2x\"></i>"
			+ "<i class=\"fa fa-minus fa-stack-1x fa-inverse\"></i>"
			+ "</span>"
			+ "</a>");
	
	var pslength = CU.isEmpty(params) ? 0 : params.length;
	
	tr.append($("<td class=\"text-center\" valign=\"top\" title=\""+PU.getDropValue("V_PC_SERVICE_SVC_TYPE", svc.svcType, false)+"\">["+svc.svcCode+"] "+svc.svcName+"</td>"));
	tr.append($("<td class=\"text-center\" valign=\"top\" style=\"width:100px;\"><select class=\"form-control\" style=\"width:100px;\"><option value='1'>调用</option><option value='2'>依赖</option></select></td>"));
	
	var td1 = $("<td class=\"text-center\"></td>");
	var td2 = $("<td class=\"text-center\"></td>");
	var td3 = $("<td class=\"text-center\"></td>");
	var td4 = $("<td class=\"text-center\"></td>");
	
	tr.append(td1);
	tr.append(td2);
	tr.append(td3);
	tr.append(td4);
	
	for(var i=0; i<pslength; i++) {
		if(i > 0) {
			td1.append("<br>");
			td2.append("<br>");
			td3.append("<br>");
			td4.append("<br>");
		}
		
		var key = params[i].kvKey;
		var keyDesc = params[i].keyDesc;
		var keyAlias = params[i].keyAlias;
		var value = params[i].kvVal;
		if(CU.isEmpty(keyAlias)) keyAlias = key;
		if(CU.isEmpty(keyDesc)) keyDesc = "";
		if(CU.isEmpty(value)) value = "";
		
		td1.append("<input type=\"text\" class=\"form-control\" id=\"param_key_"+i+"_"+svc.id+"\" name=\"param_key\" value=\""+key+"\" maxlength=\"50\" readOnly/>");
		td2.append("<input type=\"text\" class=\"form-control\" id=\"param_keyDesc_"+i+"_"+svc.id+"\" name=\"param_keyDesc\" value=\""+keyDesc+"\" maxlength=\"20\" readOnly/>");
		td3.append("<input type=\"text\" class=\"form-control\" id=\"param_keyAlias_"+i+"_"+svc.id+"\" name=\"param_keyAlias\" value=\""+keyAlias+"\" maxlength=\"50\" />");
		td4.append("<input type=\"text\" class=\"form-control\" id=\"param_value_"+i+"_"+svc.id+"\" name=\"param_value\" value=\""+value+"\" maxlength=\"300\" />");
	}
	
	tr.append($("<td class=\"text-center\" valign=\"top\"></td>").append(a));
	a.bind("click", function() {removeServiceTableRow(trid);});
	$("#serviceTable").append(tr);
}

function removeServiceTableRow(elId){
	$("#"+elId).remove();
}




function queryInfo(cb){
	RS.ajax({url:"/dep/appimage/getAppImageDepends",ps:{appImageId:AppImageId},cb:function(rs) {
		if(!CU.isEmpty(rs.dependImages)) {
			var imgnames = [];
			for(var i=0; i<rs.dependImages.length; i++) {
				SelectImageIds.push(rs.dependImages[i].id);
				imgnames.push(rs.dependImages[i].containerName);
			}
			$("#imageIds").val(imgnames.join(","));
		}
		
		if(!CU.isEmpty(rs.dependSvcs)) {
			for(var i=0; i<rs.dependSvcs.length; i++) {
				var info = rs.dependSvcs[i];
				addServiceTableRow(info.svc, info.params, info.appImgSvc.callType);
			}
		}
		
		if(CU.isFunction(cb)) cb(rs);
	}});
}





/**提交表单**/
function submitForm(cb) {
	var svcIds = [];
	var svcTypes = [];
	var callTypes = [];
	var svcpsmap = {};		//key=SVC_+svcId, value=params
	
	var trs = $("#serviceTable").find("tr");
	for(var i=0; i<trs.length; i++) {
		var trid = $(trs[i]).prop("id");
		var svcid = trid.substring(trid.lastIndexOf("_")+1);
		var s = trid.substring(0, trid.lastIndexOf("_"));
		var svctype = s.substring(s.lastIndexOf("_")+1);
		var calltype = $($(trs[i]).find("select")[0]).val();
		
		svcIds.push(svcid);
		svcTypes.push(svctype);
		callTypes.push(calltype);		
	}
	
	if(svcIds.length > 0) {
		var aliases = [];
		var param_keys = $("input[name='param_key']");
		var param_keyDesc = $("input[name='param_keyDesc']");
		var param_keyAlias = $("input[name='param_keyAlias']");
		var param_value = $("input[name='param_value']");
		
		for(var i=0;i<param_keys.length;i++){
			var alias = $.trim($(param_keyAlias[i]).val());
			if(alias.length == 0) {
				CC.showMsg({msg:"第["+(i+1)+"]行，参数别名不可以为空!!"});
	    		return;
			}
			if(aliases.indexOf(alias) > -1) {
	 			CC.showMsg({msg:"参数别名<font color='blue'>["+alias+"]</font>不可以重复!"});
	    		return;
	 		}
			aliases.push(alias);
			
			var ps = {kvKey:$.trim($(param_keys[i]).val()), keyDesc:$.trim($(param_keyDesc[i]).val()), keyAlias:alias, kvVal:$.trim($(param_value[i]).val())};
			
			var svcId = $.trim($(param_keys[i]).prop("id"));
			svcId = svcId.substring(svcId.lastIndexOf('_')+1);
			
			var svcps = svcpsmap["SVC_"+svcId];
			if(CU.isEmpty(svcps)) {
				svcps = [];
				svcpsmap["SVC_"+svcId] = svcps;
			}
			svcps.push(ps);
		}
	}	
	
	var rlts = [];
	for(var i=0; i<svcIds.length; i++) {
		var rlt = {svcId:svcIds[i], svcType:svcTypes[i], callType:callTypes[i]};
		var ps = svcpsmap["SVC_"+svcIds[i]];
		if(!CU.isEmpty(ps)) rlt.params = ps;
		rlts.push(rlt);
	}
	
	var ps = {appImageId:AppImageId};
	if(rlts.length > 0) ps.jsonRlts = CU.toString(rlts);
	if(!CU.isEmpty(SelectImageIds)) ps.strDependAppImageIds = SelectImageIds.join(",");
	
	RS.ajax({url:"/dep/appimage/saveAppImageDepends",ps:ps,cb:function(r) {
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
	var url = ContextPath + "/dispatch/mc/104050103?appId=" + AppId + "&appVnoId=" + AppVnoId + "&appImageId="+AppImageId;
	if(!CU.isEmpty(ParamPageNum)) url += "&pageNum="+ParamPageNum;
	window.location = url;
}

function nextForm() {
	submitForm(function() {
		var url = ContextPath + "/dispatch/mc/104050105?appId=" + AppId + "&appVnoId=" + AppVnoId + "&appImageId="+AppImageId;
		if(!CU.isEmpty(ParamPageNum)) url += "&pageNum="+ParamPageNum;
		window.location = url;
	});
}


function pageBack() {
	var url = ContextPath + "/dispatch/mc/1040501?1=1";
	if(!CU.isEmpty(AppId)) url += "&appId="+AppId;
	if(!CU.isEmpty(AppVnoId)) url += "&appVnoId="+AppVnoId;
	if(!CU.isEmpty(ParamPageNum)) url += "&pageNum="+ParamPageNum;
	window.location = url;
}


