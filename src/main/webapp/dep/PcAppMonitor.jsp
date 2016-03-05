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
								<th class="text-center">应用版本</th>
								<th class="text-center">容器名</th>
								<th class="text-center">数据中心</th>
								<th class="text-center">资源中心</th>
								<th class="text-center">网络区域</th>
								<th class="text-center">镜像名</th>
								<th class="text-center">监控信息</th>
							</tr>
						</thead>
						<tbody id="appMonitorTable">
							
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
<div class="modal fade" id="div_dep_instance" tabindex="-1" role="dialog" aria-hidden="true">
   <div class="modal-dialog" style="width:800px;">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="div_depInstanceTitle"></h4>
         </div>
         <div class="modal-body">
            <table class="table">
				<thead>
					<tr>
						<th class="text-center">服务器IP</th>
						<th class="text-center">实例名</th>
						<th class="text-center">状态</th>
						<th class="text-center">状态时间</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<tbody id="depInstanceTable">
					
				</tbody>
				
			</table>
         </div>
         <div class="row-fluid">
					<div class="col-lg-6">
						
					</div>
					<div class="col-lg-6">
						<div class="pagination pull-right" id="mod_pagination_box">
							<ul id="mod_ul_pagination" class="pagination-sm"></ul>
						</div>
					</div>
				</div>
         <iframe id="if_montior_dockerinstance" frameborder="0" width="795" height="400" src="<%=ContextPath%>/dep/PcAppMonitorEmpty.jsp"></iframe>
      </div>
	</div>
</div>

<script id="appMonitorTable-tmpl" type="text/x-jquery-tmpl">
	{{each(i,row) data}}
		<tr>
			<td class="text-center">{{= row.appCode}}</a></td>
			<td class="text-center">{{= row.appName}}</td>
			<td class="text-center">{{= row.appVersionNo}}</td>
			<td class="text-center">{{= row.containerName}}</td>
			<td class="text-center">{{= PU.getDropValue("DV_DATA_CENTER_CODE",row.dataCenterId,false)}}</td>
			<td class="text-center">{{= PU.getDropValue("DV_RES_CENTER_CODE",row.resCenterId,false)}}</td>
			<td class="text-center">{{= PU.getDropValue("DV_NET_ZONE_CODE",row.netZoneId,false)}}</td>
			<td class="text-center">{{= row.imageName}}</td>
			<td class="text-center">
				<a id="a_monitor_history_{{= row.id}}" href="###" class="table-link" title="监控信息">
					<span class="fa-stack">
						<i class="fa fa-square fa-stack-2x"></i>
						<i class="fa fa-comment fa-stack-1x fa-inverse"></i>
					</span>
				</a>	
			</td>
		</tr>
{{/each}}
</script>

<script id="depInstanceTable-tmpl" type="text/x-jquery-tmpl">
	{{each(i,row) data}}
		<tr>
			<td class="text-center">{{= row.serverIp}}</a></td>
			<td class="text-center">{{= row.instanceName}}</td>
			<td class="text-center">{{= PU.getDropValue("V_IS_VALID",row.status,false)}}</td>
			<td class="text-center">{{= CU.toStringDateTime(row.time)}}</td>
			<td class="text-center">
				<a id="a_forward2monitorinstance_{{= row.id}}" href="###" class="table-link" title="">
					<span class="fa-stack">
						<i class="fa fa-square fa-stack-2x"></i>
						<i class="fa fa-hand-o-right fa-stack-1x fa-inverse"></i>
					</span>
				</a>
			</td>
		</tr>
{{/each}}
</script>




<jsp:include page="/layout/jsp/footer.jsp"></jsp:include>
