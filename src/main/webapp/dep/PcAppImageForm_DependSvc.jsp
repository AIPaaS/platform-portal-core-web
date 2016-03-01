<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="com.binary.core.util.BinaryUtils"%>

<%
String ContextPath = request.getContextPath();
%>

<jsp:include page="/layout/jsp/head.jsp"></jsp:include>
<jsp:include page="/dep/PcAppImageForm_Header.jsp"></jsp:include>


<!-- 正文 -->
<div class="main-box">
	<header class="main-box-header clearfix"> </header>
	<div class="main-box-body clearfix">
		<form class="form-horizontal" role="form" id="form_dependSvc">
			<div class="form-group">
				<label for="imageIds" class="col-lg-1 control-label">依赖容器:</label>
				<div class="col-lg-5">
					<input type="text" name="imageIds" class="form-control" readonly required id="imageIds" placeholder="">
				</div>
				<div class="col-lg-5">
					<a href="###" id="btn_select_imgs" data-type="checklist" data-title="选择镜像" class="fa fa-search fa-lg" data-placement="bottom"></a>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-12">
					<table class="table">
						<thead>
							<tr>
								<th class="text-center">调用/依赖服务</th>
								<th class="text-center">关系类型</th>
								<th class="text-center">服务参数名</th>
								<th class="text-center">服务参数描述</th>
								<th class="text-center">参数别名</th>
								<th class="text-center">参数值</th>
								<th class="text-center">
									<a id="a_select_svc" href="###" class="table-link" data-type="checklist" data-placement="left" title="添加服务">
										<span class="fa-stack">
											<i class="fa fa-square fa-stack-2x"></i>
											<i class="fa fa-plus fa-stack-1x fa-inverse"></i>
										</span>
									</a>
								</th>
							</tr>
						</thead>
						<tbody id="serviceTable">
					
						</tbody>
					</table>
				</div>
       		</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					&nbsp;<button type="submit" id="btn_prev" class="btn btn-success">上一步</button>
					&nbsp;<button type="submit" id="btn_save" class="btn btn-success" data-toggle="tooltip-hide">保存</button>
					&nbsp;<button type="submit" id="btn_next" class="btn btn-success">下一步</button>
				</div>
			</div>
		</form>
	</div>
</div>


<jsp:include page="/layout/jsp/footer.jsp"></jsp:include>
