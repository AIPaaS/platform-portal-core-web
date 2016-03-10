var ParamPageNum = 1;
var CurrDataMap = {};

var TreeData = null;
var SelForCenterType = null;	//1=数据中心    2=资源中心    3=网络区域
var SelForCenterId = null;
var taskUrl = "";

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
	
	ParamPageNum = PRQ.get("pageNum");
	if(CU.isEmpty(ParamPageNum)) ParamPageNum = 1;
	
	var selstatushtml = PU.getSelectOptionsHtml("V_PC_APP_STATUS");
	$("#status").html(selstatushtml);
	
	taskUrl = PP["project.task.root"];
	
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
	RS.ajax({url:"/dep/app/queryRunAppPage",ps:ps,cb:function(r) {
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
		
		RS.ajax({url:"/dep/app/startDeploy", ps:{appId:appId, appVnoId:appVnoId}, cb:function(json) {
			
				var im = '<image src="'+ContextPath+'/layout/img/ajax-loader.gif" />';
				$("#a_app_start_"+appId).html(im);
				$("#a_app_start_"+appId).parent().parent().find(".deploy").html("");
				$("#a_app_start_"+appId).unbind();
				var reqId = json.reqId;
				appLogTask(appId,json.reqId);
		}});
		
//		RS.ajax({url:"/dep/app/startDeploy", ps:{appId:appId, appVnoId:appVnoId}, cb:function() {
//			CC.showMsg({msg:"部署成功!"});
//			
//		}});
	}
	if(type == 2 ){
		RS.ajax({url:"/dep/app/updateDeploy", ps:{appId:appId, appVnoId:appVnoId}, cb:function() {
//			CC.showMsg({msg:"部署成功!"});
			$("#a_app_update_"+appId).editable("hide");
			var im = '<image src="'+ContextPath+'/layout/img/ajax-loader.gif" />';
			$("#a_app_update_"+appId).html(im);
			$("#a_app_update_"+appId).parent().parent().find(".deploy").html("");
			$("#a_app_destory_"+appId).hide();
			$("#a_app_pause_"+appId).hide();
			$("a_app_open_"+appId).hide();
			$("#a_app_update_"+appId).unbind();
			appLogTask(json.appId,json.reqId);
		}});
	}
	if(type == 5 ){
		
		RS.ajax({url:"/dep/app/stopDeploy", ps:{appId:appId, appVnoId:appVnoId}, cb:function(json) {
			
			$("#a_app_destory_"+appId).editable("hide");
			var im = '<image src="'+ContextPath+'/layout/img/ajax-loader.gif" />';
			$("#a_app_destory_"+appId).html(im);
			$("#a_app_destory_"+appId).parent().parent().find(".deploy").html("");
			$("#a_app_destory_"+appId).unbind();
			
			$("#a_app_start_"+appId).show();
			$("#a_app_destory_"+appId).hide();
			$("#a_app_pause_"+appId).hide();
			$("#a_app_open_"+appId).hide();
			$("#a_app_update_"+appId).hide();
			
			$("#a_app_destory_"+appId).parent().parent().find(".deploy").html('<font color="#ff8800">未部署</font>');
			appLogTask(json.appId,json.reqId);
		}});
	}
}



function pauseAppTask(appinfo) {
	
	var appId = appinfo.app.id ;
	RS.ajax({url:"/dep/app/pauseApp", ps:{appId:appId}, cb:function(json) {
		$("#a_app_pause_"+appId).editable("hide");
		var im = '<image src="'+ContextPath+'/layout/img/ajax-loader.gif" />';
		$("#a_app_pause_"+appId).html(im);
		$("#a_app_pause_"+appId).parent().parent().find(".deploy").html("");
		$("#a_app_pause_"+appId).unbind();
		
		
		$("#a_app_destory_"+appId).hide();
		$("#a_app_update_"+appId).hide();
		appLogTask(json.appId,json.reqId);
	}});
}

function openAppTask(appinfo){
	var appId = appinfo.app.id ;
	RS.ajax({url:"/dep/app/startApp", ps:{appId:appId}, cb:function() {
		$("#a_app_open_"+appId).editable("hide");
		var im = '<image src="'+ContextPath+'/layout/img/ajax-loader.gif" />';
		$("#a_app_open_"+appId).html(im);
		$("#a_app_open_"+appId).parent().parent().find(".deploy").html("");
		$("#a_app_open_"+appId).unbind();
		
		$("#a_app_destory_"+appId).hide();
		$("#a_app_update_"+appId).hide();
		appLogTask(json.appId,json.reqId);
	}});
}


appTimer ="";

function appLogTask(appId,reqId){
//	RS.ajax({url:"/dep/applog/log", ps:{appId:appId,reqId:reqId,lastTime:0}, cb:function(json) {
//		var tasks = json.tasks;
//		var lastTime = json.lastTime;
//		$("#lastTime").val(lastTime);
//		var taskLog = "";
//		for(var i = 0 ;i<tasks.length;i++){
//			var task = tasks[i];
//			for(var j = 0 ;j<task.logs.length;j++){
//				var logs = task.logs[j];
//				taskLog +=logs.logTime+":"+logs.logCnt +"\n";
//			}
//		}
//		$("#div_app_log").modal("show"); 
//		$("#logWindow").html("");
//		$("#logWindow").html(taskLog);
//	}});
//	clearInterval(appTimer);
//	appTimer = setInterval(function(){ logTimer(appId,reqId) ;},1000*10);
}

function logTimer(appId,reqId){
	var lastTime =$("#lastTime").val();
	RS.ajax({url:"/dep/app/logApp", ps:{appId:appId,reqId:reqId,lastTime:lastTime}, cb:function(json) {
		var tasks = json.tasks;
		var lastTime = json.lastTime;
		$("#lastTime").val(lastTime);
		var taskLog = "";
		for(var i = 0 ;i<tasks.length;i++){
			var task = tasks[i];
			for(var j = 0 ;j<task.logs.length;j++){
				var logs = task.logs[j];
				taskLog +=logs.logTime+":"+logs.logCnt +"\n";
			}
		}
		$("#logWindow").append(taskLog);
		var ta = document.getElementById('logWindow');
		ta.scrollTop = ta.scrollHeight;
	}});
}

function appAllLogTask(appId,reqId) {
	$("#div_app_all_log").modal("show"); 
	$("#logWindow").html("");
	
	
	RS.ajax({url:"/dep/app/logApp", ps:{appId:appId,reqId:reqId}, cb:function(json) {
		var tm = '<table class="table">';
		tm +="<td><tr>集群名称</tr><tr>"+json.clusterName+"</tr></td>";
		tm +="<td><tr>数据中心</tr><tr>"+json.dataCenterName+"</tr></td></table>";
		$("#appLogTable").html(tm);
		var tasks = json.tasks;
		var um = '<ul class="nav nav-tabs" id="myTab">';
		for(var i = 0 ;i<tasks.length;i++){
			var task = tasks[i];
			if(i==0){
				um += '<li class="active"><a href="#'+task.taskName+'">'+task.taskName+'</a></li> ';
			}else{
				um += '<li><a href="#'+task.taskName+'">'+task.taskName+'</a></li> ';
			}
		}
		um +='</ul><div class="tab-content"> ';
		for(var i = 0 ;i<tasks.length;i++){
			var task = tasks[i];
			var logs = task.logs;
			var taskLog = "";
			for(var j = 0;j<logs.length;j++){
				taskLog +=logs[j].logTime+":"+logs[j].logCnt +"\n";
			}
			if(i==0){
				um += '<div class="tab-pane active" id="'+task.taskName+'">'+
				'<textarea id="logWindow_'+task.taskName+'" cols="90%" rows="15%" value="" style="width:768px;border-style: solid;background-color:black;color:white;font-size: 15px;">'+taskLog+'</textarea></div>  ';
			}else{
				um += '<div class="tab-pane" id="'+task.taskName+'">'+
				'<textarea id="logWindow_'+task.taskName+'" cols="90%" rows="15%" value="" style="width:768px;border-style: solid;background-color:black;color:white;font-size: 15px;">'+taskLog+'</textarea></div>  ';
			}
		}
		um += '</div>';
		$("#appLogInfoDiv").html(um);
		tabInit();
		
		
	}});
//	clearInterval(appTimer);
//	appTimer = setInterval(function(){ show(appId,reqId) ;},1000);
	
}
function show(appId,reqId){
	var time=new Date();
	var hour=time.getHours();
	var minu=time.getMinutes();
	var sec=time.getSeconds();
	var datetime=hour +":" +minu+ ":" +sec;
	var ta = document.getElementById('logWindow');
	$("#logWindow").append(datetime+"    appId:"+appId+"    reqId:"+reqId+'\n'  );
	ta.scrollTop = ta.scrollHeight;
	
}


function tabInit(){
//	$('#myTab a:last').tab('show');//初始化显示哪个tab 
    $('#myTab a').click(function (e) { 
      e.preventDefault();//阻止a链接的跳转行为 
      $(this).tab('show');//显示当前选中的链接及关联的content 
    }) 
}

