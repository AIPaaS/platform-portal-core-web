package com.aic.paas.web.dep.peer;

import java.util.List;

import com.aic.paas.web.dep.bean.AppImageCallServiceRlt;
import com.aic.paas.web.dep.bean.AppImageDepends;
import com.aic.paas.web.dep.bean.AppImageSettings;
import com.aic.paas.web.dep.bean.AppImageSvcInfo;
import com.aic.paas.web.dep.bean.CPcAppImage;
import com.aic.paas.web.dep.bean.PcAppImage;
import com.aic.paas.web.dep.bean.PcAppImageInfo;
import com.aic.paas.web.dep.bean.PcKvPair;
import com.aic.paas.web.dep.bean.PcService;
import com.aic.paas.web.dep.bean.PcServiceInfo;
import com.binary.jdbc.Page;

public interface PcAppImagePeer {
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcAppImage> queryAppImagePage(Integer pageNum, Integer pageSize, Long appId, Long appVnoId, CPcAppImage cdt, String orders);


	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcAppImage> queryAppImageList(Long appId, Long appVnoId, CPcAppImage cdt, String orders);

	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcAppImage queryAppImageById(Long appImageId);
	
	
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcAppImageInfo> queryAppImageInfoPage(Integer pageNum, Integer pageSize, Long appId, Long appVnoId, CPcAppImage cdt, String orders);


	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcAppImageInfo> queryAppImageInfoList(Long appId, Long appVnoId, CPcAppImage cdt, String orders);

	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcAppImageInfo queryAppImageInfoById(Long appImageId);
	
	
	
	
	
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : PcAppImage数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveAppImage(PcAppImage record);
	
	
	
	
	
	/**
	 * 跟据分类ID删除
	 * @param id
	 * @return
	 */
	public Integer removeAppImage(Long appImageId);
	
	
	
	
	
	
	
	
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
	 */
	public Long saveAppImageOpenService(Integer isOpen, Long appImageId, PcService svc, List<PcKvPair> params);
	
	
	
	
	/**
	 * 查询选择的依赖服务
	 * @param appImageId
	 * @return
	 */
	public List<PcServiceInfo> querySelectServiceInfoList(Long appImageId);
	
	
	
	
	
	/**
	 * 获取当前镜像依赖
	 * @param appImageId
	 * @return
	 */
	public AppImageDepends getAppImageDepends(Long appImageId);
	
	
	
	
	/**
	 * 保存镜像调用的服务列表
	 * @param appImageId
	 * @param svcinfos
	 */
	public void saveAppImageDepends(Long appImageId, List<AppImageCallServiceRlt> rlts, Long[] dependAppImageIds);
	
	
	
	
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
	
	
	
	/**
	 * 更新容器暴露信息
	 * @param isOpen 是否开放
	 * @param isOpen 是否入口
	 * @param appImageId
	 * @param svc
	 * @param params
	 */
	public Long updateAppImage(Integer isOpen, Long appImageId, Long isAccess,PcService svc, List<PcKvPair> params);
	
	
	/**
	 * 不分页查询 带上容器的暴露参数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcAppImageInfo> queryAppImageParamList(Long appId, Long appVnoId, CPcAppImage cdt, String orders);
	
	
	/**
	 * 获取当前镜像依赖  带上容器的依赖参数
	 * @param appImageId
	 * @return
	 */
	public AppImageDepends getAppImageInfoDepends(Long appImageId);
	
	
	/**
	 * 保存镜像调用的服务列表  依赖容器
	 * @param appImageId
	 * @param svcinfos
	 */
	public void saveAppImageDepends(Long appImageId, List<AppImageCallServiceRlt> rlts, List<AppImageCallServiceRlt> dependAppImages);
	
}
