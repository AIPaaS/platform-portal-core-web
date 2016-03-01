<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="com.binary.core.util.BinaryUtils"%>

<%
String ContextPath = request.getContextPath();
String appId = request.getParameter("appId");
String appVnoId = request.getParameter("appVnoId");
String appImageId = request.getParameter("appImageId");
String pageNum = request.getParameter("pageNum");

String params = null;
if(!BinaryUtils.isEmpty(appId) && !BinaryUtils.isEmpty(appImageId) && !BinaryUtils.isEmpty(appVnoId)) {
	params = "&appId="+appId+"&appVnoId="+appVnoId+"&appImageId="+appImageId;
	if(!BinaryUtils.isEmpty(pageNum)) params += "&pageNum="+pageNum;
}

String setupName1 = params==null ? "容器定义" : "<a id=\"PBS_link_1\" href=\""+ContextPath+"/dispatch/mc/104050102?1=1"+params+"\" title=\"容器定义\">容器定义</a>";
String setupName2 = params==null ? "开放服务" : "<a id=\"PBS_link_2\" href=\""+ContextPath+"/dispatch/mc/104050103?1=1"+params+"\" title=\"开放服务\">开放服务</a>";
String setupName3 = params==null ? "调用/依赖" : "<a id=\"PBS_link_3\" href=\""+ContextPath+"/dispatch/mc/104050104?1=1"+params+"\" title=\"调用/依赖\">调用/依赖</a>";
String setupName4 = params==null ? "其他参数" : "<a id=\"PBS_link_4\" href=\""+ContextPath+"/dispatch/mc/104050105?1=1"+params+"\" title=\"其他参数\">其他参数</a>";
String setupName5 = params==null ? "完成确认" : "<a id=\"PBS_link_5\" href=\""+ContextPath+"/dispatch/mc/104050106?1=1"+params+"\" title=\"完成确认\">完成确认</a>";
%>



<div class="row">
	<div class="col-lg-12">
		<div class="main-box-body clearfix">
			<div id="myWizard" class="wizard">
				<div class="wizard-inner">
					<ul class="steps">
						<li id="PBS_setup_1"><span id="PBS_badge_1" class="badge">1</span>
							<%=setupName1%>
							<span class="chevron"></span>
						</li>
						<li id="PBS_setup_2"><span id="PBS_badge_2" class="badge">2</span>
							<%=setupName2%>
							<span class="chevron"></span>
						</li>
						<li id="PBS_setup_3"><span id="PBS_badge_3" class="badge">3</span>
							<%=setupName3%>
							<span class="chevron"></span
							>
						</li>
						<li id="PBS_setup_4"><span id="PBS_badge_4" class="badge">4</span>
							<%=setupName4%>
							<span class="chevron"></span>
						</li>
						<li id="PBS_setup_5"><span id="PBS_badge_5" class="badge">5</span>
							<%=setupName5%>
							<span class="chevron"></span>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
function setPageHeaderSetupNum(num) {
	if(typeof(num)=="string") num = parseInt(num, 10);
	if(num == 9) num = 5;
	for(var i=1; i<=num; i++) {
		if(i < num) {
			$("#PBS_badge_"+i).addClass("badge-success");
			$("#PBS_setup_"+i).addClass("active");
		}else {
			$("#PBS_badge_"+i).addClass("badge-danger");
		}
	}
}
</script>
