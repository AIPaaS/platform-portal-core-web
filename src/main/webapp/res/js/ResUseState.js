
var ParamPageNum = 1;
var CurrDataMap = {};

var bgcolors = ["emerald-bg","red-bg","yellow-bg","green-bg","purple-bg","gray-bg"];
var icons = ["fa-rocket", "fa-share-alt", "fa-star-half-empty", "fa-umbrella", "fa-plane", "fa-space-shuttle", "fa-joomla", "fa-fighter-jet", "fa-trophy"];

function init() {
	initData(function() {
		initComponent();
		initListener();
		initFace();
		query(ParamPageNum);
	});
	
}


function initData(cb) {
	ParamPageNum = PRQ.get("pageNum");
	if(CU.isEmpty(ParamPageNum)) ParamPageNum = 1;

	RS.ajax({url:"/res/res/getResRegionDropListMap",ps:{addEmpty:true, addAttr:true,opts:"dc|rc|nc"},cb:function(result) {
		DROP["DV_DATA_CENTER_CODE"] = result["dc"];
		DROP["DV_RES_CENTER_CODE"] = result["rc"];
		DROP["DV_NET_ZONE_CODE"] = result["nc"];
		if(CU.isFunction(cb))cb();
	}});
}


function initComponent() {
}
function initListener() {
}
function initFace() {
}
/** 执行条件文本框回车查询 **/
function doCdtTFKeyUp(e) {
	if(e.keyCode === 13) query(1);
}


function getNetZoneName(netZoneId) {
	if(CU.isEmpty(netZoneId)) return "";
	var item = CU.getDropItemRecord("DV_NET_ZONE_CODE", netZoneId);
	if(CU.isEmpty(item)) return "";
	return "["+item.attributes.zoneCode+"] "+item.name;
}


function query(pageNum){
	if(CU.isEmpty(pageNum)) pageNum = 1;
	
	RS.ajax({url:"/res/mntres/queryUseState",cb:function(rs) {
		var tableData = [];		//[{dataCenterId:1,resCenterId:2,apps:[{info}]}]
		var tableMap = {};		//key=res_+resCenterId, value=apps
		
		for(var i=0; i<rs.length; i++) {
			CurrDataMap["key_"+rs[i].app.id] = rs[i];
			
			rs[i].titlebg = bgcolors[i%bgcolors.length];
			rs[i].icon = icons[i%icons.length];
			
			var rsCenterId = rs[i].app.resCenterId;
			var apps = tableMap["res_"+rsCenterId];
			if(CU.isEmpty(apps)) {
				apps = [];
				tableMap["res_"+rsCenterId] = apps;
				tableData.push({dataCenterId:rs[i].app.dataCenterId, resCenterId:rs[i].app.resCenterId, apps:apps});
			}
			apps.push(rs[i]);
		}
		
		$("#div_res_content-tmpl").tmpl({data:tableData}).appendTo("#div_res_content");
		
		for(var i=0;i<rs.length;i++){
			$("#a_app_res_use_"+rs[i].app.id).bind("click",function(){
				var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
				showAppResUseModal(obj.app.id);
			});
		}
	}});
	
	
}




function showAppResUseModal(appId){
	var obj =  CurrDataMap["key_"+appId];
	$("#div_title").html("应用[<font color='blue'>"+obj.app.appCode+"</font>]资源占用情况");
	$("#appResUseTable").html("");
	RS.ajax({url:"/dep/app/queryAppNetZoneResInfo",ps:{appId:appId,appVnoId:obj.appVnos[0].id},cb:function(rs) {
		if(!CU.isEmpty(rs)){
			var row = CurrDataMap["key_"+appId];
			row.FLAG_SUMMARY = true;
			rs.push(row);
			$("#appResUseTable-tmpl").tmpl({data:rs}).appendTo("#appResUseTable");
		}
	}});
	$("#div_appResUse").modal("show");
}

