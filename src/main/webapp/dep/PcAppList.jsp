<%@ page contentType="text/html; charset=utf-8"%>

<%
String ContextPath = request.getContextPath();
%>

<jsp:include page="/layout/jsp/head.jsp"></jsp:include>



<div class="row">
	<div class="col-lg-12">
		<div class="main-box clearfix">
			<div class="filter-block pull-left">
				<div class="form-group pull-left">
					<div class="form-group pull-left">
						&nbsp;&nbsp;&nbsp;应用代码:
					</div>
					<div class="form-group pull-left">
						<input type="text" name="appCode" id="appCode" class="form-control" style="width:120px;">
					</div>
					<div class="form-group pull-left">
						应用名称:
					</div>
					<div class="form-group pull-left">
						<input type="text" name="appName" id="appName" class="form-control" style="width:120px;">
					</div>
					<div class="form-group pull-left">
						资源中心:
					</div>
					<div class="form-group pull-left">
						<input type="text" name="forcenter" id="forcenter" class="form-control" style="width:120px;" readOnly >
					</div>
				</div>
				<button id="btn_query" class="btn btn-primary"><i class="fa fa-search fa-lg"></i> 查询</button>
				<button id="btn_add" class="btn btn-primary"> <i class="fa fa-plus-circle fa-lg"></i> 添加</button>
			</div>
			
		</div>
	</div>
</div>

<!-- 正文 -->

<div class="row">
	<div class="col-lg-12">
		<div class="main-box clearfix">
			<div class="main-box-body clearfix">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th class="text-center">应用代码</th>
								<th class="text-center">应用名称</th>
								<th class="text-center">数据中心</th>
								<th class="text-center">资源中心</th>
								<th class="text-center">最近版本号</th>
								<th class="text-center">应用管理员</th>
								<th class="text-center">描述</th>
							</tr>
						</thead>
						<tbody id="appTable">
							
						</tbody>
					</table>
				</div>
				<div class="row-fluid">
					<div class="col-lg-6">
						<label>
							每页
								<select name="selPageSize"  class="pagination" id="grid_pageSize" >
									<option value="10">10</option>
									<option value="15">15</option>
									<option value="20" selected>20</option>
									<option value="25">25</option>
									<option value="30">30</option>
									<option value="40">40</option>
									<option value="50">50</option>
								</select>
							条记录
						</label>
					</div>
					<div class="col-lg-6">
						<div class="pagination pull-right" id="pagination_box">
							<ul id="ul_pagination" class="pagination-sm"></ul>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>

<div id="sel_forcenter" style="width:300px;position:absolute;display:none;"></div>

<script id="appTable-tmpl" type="text/x-jquery-tmpl">
	{{each(i,row) data}}
		<tr>
			<td class="text-center"><a href="<%=ContextPath%>/dispatch/mc/1040101?id={{= row.app.id}}&pageNum={{= pageNum}}">{{= row.app.appCode}}</a></td>
			<td class="text-center">{{= row.app.appName}}</td>
			<td class="text-center">{{= PU.getDropValue("DV_DATA_CENTER_CODE",row.app.dataCenterId,false)}}</td>
			<td class="text-center">{{= PU.getDropValue("DV_RES_CENTER_CODE",row.app.resCenterId,false)}}</td>
			<td class="text-center" id="td_version_{{= row.app.id}}">{{= row.app.versionNo}}</td>
			<td class="text-center">
				{{each(j,sysOp) row.mgrOps}}
					{{if j>0}}
						,
					{{/if}}
					{{= sysOp.opName}}
				{{/each}}	
			</td>
			<td class="text-center">{{= row.app.remark}}</td>
		</tr>
{{/each}}
</script>




<jsp:include page="/layout/jsp/footer.jsp"></jsp:include>
