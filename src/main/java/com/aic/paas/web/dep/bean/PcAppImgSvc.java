package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 应用镜像调用服务表[PC_APP_IMG_SVC]
 */
public class PcAppImgSvc implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 应用镜像ID[APP_IMG_ID]
	 */
	private Long appImgId;


	/**
	 * mapping-field: 服务ID[SVC_ID]
	 * 如果SVC_TYPE=4时则为依赖的应用内部镜像
	 */
	private Long svcId;


	/**
	 * mapping-field: 服务类型[SVC_TYPE]
	 * 1=平台服务 2=外部服务 3=镜像服务 4=非服务镜像
	 */
	private Integer svcType;


	/**
	 * mapping-field: 调用类型[CALL_TYPE]
	 * 1=调用 2=依赖
	 */
	private Integer callType;


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


	public Long getAppImgId() {
		return this.appImgId;
	}
	public void setAppImgId(Long appImgId) {
		this.appImgId = appImgId;
	}


	public Long getSvcId() {
		return this.svcId;
	}
	public void setSvcId(Long svcId) {
		this.svcId = svcId;
	}


	public Integer getSvcType() {
		return this.svcType;
	}
	public void setSvcType(Integer svcType) {
		this.svcType = svcType;
	}


	public Integer getCallType() {
		return this.callType;
	}
	public void setCallType(Integer callType) {
		this.callType = callType;
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


