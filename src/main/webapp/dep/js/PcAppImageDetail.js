
var ParamPageNum = 1;
var CurrDataMap = {};
var AppId = "";
var AppVnoId = "";
var APP = null;

var bgcolors = ["emerald-bg","red-bg","yellow-bg","green-bg","purple-bg","gray-bg"];

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
	AppId = PRQ.get("appId");
	AppVnoId = PRQ.get("appVnoId");
	if(CU.isEmpty(ParamPageNum)) ParamPageNum = 1;

	if(CU.isEmpty(AppId) || CU.isEmpty(AppVnoId)) {
		alert("没有找到应用["+AppId+"]!");
		pageBack();
		return;
	}
	
	RS.ajax({url:"/dep/app/queryById",ps:{id:AppId},cb:function(rs) {
		if(CU.isEmpty(rs)) {
			alert("没有对应的应用!");
			pageBack();
			return;
		}
		APP = rs;
		
		$("#span_app_title").html("["+rs.appCode+"]["+rs.appName+"]");
		
		RS.ajax({url:"/res/res/getResRegionDropListMap",ps:{addEmpty:true, addAttr:true,opts:"dc|rc|nc"},cb:function(result) {
			DROP["DV_DATA_CENTER_CODE"] = result["dc"];
			DROP["DV_RES_CENTER_CODE"] = result["rc"];
			DROP["DV_NET_ZONE_CODE"] = result["nc"];
			
			$("#span_res_title").html("["+PU.getDropValue("DV_DATA_CENTER_CODE", rs.dataCenterId)+"] - ["+PU.getDropValue("DV_RES_CENTER_CODE", rs.resCenterId)+"]");
			if(CU.isFunction(cb))cb();
		}});
	}});
}


function initComponent() {
}
function initListener() {
	$("#btn_add").bind("click",function(){window.location = ContextPath + "/dispatch/mc/104050102?pageNum="+ParamPageNum+"&appId="+AppId;});
}
function initFace() {
}
/** 执行条件文本框回车查询 **/
function doCdtTFKeyUp(e) {
	if(e.keyCode === 13) query(1);
}

function query(pageNum){
	if(CU.isEmpty(pageNum)) pageNum = 1;
	
	$("#appImageDetailTable").html("");
	var orders = "CONTAINER_NAME";
	
	var ps = {appId:AppId,appVnoId:AppVnoId,orders:orders};
	RS.ajax({url:"/dep/appimage/queryAppImageInfoList",ps:ps,cb:function(rs) {
		if(!CU.isEmpty(rs)){
			var data = rs;
			for(var i=0; i<data.length; i++) {
				//data[i].titlebg = bgcolors[i%bgcolors.length]; 
				data[i].titlebg = data[i].appImage.setupNum==9 ? "green-bg" : "red-bg";
				CurrDataMap["key_"+data[i].appImage.id] = data[i];
			}
			$('#appImageDetailTable-tmpl').tmpl({data:data}).appendTo("#appImageDetailTable");
			
			for(var i=0; i<data.length; i++) {
				$("#a_remove_app_image_"+data[i].appImage.id).bind("click",function(){
					var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
					removeAppImage(obj.appImage.id);
				});
			}
		}
		
		if(APP.appType==2 && !CU.isEmpty(rs) && rs.length>0) {
			$("#btn_add").hide();
		}else {
			$("#btn_add").show();
		}
	}});
	
}



function removeAppImage(id){
	var obj = CurrDataMap["key_"+id];
	CC.showMsg({msg:"您确定要删除容器[<font color='blue'>"+obj.appImage.containerName+"</font>]吗?",option:2,callback:function(r) {
		if(r != "ok") return ;
		RS.ajax({url:"/dep/appimage/removeAppImage",ps:{appImageId:id},cb:function() {
			query(ParamPageNum);
		}});
	}});
}

function pageBack() {
	var url = ContextPath + "/dispatch/mc/10405?1=1";
	if(!CU.isEmpty(ParamPageNum)) url += "&pageNum="+ParamPageNum;
	window.location = url;
}