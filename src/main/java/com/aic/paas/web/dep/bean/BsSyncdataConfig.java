package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 数据同步定义表[BS_SYNCDATA_CONFIG]
 */
public class BsSyncdataConfig implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 消息代码[MSG_CODE]
	 */
	private String msgCode;


	/**
	 * mapping-field: 消息名称[MSG_NAME]
	 */
	private String msgName;


	/**
	 * mapping-field: 消息对象[MSG_CLASS]
	 * 1=上行 2=下行
	 */
	private String msgClass;


	/**
	 * mapping-field: 实体类[ENTITY_CLASS]
	 */
	private String entityClass;


	/**
	 * mapping-field: 条件类[CDT_CLASS]
	 */
	private String cdtClass;


	/**
	 * mapping-field: 最近同步时间[SYNC_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long syncTime;


	/**
	 * mapping-field: 排序顺序[ORDER_NO]
	 */
	private Integer orderNo;


	/**
	 * mapping-field: 备注[REMARK]
	 */
	private String remark;


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


	public String getMsgCode() {
		return this.msgCode;
	}
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}


	public String getMsgName() {
		return this.msgName;
	}
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}


	public String getMsgClass() {
		return this.msgClass;
	}
	public void setMsgClass(String msgClass) {
		this.msgClass = msgClass;
	}


	public String getEntityClass() {
		return this.entityClass;
	}
	public void setEntityClass(String entityClass) {
		this.entityClass = entityClass;
	}


	public String getCdtClass() {
		return this.cdtClass;
	}
	public void setCdtClass(String cdtClass) {
		this.cdtClass = cdtClass;
	}


	public Long getSyncTime() {
		return this.syncTime;
	}
	public void setSyncTime(Long syncTime) {
		this.syncTime = syncTime;
	}


	public Integer getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}


	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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


