package com.aic.paas.web.res.peer;

import java.util.List;

import com.aic.paas.web.res.bean.CPcDataCenter;
import com.aic.paas.web.res.bean.PcDataCenter;

public interface PcDataCenterPeer {
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcDataCenter> queryList(CPcDataCenter cdt, String orders);

}
