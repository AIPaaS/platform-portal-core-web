package com.aic.paas.web.dep.bean;

import java.io.Serializable;
import java.util.List;

public class AppImageSvcInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	
	/** 镜像服务依赖 **/
	private PcAppImgSvc appImgSvc;
	
	
	/** 镜像开放服务 **/
	private PcService svc;
	
	
	/** 开放服务参数 **/
	private List<PcKvPair> params;

	

	public PcService getSvc() {
		return svc;
	}


	public void setSvc(PcService svc) {
		this.svc = svc;
	}


	public List<PcKvPair> getParams() {
		return params;
	}


	public void setParams(List<PcKvPair> params) {
		this.params = params;
	}


	public PcAppImgSvc getAppImgSvc() {
		return appImgSvc;
	}


	public void setAppImgSvc(PcAppImgSvc appImgSvc) {
		this.appImgSvc = appImgSvc;
	}


	
	
	
	
	
	
	
}
