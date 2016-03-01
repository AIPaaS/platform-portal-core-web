package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 应用版本表[PC_APP_VERSION]
 */
public class PcAppVersion implements EntityBean {
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
	 * mapping-field: 应用ID[APP_ID]
	 */
	private Long appId;


	/**
	 * mapping-field: 版本号[VERSION_NO]
	 */
	private String versionNo;


	/**
	 * mapping-field: 配置状态[SETUP_STATUS]
	 * 1=已完成 0=未完成
	 */
	private Integer setupStatus;


	/**
	 * mapping-field: 状态[STATUS]
	 * 1=未部署 2=运行中 3=停止
	 */
	private Integer status;


	/**
	 * mapping-field: 创建时间[CREATE_TIME]
	 */
	private Long createTime;


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


	public String getVersionNo() {
		return this.versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}


	public Integer getSetupStatus() {
		return this.setupStatus;
	}
	public void setSetupStatus(Integer setupStatus) {
		this.setupStatus = setupStatus;
	}


	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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


