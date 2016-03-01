package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 应用布署任务日志表[PC_APP_TASK_LOG]
 */
public class PcAppTaskLog implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 日志时间[LOG_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long logTime;


	/**
	 * mapping-field: 所属任务[TASK_ID]
	 */
	private Long taskId;


	/**
	 * mapping-field: 日志类型[LOG_TYPE]
	 * 0=CMD 1=INFO 2=WARN 3=ERROR
	 */
	private Integer logType;


	/**
	 * mapping-field: 日志描述[REMARK]
	 */
	private String remark;


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


	public Long getLogTime() {
		return this.logTime;
	}
	public void setLogTime(Long logTime) {
		this.logTime = logTime;
	}


	public Long getTaskId() {
		return this.taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}


	public Integer getLogType() {
		return this.logType;
	}
	public void setLogType(Integer logType) {
		this.logType = logType;
	}


	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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


