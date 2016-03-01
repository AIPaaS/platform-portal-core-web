package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 应用版本表[PC_APP_VERSION]
 */
public class CPcAppVersion implements Condition {
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
	 * condition-field: 版本号[VERSION_NO] operate-Like[like]
	 */
	private String versionNo;


	/**
	 * condition-field: 版本号[VERSION_NO] operate-Equal[=]
	 */
	private String versionNoEqual;


	/**
	 * condition-field: 版本号[VERSION_NO] operate-In[in]
	 */
	private String[] versionNos;


	/**
	 * condition-field: 配置状态[SETUP_STATUS] operate-Equal[=]
	 * 1=已完成 0=未完成
	 */
	private Integer setupStatus;


	/**
	 * condition-field: 配置状态[SETUP_STATUS] operate-In[in]
	 * 1=已完成 0=未完成
	 */
	private Integer[] setupStatuss;


	/**
	 * condition-field: 配置状态[SETUP_STATUS] operate-GTEqual[>=]
	 * 1=已完成 0=未完成
	 */
	private Integer startSetupStatus;

	/**
	 * condition-field: 配置状态[SETUP_STATUS] operate-LTEqual[<=]
	 * 1=已完成 0=未完成
	 */
	private Integer endSetupStatus;


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


	public Integer getSetupStatus() {
		return this.setupStatus;
	}
	public void setSetupStatus(Integer setupStatus) {
		this.setupStatus = setupStatus;
	}


	public Integer[] getSetupStatuss() {
		return this.setupStatuss;
	}
	public void setSetupStatuss(Integer[] setupStatuss) {
		this.setupStatuss = setupStatuss;
	}


	public Integer getStartSetupStatus() {
		return this.startSetupStatus;
	}
	public void setStartSetupStatus(Integer startSetupStatus) {
		this.startSetupStatus = startSetupStatus;
	}


	public Integer getEndSetupStatus() {
		return this.endSetupStatus;
	}
	public void setEndSetupStatus(Integer endSetupStatus) {
		this.endSetupStatus = endSetupStatus;
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


