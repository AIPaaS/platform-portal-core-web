package com.aic.paas.web.res.peer.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.comm.util.SystemUtil;
import com.aic.paas.frame.cross.integration.PaasWebSsoLoginUser;
import com.aic.paas.web.dep.bean.AppResInfo;
import com.aic.paas.web.dep.bean.CPcApp;
import com.aic.paas.web.dep.bean.PcApp;
import com.aic.paas.web.dep.peer.PcAppPeer;
import com.aic.paas.web.integration.UserAuthentication;
import com.aic.paas.web.res.bean.CPcAppRes;
import com.aic.paas.web.res.bean.CPcAppResApply;
import com.aic.paas.web.res.bean.CPcAppResFlow;
import com.aic.paas.web.res.bean.CPsMntRes;
import com.aic.paas.web.res.bean.PcAppRes;
import com.aic.paas.web.res.bean.PcAppResApply;
import com.aic.paas.web.res.bean.PcAppResApplyInfo;
import com.aic.paas.web.res.bean.PcAppResFlow;
import com.aic.paas.web.res.bean.PsMntRes;
import com.aic.paas.web.res.peer.PcAppResPeer;
import com.aic.paas.web.rest.PcAppResApplySvc;
import com.aic.paas.web.rest.PcAppResSvc;
import com.aic.paas.web.rest.PsMntResSvc;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.exception.ServiceException;
import com.binary.jdbc.Page;

public class PcAppResPeerImpl implements PcAppResPeer {

	
	@Autowired
	PcAppResSvc appResSvc;
	
	@Autowired
	PcAppResApplySvc appResApplySvc;
	
	
	@Autowired
	UserAuthentication userAuth;
	
	@Autowired
	PcAppPeer appPeer;
	
	@Autowired
	PsMntResSvc mntResSvc;
	
	
	
	private List<AppResInfo> fillAppResInfo(List<PcApp> ls) {
		List<AppResInfo> infos = new ArrayList<AppResInfo>();
		if(ls!=null && ls.size()>0) {
			Long[] appIds = new Long[ls.size()];
//			Map<Long, AppResInfo> infomap = new HashMap<Long, AppResInfo>();
			for(int i=0; i<ls.size(); i++) {
				PcApp app = ls.get(i);
				AppResInfo info = new AppResInfo();
				info.setApp(app);
				infos.add(info);
				
				appIds[i] = app.getId();
//				infomap.put(appIds[i], info);
			}
			
			CPcAppRes cdt = new CPcAppRes();
			cdt.setAppIds(appIds);
			List<PcAppRes> resls = appResSvc.queryResList(cdt, null);
			Map<Long, List<PcAppRes>> resmap = BinaryUtils.toObjectGroupMap(resls, "appId");
			
			for(int i=0; i<infos.size(); i++) {
				AppResInfo info = infos.get(i);
//				info.setAppResList(resmap.get(info.getApp().getId()));
			}
		}
		return infos;
	}
	
	
	
	
	@Override
	public Page<AppResInfo> queryAppResInfoPage(Integer pageNum, Integer pageSize, CPcApp cdt, String orders) {
		Page<PcApp> page = appPeer.queryMgrPage(pageNum, pageSize, cdt, orders);
		List<PcApp> list = page.getData();
		List<AppResInfo> infols = fillAppResInfo(list);
		return new Page<AppResInfo>(page.getPageNum(), page.getPageSize(), page.getTotalRows(), page.getTotalPages(), infols);
	}
	
	
	
	@Override
	public List<AppResInfo> queryAppResInfoList(CPcApp cdt, String orders) {
		List<PcApp> list = appPeer.queryMgrList(cdt, orders);
		return fillAppResInfo(list);
	}
	
	
	
	@Override
	public AppResInfo queryAppResInfoById(Long appId) {
		BinaryUtils.checkEmpty(appId, "appId");
		CPcApp cdt = new CPcApp();
		cdt.setId(appId);
		List<AppResInfo> ls = queryAppResInfoList(cdt, null);
		return ls.size()>0 ? ls.get(0) : null;
	}
	
	
	
	@Override
	public List<PcAppRes> getAppResList(Long appId, CPcAppRes cdt, String orders) {
		BinaryUtils.checkEmpty(appId, "appId");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPcAppRes();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setAppId(appId);
		return appResSvc.queryResList(cdt, orders);
	}
	
	

	@Override
	public Page<PcAppResFlow> queryResFlowPage(Integer pageNum, Integer pageSize, Long resId, CPcAppResFlow cdt, String orders) {
		BinaryUtils.checkEmpty(resId, "resId");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPcAppResFlow();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setResId(resId);
		return appResSvc.queryFlowPage(pageNum, pageSize, cdt, orders);
	}
	
	
	

	@Override
	public Page<PcAppResApply> queryApplyPage(Integer pageNum, Integer pageSize, CPcAppResApply cdt, String orders) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPcAppResApply();
		cdt.setMntId(user.getMerchent().getId());
		return appResApplySvc.queryPage(pageNum, pageSize, cdt, orders);
	}

	
	
	
	@Override
	public PcAppResApply queryApplyById(Long applyId) {
		BinaryUtils.checkEmpty(applyId, "applyId");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		CPcAppResApply cdt = new CPcAppResApply();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setId(applyId);
		List<PcAppResApply> ls = appResApplySvc.queryList(cdt, null);
		return ls.size()>0 ? ls.get(0) : null;
	}
	
	
	@Override
	public Page<PcAppResApplyInfo> queryApplyInfoPage(Integer pageNum, Integer pageSize, CPcAppResApply cdt, String orders) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPcAppResApply();
		cdt.setMntId(user.getMerchent().getId());
		return appResApplySvc.queryInfoPage(pageNum, pageSize, cdt, orders);
	}

	
	
	@Override
	public PcAppResApplyInfo queryApplyInfoById(Long applyId) {
		BinaryUtils.checkEmpty(applyId, "applyId");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		CPcAppResApply cdt = new CPcAppResApply();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setId(applyId);
		List<PcAppResApplyInfo> ls = appResApplySvc.queryInfoList(cdt, null);
		return ls.size()>0 ? ls.get(0) : null;
	}
	
	
	

	@Override
	public Long saveOrUpdateApply(PcAppResApply record) {
		BinaryUtils.checkEmpty(record, "record");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		record.setMntId(user.getMerchent().getId());
		
		Long id = record.getId();
		boolean add = id == null;
		if(add) {
			BinaryUtils.checkEmpty(record.getAppId(), "record.appId");
			BinaryUtils.checkEmpty(record.getDataCenterId(), "record.dataCenterId");
			BinaryUtils.checkEmpty(record.getResCenterId(), "record.resCenterId");
			BinaryUtils.checkEmpty(record.getNetZoneId(), "record.netZoonId");
			BinaryUtils.checkEmpty(record.getCpuCount(), "record.cpuCount");
			BinaryUtils.checkEmpty(record.getMemSize(), "record.memSize");
			BinaryUtils.checkEmpty(record.getDiskSize(), "record.diskSize");
		}else {
			if(record.getAppId()!=null) BinaryUtils.checkEmpty(record.getAppId(), "record.appId");
			if(record.getDataCenterId()!=null) BinaryUtils.checkEmpty(record.getDataCenterId(), "record.dataCenterId");
			if(record.getResCenterId()!=null) BinaryUtils.checkEmpty(record.getResCenterId(), "record.resCenterId");
			if(record.getNetZoneId()!=null) BinaryUtils.checkEmpty(record.getNetZoneId(), "record.netZoonId");
			if(record.getCpuCount()!=null) BinaryUtils.checkEmpty(record.getCpuCount(), "record.cpuCount");
			if(record.getMemSize()!=null) BinaryUtils.checkEmpty(record.getMemSize(), "record.memSize");
			if(record.getDiskSize()!=null) BinaryUtils.checkEmpty(record.getDiskSize(), "record.diskSize");
			record.setCode(null);
		}
		
		return appResApplySvc.saveOrUpdate(record);
	}

	
	
	
	@Override
	public void cannelApply(Long applyId) {
		BinaryUtils.checkEmpty(applyId, "applyId");
		userAuth.verifyAppResApply(applyId);
		appResApplySvc.cannelApply(applyId);
	}
	
	
	
	
	@Override
	public void checkApply(Long applyId, Boolean pass, String checkDesc) {
		BinaryUtils.checkEmpty(applyId, "id");
		BinaryUtils.checkEmpty(pass, "pass");
		BinaryUtils.checkEmpty(checkDesc, "checkDesc");
		
		//如果审批通过先验证一下资源中心资源是否够
		if(Boolean.TRUE.equals(pass)) {
			PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
			PcAppResApply apply = appResApplySvc.queryById(applyId);
			if(apply == null) throw new ServiceException(" not found res-apply by id '"+applyId+"'! ");
			
			CPsMntRes rescdt = new CPsMntRes();
			rescdt.setMntId(user.getMerchent().getId());
			rescdt.setNetZoneId(apply.getNetZoneId());
			List<PsMntRes> resls = mntResSvc.queryResList(rescdt, null);
			if(resls.size() == 0) throw new ServiceException(" not found mnt-res by net-zone-id '"+apply.getNetZoneId()+"'! ");
			PsMntRes res = resls.get(0);
			
			long appCpuCount = apply.getCpuCount();
			long appMemSize = apply.getMemSize();
			long appDiskSize = apply.getDiskSize();
			
			long resCpuCount = res.getCpuCount();
			long resMemSize = res.getMemSize();
			long resDiskSize = res.getDiskSize();
			
			if(appCpuCount > resCpuCount) throw new ServiceException(" The current mnt-resource 'CPU' is not enough! ");
			if(appMemSize > resMemSize) throw new ServiceException(" The current mnt-resource 'memory' is not enough! ");
			if(appDiskSize > resDiskSize) throw new ServiceException(" The current mnt-resource 'storage' is not enough! ");
		}
		
		appResApplySvc.checkApply(applyId, pass, checkDesc);
	}

	
	
	

}
