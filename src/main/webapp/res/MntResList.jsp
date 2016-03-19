<%@ page contentType="text/html; charset=utf-8"%>

<%
String ContextPath = request.getContextPath();
%>

<jsp:include page="/layout/jsp/head.jsp"></jsp:include>



<div class="row">
	<div class="col-lg-12">
		<div class="main-box clearfix" style="min-height: 1100px;">
			<div class="tabs-wrapper tabs-no-header">
				<ul class="nav nav-tabs" id="tabs">
					<li id="tab_1" class="active"><a id="btn_myres" href="#tab_mntres" data-toggle="tab"><i class="fa fa-cubes" style="color:#009900;"></i> 我的资源</a></li>
					<li id="tab_2"><a href="#tab_mntapply" data-toggle="tab"><i class="fa fa-file-text-o"></i> 我的申请单</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane fade in active" id="tab_mntres">
						<div class="clearfix">
							<div class="form-group pull-left">
								&nbsp;&nbsp;&nbsp;资源区域：
							</div>
							<div class="form-group pull-left">
								<input type="text" name="forcenter1" id="forcenter1" class="form-control" style="width:200px;" readOnly>
							</div>
						</div>
						<div id="div_mntResList" class="container">

						</div>
					</div>
					<div class="tab-pane fade" id="tab_mntapply">
						<div class="container">
							<div class="row">
								<div class="col-lg-12">
									<div class="main-box clearfix">
										<header class="main-box-header clearfix">
											<div class="filter-block pull-left">
												<div class="form-group pull-left">
													<div class="form-group pull-left">
														&nbsp;&nbsp;&nbsp;资源区域:
													</div>
													<div class="form-group pull-left">
														<input type="text" name="forcenter" id="forcenter" class="form-control" style="width:160px;" readOnly>
													</div>
													<div class="form-group pull-left">
														&nbsp;申请日期:
													</div>
													<div class="form-group pull-left">
														<input type="text" name="cdtApplyTime" id="cdtApplyTime" class="form-control" style="width:160px;" >
													</div>
													<div class="form-group pull-left">
														&nbsp;申请状态:
													</div>
													<div class="form-group pull-left">
														<select type="text" name="cdtStatus" id="cdtStatus" class="form-control" style="width:160px;"></select>
													</div>
												</div>
												<button class="btn btn-primary pull-left" id="btn_query"><i class="fa fa-search fa-lg"></i> 查询</button>
												<a href="###" id="btn_addApply" class="btn btn-primary pull-left"> <i class="fa fa-plus-circle fa-lg"></i>添加</a>
											</div>
										</header>
										<div class="main-box-body clearfix">
											<div class="table-responsive">
												<table class="table">
													<thead>
														<tr>
															<th class="text-center">申请单号</th>
															<th class="text-center">数据中心</th>
															<th class="text-center">资源中心</th>
															<th class="text-center">网络区域</th>
															<th class="text-center">申请配额</th>
															<th class="text-center">申请时间</th>
															<th class="text-center">申请状态</th>
															<th class="text-center">备注</th>
															<th class="text-center">操作</th>
														</tr>
													</thead>
													<tbody id="applyTabList">
														
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

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<div id="sel_forcenter" style="width:300px;position:absolute;display:none;"></div>
<div id="sel_forcenter1" style="width:300px;position:absolute;display:none;"></div>

<script id="div_mntResList-tmpl" type="text/x-jquery-tmpl">
{{each(i,row) data}}
<div class="pull-left" style="padding-right:20px;padding-bottom:20px;">
<div class="main-box clearfix profile-box-stats  pull-left">
	<div class="main-box-body clearfix  pull-left">
		<a href="<%=ContextPath%>/dispatch/mc/1020102?resId={{= row.id}}&dataCenterId={{= row.dataCenterId}}&resCenterId={{= row.resCenterId}}&netZoneId={{= row.netZoneId}}">
		<div class="profile-box-header emerald-bg clearfix" style="padding-top: 15px; padding-bottom: 10px;">
			<h2>{{= dataCenterName}}</h2>
			<div class="job-position">
				<h2>{{= resCenterName}}</h2>
			</div>
			<div class="job-position">
				<h4>{{= netZoneName}}</h4>
			</div>
			<div>
				<h5 style="color: #00FF00;">CPU/内存/存储总额：{{= totalCpuCount/100}}个 / {{= CU.toMegaByteUnit(totalMemSize,false)}} / {{= CU.toMegaByteUnit(totalDiskSize,false)}}</h5>
			</div>
		</div>
		</a>
		<div class="profile-box-footer clearfix"
			style="padding-top: 5px; padding-bottom: 0px;">
			<a> 
				<span class="value" style="color:red;"><strong>{{= cpuCount/100}}个</strong></span> 
				<span class="label">CPU</span>
			</a> 
			<a> <span class="value" style="color:red;"><strong>{{= CU.toMegaByteUnit(memSize,false)}}</strong></span>
				<span class="label">内存</span>
			</a> 
			<a> <span class="value" style="color:red;"><strong>{{= CU.toMegaByteUnit(diskSize,false)}}</strong></span>
				<span class="label">存储</span>
			</a>
		</div>
	</div>
</div>
</div>
{{/each}}
</script>


<script id="applyTabList-tmpl" type="text/x-jquery-tmpl">
	{{each(i,row) data}}
		<tr>
			<td class="text-center">
				{{if row.status==0}}
					<a id="a_apply_{{= row.id}}" href="###">{{= row.code}}</a>
				{{else}}
					{{= row.code}}
				{{/if}}
			</td>
			<td class="text-center">{{= PU.getDropValue("ALL_DV_DATA_CENTER_CODE",row.dataCenterId,false)}}</td>
			<td class="text-center">{{= PU.getDropValue("ALL_DV_RES_CENTER_CODE",row.resCenterId,false)}}</td>
			<td class="text-center">{{= PU.getDropValue("ALL_DV_NET_ZONE_CODE",row.netZoneId,false)}}</td>
			<td class="text-center">
					C: {{= row.cpuCount/100}}，M: {{= CU.toMegaByteUnit(row.memSize)}}，D: {{= CU.toMegaByteUnit(row.diskSize)}}
			</td>
			<td class="text-center">{{= CU.toStringDateTime(row.applyTime)}}</td>
			<td class="text-center">{{html PU.getDropValue("V_PS_RES_APPLY_CHECK_STATUS",row.status,true)}}</td>
			<td class="text-center">{{= row.remark}}</td>
			<td class="text-center">
				{{if row.status==0}}
					<a id="btn_cancel_{{= row.id}}" href="###" class="table-link danger" title="撤销申请单">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
						</span>
					</a>
				{{/if}}
				{{if row.status==1 || row.status==2}}
					<a id="btn_check_view_{{= row.id}}" href="###" class="table-link" title="申请单审批情况">
						<span class="fa-stack">
							<i class="fa fa-square fa-stack-2x"></i>
							<i class="fa fa-search-plus fa-stack-1x fa-inverse"></i>
						</span>
					</a>
				{{/if}}
			</td>
		</tr>
	{{/each}}
</script>



<!-- 弹出框（Modal） -->
<div class="modal fade" id="div_checkView" tabindex="-1" role="dialog" aria-hidden="true">
   <div class="modal-dialog" style="width:600px;">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="div_checkViewTitle">
              	 
            </h4>
         </div>
         <div class="modal-body">
            <table class="table" id="tabCheckView">
				
			</table>
         </div>
      </div>
	</div>
</div>

<script id="tabCheckView-tmpl" type="text/x-jquery-tmpl">
			<tr>
				<td class="text-right" style="width:120px;">审核人：</td>
				<td class="text-left">{{= checkerName}}</td>
			</tr>
			<tr>
				<td class="text-right">审核时间：</td>
				<td class="text-left">{{= CU.toStringDateTime(checkTime)}}</td>
			</tr>
			<tr>
				<td class="text-right">审核意见：</td>
				<td class="text-left">{{html replaceDesc(checkDesc)}}</td>
			</tr>
</script>

<jsp:include page="/layout/jsp/footer.jsp"></jsp:include>
