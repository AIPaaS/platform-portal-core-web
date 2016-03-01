package com.aic.paas.web.res.peer;

import java.util.List;

import com.aic.paas.web.res.bean.PcComputerTag;

public interface PcComputerPeer {
	
	
	
	
	/**
	 * 跟据netZoneId查询服务器标签
	 * @param netZoneId
	 * @return
	 */
	public List<PcComputerTag> queryComputerTagsByNetZoneId(Long netZoneId);
	
	
	

}
