var APP = null;

var CurrentId = "";
var ParamPageNum = 1;


/** 初始化 **/
function init() {
	initData(function() {
		initComponent();
		initListener();
		initFace();
		if(!CU.isEmpty(CurrentId)) {
			queryInfo();
		}
	});
}

/** 初始化页面、内存等基本数据 **/
function initData(cb) {
	CurrentId = PRQ.get("id");
	CurrentPageNum = PRQ.get("pageNum");
	if(CU.isEmpty(ParamPageNum)) ParamPageNum = 1;
	
	
	var AppId = PRQ.get("appId");
	if(CU.isEmpty(AppId)) {
		alert("参数应用ID为空!");
		forwardBack();
		return ;
	}
	
	RS.ajax({url:"/dep/app/queryMgrList",ps:{id:AppId},cb:function(rs) {
		if(CU.isEmpty(rs)) {
			alert("应用["+AppId+"]没找到或您没有当前权限!");
			forwardBack();
			return ;
		}
		
		APP = rs[0];
		
		RS.ajax({url:"/res/res/getResRegionDropListMap",ps:{addEmpty:true, addAttr:true, opts:"dc|rc|nc"},cb:function(result) {
			DROP["DV_DATA_CENTER_CODE"] = result["dc"];
			DROP["DV_RES_CENTER_CODE"] = result["rc"];
			var ncls = result["nc"];
			var currncls = [ncls[0]];
			for(var i=1; i<ncls.length; i++) {
				if(ncls[i].attributes.resCenterId == APP.resCenterId) {
					currncls.push(ncls[i]);
				}
			}
			DROP["DV_NET_ZONE_CODE"] = currncls;
			
			var ncselhtml = PU.getSelectOptionsHtml("DV_NET_ZONE_CODE");
			$("#netZoneId").html(ncselhtml);
			
			var dc = CU.getDropItemRecord("DV_DATA_CENTER_CODE", APP.dataCenterId);
			var rc = CU.getDropItemRecord("DV_RES_CENTER_CODE", APP.resCenterId);
			
			var html = "应用 [<font color='blue'>"+APP.appCode+"</font>] [<font color='blue'>"+APP.appName+"</font>]"
						+ "在&nbsp;[<font color='#008800'>"+dc.attributes.name+"</font>]"
						+ "&nbsp;-&nbsp;[<font color='#008800'>"+rc.attributes.resName+"</font>] 资源申请";
			
			$("#div_head_title").html(html);
			
			if(CU.isFunction(cb))cb();
		}});
	}});
}

/** 初始化组件 **/
function initComponent() {

	
}

/** 对组件设置监听 **/
function initListener() {
	$("#formResApply").submit(function(e){
	    e.preventDefault();
	    submitForm();
	});
	RS.setAjaxLodingButton("btn_submit");
}

/** 初始化界面 **/
function initFace() {
}


function queryInfo(){
	RS.ajax({url:"/res/appres/queryApplyById",ps:{applyId:CurrentId},cb:function(rs) {
		if(!CU.isEmpty(rs.cpuCount)) rs.cpuCount = rs.cpuCount/100;
		if(!CU.isEmpty(rs.memSize)) rs.memSize = rs.memSize;
		if(!CU.isEmpty(rs.diskSize)) rs.diskSize = rs.diskSize/1024;
		PU.setFormData(rs, "formResApply");
	}});
}

/**提交表单**/
function submitForm(){
	var bean = PU.getFormData("formResApply");
	bean.cpuCount = parseInt(parseFloat(bean.cpuCount)*100, 10);
	bean.memSize = parseInt(bean.memSize, 10);
	if(CU.isEmpty(bean.diskSize)) bean.diskSize = 0;
	bean.diskSize = parseInt(bean.diskSize, 10)*1024;
	
	bean.appId = APP.id;
	bean.dataCenterId = APP.dataCenterId;
	bean.resCenterId = APP.resCenterId;
	
	if(!CU.isEmpty(CurrentId)) bean.id = CurrentId;
	
	RS.ajax({url:"/res/appres/saveOrUpdateApply",ps:bean,cb:function(rs) {
		CurrentId = rs;
		forwardBack();
	}});
}



function forwardBack() {
	var url = ContextPath + "/dispatch/mc/1040201?appId="+APP.id;
	if(!CU.isEmpty(ParamPageNum)) url += "&pageNum="+ParamPageNum;
	window.location = url;
}

