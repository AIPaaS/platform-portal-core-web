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
	if(CU.isFunction(cb))cb();
	
}
function initComponent() {
}
function initListener() {
	$("#form_appAccess").submit(function(e){
	    e.preventDefault();
	    submitForm();
	});
	RS.setAjaxLodingButton("btn_submit");
}
function initFace() {
}


function queryInfo(callback) {
	RS.ajax({url:"/app/access/queryById",ps:{id:CurrentId},cb:function(rs) {
		if(CU.isEmpty(rs)) {
			alert("没有找到应用["+CurrentId+"]");
			window.location = ContextPath + "/dispatch/mc/10411";
		}else {
			PU.setFormData(rs, "form_appAccess");
			$("#accessCode").val(rs.access.accessCode);
			$("#protocol").val(rs.access.protocol);
			$("#accessUrl").val(rs.access.accessUrl);
			$("#remark").val(rs.access.remark);
			
			RS.ajax({url:"/app/access/queryAppImageInfoList",ps:{appId:rs.access.appId,appImgId:rs.access.appImageId},cb:function(result) {
				var html = [];
				if(!CU.isEmpty(result)){
					for(var i=0;i<result.length;i++){
						html.push("<option value=\""+result[i].appImage.id+"\">"+result[i].appImage.containerName+"</option>");
					}
				}
				$("#appImgId").html(html.join(""));
				$("#appImgId").val(rs.access.appImageId);
			}});
			
		}
	}});
}



function submitForm() {	
	var bean = PU.getFormData("form_appAccess");
	if(!CU.isEmpty(CurrentId)) bean.id = CurrentId;
	
	var ps = {accessCode:bean.accessCode,appImageId:bean.appImgId,protocol:bean.protocol,remark:bean.remark};
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
