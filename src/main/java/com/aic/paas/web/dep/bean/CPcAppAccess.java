package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 应用访问表[PC_APP_ACCESS]
 */
public class CPcAppAccess implements Condition {
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
	 * condition-field: APP_ID[APP_ID] operate-Equal[=]
	 */
	private Long appId;


	/**
	 * condition-field: APP_ID[APP_ID] operate-In[in]
	 */
	private Long[] appIds;


	/**
	 * condition-field: APP_ID[APP_ID] operate-GTEqual[>=]
	 */
	private Long startAppId;

	/**
	 * condition-field: APP_ID[APP_ID] operate-LTEqual[<=]
	 */
	private Long endAppId;


	/**
	 * condition-field: 访问名称[ACCESS_CODE] operate-Like[like]
	 */
	private String accessCode;


	/**
	 * condition-field: 所属应用镜像[APP_IMAGE_ID] operate-Equal[=]
	 */
	private Long appImageId;


	/**
	 * condition-field: 所属应用镜像[APP_IMAGE_ID] operate-In[in]
	 */
	private Long[] appImageIds;


	/**
	 * condition-field: 所属应用镜像[APP_IMAGE_ID] operate-GTEqual[>=]
	 */
	private Long startAppImageId;

	/**
	 * condition-field: 所属应用镜像[APP_IMAGE_ID] operate-LTEqual[<=]
	 */
	private Long endAppImageId;


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
	 * condition-field: 协议[PROTOCOL] operate-Equal[=]
	 */
	private Integer protocol;


	/**
	 * condition-field: 协议[PROTOCOL] operate-In[in]
	 */
	private Integer[] protocols;


	/**
	 * condition-field: 协议[PROTOCOL] operate-GTEqual[>=]
	 */
	private Integer startProtocol;

	/**
	 * condition-field: 协议[PROTOCOL] operate-LTEqual[<=]
	 */
	private Integer endProtocol;


	/**
	 * condition-field: 访问地址[ACCESS_URL] operate-Like[like]
	 */
	private String accessUrl;


	/**
	 * condition-field: 所属租户[MNT_ID] operate-Equal[=]
	 */
	private Long mntId;


	/**
	 * condition-field: 所属租户[MNT_ID] operate-In[in]
	 */
	private Long[] mntIds;


	/**
	 * condition-field: 所属租户[MNT_ID] operate-GTEqual[>=]
	 */
	private Long startMntId;

	/**
	 * condition-field: 所属租户[MNT_ID] operate-LTEqual[<=]
	 */
	private Long endMntId;


	/**
	 * condition-field: 状态[STATUS] operate-Equal[=]
	 * 1=未部署 2=运行中 3=停止
	 */
	private Integer status;


	/**
	 * condition-field: 状态[STATUS] operate-In[in]
	 * 1=未部署 2=运行中 3=停止
	 */
	private Integer[] statuss;


	/**
	 * condition-field: 状态[STATUS] operate-GTEqual[>=]
	 * 1=未部署 2=运行中 3=停止
	 */
	private Integer startStatus;

	/**
	 * condition-field: 状态[STATUS] operate-LTEqual[<=]
	 * 1=未部署 2=运行中 3=停止
	 */
	private Integer endStatus;


	/**
	 * condition-field: 描述[REMARK] operate-Like[like]
	 */
	private String remark;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-Equal[=]
	 */
	private Integer dataStatus;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-In[in]
	 */
	private Integer[] dataStatuss;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-GTEqual[>=]
	 */
	private Integer startDataStatus;

	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-LTEqual[<=]
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


	public String getAccessCode() {
		return this.accessCode;
	}
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
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


	public String getAccessUrl() {
		return this.accessUrl;
	}
	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
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


	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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


}


