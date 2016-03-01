package com.aic.paas.web.res.peer;

import java.util.List;

import com.aic.paas.web.dep.bean.AppResInfo;
import com.aic.paas.web.res.bean.CPsMntRes;
import com.aic.paas.web.res.bean.CPsMntResApply;
import com.aic.paas.web.res.bean.CPsMntResFlow;
import com.aic.paas.web.res.bean.PsMntRes;
import com.aic.paas.web.res.bean.PsMntResApply;
import com.aic.paas.web.res.bean.PsMntResFlow;
import com.binary.jdbc.Page;

public interface MntResPeer {
	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PsMntRes> getMntResList(CPsMntRes cdt, String orders);
	
	
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PsMntResFlow> queryResFlowPage(Integer pageNum, Integer pageSize, Long resId, CPsMntResFlow cdt, String orders);
	
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PsMntResApply> queryApplyPage(Integer pageNum, Integer pageSize, CPsMntResApply cdt, String orders);
	
	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PsMntResApply queryApplyById(Long applyId);
	
	
	
	
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : PsMntResApply数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdateApply(PsMntResApply record);
	
	
	
	
	/**
	 * 取消申请
	 * @param id
	 * @return
	 */
	public void cannelApply(Long applyId);
	
	
	
	
	/**
	 * 查询租户资源使用情况
	 * @return
	 */
	public List<AppResInfo> queryUseStateList();
	
	
	
	
	
}
