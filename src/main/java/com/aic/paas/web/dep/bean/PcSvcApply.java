package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 平台服务申请表[PC_SVC_APPLY]
 */
public class PcSvcApply implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 申请单号[CODE]
	 */
	private Long code;


	/**
	 * mapping-field: 所属数据中心[DATA_CENTER_ID]
	 */
	private Long dataCenterId;


	/**
	 * mapping-field: 所属资源中心[RES_CENTER_ID]
	 */
	private Long resCenterId;


	/**
	 * mapping-field: 所属应用[APP_ID]
	 */
	private Integer appId;


	/**
	 * mapping-field: 申请服务[SVC_ID]
	 */
	private Long svcId;


	/**
	 * mapping-field: 申请人ID[APPLIER_ID]
	 */
	private Long applierId;


	/**
	 * mapping-field: 申请人姓名[APPLIER_NAME]
	 */
	private String applierName;


	/**
	 * mapping-field: 申请人邮箱[APPLIER_EMAIL]
	 */
	private String applierEmail;


	/**
	 * mapping-field: 申请时间[APPLY_TIME]
	 */
	private Long applyTime;


	/**
	 * mapping-field: 备注[REMARK]
	 */
	private String remark;


	/**
	 * mapping-field: 状态[STATUS]
	 * 0=待审批 1=审批通过 2=审批退回
	 */
	private Integer status;


	/**
	 * mapping-field: 审批时间[CHECK_TIME]
	 */
	private Long checkTime;


	/**
	 * mapping-field: 审批意见[CHECK_DESC]
	 */
	private String checkDesc;


	/**
	 * mapping-field: 审批人姓名[CHECKER_NAME]
	 */
	private String checkerName;


	/**
	 * mapping-field: 审批人ID[CHECKER_ID]
	 */
	private Long checkerId;


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


	public Long getCode() {
		return this.code;
	}
	public void setCode(Long code) {
		this.code = code;
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


	public Integer getAppId() {
		return this.appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}


	public Long getSvcId() {
		return this.svcId;
	}
	public void setSvcId(Long svcId) {
		this.svcId = svcId;
	}


	public Long getApplierId() {
		return this.applierId;
	}
	public void setApplierId(Long applierId) {
		this.applierId = applierId;
	}


	public String getApplierName() {
		return this.applierName;
	}
	public void setApplierName(String applierName) {
		this.applierName = applierName;
	}


	public String getApplierEmail() {
		return this.applierEmail;
	}
	public void setApplierEmail(String applierEmail) {
		this.applierEmail = applierEmail;
	}


	public Long getApplyTime() {
		return this.applyTime;
	}
	public void setApplyTime(Long applyTime) {
		this.applyTime = applyTime;
	}


	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}


	public Long getCheckTime() {
		return this.checkTime;
	}
	public void setCheckTime(Long checkTime) {
		this.checkTime = checkTime;
	}


	public String getCheckDesc() {
		return this.checkDesc;
	}
	public void setCheckDesc(String checkDesc) {
		this.checkDesc = checkDesc;
	}


	public String getCheckerName() {
		return this.checkerName;
	}
	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
	}


	public Long getCheckerId() {
		return this.checkerId;
	}
	public void setCheckerId(Long checkerId) {
		this.checkerId = checkerId;
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


