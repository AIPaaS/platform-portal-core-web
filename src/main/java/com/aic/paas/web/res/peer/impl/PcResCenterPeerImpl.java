package com.aic.paas.web.res.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.web.res.bean.CPcResCenter;
import com.aic.paas.web.res.bean.PcResCenter;
import com.aic.paas.web.res.peer.PcResCenterPeer;
import com.aic.paas.web.rest.PcResCenterSvc;

public class PcResCenterPeerImpl implements PcResCenterPeer{
	
	@Autowired
	PcResCenterSvc pcResCenterSvc;

	public List<PcResCenter> queryList(CPcResCenter cdt, String orders) {
		return pcResCenterSvc.queryList(cdt, orders);
	}

}
