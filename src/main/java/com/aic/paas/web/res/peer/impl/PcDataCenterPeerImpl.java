package com.aic.paas.web.res.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.web.res.bean.CPcDataCenter;
import com.aic.paas.web.res.bean.PcDataCenter;
import com.aic.paas.web.res.peer.PcDataCenterPeer;
import com.aic.paas.web.rest.PcDataCenterSvc;

public class PcDataCenterPeerImpl implements PcDataCenterPeer{
	
	@Autowired
	PcDataCenterSvc pcDataCenterSvc;


	public List<PcDataCenter> queryList(CPcDataCenter cdt, String orders) {
		return pcDataCenterSvc.queryList(cdt, orders);
	}

}
