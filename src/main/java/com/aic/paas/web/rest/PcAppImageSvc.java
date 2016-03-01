package com.aic.paas.web.rest;

import java.util.List;

import com.aic.paas.web.dep.bean.AppImageCallServiceRlt;
import com.aic.paas.web.dep.bean.AppImageSettings;
import com.aic.paas.web.dep.bean.AppImageSvcInfo;
import com.aic.paas.web.dep.bean.CPcAppImage;
import com.aic.paas.web.dep.bean.PcAppImage;
import com.aic.paas.web.dep.bean.PcKvPair;
import com.aic.paas.web.dep.bean.PcService;
import com.binary.jdbc.Page;

public interface PcAppImageSvc {
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcAppImage> queryPage(Integer pageNum, Integer pageSize, CPcAppImage cdt, String orders);


	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcAppImage> queryList(CPcAppImage cdt, String orders);

	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcAppImage queryById(Long id);
	
	
	
	
	
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : PcAppImage数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdate(PcAppImage record);
	
	
	
	
	
	/**
	 * 跟据分类ID删除
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id);
	
	
	
	
	
	
	/**
	 * 获取镜像作为服务开放时服务信息
	 * @param appImageId
	 * @return
	 */
	public AppImageSvcInfo getAppImageOpenService(Long appImageId);
	
	
	
	
	/**
	 * 保存服务开放信息
	 * @param isOpen 是否开放
	 * @param appImageId
	 * @param svc
	 * @param params
	 * @return 服务ID
	 */
	public Long saveAppImageOpenService(Integer isOpen, Long appImageId, PcService svc, List<PcKvPair> params);
	
	
	
	
	/**
	 * 获取当前镜像依赖于其他镜像
	 * @param appImageId
	 * @return
	 */
	public List<PcAppImage> getAppImageDependImages(Long appImageId);
	
	
	
	
	/**
	 * 保存镜像镜像依赖于其他镜像关系
	 * @param appImageId
	 * @param dependAppImageIds
	 */
	public void saveAppImageDependImages(Long appImageId, Long[] dependAppImageIds);
	
	
	
	
	
	/**
	 * 获取当前镜像调用的服务列表
	 * @param appImageId
	 * @return
	 */
	public List<AppImageSvcInfo> getAppImageCallService(Long appImageId);
	
	
	
	
	/**
	 * 保存镜像调用的服务列表
	 * @param appImageId
	 * @param svcinfos
	 */
	public void saveAppImageCallService(Long appImageId, List<AppImageCallServiceRlt> rlts);
	
	
	
	
	/**
	 * 获取镜像参数
	 * @param appImageId
	 * @return
	 */
	public List<PcKvPair> getAppImageParams(Long appImageId);
	
	
	
	
	/**
	 * 保存镜像参数
	 * @param appImageId
	 * @param params
	 */
	public void saveAppImageParams(Long appImageId, List<PcKvPair> params);
	
	
	
	
	/**
	 * 获取镜像所有配置信息
	 * @param appImageId
	 * @return
	 */
	public AppImageSettings getAppImageSettings(Long appImageId);
	
	
	
	
	
	/**
	 * 结束配置
	 * @param appImageId
	 */
	public void finishAppImageSettings(Long appImageId);
	
	
	
	
	
	
}









