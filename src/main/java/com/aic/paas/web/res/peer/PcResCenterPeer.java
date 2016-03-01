package com.aic.paas.web.res.peer;

import java.util.List;

import com.aic.paas.web.res.bean.CPcResCenter;
import com.aic.paas.web.res.bean.PcResCenter;

public interface PcResCenterPeer {

	

	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcResCenter> queryList(CPcResCenter cdt, String orders);

	



}
