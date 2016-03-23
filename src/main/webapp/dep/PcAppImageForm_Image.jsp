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
				<label for="containerName" class="pull-left pull-left control-label" style="width:100px;">容器名<font color="red">*</font>:</label>
				<div class="pull-left col-lg-3 pull-left">
					<input type="text" name="containerName" class="form-control" style="width:400px;" required id="containerName"  pattern="([0-9]|[a-zA-Z]){1,100}" placeholder="必填">
				</div>
				<div class="pull-left col-lg-3 pull-left">
					<span>1-100位字母或数字的组合</span>
				</div>
				<div>&nbsp;</div>
			</div>
			<div class="form-group">
				<label for="imageId" class="pull-left  control-label" style="width:100px;">镜像<font color="red">*</font>:</label>
				<div class="pull-left ">
					<select id="imageId" name="imageId"  style="z-index:10;POSITION: absolute;width:400px;CLIP: rect(0px auto auto 380px);"
					onchange="document.getElementById('image').value=this.options[this.selectedIndex].text" class="form-control">
					</select>
					<INPUT id="image" required name="image" style="z-index:11;LEFT: 0px; TOP: 0px; WIDTH: 381px;height: 33px;position: relative;"/>
				</div>
				<div class="pull-left ">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="netZoneId" class="pull-left  control-label" style="width:100px;">网络区域<font color="red">*</font>:</label>
				<div class="pull-left ">
					<select id="netZoneId" name="netZoneId" required style="POSITION: absolute;width:400px;"
					class="form-control">
					</select>
					
				</div>
				<div class="pull-left ">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="cpuCount" class="pull-left  control-label" style="width:100px;">CPU数<font color="red">*</font>:</label>
				<div class="pull-left ">
					<input type="text" name="cpuCount" class="form-control" required  style="width:400px;" id="cpuCount" pattern="\d+(\.\d{0,1})?" maxlength="8" placeholder="必填,格式：0.0">
				</div>
				<div class="pull-left ">
					<span>&nbsp;&nbsp;<font color="red">剩余：<span id="div_residue_cpuCount"></span></font></span>
				</div>
			</div>
			<div class="form-group">
				<label for="memSize" class="pull-left  control-label" style="width:100px;">内存大小<font color="red">*</font>:</label>
				<div class="pull-left ">
					<input type="text" name="memSize" required class="form-control"  style="width:400px;" id="memSize" pattern="\d{1,8}" maxlength="8" placeholder="必填,格式：整数">
				</div>
				<div class="pull-left ">
					<span>M&nbsp;&nbsp;<font color="red">剩余：<span id="div_residue_memSize"></span></font></span>
				</div>
			</div>
			<div class="form-group">
				<label for="diskSize" class="pull-left  control-label" style="width:100px;">存储大小:</label>
				<div class="pull-left ">
					<input type="text" name="diskSize" class="form-control" required  style="width:400px;" id="diskSize" pattern="\d{0,8}" maxlength="8"  placeholder="格式：整数">
				</div>
				<div class="pull-left ">
					<span>M&nbsp;&nbsp;<font color="red">剩余：<span id="div_residue_diskSize"></span></font></span>
				</div>
			</div>
			<div class="form-group">
				<label for="instanceCount" class="pull-left  control-label" style="width:100px;">容器实例数<font color="red">*</font>:</label>
				<div class="pull-left ">
					<input type="text" name="instanceCount" class="form-control" required  style="width:400px;" id="instanceCount" pattern="\d{1,8}" maxlength="8" placeholder="必填">
				</div>
				<div class="pull-left ">
					<span>1-8位</span>
				</div>
			</div>
			<div class="form-group">
				<label for="isSupportFlex" class="pull-left  control-label" style="width:100px;">是否自动伸缩:</label>
				<div class="pull-left col-lg-1">
					<input type="checkbox" name="isSupportFlex" id="isSupportFlex">
				</div>
				<div class="pull-left col-lg-11">
					<span></span>
				</div>
			</div>
			<div id="div_isSupportFlex_yes">
				<div class="form-group">
					<label for="cpuFlexUpperLimit" class="pull-left  control-label" style="width:100px;">容器伸缩CPU上限<font color="red">*</font>:</label>
					<div class="pull-left ">
						<input type="text" name="cpuFlexUpperLimit" class="form-control"  style="width:400px;" id="cpuFlexUpperLimit" pattern="\d+(\.\d{0,1})?" maxlength="8" placeholder="必填" >
					</div>
					<div class="pull-left ">
						<span>0.0</span>
					</div>
				</div>
				<div class="form-group">
					<label for="cpuFlexLowerLimit" class="pull-left  control-label" style="width:100px;">容器伸缩CPU下限<font color="red">*</font>:</label>
					<div class="pull-left ">
						<input type="text" name="cpuFlexLowerLimit" class="form-control"  style="width:400px;" id="cpuFlexLowerLimit" pattern="\d+(\.\d{0,1})?" maxlength="8" placeholder="必填" >
					</div>
					<div class="pull-left ">
						<span>0.0</span>
					</div>
				</div>
				<div class="form-group">
					<label for="maxInstanceCount" class="pull-left  control-label" style="width:100px;">最大实例数<font color="red">*</font>:</label>
					<div class="pull-left ">
						<input type="text" name="maxInstanceCount" class="form-control"  style="width:400px;" id="maxInstanceCount" pattern="\d{1,8}" maxlength="8" placeholder="必填">
					</div>
					<div class="pull-left ">
						<span>1-8位</span>
					</div>
				</div>
				<div class="form-group">
					<label for="minInstanceCount" class="pull-left  control-label" style="width:100px;">最小实例数<font color="red">*</font>:</label>
					<div class="pull-left ">
						<input type="text" name="minInstanceCount" class="form-control"  style="width:400px;" id="minInstanceCount" pattern="\d{1,8}" maxlength="8" placeholder="必填">
					</div>
					<div class="pull-left ">
						<span>1-8位</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="logMpPath" class="pull-left  control-label" style="width:100px;">日志目录:</label>
				<div class="pull-left ">
					<input type="text" name="logMpPath" class="form-control"  style="width:400px;" id="logMpPath" maxlength="100">
				</div>
				<div class="pull-left ">
					<span>1-100位</span>
				</div>
			</div>
			<div class="form-group">
				<label for="dataMpPath" class="pull-left  control-label" style="width:100px;">数据目录:</label>
				<div class="pull-left ">
					<input type="text" name="dataMpPath" class="form-control"  style="width:400px;" id="dataMpPath" maxlength="100">
				</div>
				<div class="pull-left ">
					<span>1-100位</span>
				</div>
			</div>
			<div class="form-group">
				<label for="isUniform" class="pull-left  control-label" style="width:100px;">是否均匀分布:</label>
				<div class="pull-left col-lg-1">
					<input type="checkbox" name="isUniform" id="isUniform">
				</div>
				<div class="pull-left col-lg-11">
					<span></span>
				</div>
			</div>	
			<div class="form-group">
				<label for="targs" class="pull-left  control-label" style="width:100px;">容器标签:</label>
				<div class="pull-left ">
					<input type="text" name="targs" class="form-control" readonly  style="width:400px;" required id="targs" placeholder="">
				</div>
				<div class="pull-left ">
					<a href="###" id="btn_select_targs" data-type="checklist" data-title="选择标签" class="fa fa-search fa-lg"></a>
				</div>
			</div>	
			
			<div id="div_time">
			
				<div class="form-group">
					<label for="targs" class="pull-left  control-label" style="width:100px;">开始时间<font color="red">*</font>:</label>
					<div class="pull-left ">
						<input type="text" class="form-control" required style="width:400px;" id="maskedDate">
					</div>
					<div class="pull-left ">
					</div>
				</div>
				<div class="form-group">
					<div class="pull-left">
						<label for="timerExp" class="pull-left  control-label" style="width:100px;">执行间隔<font color="red">*</font>:</label>
					</div>
					<div class="pull-left " class="pull-left clearfix">
						<div class="pull-left">
							<label for="timer1" class="control-label pull-left">时:</label>
						</div>
						<div class="pull-left">
							<input type="text" name="timer1" class="form-control pull-left" required style="width:120px;" id="timer1" placeholder="">
						</div>
						<div class="pull-left">
							<label for="timer2" class="control-label pull-left">分:</label>
						</div>
						<div class="pull-left">
							<input type="text" name="timer2" class="form-control pull-left" required style="width:120px;" id="timer2" placeholder="">
						</div>
						<div class="pull-left">
							<label for="timer3" class="control-label pull-left">秒:</label>
						</div>
						<div class="pull-left">
							<input type="text" name="timer3" class="form-control pull-left" required style="width:120px;" id="timer3" placeholder="">
						</div>
						
					</div>
					<div class="pull-left ">
					</div>
				</div>	
			
			
			</div>
			
			
			
			<div class="form-group">
				<div class="pull-left"  style="width:100px;">&nbsp;</div>
				<div class="pull-left col-lg-offset-2 pull-left col-lg-10">
					&nbsp;<button type="submit" id="btn_save" class="btn btn-success" data-toggle="tooltip-hide">保存</button>
					&nbsp;<button type="submit" id="btn_next" class="btn btn-success">下一步</button>
				</div>
			</div>
		</form>
	</div>
</div>


<jsp:include page="/layout/jsp/footer.jsp"></jsp:include>
