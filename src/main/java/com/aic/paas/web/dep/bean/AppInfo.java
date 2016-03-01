package com.aic.paas.web.dep.bean;

import java.io.Serializable;
import java.util.List;

public class AppInfo implements Serializable {
	private static final long serialVersionUID = 1L;



	/** 应用 **/
	private PcApp app;
	
	

	/** 应用版本 **/
	private List<PcAppVersion> appVnos;
	
	
	
	/** 应用管理员 **/
	private Long[] mgrIds;



	public PcApp getApp() {
		return app;
	}



	public void setApp(PcApp app) {
		this.app = app;
	}



	public Long[] getMgrIds() {
		return mgrIds;
	}



	public void setMgrIds(Long[] mgrIds) {
		this.mgrIds = mgrIds;
	}



	public List<PcAppVersion> getAppVnos() {
		return appVnos;
	}



	public void setAppVnos(List<PcAppVersion> appVnos) {
		this.appVnos = appVnos;
	}
	
	
	
	
	
	
	
}
