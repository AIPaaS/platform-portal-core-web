package com.aic.paas.web.res.bean;

import java.io.Serializable;
import java.util.List;

import com.aic.paas.web.dep.bean.PcApp;

public class AppResInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 应用 **/
	private PcApp app;
	
	/** 应用对应资源 **/
	private List<PcAppRes> appResList;
	
	

	public PcApp getApp() {
		return app;
	}

	public void setApp(PcApp app) {
		this.app = app;
	}

	public List<PcAppRes> getAppResList() {
		return appResList;
	}

	public void setAppResList(List<PcAppRes> appResList) {
		this.appResList = appResList;
	}

	
	
	
	
	
}
