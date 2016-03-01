package com.aic.paas.web.dep.bean;

import java.io.Serializable;
import java.util.List;

import com.aic.paas.frame.cross.bean.SysOp;

public class AppMgrInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** 产品 **/
	private PcApp app;
	
	/** 产品管理员ID **/
	private Long[] mgrIds;
	
	/** 产品管理员对象 **/
	private List<SysOp> mgrOps;
	
	/** 应用版本 **/
	private List<PcAppVersion> appVnos;

	


	public List<SysOp> getMgrOps() {
		return mgrOps;
	}



	public void setMgrOps(List<SysOp> mgrOps) {
		this.mgrOps = mgrOps;
	}



	public PcApp getApp() {
		return app;
	}



	public void setApp(PcApp app) {
		this.app = app;
	}



	public Long[] getMgrIds() {
		return mgrIds;
	}



	public void setMgrIds(Long[] mgrIds) {
		this.mgrIds = mgrIds;
	}



	public List<PcAppVersion> getAppVnos() {
		return appVnos;
	}



	public void setAppVnos(List<PcAppVersion> appVnos) {
		this.appVnos = appVnos;
	}



	
	
	
	
	
}
