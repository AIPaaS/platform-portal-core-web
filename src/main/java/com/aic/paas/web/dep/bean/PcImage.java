package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 镜像表[PC_IMAGE]
 */
public class PcImage implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 所属定义[DEF_ID]
	 */
	private Long defId;


	/**
	 * mapping-field: 所属租户[MNT_ID]
	 */
	private Long mntId;


	/**
	 * mapping-field: 所属镜像库[IMG_RESP_ID]
	 */
	private Long imgRespId;


	/**
	 * mapping-field: 目录名[DIR_NAME]
	 */
	private String dirName;


	/**
	 * mapping-field: 镜像名[IMAGE_NAME]
	 */
	private String imageName;


	/**
	 * mapping-field: 镜像全名[IMAGE_FULL_NAME]
	 * 目录名/镜像名-版本号-BUILD号
	 */
	private String imageFullName;


	/**
	 * mapping-field: 是否外部镜像[IS_EXTERNAL]
	 * 1=是 0=否
	 */
	private Integer isExternal;


	/**
	 * mapping-field: 所属产品[PRODUCT_ID]
	 */
	private Long productId;


	/**
	 * mapping-field: 所属工程[PROJECT_ID]
	 */
	private Long projectId;


	/**
	 * mapping-field: BUILD号[BUILD_NO]
	 */
	private String buildNo;


	/**
	 * mapping-field: 构建时间[BUILD_TIME]
	 */
	private Long buildTime;


	/**
	 * mapping-field: 构建人[BUILD_USER]
	 */
	private String buildUser;


	/**
	 * mapping-field: 状态[STATUS]
	 * 1=快照 2=开发 3=测试 4=生产
	 */
	private Integer status;


	/**
	 * mapping-field: 发布数据中心[DATA_CENTER_ID]
	 * 状态为快照为空
	 */
	private Long dataCenterId;


	/**
	 * mapping-field: 发布资源中心[RES_CENTER_ID]
	 * 状态为快照为空
	 */
	private Long resCenterId;


	/**
	 * mapping-field: 数据状态[DATA_STATUS]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer dataStatus;


	/**
	 * mapping-field: 创建人[CREATOR]
	 */
	private String creator;


	/**
	 * mapping-field: 创建时间[CREATE_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long createTime;


	/**
	 * mapping-field: 修改人[MODIFIER]
	 */
	private String modifier;


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


	public Long getDefId() {
		return this.defId;
	}
	public void setDefId(Long defId) {
		this.defId = defId;
	}


	public Long getMntId() {
		return this.mntId;
	}
	public void setMntId(Long mntId) {
		this.mntId = mntId;
	}


	public Long getImgRespId() {
		return this.imgRespId;
	}
	public void setImgRespId(Long imgRespId) {
		this.imgRespId = imgRespId;
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


	public Long getProductId() {
		return this.productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Long getProjectId() {
		return this.projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}


	public String getBuildNo() {
		return this.buildNo;
	}
	public void setBuildNo(String buildNo) {
		this.buildNo = buildNo;
	}


	public Long getBuildTime() {
		return this.buildTime;
	}
	public void setBuildTime(Long buildTime) {
		this.buildTime = buildTime;
	}


	public String getBuildUser() {
		return this.buildUser;
	}
	public void setBuildUser(String buildUser) {
		this.buildUser = buildUser;
	}


	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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


}


