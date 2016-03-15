var CurrentId = "";

var GridAddId = 1;


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


function initData(cb) {
	CurrentId = PRQ.get("id");
	var selhtml = PU.getSelectOptionsHtml("V_PC_SERVICE_PROTOCOL");
	$("#protocol").html(selhtml);
	
	
}
function initComponent() {
}
function initListener() {
//	$("#a_add_param").bind("click",function(){addParamRow();});
	$("#dataCenterId").bind("change",function() {
		var dcId = $("#dataCenterId").val();
		reloadResCenterId(dcId);
	});
	
	$("#form_appAccessSvc").submit(function(e){
	    e.preventDefault();
	    submitForm();
	});
	RS.setAjaxLodingButton("btn_submit");
}
function initFace() {
}

function reloadResCenterId(dcId,cb){
	$("#resCenterId").html("");
	if(!CU.isEmpty(dcId)) {
		var rs = DROP["DV_RES_CENTER_CODE"];
		var ls = [rs[0]];
		for(var i=1; i<rs.length; i++) {
			if(rs[i].attributes.dataCenterId == dcId) {
				ls.push(rs[i]);
			}
		}
		$("#resCenterId").html(getSelOpHtml(ls));
		if(CU.isFunction(cb)) cb();
	}
}

function getSelOpHtml(ls){
	var html = [];
	if(!CU.isEmpty(ls)){
		for(var i=0;i<ls.length;i++){
			html.push("<option value=\""+ls[i].code+"\">"+ls[i].name+"</option>");
		}
	}
	return html.join("");
}

function queryInfo(callback) {
	RS.ajax({url:"/app/access/queryById",ps:{id:CurrentId},cb:function(rs) {
		if(CU.isEmpty(rs)) {
			alert("没有找到应用["+CurrentId+"]");
			window.location = ContextPath + "/dispatch/mc/10411";
		}else {
			PU.setFormData(rs, "form_appAccessSvc");
			$("#accessCode").val(rs.access.accessCode);
			$("#protocol").val(rs.access.protocol);
			$("#accessUrl").val(rs.access.accessUrl);
			$("#remark").val(rs.access.remark);
			
			RS.ajax({url:"/dep/appimage/queryAppImageInfoList",ps:{appId:rs.access.appId},cb:function(result) {
//				$("#imgName").val(result.appImage.image);
				var dcselhtml = PU.getSelectOptionsHtml("DV_DATA_CENTER_CODE");
				$("#imgName").html(dcselhtml);
				if(CU.isFunction(cb)) cb();
			}});
		}
	}});
}



function submitForm() {	
	var bean = PU.getFormData("form_appAccessSvc");
	if(!CU.isEmpty(CurrentId)) bean.id = CurrentId;
	
	var paramsStr =  getTableParams();
	if(paramsStr === false) return;
	
	var ps = {custom4:bean.custom4,appName:bean.appName,accessCode:bean.accessCode,dataCenterId:bean.dataCenterId,resCenterId:bean.resCenterId,protocol:bean.protocol,accessUrl:bean.accessUrl,port:bean.port,remark:bean.remark};
	if(!CU.isEmpty(CurrentId)){
		ps.id = CurrentId;
	}
	RS.ajax({url:"/app/access/saveOrUpdate",ps:ps,cb:function(rs) {
		CurrentId = rs;
		window.location = ContextPath + "/dispatch/mc/10411";
	}});	
}


function removeTag(elId){
	$("#"+elId).remove();
}
