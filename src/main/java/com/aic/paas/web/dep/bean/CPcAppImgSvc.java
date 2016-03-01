package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 应用镜像调用服务表[PC_APP_IMG_SVC]
 */
public class CPcAppImgSvc implements Condition {
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
	 * condition-field: 应用镜像ID[APP_IMG_ID] operate-Equal[=]
	 */
	private Long appImgId;


	/**
	 * condition-field: 应用镜像ID[APP_IMG_ID] operate-In[in]
	 */
	private Long[] appImgIds;


	/**
	 * condition-field: 应用镜像ID[APP_IMG_ID] operate-GTEqual[>=]
	 */
	private Long startAppImgId;

	/**
	 * condition-field: 应用镜像ID[APP_IMG_ID] operate-LTEqual[<=]
	 */
	private Long endAppImgId;


	/**
	 * condition-field: 服务ID[SVC_ID] operate-Equal[=]
	 * 如果SVC_TYPE=4时则为依赖的应用内部镜像
	 */
	private Long svcId;


	/**
	 * condition-field: 服务ID[SVC_ID] operate-In[in]
	 * 如果SVC_TYPE=4时则为依赖的应用内部镜像
	 */
	private Long[] svcIds;


	/**
	 * condition-field: 服务ID[SVC_ID] operate-GTEqual[>=]
	 * 如果SVC_TYPE=4时则为依赖的应用内部镜像
	 */
	private Long startSvcId;

	/**
	 * condition-field: 服务ID[SVC_ID] operate-LTEqual[<=]
	 * 如果SVC_TYPE=4时则为依赖的应用内部镜像
	 */
	private Long endSvcId;


	/**
	 * condition-field: 服务类型[SVC_TYPE] operate-Equal[=]
	 * 1=平台服务 2=外部服务 3=镜像服务 4=非服务镜像
	 */
	private Integer svcType;


	/**
	 * condition-field: 服务类型[SVC_TYPE] operate-In[in]
	 * 1=平台服务 2=外部服务 3=镜像服务 4=非服务镜像
	 */
	private Integer[] svcTypes;


	/**
	 * condition-field: 服务类型[SVC_TYPE] operate-GTEqual[>=]
	 * 1=平台服务 2=外部服务 3=镜像服务 4=非服务镜像
	 */
	private Integer startSvcType;

	/**
	 * condition-field: 服务类型[SVC_TYPE] operate-LTEqual[<=]
	 * 1=平台服务 2=外部服务 3=镜像服务 4=非服务镜像
	 */
	private Integer endSvcType;


	/**
	 * condition-field: 调用类型[CALL_TYPE] operate-Equal[=]
	 * 1=调用 2=依赖
	 */
	private Integer callType;


	/**
	 * condition-field: 调用类型[CALL_TYPE] operate-In[in]
	 * 1=调用 2=依赖
	 */
	private Integer[] callTypes;


	/**
	 * condition-field: 调用类型[CALL_TYPE] operate-GTEqual[>=]
	 * 1=调用 2=依赖
	 */
	private Integer startCallType;

	/**
	 * condition-field: 调用类型[CALL_TYPE] operate-LTEqual[<=]
	 * 1=调用 2=依赖
	 */
	private Integer endCallType;


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


	public Long getAppImgId() {
		return this.appImgId;
	}
	public void setAppImgId(Long appImgId) {
		this.appImgId = appImgId;
	}


	public Long[] getAppImgIds() {
		return this.appImgIds;
	}
	public void setAppImgIds(Long[] appImgIds) {
		this.appImgIds = appImgIds;
	}


	public Long getStartAppImgId() {
		return this.startAppImgId;
	}
	public void setStartAppImgId(Long startAppImgId) {
		this.startAppImgId = startAppImgId;
	}


	public Long getEndAppImgId() {
		return this.endAppImgId;
	}
	public void setEndAppImgId(Long endAppImgId) {
		this.endAppImgId = endAppImgId;
	}


	public Long getSvcId() {
		return this.svcId;
	}
	public void setSvcId(Long svcId) {
		this.svcId = svcId;
	}


	public Long[] getSvcIds() {
		return this.svcIds;
	}
	public void setSvcIds(Long[] svcIds) {
		this.svcIds = svcIds;
	}


	public Long getStartSvcId() {
		return this.startSvcId;
	}
	public void setStartSvcId(Long startSvcId) {
		this.startSvcId = startSvcId;
	}


	public Long getEndSvcId() {
		return this.endSvcId;
	}
	public void setEndSvcId(Long endSvcId) {
		this.endSvcId = endSvcId;
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


	public Integer getCallType() {
		return this.callType;
	}
	public void setCallType(Integer callType) {
		this.callType = callType;
	}


	public Integer[] getCallTypes() {
		return this.callTypes;
	}
	public void setCallTypes(Integer[] callTypes) {
		this.callTypes = callTypes;
	}


	public Integer getStartCallType() {
		return this.startCallType;
	}
	public void setStartCallType(Integer startCallType) {
		this.startCallType = startCallType;
	}


	public Integer getEndCallType() {
		return this.endCallType;
	}
	public void setEndCallType(Integer endCallType) {
		this.endCallType = endCallType;
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


