package com.aic.paas.web.dep.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.web.dep.bean.CPcAppDepHistory;
import com.aic.paas.web.dep.bean.CPcAppDepInstance;
import com.aic.paas.web.dep.bean.PcAppDepHistory;
import com.aic.paas.web.dep.bean.PcAppDepInstance;
import com.aic.paas.web.dep.peer.PcAppMonitorPeer;
import com.aic.paas.web.rest.PcAppDeploySvc;
import com.binary.core.util.BinaryUtils;
import com.binary.jdbc.Page;

public class PcAppMonitorPeerImpl implements PcAppMonitorPeer {
	
	@Autowired
	PcAppDeploySvc svc;
	
	@Override
	public Page<PcAppDepHistory> queryDepHistoryPage(Integer pageNum,Integer pageSize, CPcAppDepHistory cdt, String orders) {
		return svc.queryDepHistoryPage(pageNum, pageSize, cdt, orders);
	}

	@Override
	public List<PcAppDepInstance> queryDepInstance(Long depHistoryId,CPcAppDepInstance cdt, String orders) {
		return svc.queryDepInstance(depHistoryId, cdt, orders);
	}

	@Override
	public Page<PcAppDepInstance> queryDepInstancePage(Integer pageNum,Integer pageSize, Long depHistoryId, CPcAppDepInstance cdt,String orders) {
		BinaryUtils.checkEmpty(depHistoryId, "depHistoryId");
		if(cdt == null) cdt = new CPcAppDepInstance();
		cdt.setAppDepHistoryId(depHistoryId);
		return svc.queryDepInstancePage(pageNum, pageSize, cdt, orders);
	}

	
}
