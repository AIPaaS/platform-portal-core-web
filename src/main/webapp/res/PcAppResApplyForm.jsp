<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="com.binary.core.util.BinaryUtils"%>

<%
String ContextPath = request.getContextPath();
%>

<jsp:include page="/layout/jsp/head.jsp"></jsp:include>


<!-- 正文 -->
<div class="main-box">
	<header class="main-box-header clearfix">
		<h4 class="pull-left" id="div_head_title"></h4>
	</header>
	<br>
	<div class="main-box-body clearfix">
		<form class="form-horizontal" role="form" id="formResApply">
			<div class="form-group">
				<label for="resCenterId" class="col-lg-2 control-label">网络区域<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<select type="text" name="netZoneId"  required class="form-control" id="netZoneId" ></select>
				</div>
				<div class="col-lg-5">
					
				</div>
			</div>
			<div class="form-group">
				<label for="cpuCount" class="col-lg-2 control-label">CPU个数<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="cpuCount" required maxLength=8 class="form-control" id="cpuCount" pattern="[0-9\\.]{1,8}" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="memSize" class="col-lg-2 control-label">内存大小<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="memSize" required maxLength=8 class="form-control" id="memSize"  pattern="[0-9]{1,8}" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span>单位:M</span>
				</div>
			</div>
			<div class="form-group">
				<label for="diskSize" class="col-lg-2 control-label">存储大小:</label>
				<div class="col-lg-5">
					<input type="text" name="diskSize" maxLength=8 class="form-control" id="diskSize" pattern="[0-9]{1,8}">
				</div>
				<div class="col-lg-5">
					<span>单位:G</span>
				</div>
			</div>
			<div class="form-group">
				<label for="remark" class="col-lg-2 control-label">备注:</label>
				<div class="col-lg-5">
					<textarea name="remark" rows="3" cols="3" class="form-control" id="remark" maxlength="100" placeholder=""></textarea>
				</div>
				<div class="col-lg-5">
					<span>1-200位</span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<button type="submit" id="btn_submit" class="btn btn-success">提交</button>
				</div>
			</div>
		</form>
	</div>
</div>

<jsp:include page="/layout/jsp/footer.jsp"></jsp:include>
