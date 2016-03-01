package com.aic.paas.web.res.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 租户信息表[WS_MERCHENT]
 */
public class WsMerchent implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 * 对应组织ID
	 */
	private Long id;


	/**
	 * mapping-field: 租户代码[MNT_CODE]
	 */
	private String mntCode;


	/**
	 * mapping-field: 租户名称[MNT_NAME]
	 */
	private String mntName;


	/**
	 * mapping-field: 登录密码[MNT_PWD]
	 */
	private String mntPwd;


	/**
	 * mapping-field: 成本中心编码[CC_CODE]
	 */
	private String ccCode;


	/**
	 * mapping-field: 联系人姓名[CONTACT_NAME]
	 */
	private String contactName;


	/**
	 * mapping-field: 联系人电话[CONTACT_PHONE]
	 */
	private String contactPhone;


	/**
	 * mapping-field: 联系人电话2[CONTACT_PHONE2]
	 */
	private String contactPhone2;


	/**
	 * mapping-field: 联系人邮箱[CONTACT_EMAIL]
	 */
	private String contactEmail;


	/**
	 * mapping-field: 租户状态[STATUS]
	 * 0=新建 1=审核通过 2=审核退回
	 */
	private Integer status;


	/**
	 * mapping-field: 审核人ID[CHECKER_ID]
	 */
	private Long checkerId;


	/**
	 * mapping-field: 审核人姓名[CHECKER_NAME]
	 */
	private String checkerName;


	/**
	 * mapping-field: 审核时间[CHECK_TIME]
	 */
	private Long checkTime;


	/**
	 * mapping-field: 审核意见[CHECK_DESC]
	 */
	private String checkDesc;


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


	public String getMntCode() {
		return this.mntCode;
	}
	public void setMntCode(String mntCode) {
		this.mntCode = mntCode;
	}


	public String getMntName() {
		return this.mntName;
	}
	public void setMntName(String mntName) {
		this.mntName = mntName;
	}


	public String getMntPwd() {
		return this.mntPwd;
	}
	public void setMntPwd(String mntPwd) {
		this.mntPwd = mntPwd;
	}


	public String getCcCode() {
		return this.ccCode;
	}
	public void setCcCode(String ccCode) {
		this.ccCode = ccCode;
	}


	public String getContactName() {
		return this.contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public String getContactPhone() {
		return this.contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}


	public String getContactPhone2() {
		return this.contactPhone2;
	}
	public void setContactPhone2(String contactPhone2) {
		this.contactPhone2 = contactPhone2;
	}


	public String getContactEmail() {
		return this.contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}


	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}


	public Long getCheckerId() {
		return this.checkerId;
	}
	public void setCheckerId(Long checkerId) {
		this.checkerId = checkerId;
	}


	public String getCheckerName() {
		return this.checkerName;
	}
	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
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


