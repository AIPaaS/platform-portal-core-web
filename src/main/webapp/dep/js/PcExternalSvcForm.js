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
	RS.ajax({url:"/res/res/getResRegionDropListMap",ps:{addEmpty:true, addAttr:true ,opts:"dc|rc"},cb:function(result) {
		DROP["DV_DATA_CENTER_CODE"] = result["dc"];
		DROP["DV_RES_CENTER_CODE"] = result["rc"];
		var dcselhtml = PU.getSelectOptionsHtml("DV_DATA_CENTER_CODE");
		$("#dataCenterId").html(dcselhtml);
		if(CU.isFunction(cb)) cb();
	}});
}
function initComponent() {
}
function initListener() {
	$("#a_add_param").bind("click",function(){addParamRow();});
	$("#dataCenterId").bind("change",function() {
		var dcId = $("#dataCenterId").val();
		reloadResCenterId(dcId);
	});
	
	$("#form_externalSvc").submit(function(e){
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
	RS.ajax({url:"/external/service/queryById",ps:{id:CurrentId},cb:function(rs) {
		if(CU.isEmpty(rs)) {
			alert("没有找到服务["+CurrentId+"]");
			window.location = ContextPath + "/dispatch/mc/10404";
		}else {
			RS.ajax({url:"/external/service/queryParams",ps:{svcId:CurrentId, orders:"ID"},cb:function(r) {
				PU.setFormData(rs, "form_externalSvc");
				var dataCenterId = rs.dataCenterId;
				$("#dataCenterId").val(rs.dataCenterId);
				reloadResCenterId(dataCenterId,function(){
					$("#resCenterId").val(rs.resCenterId);
				});
				
				for(var i=0;i<r.length;i++){
					addParamRow(r[i]);
				}
			}});
		}
	}});
}

function getTableParams(){
	var params = [];
	var keys = [];
	
	var param_keys = $("input[name='param_key']");
	var param_descs = $("input[name='param_desc']");
	for(var i=0;i<param_keys.length;i++){
		var v = $.trim($(param_keys[i]).val());
		var desc = $.trim($(param_descs[i]).val());
		if(v.length == 0){
			CC.showMsg({msg:"第["+(i+1)+"]行，参数名不可以为空!"});
			return false ;
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



function submitForm() {	
	var bean = PU.getFormData("form_externalSvc");
	if(!CU.isEmpty(CurrentId)) bean.id = CurrentId;
	
	var paramsStr =  getTableParams();
	if(paramsStr === false) return;
	
	var ps = {custom4:bean.custom4,svcCode:bean.svcCode,svcName:bean.svcName,dataCenterId:bean.dataCenterId,resCenterId:bean.resCenterId,protocol:bean.protocol,ip:bean.ip,port:bean.port,svcUrl:bean.svcUrl,paramsStr:paramsStr};
	if(!CU.isEmpty(CurrentId)){
		ps.id = CurrentId;
	}
	RS.ajax({url:"/external/service/saveOrUpdate",ps:ps,cb:function(rs) {
		CurrentId = rs;
		window.location = ContextPath + "/dispatch/mc/10404";
	}});	
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

function removeTag(elId){
	$("#"+elId).remove();
}
