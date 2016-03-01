

/**
 * 用户选择器
 * @param cfg
 * 		winId 定义窗体ID, 缺省为自动生成
 * 		singleSelect 是否单选, 缺省为false
 * 		pageSize 查询页大小, 缺小为20
 * 		callback 当用户确定时会调用此方法callback(users)
 */
function UserSelector(cfg) {
	var thiz = this;
	
	this.options = {winId:"USER_SELECTOR_"+CU.getId(),singleSelect:false,pageSize:20};
	$.extend(thiz.options, cfg);
	
	this.options.singleSelectCbName = thiz.options.winId + "_SINGLE_SELECT_CB_NAME";
	this.options.selectedUserDivIdPrefix = thiz.options.winId + "_SELECTED_USER_DIVID_PREFIX_";
	
	this.win = $("<div class=\"modal fade\" id=\""+thiz.options.winId+"\" tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\" />");
	this.win.appendTo($("body"));
	
	var modalDialog = $("<div class=\"modal-dialog\" style=\"width:800px;\"></div>");
	var modalContent = $("<div class=\"modal-content\"></div>");
	var modalHeader = $("<div class=\"modal-header\"></div>");
	modalHeader.append($("<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"));
	modalHeader.append($("<h4 class=\"modal-title\"><strong>选择用户<strong></h4>"));
	var modalBody = $("<div class=\"modal-body\" ></div>");
	
	modalContent.append(modalHeader);
	modalContent.append(modalBody);
	modalDialog.append(modalContent);
	this.win.append(modalDialog);
	
	var p_header = $("<div class=\"row\"></div>");
	var p_users = $("<div class=\"form-group pull-left\"></div>");
	var btn_ok = $("<button class=\"btn btn-danger\" ><i class=\"fa fa-check fa-lg\"></i> 确定</button>");
	var btn_cancel = $("<button class=\"btn btn-default\" ><i class=\"fa fa-power-off fa-lg\"></i> 取消</button>");
	
	p_header.append($("<div class=\"col-lg-12\"></div>")
				.append($("<div class=\"main-box clearfix\"></div>")
						.append($("<div class=\"filter-block pull-left\"></div>")
								//.append($("<div class=\"form-group pull-left\">已选用户：</div>"))
								.append(p_users))
						.append($("<div class=\"filter-block pull-right\"></div>")
								.append($("<div class=\"form-group pull-right\"></div>")
										.append(btn_ok)
										.append(btn_cancel)))));
	
	
	var p_content = $("<div class=\"row\"></div>");
	
	var TF_cdt0_opCode = $("<input type=\"text\" class=\"form-control\" style=\"width:160px;\">");
	var TF_cdt1_opName = $("<input type=\"text\" class=\"form-control\" style=\"width:160px;\">");
	var btn_query = $("<button class=\"btn btn-primary pull-left\" ><i class=\"fa fa-search fa-lg\"></i> 查询</button>");
	
	var tab = $("<table class=\"table\"></table>");
	var tabBody = $("<tbody></tbody>");
	var tabSelAll = $("<input type=\"checkbox\">");
	var pagination_box = $("<div class=\"pagination pull-right\"></div>");
	this.ul_pagination = $("<ul class=\"pagination-sm\"></ul>");
	
	tab.append($("<thead>"
				+ "<tr>"
				+ "<th class=\"text-left\"></th>"
				+ "<th class=\"text-center\">用户代码</th>"
				+ "<th class=\"text-center\">用户姓名</th>"
				+ "<th class=\"text-center\">手机号</th>"
				+ "<th class=\"text-center\">邮箱地址</th>"
				+ "</tr>"
				+ "</thead>"))
		.append(tabBody);
	pagination_box.append(thiz.ul_pagination);
	
	p_content.append($("<div class=\"col-lg-12\"></div>")
				.append($("<div class=\"main-box clearfix\"></div>")
						.append($("<header class=\"main-box-header clearfix\"></header>")
								.append($("<div class=\"filter-block pull-left\"></div>")
										.append($("<div class=\"form-group pull-left\"></div>")
												.append($("<div class=\"form-group pull-left\">&nbsp;&nbsp;&nbsp;用户代码:</div>")))
												.append($("<div class=\"form-group pull-left\"></div>").append(TF_cdt0_opCode))
												.append($("<div class=\"form-group pull-left\">&nbsp;&nbsp;用户姓名:</div>"))
												.append($("<div class=\"form-group pull-left\"></div>").append(TF_cdt1_opName))
										.append(btn_query)))
						.append($("<div class=\"main-box-body clearfix\"></div>")
								.append($("<div class=\"table-responsive\">").append(tab))
								.append($("<div class=\"row-fluid\"></div>")
										.append($("<div class=\"col-lg-6\">&nbsp;</div>"))
										.append($("<div class=\"col-lg-6\"></div>").append(pagination_box))))));
	
	modalBody.append(p_header);
	modalBody.append(p_content);
	
	
	if(thiz.options.singleSelect !== true) {
		$(tab.find("th")[0]).append(tabSelAll);
		tabSelAll.bind("change", function() {
			var cb = tabSelAll.prop("checked");
			tabBody.find("input").prop("checked", cb);
			onUserSelect();
		});
	}
	
	
	
	var data = {
			QueryUsers:{},		//当前查询出来的User对象, key=key_opId
			SelectUsers:{}		//当前选择用户对象列表, key=key_opId
	};
		
	var doCdtTFKeyUp = function(e) {
		if(e.keyCode === 13) thiz.query();
	};
	var appendUserDom = function(op) {
		var divid = thiz.options.selectedUserDivIdPrefix+op.id;
		var aid = divid + "_A_" + op.id;
		var ela = $("<a id=\""+aid+"\" href=\"###\" style=\"color:#FF0000;\"><i class=\"fa fa-times\"></i></a>");
		p_users.append($("<div id=\""+divid+"\" class=\"form-group pull-left\"></div>")
							.append($("<div class=\"form-control\" >["+op.opCode+"]"+op.opName+" </div>").append(ela)));
		ela.bind("click", function() {
			var opId = this.id.substring(this.id.lastIndexOf("_")+1);
			thiz.removeSelectedUser(opId);
			
			var cbs = tabBody.find("input");
			if(CU.isEmpty(cbs)) return ;
			
			for(var i=0; i<cbs.length; i++) {
				if(cbs[i].value == opId) {
					$(cbs[i]).prop("checked", false);
					break;
				}
			}
		});
	};
	var removeUserDom = function(opId) {
		var el = $("#"+thiz.options.selectedUserDivIdPrefix+opId);
		if(!CU.isEmpty(el)) el.remove();
	};
	var onUserSelect = function() {
		var cbs = tabBody.find("input");
		if(CU.isEmpty(cbs)) return ;
		
		for(var i=0; i<cbs.length; i++) {
			if(cbs[i].checked) {
				thiz.addSelectedUser(cbs[i].value);
			}else {
				thiz.removeSelectedUser(cbs[i].value);
			}
		}
	};
	var effVal = function(v) {
		if(v===undefined || v===null) return "&nbsp;";
		return v;
	};
	var buildTableBody = function(ls) {
		if(CU.isEmpty(ls)) return ;
		for(var i=0; i<ls.length; i++) {
			data.QueryUsers["key_"+ls[i].id] = ls[i];
			var cb = $("<input type=\""+(thiz.options.singleSelect!==true?"checkbox":"radio")+"\" name=\""+thiz.options.singleSelectCbName+"\" value=\""+ls[i].id+"\" >");
			cb.bind("change", onUserSelect);
			tabBody.append($("<tr></tr>")
								.append($("<td class=\"text-left\"></td>").append(cb))
								.append($("<td class=\"text-center\">"+effVal(ls[i].opCode)+"</td>"))
								.append($("<td class=\"text-center\">"+effVal(ls[i].opName)+"</td>"))
								.append($("<td class=\"text-center\">"+effVal(ls[i].mobileNo)+"</td>"))
								.append($("<td class=\"text-center\">"+effVal(ls[i].emailAdress)+"</td>")));
		}
	};
	
	
	
	
	this.addSelectedUser = function(opId) {
		var key = "key_"+opId;
		var selobj = data.SelectUsers[key];
		if(CU.isEmpty(selobj)) {
			//如果是单选则先清空之前选中的内容
			if(thiz.options.singleSelect == true) {
				delete data.SelectUsers;
				data.SelectUsers = {};
				p_users.empty();
			}
			data.SelectUsers[key] = data.QueryUsers[key];
			appendUserDom(data.SelectUsers[key]);
		}
	};
	this.removeSelectedUser = function(opId) {
		var key = "key_"+opId;
		var selobj = data.SelectUsers[key];
		if(!CU.isEmpty(selobj)) {
			removeUserDom(selobj.id);
			delete data.SelectUsers[key];
		}
	};
	
	
	this.reset = function() {
		delete data.QueryUsers;
		delete data.SelectUsers;
		data.QueryUsers = {};
		data.SelectUsers = {};
		tabSelAll.prop("checked", false);
		p_users.empty();
	};
	
	this.query = function(pageNum, cb) {
		if(CU.isEmpty(pageNum)) pageNum = 1;
		
		tabBody.html("");
		delete data.QueryUsers;
		data.QueryUsers = {};
		thiz.ul_pagination.remove();
		thiz.ul_pagination = $("<ul class=\"pagination-sm\"></ul>");
		pagination_box.append(thiz.ul_pagination);
		
		var psize = thiz.options.pageSize;
		if(CU.isEmpty(psize) || psize<1) psize = 20;
		
		var opCode = TF_cdt0_opCode.val();
		var opName = TF_cdt1_opName.val();
		var orders = "OP_CODE";
		
		var ps = {pageNum:pageNum,pageSize:psize,opCode:opCode,opName:opName,status:1,orders:orders};
		RS.ajax({url:"/mnt/user/queryOpPage",ps:ps,cb:function(r) {
			if(!CU.isEmpty(r)){
				buildTableBody(r.data);
				
				thiz.ul_pagination.twbsPagination({
			        totalPages: r.totalPages?r.totalPages:1,
			        visiblePages: 7,
			        startPage: r.pageNum,
			        first:"首页",
			        prev:"上一页",
			        next:"下一页",
			        last:"尾页",
			        onPageClick: function (event, page) {
			        	thiz.query(page);
			        }
			    });
			}
			
			if(CU.isFunction(cb)) cb();
		}});
		
	};
	
	
	
	/**
	 * 指定已选择用户
	 * selectOps 可以是opId数组, 也可以是submit返回数组
	 */
	this.show = function(selectOps, cb) {
		thiz.reset();
		thiz.win.modal("show");
		thiz.query(null, function() {
			if(CU.isArray(selectOps) && !CU.isEmpty(selectOps)) {
				var opIds = [];
				if(CU.isObject(selectOps[0])) {
					for(var i=0; i<selectOps.length; i++) {
						opIds.push(selectOps[i].code);
					}
				}else {
					opIds = selectOps;
				}
				RS.ajax({url:"/mnt/user/queryOpByIds",ps:{strOpIds:opIds.join(",")},cb:function(rs) {
					for(var i=0; i<rs.length; i++) {
						data.QueryUsers["key_"+rs[i].id] = rs[i];
						thiz.addSelectedUser(rs[i].id);
					}
					if(CU.isFunction(cb)) cb();
				}});
			}else {
				if(CU.isFunction(cb)) cb();
			}
		});
		
	};
	this.submit = function() {
		var arr = [];
		for(var key in data.SelectUsers) {
			var op = data.SelectUsers[key];
			arr.push({code:op.id, name:op.opName, attributes:op});
		}
		if(CU.isEmpty(arr)) {
			alert("请选择用户!");
			return ;
		}
		thiz.close();
		if(CU.isFunction(thiz.options.callback)) {
			thiz.options.callback(arr);
		}
	};
	this.close = function() {
		thiz.win.modal("hide");
	};
	
	
	
	
	
	
	TF_cdt0_opCode.bind("keyup", doCdtTFKeyUp);
	TF_cdt1_opName.bind("keyup", doCdtTFKeyUp);
	btn_query.bind("click", function(){thiz.query();});
	btn_ok.bind("click", thiz.submit);
	btn_cancel.bind("click", thiz.close);
	
}