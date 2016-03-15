<%@ page contentType="text/html; charset=utf-8"%>

<%
String ContextPath = request.getContextPath();
%>

<jsp:include page="/layout/jsp/head.jsp"></jsp:include>



<div class="row">
	<div class="col-lg-12">
		<div class="main-box clearfix">
			<div class="filter-block pull-left">
				<div class="pull-left">
					<!-- <div class="form-group pull-left">
						&nbsp;&nbsp;&nbsp;&nbsp;应用代码:
					</div>
					<div class="form-group pull-left">
						<input type="text" name="appId" id="appId" class="form-control" style="width:120px;">
					</div> -->
					<div class="form-group pull-left">
						&nbsp;&nbsp;&nbsp;&nbsp;访问名称:
					</div>
					<div class="form-group pull-left">
						<input type="text" name="accessCode" id="accessCode" class="form-control" style="width:120px;">
					</div>
					<div class="form-group pull-left">
						资源中心:
					</div>
					<div class="form-group pull-left">
						<input type="text" name="forcenter" id="forcenter" class="form-control" style="width:120px;" readOnly >
					</div>
				</div>
				<button class="btn btn-primary pull-left" id="btn_query"><i class="fa fa-search fa-lg"></i> 查询</button>
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
								<th class="text-center">应用</th>
								<th class="text-center">访问名称</th>
								<th class="text-center">资源中心</th>
								<th class="text-center">所属应用镜像</th>
								<th class="text-center">协议</th>
								<th class="text-center">访问地址</th>
<!-- 								<th class="text-center">创建人</th>
 -->								<th class="text-center">修改人</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody id="appaccessTable">
							
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


<script id="appaccessTable-tmpl" type="text/x-jquery-tmpl">
	{{each(i,row) data}}
		<tr>
			<td class="text-center"><a href="<%=ContextPath%>/dispatch/mc/1041101?id={{= row.access.id}}&pageNum={{= pageNum}}">{{= row.appName}}</a></td>
			<td class="text-center">{{= row.access.accessCode}}</td>
			<td class="text-center">{{= PU.getDropValue("DV_RES_CENTER_CODE",row.access.resCenterId,false)}}</td>
			<td class="text-center">{{= row.imgName}}</td>
			<td class="text-center">{{= PU.getDropValue("V_PC_SERVICE_PROTOCOL",row.access.protocol,false)}}</td>
			<td class="text-center">{{= row.access.accessUrl}}</td>
			<td class="text-center">{{= row.access.modifier}}</td>
			<td class="text-center">
				<a id="btn_del_{{= row.access.id}}" href="###" class="table-link danger" title="删除">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
						</span>
				</a>
			</td>
		</tr>
	{{/each}}
</script>

<jsp:include page="/layout/jsp/footer.jsp"></jsp:include>
