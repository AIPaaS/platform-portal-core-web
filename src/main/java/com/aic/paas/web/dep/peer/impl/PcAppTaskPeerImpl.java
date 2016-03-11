package com.aic.paas.web.dep.peer.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.web.dep.bean.CPcAppTask;
import com.aic.paas.web.dep.peer.PcAppTaskPeer;
import com.aic.paas.web.dep.peer.bean.PcAppTaskInfo;
import com.aic.paas.web.rest.PcAppTaskSvc;
import com.binary.jdbc.Page;

public class PcAppTaskPeerImpl implements PcAppTaskPeer {

	@Autowired
	PcAppTaskSvc pcAppTaskSvc;

	@Override
	public Page<PcAppTaskInfo> queryInfoPage(Integer pageNum, Integer pageSize, CPcAppTask cdt, String orders) {
		return pcAppTaskSvc.queryPcAppTaskInfo(pageNum, pageSize, cdt, orders);
	}

}
