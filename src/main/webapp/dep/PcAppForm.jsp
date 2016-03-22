<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="com.binary.core.util.BinaryUtils"%>

<%
String ContextPath = request.getContextPath();
%>

<jsp:include page="/layout/jsp/head.jsp"></jsp:include>


<!-- 正文 -->
<div class="main-box">
	<header class="main-box-header clearfix"> </header>
	<div class="main-box-body clearfix">
		<form class="form-horizontal" role="form" id="form_app">
			<div class="form-group">
				<label for="appCode" class="col-lg-2 control-label">应用代码<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="appCode" class="form-control" id="appCode" required pattern="([0-9]|[a-zA-Z]|[-]|[.]){1,40}" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span>1-40位字母、数字的组合</span>
				</div>
			</div>			
			<div class="form-group">
				<label for="appName" class="col-lg-2 control-label">应用名称<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="appName" class="form-control" id="appName" required pattern=".{1,20}" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span>1-20位</span>
				</div>
			</div>
			<div class="form-group">
				<label for="appType" class="col-lg-2 control-label">应用类型<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<select id="appType" name="appType" required class="form-control" disabled="disabled">
						<option>&nbsp;</option>
						<option value="1">一般应用</option>
						<option value="2">定时应用</option>
					</select>
				</div>
				<div class="col-lg-5">
					<span>1-20位</span>
				</div>
			</div>
			<div class="form-group">
				<label for="dataCenterId" class="col-lg-2 control-label">所属数据中心<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<select id="dataCenterId" name="dataCenterId" required class="form-control" disabled="disabled">
					</select>
				</div>
				<div class="col-lg-5">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="resCenterId" class="col-lg-2 control-label">所属资源中心<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<select id="resCenterId" name="resCenterId" required class="form-control" disabled="disabled">
					</select>
				</div>
				<div class="col-lg-5">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="versionNo" class="col-lg-2 control-label">版本号<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="versionNo" class="form-control" id="versionNo" required pattern="[0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span>000.000.000</span>
				</div>
			</div>
			<div class="form-group">
				<label for="mgrIds" class="col-lg-2 control-label">应用管理员<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="mgrIds" class="form-control" readonly required id="mgrIds" placeholder="">
				</div>
				<div class="col-lg-5">
					<span><a id="btn_select_mgr" href="###" title="选择管理员"><i class="fa fa-search fa-lg"></i></a></span>
				</div>
			</div>
			<div class="form-group">
				<label for="remark" class="col-lg-2 control-label">描述:</label>
				<div class="col-lg-5">
					<textarea name="remark" rows="3" cols="3" class="form-control" id="remark" maxlength="100"></textarea>
				</div>
				<div class="col-lg-5">
					<span>1-100位</span>
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
