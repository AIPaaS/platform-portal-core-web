<%@ page contentType="text/html; charset=utf-8"%>

<%
String ContextPath = request.getContextPath();
%>

<jsp:include page="/layout/jsp/head.jsp"></jsp:include>


<!-- 正文 -->
<div class="main-box">
	<header class="main-box-header clearfix"> </header>
	<div class="main-box-body clearfix">
		<form class="form-horizontal" role="form" id="form_externalSvc" name="form_externalSvc">
			<div class="form-group">
				<label for="svcCode" class="col-lg-2 control-label">服务代码<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="svcCode" class="form-control" id="svcCode" required pattern="([0-9]|[a-zA-Z]|[_]){1,40}" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span>1-40位数字、字母或下划线的组合</span>
				</div>
			</div>
			<div class="form-group">
				<label for="svcName" class="col-lg-2 control-label">服务名称<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="svcName" class="form-control" id="svcName" required pattern=".{1,20}" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span>1-20位</span>
				</div>
			</div>
			<div class="form-group">
				<label for="dataCenterId" class="col-lg-2 control-label">所属数据中心<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<select id="dataCenterId" name="dataCenterId" required="required" class="form-control">
					</select>
				</div>
				<div class="col-lg-5">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="resCenterId" class="col-lg-2 control-label">所属资源中心<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<select id="resCenterId" name="resCenterId" required="required" class="form-control">
					</select>
				</div>
				<div class="col-lg-5">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="protocol" class="col-lg-2 control-label">开放协议<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<select name="protocol"  class="form-control" required id="protocol" ></select>
				</div>
				<div class="col-lg-5">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="ip" class="col-lg-2 control-label">IP<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="ip" class="form-control" id="ip" required maxlength="15"  pattern="(([01]?[0-9]?[0-9]|2([0-4][0-9]|5[0-5]))\.){3}([01]?[0-9]?[0-9]|2([0-4][0-9]|5[0-5]))" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="port" class="col-lg-2 control-label">开放端口<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="port" class="form-control" id="port" required maxlength="8"  pattern="([0-9]){1,8}" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="custom4" class="col-lg-2 control-label">健康检查脚本<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="custom4" class="form-control" id="custom4" required maxlength="100"  pattern="(.{1,100}" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="svcUrl" class="col-lg-2 control-label">开放URL<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="svcUrl" class="form-control" id="svcUrl" required  pattern=".{1,200}" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span>1-200位</span>
				</div>
			</div>
			<div class="form-group">
					<div class="col-lg-2">
					</div>
					<div class="col-lg-5">
						<table class="table">
							<thead>
								<tr>
									<th class="text-center">参数名</th>
									<th class="text-center">参数描述</th>
									<th class="text-center">
										<a id="a_add_param" href="###" class="table-link" title="添加参数">
											<span class="fa-stack">
												<i class="fa fa-square fa-stack-2x"></i>
												<i class="fa fa-plus fa-stack-1x fa-inverse"></i>
											</span>
										</a>
									</th>
								</tr>
							</thead>
							<tbody id="SvcParamsTable">
							</tbody>
						</table>
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
