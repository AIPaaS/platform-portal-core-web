package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 应用管理员表[PC_APP_MGR]
 */
public class PcAppMgr implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 应用ID[APP_ID]
	 */
	private Long appId;


	/**
	 * mapping-field: 用户ID[USER_ID]
	 */
	private Long userId;


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


	public Long getAppId() {
		return this.appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}


	public Long getUserId() {
		return this.userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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


