
var TreeData = null;
var SelForCenterType = null;	//1=数据中心    2=资源中心 
var SelForCenterId = null;

var mouseenter = false;

var CurrDataMap = {};
var ParamPageNum = 1;

var CurrentCheckMnt = null;


function init() {
	initData(function() {
		initComponent();
		initListener();
		initFace();
		query(1);
	});
	
}


function initData(cb) {
	ParamPageNum = PRQ.get("pageNum");
	if(CU.isEmpty(ParamPageNum)) ParamPageNum = 1;
	
	RS.ajax({url:"/res/res/getResRegionDropListMap",ps:{addEmpty:true, addAttr:true, opts:"dc|rc"},cb:function(result) {
		DROP["DV_DATA_CENTER_CODE"] = result["dc"];
		DROP["DV_RES_CENTER_CODE"] = result["rc"];
		
		var dropList = [];
		for(var i=1; i<result["dc"].length; i++) dropList.push(result["dc"][i]);
		for(var i=1; i<result["rc"].length; i++) dropList.push(result["rc"][i]);
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
		query();
	}});
	$("#sel_forcenter").treeview("collapseAll", {silent:true});
}
function initListener() {
	$("#cdtAppCode").bind("keyup", doCdtTFKeyUp);
	$("#cdtAppName").bind("keyup", doCdtTFKeyUp);
	
	
	$("#forcenter").bind("focus",function(){
		var sul = $('#sel_forcenter');
		sul.css("top", $("#forcenter").offset().top-$("#forcenter").height());
		sul.css("left", $("#forcenter").offset().left-$("#forcenter").width()-90);
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


function query(pageNum){
	if(CU.isEmpty(pageNum)) pageNum = 1;
	
	delete CurrDataMap;
	CurrDataMap = {};
	$("#tabList").html("");
	$("#ul_pagination").remove();
	$("#pagination_box").html('<ul id="ul_pagination" class="pagination-sm"></ul>');
	
	var pageSize = $("#grid_pageSize").val();
	var appCode = $("#cdtAppCode").val();
	var appName = $("#cdtAppName").val();
	var orders = " APP_CODE ";
	
	var cdt = {pageNum:pageNum,pageSize:pageSize,appCode:appCode,appName:appName,orders:orders};
	if(SelForCenterType=="1"||SelForCenterType=="2") {
		if(SelForCenterType == "1") {
			cdt.dataCenterId = SelForCenterId;
		}else {
			cdt.resCenterId = SelForCenterId;
		}
	}
	
	RS.ajax({url:"/res/appres/queryAppResInfoPage",ps:cdt,cb:function(r) {
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
		}
	}});
	
}




