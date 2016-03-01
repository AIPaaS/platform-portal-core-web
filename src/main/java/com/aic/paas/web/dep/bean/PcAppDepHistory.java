package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 应用布署历史表[PC_APP_DEP_HISTORY]
 */
public class PcAppDepHistory implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 * 对应任务ID
	 */
	private Long id;


	/**
	 * mapping-field: 租户ID[MNT_ID]
	 */
	private Long mntId;


	/**
	 * mapping-field: 应用ID[APP_ID]
	 */
	private Long appId;


	/**
	 * mapping-field: 应用版本ID[APP_VNO_ID]
	 */
	private Long appVnoId;


	/**
	 * mapping-field: 应用代码[APP_CODE]
	 */
	private String appCode;


	/**
	 * mapping-field: 应用名称[APP_NAME]
	 */
	private String appName;


	/**
	 * mapping-field: 应用版本号[APP_VERSION_NO]
	 */
	private String appVersionNo;


	/**
	 * mapping-field: 镜像ID[IMAGE_ID]
	 */
	private Long imageId;


	/**
	 * mapping-field: 镜像定义ID[IMAGE_DEF_ID]
	 */
	private Long imageDefId;


	/**
	 * mapping-field: 所属镜像库[IMAGE_RESP_ID]
	 */
	private Long imageRespId;


	/**
	 * mapping-field: 镜像名[IMAGE_NAME]
	 */
	private String imageName;


	/**
	 * mapping-field: 镜像全名[IMAGE_FULL_NAME]
	 * 目录名/镜像名-版本号-BUILD号
	 */
	private String imageFullName;


	/**
	 * mapping-field: BUILD号[BUILD_NO]
	 */
	private String buildNo;


	/**
	 * mapping-field: 容器名[CONTAINER_NAME]
	 * 如果做为服务需与服务名保持一致
	 */
	private String containerName;


	/**
	 * mapping-field: 容器全名[CONTAINER_FULL_NAME]
	 * 租户代码-应用代码-容器名
	 */
	private String containerFullName;


	/**
	 * mapping-field: 所属数据中心[DATA_CENTER_ID]
	 */
	private Long dataCenterId;


	/**
	 * mapping-field: 所属资源中心[RES_CENTER_ID]
	 */
	private Long resCenterId;


	/**
	 * mapping-field: 所在网络区域[NET_ZONE_ID]
	 */
	private Long netZoneId;


	/**
	 * mapping-field: CPU个数[CPU_COUNT]
	 * 单位：0.00
	 */
	private Integer cpuCount;


	/**
	 * mapping-field: 内存大小[MEM_SIZE]
	 * 单位：M
	 */
	private Long memSize;


	/**
	 * mapping-field: 存储大小[DISK_SIZE]
	 * 单位：M
	 */
	private Long diskSize;


	/**
	 * mapping-field: 容器实例数[INSTANCE_COUNT]
	 */
	private Integer instanceCount;


	/**
	 * mapping-field: 是否自动伸缩[IS_SUPPORT_FLEX]
	 * 1=是 0=否
	 */
	private Integer isSupportFlex;


	/**
	 * mapping-field: 容器伸缩CPU上限值[CPU_FLEX_UPPER_LIMIT]
	 * 单位：0.00
	 */
	private Integer cpuFlexUpperLimit;


	/**
	 * mapping-field: 容器伸缩CPU下限值[CPU_FLEX_LOWER_LIMIT]
	 * 单位：0.00
	 */
	private Integer cpuFlexLowerLimit;


	/**
	 * mapping-field: 最大实例数量[MAX_INSTANCE_COUNT]
	 */
	private Integer maxInstanceCount;


	/**
	 * mapping-field: 最小实例数量[MIN_INSTANCE_COUNT]
	 */
	private Integer minInstanceCount;


	/**
	 * mapping-field: 日志目录[LOG_MP_PATH]
	 */
	private String logMpPath;


	/**
	 * mapping-field: 数据目录[DATA_MP_PATH]
	 */
	private String dataMpPath;


	/**
	 * mapping-field: 是否均匀分布[IS_UNIFORM]
	 * 1=是 0=否
	 */
	private Integer isUniform;


	/**
	 * mapping-field: 容器标签[TARGS]
	 * JSON {key:value}
	 */
	private String targs;


	/**
	 * mapping-field: 依赖容器ID列表[DEPEND_CONT_IDS]
	 * 以逗号[,]分隔
	 */
	private String dependContIds;


	/**
	 * mapping-field: 依赖容器名称列表[DEPEND_CONT_NAMES]
	 * 以逗号[,]分隔
	 */
	private String dependContNames;


	/**
	 * mapping-field: 备用字段_1[CUSTOM_1]
	 */
	private Long custom1;


	/**
	 * mapping-field: 备用字段_2[CUSTOM_2]
	 */
	private Long custom2;


	/**
	 * mapping-field: 备用字段_3[CUSTOM_3]
	 */
	private Long custom3;


	/**
	 * mapping-field: 备用字段_4[CUSTOM_4]
	 */
	private String custom4;


	/**
	 * mapping-field: 备用字段_5[CUSTOM_5]
	 */
	private String custom5;


	/**
	 * mapping-field: 备用字段_6[CUSTOM_6]
	 */
	private String custom6;


	/**
	 * mapping-field: 部署状态[DEP_STATUS]
	 * 1=就绪 2=部署中 3=部署成功 4=部署失败
	 */
	private Integer depStatus;


	/**
	 * mapping-field: 运行状态[RUN_STATUS]
	 * 1=待运行 2=运行中 3=停止
	 */
	private Integer runStatus;


	/**
	 * mapping-field: 数据状态[DATA_STATUS]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer dataStatus;


	/**
	 * mapping-field: 创建人[CREATOR]
	 */
	private String creator;


	/**
	 * mapping-field: 创建时间[CREATE_TIME]
	 */
	private Long createTime;


	/**
	 * mapping-field: 修改人[MODIFIER]
	 */
	private String modifier;


	/**
	 * mapping-field: 修改时间[MODIFY_TIME]
	 */
	private Long modifyTime;




	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public Long getMntId() {
		return this.mntId;
	}
	public void setMntId(Long mntId) {
		this.mntId = mntId;
	}


	public Long getAppId() {
		return this.appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}


	public Long getAppVnoId() {
		return this.appVnoId;
	}
	public void setAppVnoId(Long appVnoId) {
		this.appVnoId = appVnoId;
	}


	public String getAppCode() {
		return this.appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}


	public String getAppName() {
		return this.appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}


	public String getAppVersionNo() {
		return this.appVersionNo;
	}
	public void setAppVersionNo(String appVersionNo) {
		this.appVersionNo = appVersionNo;
	}


	public Long getImageId() {
		return this.imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}


	public Long getImageDefId() {
		return this.imageDefId;
	}
	public void setImageDefId(Long imageDefId) {
		this.imageDefId = imageDefId;
	}


	public Long getImageRespId() {
		return this.imageRespId;
	}
	public void setImageRespId(Long imageRespId) {
		this.imageRespId = imageRespId;
	}


	public String getImageName() {
		return this.imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public String getImageFullName() {
		return this.imageFullName;
	}
	public void setImageFullName(String imageFullName) {
		this.imageFullName = imageFullName;
	}


	public String getBuildNo() {
		return this.buildNo;
	}
	public void setBuildNo(String buildNo) {
		this.buildNo = buildNo;
	}


	public String getContainerName() {
		return this.containerName;
	}
	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}


	public String getContainerFullName() {
		return this.containerFullName;
	}
	public void setContainerFullName(String containerFullName) {
		this.containerFullName = containerFullName;
	}


	public Long getDataCenterId() {
		return this.dataCenterId;
	}
	public void setDataCenterId(Long dataCenterId) {
		this.dataCenterId = dataCenterId;
	}


	public Long getResCenterId() {
		return this.resCenterId;
	}
	public void setResCenterId(Long resCenterId) {
		this.resCenterId = resCenterId;
	}


	public Long getNetZoneId() {
		return this.netZoneId;
	}
	public void setNetZoneId(Long netZoneId) {
		this.netZoneId = netZoneId;
	}


	public Integer getCpuCount() {
		return this.cpuCount;
	}
	public void setCpuCount(Integer cpuCount) {
		this.cpuCount = cpuCount;
	}


	public Long getMemSize() {
		return this.memSize;
	}
	public void setMemSize(Long memSize) {
		this.memSize = memSize;
	}


	public Long getDiskSize() {
		return this.diskSize;
	}
	public void setDiskSize(Long diskSize) {
		this.diskSize = diskSize;
	}


	public Integer getInstanceCount() {
		return this.instanceCount;
	}
	public void setInstanceCount(Integer instanceCount) {
		this.instanceCount = instanceCount;
	}


	public Integer getIsSupportFlex() {
		return this.isSupportFlex;
	}
	public void setIsSupportFlex(Integer isSupportFlex) {
		this.isSupportFlex = isSupportFlex;
	}


	public Integer getCpuFlexUpperLimit() {
		return this.cpuFlexUpperLimit;
	}
	public void setCpuFlexUpperLimit(Integer cpuFlexUpperLimit) {
		this.cpuFlexUpperLimit = cpuFlexUpperLimit;
	}


	public Integer getCpuFlexLowerLimit() {
		return this.cpuFlexLowerLimit;
	}
	public void setCpuFlexLowerLimit(Integer cpuFlexLowerLimit) {
		this.cpuFlexLowerLimit = cpuFlexLowerLimit;
	}


	public Integer getMaxInstanceCount() {
		return this.maxInstanceCount;
	}
	public void setMaxInstanceCount(Integer maxInstanceCount) {
		this.maxInstanceCount = maxInstanceCount;
	}


	public Integer getMinInstanceCount() {
		return this.minInstanceCount;
	}
	public void setMinInstanceCount(Integer minInstanceCount) {
		this.minInstanceCount = minInstanceCount;
	}


	public String getLogMpPath() {
		return this.logMpPath;
	}
	public void setLogMpPath(String logMpPath) {
		this.logMpPath = logMpPath;
	}


	public String getDataMpPath() {
		return this.dataMpPath;
	}
	public void setDataMpPath(String dataMpPath) {
		this.dataMpPath = dataMpPath;
	}


	public Integer getIsUniform() {
		return this.isUniform;
	}
	public void setIsUniform(Integer isUniform) {
		this.isUniform = isUniform;
	}


	public String getTargs() {
		return this.targs;
	}
	public void setTargs(String targs) {
		this.targs = targs;
	}


	public String getDependContIds() {
		return this.dependContIds;
	}
	public void setDependContIds(String dependContIds) {
		this.dependContIds = dependContIds;
	}


	public String getDependContNames() {
		return this.dependContNames;
	}
	public void setDependContNames(String dependContNames) {
		this.dependContNames = dependContNames;
	}


	public Long getCustom1() {
		return this.custom1;
	}
	public void setCustom1(Long custom1) {
		this.custom1 = custom1;
	}


	public Long getCustom2() {
		return this.custom2;
	}
	public void setCustom2(Long custom2) {
		this.custom2 = custom2;
	}


	public Long getCustom3() {
		return this.custom3;
	}
	public void setCustom3(Long custom3) {
		this.custom3 = custom3;
	}


	public String getCustom4() {
		return this.custom4;
	}
	public void setCustom4(String custom4) {
		this.custom4 = custom4;
	}


	public String getCustom5() {
		return this.custom5;
	}
	public void setCustom5(String custom5) {
		this.custom5 = custom5;
	}


	public String getCustom6() {
		return this.custom6;
	}
	public void setCustom6(String custom6) {
		this.custom6 = custom6;
	}


	public Integer getDepStatus() {
		return this.depStatus;
	}
	public void setDepStatus(Integer depStatus) {
		this.depStatus = depStatus;
	}


	public Integer getRunStatus() {
		return this.runStatus;
	}
	public void setRunStatus(Integer runStatus) {
		this.runStatus = runStatus;
	}


	public Integer getDataStatus() {
		return this.dataStatus;
	}
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}


	public String getCreator() {
		return this.creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}


	public Long getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}


	public String getModifier() {
		return this.modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}


	public Long getModifyTime() {
		return this.modifyTime;
	}
	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}


}


