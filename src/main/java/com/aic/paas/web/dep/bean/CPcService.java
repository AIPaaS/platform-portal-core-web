package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 服务表[PC_SERVICE]
 */
public class CPcService implements Condition {
	private static final long serialVersionUID = 1L;


	/**
	 * condition-field: ID[ID] operate-Equal[=]
	 */
	private Long id;


	/**
	 * condition-field: ID[ID] operate-In[in]
	 */
	private Long[] ids;


	/**
	 * condition-field: ID[ID] operate-GTEqual[>=]
	 */
	private Long startId;

	/**
	 * condition-field: ID[ID] operate-LTEqual[<=]
	 */
	private Long endId;


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
	 * condition-field: 服务代码[SVC_CODE] operate-Like[like]
	 */
	private String svcCode;


	/**
	 * condition-field: 服务名称[SVC_NAME] operate-Like[like]
	 */
	private String svcName;


	/**
	 * condition-field: 开放协议[PROTOCOL] operate-Equal[=]
	 * 1=HTTP 2=TPC
	 */
	private Integer protocol;


	/**
	 * condition-field: 开放协议[PROTOCOL] operate-In[in]
	 * 1=HTTP 2=TPC
	 */
	private Integer[] protocols;


	/**
	 * condition-field: 开放协议[PROTOCOL] operate-GTEqual[>=]
	 * 1=HTTP 2=TPC
	 */
	private Integer startProtocol;

	/**
	 * condition-field: 开放协议[PROTOCOL] operate-LTEqual[<=]
	 * 1=HTTP 2=TPC
	 */
	private Integer endProtocol;


	/**
	 * condition-field: 开放端口[PORT] operate-Equal[=]
	 */
	private Integer port;


	/**
	 * condition-field: 开放端口[PORT] operate-In[in]
	 */
	private Integer[] ports;


	/**
	 * condition-field: 开放端口[PORT] operate-GTEqual[>=]
	 */
	private Integer startPort;

	/**
	 * condition-field: 开放端口[PORT] operate-LTEqual[<=]
	 */
	private Integer endPort;


	/**
	 * condition-field: 开放URL[SVC_URL] operate-Like[like]
	 */
	private String svcUrl;


	/**
	 * condition-field: 服务类型[SVC_TYPE] operate-Equal[=]
	 * 1=平台服务 2=外部服务 3=镜像服务
	 */
	private Integer svcType;


	/**
	 * condition-field: 服务类型[SVC_TYPE] operate-In[in]
	 * 1=平台服务 2=外部服务 3=镜像服务
	 */
	private Integer[] svcTypes;


	/**
	 * condition-field: 服务类型[SVC_TYPE] operate-GTEqual[>=]
	 * 1=平台服务 2=外部服务 3=镜像服务
	 */
	private Integer startSvcType;

	/**
	 * condition-field: 服务类型[SVC_TYPE] operate-LTEqual[<=]
	 * 1=平台服务 2=外部服务 3=镜像服务
	 */
	private Integer endSvcType;


	/**
	 * condition-field: 所属租户[MNT_ID] operate-Equal[=]
	 * 外部服务\镜像服务 需指定租户
	 */
	private Long mntId;


	/**
	 * condition-field: 所属租户[MNT_ID] operate-In[in]
	 * 外部服务\镜像服务 需指定租户
	 */
	private Long[] mntIds;


	/**
	 * condition-field: 所属租户[MNT_ID] operate-GTEqual[>=]
	 * 外部服务\镜像服务 需指定租户
	 */
	private Long startMntId;

	/**
	 * condition-field: 所属租户[MNT_ID] operate-LTEqual[<=]
	 * 外部服务\镜像服务 需指定租户
	 */
	private Long endMntId;


	/**
	 * condition-field: 监控URL[MONITOR_URL] operate-Like[like]
	 */
	private String monitorUrl;


	/**
	 * condition-field: 状态[STATUS] operate-Equal[=]
	 * 1=有效 0=无效
	 */
	private Integer status;


	/**
	 * condition-field: 状态[STATUS] operate-In[in]
	 * 1=有效 0=无效
	 */
	private Integer[] statuss;


	/**
	 * condition-field: 状态[STATUS] operate-GTEqual[>=]
	 * 1=有效 0=无效
	 */
	private Integer startStatus;

	/**
	 * condition-field: 状态[STATUS] operate-LTEqual[<=]
	 * 1=有效 0=无效
	 */
	private Integer endStatus;


	/**
	 * condition-field: 负责人ID[DUTIER_ID] operate-Equal[=]
	 * 平台服务字段
	 */
	private Long dutierId;


	/**
	 * condition-field: 负责人ID[DUTIER_ID] operate-In[in]
	 * 平台服务字段
	 */
	private Long[] dutierIds;


	/**
	 * condition-field: 负责人ID[DUTIER_ID] operate-GTEqual[>=]
	 * 平台服务字段
	 */
	private Long startDutierId;

	/**
	 * condition-field: 负责人ID[DUTIER_ID] operate-LTEqual[<=]
	 * 平台服务字段
	 */
	private Long endDutierId;


	/**
	 * condition-field: 负责人姓名[DUTIER_NAME] operate-Like[like]
	 * 平台服务字段
	 */
	private String dutierName;


	/**
	 * condition-field: 负责人姓名[DUTIER_NAME] operate-Equal[=]
	 * 平台服务字段
	 */
	private String dutierNameEqual;


	/**
	 * condition-field: 负责人姓名[DUTIER_NAME] operate-In[in]
	 * 平台服务字段
	 */
	private String[] dutierNames;


	/**
	 * condition-field: 负责人电话[DUTIER_PHONE] operate-Like[like]
	 * 平台服务字段
	 */
	private String dutierPhone;


	/**
	 * condition-field: 负责人电话[DUTIER_PHONE] operate-Equal[=]
	 * 平台服务字段
	 */
	private String dutierPhoneEqual;


	/**
	 * condition-field: 负责人电话[DUTIER_PHONE] operate-In[in]
	 * 平台服务字段
	 */
	private String[] dutierPhones;


	/**
	 * condition-field: 负责人邮箱[DUTIER_EMAIL] operate-Like[like]
	 * 平台服务字段
	 */
	private String dutierEmail;


	/**
	 * condition-field: 发布时间[DEP_TIME] operate-Equal[=]
	 * 平台服务字段
	 */
	private Long depTime;


	/**
	 * condition-field: 发布时间[DEP_TIME] operate-In[in]
	 * 平台服务字段
	 */
	private Long[] depTimes;


	/**
	 * condition-field: 发布时间[DEP_TIME] operate-GTEqual[>=]
	 * 平台服务字段
	 */
	private Long startDepTime;

	/**
	 * condition-field: 发布时间[DEP_TIME] operate-LTEqual[<=]
	 * 平台服务字段
	 */
	private Long endDepTime;


	/**
	 * condition-field: 所属应用[APP_ID] operate-Equal[=]
	 * 外部服务字段（暂不用）
	 */
	private Long appId;


	/**
	 * condition-field: 所属应用[APP_ID] operate-In[in]
	 * 外部服务字段（暂不用）
	 */
	private Long[] appIds;


	/**
	 * condition-field: 所属应用[APP_ID] operate-GTEqual[>=]
	 * 外部服务字段（暂不用）
	 */
	private Long startAppId;

	/**
	 * condition-field: 所属应用[APP_ID] operate-LTEqual[<=]
	 * 外部服务字段（暂不用）
	 */
	private Long endAppId;


	/**
	 * condition-field: 创建人ID[USER_ID] operate-Equal[=]
	 * 外部服务字段
	 */
	private Long userId;


	/**
	 * condition-field: 创建人ID[USER_ID] operate-In[in]
	 * 外部服务字段
	 */
	private Long[] userIds;


	/**
	 * condition-field: 创建人ID[USER_ID] operate-GTEqual[>=]
	 * 外部服务字段
	 */
	private Long startUserId;

	/**
	 * condition-field: 创建人ID[USER_ID] operate-LTEqual[<=]
	 * 外部服务字段
	 */
	private Long endUserId;


	/**
	 * condition-field: 创建姓名[USER_NAME] operate-Like[like]
	 * 外部服务字段
	 */
	private String userName;


	/**
	 * condition-field: 创建姓名[USER_NAME] operate-Equal[=]
	 * 外部服务字段
	 */
	private String userNameEqual;


	/**
	 * condition-field: 创建姓名[USER_NAME] operate-In[in]
	 * 外部服务字段
	 */
	private String[] userNames;


	/**
	 * condition-field: 所属应用镜像[APP_IMAGE_ID] operate-Equal[=]
	 * 应用服务定义表
	 */
	private Long appImageId;


	/**
	 * condition-field: 所属应用镜像[APP_IMAGE_ID] operate-In[in]
	 * 应用服务定义表
	 */
	private Long[] appImageIds;


	/**
	 * condition-field: 所属应用镜像[APP_IMAGE_ID] operate-GTEqual[>=]
	 * 应用服务定义表
	 */
	private Long startAppImageId;

	/**
	 * condition-field: 所属应用镜像[APP_IMAGE_ID] operate-LTEqual[<=]
	 * 应用服务定义表
	 */
	private Long endAppImageId;


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
	 * condition-field: 创建时间[CREATE_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long createTime;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] createTimes;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startCreateTime;

	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endCreateTime;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long modifyTime;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] modifyTimes;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startModifyTime;

	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
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


	public String getSvcCode() {
		return this.svcCode;
	}
	public void setSvcCode(String svcCode) {
		this.svcCode = svcCode;
	}


	public String getSvcName() {
		return this.svcName;
	}
	public void setSvcName(String svcName) {
		this.svcName = svcName;
	}


	public Integer getProtocol() {
		return this.protocol;
	}
	public void setProtocol(Integer protocol) {
		this.protocol = protocol;
	}


	public Integer[] getProtocols() {
		return this.protocols;
	}
	public void setProtocols(Integer[] protocols) {
		this.protocols = protocols;
	}


	public Integer getStartProtocol() {
		return this.startProtocol;
	}
	public void setStartProtocol(Integer startProtocol) {
		this.startProtocol = startProtocol;
	}


	public Integer getEndProtocol() {
		return this.endProtocol;
	}
	public void setEndProtocol(Integer endProtocol) {
		this.endProtocol = endProtocol;
	}


	public Integer getPort() {
		return this.port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}


	public Integer[] getPorts() {
		return this.ports;
	}
	public void setPorts(Integer[] ports) {
		this.ports = ports;
	}


	public Integer getStartPort() {
		return this.startPort;
	}
	public void setStartPort(Integer startPort) {
		this.startPort = startPort;
	}


	public Integer getEndPort() {
		return this.endPort;
	}
	public void setEndPort(Integer endPort) {
		this.endPort = endPort;
	}


	public String getSvcUrl() {
		return this.svcUrl;
	}
	public void setSvcUrl(String svcUrl) {
		this.svcUrl = svcUrl;
	}


	public Integer getSvcType() {
		return this.svcType;
	}
	public void setSvcType(Integer svcType) {
		this.svcType = svcType;
	}


	public Integer[] getSvcTypes() {
		return this.svcTypes;
	}
	public void setSvcTypes(Integer[] svcTypes) {
		this.svcTypes = svcTypes;
	}


	public Integer getStartSvcType() {
		return this.startSvcType;
	}
	public void setStartSvcType(Integer startSvcType) {
		this.startSvcType = startSvcType;
	}


	public Integer getEndSvcType() {
		return this.endSvcType;
	}
	public void setEndSvcType(Integer endSvcType) {
		this.endSvcType = endSvcType;
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


	public String getMonitorUrl() {
		return this.monitorUrl;
	}
	public void setMonitorUrl(String monitorUrl) {
		this.monitorUrl = monitorUrl;
	}


	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer[] getStatuss() {
		return this.statuss;
	}
	public void setStatuss(Integer[] statuss) {
		this.statuss = statuss;
	}


	public Integer getStartStatus() {
		return this.startStatus;
	}
	public void setStartStatus(Integer startStatus) {
		this.startStatus = startStatus;
	}


	public Integer getEndStatus() {
		return this.endStatus;
	}
	public void setEndStatus(Integer endStatus) {
		this.endStatus = endStatus;
	}


	public Long getDutierId() {
		return this.dutierId;
	}
	public void setDutierId(Long dutierId) {
		this.dutierId = dutierId;
	}


	public Long[] getDutierIds() {
		return this.dutierIds;
	}
	public void setDutierIds(Long[] dutierIds) {
		this.dutierIds = dutierIds;
	}


	public Long getStartDutierId() {
		return this.startDutierId;
	}
	public void setStartDutierId(Long startDutierId) {
		this.startDutierId = startDutierId;
	}


	public Long getEndDutierId() {
		return this.endDutierId;
	}
	public void setEndDutierId(Long endDutierId) {
		this.endDutierId = endDutierId;
	}


	public String getDutierName() {
		return this.dutierName;
	}
	public void setDutierName(String dutierName) {
		this.dutierName = dutierName;
	}


	public String getDutierNameEqual() {
		return this.dutierNameEqual;
	}
	public void setDutierNameEqual(String dutierNameEqual) {
		this.dutierNameEqual = dutierNameEqual;
	}


	public String[] getDutierNames() {
		return this.dutierNames;
	}
	public void setDutierNames(String[] dutierNames) {
		this.dutierNames = dutierNames;
	}


	public String getDutierPhone() {
		return this.dutierPhone;
	}
	public void setDutierPhone(String dutierPhone) {
		this.dutierPhone = dutierPhone;
	}


	public String getDutierPhoneEqual() {
		return this.dutierPhoneEqual;
	}
	public void setDutierPhoneEqual(String dutierPhoneEqual) {
		this.dutierPhoneEqual = dutierPhoneEqual;
	}


	public String[] getDutierPhones() {
		return this.dutierPhones;
	}
	public void setDutierPhones(String[] dutierPhones) {
		this.dutierPhones = dutierPhones;
	}


	public String getDutierEmail() {
		return this.dutierEmail;
	}
	public void setDutierEmail(String dutierEmail) {
		this.dutierEmail = dutierEmail;
	}


	public Long getDepTime() {
		return this.depTime;
	}
	public void setDepTime(Long depTime) {
		this.depTime = depTime;
	}


	public Long[] getDepTimes() {
		return this.depTimes;
	}
	public void setDepTimes(Long[] depTimes) {
		this.depTimes = depTimes;
	}


	public Long getStartDepTime() {
		return this.startDepTime;
	}
	public void setStartDepTime(Long startDepTime) {
		this.startDepTime = startDepTime;
	}


	public Long getEndDepTime() {
		return this.endDepTime;
	}
	public void setEndDepTime(Long endDepTime) {
		this.endDepTime = endDepTime;
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


	public Long getUserId() {
		return this.userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long[] getUserIds() {
		return this.userIds;
	}
	public void setUserIds(Long[] userIds) {
		this.userIds = userIds;
	}


	public Long getStartUserId() {
		return this.startUserId;
	}
	public void setStartUserId(Long startUserId) {
		this.startUserId = startUserId;
	}


	public Long getEndUserId() {
		return this.endUserId;
	}
	public void setEndUserId(Long endUserId) {
		this.endUserId = endUserId;
	}


	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserNameEqual() {
		return this.userNameEqual;
	}
	public void setUserNameEqual(String userNameEqual) {
		this.userNameEqual = userNameEqual;
	}


	public String[] getUserNames() {
		return this.userNames;
	}
	public void setUserNames(String[] userNames) {
		this.userNames = userNames;
	}


	public Long getAppImageId() {
		return this.appImageId;
	}
	public void setAppImageId(Long appImageId) {
		this.appImageId = appImageId;
	}


	public Long[] getAppImageIds() {
		return this.appImageIds;
	}
	public void setAppImageIds(Long[] appImageIds) {
		this.appImageIds = appImageIds;
	}


	public Long getStartAppImageId() {
		return this.startAppImageId;
	}
	public void setStartAppImageId(Long startAppImageId) {
		this.startAppImageId = startAppImageId;
	}


	public Long getEndAppImageId() {
		return this.endAppImageId;
	}
	public void setEndAppImageId(Long endAppImageId) {
		this.endAppImageId = endAppImageId;
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


