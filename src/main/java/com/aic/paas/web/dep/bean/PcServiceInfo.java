package com.aic.paas.web.dep.bean;

import java.io.Serializable;
import java.util.List;

public class PcServiceInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/** 服务 **/
	private PcService svc;
	
	
	/** 服务参数 **/
	private List<PcKvPair> params;

	/**提供者 应用名称*/
	private String provider;
	/**引用者 容器ID （调用该服务的容器） */
	private List<Long> consumerIds;
	/**引用者 容器名称*/
	private List<String> consumers;
	/**引用者 容器名称  描述*/
	private String consumerDes;

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


	public String getProvider() {
		return provider;
	}


	public void setProvider(String provider) {
		this.provider = provider;
	}


	public List<Long> getConsumerIds() {
		return consumerIds;
	}


	public void setConsumerIds(List<Long> consumerIds) {
		this.consumerIds = consumerIds;
	}


	public List<String> getConsumers() {
		return consumers;
	}


	public void setConsumers(List<String> consumers) {
		this.consumers = consumers;
	}


	public String getConsumerDes() {
		return consumerDes;
	}


	public void setConsumerDes(String consumerDes) {
		this.consumerDes = consumerDes;
	}
	
	
	
	
	

}
