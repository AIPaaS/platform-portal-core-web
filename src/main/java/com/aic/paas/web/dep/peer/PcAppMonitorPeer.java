package com.aic.paas.web.dep.peer;

import java.util.List;

import com.aic.paas.web.dep.bean.CPcAppDepHistory;
import com.aic.paas.web.dep.bean.CPcAppDepInstance;
import com.aic.paas.web.dep.bean.PcAppDepHistory;
import com.aic.paas.web.dep.bean.PcAppDepInstance;
import com.binary.jdbc.Page;

public interface PcAppMonitorPeer {

	
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
	 * 跟据历史发布信息获取实例
	 * @param depHistoryId
	 * @return
	 */
	public List<PcAppDepInstance> queryDepInstance(Long depHistoryId, CPcAppDepInstance cdt, String orders);
	
	
	
	/**
	 * 分页查询
	 * 跟据历史发布信息获取实例
	 * @param depHistoryId
	 * @return
	 */
	 public Page<PcAppDepInstance> queryDepInstancePage(Integer pageNum, Integer pageSize, Long depHistoryId, CPcAppDepInstance cdt, String orders);
}
