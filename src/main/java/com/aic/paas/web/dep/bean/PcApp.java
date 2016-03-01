package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 应用表[PC_APP]
 */
public class PcApp implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 所属租户[MNT_ID]
	 */
	private Long mntId;


	/**
	 * mapping-field: 应用代码[APP_CODE]
	 */
	private String appCode;


	/**
	 * mapping-field: 应用名称[APP_NAME]
	 */
	private String appName;


	/**
	 * mapping-field: 所属数据中心[DATA_CENTER_ID]
	 */
	private Long dataCenterId;


	/**
	 * mapping-field: 所属资源中心[RES_CENTER_ID]
	 */
	private Long resCenterId;


	/**
	 * mapping-field: 最近版本ID[VERSION_ID]
	 */
	private Long versionId;


	/**
	 * mapping-field: 最近版本号[VERSION_NO]
	 */
	private String versionNo;


	/**
	 * mapping-field: 最近启动时间[LAST_START_TIME]
	 */
	private Long lastStartTime;


	/**
	 * mapping-field: 状态[STATUS]
	 * 1=未部署 2=运行中 3=停止
	 */
	private Integer status;


	/**
	 * mapping-field: 描述[REMARK]
	 */
	private String remark;


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
	 * yyyyMMddHHmmss
	 */
	private Long createTime;


	/**
	 * mapping-field: 修改人[MODIFIER]
	 */
	private String modifier;


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


	public Long getMntId() {
		return this.mntId;
	}
	public void setMntId(Long mntId) {
		this.mntId = mntId;
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


	public Long getVersionId() {
		return this.versionId;
	}
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}


	public String getVersionNo() {
		return this.versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}


	public Long getLastStartTime() {
		return this.lastStartTime;
	}
	public void setLastStartTime(Long lastStartTime) {
		this.lastStartTime = lastStartTime;
	}


	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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


