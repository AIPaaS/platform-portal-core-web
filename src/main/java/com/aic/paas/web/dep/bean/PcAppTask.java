package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 应用布署任务表[PC_APP_TASK]
 */
public class PcAppTask implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 应用ID[APP_ID]
	 */
	private Long appId;


	/**
	 * mapping-field: 应用版本ID[APP_VNO_ID]
	 */
	private Long appVnoId;


	/**
	 * mapping-field: 任务执行人ID[TASK_USER_ID]
	 */
	private Long taskUserId;


	/**
	 * mapping-field: 任务执行人姓名[TASK_USER_NAME]
	 */
	private String taskUserName;


	/**
	 * mapping-field: 任务启动时间[TASK_START_TIME]
	 */
	private Long taskStartTime;


	/**
	 * mapping-field: 实际运行时间[RUN_START_TIME]
	 */
	private Long runStartTime;


	/**
	 * mapping-field: 任务结束时间[TASK_END_TIME]
	 */
	private Long taskEndTime;


	/**
	 * mapping-field: 结束类型[FINISH_TYPE]
	 * 1=正常结束 2=人为中断
	 */
	private Integer finishType;


	/**
	 * mapping-field: 任务状态[STATUS]
	 * 1=就绪 2=运行中 3=成功结束 4=失败结束
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


	public Long getAppId() {
		return this.appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}


	public Long getAppVnoId() {
		return this.appVnoId;
	}
	public void setAppVnoId(Long appVnoId) {
		this.appVnoId = appVnoId;
	}


	public Long getTaskUserId() {
		return this.taskUserId;
	}
	public void setTaskUserId(Long taskUserId) {
		this.taskUserId = taskUserId;
	}


	public String getTaskUserName() {
		return this.taskUserName;
	}
	public void setTaskUserName(String taskUserName) {
		this.taskUserName = taskUserName;
	}


	public Long getTaskStartTime() {
		return this.taskStartTime;
	}
	public void setTaskStartTime(Long taskStartTime) {
		this.taskStartTime = taskStartTime;
	}


	public Long getRunStartTime() {
		return this.runStartTime;
	}
	public void setRunStartTime(Long runStartTime) {
		this.runStartTime = runStartTime;
	}


	public Long getTaskEndTime() {
		return this.taskEndTime;
	}
	public void setTaskEndTime(Long taskEndTime) {
		this.taskEndTime = taskEndTime;
	}


	public Integer getFinishType() {
		return this.finishType;
	}
	public void setFinishType(Integer finishType) {
		this.finishType = finishType;
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


