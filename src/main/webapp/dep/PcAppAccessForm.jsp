<%@ page contentType="text/html; charset=utf-8"%>

<%
String ContextPath = request.getContextPath();
%>

<jsp:include page="/layout/jsp/head.jsp"></jsp:include>


<!-- 正文 -->
<div class="main-box">
	<header class="main-box-header clearfix"> </header>
	<div class="main-box-body clearfix">
		<form class="form-horizontal" role="form" id="form_appAccess" name="form_appAccess">
			<div class="form-group">
				<label for="appName" class="col-lg-2 control-label">应用名:</label>
				<div class="col-lg-5">
					<input type="text" name="appName" class="form-control" id="appName" required pattern="([0-9]|[a-zA-Z]|[_]){1,40}" readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="accessCode" class="col-lg-2 control-label">访问名<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="accessCode" class="form-control" id="accessCode" required  pattern="([0-9]|[a-zA-Z]|[_]|[-]){1,40}" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span>1-20位</span>
				</div>
			</div>
			<div class="form-group">
				<label for="appImgId" class="col-lg-2 control-label">所属应用镜像<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<select id="appImgId" name="appImgId" required="required" class="form-control">
					</select>
				</div>
				<div class="col-lg-5">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="protocol" class="col-lg-2 control-label">协议<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<select name="protocol"  class="form-control" required id="protocol" >
					</select>
				</div>
				<div class="col-lg-5">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="accessUrl" class="col-lg-2 control-label">访问地址:</label>
				<div class="col-lg-5">
					<input type="text" name="accessUrl" class="form-control" id="accessUrl" required maxlength="200"  readonly />
				</div>
				<div class="col-lg-5">
					<span></span>
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
					<button id="btn_submit" class="btn btn-success">提交</button>
				</div>
			</div>
		</form>
	</div>
</div>




<jsp:include page="/layout/jsp/footer.jsp"></jsp:include>
