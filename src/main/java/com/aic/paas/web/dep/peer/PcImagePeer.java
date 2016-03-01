package com.aic.paas.web.dep.peer;

import java.util.List;

import com.aic.paas.web.dep.bean.CPcImage;
import com.aic.paas.web.dep.bean.PcImage;

public interface PcImagePeer {
	
	
	
	/**
	 * 不分页查询当前租户下的镜像定义
	 * @param cdt
	 * @param orders
	 * @return
	 */
	public List<PcImage> queryImageList(CPcImage cdt, String orders);
	
	
	/**
	 * 根据主键查询
	 * @return
	 */
	public PcImage queryImageById(Long imageId);
	
	
	
	
	
	

}
