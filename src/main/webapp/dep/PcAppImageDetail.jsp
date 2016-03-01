<%@ page contentType="text/html; charset=utf-8"%>

<%
String ContextPath = request.getContextPath();
%>

<jsp:include page="/layout/jsp/head.jsp"></jsp:include>



<!-- 正文 -->
<div class="row">
	<div class="col-lg-12">
		<header class="pull-left clearfix">
			<h4>
				<strong>应用<font color="red"><span id="span_app_title"></span></font> 容器定义清单</strong>
				<span style="padding-left:20px;">&nbsp;</span>
				所在资源中心：<font color="blue"><span id="span_res_title"></span></font>
			</h4>
		</header>
		<span class="pull-left" style="padding-left:20px;">&nbsp;</span>
		<button id="btn_add" class="btn btn-primary pull-left"><i class="fa fa-plus-circle fa-lg"></i> 添加容器</button>
	</div>
</div>
<br>


<div id="appImageDetailTable" class="row">
	

	
</div>	


<script id="appImageDetailTable-tmpl" type="text/x-jquery-tmpl">
{{each(i,row) data}}
<div class="col-lg-3 col-sm-6 col-xs-12">
		<div class="main-box infographic-box" style="padding-top:10px;padding-bottom:10px;">
			<i class="fa fa-life-saver {{= titlebg}}"></i>
			<span class="value">
				{{if row.appImage.setupNum==1}}
					<a href="<%=ContextPath%>/dispatch/mc/104050103?appId={{= row.appImage.appId}}&appVnoId={{= row.appImage.appVnoId}}&appImageId={{= row.appImage.id}}" title="{{= row.appImage.containerFullName}}">
				{{else row.appImage.setupNum==2}}
					<a href="<%=ContextPath%>/dispatch/mc/104050104?appId={{= row.appImage.appId}}&appVnoId={{= row.appImage.appVnoId}}&appImageId={{= row.appImage.id}}" title="{{= row.appImage.containerFullName}}">
				{{else row.appImage.setupNum==3}}
					<a href="<%=ContextPath%>/dispatch/mc/104050105?appId={{= row.appImage.appId}}&appVnoId={{= row.appImage.appVnoId}}&appImageId={{= row.appImage.id}}" title="{{= row.appImage.containerFullName}}">
				{{else row.appImage.setupNum==4}}
					<a href="<%=ContextPath%>/dispatch/mc/104050106?appId={{= row.appImage.appId}}&appVnoId={{= row.appImage.appVnoId}}&appImageId={{= row.appImage.id}}" title="{{= row.appImage.containerFullName}}">
				{{else}}
					<a href="<%=ContextPath%>/dispatch/mc/104050102?appId={{= row.appImage.appId}}&appVnoId={{= row.appImage.appVnoId}}&appImageId={{= row.appImage.id}}" title="{{= row.appImage.containerFullName}}">
				{{/if}}
				{{= row.appImage.containerName}}</a></span>
			<span class="headline"><font color="">{{= PU.getDropValue("DV_NET_ZONE_CODE",row.appImage.netZoneId,false)}}</font> <font color="#cc0000" style="font-size:13px;">C:{{= row.appImage.cpuCount/100}}，M:{{= CU.toMegaByteUnit(row.appImage.memSize,false)}}，D:{{= CU.toMegaByteUnit(row.appImage.diskSize,false)}}</font>
				&nbsp;<a id="a_remove_app_image_{{= row.appImage.id}}" href="###" class="fa fa-times" style="color:#FF0000;"></a></span>
		</div>
</div>
{{/each}}
</script>





<jsp:include page="/layout/jsp/footer.jsp"></jsp:include>
