var ParamPageNum = 1;
var CurrDataMap = {};

var TreeData = null;
var SelForCenterType = null;	//1=数据中心    2=资源中心    3=网络区域
var SelForCenterId = null;
var taskUrl = "";


var AppId = "";

var mouseenter = false;

var ParentLeftWidth = 0;
var ParentHeaderHeight = 0;


function init() {
	initData(function() {
		
		initComponent();
		initListener();
		initFace();
		query(ParamPageNum);
	});
	
}

function initData(cb) {
	var pb = CC.getParentLayoutBorder();
	ParentLeftWidth = pb.width;
	ParentHeaderHeight = pb.height;
	AppId = PRQ.get("appId");
	ParamPageNum = PRQ.get("pageNum");
	if(CU.isEmpty(ParamPageNum)) ParamPageNum = 1;
	
	var selstatushtml = PU.getSelectOptionsHtml("V_PC_APP_TASK_STATUS");
	$("#status").html(selstatushtml);
	
	taskUrl = PP["project.task.root"];
	if(CU.isFunction(cb))cb();
}
function initComponent() {
	$("#sel_forcenter").treeview({data:TreeData,color:"#428bca",selectedBackColor:"#f0f8ff",selectedColor:"#428bca",collapseIcon:"fa fa-minus-square-o",expandIcon:"fa fa-plus-square-o",onNodeSelected: function(e, node) {
		if(CU.isEmpty(node.id)) {
			SelForCenterType = null;
			SelForCenterId = null;
			$("#forcenter").val("");
		}else {
			SelForCenterType = node.param1;
			SelForCenterId = node.id;
			$("#forcenter").val(node.text);
		}
		$('#sel_forcenter').hide();
		query(1);
	}});
	$("#sel_forcenter").treeview("collapseAll", {silent:true});
}
function initListener() {
	
	$("#btn_query").bind("click",function(){query();});
	$("#grid_pageSize").bind("change",function(){query();});
}
function initFace() {
}

/** 执行条件文本框回车查询 **/
function doCdtTFKeyUp(e) {
	if(e.keyCode === 13) query(1);
}
function toTreeData(dropList) {
	var tree = [{}];
	var pnobj = {};
	for(var i=0; i<dropList.length; i++) {
		var item = dropList[i];
		var type = item.param1;
		
		item.id = item.code;
		item.text = item.name;
		
		pnobj[item.code+"_"+type] = item;
		
		if(type == "1") {
			item.icon = "fa fa-database";
			tree.push(item);
		}else {
			item.icon = type=="2" ? "fa fa-sitemap" : "fa fa-flash";
			var pn = pnobj[item.parentCode+"_"+(parseInt(type, 10)-1)];
			if(CU.isEmpty(pn)) continue ;
			if(CU.isEmpty(pn.childNodes)) pn.childNodes = [];
			pn.childNodes.push(item);
		}
	}
	return tree;
}

function getNetZoneName(netZoneId) {
	if(CU.isEmpty(netZoneId)) return "";
	var item = CU.getDropItemRecord("DV_NET_ZONE_CODE", netZoneId);
	if(CU.isEmpty(item)) return "";
	return "["+item.attributes.zoneCode+"] "+item.name;
}

function query(pageNum){
	if(CU.isEmpty(pageNum)) pageNum = 1;
	$("#appImageTable").html("");
	$("#ul_pagination").remove();
	$("#pagination_box").html('<ul id="ul_pagination" class="pagination-sm"></ul>');
	var pageSize = $("#grid_pageSize").val();
	var appCode = $("#appCode").val();
	var appName = $("#appName").val();
	var status = $("#status").val();
	var orders = "ID DESC";
	
	var ps = {pageNum:pageNum,pageSize:pageSize,appId:AppId,orders:orders};
	
	if(!CU.isEmpty(SelForCenterType) && !CU.isEmpty(SelForCenterId)) {
		switch (SelForCenterType) {		//1=数据中心    2=资源中心 
			case "1": ps.dataCenterId = SelForCenterId; break;
			case "2": ps.resCenterId = SelForCenterId; break;
		}
	}
	RS.ajax({url:"/dep/applog/log/task",ps:ps,cb:function(r) {
		if(!CU.isEmpty(r)){
			var data = r.data;
			for(var i=0;i<data.length;i++){
				CurrDataMap["key_"+data[i].pcAppTask.id] = data[i];
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
			$("#appImageTable-tmpl").tmpl(r).appendTo("#appTaskTable");
			for(var i=0;i<data.length;i++){
				$("#a_app_log_"+data[i].pcAppTask.id).bind("click",function(){
					var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
					appLogTask(obj.pcAppTask.appId,obj.pcAppTask.id);
				});
			}
		}
	}});
	
}
appTimer ="";

function appLogTask(appId,reqId){
	RS.ajax({url:"/dep/applog/log", ps:{appId:appId,reqId:reqId,lastTime:0}, cb:function(json) {
		var tasks = json.tasks;
		var lastTime = json.lastFetchTime;
		$("#lastTime").val(lastTime);
		var taskLog = json.actionType+"    开始…… \n";
		
		for(var i = 0 ;i<tasks.length;i++){
			var task = tasks[i];
			for(var j = 0 ;j<task.logs.length;j++){
				var logs = task.logs[j];
				taskLog += logs.logTime+": " +task.taskName+"   执行"+logs.taskState+"\n";
			}
		}
		$("#div_app_log").modal("show"); 
		$("#logWindow").html("");
		$("#logWindow").html(taskLog);
	}});
	clearInterval(appTimer);
	appTimer = setInterval(function(){ logTimer(appId,reqId) ;},1000*10);
}

function logTimer(appId,reqId){
	var lastTime =$("#lastTime").val();
	
	
	RS.ajax({url:"/dep/applog/log", ps:{appId:appId,reqId:reqId,lastTime:lastTime}, cb:function(json) {
		var tasks = json.tasks;
		var lastTime = json.lastFetchTime;
		if(lastTime != 0 ){
			$("#lastTime").val(lastTime);
			for(var i = 0 ;i<tasks.length;i++){
				var task = tasks[i];
				for(var j = 0 ;j<task.logs.length;j++){
					var logs = task.logs[j];
					taskLog += logs.logTime+": " +task.taskName+"执行"+logs.taskState+"\n";
				}
			}
			$("#logWindow").append(taskLog);
			var ta = document.getElementById('logWindow');
			ta.scrollTop = ta.scrollHeight;
		}
	}});
}


