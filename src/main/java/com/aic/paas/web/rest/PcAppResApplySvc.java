package com.aic.paas.web.rest;

import java.util.List;

import com.aic.paas.web.res.bean.CPcAppResApply;
import com.aic.paas.web.res.bean.PcAppResApply;
import com.aic.paas.web.res.bean.PcAppResApplyInfo;
import com.binary.jdbc.Page;

public interface PcAppResApplySvc {
	
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcAppResApply> queryPage(Integer pageNum, Integer pageSize, CPcAppResApply cdt, String orders);


	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcAppResApply> queryList(CPcAppResApply cdt, String orders);

	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcAppResApply queryById(Long id);
	
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcAppResApplyInfo> queryInfoPage(Integer pageNum, Integer pageSize, CPcAppResApply cdt, String orders);


	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcAppResApplyInfo> queryInfoList(CPcAppResApply cdt, String orders);

	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcAppResApplyInfo queryInfoById(Long id);
	
	
	
	
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : PcAppResApply数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdate(PcAppResApply record);
	
	
	
	
	/**
	 * 取消申请
	 * @param id
	 * @return
	 */
	public void cannelApply(Long id);
	
	
	
	
	
	/**
	 * 审核申请单
	 * @param id
	 * @param pass true=通过    false=退回
	 * @param checkDesc 
	 * @return
	 */
	public void checkApply(Long id, Boolean pass, String checkDesc);
	
	
	
	

}
