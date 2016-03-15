package com.aic.paas.web.dep.bean;

import java.io.Serializable;

public class PcAppAccessInfo  implements Serializable {
	/**
	 * [PC_APP_ACCESS]信息表
	 */
	private static final long serialVersionUID = 135324625775L;
	/** 应用入口 **/
	private PcAppAccess access;
	
	/**	镜像--容器名 **/
	private String imgName;
	/**	应用名 **/
	private String appName;


	public PcAppAccess getAccess() {
		return access;
	}


	public void setAccess(PcAppAccess access) {
		this.access = access;
	}


	public String getImgName() {
		return imgName;
	}


	public void setImgName(String imgName) {
		this.imgName = imgName;
	}


	public String getAppName() {
		return appName;
	}


	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	
}
