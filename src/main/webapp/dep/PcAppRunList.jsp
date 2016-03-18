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
					<div class="form-group pull-left">
						&nbsp;状态:
					</div>
					<div class="form-group pull-left">
						<select type="text" name="status" id="status" class="form-control" style="width:100px;"  ></select>
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
								<th class="text-center">版本号</th>
								<th class="text-center">应用状态</th>
								
								<th class="text-center">最近任务开始时间</th>
								<th class="text-center">最近任务结束时间</th>
								<th class="text-center">最近任务状态</th>
								
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

<div class="modal fade" id="div_app_log" tabindex="-1" role="dialog" aria-hidden="true">
   <div class="modal-dialog" style="width:800px; min-height: 600px">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="div_title"></h4>
            <input type="hidden" id="lastTime" value = "1">
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
			<td class="text-center">{{= row.app.appCode}}</td>
			<td class="text-center">{{= row.app.appName}}</td>
			<td class="text-center">{{= PU.getDropValue("DV_DATA_CENTER_CODE",row.app.dataCenterId,false)}}</td>
			<td class="text-center">{{= PU.getDropValue("DV_RES_CENTER_CODE",row.app.resCenterId,false)}}</td>
			<td class="text-center">{{= row.app.versionNo}}</td>
			<td class="text-center deploy">
				{{html PU.getDropValue("V_PC_APP_STATUS",row.app.status,true)}}
			</td>


			<td class="text-center">
				{{if !CU.isEmpty(row.lastTask)}}
					{{= CU.toStringDateTime(row.lastTask.taskStartTime)}}
				{{/if}}
			<td class="text-center">
				{{if !CU.isEmpty(row.lastTask)}}
					{{= CU.toStringDateTime(row.lastTask.taskEndTime)}}
				{{/if}}
			</td>
			<td class="text-center">
				{{if !CU.isEmpty(row.lastTask)}}
					{{html PU.getDropValue("V_PC_APP_TASK_STATUS",row.lastTask.status,true)}}
				{{/if}}
			</td>

			<td class="text-center">
				
				{{if  row.app.status ==1 }}
					<a id="a_app_start_{{= row.app.id}}" href="###" class="table-link" data-placement="left" title="启动">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-play fa-stack-1x fa-inverse"></i>
						</span>
					</a>	
					<a id="a_app_destory_{{= row.app.id}}" style="display:none;" href="###" class="table-link danger" title="销毁">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-stop fa-stack-1x fa-inverse"></i>
						</span>
					</a>
					<a id="a_app_loading_{{= row.app.id}}" style="display:none;" href="###" class="table-link danger loader" data-placement="left" title="启动">
						<image src="<%= ContextPath%>/layout/img/ajax-loader.gif" />
					</a>	
					<a id="a_app_open_{{= row.app.id}}" href="###" style="display:none;" class="table-link" data-placement="left" title="启动">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-play-circle fa-stack-1x fa-inverse"></i>
						</span>
					</a>	
					<a id="a_app_pause_{{= row.app.id}}" href="###" style="display:none;" class="table-link" data-placement="left" title="暂停">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-pause fa-stack-1x fa-inverse"></i>
						</span>
					</a>	
					<a id="a_app_update_{{= row.app.id}}"  style="display:none;" href="###" class="table-link" title="升级">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-refresh fa-stack-1x fa-inverse"></i>
						</span>
					</a>
				{{else row.app.status == 2 }}
						<a id="a_app_start_{{= row.app.id}}" style="display:none;" href="###" class="table-link" data-placement="left" title="启动">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-play fa-stack-1x fa-inverse"></i>
						</span>
					</a>	
					<a id="a_app_destory_{{= row.app.id}}" style="display:none;" href="###" class="table-link danger" title="销毁">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-stop fa-stack-1x fa-inverse"></i>
						</span>
					</a>
					<a id="a_app_loading_{{= row.app.id}}"  href="###" class="table-link danger loader" data-placement="left" title="启动">
						<image src="<%= ContextPath%>/layout/img/ajax-loader.gif" />
					</a>	
					<a id="a_app_open_{{= row.app.id}}" href="###" style="display:none;" class="table-link" data-placement="left" title="启动">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-play-circle fa-stack-1x fa-inverse"></i>
						</span>
					</a>	
					<a id="a_app_pause_{{= row.app.id}}" href="###" style="display:none;" class="table-link" data-placement="left" title="暂停">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-pause fa-stack-1x fa-inverse"></i>
						</span>
					</a>	
					<a id="a_app_update_{{= row.app.id}}"  style="display:none;" href="###" class="table-link" title="升级">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-refresh fa-stack-1x fa-inverse"></i>
						</span>
					</a>

				{{else row.app.status == 3  }}

					<a id="a_app_start_{{= row.app.id}}" href="###" style="display:none;" class="table-link" data-placement="left" title="启动">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-play fa-stack-1x fa-inverse"></i>
						</span>
					</a>	
					<a id="a_app_destory_{{= row.app.id}}" href="###"  class="table-link danger" title="销毁">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-stop fa-stack-1x fa-inverse"></i>
						</span>
					</a>
					<a id="a_app_loading_{{= row.app.id}}" style="display:none;" href="###" class="table-link danger loader" data-placement="left" title="启动">
						<image src="<%= ContextPath%>/layout/img/ajax-loader.gif" />
					</a>	
					<a id="a_app_open_{{= row.app.id}}" href="###" style="display:none;" class="table-link" data-placement="left" title="启动">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-play-circle fa-stack-1x fa-inverse"></i>
						</span>
					</a>	
					<a id="a_app_pause_{{= row.app.id}}" href="###" class="table-link" data-placement="left" title="暂停">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-pause fa-stack-1x fa-inverse"></i>
						</span>
					</a>	
					<a id="a_app_update_{{= row.app.id}}"   href="###" class="table-link" title="升级">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-refresh fa-stack-1x fa-inverse"></i>
						</span>
					</a>

				{{else row.app.status == 4  }}
	
				<a id="a_app_destory_{{= row.app.id}}" href="###" class="table-link danger" title="销毁">
					<span class="fa-stack">
						<i class="fa fa-square fa-stack-2x"></i>
						<i class="fa fa-stop fa-stack-1x fa-inverse"></i>
					</span>
				</a>
				<a id="a_app_start_{{= row.app.id}}"  style="display:none;" href="###" class="table-link" data-placement="left" title="开始部署">
					<span class="fa-stack">
						<i class="fa fa-square fa-stack-2x"></i>
						<i class="fa fa-play fa-stack-1x fa-inverse"></i>
					</span>
				</a>	
					<a id="a_app_loading_{{= row.app.id}}" style="display:none;" href="###" class="table-link danger loader" data-placement="left" title="启动">
						<image src="<%= ContextPath%>/layout/img/ajax-loader.gif" />
					</a>	
				<a id="a_app_open_{{= row.app.id}}" href="###" class="table-link" data-placement="left" title="启动应用">
					<span class="fa-stack">
						<i class="fa fa-square fa-stack-2x"></i>
						<i class="fa fa-play-circle fa-stack-1x fa-inverse"></i>
					</span>
				</a>	
					<a id="a_app_pause_{{= row.app.id}}" href="###" style="display:none;" class="table-link" data-placement="left" title="暂停">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-pause fa-stack-1x fa-inverse"></i>
						</span>
					</a>	
				<a id="a_app_update_{{= row.app.id}}" href="###" class="table-link" title="升级">
					<span class="fa-stack">
						<i class="fa fa-square fa-stack-2x"></i>
						<i class="fa fa-refresh fa-stack-1x fa-inverse"></i>
					</span>
				</a>
				{{else row.app.status == 5  }}
					<a id="a_app_start_{{= row.app.id}}" href="###" style="display:none;" class="table-link" data-placement="left" title="启动">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-play fa-stack-1x fa-inverse"></i>
						</span>
					</a>	
					<a id="a_app_destory_{{= row.app.id}}"  href="###" class="table-link danger" title="销毁">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-stop fa-stack-1x fa-inverse"></i>
						</span>
					</a>
					<a id="a_app_loading_{{= row.app.id}}" style="display:none;" href="###" class="table-link danger loader" data-placement="left" title="启动">
						<image src="<%= ContextPath%>/layout/img/ajax-loader.gif" />
					</a>	
					<a id="a_app_open_{{= row.app.id}}" href="###" style="display:none;" class="table-link" data-placement="left" title="启动">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-play-circle fa-stack-1x fa-inverse"></i>
						</span>
					</a>	
					<a id="a_app_pause_{{= row.app.id}}" href="###" style="display:none;" class="table-link" data-placement="left" title="暂停">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-pause fa-stack-1x fa-inverse"></i>
						</span>
					</a>	
					<a id="a_app_update_{{= row.app.id}}"  style="display:none;" href="###" class="table-link" title="升级">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-refresh fa-stack-1x fa-inverse"></i>
						</span>
					</a>
				
				{{/if}}
				<a id="a_app_log_{{= row.app.id}}" href="###" class="table-link" title="查看日志">
					<span class="fa-stack">
						<i class="fa fa-square fa-stack-2x"></i>
						<i class="fa fa-file-text fa-stack-1x fa-inverse"></i>
					</span>
				</a>		
				
				<a id="a_app_status_{{= row.app.id}}" href="###" class="table-link" title="查看">
					<span class="fa-stack">
						<i class="fa fa-building fa-stack-2x"></i>
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
