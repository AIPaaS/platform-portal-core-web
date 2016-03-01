package com.aic.paas.web.dep.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.comm.util.SystemUtil;
import com.aic.paas.frame.cross.integration.PaasWebSsoLoginUser;
import com.aic.paas.web.dep.bean.CPcImage;
import com.aic.paas.web.dep.bean.PcImage;
import com.aic.paas.web.dep.peer.PcImagePeer;
import com.aic.paas.web.integration.UserAuthentication;
import com.aic.paas.web.rest.PcImageSvc;
import com.binary.core.util.BinaryUtils;

public class PcImagePeerImpl implements PcImagePeer {
	
	
	@Autowired
	PcImageSvc imageSvc;
	
	@Autowired
	UserAuthentication userAuth;

	
	
	@Override
	public List<PcImage> queryImageList(CPcImage cdt, String orders) {
		if(cdt == null) cdt = new CPcImage();
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		cdt.setMntId(user.getMerchent().getId());
		return imageSvc.queryImageList(cdt, orders);
	}

	
	@Override
	public PcImage queryImageById(Long imageId) {
		BinaryUtils.checkEmpty(imageId, "imageId");
		CPcImage cdt = new CPcImage();
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setId(imageId);
		List<PcImage> ls = imageSvc.queryImageList(cdt, null);
		return ls.size()>0 ? ls.get(0) : null;
	}

	












}
