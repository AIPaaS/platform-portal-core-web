package com.aic.paas.web.res.peer;

import java.util.List;

import com.aic.paas.web.dep.bean.CPcApp;
import com.aic.paas.web.res.bean.AppResInfo;
import com.aic.paas.web.res.bean.CPcAppRes;
import com.aic.paas.web.res.bean.CPcAppResApply;
import com.aic.paas.web.res.bean.CPcAppResFlow;
import com.aic.paas.web.res.bean.PcAppRes;
import com.aic.paas.web.res.bean.PcAppResApply;
import com.aic.paas.web.res.bean.PcAppResApplyInfo;
import com.aic.paas.web.res.bean.PcAppResFlow;
import com.binary.jdbc.Page;

public interface PcAppResPeer {
	
	
	
	/**
	 * 分页查询应用及应用资源
	 * @param pageNum
	 * @param pageSize
	 * @param cdt
	 * @param orders
	 * @return
	 */
	public Page<AppResInfo> queryAppResInfoPage(Integer pageNum, Integer pageSize, CPcApp cdt, String orders);
	
	
	
	
	/**
	 * 查询应用及应用资源
	 * @param cdt
	 * @param orders
	 * @return
	 */
	public List<AppResInfo> queryAppResInfoList(CPcApp cdt, String orders);
	
	
	
	/**
	 * 查询应用资源
	 * @param appId
	 * @return
	 */
	public AppResInfo queryAppResInfoById(Long appId);
	
	
	
	
	
	/**
	 * 不分页查询
	 * @param appId 应用ID
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcAppRes> getAppResList(Long appId, CPcAppRes cdt, String orders);
	
	
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcAppResFlow> queryResFlowPage(Integer pageNum, Integer pageSize, Long resId, CPcAppResFlow cdt, String orders);
	
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcAppResApply> queryApplyPage(Integer pageNum, Integer pageSize, CPcAppResApply cdt, String orders);
	
	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcAppResApply queryApplyById(Long applyId);
	
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcAppResApplyInfo> queryApplyInfoPage(Integer pageNum, Integer pageSize, CPcAppResApply cdt, String orders);


	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcAppResApplyInfo queryApplyInfoById(Long applyId);
	
	
	
	
	
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : PcAppResApply数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdateApply(PcAppResApply record);
	
	
	
	
	/**
	 * 取消申请
	 * @param id
	 * @return
	 */
	public void cannelApply(Long applyId);
	

	
	
	/**
	 * 审核申请单
	 * @param applyId
	 * @param pass true=通过    false=退回
	 * @param checkDesc 
	 * @return
	 */
	public void checkApply(Long applyId, Boolean pass, String checkDesc);
	
	
	
	
}
