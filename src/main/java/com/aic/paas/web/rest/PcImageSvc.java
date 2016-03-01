package com.aic.paas.web.rest;

import java.util.List;

import com.aic.paas.web.dep.bean.CPcImage;
import com.aic.paas.web.dep.bean.PcImage;

public interface PcImageSvc {
	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcImage> queryImageList(CPcImage cdt, String orders);

	
	
	/**
	 * 跟据镜像全名查询
	 * @param fullName 全名
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcImage> queryImageListByFullName(String fullName, CPcImage cdt, String orders);
	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcImage queryImageById(Long id);
	
	
	
	

}
