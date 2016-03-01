package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 应用布署实例表[PC_APP_DEP_INSTANCE]
 */
public class PcAppDepInstance implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 所属应用部署历史ID[APP_DEP_HISTORY_ID]
	 */
	private Long appDepHistoryId;


	/**
	 * mapping-field: 服务器IP[SERVER_IP]
	 */
	private String serverIp;


	/**
	 * mapping-field: 实例ID[INSTANCE_ID]
	 */
	private String instanceId;


	/**
	 * mapping-field: 实例名[INSTANCE_NAME]
	 */
	private String instanceName;


	/**
	 * mapping-field: 获取时间[TIME]
	 * 毫秒数
	 */
	private Long time;


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
	 * mapping-field: 状态[STATUS]
	 * 0=无效 1=有效
	 */
	private Integer status;


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


	public Long getAppDepHistoryId() {
		return this.appDepHistoryId;
	}
	public void setAppDepHistoryId(Long appDepHistoryId) {
		this.appDepHistoryId = appDepHistoryId;
	}


	public String getServerIp() {
		return this.serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}


	public String getInstanceId() {
		return this.instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}


	public String getInstanceName() {
		return this.instanceName;
	}
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}


	public Long getTime() {
		return this.time;
	}
	public void setTime(Long time) {
		this.time = time;
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


	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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


