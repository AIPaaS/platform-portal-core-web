package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 应用表[PC_APP]
 */
public class CPcApp implements Condition {
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
	 * condition-field: 最近版本ID[VERSION_ID] operate-Equal[=]
	 */
	private Long versionId;


	/**
	 * condition-field: 最近版本ID[VERSION_ID] operate-In[in]
	 */
	private Long[] versionIds;


	/**
	 * condition-field: 最近版本ID[VERSION_ID] operate-GTEqual[>=]
	 */
	private Long startVersionId;

	/**
	 * condition-field: 最近版本ID[VERSION_ID] operate-LTEqual[<=]
	 */
	private Long endVersionId;


	/**
	 * condition-field: 最近版本号[VERSION_NO] operate-Like[like]
	 */
	private String versionNo;


	/**
	 * condition-field: 最近版本号[VERSION_NO] operate-Equal[=]
	 */
	private String versionNoEqual;


	/**
	 * condition-field: 最近版本号[VERSION_NO] operate-In[in]
	 */
	private String[] versionNos;


	/**
	 * condition-field: 最近启动时间[LAST_START_TIME] operate-Equal[=]
	 */
	private Long lastStartTime;


	/**
	 * condition-field: 最近启动时间[LAST_START_TIME] operate-In[in]
	 */
	private Long[] lastStartTimes;


	/**
	 * condition-field: 最近启动时间[LAST_START_TIME] operate-GTEqual[>=]
	 */
	private Long startLastStartTime;

	/**
	 * condition-field: 最近启动时间[LAST_START_TIME] operate-LTEqual[<=]
	 */
	private Long endLastStartTime;


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
	 * condition-field: 修改人[MODIFIER] operate-Like[like]
	 */
	private String modifier;


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


	public Long getVersionId() {
		return this.versionId;
	}
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}


	public Long[] getVersionIds() {
		return this.versionIds;
	}
	public void setVersionIds(Long[] versionIds) {
		this.versionIds = versionIds;
	}


	public Long getStartVersionId() {
		return this.startVersionId;
	}
	public void setStartVersionId(Long startVersionId) {
		this.startVersionId = startVersionId;
	}


	public Long getEndVersionId() {
		return this.endVersionId;
	}
	public void setEndVersionId(Long endVersionId) {
		this.endVersionId = endVersionId;
	}


	public String getVersionNo() {
		return this.versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}


	public String getVersionNoEqual() {
		return this.versionNoEqual;
	}
	public void setVersionNoEqual(String versionNoEqual) {
		this.versionNoEqual = versionNoEqual;
	}


	public String[] getVersionNos() {
		return this.versionNos;
	}
	public void setVersionNos(String[] versionNos) {
		this.versionNos = versionNos;
	}


	public Long getLastStartTime() {
		return this.lastStartTime;
	}
	public void setLastStartTime(Long lastStartTime) {
		this.lastStartTime = lastStartTime;
	}


	public Long[] getLastStartTimes() {
		return this.lastStartTimes;
	}
	public void setLastStartTimes(Long[] lastStartTimes) {
		this.lastStartTimes = lastStartTimes;
	}


	public Long getStartLastStartTime() {
		return this.startLastStartTime;
	}
	public void setStartLastStartTime(Long startLastStartTime) {
		this.startLastStartTime = startLastStartTime;
	}


	public Long getEndLastStartTime() {
		return this.endLastStartTime;
	}
	public void setEndLastStartTime(Long endLastStartTime) {
		this.endLastStartTime = endLastStartTime;
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


}


