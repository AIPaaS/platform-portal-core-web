var ParamPageNum = 1;
var CurrDataMap = {};

var TreeData = null;
var SelForCenterType = null;	//1=数据中心    2=资源中心    3=网络区域
var SelForCenterId = null;
var taskUrl = "";

var mouseenter = false;

var pageTimer = null;

var ParentLeftWidth = 0;
var ParentHeaderHeight = 0;

var ParentAppId = "";

function init() {
	initData(function() {
		
		initComponent();
		initListener();
		initFace();
		query(ParentAppId);
	});
	
}

function initData(cb) {
	var pb = CC.getParentLayoutBorder();
	ParentLeftWidth = pb.width;
	ParentHeaderHeight = pb.height;
	ParentAppId = PRQ.get("appId");
	if(CU.isFunction(cb))cb();
	
}
function initComponent() {
}
function initListener() {

}
function initFace() {
}


function query(appId) {
	RS.ajax({url:"/dep/applog/log/status",
		ps:{appId:appId},
		cb:function(json) {
			$("#div_app_all_log").modal("show");
			var status_resultMsg = '<div class="table-responsive">';
			status_resultMsg += '<table class="table"><thead><tr>'
				+ '<th><a href="#"><span>结果信息</span></a></th>'
				+ '<th><a href="#"><span>'+json.resultMsg+'</span></a></th>';
			$("#appLogTable").html(status_resultMsg);
			
			
			
			var status_app ='<div class="panel-group accordion">';
			for(var j =0;j< json.status.length;j++){
				var app = json.status[0].app;
				status_app+= '<div class="panel panel-default">'+
				'<div class="panel-heading"><h4 class="panel-title">'+
				'<a class="accordion-toggle" data-toggle="collapse" data-parent="#task" href="#app_'+j+'">'+
				app.id+
				'</a></h4></div><div id="app_'+j+'" class="panel-collapse collapse in"><div class="panel-body">';
				status_app += '<div class="table-responsive">';
				status_app += '<table class="table"><thead><tr><th><a href="#">应用</a></th></tr></thead>';
				status_app += '<tbody><tr>'
					+ '<td><a href="#">应用代码</a></td><td>'
					+ app.id
					+ '</td>'
					+ '<td><a href="#">需要端口</a></td><td>'
					+ app.requirePorts
					+ '</td>'
					+ '<td><a href="#">依赖</a></td><td>'
					+ app.dependencies
					+ '</td></tr><tr>'
					+ '<td><a href="#">任务展示</a></td><td>'
					+ app.tasksStaged
					+ '</td>'
					+ '<td><a href="#">补偿工厂</a></td><td>'
					+ app.backoffFactor
					+ '</td>'
					+ '<td><a href="#">检查</a></td><td>'
					+ app.healthChecks
					+ '</td>'
					+ '<td><a href="#">时间补偿</a></td><td>'
					+ app.backoffSeconds
					+ '</td></tr><tr>'
					+ '<td><a href="#">完整任务</a></td><td>'
					+ app.tasksHealthy
					+ '</td>'
					+ '<td><a href="#">执行者</a></td><td>'
					+ app.executor
					+ '</td>'
					+ '<td><a href="#">约束</a></td><td>'
					+ app.constraints
					+ '</td>'
					+ '<td><a href="#">不完整任务</a></td><td>'
					+ app.tasksUnhealthy
					+ '</td></tr><tr>'
					+ '<td><a href="#">最大登陆延迟时间</a></td><td>'
					+ app.maxLaunchDelaySeconds
					+ '</td>'
					+ '<td><a href="#">URL仓库</a></td><td>'
					+ app.storeUrls
					+ '</td>'
					+ '<td><a href="#">运行任务</a></td><td>'
					+ app.tasksRunning
					+ '</td>'
					+ '<td><a href="#">端口</a></td><td>'
					+ app.ports
					+ '</td></tr></tbody></thead></table></div>';
				
				
				status_app +='<div class="panel-group accordion" id="task">';
				for(var i=0;i<app.tasks.length;i++){
					var task=app.tasks[i];
					status_app+=
						'<div class="panel panel-default">'+
						'<div class="panel-heading"><h4 class="panel-title">'+
						'<a class="accordion-toggle" data-toggle="collapse" data-parent="#task" href="#collapse_'+task.slaveId+'">'
						+
						'</a></h4></div><div id="collapse_'+task.slaveId+'" class="panel-collapse collapse in"><div class="panel-body">'+
						'<table class="table"><tbody><tr>'+
						'<td><a href="javascript:void(0);" >Id</a></td><td><a href="javascript:void(0);" id="taskId_'+task.slaveId+'">'
						+ task.id
						+ '</a></td>'+
						'<td><a href="#">host</a></td><td>'
						+ task.host
						+ '</td>'+
						'<td><a href="#">版本</a></td><td>'
						+ task.version
						+ 
						'</tr><tbody></table>'+
						'<div class="modal-body" style=" min-height: 400px;display:none;" id="iframe_'+task.slaveId+'">'+
						'<iframe width="780px;" height="400px;"   ></iframe >'+
						'</div></div></div></div>';
				}
				status_app+='</div></div></div></div>';
				}
			status_app +='</div>';
			$("#appLogTable").append(status_app);
			for(var j =0;j< json.status.length;j++){
				var app =  json.status[j].app;
				for(var i=0;i<app.tasks.length;i++){
					var task=app.tasks[i];
					$("#taskId_"+task.slaveId).bind("click",function(){
						var slaveId = $(this).attr("id").replace("taskId_","");
						var url = "http://10.1.241.124:8022";
						$("#iframe_"+slaveId).slideToggle();
						$("#iframe_"+slaveId).find("iframe").attr("src",url);
					});
					
				}
				
				
			}
	}});
}


