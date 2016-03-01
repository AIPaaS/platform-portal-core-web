<%@ page contentType="text/html; charset=utf-8"%>

<%
String ContextPath = request.getContextPath();
%>

<jsp:include page="/layout/jsp/head.jsp"></jsp:include>



<!-- 正文 -->
<div id="div_res_content" >


</div>



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



<script id="div_res_content-tmpl" type="text/x-jquery-tmpl">
{{each(i,row) data}}
<div class="row">
	<div class="col-lg-12">
		<header class="pull-left clearfix">
			<h2>
				资源中心 <font color="blue">[{{= PU.getDropValue("DV_DATA_CENTER_CODE",row.dataCenterId,false)}}] - [{{= PU.getDropValue("DV_RES_CENTER_CODE",row.resCenterId,false)}}]</font> 应用资源占用情况
			</h2>
		</header>
	</div>
</div>
<div class="row">
	{{each(j,info) row.apps}}
			<div class="col-lg-3 col-sm-6 col-xs-12">
				<div class="main-box infographic-box" >
					<i class="fa {{= info.icon}} {{= info.titlebg}}"></i>
					<span class="value"><a id="a_app_res_use_{{= info.app.id}}" href="###" title="{{= info.app.appCode}}">{{= info.app.appName}}</a></span>
					<span class="headline">
						占用： <font color="#cc0000">
							{{if !CU.isEmpty(info.totalRes)}}
								C:{{= info.totalRes.cpuCount/100}}，M:{{= CU.toMegaByteUnit(info.totalRes.memSize,false)}}，D:{{= CU.toMegaByteUnit(info.totalRes.diskSize,false)}}
							{{else}}
								C:0，M:0M，D:0M
							{{/if}}
						</font>
					</span>
					<span class="headline">剩余： <font color="#008800">
						C:{{= info.residueRes.cpuCount/100}}，M:{{= CU.toMegaByteUnit(info.residueRes.memSize,false)}}，D:{{= CU.toMegaByteUnit(info.residueRes.diskSize,false)}}</font>
					</span>
				</div>
			</div>
	{{/each}}
</div>
<br>
{{/each}}
</script>


<script id="appResUseTable-tmpl" type="text/x-jquery-tmpl">
	{{each(i,row) data}}
		<tr>
			<td class="text-center">
				{{if row.FLAG_SUMMARY===true}}
					<font color="blue">合计</font>
				{{else}}
					{{if !CU.isEmpty(row.totalRes)}}
						{{= getNetZoneName(row.totalRes.netZoneId)}}
					{{/if}}
				{{/if}}
			</td>
			<td class="text-center">
				<font color='#cc0000'>
					{{if !CU.isEmpty(row.totalRes)}}
							C: {{= row.totalRes.cpuCount/100}}个，M: {{= CU.toMegaByteUnit(row.totalRes.memSize,false)}}，D: {{= CU.toMegaByteUnit(row.totalRes.diskSize,false)}}
					{{else}}
							C:0个，M:0M，D:0M
					{{/if}}
				</font>
			</td>
			<td class="text-center">
				{{if row.FLAG_SUMMARY===true}}
					<font color='#0000ff'>
						{{if !CU.isEmpty(row.imageTotal)}}
							C: {{= row.imageTotal.cpuCount/100}}个，M: {{= CU.toMegaByteUnit(row.imageTotal.memSize,false)}}，D: {{= CU.toMegaByteUnit(row.imageTotal.diskSize,false)}}
						{{else}}
							C:0个，M:0M，D:0M
						{{/if}}
					</font>
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
