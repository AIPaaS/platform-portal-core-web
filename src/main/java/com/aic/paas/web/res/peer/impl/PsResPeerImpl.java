package com.aic.paas.web.res.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.web.res.bean.CPcCompRoom;
import com.aic.paas.web.res.bean.CPcDataCenter;
import com.aic.paas.web.res.bean.CPcNetZone;
import com.aic.paas.web.res.bean.CPcResCenter;
import com.aic.paas.web.res.bean.PcCompRoom;
import com.aic.paas.web.res.bean.PcDataCenter;
import com.aic.paas.web.res.bean.PcNetZone;
import com.aic.paas.web.res.bean.PcResCenter;
import com.aic.paas.web.res.peer.PsResPeer;
import com.aic.paas.web.rest.PcCompRoomSvc;
import com.aic.paas.web.rest.PcDataCenterSvc;
import com.aic.paas.web.rest.PcNetZoneSvc;
import com.aic.paas.web.rest.PcResCenterSvc;

public class PsResPeerImpl implements PsResPeer {
	
	
	@Autowired
	PcDataCenterSvc dataCenterSvc;
	
	
	@Autowired
	PcResCenterSvc resCenterSvc;
	
	
	@Autowired
	PcNetZoneSvc netZoneSvc;
	
	@Autowired
	PcCompRoomSvc compRoomSvc;
	
	

	@Override
	public List<PcDataCenter> queryDataCenterList(CPcDataCenter cdt, String orders) {
		return dataCenterSvc.queryList(cdt, orders);
	}
	
	

	@Override
	public List<PcResCenter> queryResCenterList(CPcResCenter cdt, String orders) {
		return resCenterSvc.queryList(cdt, orders);
	}

	
	
	@Override
	public List<PcNetZone> queryNetZoneList(CPcNetZone cdt, String orders) {
		return netZoneSvc.queryList(cdt, orders);
	}



	@Override
	public List<PcCompRoom> queryCompRoomList(CPcCompRoom cdt, String orders) {
		return compRoomSvc.queryList(cdt, orders);
	}
	
	
	

}
