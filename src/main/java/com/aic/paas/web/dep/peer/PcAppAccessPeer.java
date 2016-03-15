package com.aic.paas.web.dep.peer;

import java.util.List;

import com.aic.paas.web.dep.bean.CPcAppAccess;
import com.aic.paas.web.dep.bean.PcAppAccess;
import com.aic.paas.web.dep.bean.PcAppAccessInfo;
import com.binary.jdbc.Page;

public interface PcAppAccessPeer {

	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcAppAccess> queryPage(Integer pageNum, Integer pageSize, CPcAppAccess cdt, String orders);

	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcAppAccess> queryList(CPcAppAccess cdt, String orders);

	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 应用访问表[PC_APP_ACCESS]映射对象
	 */
	public PcAppAccess queryById(Long id);
	
	

	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcAppAccessInfo> queryInfoList(CPcAppAccess cdt, String orders);

	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcAppAccessInfo queryInfoById(Long id);
	
	
	
	
	/**
	 * 保存或更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : PcAppAccess数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdate(PcAppAccess record);
	
	
	/**
	 * 根据分类ID删除
	 * @param id
	 * @return
	 */
	public int removeById(Long id);
	

	
	/**
	 * 分页查询 -- 加了一些扩展字段
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcAppAccessInfo> queryPage4Info(Integer pageNum, Integer pageSize, CPcAppAccess cdt, String orders);

	
}
