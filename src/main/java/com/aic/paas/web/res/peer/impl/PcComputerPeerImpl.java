package com.aic.paas.web.res.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.web.res.bean.PcComputerTag;
import com.aic.paas.web.res.peer.PcComputerPeer;
import com.aic.paas.web.rest.PcComputerSvc;
import com.binary.core.util.BinaryUtils;

public class PcComputerPeerImpl implements PcComputerPeer {
	
	
	@Autowired
	PcComputerSvc computerSvc;
	

	
	@Override
	public List<PcComputerTag> queryComputerTagsByNetZoneId(Long netZoneId) {
		BinaryUtils.checkEmpty(netZoneId, "netZoneId");
		return computerSvc.queryComputerTagsByNetZoneId(netZoneId);
	}
	
	
	
	
}
