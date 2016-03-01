package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 应用布署键值历史表[PC_APP_DEP_KV_HISTORY]
 */
public class PcAppDepKvHistory implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 定义类型[TYPE_ID]
	 * 1=服务参数 3=镜像参数
	 */
	private Integer typeId;


	/**
	 * mapping-field: 来源ID[SOURCE_ID]
	 */
	private Long sourceId;


	/**
	 * mapping-field: 键描述[KEY_DESC]
	 */
	private String keyDesc;


	/**
	 * mapping-field: 键名[KV_KEY]
	 */
	private String kvKey;


	/**
	 * mapping-field: 键别名[KEY_ALIAS]
	 */
	private String keyAlias;


	/**
	 * mapping-field: 值[KV_VAL]
	 */
	private String kvVal;


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


	public Integer getTypeId() {
		return this.typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}


	public Long getSourceId() {
		return this.sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}


	public String getKeyDesc() {
		return this.keyDesc;
	}
	public void setKeyDesc(String keyDesc) {
		this.keyDesc = keyDesc;
	}


	public String getKvKey() {
		return this.kvKey;
	}
	public void setKvKey(String kvKey) {
		this.kvKey = kvKey;
	}


	public String getKeyAlias() {
		return this.keyAlias;
	}
	public void setKeyAlias(String keyAlias) {
		this.keyAlias = keyAlias;
	}


	public String getKvVal() {
		return this.kvVal;
	}
	public void setKvVal(String kvVal) {
		this.kvVal = kvVal;
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


