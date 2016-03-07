package com.aic.paas.web.rest;

import java.util.List;

import com.aic.paas.web.dep.bean.CPcService;
import com.aic.paas.web.dep.bean.PcKvPair;
import com.aic.paas.web.dep.bean.PcService;
import com.aic.paas.web.dep.bean.PcServiceInfo;
import com.binary.jdbc.Page;

public interface PcServiceSvc {
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcService> queryPage(Integer pageNum, Integer pageSize, CPcService cdt, String orders);


	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcService> queryList(CPcService cdt, String orders);

	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcService queryById(Long id);
	
	
	
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcServiceInfo> queryInfoPage(Integer pageNum, Integer pageSize, CPcService cdt, String orders);


	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcServiceInfo> queryInfoList(CPcService cdt, String orders);

	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcServiceInfo queryInfoById(Long id);
	
	
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : PcService数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdate(PcService record);
	
	
	
	
	
	/**
	 * 跟据分类ID删除
	 * @param id
	 * @return
	 */
	public int removeById(Long id);
	
	
	
	
	/**
	 * 查询服务参数
	 * @param svcId
	 * @param orders
	 * @return
	 */
	public List<PcKvPair> queryParams(Long svcId, String orders);
	
	
	
	/**
	 * 重置服务参数
	 * @param svcId
	 * @param params
	 */
	public void resetParams(Long svcId, List<PcKvPair> params);
	
	
	
	/**
	 * 删除参数
	 * @param svcId
	 */
	public void removeParams(Long svcId);
	
	
	/**
	 * 分页查询  结果集有扩展字段 -- 镜像服务提供者、引用者信息
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcServiceInfo> queryPage4Info(Integer pageNum, Integer pageSize, CPcService cdt, String orders);

	
	
	
	

}
