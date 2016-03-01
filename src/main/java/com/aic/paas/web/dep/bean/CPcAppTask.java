package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 应用布署任务表[PC_APP_TASK]
 */
public class CPcAppTask implements Condition {
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
	 * condition-field: 应用ID[APP_ID] operate-Equal[=]
	 */
	private Long appId;


	/**
	 * condition-field: 应用ID[APP_ID] operate-In[in]
	 */
	private Long[] appIds;


	/**
	 * condition-field: 应用ID[APP_ID] operate-GTEqual[>=]
	 */
	private Long startAppId;

	/**
	 * condition-field: 应用ID[APP_ID] operate-LTEqual[<=]
	 */
	private Long endAppId;


	/**
	 * condition-field: 应用版本ID[APP_VNO_ID] operate-Equal[=]
	 */
	private Long appVnoId;


	/**
	 * condition-field: 应用版本ID[APP_VNO_ID] operate-In[in]
	 */
	private Long[] appVnoIds;


	/**
	 * condition-field: 应用版本ID[APP_VNO_ID] operate-GTEqual[>=]
	 */
	private Long startAppVnoId;

	/**
	 * condition-field: 应用版本ID[APP_VNO_ID] operate-LTEqual[<=]
	 */
	private Long endAppVnoId;


	/**
	 * condition-field: 任务执行人ID[TASK_USER_ID] operate-Equal[=]
	 */
	private Long taskUserId;


	/**
	 * condition-field: 任务执行人ID[TASK_USER_ID] operate-In[in]
	 */
	private Long[] taskUserIds;


	/**
	 * condition-field: 任务执行人ID[TASK_USER_ID] operate-GTEqual[>=]
	 */
	private Long startTaskUserId;

	/**
	 * condition-field: 任务执行人ID[TASK_USER_ID] operate-LTEqual[<=]
	 */
	private Long endTaskUserId;


	/**
	 * condition-field: 任务执行人姓名[TASK_USER_NAME] operate-Like[like]
	 */
	private String taskUserName;


	/**
	 * condition-field: 任务执行人姓名[TASK_USER_NAME] operate-Equal[=]
	 */
	private String taskUserNameEqual;


	/**
	 * condition-field: 任务执行人姓名[TASK_USER_NAME] operate-In[in]
	 */
	private String[] taskUserNames;


	/**
	 * condition-field: 任务启动时间[TASK_START_TIME] operate-Equal[=]
	 */
	private Long taskStartTime;


	/**
	 * condition-field: 任务启动时间[TASK_START_TIME] operate-In[in]
	 */
	private Long[] taskStartTimes;


	/**
	 * condition-field: 任务启动时间[TASK_START_TIME] operate-GTEqual[>=]
	 */
	private Long startTaskStartTime;

	/**
	 * condition-field: 任务启动时间[TASK_START_TIME] operate-LTEqual[<=]
	 */
	private Long endTaskStartTime;


	/**
	 * condition-field: 实际运行时间[RUN_START_TIME] operate-Equal[=]
	 */
	private Long runStartTime;


	/**
	 * condition-field: 实际运行时间[RUN_START_TIME] operate-In[in]
	 */
	private Long[] runStartTimes;


	/**
	 * condition-field: 实际运行时间[RUN_START_TIME] operate-GTEqual[>=]
	 */
	private Long startRunStartTime;

	/**
	 * condition-field: 实际运行时间[RUN_START_TIME] operate-LTEqual[<=]
	 */
	private Long endRunStartTime;


	/**
	 * condition-field: 任务结束时间[TASK_END_TIME] operate-Equal[=]
	 */
	private Long taskEndTime;


	/**
	 * condition-field: 任务结束时间[TASK_END_TIME] operate-In[in]
	 */
	private Long[] taskEndTimes;


	/**
	 * condition-field: 任务结束时间[TASK_END_TIME] operate-GTEqual[>=]
	 */
	private Long startTaskEndTime;

	/**
	 * condition-field: 任务结束时间[TASK_END_TIME] operate-LTEqual[<=]
	 */
	private Long endTaskEndTime;


	/**
	 * condition-field: 结束类型[FINISH_TYPE] operate-Equal[=]
	 * 1=正常结束 2=人为中断
	 */
	private Integer finishType;


	/**
	 * condition-field: 结束类型[FINISH_TYPE] operate-In[in]
	 * 1=正常结束 2=人为中断
	 */
	private Integer[] finishTypes;


	/**
	 * condition-field: 结束类型[FINISH_TYPE] operate-GTEqual[>=]
	 * 1=正常结束 2=人为中断
	 */
	private Integer startFinishType;

	/**
	 * condition-field: 结束类型[FINISH_TYPE] operate-LTEqual[<=]
	 * 1=正常结束 2=人为中断
	 */
	private Integer endFinishType;


	/**
	 * condition-field: 任务状态[STATUS] operate-Equal[=]
	 * 1=就绪 2=运行中 3=成功结束 4=失败结束
	 */
	private Integer status;


	/**
	 * condition-field: 任务状态[STATUS] operate-In[in]
	 * 1=就绪 2=运行中 3=成功结束 4=失败结束
	 */
	private Integer[] statuss;


	/**
	 * condition-field: 任务状态[STATUS] operate-GTEqual[>=]
	 * 1=就绪 2=运行中 3=成功结束 4=失败结束
	 */
	private Integer startStatus;

	/**
	 * condition-field: 任务状态[STATUS] operate-LTEqual[<=]
	 * 1=就绪 2=运行中 3=成功结束 4=失败结束
	 */
	private Integer endStatus;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-Equal[=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer dataStatus;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-In[in]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer[] dataStatuss;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-GTEqual[>=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer startDataStatus;

	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-LTEqual[<=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer endDataStatus;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long createTime;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] createTimes;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startCreateTime;

	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endCreateTime;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long modifyTime;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] modifyTimes;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startModifyTime;

	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
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


	public Long getAppId() {
		return this.appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}


	public Long[] getAppIds() {
		return this.appIds;
	}
	public void setAppIds(Long[] appIds) {
		this.appIds = appIds;
	}


	public Long getStartAppId() {
		return this.startAppId;
	}
	public void setStartAppId(Long startAppId) {
		this.startAppId = startAppId;
	}


	public Long getEndAppId() {
		return this.endAppId;
	}
	public void setEndAppId(Long endAppId) {
		this.endAppId = endAppId;
	}


	public Long getAppVnoId() {
		return this.appVnoId;
	}
	public void setAppVnoId(Long appVnoId) {
		this.appVnoId = appVnoId;
	}


	public Long[] getAppVnoIds() {
		return this.appVnoIds;
	}
	public void setAppVnoIds(Long[] appVnoIds) {
		this.appVnoIds = appVnoIds;
	}


	public Long getStartAppVnoId() {
		return this.startAppVnoId;
	}
	public void setStartAppVnoId(Long startAppVnoId) {
		this.startAppVnoId = startAppVnoId;
	}


	public Long getEndAppVnoId() {
		return this.endAppVnoId;
	}
	public void setEndAppVnoId(Long endAppVnoId) {
		this.endAppVnoId = endAppVnoId;
	}


	public Long getTaskUserId() {
		return this.taskUserId;
	}
	public void setTaskUserId(Long taskUserId) {
		this.taskUserId = taskUserId;
	}


	public Long[] getTaskUserIds() {
		return this.taskUserIds;
	}
	public void setTaskUserIds(Long[] taskUserIds) {
		this.taskUserIds = taskUserIds;
	}


	public Long getStartTaskUserId() {
		return this.startTaskUserId;
	}
	public void setStartTaskUserId(Long startTaskUserId) {
		this.startTaskUserId = startTaskUserId;
	}


	public Long getEndTaskUserId() {
		return this.endTaskUserId;
	}
	public void setEndTaskUserId(Long endTaskUserId) {
		this.endTaskUserId = endTaskUserId;
	}


	public String getTaskUserName() {
		return this.taskUserName;
	}
	public void setTaskUserName(String taskUserName) {
		this.taskUserName = taskUserName;
	}


	public String getTaskUserNameEqual() {
		return this.taskUserNameEqual;
	}
	public void setTaskUserNameEqual(String taskUserNameEqual) {
		this.taskUserNameEqual = taskUserNameEqual;
	}


	public String[] getTaskUserNames() {
		return this.taskUserNames;
	}
	public void setTaskUserNames(String[] taskUserNames) {
		this.taskUserNames = taskUserNames;
	}


	public Long getTaskStartTime() {
		return this.taskStartTime;
	}
	public void setTaskStartTime(Long taskStartTime) {
		this.taskStartTime = taskStartTime;
	}


	public Long[] getTaskStartTimes() {
		return this.taskStartTimes;
	}
	public void setTaskStartTimes(Long[] taskStartTimes) {
		this.taskStartTimes = taskStartTimes;
	}


	public Long getStartTaskStartTime() {
		return this.startTaskStartTime;
	}
	public void setStartTaskStartTime(Long startTaskStartTime) {
		this.startTaskStartTime = startTaskStartTime;
	}


	public Long getEndTaskStartTime() {
		return this.endTaskStartTime;
	}
	public void setEndTaskStartTime(Long endTaskStartTime) {
		this.endTaskStartTime = endTaskStartTime;
	}


	public Long getRunStartTime() {
		return this.runStartTime;
	}
	public void setRunStartTime(Long runStartTime) {
		this.runStartTime = runStartTime;
	}


	public Long[] getRunStartTimes() {
		return this.runStartTimes;
	}
	public void setRunStartTimes(Long[] runStartTimes) {
		this.runStartTimes = runStartTimes;
	}


	public Long getStartRunStartTime() {
		return this.startRunStartTime;
	}
	public void setStartRunStartTime(Long startRunStartTime) {
		this.startRunStartTime = startRunStartTime;
	}


	public Long getEndRunStartTime() {
		return this.endRunStartTime;
	}
	public void setEndRunStartTime(Long endRunStartTime) {
		this.endRunStartTime = endRunStartTime;
	}


	public Long getTaskEndTime() {
		return this.taskEndTime;
	}
	public void setTaskEndTime(Long taskEndTime) {
		this.taskEndTime = taskEndTime;
	}


	public Long[] getTaskEndTimes() {
		return this.taskEndTimes;
	}
	public void setTaskEndTimes(Long[] taskEndTimes) {
		this.taskEndTimes = taskEndTimes;
	}


	public Long getStartTaskEndTime() {
		return this.startTaskEndTime;
	}
	public void setStartTaskEndTime(Long startTaskEndTime) {
		this.startTaskEndTime = startTaskEndTime;
	}


	public Long getEndTaskEndTime() {
		return this.endTaskEndTime;
	}
	public void setEndTaskEndTime(Long endTaskEndTime) {
		this.endTaskEndTime = endTaskEndTime;
	}


	public Integer getFinishType() {
		return this.finishType;
	}
	public void setFinishType(Integer finishType) {
		this.finishType = finishType;
	}


	public Integer[] getFinishTypes() {
		return this.finishTypes;
	}
	public void setFinishTypes(Integer[] finishTypes) {
		this.finishTypes = finishTypes;
	}


	public Integer getStartFinishType() {
		return this.startFinishType;
	}
	public void setStartFinishType(Integer startFinishType) {
		this.startFinishType = startFinishType;
	}


	public Integer getEndFinishType() {
		return this.endFinishType;
	}
	public void setEndFinishType(Integer endFinishType) {
		this.endFinishType = endFinishType;
	}


	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer[] getStatuss() {
		return this.statuss;
	}
	public void setStatuss(Integer[] statuss) {
		this.statuss = statuss;
	}


	public Integer getStartStatus() {
		return this.startStatus;
	}
	public void setStartStatus(Integer startStatus) {
		this.startStatus = startStatus;
	}


	public Integer getEndStatus() {
		return this.endStatus;
	}
	public void setEndStatus(Integer endStatus) {
		this.endStatus = endStatus;
	}


	public Integer getDataStatus() {
		return this.dataStatus;
	}
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}


	public Integer[] getDataStatuss() {
		return this.dataStatuss;
	}
	public void setDataStatuss(Integer[] dataStatuss) {
		this.dataStatuss = dataStatuss;
	}


	public Integer getStartDataStatus() {
		return this.startDataStatus;
	}
	public void setStartDataStatus(Integer startDataStatus) {
		this.startDataStatus = startDataStatus;
	}


	public Integer getEndDataStatus() {
		return this.endDataStatus;
	}
	public void setEndDataStatus(Integer endDataStatus) {
		this.endDataStatus = endDataStatus;
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


