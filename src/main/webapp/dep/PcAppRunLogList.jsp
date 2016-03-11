<%@ page contentType="text/html; charset=utf-8"%>

<%
String ContextPath = request.getContextPath();
%>

<jsp:include page="/layout/jsp/head.jsp"></jsp:include>


<div class="row">
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
								<th class="text-center">操作类型</th>
								<th class="text-center">版本号</th>
								
								<th class="text-center">任务开始时间</th>
								<th class="text-center">任务结束时间</th>
								<th class="text-center">任务状态</th>
								
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody id="appTaskTable">
							
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


<div class="modal fade" id="div_app_log" tabindex="-1" role="dialog" aria-hidden="true">
   <div class="modal-dialog" style="width:800px; min-height: 600px">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="div_title"></h4>
            <input type="hidden" id="lastTime" value = "0">
         </div>
         <div class="modal-body" style=" min-height: 400px">
           <textarea id="logWindow" cols="90%" rows="15%" value="" style="width:768px;border-style: solid;background-color:black;color:white;font-size: 15px;">sadas</textarea>
         </div>
      </div>
	</div>
</div>


<div class="modal fade" id="div_app_all_log" tabindex="-1" role="dialog" aria-hidden="true">
   <div class="modal-dialog" style="width:800px; min-height: 600px">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="div_title"></h4>
         </div>
         <div class="modal-body" style=" min-height: 400px">
         	<div id="appLogTable" class="table-responsive">
         	</div>
           <div id="appLogInfoDiv" ></div>
         </div>
      </div>
	</div>
</div>

<script id="appImageTable-tmpl" type="text/x-jquery-tmpl">
	{{each(i,row) data}}
		<tr>
			<td class="text-center">{{= row.taskUserName}}</td>
			<td class="text-center">{{= row.appVnoId}}</td>
			<td class="text-center">
					{{= CU.toStringDateTime(row.taskStartTime)}}
			<td class="text-center">
					{{= CU.toStringDateTime(row.taskEndTime)}}
			</td>
			

			<td class="text-center deploy">
				{{html PU.getDropValue("V_PC_APP_TASK_STATUS",row.status,true)}}
			</td>



			<td class="text-center">
				<a id="a_app_log_{{= row.id}}" href="###" class="table-link" title="查看日志">
					<span class="fa-stack">
						<i class="fa fa-square fa-stack-2x"></i>
						<i class="fa fa-file-text fa-stack-1x fa-inverse"></i>
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
