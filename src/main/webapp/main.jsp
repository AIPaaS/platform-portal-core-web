<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="com.binary.framework.web.SessionKey,com.binary.framework.bean.User"%>

<%
String ContextPath = request.getContextPath();
User user = (User)session.getAttribute(SessionKey.SYSTEM_USER);

if(user == null) {
	response.sendRedirect(ContextPath+"/index.jsp");
	return ;
}

Long userId = user.getId();
%>

<!doctype html>
<html>
<head>
<title>EBDP-SDAS-CONSOLE Main</title>
<script type="text/javascript">
var ContextPath = "<%=ContextPath%>";

function forward2ModuCode(mc) {
	var url = ContextPath + "/dispatch/mc/"+mc;
	forward(url);
}

function forward(url) {
	document.getElementById("if_page").src = url + "?PARENT_SID=<%=userId%>&ParentLeftWidth=220&ParentHeaderHeight=50&d="+new Date().getTime();
}


</script>
</head>

<body>

<table>
<tr>
	<td colspan="2">
	&nbsp;
	</td>
</tr>
<tr>
	<td width="300" valign="top">
		<table>
			<tr>
				<td>
					<span style="padding-left:20px;">资源管理</span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2ModuCode('10201')">租户资源配额</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2ModuCode('10202')">应用资源审批</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2ModuCode('10203')">资源使用情况</a></span><br>
				</td>
			</tr>
			<tr>
				<td>
					<span style="padding-left:20px;">部署管理</span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2ModuCode('10401')">应用定义</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2ModuCode('10402')">应用资源管理</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2ModuCode('10403')">平台服务申请</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2ModuCode('10404')">外部服务管理</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2ModuCode('10405')">应用部署配置</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2ModuCode('10406')">应用运行管理</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2ModuCode('10407')">应用运行监控</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2ModuCode('10408')">应用定时运行</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2ModuCode('10410')">镜像服务管理</a></span><br>
				</td>
			</tr>
		</table>
	</td>
	<td align="center">
		<iframe id="if_page" frameborder='1' width='900' height='600' src="###"></iframe>
	</td>
</tr>
</table>

<br>
<br>

</body>

</html>
