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
		<form class="form-horizontal" role="form" id="form_appImage">
			<div class="form-group">
				<label for="containerName" class="col-lg-2 control-label">容器名<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="containerName" class="form-control" id="containerName" required pattern="([0-9]|[a-zA-Z]){1,100}" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span>1-100位字母或数字的组合</span>
				</div>
			</div>
			<div class="form-group">
				<label for="imageId" class="col-lg-2 control-label">镜像<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<select id="imageId" name="imageId" required class="form-control">
					</select>
				</div>
				<div class="col-lg-5">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="netZoneId" class="col-lg-2 control-label">网络区域<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<select id="netZoneId" name="netZoneId" class="form-control">
					</select>
				</div>
				<div class="col-lg-5">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="cpuCount" class="col-lg-2 control-label">CPU数<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="cpuCount" class="form-control" required id="cpuCount" pattern="\d+(\.\d{0,1})?" maxlength="8" placeholder="0.0">
				</div>
				<div class="col-lg-5">
					<span>&nbsp;&nbsp;<font color="red">剩余：<span id="div_residue_cpuCount"></span></font></span>
				</div>
			</div>
			<div class="form-group">
				<label for="memSize" class="col-lg-2 control-label">内存大小<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="memSize" class="form-control" required id="memSize" pattern="\d{1,8}" maxlength="8" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span>M&nbsp;&nbsp;<font color="red">剩余：<span id="div_residue_memSize"></span></font></span>
				</div>
			</div>
			<div class="form-group">
				<label for="diskSize" class="col-lg-2 control-label">存储大小<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="diskSize" class="form-control" required id="diskSize" pattern="\d{1,8}" maxlength="8" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span>M&nbsp;&nbsp;<font color="red">剩余：<span id="div_residue_diskSize"></span></font></span>
				</div>
			</div>
			<div class="form-group">
				<label for="instanceCount" class="col-lg-2 control-label">容器实例数<font color="red">*</font>:</label>
				<div class="col-lg-5">
					<input type="text" name="instanceCount" class="form-control" required id="instanceCount" pattern="\d{1,8}" maxlength="8" placeholder="必填">
				</div>
				<div class="col-lg-5">
					<span>1-8位</span>
				</div>
			</div>
			<div class="form-group">
				<label for="isSupportFlex" class="col-lg-2 control-label">是否自动伸缩:</label>
				<div class="col-lg-1">
					<input type="checkbox" name="isSupportFlex" id="isSupportFlex">
				</div>
				<div class="col-lg-11">
					<span></span>
				</div>
			</div>
			<div id="div_isSupportFlex_yes">
				<div class="form-group">
					<label for="cpuFlexUpperLimit" class="col-lg-2 control-label">容器伸缩CPU上限<font color="red">*</font>:</label>
					<div class="col-lg-5">
						<input type="text" name="cpuFlexUpperLimit" class="form-control" id="cpuFlexUpperLimit" pattern="\d+(\.\d{0,1})?" maxlength="8" placeholder="必填" >
					</div>
					<div class="col-lg-5">
						<span>0.0</span>
					</div>
				</div>
				<div class="form-group">
					<label for="cpuFlexLowerLimit" class="col-lg-2 control-label">容器伸缩CPU下限<font color="red">*</font>:</label>
					<div class="col-lg-5">
						<input type="text" name="cpuFlexLowerLimit" class="form-control" id="cpuFlexLowerLimit" pattern="\d+(\.\d{0,1})?" maxlength="8" placeholder="必填" >
					</div>
					<div class="col-lg-5">
						<span>0.0</span>
					</div>
				</div>
				<div class="form-group">
					<label for="maxInstanceCount" class="col-lg-2 control-label">最大实例数<font color="red">*</font>:</label>
					<div class="col-lg-5">
						<input type="text" name="maxInstanceCount" class="form-control" id="maxInstanceCount" pattern="\d{1,8}" maxlength="8" placeholder="必填">
					</div>
					<div class="col-lg-5">
						<span>1-8位</span>
					</div>
				</div>
				<div class="form-group">
					<label for="minInstanceCount" class="col-lg-2 control-label">最小实例数<font color="red">*</font>:</label>
					<div class="col-lg-5">
						<input type="text" name="minInstanceCount" class="form-control" id="minInstanceCount" pattern="\d{1,8}" maxlength="8" placeholder="必填">
					</div>
					<div class="col-lg-5">
						<span>1-8位</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="logMpPath" class="col-lg-2 control-label">日志目录:</label>
				<div class="col-lg-5">
					<input type="text" name="logMpPath" class="form-control" id="logMpPath" maxlength="100">
				</div>
				<div class="col-lg-5">
					<span>1-100位</span>
				</div>
			</div>
			<div class="form-group">
				<label for="dataMpPath" class="col-lg-2 control-label">数据目录:</label>
				<div class="col-lg-5">
					<input type="text" name="dataMpPath" class="form-control" id="dataMpPath" maxlength="100">
				</div>
				<div class="col-lg-5">
					<span>1-100位</span>
				</div>
			</div>
			<div class="form-group">
				<label for="isUniform" class="col-lg-2 control-label">是否均匀分布:</label>
				<div class="col-lg-1">
					<input type="checkbox" name="isUniform" id="isUniform">
				</div>
				<div class="col-lg-11">
					<span></span>
				</div>
			</div>	
			<div class="form-group">
				<label for="targs" class="col-lg-2 control-label">容器标签:</label>
				<div class="col-lg-5">
					<input type="text" name="targs" class="form-control" readonly required id="targs" placeholder="">
				</div>
				<div class="col-lg-5">
					<a href="###" id="btn_select_targs" data-type="checklist" data-title="选择标签" class="fa fa-search fa-lg"></a>
				</div>
			</div>	
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					&nbsp;<button type="submit" id="btn_save" class="btn btn-success" data-toggle="tooltip-hide">保存</button>
					&nbsp;<button type="submit" id="btn_next" class="btn btn-success">下一步</button>
				</div>
			</div>
		</form>
	</div>
</div>


<jsp:include page="/layout/jsp/footer.jsp"></jsp:include>
