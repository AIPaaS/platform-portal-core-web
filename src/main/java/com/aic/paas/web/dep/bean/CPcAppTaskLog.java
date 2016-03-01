package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 应用布署任务日志表[PC_APP_TASK_LOG]
 */
public class CPcAppTaskLog implements Condition {
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
	 * condition-field: 日志时间[LOG_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long logTime;


	/**
	 * condition-field: 日志时间[LOG_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] logTimes;


	/**
	 * condition-field: 日志时间[LOG_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startLogTime;

	/**
	 * condition-field: 日志时间[LOG_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endLogTime;


	/**
	 * condition-field: 所属任务[TASK_ID] operate-Equal[=]
	 */
	private Long taskId;


	/**
	 * condition-field: 所属任务[TASK_ID] operate-In[in]
	 */
	private Long[] taskIds;


	/**
	 * condition-field: 所属任务[TASK_ID] operate-GTEqual[>=]
	 */
	private Long startTaskId;

	/**
	 * condition-field: 所属任务[TASK_ID] operate-LTEqual[<=]
	 */
	private Long endTaskId;


	/**
	 * condition-field: 日志类型[LOG_TYPE] operate-Equal[=]
	 * 0=CMD 1=INFO 2=WARN 3=ERROR
	 */
	private Integer logType;


	/**
	 * condition-field: 日志类型[LOG_TYPE] operate-In[in]
	 * 0=CMD 1=INFO 2=WARN 3=ERROR
	 */
	private Integer[] logTypes;


	/**
	 * condition-field: 日志类型[LOG_TYPE] operate-GTEqual[>=]
	 * 0=CMD 1=INFO 2=WARN 3=ERROR
	 */
	private Integer startLogType;

	/**
	 * condition-field: 日志类型[LOG_TYPE] operate-LTEqual[<=]
	 * 0=CMD 1=INFO 2=WARN 3=ERROR
	 */
	private Integer endLogType;


	/**
	 * condition-field: 日志描述[REMARK] operate-Like[like]
	 */
	private String remark;


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


	public Long getLogTime() {
		return this.logTime;
	}
	public void setLogTime(Long logTime) {
		this.logTime = logTime;
	}


	public Long[] getLogTimes() {
		return this.logTimes;
	}
	public void setLogTimes(Long[] logTimes) {
		this.logTimes = logTimes;
	}


	public Long getStartLogTime() {
		return this.startLogTime;
	}
	public void setStartLogTime(Long startLogTime) {
		this.startLogTime = startLogTime;
	}


	public Long getEndLogTime() {
		return this.endLogTime;
	}
	public void setEndLogTime(Long endLogTime) {
		this.endLogTime = endLogTime;
	}


	public Long getTaskId() {
		return this.taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}


	public Long[] getTaskIds() {
		return this.taskIds;
	}
	public void setTaskIds(Long[] taskIds) {
		this.taskIds = taskIds;
	}


	public Long getStartTaskId() {
		return this.startTaskId;
	}
	public void setStartTaskId(Long startTaskId) {
		this.startTaskId = startTaskId;
	}


	public Long getEndTaskId() {
		return this.endTaskId;
	}
	public void setEndTaskId(Long endTaskId) {
		this.endTaskId = endTaskId;
	}


	public Integer getLogType() {
		return this.logType;
	}
	public void setLogType(Integer logType) {
		this.logType = logType;
	}


	public Integer[] getLogTypes() {
		return this.logTypes;
	}
	public void setLogTypes(Integer[] logTypes) {
		this.logTypes = logTypes;
	}


	public Integer getStartLogType() {
		return this.startLogType;
	}
	public void setStartLogType(Integer startLogType) {
		this.startLogType = startLogType;
	}


	public Integer getEndLogType() {
		return this.endLogType;
	}
	public void setEndLogType(Integer endLogType) {
		this.endLogType = endLogType;
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


