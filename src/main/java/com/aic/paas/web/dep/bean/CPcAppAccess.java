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
	 * condition-field: 备用字段1[BAK_1] operate-Equal[=]
	 */
	private Long bak1;


	/**
	 * condition-field: 备用字段1[BAK_1] operate-In[in]
	 */
	private Long[] bak1s;


	/**
	 * condition-field: 备用字段1[BAK_1] operate-GTEqual[>=]
	 */
	private Long startBak1;

	/**
	 * condition-field: 备用字段1[BAK_1] operate-LTEqual[<=]
	 */
	private Long endBak1;


	/**
	 * condition-field: 备用字段2[BAK_2] operate-Equal[=]
	 */
	private Long bak2;


	/**
	 * condition-field: 备用字段2[BAK_2] operate-In[in]
	 */
	private Long[] bak2s;


	/**
	 * condition-field: 备用字段2[BAK_2] operate-GTEqual[>=]
	 */
	private Long startBak2;

	/**
	 * condition-field: 备用字段2[BAK_2] operate-LTEqual[<=]
	 */
	private Long endBak2;


	/**
	 * condition-field: 备用字段3[BAK_3] operate-Like[like]
	 */
	private String bak3;


	/**
	 * condition-field: 备用字段4[BAK_4] operate-Like[like]
	 */
	private String bak4;




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


	public Long getBak1() {
		return this.bak1;
	}
	public void setBak1(Long bak1) {
		this.bak1 = bak1;
	}


	public Long[] getBak1s() {
		return this.bak1s;
	}
	public void setBak1s(Long[] bak1s) {
		this.bak1s = bak1s;
	}


	public Long getStartBak1() {
		return this.startBak1;
	}
	public void setStartBak1(Long startBak1) {
		this.startBak1 = startBak1;
	}


	public Long getEndBak1() {
		return this.endBak1;
	}
	public void setEndBak1(Long endBak1) {
		this.endBak1 = endBak1;
	}


	public Long getBak2() {
		return this.bak2;
	}
	public void setBak2(Long bak2) {
		this.bak2 = bak2;
	}


	public Long[] getBak2s() {
		return this.bak2s;
	}
	public void setBak2s(Long[] bak2s) {
		this.bak2s = bak2s;
	}


	public Long getStartBak2() {
		return this.startBak2;
	}
	public void setStartBak2(Long startBak2) {
		this.startBak2 = startBak2;
	}


	public Long getEndBak2() {
		return this.endBak2;
	}
	public void setEndBak2(Long endBak2) {
		this.endBak2 = endBak2;
	}


	public String getBak3() {
		return this.bak3;
	}
	public void setBak3(String bak3) {
		this.bak3 = bak3;
	}


	public String getBak4() {
		return this.bak4;
	}
	public void setBak4(String bak4) {
		this.bak4 = bak4;
	}


}


