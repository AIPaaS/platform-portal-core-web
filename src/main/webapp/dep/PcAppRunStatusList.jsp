<%@ page contentType="text/html; charset=utf-8"%>

<%
String ContextPath = request.getContextPath();
%>

<jsp:include page="/layout/jsp/head.jsp"></jsp:include>
<style>
.table tbody > tr > td:first-child{
font-size: 0.875em;
}
</style>

         	<div id="appLogTable" class="table-responsive">
         	</div>
           <div id="appLogInfoDiv" ></div>

<!-- 正文 -->


<div id="sel_forcenter" style="width:300px;position:absolute;display:none;"></div>



<jsp:include page="/layout/jsp/footer.jsp"></jsp:include>