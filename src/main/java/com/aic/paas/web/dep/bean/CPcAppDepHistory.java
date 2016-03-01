package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 应用布署历史表[PC_APP_DEP_HISTORY]
 */
public class CPcAppDepHistory implements Condition {
	private static final long serialVersionUID = 1L;


	/**
	 * condition-field: ID[ID] operate-Equal[=]
	 * 对应任务ID
	 */
	private Long id;


	/**
	 * condition-field: ID[ID] operate-In[in]
	 * 对应任务ID
	 */
	private Long[] ids;


	/**
	 * condition-field: ID[ID] operate-GTEqual[>=]
	 * 对应任务ID
	 */
	private Long startId;

	/**
	 * condition-field: ID[ID] operate-LTEqual[<=]
	 * 对应任务ID
	 */
	private Long endId;


	/**
	 * condition-field: 租户ID[MNT_ID] operate-Equal[=]
	 */
	private Long mntId;


	/**
	 * condition-field: 租户ID[MNT_ID] operate-In[in]
	 */
	private Long[] mntIds;


	/**
	 * condition-field: 租户ID[MNT_ID] operate-GTEqual[>=]
	 */
	private Long startMntId;

	/**
	 * condition-field: 租户ID[MNT_ID] operate-LTEqual[<=]
	 */
	private Long endMntId;


	/**
	 * condition-field: 应用ID[APP_ID] operate-Equal[=]
	 */
	private Long appId;


	/**
	 * condition-field: 应用ID[APP_ID] operate-In[in]
	 */
	private Long[] appIds;


	/**
	 * condition-field: 应用ID[APP_ID] operate-GTEqual[>=]
	 */
	private Long startAppId;

	/**
	 * condition-field: 应用ID[APP_ID] operate-LTEqual[<=]
	 */
	private Long endAppId;


	/**
	 * condition-field: 应用版本ID[APP_VNO_ID] operate-Equal[=]
	 */
	private Long appVnoId;


	/**
	 * condition-field: 应用版本ID[APP_VNO_ID] operate-In[in]
	 */
	private Long[] appVnoIds;


	/**
	 * condition-field: 应用版本ID[APP_VNO_ID] operate-GTEqual[>=]
	 */
	private Long startAppVnoId;

	/**
	 * condition-field: 应用版本ID[APP_VNO_ID] operate-LTEqual[<=]
	 */
	private Long endAppVnoId;


	/**
	 * condition-field: 应用代码[APP_CODE] operate-Like[like]
	 */
	private String appCode;


	/**
	 * condition-field: 应用代码[APP_CODE] operate-Equal[=]
	 */
	private String appCodeEqual;


	/**
	 * condition-field: 应用代码[APP_CODE] operate-In[in]
	 */
	private String[] appCodes;


	/**
	 * condition-field: 应用名称[APP_NAME] operate-Like[like]
	 */
	private String appName;


	/**
	 * condition-field: 应用名称[APP_NAME] operate-Equal[=]
	 */
	private String appNameEqual;


	/**
	 * condition-field: 应用名称[APP_NAME] operate-In[in]
	 */
	private String[] appNames;


	/**
	 * condition-field: 应用版本号[APP_VERSION_NO] operate-Like[like]
	 */
	private String appVersionNo;


	/**
	 * condition-field: 应用版本号[APP_VERSION_NO] operate-Equal[=]
	 */
	private String appVersionNoEqual;


	/**
	 * condition-field: 应用版本号[APP_VERSION_NO] operate-In[in]
	 */
	private String[] appVersionNos;


	/**
	 * condition-field: 镜像ID[IMAGE_ID] operate-Equal[=]
	 */
	private Long imageId;


	/**
	 * condition-field: 镜像ID[IMAGE_ID] operate-In[in]
	 */
	private Long[] imageIds;


	/**
	 * condition-field: 镜像ID[IMAGE_ID] operate-GTEqual[>=]
	 */
	private Long startImageId;

	/**
	 * condition-field: 镜像ID[IMAGE_ID] operate-LTEqual[<=]
	 */
	private Long endImageId;


	/**
	 * condition-field: 镜像定义ID[IMAGE_DEF_ID] operate-Equal[=]
	 */
	private Long imageDefId;


	/**
	 * condition-field: 镜像定义ID[IMAGE_DEF_ID] operate-In[in]
	 */
	private Long[] imageDefIds;


	/**
	 * condition-field: 镜像定义ID[IMAGE_DEF_ID] operate-GTEqual[>=]
	 */
	private Long startImageDefId;

	/**
	 * condition-field: 镜像定义ID[IMAGE_DEF_ID] operate-LTEqual[<=]
	 */
	private Long endImageDefId;


	/**
	 * condition-field: 所属镜像库[IMAGE_RESP_ID] operate-Equal[=]
	 */
	private Long imageRespId;


	/**
	 * condition-field: 所属镜像库[IMAGE_RESP_ID] operate-In[in]
	 */
	private Long[] imageRespIds;


	/**
	 * condition-field: 所属镜像库[IMAGE_RESP_ID] operate-GTEqual[>=]
	 */
	private Long startImageRespId;

	/**
	 * condition-field: 所属镜像库[IMAGE_RESP_ID] operate-LTEqual[<=]
	 */
	private Long endImageRespId;


	/**
	 * condition-field: 镜像名[IMAGE_NAME] operate-Like[like]
	 */
	private String imageName;


	/**
	 * condition-field: 镜像全名[IMAGE_FULL_NAME] operate-Like[like]
	 * 目录名/镜像名-版本号-BUILD号
	 */
	private String imageFullName;


	/**
	 * condition-field: BUILD号[BUILD_NO] operate-Like[like]
	 */
	private String buildNo;


	/**
	 * condition-field: BUILD号[BUILD_NO] operate-Equal[=]
	 */
	private String buildNoEqual;


	/**
	 * condition-field: BUILD号[BUILD_NO] operate-In[in]
	 */
	private String[] buildNos;


	/**
	 * condition-field: 容器名[CONTAINER_NAME] operate-Like[like]
	 * 如果做为服务需与服务名保持一致
	 */
	private String containerName;


	/**
	 * condition-field: 容器全名[CONTAINER_FULL_NAME] operate-Like[like]
	 * 租户代码-应用代码-容器名
	 */
	private String containerFullName;


	/**
	 * condition-field: 所属数据中心[DATA_CENTER_ID] operate-Equal[=]
	 */
	private Long dataCenterId;


	/**
	 * condition-field: 所属数据中心[DATA_CENTER_ID] operate-In[in]
	 */
	private Long[] dataCenterIds;


	/**
	 * condition-field: 所属数据中心[DATA_CENTER_ID] operate-GTEqual[>=]
	 */
	private Long startDataCenterId;

	/**
	 * condition-field: 所属数据中心[DATA_CENTER_ID] operate-LTEqual[<=]
	 */
	private Long endDataCenterId;


	/**
	 * condition-field: 所属资源中心[RES_CENTER_ID] operate-Equal[=]
	 */
	private Long resCenterId;


	/**
	 * condition-field: 所属资源中心[RES_CENTER_ID] operate-In[in]
	 */
	private Long[] resCenterIds;


	/**
	 * condition-field: 所属资源中心[RES_CENTER_ID] operate-GTEqual[>=]
	 */
	private Long startResCenterId;

	/**
	 * condition-field: 所属资源中心[RES_CENTER_ID] operate-LTEqual[<=]
	 */
	private Long endResCenterId;


	/**
	 * condition-field: 所在网络区域[NET_ZONE_ID] operate-Equal[=]
	 */
	private Long netZoneId;


	/**
	 * condition-field: 所在网络区域[NET_ZONE_ID] operate-In[in]
	 */
	private Long[] netZoneIds;


	/**
	 * condition-field: 所在网络区域[NET_ZONE_ID] operate-GTEqual[>=]
	 */
	private Long startNetZoneId;

	/**
	 * condition-field: 所在网络区域[NET_ZONE_ID] operate-LTEqual[<=]
	 */
	private Long endNetZoneId;


	/**
	 * condition-field: CPU个数[CPU_COUNT] operate-Equal[=]
	 * 单位：0.00
	 */
	private Integer cpuCount;


	/**
	 * condition-field: CPU个数[CPU_COUNT] operate-In[in]
	 * 单位：0.00
	 */
	private Integer[] cpuCounts;


	/**
	 * condition-field: CPU个数[CPU_COUNT] operate-GTEqual[>=]
	 * 单位：0.00
	 */
	private Integer startCpuCount;

	/**
	 * condition-field: CPU个数[CPU_COUNT] operate-LTEqual[<=]
	 * 单位：0.00
	 */
	private Integer endCpuCount;


	/**
	 * condition-field: 内存大小[MEM_SIZE] operate-Equal[=]
	 * 单位：M
	 */
	private Long memSize;


	/**
	 * condition-field: 内存大小[MEM_SIZE] operate-In[in]
	 * 单位：M
	 */
	private Long[] memSizes;


	/**
	 * condition-field: 内存大小[MEM_SIZE] operate-GTEqual[>=]
	 * 单位：M
	 */
	private Long startMemSize;

	/**
	 * condition-field: 内存大小[MEM_SIZE] operate-LTEqual[<=]
	 * 单位：M
	 */
	private Long endMemSize;


	/**
	 * condition-field: 存储大小[DISK_SIZE] operate-Equal[=]
	 * 单位：M
	 */
	private Long diskSize;


	/**
	 * condition-field: 存储大小[DISK_SIZE] operate-In[in]
	 * 单位：M
	 */
	private Long[] diskSizes;


	/**
	 * condition-field: 存储大小[DISK_SIZE] operate-GTEqual[>=]
	 * 单位：M
	 */
	private Long startDiskSize;

	/**
	 * condition-field: 存储大小[DISK_SIZE] operate-LTEqual[<=]
	 * 单位：M
	 */
	private Long endDiskSize;


	/**
	 * condition-field: 容器实例数[INSTANCE_COUNT] operate-Equal[=]
	 */
	private Integer instanceCount;


	/**
	 * condition-field: 容器实例数[INSTANCE_COUNT] operate-In[in]
	 */
	private Integer[] instanceCounts;


	/**
	 * condition-field: 容器实例数[INSTANCE_COUNT] operate-GTEqual[>=]
	 */
	private Integer startInstanceCount;

	/**
	 * condition-field: 容器实例数[INSTANCE_COUNT] operate-LTEqual[<=]
	 */
	private Integer endInstanceCount;


	/**
	 * condition-field: 是否自动伸缩[IS_SUPPORT_FLEX] operate-Equal[=]
	 * 1=是 0=否
	 */
	private Integer isSupportFlex;


	/**
	 * condition-field: 是否自动伸缩[IS_SUPPORT_FLEX] operate-In[in]
	 * 1=是 0=否
	 */
	private Integer[] isSupportFlexs;


	/**
	 * condition-field: 是否自动伸缩[IS_SUPPORT_FLEX] operate-GTEqual[>=]
	 * 1=是 0=否
	 */
	private Integer startIsSupportFlex;

	/**
	 * condition-field: 是否自动伸缩[IS_SUPPORT_FLEX] operate-LTEqual[<=]
	 * 1=是 0=否
	 */
	private Integer endIsSupportFlex;


	/**
	 * condition-field: 容器伸缩CPU上限值[CPU_FLEX_UPPER_LIMIT] operate-Equal[=]
	 * 单位：0.00
	 */
	private Integer cpuFlexUpperLimit;


	/**
	 * condition-field: 容器伸缩CPU上限值[CPU_FLEX_UPPER_LIMIT] operate-In[in]
	 * 单位：0.00
	 */
	private Integer[] cpuFlexUpperLimits;


	/**
	 * condition-field: 容器伸缩CPU上限值[CPU_FLEX_UPPER_LIMIT] operate-GTEqual[>=]
	 * 单位：0.00
	 */
	private Integer startCpuFlexUpperLimit;

	/**
	 * condition-field: 容器伸缩CPU上限值[CPU_FLEX_UPPER_LIMIT] operate-LTEqual[<=]
	 * 单位：0.00
	 */
	private Integer endCpuFlexUpperLimit;


	/**
	 * condition-field: 容器伸缩CPU下限值[CPU_FLEX_LOWER_LIMIT] operate-Equal[=]
	 * 单位：0.00
	 */
	private Integer cpuFlexLowerLimit;


	/**
	 * condition-field: 容器伸缩CPU下限值[CPU_FLEX_LOWER_LIMIT] operate-In[in]
	 * 单位：0.00
	 */
	private Integer[] cpuFlexLowerLimits;


	/**
	 * condition-field: 容器伸缩CPU下限值[CPU_FLEX_LOWER_LIMIT] operate-GTEqual[>=]
	 * 单位：0.00
	 */
	private Integer startCpuFlexLowerLimit;

	/**
	 * condition-field: 容器伸缩CPU下限值[CPU_FLEX_LOWER_LIMIT] operate-LTEqual[<=]
	 * 单位：0.00
	 */
	private Integer endCpuFlexLowerLimit;


	/**
	 * condition-field: 最大实例数量[MAX_INSTANCE_COUNT] operate-Equal[=]
	 */
	private Integer maxInstanceCount;


	/**
	 * condition-field: 最大实例数量[MAX_INSTANCE_COUNT] operate-In[in]
	 */
	private Integer[] maxInstanceCounts;


	/**
	 * condition-field: 最大实例数量[MAX_INSTANCE_COUNT] operate-GTEqual[>=]
	 */
	private Integer startMaxInstanceCount;

	/**
	 * condition-field: 最大实例数量[MAX_INSTANCE_COUNT] operate-LTEqual[<=]
	 */
	private Integer endMaxInstanceCount;


	/**
	 * condition-field: 最小实例数量[MIN_INSTANCE_COUNT] operate-Equal[=]
	 */
	private Integer minInstanceCount;


	/**
	 * condition-field: 最小实例数量[MIN_INSTANCE_COUNT] operate-In[in]
	 */
	private Integer[] minInstanceCounts;


	/**
	 * condition-field: 最小实例数量[MIN_INSTANCE_COUNT] operate-GTEqual[>=]
	 */
	private Integer startMinInstanceCount;

	/**
	 * condition-field: 最小实例数量[MIN_INSTANCE_COUNT] operate-LTEqual[<=]
	 */
	private Integer endMinInstanceCount;


	/**
	 * condition-field: 日志目录[LOG_MP_PATH] operate-Like[like]
	 */
	private String logMpPath;


	/**
	 * condition-field: 数据目录[DATA_MP_PATH] operate-Like[like]
	 */
	private String dataMpPath;


	/**
	 * condition-field: 是否均匀分布[IS_UNIFORM] operate-Equal[=]
	 * 1=是 0=否
	 */
	private Integer isUniform;


	/**
	 * condition-field: 是否均匀分布[IS_UNIFORM] operate-In[in]
	 * 1=是 0=否
	 */
	private Integer[] isUniforms;


	/**
	 * condition-field: 是否均匀分布[IS_UNIFORM] operate-GTEqual[>=]
	 * 1=是 0=否
	 */
	private Integer startIsUniform;

	/**
	 * condition-field: 是否均匀分布[IS_UNIFORM] operate-LTEqual[<=]
	 * 1=是 0=否
	 */
	private Integer endIsUniform;


	/**
	 * condition-field: 容器标签[TARGS] operate-Like[like]
	 * JSON {key:value}
	 */
	private String targs;


	/**
	 * condition-field: 依赖容器ID列表[DEPEND_CONT_IDS] operate-Like[like]
	 * 以逗号[,]分隔
	 */
	private String dependContIds;


	/**
	 * condition-field: 依赖容器名称列表[DEPEND_CONT_NAMES] operate-Like[like]
	 * 以逗号[,]分隔
	 */
	private String dependContNames;


	/**
	 * condition-field: 备用字段_1[CUSTOM_1] operate-Equal[=]
	 */
	private Long custom1;


	/**
	 * condition-field: 备用字段_1[CUSTOM_1] operate-In[in]
	 */
	private Long[] custom1s;


	/**
	 * condition-field: 备用字段_1[CUSTOM_1] operate-GTEqual[>=]
	 */
	private Long startCustom1;

	/**
	 * condition-field: 备用字段_1[CUSTOM_1] operate-LTEqual[<=]
	 */
	private Long endCustom1;


	/**
	 * condition-field: 备用字段_2[CUSTOM_2] operate-Equal[=]
	 */
	private Long custom2;


	/**
	 * condition-field: 备用字段_2[CUSTOM_2] operate-In[in]
	 */
	private Long[] custom2s;


	/**
	 * condition-field: 备用字段_2[CUSTOM_2] operate-GTEqual[>=]
	 */
	private Long startCustom2;

	/**
	 * condition-field: 备用字段_2[CUSTOM_2] operate-LTEqual[<=]
	 */
	private Long endCustom2;


	/**
	 * condition-field: 备用字段_3[CUSTOM_3] operate-Equal[=]
	 */
	private Long custom3;


	/**
	 * condition-field: 备用字段_3[CUSTOM_3] operate-In[in]
	 */
	private Long[] custom3s;


	/**
	 * condition-field: 备用字段_3[CUSTOM_3] operate-GTEqual[>=]
	 */
	private Long startCustom3;

	/**
	 * condition-field: 备用字段_3[CUSTOM_3] operate-LTEqual[<=]
	 */
	private Long endCustom3;


	/**
	 * condition-field: 备用字段_4[CUSTOM_4] operate-Like[like]
	 */
	private String custom4;


	/**
	 * condition-field: 备用字段_5[CUSTOM_5] operate-Like[like]
	 */
	private String custom5;


	/**
	 * condition-field: 备用字段_6[CUSTOM_6] operate-Like[like]
	 */
	private String custom6;


	/**
	 * condition-field: 部署状态[DEP_STATUS] operate-Equal[=]
	 * 1=就绪 2=部署中 3=部署成功 4=部署失败
	 */
	private Integer depStatus;


	/**
	 * condition-field: 部署状态[DEP_STATUS] operate-In[in]
	 * 1=就绪 2=部署中 3=部署成功 4=部署失败
	 */
	private Integer[] depStatuss;


	/**
	 * condition-field: 部署状态[DEP_STATUS] operate-GTEqual[>=]
	 * 1=就绪 2=部署中 3=部署成功 4=部署失败
	 */
	private Integer startDepStatus;

	/**
	 * condition-field: 部署状态[DEP_STATUS] operate-LTEqual[<=]
	 * 1=就绪 2=部署中 3=部署成功 4=部署失败
	 */
	private Integer endDepStatus;


	/**
	 * condition-field: 运行状态[RUN_STATUS] operate-Equal[=]
	 * 1=待运行 2=运行中 3=停止
	 */
	private Integer runStatus;


	/**
	 * condition-field: 运行状态[RUN_STATUS] operate-In[in]
	 * 1=待运行 2=运行中 3=停止
	 */
	private Integer[] runStatuss;


	/**
	 * condition-field: 运行状态[RUN_STATUS] operate-GTEqual[>=]
	 * 1=待运行 2=运行中 3=停止
	 */
	private Integer startRunStatus;

	/**
	 * condition-field: 运行状态[RUN_STATUS] operate-LTEqual[<=]
	 * 1=待运行 2=运行中 3=停止
	 */
	private Integer endRunStatus;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-Equal[=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer dataStatus;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-In[in]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer[] dataStatuss;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-GTEqual[>=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer startDataStatus;

	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-LTEqual[<=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer endDataStatus;


	/**
	 * condition-field: 创建人[CREATOR] operate-Like[like]
	 */
	private String creator;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-Equal[=]
	 */
	private Long createTime;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-In[in]
	 */
	private Long[] createTimes;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-GTEqual[>=]
	 */
	private Long startCreateTime;

	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-LTEqual[<=]
	 */
	private Long endCreateTime;


	/**
	 * condition-field: 修改人[MODIFIER] operate-Like[like]
	 */
	private String modifier;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-Equal[=]
	 */
	private Long modifyTime;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-In[in]
	 */
	private Long[] modifyTimes;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-GTEqual[>=]
	 */
	private Long startModifyTime;

	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-LTEqual[<=]
	 */
	private Long endModifyTime;




	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public Long[] getIds() {
		return this.ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}


	public Long getStartId() {
		return this.startId;
	}
	public void setStartId(Long startId) {
		this.startId = startId;
	}


	public Long getEndId() {
		return this.endId;
	}
	public void setEndId(Long endId) {
		this.endId = endId;
	}


	public Long getMntId() {
		return this.mntId;
	}
	public void setMntId(Long mntId) {
		this.mntId = mntId;
	}


	public Long[] getMntIds() {
		return this.mntIds;
	}
	public void setMntIds(Long[] mntIds) {
		this.mntIds = mntIds;
	}


	public Long getStartMntId() {
		return this.startMntId;
	}
	public void setStartMntId(Long startMntId) {
		this.startMntId = startMntId;
	}


	public Long getEndMntId() {
		return this.endMntId;
	}
	public void setEndMntId(Long endMntId) {
		this.endMntId = endMntId;
	}


	public Long getAppId() {
		return this.appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}


	public Long[] getAppIds() {
		return this.appIds;
	}
	public void setAppIds(Long[] appIds) {
		this.appIds = appIds;
	}


	public Long getStartAppId() {
		return this.startAppId;
	}
	public void setStartAppId(Long startAppId) {
		this.startAppId = startAppId;
	}


	public Long getEndAppId() {
		return this.endAppId;
	}
	public void setEndAppId(Long endAppId) {
		this.endAppId = endAppId;
	}


	public Long getAppVnoId() {
		return this.appVnoId;
	}
	public void setAppVnoId(Long appVnoId) {
		this.appVnoId = appVnoId;
	}


	public Long[] getAppVnoIds() {
		return this.appVnoIds;
	}
	public void setAppVnoIds(Long[] appVnoIds) {
		this.appVnoIds = appVnoIds;
	}


	public Long getStartAppVnoId() {
		return this.startAppVnoId;
	}
	public void setStartAppVnoId(Long startAppVnoId) {
		this.startAppVnoId = startAppVnoId;
	}


	public Long getEndAppVnoId() {
		return this.endAppVnoId;
	}
	public void setEndAppVnoId(Long endAppVnoId) {
		this.endAppVnoId = endAppVnoId;
	}


	public String getAppCode() {
		return this.appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}


	public String getAppCodeEqual() {
		return this.appCodeEqual;
	}
	public void setAppCodeEqual(String appCodeEqual) {
		this.appCodeEqual = appCodeEqual;
	}


	public String[] getAppCodes() {
		return this.appCodes;
	}
	public void setAppCodes(String[] appCodes) {
		this.appCodes = appCodes;
	}


	public String getAppName() {
		return this.appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}


	public String getAppNameEqual() {
		return this.appNameEqual;
	}
	public void setAppNameEqual(String appNameEqual) {
		this.appNameEqual = appNameEqual;
	}


	public String[] getAppNames() {
		return this.appNames;
	}
	public void setAppNames(String[] appNames) {
		this.appNames = appNames;
	}


	public String getAppVersionNo() {
		return this.appVersionNo;
	}
	public void setAppVersionNo(String appVersionNo) {
		this.appVersionNo = appVersionNo;
	}


	public String getAppVersionNoEqual() {
		return this.appVersionNoEqual;
	}
	public void setAppVersionNoEqual(String appVersionNoEqual) {
		this.appVersionNoEqual = appVersionNoEqual;
	}


	public String[] getAppVersionNos() {
		return this.appVersionNos;
	}
	public void setAppVersionNos(String[] appVersionNos) {
		this.appVersionNos = appVersionNos;
	}


	public Long getImageId() {
		return this.imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}


	public Long[] getImageIds() {
		return this.imageIds;
	}
	public void setImageIds(Long[] imageIds) {
		this.imageIds = imageIds;
	}


	public Long getStartImageId() {
		return this.startImageId;
	}
	public void setStartImageId(Long startImageId) {
		this.startImageId = startImageId;
	}


	public Long getEndImageId() {
		return this.endImageId;
	}
	public void setEndImageId(Long endImageId) {
		this.endImageId = endImageId;
	}


	public Long getImageDefId() {
		return this.imageDefId;
	}
	public void setImageDefId(Long imageDefId) {
		this.imageDefId = imageDefId;
	}


	public Long[] getImageDefIds() {
		return this.imageDefIds;
	}
	public void setImageDefIds(Long[] imageDefIds) {
		this.imageDefIds = imageDefIds;
	}


	public Long getStartImageDefId() {
		return this.startImageDefId;
	}
	public void setStartImageDefId(Long startImageDefId) {
		this.startImageDefId = startImageDefId;
	}


	public Long getEndImageDefId() {
		return this.endImageDefId;
	}
	public void setEndImageDefId(Long endImageDefId) {
		this.endImageDefId = endImageDefId;
	}


	public Long getImageRespId() {
		return this.imageRespId;
	}
	public void setImageRespId(Long imageRespId) {
		this.imageRespId = imageRespId;
	}


	public Long[] getImageRespIds() {
		return this.imageRespIds;
	}
	public void setImageRespIds(Long[] imageRespIds) {
		this.imageRespIds = imageRespIds;
	}


	public Long getStartImageRespId() {
		return this.startImageRespId;
	}
	public void setStartImageRespId(Long startImageRespId) {
		this.startImageRespId = startImageRespId;
	}


	public Long getEndImageRespId() {
		return this.endImageRespId;
	}
	public void setEndImageRespId(Long endImageRespId) {
		this.endImageRespId = endImageRespId;
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


	public String getBuildNoEqual() {
		return this.buildNoEqual;
	}
	public void setBuildNoEqual(String buildNoEqual) {
		this.buildNoEqual = buildNoEqual;
	}


	public String[] getBuildNos() {
		return this.buildNos;
	}
	public void setBuildNos(String[] buildNos) {
		this.buildNos = buildNos;
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


	public Long[] getDataCenterIds() {
		return this.dataCenterIds;
	}
	public void setDataCenterIds(Long[] dataCenterIds) {
		this.dataCenterIds = dataCenterIds;
	}


	public Long getStartDataCenterId() {
		return this.startDataCenterId;
	}
	public void setStartDataCenterId(Long startDataCenterId) {
		this.startDataCenterId = startDataCenterId;
	}


	public Long getEndDataCenterId() {
		return this.endDataCenterId;
	}
	public void setEndDataCenterId(Long endDataCenterId) {
		this.endDataCenterId = endDataCenterId;
	}


	public Long getResCenterId() {
		return this.resCenterId;
	}
	public void setResCenterId(Long resCenterId) {
		this.resCenterId = resCenterId;
	}


	public Long[] getResCenterIds() {
		return this.resCenterIds;
	}
	public void setResCenterIds(Long[] resCenterIds) {
		this.resCenterIds = resCenterIds;
	}


	public Long getStartResCenterId() {
		return this.startResCenterId;
	}
	public void setStartResCenterId(Long startResCenterId) {
		this.startResCenterId = startResCenterId;
	}


	public Long getEndResCenterId() {
		return this.endResCenterId;
	}
	public void setEndResCenterId(Long endResCenterId) {
		this.endResCenterId = endResCenterId;
	}


	public Long getNetZoneId() {
		return this.netZoneId;
	}
	public void setNetZoneId(Long netZoneId) {
		this.netZoneId = netZoneId;
	}


	public Long[] getNetZoneIds() {
		return this.netZoneIds;
	}
	public void setNetZoneIds(Long[] netZoneIds) {
		this.netZoneIds = netZoneIds;
	}


	public Long getStartNetZoneId() {
		return this.startNetZoneId;
	}
	public void setStartNetZoneId(Long startNetZoneId) {
		this.startNetZoneId = startNetZoneId;
	}


	public Long getEndNetZoneId() {
		return this.endNetZoneId;
	}
	public void setEndNetZoneId(Long endNetZoneId) {
		this.endNetZoneId = endNetZoneId;
	}


	public Integer getCpuCount() {
		return this.cpuCount;
	}
	public void setCpuCount(Integer cpuCount) {
		this.cpuCount = cpuCount;
	}


	public Integer[] getCpuCounts() {
		return this.cpuCounts;
	}
	public void setCpuCounts(Integer[] cpuCounts) {
		this.cpuCounts = cpuCounts;
	}


	public Integer getStartCpuCount() {
		return this.startCpuCount;
	}
	public void setStartCpuCount(Integer startCpuCount) {
		this.startCpuCount = startCpuCount;
	}


	public Integer getEndCpuCount() {
		return this.endCpuCount;
	}
	public void setEndCpuCount(Integer endCpuCount) {
		this.endCpuCount = endCpuCount;
	}


	public Long getMemSize() {
		return this.memSize;
	}
	public void setMemSize(Long memSize) {
		this.memSize = memSize;
	}


	public Long[] getMemSizes() {
		return this.memSizes;
	}
	public void setMemSizes(Long[] memSizes) {
		this.memSizes = memSizes;
	}


	public Long getStartMemSize() {
		return this.startMemSize;
	}
	public void setStartMemSize(Long startMemSize) {
		this.startMemSize = startMemSize;
	}


	public Long getEndMemSize() {
		return this.endMemSize;
	}
	public void setEndMemSize(Long endMemSize) {
		this.endMemSize = endMemSize;
	}


	public Long getDiskSize() {
		return this.diskSize;
	}
	public void setDiskSize(Long diskSize) {
		this.diskSize = diskSize;
	}


	public Long[] getDiskSizes() {
		return this.diskSizes;
	}
	public void setDiskSizes(Long[] diskSizes) {
		this.diskSizes = diskSizes;
	}


	public Long getStartDiskSize() {
		return this.startDiskSize;
	}
	public void setStartDiskSize(Long startDiskSize) {
		this.startDiskSize = startDiskSize;
	}


	public Long getEndDiskSize() {
		return this.endDiskSize;
	}
	public void setEndDiskSize(Long endDiskSize) {
		this.endDiskSize = endDiskSize;
	}


	public Integer getInstanceCount() {
		return this.instanceCount;
	}
	public void setInstanceCount(Integer instanceCount) {
		this.instanceCount = instanceCount;
	}


	public Integer[] getInstanceCounts() {
		return this.instanceCounts;
	}
	public void setInstanceCounts(Integer[] instanceCounts) {
		this.instanceCounts = instanceCounts;
	}


	public Integer getStartInstanceCount() {
		return this.startInstanceCount;
	}
	public void setStartInstanceCount(Integer startInstanceCount) {
		this.startInstanceCount = startInstanceCount;
	}


	public Integer getEndInstanceCount() {
		return this.endInstanceCount;
	}
	public void setEndInstanceCount(Integer endInstanceCount) {
		this.endInstanceCount = endInstanceCount;
	}


	public Integer getIsSupportFlex() {
		return this.isSupportFlex;
	}
	public void setIsSupportFlex(Integer isSupportFlex) {
		this.isSupportFlex = isSupportFlex;
	}


	public Integer[] getIsSupportFlexs() {
		return this.isSupportFlexs;
	}
	public void setIsSupportFlexs(Integer[] isSupportFlexs) {
		this.isSupportFlexs = isSupportFlexs;
	}


	public Integer getStartIsSupportFlex() {
		return this.startIsSupportFlex;
	}
	public void setStartIsSupportFlex(Integer startIsSupportFlex) {
		this.startIsSupportFlex = startIsSupportFlex;
	}


	public Integer getEndIsSupportFlex() {
		return this.endIsSupportFlex;
	}
	public void setEndIsSupportFlex(Integer endIsSupportFlex) {
		this.endIsSupportFlex = endIsSupportFlex;
	}


	public Integer getCpuFlexUpperLimit() {
		return this.cpuFlexUpperLimit;
	}
	public void setCpuFlexUpperLimit(Integer cpuFlexUpperLimit) {
		this.cpuFlexUpperLimit = cpuFlexUpperLimit;
	}


	public Integer[] getCpuFlexUpperLimits() {
		return this.cpuFlexUpperLimits;
	}
	public void setCpuFlexUpperLimits(Integer[] cpuFlexUpperLimits) {
		this.cpuFlexUpperLimits = cpuFlexUpperLimits;
	}


	public Integer getStartCpuFlexUpperLimit() {
		return this.startCpuFlexUpperLimit;
	}
	public void setStartCpuFlexUpperLimit(Integer startCpuFlexUpperLimit) {
		this.startCpuFlexUpperLimit = startCpuFlexUpperLimit;
	}


	public Integer getEndCpuFlexUpperLimit() {
		return this.endCpuFlexUpperLimit;
	}
	public void setEndCpuFlexUpperLimit(Integer endCpuFlexUpperLimit) {
		this.endCpuFlexUpperLimit = endCpuFlexUpperLimit;
	}


	public Integer getCpuFlexLowerLimit() {
		return this.cpuFlexLowerLimit;
	}
	public void setCpuFlexLowerLimit(Integer cpuFlexLowerLimit) {
		this.cpuFlexLowerLimit = cpuFlexLowerLimit;
	}


	public Integer[] getCpuFlexLowerLimits() {
		return this.cpuFlexLowerLimits;
	}
	public void setCpuFlexLowerLimits(Integer[] cpuFlexLowerLimits) {
		this.cpuFlexLowerLimits = cpuFlexLowerLimits;
	}


	public Integer getStartCpuFlexLowerLimit() {
		return this.startCpuFlexLowerLimit;
	}
	public void setStartCpuFlexLowerLimit(Integer startCpuFlexLowerLimit) {
		this.startCpuFlexLowerLimit = startCpuFlexLowerLimit;
	}


	public Integer getEndCpuFlexLowerLimit() {
		return this.endCpuFlexLowerLimit;
	}
	public void setEndCpuFlexLowerLimit(Integer endCpuFlexLowerLimit) {
		this.endCpuFlexLowerLimit = endCpuFlexLowerLimit;
	}


	public Integer getMaxInstanceCount() {
		return this.maxInstanceCount;
	}
	public void setMaxInstanceCount(Integer maxInstanceCount) {
		this.maxInstanceCount = maxInstanceCount;
	}


	public Integer[] getMaxInstanceCounts() {
		return this.maxInstanceCounts;
	}
	public void setMaxInstanceCounts(Integer[] maxInstanceCounts) {
		this.maxInstanceCounts = maxInstanceCounts;
	}


	public Integer getStartMaxInstanceCount() {
		return this.startMaxInstanceCount;
	}
	public void setStartMaxInstanceCount(Integer startMaxInstanceCount) {
		this.startMaxInstanceCount = startMaxInstanceCount;
	}


	public Integer getEndMaxInstanceCount() {
		return this.endMaxInstanceCount;
	}
	public void setEndMaxInstanceCount(Integer endMaxInstanceCount) {
		this.endMaxInstanceCount = endMaxInstanceCount;
	}


	public Integer getMinInstanceCount() {
		return this.minInstanceCount;
	}
	public void setMinInstanceCount(Integer minInstanceCount) {
		this.minInstanceCount = minInstanceCount;
	}


	public Integer[] getMinInstanceCounts() {
		return this.minInstanceCounts;
	}
	public void setMinInstanceCounts(Integer[] minInstanceCounts) {
		this.minInstanceCounts = minInstanceCounts;
	}


	public Integer getStartMinInstanceCount() {
		return this.startMinInstanceCount;
	}
	public void setStartMinInstanceCount(Integer startMinInstanceCount) {
		this.startMinInstanceCount = startMinInstanceCount;
	}


	public Integer getEndMinInstanceCount() {
		return this.endMinInstanceCount;
	}
	public void setEndMinInstanceCount(Integer endMinInstanceCount) {
		this.endMinInstanceCount = endMinInstanceCount;
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


	public Integer[] getIsUniforms() {
		return this.isUniforms;
	}
	public void setIsUniforms(Integer[] isUniforms) {
		this.isUniforms = isUniforms;
	}


	public Integer getStartIsUniform() {
		return this.startIsUniform;
	}
	public void setStartIsUniform(Integer startIsUniform) {
		this.startIsUniform = startIsUniform;
	}


	public Integer getEndIsUniform() {
		return this.endIsUniform;
	}
	public void setEndIsUniform(Integer endIsUniform) {
		this.endIsUniform = endIsUniform;
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


	public Long[] getCustom1s() {
		return this.custom1s;
	}
	public void setCustom1s(Long[] custom1s) {
		this.custom1s = custom1s;
	}


	public Long getStartCustom1() {
		return this.startCustom1;
	}
	public void setStartCustom1(Long startCustom1) {
		this.startCustom1 = startCustom1;
	}


	public Long getEndCustom1() {
		return this.endCustom1;
	}
	public void setEndCustom1(Long endCustom1) {
		this.endCustom1 = endCustom1;
	}


	public Long getCustom2() {
		return this.custom2;
	}
	public void setCustom2(Long custom2) {
		this.custom2 = custom2;
	}


	public Long[] getCustom2s() {
		return this.custom2s;
	}
	public void setCustom2s(Long[] custom2s) {
		this.custom2s = custom2s;
	}


	public Long getStartCustom2() {
		return this.startCustom2;
	}
	public void setStartCustom2(Long startCustom2) {
		this.startCustom2 = startCustom2;
	}


	public Long getEndCustom2() {
		return this.endCustom2;
	}
	public void setEndCustom2(Long endCustom2) {
		this.endCustom2 = endCustom2;
	}


	public Long getCustom3() {
		return this.custom3;
	}
	public void setCustom3(Long custom3) {
		this.custom3 = custom3;
	}


	public Long[] getCustom3s() {
		return this.custom3s;
	}
	public void setCustom3s(Long[] custom3s) {
		this.custom3s = custom3s;
	}


	public Long getStartCustom3() {
		return this.startCustom3;
	}
	public void setStartCustom3(Long startCustom3) {
		this.startCustom3 = startCustom3;
	}


	public Long getEndCustom3() {
		return this.endCustom3;
	}
	public void setEndCustom3(Long endCustom3) {
		this.endCustom3 = endCustom3;
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


	public Integer[] getDepStatuss() {
		return this.depStatuss;
	}
	public void setDepStatuss(Integer[] depStatuss) {
		this.depStatuss = depStatuss;
	}


	public Integer getStartDepStatus() {
		return this.startDepStatus;
	}
	public void setStartDepStatus(Integer startDepStatus) {
		this.startDepStatus = startDepStatus;
	}


	public Integer getEndDepStatus() {
		return this.endDepStatus;
	}
	public void setEndDepStatus(Integer endDepStatus) {
		this.endDepStatus = endDepStatus;
	}


	public Integer getRunStatus() {
		return this.runStatus;
	}
	public void setRunStatus(Integer runStatus) {
		this.runStatus = runStatus;
	}


	public Integer[] getRunStatuss() {
		return this.runStatuss;
	}
	public void setRunStatuss(Integer[] runStatuss) {
		this.runStatuss = runStatuss;
	}


	public Integer getStartRunStatus() {
		return this.startRunStatus;
	}
	public void setStartRunStatus(Integer startRunStatus) {
		this.startRunStatus = startRunStatus;
	}


	public Integer getEndRunStatus() {
		return this.endRunStatus;
	}
	public void setEndRunStatus(Integer endRunStatus) {
		this.endRunStatus = endRunStatus;
	}


	public Integer getDataStatus() {
		return this.dataStatus;
	}
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}


	public Integer[] getDataStatuss() {
		return this.dataStatuss;
	}
	public void setDataStatuss(Integer[] dataStatuss) {
		this.dataStatuss = dataStatuss;
	}


	public Integer getStartDataStatus() {
		return this.startDataStatus;
	}
	public void setStartDataStatus(Integer startDataStatus) {
		this.startDataStatus = startDataStatus;
	}


	public Integer getEndDataStatus() {
		return this.endDataStatus;
	}
	public void setEndDataStatus(Integer endDataStatus) {
		this.endDataStatus = endDataStatus;
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


	public Long[] getCreateTimes() {
		return this.createTimes;
	}
	public void setCreateTimes(Long[] createTimes) {
		this.createTimes = createTimes;
	}


	public Long getStartCreateTime() {
		return this.startCreateTime;
	}
	public void setStartCreateTime(Long startCreateTime) {
		this.startCreateTime = startCreateTime;
	}


	public Long getEndCreateTime() {
		return this.endCreateTime;
	}
	public void setEndCreateTime(Long endCreateTime) {
		this.endCreateTime = endCreateTime;
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


	public Long[] getModifyTimes() {
		return this.modifyTimes;
	}
	public void setModifyTimes(Long[] modifyTimes) {
		this.modifyTimes = modifyTimes;
	}


	public Long getStartModifyTime() {
		return this.startModifyTime;
	}
	public void setStartModifyTime(Long startModifyTime) {
		this.startModifyTime = startModifyTime;
	}


	public Long getEndModifyTime() {
		return this.endModifyTime;
	}
	public void setEndModifyTime(Long endModifyTime) {
		this.endModifyTime = endModifyTime;
	}


}


