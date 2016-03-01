package com.aic.paas.web.rest;

import java.util.List;

import com.aic.paas.web.res.bean.CPcAppRes;
import com.aic.paas.web.res.bean.CPcAppResFlow;
import com.aic.paas.web.res.bean.PcAppRes;
import com.aic.paas.web.res.bean.PcAppResFlow;
import com.aic.paas.web.res.bean.ResItems;
import com.binary.jdbc.Page;

public interface PcAppResSvc {
	
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcAppRes> queryResPage(Integer pageNum, Integer pageSize, CPcAppRes cdt, String orders);


	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcAppRes> queryResList(CPcAppRes cdt, String orders);

	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcAppRes queryResById(Long id);
	
	
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcAppResFlow> queryFlowPage(Integer pageNum, Integer pageSize, CPcAppResFlow cdt, String orders);


	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcAppResFlow> queryFlowList(CPcAppResFlow cdt, String orders);

	
	
	
	/**
	 * 创建资源
	 * @param appId
	 * @param mntId
	 * @param dataCenterId
	 * @param resCenterId
	 * @param netZoneId
	 * @return
	 */
	public PcAppRes createRes(Long appId, Long mntId, Long dataCenterId, Long resCenterId, Long netZoneId);
	
	
	
	/**
	 * 删除应用资源
	 * @param appId
	 * @param netZoneId 删除指定网络区域资源
	 * @return 被释放的资源
	 */
	public List<PcAppRes> removeResByApp(Long appId, Long netZoneId);
	
	
	
	
	/**
	 * 删除应用下所有资源
	 * @param appId
	 * @return 被释放的资源
	 */
	public List<PcAppRes> removeAllResByApp(Long appId);
	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcAppResFlow queryFlowById(Long id);
	
	
	
	
	
	/**
	 * 添加资源, 资源项目数据如果有负值则取绝对值
	 * @param id 资源ID
	 * @param items 添加资源项目
	 * @param upor 更新人
	 * @param remark 说明
	 * @param applyId 对应申请单ID, 可为空
	 * @return
	 */
	public Integer addRes(Long id, ResItems items, String upor, String remark, Long applyId);
	
	
	
	
	
	/**
	 * 扣减资源
	 * @param id 资源ID
	 * @param items 添加资源项目
	 * @param upor 更新人
	 * @param remark 说明
	 * @param validity 是否需要验证扣减有效性, 缺省为true
	 * @param applyId 对应申请单ID, 可为空
	 * @return
	 */
	public Integer reduceRes(Long id, ResItems items, String upor, String remark, Long applyId, Boolean validity);
	
	
	
	
	

}
