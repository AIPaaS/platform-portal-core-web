package com.aic.paas.web.dep.bean;

import java.io.Serializable;
import java.util.List;

public class PcAppImageInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/** 应用镜像 **/
	private PcAppImage appImage;
	
	
	/**
	 * 镜像
	 */
	private PcImage image;


	/** 参数 **/
	private List<PcKvPair> params;
	
	public PcAppImage getAppImage() {
		return appImage;
	}



	public void setAppImage(PcAppImage appImage) {
		this.appImage = appImage;
	}



	public PcImage getImage() {
		return image;
	}



	public void setImage(PcImage image) {
		this.image = image;
	}



	public List<PcKvPair> getParams() {
		return params;
	}



	public void setParams(List<PcKvPair> params) {
		this.params = params;
	}
	
	
	
	

}
