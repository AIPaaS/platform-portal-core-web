
var APP = null;

var CurrDataMap = {};
var ParamPageNum = 1;

var CurrentCheckMnt = null;


function init() {
	initData(function() {
		initComponent();
		initListener();
		initFace();
		query();
	});
	
}


function initData(cb) {
	ParamPageNum = PRQ.get("pageNum");
	if(CU.isEmpty(ParamPageNum)) ParamPageNum = 1;
	
	var AppId = PRQ.get("appId");
	if(CU.isEmpty(AppId)) {
		alert("参数应用ID为空!");
		forwardBack();
		return ;
	}
	
	var statusselhtml = PU.getSelectOptionsHtml("V_PS_RES_APPLY_CHECK_STATUS");
	$("#cdtStatus").html(statusselhtml);
	
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
			DROP["DV_NET_ZONE_CODE"] = result["nc"];
			
			var dc = CU.getDropItemRecord("DV_DATA_CENTER_CODE", APP.dataCenterId);
			var rc = CU.getDropItemRecord("DV_RES_CENTER_CODE", APP.resCenterId);
			
			var html = "应用 [<font color='blue'>"+APP.appCode+"</font>] [<font color='blue'>"+APP.appName+"</font>]"
						+ "&nbsp;在[<font color='#008800'>"+dc.attributes.name+"</font>]"
						+ "&nbsp;-&nbsp;[<font color='#008800'>"+rc.attributes.resName+"</font>] 资源申请记录";
			
			$("#div_head_title").html(html);
			
			if(CU.isFunction(cb))cb();
		}});
	}});
}
function initComponent() {
}
function initListener() {
	$("#cdtAppCode").bind("keyup", doCdtTFKeyUp);
	$("#cdtAppName").bind("keyup", doCdtTFKeyUp);
	$("#cdtStatus").bind("change", function(){query();});
	
	$("#btn_query").bind("click",function(){query();});
	$("#grid_pageSize").bind("change",function(){query();});
	
	$("#btn_addApply").bind("click", function() {forwardApplyForm();});
}
function initFace() {
}


/** 执行条件文本框回车查询 **/
function doCdtTFKeyUp(e) {
	if(e.keyCode === 13) query(1);
}





function query(pageNum){
	if(CU.isEmpty(pageNum)) pageNum = 1;
	
	delete CurrDataMap;
	CurrDataMap = {};
	$("#tabList").html("");
	$("#ul_pagination").remove();
	$("#pagination_box").html('<ul id="ul_pagination" class="pagination-sm"></ul>');
	
	var pageSize = $("#grid_pageSize").val();
	var applyTime = $("#cdtApplyTime").val();
	var status = $("#cdtStatus").val();
	var orders = " ID DESC ";
	
	var cdt = {appId:APP.id,pageNum:pageNum,pageSize:pageSize,orders:orders};
	if(!CU.isEmpty(status)) cdt.status = status;
	if(!CU.isEmpty(applyTime)) {
		applyTime = applyTime.replace(/-/g, "");
		cdt.startApplyTime = applyTime + "000000";
		cdt.endApplyTime = applyTime + "235959";
	}
	
	RS.ajax({url:"/res/appres/queryApplyPage",ps:cdt,cb:function(r) {
		if(!CU.isEmpty(r)){
			var data = r.data;
			for(var i=0; i<data.length; i++) {
				CurrDataMap["key_"+data[i].id] = data[i];
			}
			ParamPageNum = r.pageNum;
			
			$("#ul_pagination").twbsPagination({
		        totalPages: r.totalPages?r.totalPages:1,
		        visiblePages: 7,
		        startPage: r.pageNum,
		        first:"首页",
		        prev:"上一页",
		        next:"下一页",
		        last:"尾页",
		        onPageClick: function (event, page) {
		        	query(page);
		        }
		    	
		    });
			$('#tabList-tmpl').tmpl(r).appendTo("#tabList");
			
			
			for(var i=0;i<data.length;i++){
				$("#a_apply_"+data[i].id).bind("click", function() {
					var applyId = this.id.substring(this.id.lastIndexOf("_")+1);
					forwardApplyForm(applyId);
				});
				
				$("#btn_cancel_"+data[i].id).bind("click", function() {
					var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
					cancelApply(obj);
				});
				$("#btn_check_view_"+data[i].id).bind("click", function() {
					var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
					showCheckView(obj);
				});
				
			}
		}
	}});
	
}


function replaceDesc(desc) {
	if(CU.isEmpty(desc)) return "";
	return (desc+"").replace(/\n/g, "<br>");
}


function cancelApply(obj) {
	CC.showMsg({msg:"您确定要撤销申请单[<font color='blue'>"+obj.code+"</font>]吗?",option:2,callback:function(r) {
		if(r != "ok") return ;
		RS.ajax({url:"/res/appres/cannelApply",ps:{applyId:obj.id},cb:function() {
			query(ParamPageNum);
		}});
	}});
}

function showCheckView(apply) {
	$("#tabCheckView").html("");
	$("#div_checkViewTitle").html("资源申请单[<font color='#008800'>"+apply.code+"</font>]审核情况");
	$('#tabCheckView-tmpl').tmpl(apply).appendTo("#tabCheckView");
	$('#div_checkView').modal('show');
}

function forwardBack() {
	window.location = ContextPath + "/dispatch/mc/10402";
}

function forwardApplyForm(id) {
	var url = ContextPath + "/dispatch/mc/1040202?appId="+APP.id;
	if(!CU.isEmpty(ParamPageNum)) url += "&pageNum="+ParamPageNum;
	if(!CU.isEmpty(id)) url += "&id="+id;
	window.location = url;
}



