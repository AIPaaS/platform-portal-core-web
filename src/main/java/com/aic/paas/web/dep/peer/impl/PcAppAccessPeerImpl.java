package com.aic.paas.web.dep.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.comm.util.SystemUtil;
import com.aic.paas.frame.cross.integration.PaasWebSsoLoginUser;
import com.aic.paas.web.dep.bean.CPcAppAccess;
import com.aic.paas.web.dep.bean.PcAppAccess;
import com.aic.paas.web.dep.bean.PcAppAccessInfo;
import com.aic.paas.web.dep.peer.PcAppAccessPeer;
import com.aic.paas.web.rest.PcAppAccessSvc;
import com.binary.core.util.BinaryUtils;
import com.binary.jdbc.Page;

public class PcAppAccessPeerImpl implements PcAppAccessPeer {
	
	@Autowired
	PcAppAccessSvc appAccessSvc;

	@Override
	public Page<PcAppAccess> queryPage(Integer pageNum, Integer pageSize, CPcAppAccess cdt, String orders) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		cdt.setMntId(user.getMerchent().getId());
		return appAccessSvc.queryPage(pageNum, pageSize, cdt, orders);
	}

	@Override
	public List<PcAppAccess> queryList(CPcAppAccess cdt, String orders) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		cdt.setMntId(user.getMerchent().getId());
		return appAccessSvc.queryList(cdt, orders);
	}

	@Override
	public PcAppAccess queryById(Long id) {
		CPcAppAccess cdt = new CPcAppAccess();
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		cdt.setMntId(user.getMerchent().getId());
		List<PcAppAccess> list = appAccessSvc.queryList(cdt, null);
		return list.size()>0 ? list.get(0) : null;
	}

	@Override
	public Long saveOrUpdate(PcAppAccess record) {
		BinaryUtils.checkEmpty(record, "record");
			
		boolean isadd = record.getId() == null;
		if(isadd) {
			BinaryUtils.checkEmpty(record.getAppId(), "record.appId");
			BinaryUtils.checkEmpty(record.getAccessCode(), "record.accessCode");
			BinaryUtils.checkEmpty(record.getAppImageId(), "record.appImageId");
			BinaryUtils.checkEmpty(record.getProtocol(), "record.protocol");
			BinaryUtils.checkEmpty(record.getAccessUrl(), "record.accessUrl");
			BinaryUtils.checkEmpty(record.getMntId(), "record.mntId");
			if(record.getStatus() == null) record.setStatus(1); 
			BinaryUtils.checkEmpty(record.getRemark(), "record.remark");
			BinaryUtils.checkEmpty(record.getDataStatus(), "record.dataStatus");
			BinaryUtils.checkEmpty(record.getCreator(), "record.creator");
			BinaryUtils.checkEmpty(record.getCreateTime(), "record.createTime");
			BinaryUtils.checkEmpty(record.getModifier(), "record.modifier");
			BinaryUtils.checkEmpty(record.getModifyTime(), "record.modifyTime");
			BinaryUtils.checkEmpty(record.getProtocol(), "record.Protocol");
		}else {
			if(record.getAppId() != null) BinaryUtils.checkEmpty(record.getAppId(), "record.appId");
			if(record.getAccessCode() != null) BinaryUtils.checkEmpty(record.getAccessCode(), "record.accessCode");
			if(record.getAppImageId() != null) BinaryUtils.checkEmpty(record.getAppImageId(), "record.appImageId");
			if(record.getProtocol() != null) BinaryUtils.checkEmpty(record.getProtocol(), "record.protocol");
			if(record.getAccessUrl() != null) BinaryUtils.checkEmpty(record.getAccessUrl(), "record.accessUrl");
			if(record.getMntId() != null) BinaryUtils.checkEmpty(record.getMntId(), "record.mntId");
			if(record.getRemark() != null) BinaryUtils.checkEmpty(record.getRemark(), "record.remark");
			if(record.getDataStatus() != null) BinaryUtils.checkEmpty(record.getDataStatus(), "record.dataStatus");
			if(record.getCreator()!= null) BinaryUtils.checkEmpty(record.getCreator(), "record.creator");
			if(record.getCreateTime() != null) BinaryUtils.checkEmpty(record.getCreateTime(), "record.createTime");
			if(record.getModifier() != null) BinaryUtils.checkEmpty(record.getModifier(), "record.modifier");
			if(record.getModifyTime() != null) BinaryUtils.checkEmpty(record.getModifyTime(), "record.modifyTime");
			if(record.getProtocol() != null) BinaryUtils.checkEmpty(record.getProtocol(), "record.Protocol");
		}
		return appAccessSvc.saveOrUpdate(record);
	}

	@Override
	public int removeById(Long id) {
		return appAccessSvc.removeById(id);
	}

	@Override
	public List<PcAppAccessInfo> queryInfoList(CPcAppAccess cdt, String orders) {
		if(cdt == null) cdt = new CPcAppAccess();
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		cdt.setMntId(user.getMerchent().getId());
		return appAccessSvc.queryInfoList(cdt, orders);
	}

	
	
	@Override
	public PcAppAccessInfo queryInfoById(Long id) {
		BinaryUtils.checkEmpty(id, "id");
		CPcAppAccess cdt = new CPcAppAccess();
		cdt.setId(id);
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		cdt.setMntId(user.getMerchent().getId());
		List<PcAppAccessInfo> list= appAccessSvc.queryInfoList(cdt, null);
		return list.size()>0 ? list.get(0) : null;
	}

	@Override
	public Page<PcAppAccessInfo> queryPage4Info(Integer pageNum, Integer pageSize, CPcAppAccess cdt, String orders) {
		if(cdt == null) cdt = new CPcAppAccess();
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		cdt.setMntId(user.getMerchent().getId());
		return appAccessSvc.queryPage4Info(pageNum, pageSize, cdt, orders);
	}
	

}
