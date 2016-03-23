

var AppId = "";
var AppImageId = "";
var AppVnoId = "";
var ParamPageNum = 1;



/** 初始化 **/
function init() {
	setPageHeaderSetupNum(5);
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
	
	RS.ajax({url:"/res/res/getResRegionDropListMap",ps:{addEmpty:true, addAttr:true,opts:"nc"},cb:function(result) {
		DROP["DV_NET_ZONE_CODE"] = result["nc"];
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
	$("#btn_prev").bind("click", prevForm);
	$("#btn_save").bind("click", submitForm);
	RS.setAjaxLodingButton("btn_save");
}

/** 初始化界面 **/
function initFace() {
}



function getImageName(img) {
	if(CU.isEmpty(img)) return "";
	return img.imageFullName;
}

function getAutoFlex(appimg) {
	if(appimg.isSupportFlex == 1) {
		return "<font color='red'>CPU:"+appimg.cpuFlexLowerLimit+"~"+appimg.cpuFlexUpperLimit+"%</font>&nbsp;&nbsp;<font color='blue'>"+appimg.minInstanceCount+"~"+appimg.maxInstanceCount+"</font>";
	}else {
		return "否";
	}
}
function getDependImagesName(imgs) {
	if(CU.isEmpty(imgs)) return "";
	var names = [];
	for(var i=0; i<imgs.length; i++) {
		names.push(imgs[i].containerName);
	}
	return names.join("，");
}



function queryInfo(cb){
	RS.ajax({url:"/dep/appimage/getAppImageSettings",ps:{appImageId:AppImageId},cb:function(rs) {
		if(!CU.isEmpty(rs)) {
			rs.Param_AppId = AppId;
			rs.Param_AppImageId = AppImageId;
			rs.Param_PageNum = ParamPageNum;
			$("#div_settings-tmpl").tmpl({data:rs}).appendTo("#div_settings");
		}
	}});
}



/**提交表单**/
function submitForm(cb) {
	CC.showMsg({msg:"您确定要完成配置吗?",option:2,callback:function(r) {
		if(r != "ok") return ;
		
		setTimeout(function() {
			RS.ajax({url:"/dep/appimage/finishAppImageSettings",ps:{appImageId:AppImageId},cb:function() {
				forwardDetail();
			}});
		}, 500);
	}});
}




function prevForm(){
	var url = ContextPath + "/dispatch/mc/104050105?appId=" + AppId + "&appVnoId=" + AppVnoId + "&appImageId="+AppImageId;
	if(!CU.isEmpty(ParamPageNum)) url += "&pageNum="+ParamPageNum;
	window.location = url;
}

function pageBack() {
	var url = ContextPath + "/dispatch/mc/1040501?1=1&appImageId="+AppImageId;
	if(!CU.isEmpty(AppId)) url += "&appId="+AppId;
	if(!CU.isEmpty(AppVnoId)) url += "&appVnoId="+AppVnoId;
	if(!CU.isEmpty(ParamPageNum)) url += "&pageNum="+ParamPageNum;
	window.location = url;
}

function forwardDetail() {
	var url = ContextPath + "/dispatch/mc/1040501?appId=" + AppId + "&appVnoId=" + AppVnoId;
	if(!CU.isEmpty(ParamPageNum)) url += "&pageNum="+ParamPageNum;
	window.location = url;
}


function mo(f) {
	var s = f+"";
	if(s.indexOf('.')>0) {
		s = s.substring(0,s.indexOf('.'));
	}
	return parseInt(s, 10);
}
function timeExp(exp){
	var timerExp = parseFloat(exp);
	var h = mo(timerExp/3600);
	var m = mo(timerExp%3600/60);
	var s = (timerExp%60);
	return h+"时"+m+"分"+s+"秒";
}

