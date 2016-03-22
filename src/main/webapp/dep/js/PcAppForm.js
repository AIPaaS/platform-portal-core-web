var CurrentId = "";
var PageNum = "";

var MgrOpIds = null;

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
	PageNum = PRQ.get("pageNum");
	if(CU.isEmpty(CurrentId)) CurrentId = "";
	RS.ajax({url:"/res/res/getResRegionDropListMap",ps:{addEmpty:true, addAttr:true,opts:"dc|rc"},cb:function(result) {
		DROP["DV_DATA_CENTER_CODE"] = result["dc"];
		DROP["DV_RES_CENTER_CODE"] = result["rc"];
		var dcSelHtml = PU.getSelectOptionsHtml("DV_DATA_CENTER_CODE");
		$("#dataCenterId").html(dcSelHtml);
		if(CU.isFunction(cb))cb();
	}});
}

/** 初始化组件 **/
function initComponent() {
	userSelor = new UserSelector({callback:function(ops) {
		setMgrNameFields(ops);
	}});
}

/** 对组件设置监听 **/
function initListener() {
	$("#dataCenterId").bind("change",function() {
		var dcId = $("#dataCenterId").val();
		reloadResCenterId(dcId);
	});
	$("#btn_select_mgr").bind("click",showSelectMgrs);
	$("#form_app").submit(function(e){
	    e.preventDefault();
	    submitForm();
	});
	RS.setAjaxLodingButton("btn_submit");
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
/** 初始化界面 **/
function initFace() {
	
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


function queryInfo(){
	RS.ajax({url:"/dep/app/queryInfoById",ps:{id:CurrentId},cb:function(rs) {
		PU.setFormData(rs.app, "form_app");
		var dcId = rs.app.dataCenterId;
		reloadResCenterId(dcId,function(){
			$("#resCenterId").val(rs.app.resCenterId);
		});
		setMgrNameFields(rs.mgrOps);
	}});
}

function setMgrNameFields(arr) {
	var val = "";
	MgrOpIds = [];
	for(var i=0; i<arr.length; i++) {
		var id = arr[i].id;
		var name = arr[i].opName;
		if(CU.isEmpty(id)) id = arr[i].code;
		if(CU.isEmpty(name)) name = arr[i].name;
		if(i > 0) val += "，";
		val += name;
		MgrOpIds.push(id);
	}
	$("#mgrIds").val(val);
}


function showSelectMgrs(){
	userSelor.show(MgrOpIds);
}




/**提交表单**/
function submitForm(){
	var bean = PU.getFormData("form_app");
	if(CU.isEmpty(MgrOpIds)) {
		CC.showMsg({msg:"请选择应用管理员!"});
		return ;
	}
	bean.strMgrIds = MgrOpIds.join(",");
	if(!CU.isEmpty(CurrentId)) bean.id = CurrentId;
	
	RS.ajax({url:"/dep/app/saveOrUpdate",ps:bean,cb:function(rs) {
		var code = $("#appCode").val();
		if(rs =="errMsg: call remote service 'PcAppSvc.saveOrUpdate()' error! 1"){
			CC.showMsg({msg:"代码为"+code+"的应用已存在，请修改!"});
		}
		else {
			if(rs =="errMsg: call remote service 'PcAppSvc.saveOrUpdate()' error! 2"){
				CC.showMsg({msg:"应用不存在!"});
			}
			else {
				if(rs =="errMsg: call remote service 'PcAppSvc.saveOrUpdate()' error! 3"){
					CC.showMsg({msg:"不能修改!"});
				}
				else if(rs =="errMsg: call remote service 'PcAppSvc.saveOrUpdate()' error! 3"){
					CC.showMsg({msg:"版本已存在!"});
				}
				else{
					CurrentId = rs;
					var url = ContextPath+"/dispatch/mc/10401";
					if(!CU.isEmpty(PageNum)) url += "?pageNum="+PageNum;
					window.location = url;
				}}}}});
		
}



