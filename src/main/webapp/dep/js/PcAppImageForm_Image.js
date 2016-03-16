

var AppId = "";
var APP = null;

var AppImageId = "";
var AppVnoId = "";
var AppType = "";
var ParamPageNum = 1;

var BTN_TYPE = 1;	//-1=prev 0=save 1=next

var OldUseRes = {netZoneId:-1,cpuCount:0,memSize:0,diskSize:0};		//查询出的资源数
var NetZoneRes = {netZoneId:-1,cpuCount:0,memSize:0,diskSize:0};	//当前网络区域剩余资源
var ResidueRes = {netZoneId:-1,cpuCount:0,memSize:0,diskSize:0};	//计算之后剩余资源
var TargsList = [];



/** 初始化 **/
function init() {
	setPageHeaderSetupNum(1);
	initData(function() {
		initComponent();
		initListener();
		initFace();
		if(!CU.isEmpty(AppImageId)) {
			queryInfo(function(rs) {
				setTargsEditable(rs.targs);
			});
		}else {
			setTargsEditable();
		}
	});
}

/** 初始化页面、内存等基本数据 **/
function initData(cb) {
	AppId = PRQ.get("appId");
	AppImageId = PRQ.get("appImageId");
	AppVnoId = PRQ.get("appVnoId");
	ParamPageNum = PRQ.get("pageNum");
	if(CU.isEmpty(ParamPageNum)) ParamPageNum = 1;
	
	$("#imageId").html("");
	$("#netZoneId").html("");
	$("#div_isSupportFlex_yes").hide();
	
	if(CU.isEmpty(AppId) || CU.isEmpty(AppVnoId)) {
		alert("没有找到应用["+AppId+"]!");
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
		DROP["DV_IMAGE_CODE"] = rs.imageDropList;
		DROP["DV_NET_ZONE_CODE"] = rs.netZoneDropList;
		
		var imgselHtml = PU.getSelectOptionsHtml("DV_IMAGE_CODE");
		$("#imageId").html(imgselHtml);
		
		var ncselHtml = PU.getSelectOptionsHtml("DV_NET_ZONE_CODE");
		$("#netZoneId").html(ncselHtml);
		
		if(AppType == 1){
			$("#div_time").hide();
		}else{
			$("#div_time").show();
		}
		
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
	$('#maskedDate').datetimepicker({
//		minView: "month",
		format: "yyyy-mm-dd hh:ii:ss", 
		language: "zh-CN",
		autoclose:true
	});
	$("#netZoneId").bind("change", refreshCompTagsSource);
	$("#isSupportFlex").bind("change",function(){
		if($("#isSupportFlex").prop("checked")){
			$("#div_isSupportFlex_yes").show();
		}else{
			$("#flexThreshold").val("");
			$("#maxInstanceCount").val("");
			$("#minInstanceCount").val("");
			$("#div_isSupportFlex_yes").hide();
		}
	});
	$("#btn_save").bind("click", function() {BTN_TYPE=0;});
	$("#btn_next").bind("click", function(){BTN_TYPE=1;});
	$("#form_appImage").submit(function(e){
	    e.preventDefault();
	    switch(BTN_TYPE) {
	    	case 0: submitForm(); break;
	    	case 1: nextForm(); break;
	    }
	});
	
	$("#cpuCount").bind("keyup", refreshResidueRes);
	$("#memSize").bind("keyup", refreshResidueRes);
	$("#diskSize").bind("keyup", refreshResidueRes);
	
	RS.setAjaxLodingButton("btn_save");
}

/** 初始化界面 **/
function initFace() {
}


function setTargsEditable(targs) {
	$("#btn_select_targs").editable({
		display:false,
		showbuttons: "bottom",
        source: function() {
        	return TargsList;
        },
        value: inputValue2TargsValue(targs),
		url: function (pps) {
			return targsValue2InputValue(pps.value);
		}
	});
}

function refreshCompTagsSource(cb){
	delete TargsList;
	TargsList = [];
	NetZoneRes = {netZoneId:-1,cpuCount:0,memSize:0,diskSize:0};
	ResidueRes = {netZoneId:-1,cpuCount:0,memSize:0,diskSize:0};
	
	var netZoneId = $("#netZoneId").val();
	if(CU.isEmpty(netZoneId)) {
		refreshResidueRes();
		return ;
	}
	
	RS.ajax({url:"/dep/appimage/getNetZoneChangeData",ps:{appId:AppId,appVnoId:AppVnoId,netZoneId:netZoneId},cb:function(rs) {
		var ls = rs.targs;
		for(var i=0;i<ls.length;i++){
			var value = ls[i].tagName + "|" + ls[i].tagValue;
			var text = "["+ls[i].tagName+"="+ls[i].tagValue+"] "+(CU.isEmpty(ls[i].tagDesc)?"":ls[i].tagDesc);
			TargsList.push({value:value,text:text});
		}
		
		NetZoneRes = rs.res;
		NetZoneRes.netZoneId = ResidueRes.netZoneId = parseInt(netZoneId, 10);
		refreshResidueRes();
		
		if(CU.isFunction(cb))cb();
	}});
}

function targsValue2InputValue(targsValue) {
	var arr = targsValue;
	var v = "";
	if(!CU.isEmpty(arr)) {
		var kv = {};
		for(var i=0; i<arr.length; i++) {
			kv[arr[i].substring(0, arr[i].indexOf('|'))] = arr[i].substring(arr[i].indexOf('|')+1);
		}
		v = CU.toString(kv);
	}
	$("#targs").val(v);
	return v;
}
function inputValue2TargsValue(targs) {
	if(CU.isEmpty(targs)) return "";
	var bean = CU.toObject(targs);
	var arr = [];
	for(var key in bean) {
		arr.push(key+"|"+bean[key]);
	}
	return arr;
}


/** 刷新余额 **/
function refreshResidueRes() {
	ResidueRes.cpuCount = NetZoneRes.cpuCount;
	ResidueRes.memSize = NetZoneRes.memSize;
	ResidueRes.diskSize = NetZoneRes.diskSize;
	
	var cpuCount = $("#cpuCount").val();
	var memSize = $("#memSize").val();
	var diskSize = $("#diskSize").val();
	
	var reg1 = /^\d+(\.\d+)?$/;	//小数
	var reg2 = /^\d+$/;		//整数
		
	if(ResidueRes.netZoneId == OldUseRes.netZoneId) {
		ResidueRes.cpuCount += OldUseRes.cpuCount;
		ResidueRes.memSize += OldUseRes.memSize;
		ResidueRes.diskSize += OldUseRes.diskSize;
	}
	if(!CU.isEmpty(cpuCount)&&reg1.test(cpuCount)) ResidueRes.cpuCount -= parseInt(parseFloat(cpuCount)*100);
	if(!CU.isEmpty(memSize)&&reg2.test(memSize)) ResidueRes.memSize -= parseInt(memSize);
	if(!CU.isEmpty(diskSize)&&reg2.test(diskSize)) ResidueRes.diskSize -= parseInt(diskSize);
	
	$("#div_residue_cpuCount").html(ResidueRes.cpuCount/100);
	$("#div_residue_memSize").html(CU.toMegaByteUnit(ResidueRes.memSize));
	$("#div_residue_diskSize").html(CU.toMegaByteUnit(ResidueRes.diskSize));
}


function queryInfo(cb){
	RS.ajax({url:"/dep/appimage/queryAppImageById",ps:{appImageId:AppImageId},cb:function(rs) {
		if(CU.isEmpty(rs)) {
			alert("没有找到应用容器定义["+AppImageId+"]!");
			pageBack();
			return;
		}
		
		OldUseRes.netZoneId = rs.netZoneId;
		OldUseRes.cpuCount = rs.cpuCount;
		OldUseRes.memSize = rs.memSize;
		OldUseRes.diskSize = rs.diskSize;
	
		
		if(!CU.isEmpty(rs.cpuCount)) rs.cpuCount = rs.cpuCount/100;
		if(!CU.isEmpty(rs.cpuFlexUpperLimit)) rs.cpuFlexUpperLimit = rs.cpuFlexUpperLimit/100;
		if(!CU.isEmpty(rs.cpuFlexLowerLimit)) rs.cpuFlexLowerLimit = rs.cpuFlexLowerLimit/100;
		PU.setFormData(rs, "form_appImage");
		if(AppType == 2){
			var timerStartTime = rs.timerStartTime;
			$("#maskedDate").val(CU.toStringDateTime(timerStartTime));
			
			var timerExp = parseFloat(rs.timerExp);
			$("#timer1").val(mo(timerExp/3600));
			$("#timer2").val(mo(timerExp%3600/60));
			$("#timer3").val(timerExp%60);
		}
		
		var isSupportFlex = rs.isSupportFlex;
		if(isSupportFlex){
			$("#div_isSupportFlex_yes").show();
			$("#isSupportFlex").prop("checked",true);
		}else{
			$("#div_isSupportFlex_yes").hide();
			$("#isSupportFlex").prop("checked",false);
		}
		refreshCompTagsSource(function() {
			if(CU.isFunction(cb))cb(rs);
		});
	}});
}


function mo(f) {
	var s = f+"";
	if(s.indexOf('.')>0) {
		s = s.substring(0,s.indexOf('.'));
	}
	return parseInt(s, 10);
}


/**提交表单**/
function submitForm(cb){
	
	
	var bean = PU.getFormData("form_appImage");
	
	if(AppType == 2){
		var d = $("#maskedDate").val();
		d = d.replace(/-/g, "");
		d = d.replace(/ /g, "");
		d = d.replace(/:/g, "");
		bean.timerStartTime = d;
		
		var t1 = parseInt($("#timer1").val(),10);
		var t2 = parseInt($("#timer2").val(),10);
		var t3 = parseInt($("#timer3").val(),10);
		var timerExp = t1*3600+t2*60+t3;
		
		bean.timerExp = timerExp;
		bean.timerType = 1;
	}else{
		delete bean.timerStratTime;
		delete bean.timerExp;
	}
	
	bean.isSupportFlex = $("#isSupportFlex").prop("checked") ? 1 : 0;
	if(!bean.isSupportFlex){
		delete bean.cpuFlexUpperLimit;
		delete bean.cpuFlexLowerLimit;
		delete bean.maxInstanceCount;
		delete bean.minInstanceCount;
	}else {
		var cpuFlexUpperLimit = $("#cpuFlexUpperLimit").val();
		var cpuFlexLowerLimit = $("#cpuFlexLowerLimit").val();
		var maxInstanceCount = $("#maxInstanceCount").val();
		var minInstanceCount = $("#minInstanceCount").val();
		if(CU.isEmpty(cpuFlexUpperLimit)){CC.showMsg({msg:"容器伸缩CPU上限不能为空"}); return;}
		if(CU.isEmpty(cpuFlexLowerLimit)){CC.showMsg({msg:"容器伸缩CPU下限不能为空"}); return;}
		if(CU.isEmpty(maxInstanceCount)){CC.showMsg({msg:"最大实例数量不能为空"}); return;}
		if(CU.isEmpty(minInstanceCount)){CC.showMsg({msg:"最小实例数量不能为空"}); return;}
		if(parseInt(parseFloat(bean.cpuFlexUpperLimit)*100, 10)<=parseInt(parseFloat(bean.cpuFlexLowerLimit)*100, 10)){
			CC.showMsg({msg:"容器伸缩CPU上限不能小于下限"}); return;
		}
		bean.cpuFlexUpperLimit = parseInt(parseFloat(bean.cpuFlexUpperLimit)*100, 10);
		bean.cpuFlexLowerLimit = parseInt(parseFloat(bean.cpuFlexLowerLimit)*100, 10);
	}
		
	bean.cpuCount = parseInt(parseFloat(bean.cpuCount)*100, 10);
	if(bean.cpuCount==0) {CC.showMsg({msg:"CPU个数不可以为0"}); return;}
	if(bean.memSize==0) {CC.showMsg({msg:"内存大小不可以为0"}); return;}
	if(bean.instanceCount==0) {CC.showMsg({msg:"容器数不可以为0"}); return;}
	if(ResidueRes.cpuCount < 0) {CC.showMsg({msg:"当前网络区域<font color='red'>CPU</font>资源<font color='red'>不充足</font>，请调整CPU大小!"}); return;}
	if(ResidueRes.memSize < 0) {CC.showMsg({msg:"当前网络区域<font color='red'>内存</font>资源<font color='red'>不充足</font>，请调整内存大小!"}); return;}
	if(ResidueRes.diskSize < 0) {CC.showMsg({msg:"当前网络区域<font color='red'>存储</font>资源<font color='red'>不充足</font>，请调整存储大小!"}); return;}
	if(CU.isEmpty(ResidueRes.diskSize)) ResidueRes.diskSize = 0;
	bean.appId = AppId;
	bean.appVnoId = AppVnoId;
	if(!CU.isEmpty(AppImageId)) bean.id = AppImageId;
	
	RS.ajax({url:"/dep/appimage/saveAppImage",ps:bean,cb:function(rs) {
		AppImageId = rs;
		$("#btn_save").prop("title", "保存成功");
		$("#btn_save").tooltip("show");
		setTimeout(function(){
			$("#btn_save").prop("title", "");
			$("#btn_save").tooltip("destroy");
		}, 2000);
		
		if(CU.isFunction(cb))cb(); 
	}});
}






function nextForm() {
	submitForm(function() {
		var url = ContextPath + "/dispatch/mc/104050103?appId=" + AppId + "&appVnoId=" + AppVnoId + "&appImageId="+AppImageId + "&appType=" + AppType;
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


