package com.aic.paas.web.dep.bean;

import java.io.Serializable;
import java.util.List;

import com.aic.paas.web.res.bean.PcAppRes;

public class AppResInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/** 应用 **/
	private PcApp app;
	
	
	/** 应用版本 **/
	private List<PcAppVersion> appVnos;
	
	
	
	
	/**
	 * 应用占用资源总信息, 包含字段
	 * 		APP_ID 应用ID
	 * 		CPU_COUNT 应用占CPU总数
	 * 		MEM_SIZE 应用占内存总数
	 * 		DISK_SIZE 应用占硬盘总数
	 */
	private PcAppRes totalRes;
	
	
	
	
	/**
	 * 应用最近版本剩余资源, 包含字段
	 * 		CPU_COUNT 剩余CPU
	 * 		MEM_SIZE 剩余内存
	 * 		DISK_SIZE 剩余硬盘
	 */
	private PcAppRes residueRes;
	
	
	
	
	/**
	 * 查询应用最近版本下所有容器占用资源合计, 包含字段
	 * 		APP_ID 应用ID
	 * 		CPU_COUNT 应用占CPU总数
	 * 		MEM_SIZE 应用占内存总数
	 * 		DISK_SIZE 应用占硬盘总数
	 * 		INSTANCE_COUNT 应用起实例总数
	 * 		CUSTOM_1 应用包含容器数
	 */
	private PcAppImage imageTotal;
	
	
	
	
	/** 最近运行任务 **/
	private PcAppTask lastTask;
	
	

	

	public PcApp getApp() {
		return app;
	}



	public void setApp(PcApp app) {
		this.app = app;
	}



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



	public PcAppTask getLastTask() {
		return lastTask;
	}



	public void setLastTask(PcAppTask lastTask) {
		this.lastTask = lastTask;
	}



	public List<PcAppVersion> getAppVnos() {
		return appVnos;
	}



	public void setAppVnos(List<PcAppVersion> appVnos) {
		this.appVnos = appVnos;
	}


	
	
	
	
	
	

}
