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
								<th class="text-center">占用资源</th>
								<th class="text-center">容器个数</th>
								<th class="text-center">容器实例数</th>
								<th class="text-center">容器占用资源</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody id="appImageTable">
							
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
<div class="modal fade" id="div_appResUse" tabindex="-1" role="dialog" aria-hidden="true">
   <div class="modal-dialog" style="width:900px;">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="div_title"></h4>
         </div>
         <div class="modal-body">
            <table class="table">
				<thead>
					<tr>
						<th class="text-center">网络区域</th>
						<th class="text-center">应用资源</th>
						<th class="text-center">容器占用资源</th>
						<th class="text-center">剩余资源</th>
					</tr>
				</thead>
				<tbody id="appResUseTable">
					
				</tbody>
			</table>
         </div>
      </div>
	</div>
</div>


<script id="appImageTable-tmpl" type="text/x-jquery-tmpl">
	{{each(i,row) data}}
		<tr>
			<td class="text-center">{{= row.app.appCode}}</td>
			<td class="text-center">{{= row.app.appName}}</td>
			<td class="text-center">{{= PU.getDropValue("DV_DATA_CENTER_CODE",row.app.dataCenterId,false)}}</td>
			<td class="text-center">{{= PU.getDropValue("DV_RES_CENTER_CODE",row.app.resCenterId,false)}}</td>
			<td class="text-center">{{= row.app.versionNo}}</td>
			<td class="text-center">
				{{if !CU.isEmpty(row.totalRes)}}
					<font color='#cc0000'>C: {{= row.totalRes.cpuCount/100}}个，M: {{= CU.toMegaByteUnit(row.totalRes.memSize,false)}}，D: {{= CU.toMegaByteUnit(row.totalRes.diskSize,false)}}</font>
				{{/if}}
			</td>
			<td class="text-center">
				{{if !CU.isEmpty(row.imageTotal)}}
					{{= row.imageTotal.custom1}}
				{{/if}}
			</td>
			<td class="text-center">
				{{if !CU.isEmpty(row.imageTotal)}}
					{{= row.imageTotal.instanceCount}}
				{{/if}}
			</td>
			<td class="text-center">
				{{if !CU.isEmpty(row.imageTotal)}}
					<font color='#cc0000'>C: {{= row.imageTotal.cpuCount/100}}个，M: {{= CU.toMegaByteUnit(row.imageTotal.memSize,false)}}，D: {{= CU.toMegaByteUnit(row.imageTotal.diskSize,false)}}</font>
				{{/if}}
			</td>
			<td class="text-center">
				<a id="a_app_image_setup_{{= row.app.id}}" href="###" class="table-link" data-placement="left" data-title="选择应用版本" title="镜像容器配置" >
					<span class="fa-stack">
						<i class="fa fa-square fa-stack-2x"></i>
						<i class="fa fa-life-saver fa-stack-1x fa-inverse"></i>
					</span>
				</a>	
				<a id="a_app_res_use_{{= row.app.id}}" href="###" class="table-link" title="应用资源占用情况">
					<span class="fa-stack">
						<i class="fa fa-square fa-stack-2x"></i>
						<i class="fa fa-star-half-o fa-stack-1x fa-inverse"></i>
					</span>
				</a>			
			</td>
		</tr>
{{/each}}
</script>

<script id="appResUseTable-tmpl" type="text/x-jquery-tmpl">
	{{each(i,row) data}}
		<tr>
			<td class="text-center">
				{{if row.FLAG_SUMMARY===true}}
					<font color="blue">合计</font>
				{{else}}
					{{= getNetZoneName(row.totalRes.netZoneId)}}
				{{/if}}
			</td>
			<td class="text-center">
				<font color='#cc0000'>C: {{= row.totalRes.cpuCount/100}}个，M: {{= CU.toMegaByteUnit(row.totalRes.memSize,false)}}，D: {{= CU.toMegaByteUnit(row.totalRes.diskSize,false)}}</font>
			</td>
			<td class="text-center">
				{{if row.FLAG_SUMMARY===true}}
					<font color='#0000ff'>C: {{= row.imageTotal.cpuCount/100}}个，M: {{= CU.toMegaByteUnit(row.imageTotal.memSize,false)}}，D: {{= CU.toMegaByteUnit(row.imageTotal.diskSize,false)}}</font>
				{{else}}
					{{if !CU.isEmpty(row.imageList)}}
						{{each(j,img) row.imageList}}
							{{if j>0}}
								<br>
							{{/if}}
							<font color='#0000ff'>C: {{= img.cpuCount/100}}个，M: {{= CU.toMegaByteUnit(img.memSize,false)}}，D: {{= CU.toMegaByteUnit(img.diskSize,false)}}</font>
						{{/each}}
					{{else}}
						<font color='#0000ff'>C: 0个，M: 0M，D: 0M</font>
					{{/if}}
				{{/if}}
			</td>
			<td class="text-center">
				<font color='#008800'>C: {{= row.residueRes.cpuCount/100}}个，M: {{= CU.toMegaByteUnit(row.residueRes.memSize,false)}}，D: {{= CU.toMegaByteUnit(row.residueRes.diskSize,false)}}</font>
			</td>
		</tr>
{{/each}}
</script>




<jsp:include page="/layout/jsp/footer.jsp"></jsp:include>
