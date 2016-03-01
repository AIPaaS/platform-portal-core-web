package com.aic.paas.web.res.bean;

import java.io.Serializable;

import com.aic.paas.web.dep.bean.PcApp;

public class PcAppResApplyInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	
	/** 申请单 **/
	private PcAppResApply apply;
	
	
	/** 所属应用 **/
	private PcApp app;


	public PcAppResApply getApply() {
		return apply;
	}


	public void setApply(PcAppResApply apply) {
		this.apply = apply;
	}


	public PcApp getApp() {
		return app;
	}


	public void setApp(PcApp app) {
		this.app = app;
	}
	
	
	
	
	
	
}
