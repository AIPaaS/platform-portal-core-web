package com.aic.paas.web.dep.peer;

import java.util.List;

import com.aic.paas.web.dep.bean.AppMgrInfo;
import com.aic.paas.web.dep.bean.AppResInfo;
import com.aic.paas.web.dep.bean.AppTimerInfo;
import com.aic.paas.web.dep.bean.AppZoneResInfo;
import com.aic.paas.web.dep.bean.CPcApp;
import com.aic.paas.web.dep.bean.PcApp;
import com.aic.paas.web.res.bean.PcAppRes;
import com.binary.jdbc.Page;

public interface PcAppPeer {
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<AppMgrInfo> queryInfoPage(Integer pageNum, Integer pageSize, CPcApp cdt, String orders);


	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<AppMgrInfo> queryInfoList(CPcApp cdt, String orders);

	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public AppMgrInfo queryInfoById(Long id);
	
	
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	public PcApp queryById(Long id);
	
	
	
	
	
	/**
	 * 查询管理员所管理的产品
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcApp> queryMgrPage(Integer pageNum, Integer pageSize, CPcApp cdt, String orders);


	
	
	
	/**
	 * 查询管理员所管理的产品
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcApp> queryMgrList(CPcApp cdt, String orders);

	
	
	
	/**
	 * 分页查询应用部署信息
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<AppResInfo> queryMgrResInfoPage(Integer pageNum, Integer pageSize, CPcApp cdt, String orders);
	
		
	/**
	 * 分页查询应用部署信息
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<AppTimerInfo> queryMgrAppTimerInfoPage(Integer pageNum, Integer pageSize, CPcApp cdt, String orders);
	
	
	
	/**
	 * 查询应用资源占用情况
	 * @param appId
	 * @return
	 */
	public List<AppZoneResInfo> queryAppNetZoneResInfo(Long appId, Long appVnoId);
	
	
	
	
	/**
	 * 查询应用在指定络网络区域资源剩余
	 * @param appId
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
	 * 设置产品管理员
	 * @param appId
	 * @param mgrIds
	 */
	public void setAppMgrs(Long appId, Long[] mgrIds);
	
	public int queryAppImageCount(Long appId);

}
