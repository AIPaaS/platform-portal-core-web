package com.aic.paas.web.integration.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.comm.util.SystemUtil;
import com.aic.paas.frame.cross.integration.PaasWebSsoLoginUser;
import com.aic.paas.web.dep.bean.CPcApp;
import com.aic.paas.web.dep.bean.CPcImage;
import com.aic.paas.web.dep.bean.PcApp;
import com.aic.paas.web.dep.bean.PcAppImage;
import com.aic.paas.web.dep.bean.PcImage;
import com.aic.paas.web.integration.UserAuthentication;
import com.aic.paas.web.res.bean.CPcAppResApply;
import com.aic.paas.web.res.bean.CPsMntResApply;
import com.aic.paas.web.res.bean.PcAppResApply;
import com.aic.paas.web.res.bean.PsMntResApply;
import com.aic.paas.web.rest.PcAppImageSvc;
import com.aic.paas.web.rest.PcAppResApplySvc;
import com.aic.paas.web.rest.PcAppSvc;
import com.aic.paas.web.rest.PcImageSvc;
import com.aic.paas.web.rest.PsMntResApplySvc;
import com.binary.framework.exception.ServiceException;


/**
 * 用户认证
 * @author wanwb
 */
public class UserAuthenticationPeerImpl implements UserAuthentication {

	
	@Autowired
	PcAppSvc appSvc;
	
	
	@Autowired
	PsMntResApplySvc mntResApplySvc;
	
	
	@Autowired
	PcAppResApplySvc appResApplySvc;
	
	@Autowired
	PcImageSvc imageSvc;
	
	@Autowired
	PcAppImageSvc appImageSvc;
	
	
	
	
	
	@Override
	public void verifyImageAuth(Long imageId) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		CPcImage imgcdt = new CPcImage();
		imgcdt.setMntId(user.getMerchent().getId());
		imgcdt.setId(imageId);
		List<PcImage> ls = imageSvc.queryImageList(imgcdt, null);
		if(ls.size() == 0) {
			throw new ServiceException(" You don't have permission to operate image '"+imageId+"' or image is not exists! ");
		}
	}
	
	
	
	@Override
	public void verifyUserAppAuth(Long appId) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		CPcApp cdt = new CPcApp();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setId(appId);
		List<PcApp> ls = appSvc.queryList(cdt, null);
		if(ls.size() == 0) {
			throw new ServiceException(" You don't have permission to operate app '"+appId+"' or app is not exists! ");
		}
	}
	
	
	
	@Override
	public void verifyMntResApply(Long applyId) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		CPsMntResApply cdt = new CPsMntResApply();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setId(applyId);
		List<PsMntResApply> ls = mntResApplySvc.queryList(cdt, null);
		if(ls.size() == 0) {
			throw new ServiceException(" You don't have permission to operate resApply '"+applyId+"' or resApply is not exists! ");
		}
	}
	
	
	
	@Override
	public void verifyAppResApply(Long applyId) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		CPcAppResApply cdt = new CPcAppResApply();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setId(applyId);
		List<PcAppResApply> ls = appResApplySvc.queryList(cdt, null);
		if(ls.size() == 0) {
			throw new ServiceException(" You don't have permission to operate resApply '"+applyId+"' or resApply is not exists! ");
		}
	}
	
	
	
	
	@Override
	public void verifyAppImageAuth(Long appImageId) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		
		PcAppImage appImage = appImageSvc.queryById(appImageId);
		if(appImage == null) {
			throw new ServiceException(" not found appImage by id '"+appImageId+"'! ");
		}
		
		Long appId = appImage.getAppId();
		CPcApp cdt = new CPcApp();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setId(appId);
		List<PcApp> ls = appSvc.queryList(cdt, null);
		if(ls.size() == 0) {
			throw new ServiceException(" You don't have permission to operate appImage '"+appImageId+"' or app is not exists! ");
		}
	}


	
	
}
