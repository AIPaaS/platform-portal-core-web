var ParamPageNum = 1;
var CurrDataMap = {};

var TreeData = null;
var SelForCenterType = null;	//1=数据中心    2=资源中心    3=网络区域
var SelForCenterId = null;

var pageTimer = null;
var mouseenter = false;

var ParentLeftWidth = 0;
var ParentHeaderHeight = 0;


function init() {
	initData(function() {
		initComponent();
		initListener();
		initFace();
		query(ParamPageNum);
		refreshPage();
	});
	
}

function initData(cb) {
	var pb = CC.getParentLayoutBorder();
	ParentLeftWidth = pb.width;
	ParentHeaderHeight = pb.height;
	
	ParamPageNum = PRQ.get("pageNum");
	if(CU.isEmpty(ParamPageNum)) ParamPageNum = 1;
	
	var selstatushtml = PU.getSelectOptionsHtml("V_PC_APP_STATUS");
	$("#status").html(selstatushtml);
	
	RS.ajax({url:"/res/res/getResRegionDropListMap",ps:{addEmpty:true, addAttr:true,opts:"dc|rc|nc"},cb:function(result) {
		DROP["DV_DATA_CENTER_CODE"] = result["dc"];
		DROP["DV_RES_CENTER_CODE"] = result["rc"];
		DROP["DV_NET_ZONE_CODE"] = result["nc"];
		var dropList = [];
		for(var i=0; i<result["dc"].length; i++) dropList.push(result["dc"][i]);
		for(var i=0; i<result["rc"].length; i++) dropList.push(result["rc"][i]);
		TreeData = toTreeData(dropList);
		if(CU.isFunction(cb))cb();
	}});
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
	$("#appCode").bind("keyup", doCdtTFKeyUp);
	$("#appName").bind("keyup", doCdtTFKeyUp);
	$("#forcenter").bind("focus",function(){
		var sul = $('#sel_forcenter');
		sul.css("top", $("#forcenter").offset().top-$("#forcenter").height()+ParentHeaderHeight+10);
		sul.css("left", $("#forcenter").offset().left-$("#forcenter").width()-130+ParentLeftWidth+5);
		sul.show(); 
	});
	$("#forcenter").on("blur", function() {
		if(!mouseenter) $("#sel_forcenter").hide();
	});
	
	$("#sel_forcenter").on("mouseenter",function(){mouseenter=true;});
	$("#sel_forcenter").on("mouseleave",function(){mouseenter=false;});
	$("#sel_forcenter").bind("click", function() {
		if(!$("#sel_forcenter").is(":hidden")) $("#forcenter").focus();
	});
	$("#status").bind("change", function(){query();});
	
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


function refreshPage(){
	if(pageTimer){
		clearInterval(pageTimer);
	}
	pageTimer = setInterval(function(){refreshQuery();},1000*10);
}

function refreshQuery(){
	var pageNum = $("#pagination_box").find("li.active").text();
	var pageSize = $("#grid_pageSize").val();
	var appCode = $("#appCode").val();
	var appName = $("#appName").val();
	var status = $("#status").val();
	var orders = "APP_CODE , ID";
	var ps = {pageNum:pageNum,pageSize:pageSize,appCode:appCode,appName:appName,status:status,orders:orders};
	
	if(!CU.isEmpty(SelForCenterType) && !CU.isEmpty(SelForCenterId)) {
		switch (SelForCenterType) {		//1=数据中心    2=资源中心 
			case "1": ps.dataCenterId = SelForCenterId; break;
			case "2": ps.resCenterId = SelForCenterId; break;
		}
	}
	RS.ajax({url:"/dep/app/queryAppTimerPage",ps:ps,cb:function(r) {
		if(!CU.isEmpty(r)){
			var data = r.data;
			for(var i=0;i<data.length;i++){
				if(data[i].app.status  ==1){
					$("#a_app_start_"+data[i].app.id).show();
					$("#a_app_loading_"+data[i].app.id).hide();
					$("#a_app_destory_"+data[i].app.id).hide();
					$("#a_app_open_"+data[i].app.id).hide();
					$("#a_app_pause_"+data[i].app.id).hide();
					$("#a_app_update_"+data[i].app.id).hide();
					$("#a_app_start_"+data[i].app.id).parent().parent().find(".deploy").html('<font color="#ff8800">未部署</font>');
				}else if (data[i].app.status  ==2){
					$("#a_app_start_"+data[i].app.id).hide();
					$("#a_app_loading_"+data[i].app.id).show();
					$("#a_app_destory_"+data[i].app.id).hide();
					$("#a_app_open_"+data[i].app.id).hide();
					$("#a_app_pause_"+data[i].app.id).hide();
					$("#a_app_update_"+data[i].app.id).hide();
					$("#a_app_start_"+data[i].app.id).parent().parent().find(".deploy").html('<font color="#008800">执行中</font>');
					
				}else if (data[i].app.status  ==3){
					$("#a_app_start_"+data[i].app.id).hide();
					$("#a_app_loading_"+data[i].app.id).hide();
					$("#a_app_destory_"+data[i].app.id).show();
					$("#a_app_open_"+data[i].app.id).hide();
					$("#a_app_pause_"+data[i].app.id).show();
					$("#a_app_update_"+data[i].app.id).show();
					$("#a_app_start_"+data[i].app.id).parent().parent().find(".deploy").html('<font color="#008800">运行中</font>');
				}else if (data[i].app.status  ==4){
					$("#a_app_start_"+data[i].app.id).hide();
					$("#a_app_loading_"+data[i].app.id).hide();
					$("#a_app_destory_"+data[i].app.id).show();
					$("#a_app_open_"+data[i].app.id).show();
					$("#a_app_pause_"+data[i].app.id).hide();
					$("#a_app_update_"+data[i].app.id).show();
					$("#a_app_start_"+data[i].app.id).parent().parent().find(".deploy").html('<font color="#ff0000">停止</font>');
				}else if (data[i].app.status  ==5){
					$("#a_app_start_"+data[i].app.id).hide();
					$("#a_app_loading_"+data[i].app.id).hide();
					$("#a_app_destory_"+data[i].app.id).show();
					$("#a_app_open_"+data[i].app.id).hide();
					$("#a_app_pause_"+data[i].app.id).hide();
					$("#a_app_update_"+data[i].app.id).hide();
					$("#a_app_start_"+data[i].app.id).parent().parent().find(".deploy").html('<font color="red">部署失败</font>');
				}
			}
		}
	}});
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
	var orders = "APP_CODE , ID";
	
	var ps = {pageNum:pageNum,pageSize:pageSize,appCode:appCode,appName:appName,status:status,orders:orders};
	
	if(!CU.isEmpty(SelForCenterType) && !CU.isEmpty(SelForCenterId)) {
		switch (SelForCenterType) {		//1=数据中心    2=资源中心 
			case "1": ps.dataCenterId = SelForCenterId; break;
			case "2": ps.resCenterId = SelForCenterId; break;
		}
	}
	RS.ajax({url:"/dep/app/queryAppTimerPage",ps:ps,cb:function(r) {
		if(!CU.isEmpty(r)){
			var data = r.data;
			for(var i=0;i<data.length;i++){
				CurrDataMap["key_"+data[i].app.id] = data[i];
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
			$("#appImageTable-tmpl").tmpl(r).appendTo("#appImageTable");
			for(var i=0;i<data.length;i++){
				$("#a_app_start_"+data[i].app.id).editable({
					display:false,
					showbuttons: false,
			        value:"",
					tpl:getSelectAppVnoTpl(data[i].app.id, 1)
				});
				
				$("#a_app_update_"+data[i].app.id).editable({
					display:false,
					showbuttons: false,
			        value:"",
					tpl:getSelectAppVnoTpl(data[i].app.id, 2)
				});
				$("#a_app_open_"+data[i].app.id).bind("click",function(){
					var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
					openAppTask(obj);
				});
				
				$("#a_app_log_"+data[i].app.id).bind("click",function(){
					var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
					window.location = ContextPath + "/dispatch/mc/104060103?appId="+obj.app.id;
				});
				
				$("#a_app_pause_"+data[i].app.id).bind("click",function(){
					var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
					pauseAppTask(obj);
				});
				
				$("#a_app_destory_"+data[i].app.id).editable({
					display:false,
					showbuttons: false,
			        value:"",
					tpl:getSelectAppVnoTpl(data[i].app.id, 5)
				});
				
				$("#a_app_status_"+data[i].app.id).bind("click",function(){
					var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
					appStatus(obj);
				});
			}
		}
	}});
	
}



//type:1=start	2=restart	3=stop
function getSelectAppVnoTpl(appId, type) {
	var tpl = [];
	var obj = CurrDataMap["key_"+appId];
	var height = 30;
	
	if(!CU.isEmpty(obj) && !CU.isEmpty(obj.appVnos)) {
		var appVnos = obj.appVnos;
		for(var i=0; i<appVnos.length; i++) {
			tpl.push("<input id='a_app_image_dep_"+type+"_"+appId+"_"+appVnos[i].id+"' name=id='a_app_image_dep_"+type+"_"+appId+"' type='radio' onclick='selectAppVnoTplClick(this, "+type+")'>"
						+ "<span style='padding-left:5px;'></span>"
						+ "<label for='a_app_image_dep_"+type+"_"+appId+"_"+appVnos[i].id+"'>" + appVnos[i].versionNo 
						+ "<span style='padding-left:25px;'></span>"
						+ "<font color='"+(appVnos[i].setupStatus==1?"#008800":"#ff0000")+"'>["+(appVnos[i].setupStatus==1?"已完成":"未完成")+"]</font></label>");
		}
		
		height *= appVnos.length;
	}
		
	return "<div style='height:"+height+"px;'>"+tpl.join("<br>")+"</div>";
}



function selectAppVnoTplClick(rb, type) {
	var id = rb.id;
	var appVnoId = id.substring(id.lastIndexOf('_')+1);
	id = id.substring(0, id.lastIndexOf('_'));
	var appId = id.substring(id.lastIndexOf('_')+1);
	if(type == 1) {
		$("#a_app_start_"+appId).editable("hide");
		
		RS.ajax({url:"/dep/app/timer/deploy", ps:{appId:appId, appVnoId:appVnoId}, cb:function(json) {
			
				$("#a_app_start_"+appId).parent().parent().find(".deploy").html("");
				$("#a_app_start_"+appId).hide();
				$("#a_app_loading_"+appId).show();
		}});
		
//		RS.ajax({url:"/dep/app/startDeploy", ps:{appId:appId, appVnoId:appVnoId}, cb:function() {
//			CC.showMsg({msg:"部署成功!"});
//			
//		}});
	}
	if(type == 2 ){
		RS.ajax({url:"/dep/app/timer/upgrade", ps:{appId:appId, appVnoId:appVnoId}, cb:function() {
//			CC.showMsg({msg:"部署成功!"});
			$("#a_app_update_"+appId).editable("hide");
			$("#a_app_update_"+appId).hide();
			$("#a_app_loading_"+appId).show();
			$("#a_app_destory_"+appId).hide();
			$("a_app_open_"+appId).hide();
		}});
	}
	if(type == 5 ){
		
		RS.ajax({url:"/dep/app/timer/destory", ps:{appId:appId, appVnoId:appVnoId}, cb:function(json) {
			
			$("#a_app_destory_"+appId).editable("hide");
			$("#a_app_destory_"+appId).hide();
			$("#a_app_loading_"+appId).show();
			$("#a_app_start_"+appId).hide();
			$("#a_app_open_"+appId).hide();
			$("#a_app_update_"+appId).hide();
			
			$("#a_app_destory_"+appId).parent().parent().find(".deploy").html('<font color="#ff8800">未部署</font>');
		}});
	}
}



function toPoideTime(time) {
	if(CU.isEmpty(time)) return "";
	
	var timerExp = parseFloat(time);
	return mo(timerExp/3600)+"时"+mo(timerExp%3600/60)+"分"+(timerExp%60)+"秒";
}
function mo(f) {
	var s = f+"";
	if(s.indexOf('.')>0) {
		s = s.substring(0,s.indexOf('.'));
	}
	return parseInt(s, 10);
}



function pauseAppTask(appinfo) {
	
	var appId = appinfo.app.id ;
	RS.ajax({url:"/dep/app/timer/pause", ps:{appId:appId}, cb:function(json) {
		$("#a_app_pause_"+appId).editable("hide");
		var im = '<image src="'+ContextPath+'/layout/img/ajax-loader.gif" />';
		$("#a_app_pause_"+appId).hide();
		$("#a_app_loading_"+appId).show();
		$("#a_app_destory_"+appId).hide();
		$("#a_app_update_"+appId).hide();
	}});
}

function openAppTask(appinfo){
	var appId = appinfo.app.id ;
	RS.ajax({url:"/dep/app/timer/run", ps:{appId:appId}, cb:function(json) {
		$("#a_app_open_"+appId).editable("hide");
		$("#a_app_open_"+appId).hide();
		$("#a_app_loading_"+appId).show();
		
		$("#a_app_destory_"+appId).hide();
		$("#a_app_update_"+appId).hide();
	}});
}


appTimer ="";

function appLogTask(appId,reqId){
	RS.ajax({url:"/dep/applog/log", ps:{appId:appId,reqId:reqId,lastTime:0}, cb:function(json) {
		var tasks = json.tasks;
		var lastTime = json.lastFetchTime;
		$("#lastTime").val(lastTime);
		var actionType =  CU.getDropItemRecord("V_PC_APP_RUN_STATUS", json.actionType).name;
		var taskLog = actionType+"    开始…… \n";
		
		for(var i = 0 ;i<tasks.length;i++){
			var task = tasks[i];
			for(var j = 0 ;j<task.logs.length;j++){
				var logs = task.logs[j];
				var logState =   CU.getDropItemRecord("V_PC_APP_RESULT_CODE", logs.taskState).name;
				taskLog += logs.logTime+": " +task.taskName+"执行  "+logState+"\n";
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
			var taskLog = "";
			for(var i = 0 ;i<tasks.length;i++){
				var task = tasks[i];
				for(var j = 0 ;j<task.logs.length;j++){
					var logs = task.logs[j];
					var logState =   CU.getDropItemRecord("V_PC_APP_RUN_STATUS", logs.taskState).name;
					taskLog += logs.logTime+": " +task.taskName+"执行  "+logState+"\n";
				}
			}
			$("#logWindow").append(taskLog);
			var ta = document.getElementById('logWindow');
			ta.scrollTop = ta.scrollHeight;
		}
	}});
}



function appStatus(appinfo) {
	var appId = appinfo.app.id ;
	RS.ajax({url:"/dep/app/timer/status",
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





