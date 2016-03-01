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
					<div class="form-group pull-left">
						&nbsp;&nbsp;&nbsp;&nbsp;服务代码:
					</div>
					<div class="form-group pull-left">
						<input type="text" name="svcCode" id="svcCode" class="form-control" style="width:120px;">
					</div>
					<div class="form-group pull-left">
						服务名称:
					</div>
					<div class="form-group pull-left">
						<input type="text" name="svcName" id="svcName" class="form-control" style="width:120px;">
					</div>
					<div class="form-group pull-left">
						资源中心:
					</div>
					<div class="form-group pull-left">
						<input type="text" name="forcenter" id="forcenter" class="form-control" style="width:120px;" readOnly >
					</div>
				</div>
				<button class="btn btn-primary pull-left" id="btn_query"><i class="fa fa-search fa-lg"></i> 查询</button>
				<button id="btn_add" href="###" class="btn btn-primary pull-left"> <i class="fa fa-plus-circle fa-lg"></i> 添加</button>
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
								<th class="text-center">服务代码</th>
								<th class="text-center">服务名称</th>
								<th class="text-center">数据中心</th>
								<th class="text-center">资源中心</th>
								<th class="text-center">开放协议</th>
								<th class="text-center">开放端口</th>
								<th class="text-left">开放URL</th>
								<th class="text-center">参数</th>
							</tr>
						</thead>
						<tbody id="externalSvcTable">
							
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


<!-- 弹出框（Modal） -->
<div class="modal fade" id="div_compTags" tabindex="-1" role="dialog" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="div_SvcParamsTitle"></h4>
         </div>
         <div class="modal-body">
            <table class="table">
				<thead>
					<tr>
						<th class="text-center">参数名</th>
						<th class="text-center">参数描述</th>
						<th class="text-center">
							<a id="a_add_param" href="###" class="table-link" title="添加参数">
								<span class="fa-stack">
									<i class="fa fa-square fa-stack-2x"></i>
									<i class="fa fa-plus fa-stack-1x fa-inverse"></i>
								</span>
							</a>
						</th>
					</tr>
				</thead>
				<tbody id="SvcParamsTable">
					
				</tbody>
				
			</table>
			<div class="modal-footer" >
	        <button id="btn_Ok" type="button" class="btn btn-success ok" data-toggle="tooltip-hide" data-placement="left"><i class="fa fa-save fa-lg"></i> 保存</button>
      	</div>
         </div>
      </div>
	</div>
</div>

<script id="externalSvcTable-tmpl" type="text/x-jquery-tmpl">
	{{each(i,row) data}}
		<tr>
			<td class="text-center"><a href="<%=ContextPath%>/dispatch/mc/1040401?id={{= row.id}}&pageNum={{= pageNum}}">{{= row.svcCode}}</a></td>
			<td class="text-center">{{= row.svcName}}</td>
			<td class="text-center">{{= PU.getDropValue("DV_DATA_CENTER_CODE",row.dataCenterId,false)}}</td>
			<td class="text-center">{{= PU.getDropValue("DV_RES_CENTER_CODE",row.resCenterId,false)}}</td>
			<td class="text-center">{{= PU.getDropValue("V_PC_SERVICE_PROTOCOL",row.protocol,false)}}</td>
			<td class="text-center">{{= row.port}}</td>
			<td class="text-left">{{= row.svcUrl}}</td>
			<td class="text-center">
				<a id="a_svc_params_{{= row.id}}" href="###" class="table-link" title="参数详情">
					<span class="fa-stack">
						<i class="fa fa-square fa-stack-2x"></i>
						<i class="fa fa-asterisk fa-stack-1x fa-inverse"></i>
					</span>
				</a>
			</td>
		</tr>
{{/each}}
</script>

<jsp:include page="/layout/jsp/footer.jsp"></jsp:include>
