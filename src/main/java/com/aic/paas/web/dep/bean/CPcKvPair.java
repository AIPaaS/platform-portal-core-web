package com.aic.paas.web.dep.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 键值表[PC_KV_PAIR]
 */
public class CPcKvPair implements Condition {
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
	 * condition-field: 定义类型[TYPE_ID] operate-Equal[=]
	 * 1=服务定义参数 2=镜像环境变量 3=镜像调用服务参数
	 */
	private Integer typeId;


	/**
	 * condition-field: 定义类型[TYPE_ID] operate-In[in]
	 * 1=服务定义参数 2=镜像环境变量 3=镜像调用服务参数
	 */
	private Integer[] typeIds;


	/**
	 * condition-field: 定义类型[TYPE_ID] operate-GTEqual[>=]
	 * 1=服务定义参数 2=镜像环境变量 3=镜像调用服务参数
	 */
	private Integer startTypeId;

	/**
	 * condition-field: 定义类型[TYPE_ID] operate-LTEqual[<=]
	 * 1=服务定义参数 2=镜像环境变量 3=镜像调用服务参数
	 */
	private Integer endTypeId;


	/**
	 * condition-field: 来源ID[SOURCE_ID] operate-Equal[=]
	 */
	private Long sourceId;


	/**
	 * condition-field: 来源ID[SOURCE_ID] operate-In[in]
	 */
	private Long[] sourceIds;


	/**
	 * condition-field: 来源ID[SOURCE_ID] operate-GTEqual[>=]
	 */
	private Long startSourceId;

	/**
	 * condition-field: 来源ID[SOURCE_ID] operate-LTEqual[<=]
	 */
	private Long endSourceId;


	/**
	 * condition-field: 键描述[KEY_DESC] operate-Like[like]
	 */
	private String keyDesc;


	/**
	 * condition-field: 键描述[KEY_DESC] operate-Equal[=]
	 */
	private String keyDescEqual;


	/**
	 * condition-field: 键描述[KEY_DESC] operate-In[in]
	 */
	private String[] keyDescs;


	/**
	 * condition-field: 键名[KV_KEY] operate-Like[like]
	 */
	private String kvKey;


	/**
	 * condition-field: 键别名[KEY_ALIAS] operate-Like[like]
	 */
	private String keyAlias;


	/**
	 * condition-field: 值[KV_VAL] operate-Like[like]
	 */
	private String kvVal;


	/**
	 * condition-field: 备用字段_1[CUSTOM_1] operate-Equal[=]
	 */
	private Long custom1;


	/**
	 * condition-field: 备用字段_1[CUSTOM_1] operate-In[in]
	 */
	private Long[] custom1s;


	/**
	 * condition-field: 备用字段_1[CUSTOM_1] operate-GTEqual[>=]
	 */
	private Long startCustom1;

	/**
	 * condition-field: 备用字段_1[CUSTOM_1] operate-LTEqual[<=]
	 */
	private Long endCustom1;


	/**
	 * condition-field: 备用字段_2[CUSTOM_2] operate-Equal[=]
	 */
	private Long custom2;


	/**
	 * condition-field: 备用字段_2[CUSTOM_2] operate-In[in]
	 */
	private Long[] custom2s;


	/**
	 * condition-field: 备用字段_2[CUSTOM_2] operate-GTEqual[>=]
	 */
	private Long startCustom2;

	/**
	 * condition-field: 备用字段_2[CUSTOM_2] operate-LTEqual[<=]
	 */
	private Long endCustom2;


	/**
	 * condition-field: 备用字段_3[CUSTOM_3] operate-Equal[=]
	 */
	private Long custom3;


	/**
	 * condition-field: 备用字段_3[CUSTOM_3] operate-In[in]
	 */
	private Long[] custom3s;


	/**
	 * condition-field: 备用字段_3[CUSTOM_3] operate-GTEqual[>=]
	 */
	private Long startCustom3;

	/**
	 * condition-field: 备用字段_3[CUSTOM_3] operate-LTEqual[<=]
	 */
	private Long endCustom3;


	/**
	 * condition-field: 备用字段_4[CUSTOM_4] operate-Like[like]
	 */
	private String custom4;


	/**
	 * condition-field: 备用字段_5[CUSTOM_5] operate-Like[like]
	 */
	private String custom5;


	/**
	 * condition-field: 备用字段_6[CUSTOM_6] operate-Like[like]
	 */
	private String custom6;


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


	public Integer getTypeId() {
		return this.typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}


	public Integer[] getTypeIds() {
		return this.typeIds;
	}
	public void setTypeIds(Integer[] typeIds) {
		this.typeIds = typeIds;
	}


	public Integer getStartTypeId() {
		return this.startTypeId;
	}
	public void setStartTypeId(Integer startTypeId) {
		this.startTypeId = startTypeId;
	}


	public Integer getEndTypeId() {
		return this.endTypeId;
	}
	public void setEndTypeId(Integer endTypeId) {
		this.endTypeId = endTypeId;
	}


	public Long getSourceId() {
		return this.sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}


	public Long[] getSourceIds() {
		return this.sourceIds;
	}
	public void setSourceIds(Long[] sourceIds) {
		this.sourceIds = sourceIds;
	}


	public Long getStartSourceId() {
		return this.startSourceId;
	}
	public void setStartSourceId(Long startSourceId) {
		this.startSourceId = startSourceId;
	}


	public Long getEndSourceId() {
		return this.endSourceId;
	}
	public void setEndSourceId(Long endSourceId) {
		this.endSourceId = endSourceId;
	}


	public String getKeyDesc() {
		return this.keyDesc;
	}
	public void setKeyDesc(String keyDesc) {
		this.keyDesc = keyDesc;
	}


	public String getKeyDescEqual() {
		return this.keyDescEqual;
	}
	public void setKeyDescEqual(String keyDescEqual) {
		this.keyDescEqual = keyDescEqual;
	}


	public String[] getKeyDescs() {
		return this.keyDescs;
	}
	public void setKeyDescs(String[] keyDescs) {
		this.keyDescs = keyDescs;
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


	public Long[] getCustom1s() {
		return this.custom1s;
	}
	public void setCustom1s(Long[] custom1s) {
		this.custom1s = custom1s;
	}


	public Long getStartCustom1() {
		return this.startCustom1;
	}
	public void setStartCustom1(Long startCustom1) {
		this.startCustom1 = startCustom1;
	}


	public Long getEndCustom1() {
		return this.endCustom1;
	}
	public void setEndCustom1(Long endCustom1) {
		this.endCustom1 = endCustom1;
	}


	public Long getCustom2() {
		return this.custom2;
	}
	public void setCustom2(Long custom2) {
		this.custom2 = custom2;
	}


	public Long[] getCustom2s() {
		return this.custom2s;
	}
	public void setCustom2s(Long[] custom2s) {
		this.custom2s = custom2s;
	}


	public Long getStartCustom2() {
		return this.startCustom2;
	}
	public void setStartCustom2(Long startCustom2) {
		this.startCustom2 = startCustom2;
	}


	public Long getEndCustom2() {
		return this.endCustom2;
	}
	public void setEndCustom2(Long endCustom2) {
		this.endCustom2 = endCustom2;
	}


	public Long getCustom3() {
		return this.custom3;
	}
	public void setCustom3(Long custom3) {
		this.custom3 = custom3;
	}


	public Long[] getCustom3s() {
		return this.custom3s;
	}
	public void setCustom3s(Long[] custom3s) {
		this.custom3s = custom3s;
	}


	public Long getStartCustom3() {
		return this.startCustom3;
	}
	public void setStartCustom3(Long startCustom3) {
		this.startCustom3 = startCustom3;
	}


	public Long getEndCustom3() {
		return this.endCustom3;
	}
	public void setEndCustom3(Long endCustom3) {
		this.endCustom3 = endCustom3;
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


