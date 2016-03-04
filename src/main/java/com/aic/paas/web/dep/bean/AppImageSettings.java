package com.aic.paas.web.dep.bean;

import java.io.Serializable;
import java.util.List;

public class AppImageSettings implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/** 容器定义 **/
	private PcAppImage appImage;
	
	
	/** 镜像 **/
	private PcImage image;
	
	
	/** 开放服务信息 **/
	private AppImageSvcInfo openSvc;
	
	
	/** 内部依赖镜像 **/
	private List<PcAppImage> dependImages;
	
	
	/** 调用服务 **/
	private List<AppImageSvcInfo> callServices;
	
	
	/** 其他参数 **/
	private List<PcKvPair> params;
	
	
	


	public PcAppImage getAppImage() {
		return appImage;
	}


	public void setAppImage(PcAppImage appImage) {
		this.appImage = appImage;
	}


	public AppImageSvcInfo getOpenSvc() {
		return openSvc;
	}


	public void setOpenSvc(AppImageSvcInfo openSvc) {
		this.openSvc = openSvc;
	}


	public List<PcAppImage> getDependImages() {
		return dependImages;
	}


	public void setDependImages(List<PcAppImage> dependImages) {
		this.dependImages = dependImages;
	}


	public List<AppImageSvcInfo> getCallServices() {
		return callServices;
	}


	public void setCallServices(List<AppImageSvcInfo> callServices) {
		this.callServices = callServices;
	}


	public List<PcKvPair> getParams() {
		return params;
	}


	public void setParams(List<PcKvPair> params) {
		this.params = params;
	}


	public PcImage getImage() {
		return image;
	}


	public void setImage(PcImage image) {
		this.image = image;
	}
	
	
	
	
	
	

}
