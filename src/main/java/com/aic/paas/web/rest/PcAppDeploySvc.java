package com.aic.paas.web.rest;

import java.util.List;

import com.aic.paas.web.dep.bean.CPcAppDepHistory;
import com.aic.paas.web.dep.bean.CPcAppDepInstance;
import com.aic.paas.web.dep.bean.PcAppDepHistory;
import com.aic.paas.web.dep.bean.PcAppDepInstance;
import com.aic.paas.web.dep.bean.PcImage;
import com.binary.jdbc.Page;

public interface PcAppDeploySvc {
	
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcAppDepHistory> queryDepHistoryPage(Integer pageNum, Integer pageSize, CPcAppDepHistory cdt, String orders);


	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcAppDepHistory> queryDepHistoryList(CPcAppDepHistory cdt, String orders);

	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcAppDepHistory queryDepHistoryById(Long id);
	
	
	
	
	/**
	 * 跟据历史发布信息获取实例
	 * @param depHistoryId
	 * @return
	 */
	public List<PcAppDepInstance> queryDepInstance(Long depHistoryId, CPcAppDepInstance cdt, String orders);
	
	
	
	
	
	/**
	 * 布署应用
	 * @param appId 应用ID
	 * @param appVnoId 应用版本号
	 */
	public void deployApp(Long appId, Long appVnoId);
	
	
	
	
	
	/**
	 * 结束应用部署
	 * @param appId
	 * @param appVnoId
	 * @param remark
	 */
	public void finishDeployApp(Long appId, Long appVnoId, List<PcImage> images, String remark);
	
	
	
	
	

}
