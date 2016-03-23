<%@ page contentType="text/html; charset=utf-8"%>

<%
String ContextPath = request.getContextPath();

String tdcss = "border:0px;padding-top:2px;padding-bottom:2px;padding-left:0px;padding-right:0px;font-size:16px;font-weight:300;";
String incss = "border:0px;font-size:16px;font-weight:400;width:100%;";
String tdin = "border:0px;font-size:15px;font-weight:300;width:100%;";
String divin = "font-size:15px;font-weight:300;width:100%;";
%>

<jsp:include page="/layout/jsp/head.jsp"></jsp:include>
<jsp:include page="/dep/PcAppImageForm_Header.jsp"></jsp:include>




<!-- 正文 -->
<div id="div_settings">




<!-- 
<div class="row">
	<div class="col-lg-12">
		<div class="main-box clearfix">
			<div class="filter-block">
				<div class="form-group">
					<div class="col-lg-11"><h1><font color="blue">容器定义</font></h1></div>
					<div class="col-lg-1"><a href="###">[编辑]</a></div>
				</div>
				<div class="col-lg-12">
					<table class="table">
						<tbody>
							<tr>
								<td width="10%" style="<%=tdcss%>" align="right">容器名：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value=""></td>
								<td width="10%" style="<%=tdcss%>" align="right">镜像名：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value=""></td>
								<td width="10%" style="<%=tdcss%>" align="right">网络区域：</td>
								<td style="border:0px;padding:0px;"><input type="text" readOnly style="<%=incss%>" value=""></td>
							</tr>
							<tr>
								<td width="10%" style="<%=tdcss%>" align="right">CPU个数：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value=""></td>
								<td width="10%" style="<%=tdcss%>" align="right">内存大小：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value=""></td>
								<td width="10%" style="<%=tdcss%>" align="right">存储大小：</td>
								<td style="border:0px;padding:0px;"><input type="text" readOnly style="<%=incss%>" value=""></td>
							</tr>
							<tr>
								<td width="10%" style="<%=tdcss%>" align="right">容器个数：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value=""></td>
								<td width="10%" style="<%=tdcss%>" align="right">自动伸缩：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value=""></td>
								<td width="10%" style="<%=tdcss%>" align="right">均匀分布：</td>
								<td style="border:0px;padding:0px;"><input type="text" readOnly style="<%=incss%>" value=""></td>
							</tr>
							<tr>
								<td width="10%" style="<%=tdcss%>" align="right">日志目录：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value=""></td>
								<td width="10%" style="<%=tdcss%>" align="right">数据目录：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value=""></td>
								<td width="10%" style="<%=tdcss%>" align="right">容器标签：</td>
								<td style="border:0px;padding:0px;"><input type="text" readOnly style="<%=incss%>" value=""></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
	</div>
</div>




<div class="row">
	<div class="col-lg-12">
		<div class="main-box clearfix">
			<div class="filter-block">
				<div class="form-group">
					<div class="col-lg-11"><h1><font color="blue">开放服务</font></h1></div>
					<div class="col-lg-1"><a href="###">[编辑]</a></div>
				</div>
				<div class="col-lg-12">
					<table class="table">
						<tbody>
							<tr>
								<td width="10%" style="<%=tdcss%>" align="right">开放协议：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value=""></td>
								<td width="10%" style="<%=tdcss%>" align="right">开放URL：</td>
								<td style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value=""></td>
							</tr>
							<tr>
								<td width="10%" style="<%=tdcss%>" align="right">开放端口：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value=""></td>
								<td width="10%" style="<%=tdcss%>" align="right">监测URL：</td>
								<td style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value=""></td>
							</tr>
							<tr>
								<td colspan="4" style="border:0px;padding-left:30px;padding-right:30px;">
									<table class="table">
										<thead>
											<tr>
												<th width="30%" class="text-left">服务参数名</th>
												<th class="text-left">参数描述</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input type="text" readOnly style="<%=tdin%>" value="111"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="222"></td>
											</tr>
											<tr>
												<td><input type="text" readOnly style="<%=tdin%>" value="aaaa"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="jdbc"></td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
	</div>
</div>



<div class="row">
	<div class="col-lg-12">
		<div class="main-box clearfix">
			<div class="filter-block">
				<div class="form-group">
					<div class="col-lg-11"><h1><font color="blue">调用/依赖</font></h1></div>
					<div class="col-lg-1"><a href="###">[编辑]</a></div>
				</div>
				<div class="col-lg-12">
					<table class="table">
						<tbody>
							<tr>
								<td width="10%" style="<%=tdcss%>" align="right">依赖镜像：</td>
								<td style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value=""></td>
							</tr>
							<tr>
								<td colspan="2" style="border:0px;padding-left:30px;padding-right:30px;">
									<table class="table">
										<thead>
											<tr>
												<th class="text-left">调用/依赖服务</th>
												<th class="text-left">关系类型</th>
												<th class="text-left">服务参数名</th>
												<th class="text-left">参数描述</th>
												<th class="text-left">参数别名</th>
												<th class="text-left">参数值</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input type="text" readOnly style="<%=tdin%>" value="111"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="222"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="111"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="222"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="111"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="222"></td>
											</tr>
											<tr>
												<td><input type="text" readOnly style="<%=tdin%>" value="aaaa"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="jdbc"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="aaaa"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="jdbc"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="aaaa"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="jdbc"></td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
	</div>
</div>



<div class="row">
	<div class="col-lg-12">
		<div class="main-box clearfix">
			<div class="filter-block">
				<div class="form-group">
					<div class="col-lg-11"><h1><font color="blue">其他参数</font></h1></div>
					<div class="col-lg-1"><a href="###">[编辑]</a></div>
				</div>
				<div class="col-lg-12">
					<table class="table">
						<tbody>
							<tr>
								<td style="border:0px;padding-left:30px;padding-right:30px;">
									<table class="table">
										<thead>
											<tr>
												<th class="text-left">服务参数名</th>
												<th class="text-left">参数描述</th>
												<th class="text-left">参数值</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input type="text" readOnly style="<%=tdin%>" value="111"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="222"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="222"></td>
											</tr>
											<tr>
												<td><input type="text" readOnly style="<%=tdin%>" value="aaaa"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="jdbc"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="jdbc"></td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
	</div>
</div>


 -->


</div>



<div class="row">
	<div class="col-lg-12">
		<div class="clearfix">
			<div class="filter-block">
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						&nbsp;<button type="submit" id="btn_prev" class="btn btn-success">上一步</button>
						&nbsp;<button type="submit" id="btn_save" class="btn btn-success" data-toggle="tooltip-hide">确认完成</button>
					</div>
				</div>
		</div>
	</div>
	<br>
	<br>
</div>



<script id="div_settings-tmpl" type="text/x-jquery-tmpl">
<div class="row">
	<div class="col-lg-12">
		<div class="main-box clearfix">
			<div class="filter-block">
				<div class="form-group">
					<div class="col-lg-11"><h1><font color="blue">容器定义</font></h1></div>
					<div class="col-lg-1"><a href="<%=ContextPath%>/dispatch/mc/104050102?appId={{= Param_AppId}}&appImageId={{= Param_AppImageId}}&pageNum={{= Param_PageNum}}">[修改]</a></div>
				</div>
				<div class="col-lg-12">
					<table class="table">
						<tbody>
							<tr>
								<td width="10%" style="<%=tdcss%>" align="right">容器名：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value="{{= data.appImage.containerName}}"></td>
								<td width="10%" style="<%=tdcss%>" align="right">镜像名：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value="{{= getImageName(data.image)}}"></td>
								<td width="10%" style="<%=tdcss%>" align="right">网络区域：</td>
								<td style="border:0px;padding:0px;"><input type="text" readOnly style="<%=incss%>" value="{{= PU.getDropValue("DV_NET_ZONE_CODE", data.appImage.netZoneId,false)}}"></td>
							</tr>
							<tr>
								<td width="10%" style="<%=tdcss%>" align="right">CPU个数：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value="{{= data.appImage.cpuCount/100}}"></td>
								<td width="10%" style="<%=tdcss%>" align="right">内存大小：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value="{{= CU.toMegaByteUnit(data.appImage.memSize,false)}}"></td>
								<td width="10%" style="<%=tdcss%>" align="right">存储大小：</td>
								<td style="border:0px;padding:0px;"><input type="text" readOnly style="<%=incss%>" value="{{= CU.toMegaByteUnit(data.appImage.diskSize,false)}}"></td>
							</tr>
							<tr>
								<td width="10%" style="<%=tdcss%>" align="right">容器实例数：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value="{{= data.appImage.instanceCount}}"></td>
								<td width="10%" style="<%=tdcss%>" align="right">自动伸缩：</td>
								<td width="20%" style="<%=tdcss%>"><span style="<%=incss%>">{{html getAutoFlex(data.appImage)}}</span></td>
								<td width="10%" style="<%=tdcss%>" align="right">均匀分布：</td>
								<td style="border:0px;padding:0px;"><input type="text" readOnly style="<%=incss%>" value="{{= PU.getDropValue("V_YES_NO", data.appImage.isUniform,false)}}"></td>
							</tr>
							<tr>
								<td width="10%" style="<%=tdcss%>" align="right">日志目录：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value="{{= data.appImage.logMpPath}}"></td>
								<td width="10%" style="<%=tdcss%>" align="right">数据目录：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value="{{= data.appImage.dataMpPath}}"></td>
								<td width="10%" style="<%=tdcss%>" align="right">容器标签：</td>
								<td style="border:0px;padding:0px;"><input type="text" readOnly style="<%=incss%>" value="{{= data.appImage.targs}}"></td>
							</tr>
							<tr>
								{{if !CU.isEmpty(data.appImage.timerStartTime)}}
									<td width="20%" style="<%=tdcss%>" align="right">定时开始时间：</td>
									<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value="{{= CU.toStringDateTime(data.appImage.timerStartTime)}}"></td>
									<td width="20%" style="<%=tdcss%>" align="right">时间间隔：</td>
									<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value="{{= timeExp(data.appImage.timerExp)}}"></td>
								{{/if}}
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
	</div>
</div>



{{if !CU.isEmpty(data.openSvc)}}
<div class="row">
	<div class="col-lg-12">
		<div class="main-box clearfix">
			<div class="filter-block">
				<div class="form-group">
					<div class="col-lg-11"><h1><font color="blue">开放服务</font></h1></div>
					<div class="col-lg-1"><a href="<%=ContextPath%>/dispatch/mc/104050103?appId={{= Param_AppId}}&appImageId={{= Param_AppImageId}}&pageNum={{= Param_PageNum}}">[编辑]</a></div>
				</div>
				<div class="col-lg-12">
					<table class="table">
						<tbody>
							<tr>
								<td width="10%" style="<%=tdcss%>" align="right">开放协议：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value="{{= PU.getDropValue("V_PC_SERVICE_PROTOCOL",data.openSvc.svc.protocol,false)}}"></td>
								<td width="10%" style="<%=tdcss%>" align="right">开放URL：</td>
								<td style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value="{{= data.openSvc.svc.svcUrl}}"></td>
							</tr>
							<tr>
								<td width="10%" style="<%=tdcss%>" align="right">开放端口：</td>
								<td width="20%" style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value="{{= data.openSvc.svc.port}}"></td>
								<td width="10%" style="<%=tdcss%>" align="right">监测URL：</td>
								<td style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value="{{= data.openSvc.svc.monitorUrl}}"></td>
							</tr>
						{{if !CU.isEmpty(data.openSvc.params)}}
							<tr>
								<td colspan="4" style="border:0px;padding-left:30px;padding-right:30px;">
									<table class="table">
										<thead>
											<tr>
												<th width="30%" class="text-left">服务参数名</th>
												<th class="text-left">参数描述</th>
											</tr>
										</thead>
										<tbody>
										{{each(i,svcparam) data.openSvc.params}}
											<tr>
												<td style="padding-top:2px;padding-bottom:2px;"><input type="text" readOnly style="<%=tdin%>" value="{{= svcparam.kvKey}}"></td>
												<td style="padding-top:2px;padding-bottom:2px;"><input type="text" readOnly style="<%=tdin%>" value="{{= svcparam.keyDesc}}"></td>
											</tr>
										{{/each}}
										</tbody>
									</table>
								</td>
							</tr>
						{{/if}}
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
	</div>
</div>
{{/if}}




{{if !CU.isEmpty(data.dependImages)||!CU.isEmpty(data.callServices)}}
<div class="row">
	<div class="col-lg-12">
		<div class="main-box clearfix">
			<div class="filter-block">
				<div class="form-group">
					<div class="col-lg-11"><h1><font color="blue">调用/依赖</font></h1></div>
					<div class="col-lg-1"><a href="<%=ContextPath%>/dispatch/mc/104050104?appId={{= Param_AppId}}&appImageId={{= Param_AppImageId}}&pageNum={{= Param_PageNum}}">[编辑]</a></div>
				</div>
				<div class="col-lg-12">
					<table class="table">
						<tbody>
						{{if !CU.isEmpty(data.dependImages)}}
							<tr>
								<td width="10%" style="<%=tdcss%>" align="right">依赖容器：</td>
								<td style="<%=tdcss%>"><input type="text" readOnly style="<%=incss%>" value="{{= getDependImagesName(data.dependImages)}}"></td>
							</tr>
						{{/if}}
						{{if !CU.isEmpty(data.callServices)}}
							<tr>
								<td colspan="2" style="border:0px;padding-left:30px;padding-right:30px;">
									<table class="table">
										<thead>
											<tr>
												<th class="text-left" width="30%">调用/依赖服务</th>
												<th class="text-center" style="width:80px;">关系类型</th>
												<th class="text-center" width="10%">服务参数名</th>
												<th class="text-center" width="10%">参数描述</th>
												<th class="text-center" width="10%">参数别名</th>
												<th class="text-center">参数值</th>
											</tr>
										</thead>
										<tbody>
										{{each(i,callsvc) data.callServices}}
											<tr>
												<td><input type="text" readOnly style="<%=tdin%>" title="{{= PU.getDropValue("V_PC_SERVICE_SVC_TYPE", callsvc.svc.svcType,false)}}" value="[{{= callsvc.svc.svcCode}}] {{= callsvc.svc.svcName}}"></td>
												<td class="text-center">{{html PU.getDropValue("V_PC_SERVICE_CALL_TYPE", callsvc.appImgSvc.callType,true)}}</td>
												<td class="text-center">
													{{each(j,callsvcp) callsvc.params}}
														<div style="padding-bottom:5px;"><input type="text" readOnly class="form-control" style="<%=divin%>" value="{{= callsvcp.kvKey}}"></div>
													{{/each}}
												</td>
												<td class="text-center">
													{{each(j,callsvcp) callsvc.params}}
														<div style="padding-bottom:5px;"><input type="text" readOnly class="form-control" style="<%=divin%>" value="{{= callsvcp.keyDesc}}"></div>
													{{/each}}
												</td>
												<td class="text-center">
													{{each(j,callsvcp) callsvc.params}}
														<div style="padding-bottom:5px;"><input type="text" readOnly class="form-control" style="<%=divin%>" value="{{= callsvcp.keyAlias}}"></div>
													{{/each}}
												</td>
												<td class="text-center">
													{{each(j,callsvcp) callsvc.params}}
														<div style="padding-bottom:5px;"><input type="text" readOnly class="form-control" style="<%=divin%>" value="{{= callsvcp.kvVal}}"></div>
													{{/each}}
												</td>
											</tr>
										{{/each}}
										</tbody>
									</table>
								</td>
							</tr>
						{{/if}}
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
	</div>
</div>
{{/if}}



{{if !CU.isEmpty(data.params)}}
<div class="row">
	<div class="col-lg-12">
		<div class="main-box clearfix">
			<div class="filter-block">
				<div class="form-group">
					<div class="col-lg-11"><h1><font color="blue">其他参数</font></h1></div>
					<div class="col-lg-1"><a href="<%=ContextPath%>/dispatch/mc/104050105?appId={{= Param_AppId}}&appImageId={{= Param_AppImageId}}&pageNum={{= Param_PageNum}}">[编辑]</a></div>
				</div>
				<div class="col-lg-12">
					<table class="table">
						<tbody>
							<tr>
								<td style="border:0px;padding-left:30px;padding-right:30px;">
									<table class="table">
										<thead>
											<tr>
												<th width="30%" class="text-left">服务参数名</th>
												<th width="30%" class="text-left">参数描述</th>
												<th class="text-left">参数值</th>
											</tr>
										</thead>
										<tbody>
										{{each(i,p) data.params}}
											<tr>
												<td><input type="text" readOnly style="<%=tdin%>" value="{{= p.kvKey}}"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="{{= p.keyDesc}}"></td>
												<td><input type="text" readOnly style="<%=tdin%>" value="{{= p.kvVal}}"></td>
											</tr>
										{{/each}}
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
	</div>
</div>
{{/if}}


</script>

<jsp:include page="/layout/jsp/footer.jsp"></jsp:include>
