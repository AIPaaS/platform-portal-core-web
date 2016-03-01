package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 镜像表[PC_IMAGE]
 */
public class CPcImage implements Condition {
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
	 * condition-field: 所属定义[DEF_ID] operate-Equal[=]
	 */
	private Long defId;


	/**
	 * condition-field: 所属定义[DEF_ID] operate-In[in]
	 */
	private Long[] defIds;


	/**
	 * condition-field: 所属定义[DEF_ID] operate-GTEqual[>=]
	 */
	private Long startDefId;

	/**
	 * condition-field: 所属定义[DEF_ID] operate-LTEqual[<=]
	 */
	private Long endDefId;


	/**
	 * condition-field: 所属租户[MNT_ID] operate-Equal[=]
	 */
	private Long mntId;


	/**
	 * condition-field: 所属租户[MNT_ID] operate-In[in]
	 */
	private Long[] mntIds;


	/**
	 * condition-field: 所属租户[MNT_ID] operate-GTEqual[>=]
	 */
	private Long startMntId;

	/**
	 * condition-field: 所属租户[MNT_ID] operate-LTEqual[<=]
	 */
	private Long endMntId;


	/**
	 * condition-field: 所属镜像库[IMG_RESP_ID] operate-Equal[=]
	 */
	private Long imgRespId;


	/**
	 * condition-field: 所属镜像库[IMG_RESP_ID] operate-In[in]
	 */
	private Long[] imgRespIds;


	/**
	 * condition-field: 所属镜像库[IMG_RESP_ID] operate-GTEqual[>=]
	 */
	private Long startImgRespId;

	/**
	 * condition-field: 所属镜像库[IMG_RESP_ID] operate-LTEqual[<=]
	 */
	private Long endImgRespId;


	/**
	 * condition-field: 目录名[DIR_NAME] operate-Like[like]
	 */
	private String dirName;


	/**
	 * condition-field: 镜像名[IMAGE_NAME] operate-Like[like]
	 */
	private String imageName;


	/**
	 * condition-field: 镜像全名[IMAGE_FULL_NAME] operate-Like[like]
	 * 目录名/镜像名-版本号-BUILD号
	 */
	private String imageFullName;


	/**
	 * condition-field: 是否外部镜像[IS_EXTERNAL] operate-Equal[=]
	 * 1=是 0=否
	 */
	private Integer isExternal;


	/**
	 * condition-field: 是否外部镜像[IS_EXTERNAL] operate-In[in]
	 * 1=是 0=否
	 */
	private Integer[] isExternals;


	/**
	 * condition-field: 是否外部镜像[IS_EXTERNAL] operate-GTEqual[>=]
	 * 1=是 0=否
	 */
	private Integer startIsExternal;

	/**
	 * condition-field: 是否外部镜像[IS_EXTERNAL] operate-LTEqual[<=]
	 * 1=是 0=否
	 */
	private Integer endIsExternal;


	/**
	 * condition-field: 所属产品[PRODUCT_ID] operate-Equal[=]
	 */
	private Long productId;


	/**
	 * condition-field: 所属产品[PRODUCT_ID] operate-In[in]
	 */
	private Long[] productIds;


	/**
	 * condition-field: 所属产品[PRODUCT_ID] operate-GTEqual[>=]
	 */
	private Long startProductId;

	/**
	 * condition-field: 所属产品[PRODUCT_ID] operate-LTEqual[<=]
	 */
	private Long endProductId;


	/**
	 * condition-field: 所属工程[PROJECT_ID] operate-Equal[=]
	 */
	private Long projectId;


	/**
	 * condition-field: 所属工程[PROJECT_ID] operate-In[in]
	 */
	private Long[] projectIds;


	/**
	 * condition-field: 所属工程[PROJECT_ID] operate-GTEqual[>=]
	 */
	private Long startProjectId;

	/**
	 * condition-field: 所属工程[PROJECT_ID] operate-LTEqual[<=]
	 */
	private Long endProjectId;


	/**
	 * condition-field: BUILD号[BUILD_NO] operate-Like[like]
	 */
	private String buildNo;


	/**
	 * condition-field: BUILD号[BUILD_NO] operate-Equal[=]
	 */
	private String buildNoEqual;


	/**
	 * condition-field: BUILD号[BUILD_NO] operate-In[in]
	 */
	private String[] buildNos;


	/**
	 * condition-field: 构建时间[BUILD_TIME] operate-Equal[=]
	 */
	private Long buildTime;


	/**
	 * condition-field: 构建时间[BUILD_TIME] operate-In[in]
	 */
	private Long[] buildTimes;


	/**
	 * condition-field: 构建时间[BUILD_TIME] operate-GTEqual[>=]
	 */
	private Long startBuildTime;

	/**
	 * condition-field: 构建时间[BUILD_TIME] operate-LTEqual[<=]
	 */
	private Long endBuildTime;


	/**
	 * condition-field: 构建人[BUILD_USER] operate-Like[like]
	 */
	private String buildUser;


	/**
	 * condition-field: 构建人[BUILD_USER] operate-Equal[=]
	 */
	private String buildUserEqual;


	/**
	 * condition-field: 构建人[BUILD_USER] operate-In[in]
	 */
	private String[] buildUsers;


	/**
	 * condition-field: 状态[STATUS] operate-Equal[=]
	 * 1=快照 2=开发 3=测试 4=生产
	 */
	private Integer status;


	/**
	 * condition-field: 状态[STATUS] operate-In[in]
	 * 1=快照 2=开发 3=测试 4=生产
	 */
	private Integer[] statuss;


	/**
	 * condition-field: 状态[STATUS] operate-GTEqual[>=]
	 * 1=快照 2=开发 3=测试 4=生产
	 */
	private Integer startStatus;

	/**
	 * condition-field: 状态[STATUS] operate-LTEqual[<=]
	 * 1=快照 2=开发 3=测试 4=生产
	 */
	private Integer endStatus;


	/**
	 * condition-field: 发布数据中心[DATA_CENTER_ID] operate-Equal[=]
	 * 状态为快照为空
	 */
	private Long dataCenterId;


	/**
	 * condition-field: 发布数据中心[DATA_CENTER_ID] operate-In[in]
	 * 状态为快照为空
	 */
	private Long[] dataCenterIds;


	/**
	 * condition-field: 发布数据中心[DATA_CENTER_ID] operate-GTEqual[>=]
	 * 状态为快照为空
	 */
	private Long startDataCenterId;

	/**
	 * condition-field: 发布数据中心[DATA_CENTER_ID] operate-LTEqual[<=]
	 * 状态为快照为空
	 */
	private Long endDataCenterId;


	/**
	 * condition-field: 发布资源中心[RES_CENTER_ID] operate-Equal[=]
	 * 状态为快照为空
	 */
	private Long resCenterId;


	/**
	 * condition-field: 发布资源中心[RES_CENTER_ID] operate-In[in]
	 * 状态为快照为空
	 */
	private Long[] resCenterIds;


	/**
	 * condition-field: 发布资源中心[RES_CENTER_ID] operate-GTEqual[>=]
	 * 状态为快照为空
	 */
	private Long startResCenterId;

	/**
	 * condition-field: 发布资源中心[RES_CENTER_ID] operate-LTEqual[<=]
	 * 状态为快照为空
	 */
	private Long endResCenterId;


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
	 * condition-field: 创建人[CREATOR] operate-Like[like]
	 */
	private String creator;


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
	 * condition-field: 修改人[MODIFIER] operate-Like[like]
	 */
	private String modifier;


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


	public Long getDefId() {
		return this.defId;
	}
	public void setDefId(Long defId) {
		this.defId = defId;
	}


	public Long[] getDefIds() {
		return this.defIds;
	}
	public void setDefIds(Long[] defIds) {
		this.defIds = defIds;
	}


	public Long getStartDefId() {
		return this.startDefId;
	}
	public void setStartDefId(Long startDefId) {
		this.startDefId = startDefId;
	}


	public Long getEndDefId() {
		return this.endDefId;
	}
	public void setEndDefId(Long endDefId) {
		this.endDefId = endDefId;
	}


	public Long getMntId() {
		return this.mntId;
	}
	public void setMntId(Long mntId) {
		this.mntId = mntId;
	}


	public Long[] getMntIds() {
		return this.mntIds;
	}
	public void setMntIds(Long[] mntIds) {
		this.mntIds = mntIds;
	}


	public Long getStartMntId() {
		return this.startMntId;
	}
	public void setStartMntId(Long startMntId) {
		this.startMntId = startMntId;
	}


	public Long getEndMntId() {
		return this.endMntId;
	}
	public void setEndMntId(Long endMntId) {
		this.endMntId = endMntId;
	}


	public Long getImgRespId() {
		return this.imgRespId;
	}
	public void setImgRespId(Long imgRespId) {
		this.imgRespId = imgRespId;
	}


	public Long[] getImgRespIds() {
		return this.imgRespIds;
	}
	public void setImgRespIds(Long[] imgRespIds) {
		this.imgRespIds = imgRespIds;
	}


	public Long getStartImgRespId() {
		return this.startImgRespId;
	}
	public void setStartImgRespId(Long startImgRespId) {
		this.startImgRespId = startImgRespId;
	}


	public Long getEndImgRespId() {
		return this.endImgRespId;
	}
	public void setEndImgRespId(Long endImgRespId) {
		this.endImgRespId = endImgRespId;
	}


	public String getDirName() {
		return this.dirName;
	}
	public void setDirName(String dirName) {
		this.dirName = dirName;
	}


	public String getImageName() {
		return this.imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public String getImageFullName() {
		return this.imageFullName;
	}
	public void setImageFullName(String imageFullName) {
		this.imageFullName = imageFullName;
	}


	public Integer getIsExternal() {
		return this.isExternal;
	}
	public void setIsExternal(Integer isExternal) {
		this.isExternal = isExternal;
	}


	public Integer[] getIsExternals() {
		return this.isExternals;
	}
	public void setIsExternals(Integer[] isExternals) {
		this.isExternals = isExternals;
	}


	public Integer getStartIsExternal() {
		return this.startIsExternal;
	}
	public void setStartIsExternal(Integer startIsExternal) {
		this.startIsExternal = startIsExternal;
	}


	public Integer getEndIsExternal() {
		return this.endIsExternal;
	}
	public void setEndIsExternal(Integer endIsExternal) {
		this.endIsExternal = endIsExternal;
	}


	public Long getProductId() {
		return this.productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Long[] getProductIds() {
		return this.productIds;
	}
	public void setProductIds(Long[] productIds) {
		this.productIds = productIds;
	}


	public Long getStartProductId() {
		return this.startProductId;
	}
	public void setStartProductId(Long startProductId) {
		this.startProductId = startProductId;
	}


	public Long getEndProductId() {
		return this.endProductId;
	}
	public void setEndProductId(Long endProductId) {
		this.endProductId = endProductId;
	}


	public Long getProjectId() {
		return this.projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}


	public Long[] getProjectIds() {
		return this.projectIds;
	}
	public void setProjectIds(Long[] projectIds) {
		this.projectIds = projectIds;
	}


	public Long getStartProjectId() {
		return this.startProjectId;
	}
	public void setStartProjectId(Long startProjectId) {
		this.startProjectId = startProjectId;
	}


	public Long getEndProjectId() {
		return this.endProjectId;
	}
	public void setEndProjectId(Long endProjectId) {
		this.endProjectId = endProjectId;
	}


	public String getBuildNo() {
		return this.buildNo;
	}
	public void setBuildNo(String buildNo) {
		this.buildNo = buildNo;
	}


	public String getBuildNoEqual() {
		return this.buildNoEqual;
	}
	public void setBuildNoEqual(String buildNoEqual) {
		this.buildNoEqual = buildNoEqual;
	}


	public String[] getBuildNos() {
		return this.buildNos;
	}
	public void setBuildNos(String[] buildNos) {
		this.buildNos = buildNos;
	}


	public Long getBuildTime() {
		return this.buildTime;
	}
	public void setBuildTime(Long buildTime) {
		this.buildTime = buildTime;
	}


	public Long[] getBuildTimes() {
		return this.buildTimes;
	}
	public void setBuildTimes(Long[] buildTimes) {
		this.buildTimes = buildTimes;
	}


	public Long getStartBuildTime() {
		return this.startBuildTime;
	}
	public void setStartBuildTime(Long startBuildTime) {
		this.startBuildTime = startBuildTime;
	}


	public Long getEndBuildTime() {
		return this.endBuildTime;
	}
	public void setEndBuildTime(Long endBuildTime) {
		this.endBuildTime = endBuildTime;
	}


	public String getBuildUser() {
		return this.buildUser;
	}
	public void setBuildUser(String buildUser) {
		this.buildUser = buildUser;
	}


	public String getBuildUserEqual() {
		return this.buildUserEqual;
	}
	public void setBuildUserEqual(String buildUserEqual) {
		this.buildUserEqual = buildUserEqual;
	}


	public String[] getBuildUsers() {
		return this.buildUsers;
	}
	public void setBuildUsers(String[] buildUsers) {
		this.buildUsers = buildUsers;
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


	public Long getDataCenterId() {
		return this.dataCenterId;
	}
	public void setDataCenterId(Long dataCenterId) {
		this.dataCenterId = dataCenterId;
	}


	public Long[] getDataCenterIds() {
		return this.dataCenterIds;
	}
	public void setDataCenterIds(Long[] dataCenterIds) {
		this.dataCenterIds = dataCenterIds;
	}


	public Long getStartDataCenterId() {
		return this.startDataCenterId;
	}
	public void setStartDataCenterId(Long startDataCenterId) {
		this.startDataCenterId = startDataCenterId;
	}


	public Long getEndDataCenterId() {
		return this.endDataCenterId;
	}
	public void setEndDataCenterId(Long endDataCenterId) {
		this.endDataCenterId = endDataCenterId;
	}


	public Long getResCenterId() {
		return this.resCenterId;
	}
	public void setResCenterId(Long resCenterId) {
		this.resCenterId = resCenterId;
	}


	public Long[] getResCenterIds() {
		return this.resCenterIds;
	}
	public void setResCenterIds(Long[] resCenterIds) {
		this.resCenterIds = resCenterIds;
	}


	public Long getStartResCenterId() {
		return this.startResCenterId;
	}
	public void setStartResCenterId(Long startResCenterId) {
		this.startResCenterId = startResCenterId;
	}


	public Long getEndResCenterId() {
		return this.endResCenterId;
	}
	public void setEndResCenterId(Long endResCenterId) {
		this.endResCenterId = endResCenterId;
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


