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
	 * mapping-field: 备用字段1[BAK_1]
	 */
	private Long bak1;


	/**
	 * mapping-field: 备用字段2[BAK_2]
	 */
	private Long bak2;


	/**
	 * mapping-field: 备用字段3[BAK_3]
	 */
	private String bak3;


	/**
	 * mapping-field: 备用字段4[BAK_4]
	 */
	private String bak4;




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


	public Long getBak1() {
		return this.bak1;
	}
	public void setBak1(Long bak1) {
		this.bak1 = bak1;
	}


	public Long getBak2() {
		return this.bak2;
	}
	public void setBak2(Long bak2) {
		this.bak2 = bak2;
	}


	public String getBak3() {
		return this.bak3;
	}
	public void setBak3(String bak3) {
		this.bak3 = bak3;
	}


	public String getBak4() {
		return this.bak4;
	}
	public void setBak4(String bak4) {
		this.bak4 = bak4;
	}


}


