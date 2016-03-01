package com.aic.paas.web.res.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.web.res.bean.CPcImageRepository;
import com.aic.paas.web.res.bean.PcImageRepository;
import com.aic.paas.web.res.peer.PcImageRepositoryPeer;
import com.aic.paas.web.rest.PcImageRepositorySvc;

public class PcImageRepositoryPeerImpl implements PcImageRepositoryPeer {
	
	
	@Autowired
	PcImageRepositorySvc imageRespSvc;
	

	@Override
	public List<PcImageRepository> queryList(CPcImageRepository cdt, String orders) {
		return imageRespSvc.queryList(cdt, orders);
	}
	

}
