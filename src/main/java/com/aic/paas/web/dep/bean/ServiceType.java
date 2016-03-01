package com.aic.paas.web.dep.bean;

import com.binary.framework.exception.ServiceException;


/**
 * 服务类型
 * @author wanwb
 * 1=平台服务    2=外部服务    3=镜像服务
 */
public enum ServiceType {

	
	PLATFORM(1),
	
	
	
	EXTERNAL(2),
	
	
	APP_IMAGE(3);
	
	
	
	private int v;
	
	
	
	private ServiceType(int v) {
		this.v = v;
	}
	
	
	
	public int getValue() {
		return this.v;
	}
	
	
	
	public static ServiceType valueOf(int v) {
		switch(v) {
			case 1: return PLATFORM;
			case 2: return EXTERNAL;
			case 3: return APP_IMAGE;
			default: throw new ServiceException(" is wrong ServiceType value '"+v+"'! ");
		}
	} 
	
	
}
