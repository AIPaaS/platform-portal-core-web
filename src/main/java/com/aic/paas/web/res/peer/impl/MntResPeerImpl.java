package com.aic.paas.web.res.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.comm.util.SystemUtil;
import com.aic.paas.frame.cross.integration.PaasWebSsoLoginUser;
import com.aic.paas.web.dep.bean.AppResInfo;
import com.aic.paas.web.dep.bean.CPcApp;
import com.aic.paas.web.integration.UserAuthentication;
import com.aic.paas.web.res.bean.CPsMntRes;
import com.aic.paas.web.res.bean.CPsMntResApply;
import com.aic.paas.web.res.bean.CPsMntResFlow;
import com.aic.paas.web.res.bean.PsMntRes;
import com.aic.paas.web.res.bean.PsMntResApply;
import com.aic.paas.web.res.bean.PsMntResFlow;
import com.aic.paas.web.res.peer.MntResPeer;
import com.aic.paas.web.rest.PcAppSvc;
import com.aic.paas.web.rest.PsMntResApplySvc;
import com.aic.paas.web.rest.PsMntResSvc;
import com.binary.core.util.BinaryUtils;
import com.binary.jdbc.Page;

public class MntResPeerImpl implements MntResPeer {

	
	@Autowired
	PsMntResSvc mntResSvc;
	
	@Autowired
	PsMntResApplySvc mntResApplySvc;
	
	@Autowired
	PcAppSvc appSvc;
	
	
	@Autowired
	UserAuthentication userAuth;
	
	
	
	@Override
	public List<PsMntRes> getMntResList(CPsMntRes cdt, String orders) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPsMntRes();
		cdt.setMntId(user.getMerchent().getId());
		return mntResSvc.queryResList(cdt, orders);
	}
	
	
	
	
	@Override
	public Page<PsMntResFlow> queryResFlowPage(Integer pageNum, Integer pageSize, Long resId, CPsMntResFlow cdt, String orders) {
		BinaryUtils.checkEmpty(resId, "resId");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPsMntResFlow();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setResId(resId);
		return mntResSvc.queryFlowPage(pageNum, pageSize, cdt, orders);
	}
	
	
	

	@Override
	public Page<PsMntResApply> queryApplyPage(Integer pageNum, Integer pageSize, CPsMntResApply cdt, String orders) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPsMntResApply();
		cdt.setMntId(user.getMerchent().getId());
		return mntResApplySvc.queryPage(pageNum, pageSize, cdt, orders);
	}
	
	
	

	@Override
	public PsMntResApply queryApplyById(Long applyId) {
		BinaryUtils.checkEmpty(applyId, "applyId");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		CPsMntResApply cdt = new CPsMntResApply();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setId(applyId);
		List<PsMntResApply> ls = mntResApplySvc.queryList(cdt, null);
		return ls.size()>0 ? ls.get(0) : null;
	}

	
	
	@Override
	public Long saveOrUpdateApply(PsMntResApply record) {
		BinaryUtils.checkEmpty(record, "record");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		record.setMntId(user.getMerchent().getId());
		
		if(record.getId() == null) {
			BinaryUtils.checkEmpty(record.getDataCenterId(), "record.dataCenterId");
			BinaryUtils.checkEmpty(record.getResCenterId(), "record.resCenterId");
			BinaryUtils.checkEmpty(record.getNetZoneId(), "record.netZoneId");
			BinaryUtils.checkEmpty(record.getCpuCount(), "record.cpuCount");
			BinaryUtils.checkEmpty(record.getMemSize(), "record.memSize");
			BinaryUtils.checkEmpty(record.getDiskSize(), "record.diskSize");
		}else {
			if(record.getDataCenterId()!=null) BinaryUtils.checkEmpty(record.getDataCenterId(), "record.dataCenterId");
			if(record.getResCenterId()!=null) BinaryUtils.checkEmpty(record.getResCenterId(), "record.resCenterId");
			if(record.getNetZoneId()!=null) BinaryUtils.checkEmpty(record.getNetZoneId(), "record.netZoneId");
			if(record.getCpuCount()!=null) BinaryUtils.checkEmpty(record.getCpuCount(), "record.cpuCount");
			if(record.getMemSize()!=null) BinaryUtils.checkEmpty(record.getMemSize(), "record.memSize");
			if(record.getDiskSize()!=null) BinaryUtils.checkEmpty(record.getDiskSize(), "record.diskSize");
		}
		return mntResApplySvc.saveOrUpdate(record);
	}

	
	
	
	@Override
	public void cannelApply(Long applyId) {
		BinaryUtils.checkEmpty(applyId, "applyId");
		userAuth.verifyMntResApply(applyId);
		mntResApplySvc.cannelApply(applyId);
	}
	
	
	
	@Override
	public List<AppResInfo> queryUseStateList() {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		CPcApp cdt = new CPcApp();
		cdt.setMntId(user.getMerchent().getId());
		List<AppResInfo> ls = appSvc.queryResInfoList(cdt, " DATA_CENTER_ID, RES_CENTER_ID, APP_CODE ");
		return ls;
	}
	
}
