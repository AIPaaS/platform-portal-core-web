package com.aic.paas.web.dep.bean;

import java.io.Serializable;
import java.util.List;

public class AppImageCallServiceRlt implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/** 服务ID **/
	private Long svcId;
	
	/** 服务类型  1=平台服务    2=外部服务    3=镜像服务 **/
	private Integer svcType;
	
	
	/** 调用类型 		1=调用    2=依赖**/
	private Integer callType;
	
	
	/** 服务调用参数 **/
	private List<PcKvPair> params;

	
	public Long getSvcId() {
		return svcId;
	}


	public void setSvcId(Long svcId) {
		this.svcId = svcId;
	}


	public Integer getCallType() {
		return callType;
	}


	public void setCallType(Integer callType) {
		this.callType = callType;
	}


	public List<PcKvPair> getParams() {
		return params;
	}


	public void setParams(List<PcKvPair> params) {
		this.params = params;
	}


	public Integer getSvcType() {
		return svcType;
	}


	public void setSvcType(Integer svcType) {
		this.svcType = svcType;
	}
	
	
	
	

}
