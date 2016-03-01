package com.aic.paas.web.dep.bean;

import com.binary.framework.exception.ServiceException;


/**
 * 1=容器定义  2=开放服务  3=依赖服务  4=其它参数   9=完成
 * @author wanwb
 */
public enum AppImageSetup {

	
	/** 容器定义 **/
	CONTAINER(1),
	
	
	/** 开放服务 **/
	OPEN_SERVICE(2),
	
	
	/** 依赖服务 **/
	DEPEND_SERVICE(3),
	
	
	/** 其它参数 **/
	CONTAINER_PARAMS(4),
	
	
	/** 完成 **/
	FINISHED(9);
	
	
	
	private int v;
	
	
	private AppImageSetup(int v) {
		this.v = v;
	}
	
	
	
	public int getValue() {
		return this.v;
	}
	
	
	
	
	
	public static AppImageSetup valueOf(int v) {
		switch(v) {
			case 1: return CONTAINER;
			case 2: return OPEN_SERVICE;
			case 3: return DEPEND_SERVICE;
			case 4: return CONTAINER_PARAMS;
			case 9: return FINISHED;
			default: throw new ServiceException(" is wrong AppImageSetup.value '"+v+"'! ");
		}
	}
	
	
	
	
}








