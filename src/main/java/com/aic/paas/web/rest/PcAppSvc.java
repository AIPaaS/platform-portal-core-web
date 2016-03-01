package com.aic.paas.web.rest;

import java.util.List;

import com.aic.paas.web.dep.bean.AppInfo;
import com.aic.paas.web.dep.bean.AppResInfo;
import com.aic.paas.web.dep.bean.AppZoneResInfo;
import com.aic.paas.web.dep.bean.CPcApp;
import com.aic.paas.web.dep.bean.PcApp;
import com.aic.paas.web.res.bean.PcAppRes;
import com.binary.jdbc.Page;

public interface PcAppSvc {
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcApp> queryPage(Integer pageNum, Integer pageSize, CPcApp cdt, String orders);


	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcApp> queryList(CPcApp cdt, String orders);

	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcApp queryById(Long id);
	
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<AppInfo> queryInfoPage(Integer pageNum, Integer pageSize, CPcApp cdt, String orders);


	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<AppInfo> queryInfoList(CPcApp cdt, String orders);

	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public AppInfo queryInfoById(Long id);
	
	
	
	
	
	/**
	 * 查询管理员所管理的应用
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcApp> queryMgrPage(Integer pageNum, Integer pageSize, Long mgrId, CPcApp cdt, String orders);


	
	
	
	/**
	 * 查询管理员所管理的应用
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcApp> queryMgrList(Long mgrId, CPcApp cdt, String orders);

	
	
	
	
	
	
	/**
	 * 分页查询应用部署信息
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<AppResInfo> queryResInfoPage(Integer pageNum, Integer pageSize, CPcApp cdt, String orders);


	
	
	
	/**
	 * 不分页查询应用部署信息
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<AppResInfo> queryResInfoList(CPcApp cdt, String orders);

	
	
	/**
	 * 查询应用部署信息
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public AppResInfo queryResInfoById(Long appId);
	
	
	
	/**
	 * 分页查询应用部署信息
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<AppResInfo> queryMgrResInfoPage(Integer pageNum, Integer pageSize, Long mgrId, CPcApp cdt, String orders);


	
	
	
	/**
	 * 不分页查询应用部署信息
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<AppResInfo> queryMgrResInfoList(Long mgrId, CPcApp cdt, String orders);
	
	
	
	
	
	/**
	 * 查询应用和容器在各络网络区域资源占用情况
	 * @param appId 应用ID, 不可以为空
	 * @param netZoneId 指定网络区域, 可以为空, 为空则查询各网络区域, 不为空则返回一条记录(如果应用存在)
	 * @return
	 */
	public List<AppZoneResInfo> queryAppNetZoneResInfo(Long appId, Long appVnoId, Long netZoneId);
	
	
	
		
	/**
	 * 查询应用在指定络网络区域资源剩余
	 * @param appId
	 * @param appVnoId
	 * @param netZoneId
	 * @return
	 */
	public PcAppRes queryAppResidueRes(Long appId, Long appVnoId, Long netZoneId);
	
	
	
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : PcApp数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdate(PcApp record);
	
	
	
	
	
	/**
	 * 跟据分类ID删除
	 * @param id
	 * @return
	 */
	public int removeById(Long id);
	
	
	
	
	
	/**
	 * 设置应用管理员
	 * @param appId
	 * @param mgrIds
	 */
	public void setAppMgrs(Long appId, Long[] mgrIds);
	
	

}
