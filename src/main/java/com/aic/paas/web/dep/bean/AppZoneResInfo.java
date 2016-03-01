package com.aic.paas.web.dep.bean;

import java.io.Serializable;
import java.util.List;

import com.aic.paas.web.res.bean.PcAppRes;

public class AppZoneResInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/** 应用在指定网络区域下占用资源 **/
	private PcAppRes totalRes;
	
	
	/**
	 * 应用在指定网络区域下剩余资源, 包含字段：
	 * 		CPU_COUNT 剩余CPU
	 * 		MEM_SIZE 剩余内存
	 * 		DISK_SIZE 剩余硬盘
	 */
	private PcAppRes residueRes;
	
	
	
	/**
	 * 应用下所有容器在指定网络区域下占用资源合计, 包含字段：
	 * 		APP_ID 应用ID
	 * 		CPU_COUNT 应用占CPU总数
	 * 		MEM_SIZE 应用占内存总数
	 * 		DISK_SIZE 应用占硬盘总数
	 * 		INSTANCE_COUNT 应用起实例总数
	 * 		CUSTOM_1 应用包含容器数
	 */
	private PcAppImage imageTotal;
	
	
	
	
	/**
	 * 容器在各网络区域中占用资源明细
	 */
	private List<PcAppImage> imageList;




	

	public PcAppRes getTotalRes() {
		return totalRes;
	}




	public void setTotalRes(PcAppRes totalRes) {
		this.totalRes = totalRes;
	}




	public PcAppRes getResidueRes() {
		return residueRes;
	}




	public void setResidueRes(PcAppRes residueRes) {
		this.residueRes = residueRes;
	}




	public PcAppImage getImageTotal() {
		return imageTotal;
	}




	public void setImageTotal(PcAppImage imageTotal) {
		this.imageTotal = imageTotal;
	}




	public List<PcAppImage> getImageList() {
		return imageList;
	}




	public void setImageList(List<PcAppImage> imageList) {
		this.imageList = imageList;
	}
	
	
	
	
	
	
	

}
