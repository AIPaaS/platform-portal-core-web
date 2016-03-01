package com.aic.paas.web.dep.bean;

import java.io.Serializable;
import java.util.List;

public class AppImageDepends implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/** 依赖镜像 **/
	private List<PcAppImage> dependImages;
	
	
	/** 调用/依赖服务 **/
	private List<AppImageSvcInfo> dependSvcs;


	public List<PcAppImage> getDependImages() {
		return dependImages;
	}


	public void setDependImages(List<PcAppImage> dependImages) {
		this.dependImages = dependImages;
	}


	public List<AppImageSvcInfo> getDependSvcs() {
		return dependSvcs;
	}


	public void setDependSvcs(List<AppImageSvcInfo> dependSvcs) {
		this.dependSvcs = dependSvcs;
	}

	
	
	
	
}
