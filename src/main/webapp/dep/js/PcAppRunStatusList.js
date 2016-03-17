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

var parentAppId = null;

function init() {
	initData(function() {
		
		initComponent();
		initListener();
		initFace();
		appStatus(parentAppId);
	});
	
}

function initData(cb) {
	var pb = CC.getParentLayoutBorder();
	ParentLeftWidth = pb.width;
	ParentHeaderHeight = pb.height;
	
	parentAppId = PRQ.get("appId");
	
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

}
function initFace() {
}


function appStatus(appId) {
	
	var appId = appinfo.app.id ;
	RS.ajax({url:"/dep/applog/log/status",
		ps:{appId:appId},
		cb:function(json) {
			$("#div_app_all_log").modal("show");
			var status_resultMsg = '<div class="table-responsive">';
			status_resultMsg += '<table class="table"><thead><tr>'
				+ '<th><a href="#"><span>结果信息</span></a></th>'
				+ '<th><a href="#"><span>'+json.resultMsg+'</span></a></th>';
			$("#appLogTable").html(status_resultMsg);
			
			var app = json.status[0].app;
			var status_app = '<div class="table-responsive">';
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
			$("#appLogTable").append(status_app);
			
			var appTaskHtml='<div class="panel-group accordion" id="task">';
			for(var i=0;i<app.tasks.length;i++){
				var task=app.tasks[i];
				appTaskHtml+=
				'<div class="panel panel-default">'+
				'<div class="panel-heading"><h4 class="panel-title">'+
				'<a class="accordion-toggle" data-toggle="collapse" data-parent="#task" href="#collapse'+i+'">'
				+'Task'+
				'</a></h4></div><div id="collapse'+i+'" class="panel-collapse collapse in"><div class="panel-body">'+
				'<table class="table"><tbody><tr>'+
				'<td><a href="#">Id</a></td><td>'
				+ task.id
				+ '</td>'+
				'<td><a href="#">host</a></td><td>'
				+ task.host
				+ '</td>'+
				'<td><a href="#">版本</a></td><td>'
				+ task.version
				+ 
				'</tr><tbody></table></div></div></div>';
			}
			appTaskHtml+='</div>';
			$("#appLogTable").append(appTaskHtml);
			var app_versionInfo="";
			app_versionInfo+='<table class="table"><tr>'+
			'<td>最后缩放时间</td><td>'+
			versionInfo.lastScalingAt+
			'</td></tr><tr>'+
			'<td>配置最终修改时间</td><td>'+
			versionInfo.lastConfigChangeAt
			'</td></tr></table></div></div>';
			$("#appLogTable").append(app_versionInfo);
	}});
}

