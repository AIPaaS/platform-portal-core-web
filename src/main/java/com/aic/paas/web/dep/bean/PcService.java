package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 服务表[PC_SERVICE]
 */
public class PcService implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 所属数据中心[DATA_CENTER_ID]
	 */
	private Long dataCenterId;


	/**
	 * mapping-field: 所属资源中心[RES_CENTER_ID]
	 */
	private Long resCenterId;


	/**
	 * mapping-field: 服务代码[SVC_CODE]
	 */
	private String svcCode;


	/**
	 * mapping-field: 服务名称[SVC_NAME]
	 */
	private String svcName;


	/**
	 * mapping-field: 开放协议[PROTOCOL]
	 * 1=HTTP 2=TPC
	 */
	private Integer protocol;


	/**
	 * mapping-field: IP[IP]
	 */
	private String ip;


	/**
	 * mapping-field: 开放端口[PORT]
	 */
	private Integer port;


	/**
	 * mapping-field: 开放URL[SVC_URL]
	 */
	private String svcUrl;


	/**
	 * mapping-field: 服务DNS[DOMAIN_NAME]
	 */
	private String domainName;


	/**
	 * mapping-field: 服务类型[SVC_TYPE]
	 * 1=平台服务 2=外部服务 3=镜像服务
	 */
	private Integer svcType;


	/**
	 * mapping-field: 所属租户[MNT_ID]
	 * 外部服务\镜像服务 需指定租户
	 */
	private Long mntId;


	/**
	 * mapping-field: 监控URL[MONITOR_URL]
	 */
	private String monitorUrl;


	/**
	 * mapping-field: 状态[STATUS]
	 * 1=有效 0=无效
	 */
	private Integer status;


	/**
	 * mapping-field: 负责人ID[DUTIER_ID]
	 * 平台服务字段
	 */
	private Long dutierId;


	/**
	 * mapping-field: 负责人姓名[DUTIER_NAME]
	 * 平台服务字段
	 */
	private String dutierName;


	/**
	 * mapping-field: 负责人电话[DUTIER_PHONE]
	 * 平台服务字段
	 */
	private String dutierPhone;


	/**
	 * mapping-field: 负责人邮箱[DUTIER_EMAIL]
	 * 平台服务字段
	 */
	private String dutierEmail;


	/**
	 * mapping-field: 发布时间[DEP_TIME]
	 * 平台服务字段
	 */
	private Long depTime;


	/**
	 * mapping-field: 创建人ID[USER_ID]
	 * 外部服务字段
	 */
	private Long userId;


	/**
	 * mapping-field: 创建姓名[USER_NAME]
	 * 外部服务字段
	 */
	private String userName;


	/**
	 * mapping-field: 所属应用[APP_ID]
	 * 应用服务定义表
	 */
	private Long appId;


	/**
	 * mapping-field: 所属应用镜像[APP_IMAGE_ID]
	 * 应用服务定义表
	 */
	private Long appImageId;


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
	 * mapping-field: 数据状态[DATA_STATUS]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer dataStatus;


	/**
	 * mapping-field: 创建时间[CREATE_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long createTime;


	/**
	 * mapping-field: 修改时间[MODIFY_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long modifyTime;




	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
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


	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}


	public Integer getPort() {
		return this.port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}


	public String getSvcUrl() {
		return this.svcUrl;
	}
	public void setSvcUrl(String svcUrl) {
		this.svcUrl = svcUrl;
	}


	public String getDomainName() {
		return this.domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}


	public Integer getSvcType() {
		return this.svcType;
	}
	public void setSvcType(Integer svcType) {
		this.svcType = svcType;
	}


	public Long getMntId() {
		return this.mntId;
	}
	public void setMntId(Long mntId) {
		this.mntId = mntId;
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


	public Long getDutierId() {
		return this.dutierId;
	}
	public void setDutierId(Long dutierId) {
		this.dutierId = dutierId;
	}


	public String getDutierName() {
		return this.dutierName;
	}
	public void setDutierName(String dutierName) {
		this.dutierName = dutierName;
	}


	public String getDutierPhone() {
		return this.dutierPhone;
	}
	public void setDutierPhone(String dutierPhone) {
		this.dutierPhone = dutierPhone;
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


	public Long getUserId() {
		return this.userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Long getAppId() {
		return this.appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}


	public Long getAppImageId() {
		return this.appImageId;
	}
	public void setAppImageId(Long appImageId) {
		this.appImageId = appImageId;
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


	public Integer getDataStatus() {
		return this.dataStatus;
	}
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}


	public Long getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}


	public Long getModifyTime() {
		return this.modifyTime;
	}
	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}


}


