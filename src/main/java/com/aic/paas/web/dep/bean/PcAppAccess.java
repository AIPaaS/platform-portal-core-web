package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 应用访问表[PC_APP_ACCESS]
 */
public class PcAppAccess implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: APP_ID[APP_ID]
	 */
	private Long appId;


	/**
	 * mapping-field: 访问名称[ACCESS_CODE]
	 */
	private String accessCode;


	/**
	 * mapping-field: 所属应用镜像[APP_IMAGE_ID]
	 */
	private Long appImageId;


	/**
	 * mapping-field: 所属数据中心[DATA_CENTER_ID]
	 */
	private Long dataCenterId;


	/**
	 * mapping-field: 所属资源中心[RES_CENTER_ID]
	 */
	private Long resCenterId;


	/**
	 * mapping-field: 协议[PROTOCOL]
	 */
	private Integer protocol;


	/**
	 * mapping-field: 访问地址[ACCESS_URL]
	 */
	private String accessUrl;


	/**
	 * mapping-field: 所属租户[MNT_ID]
	 */
	private Long mntId;


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
	 */
	private Integer dataStatus;


	/**
	 * mapping-field: 创建人[CREATOR]
	 */
	private String creator;


	/**
	 * mapping-field: 创建时间[CREATE_TIME]
	 */
	private Long createTime;


	/**
	 * mapping-field: 修改人[MODIFIER]
	 */
	private String modifier;


	/**
	 * mapping-field: 修改时间[MODIFY_TIME]
	 */
	private Long modifyTime;


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


	public Integer getProtocol() {
		return this.protocol;
	}
	public void setProtocol(Integer protocol) {
		this.protocol = protocol;
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


}


