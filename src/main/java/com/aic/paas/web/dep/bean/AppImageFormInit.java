package com.aic.paas.web.dep.bean;

import java.io.Serializable;
import java.util.List;

import com.aic.paas.frame.cross.bean.DropRecord;

public class AppImageFormInit implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 应用对象 **/
	private PcApp app;
	
	/** 镜像下拉列表 **/
	private List<DropRecord> imageDropList;
	
	/** 区域下拉列表 **/
	private List<DropRecord> netZoneDropList;

	
	
	public PcApp getApp() {
		return app;
	}

	public void setApp(PcApp app) {
		this.app = app;
	}

	public List<DropRecord> getImageDropList() {
		return imageDropList;
	}

	public void setImageDropList(List<DropRecord> imageDropList) {
		this.imageDropList = imageDropList;
	}

	public List<DropRecord> getNetZoneDropList() {
		return netZoneDropList;
	}

	public void setNetZoneDropList(List<DropRecord> netZoneDropList) {
		this.netZoneDropList = netZoneDropList;
	}
	
	
	
	
	
}
