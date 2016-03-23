package com.aic.paas.web.dep.peer.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.comm.util.SystemUtil;
import com.aic.paas.frame.cross.bean.CSysOp;
import com.aic.paas.frame.cross.bean.SysOp;
import com.aic.paas.frame.cross.integration.PaasWebSsoLoginUser;
import com.aic.paas.web.dep.bean.AppInfo;
import com.aic.paas.web.dep.bean.AppMgrInfo;
import com.aic.paas.web.dep.bean.AppResInfo;
import com.aic.paas.web.dep.bean.AppTimerInfo;
import com.aic.paas.web.dep.bean.AppZoneResInfo;
import com.aic.paas.web.dep.bean.CPcApp;
import com.aic.paas.web.dep.bean.CPcAppImage;
import com.aic.paas.web.dep.bean.PcApp;
import com.aic.paas.web.dep.bean.PcAppImage;
import com.aic.paas.web.dep.peer.PcAppPeer;
import com.aic.paas.web.integration.UserAuthentication;
import com.aic.paas.web.res.bean.PcAppRes;
import com.aic.paas.web.rest.PcAppImageSvc;
import com.aic.paas.web.rest.PcAppSvc;
import com.aic.paas.web.rest.SysOpSvc;
import com.binary.core.lang.ArrayUtils;
import com.binary.core.util.BinaryUtils;
import com.binary.jdbc.Page;

public class PcAppPeerImpl implements PcAppPeer {

	
	@Autowired
	PcAppSvc appSvc;
	
	@Autowired
	SysOpSvc sysOpSvc;
	
	@Autowired
	PcAppImageSvc appImageSvc;
	
	
	@Autowired
	UserAuthentication userAuth;
	
	
	
	private List<AppMgrInfo> fillMgrInfo(List<AppInfo> ls) {
		List<AppMgrInfo> infos = new ArrayList<AppMgrInfo>();
		if(ls!=null && ls.size()>0) {
			Set<Long> opids = new HashSet<Long>();
			for(int i=0; i<ls.size(); i++) {
				AppInfo pif = ls.get(i);
				AppMgrInfo info = new AppMgrInfo();
				info.setApp(pif.getApp());
				info.setMgrIds(pif.getMgrIds());
				info.setAppVnos(pif.getAppVnos());
				infos.add(info);
				
				Long[] mids = pif.getMgrIds();
				if(mids!=null && mids.length>0) {
					opids.addAll(ArrayUtils.toList(mids));
				}
			}
			
			if(opids.size() > 0) {
				CSysOp cdt = new CSysOp();
				cdt.setIds(opids.toArray(new Long[0]));
				List<SysOp> ops = sysOpSvc.queryList(cdt, null);
				
				if(ops.size() > 0) {
					Map<Long, SysOp> opmap = new HashMap<Long, SysOp>();
					for(int i=0; i<ops.size(); i++) {
						SysOp op = ops.get(i);
						opmap.put(op.getId(), op);
					}
					
					for(int i=0; i<infos.size(); i++) {
						AppMgrInfo info = infos.get(i);
						Long[] mgrIds = info.getMgrIds();
						if(mgrIds==null || mgrIds.length==0) continue ;
						
						List<SysOp> opls = new ArrayList<SysOp>();
						for(int j=0; j<mgrIds.length; j++) {
							SysOp op = opmap.get(mgrIds[j]);
							if(op != null) {
								opls.add(op);
							}
						}
						if(opls.size() > 0) {
							info.setMgrOps(opls);
						}
					}
				}
				
			}
		}
		
		return infos;
	}
	
	
	
	@Override
	public Page<AppMgrInfo> queryInfoPage(Integer pageNum, Integer pageSize, CPcApp cdt, String orders) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPcApp();
		cdt.setMntId(user.getMerchent().getId());
		Page<AppInfo> page = appSvc.queryInfoPage(pageNum, pageSize, cdt, orders);
		List<AppInfo> ls = page.getData();
		List<AppMgrInfo> infols = fillMgrInfo(ls);
		return new Page<AppMgrInfo>(page.getPageNum(), page.getPageSize(), page.getTotalRows(), page.getTotalPages(), infols);
	}
	
	

	@Override
	public List<AppMgrInfo> queryInfoList(CPcApp cdt, String orders) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPcApp();
		cdt.setMntId(user.getMerchent().getId());
		List<AppInfo> ls = appSvc.queryInfoList(cdt, null);
		return fillMgrInfo(ls);
	}
	
	
	

	@Override
	public AppMgrInfo queryInfoById(Long id) {
		BinaryUtils.checkEmpty(id, "id");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		CPcApp cdt = new CPcApp();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setId(id);
		List<AppInfo> ls = appSvc.queryInfoList(cdt, null);
		if(ls.size() == 0) return null;
		
		return fillMgrInfo(ls).get(0);
	}
	
	
	
	@Override
	public PcApp queryById(Long id) {
		BinaryUtils.checkEmpty(id, "id");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		CPcApp cdt = new CPcApp();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setId(id);
		List<PcApp> ls = appSvc.queryList(cdt, null);
		if(ls.size() == 0) return null;
		return ls.get(0);
	}
	
	
	

	@Override
	public Page<PcApp> queryMgrPage(Integer pageNum, Integer pageSize, CPcApp cdt, String orders) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPcApp();
		cdt.setMntId(user.getMerchent().getId());
		return appSvc.queryMgrPage(pageNum, pageSize, user.getId(), cdt, orders);
	}
	
	

	@Override
	public List<PcApp> queryMgrList(CPcApp cdt, String orders) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPcApp();
		cdt.setMntId(user.getMerchent().getId());
		return appSvc.queryMgrList(user.getId(), cdt, orders);
	}

	
	
	@Override
	public Page<AppResInfo> queryMgrResInfoPage(Integer pageNum, Integer pageSize, CPcApp cdt, String orders) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPcApp();
		cdt.setMntId(user.getMerchent().getId());
		Page<AppResInfo> page = appSvc.queryMgrResInfoPage(pageNum, pageSize, user.getId(), cdt, orders);
		return page;
	}
	
	
	@Override
	public Page<AppTimerInfo> queryMgrAppTimerInfoPage(Integer pageNum, Integer pageSize, CPcApp cdt, String orders) {
		Page<AppResInfo> page = queryMgrResInfoPage(pageNum, pageSize, cdt, orders);
		List<AppResInfo> ls = page.getData();
		
		Page<AppTimerInfo> timerinfo = new Page<AppTimerInfo>(page.getPageNum(), page.getPageSize(), page.getTotalRows(), page.getTotalPages(), new ArrayList<AppTimerInfo>());
		if(ls!=null && ls.size()>0) {
			List<AppTimerInfo> appls = new ArrayList<AppTimerInfo>();
			timerinfo.setData(appls);
			
			Long[] appIds = new Long[ls.size()];
			for(int i=0; i<ls.size(); i++) {
				AppResInfo info = ls.get(i);
				
				AppTimerInfo timer = new AppTimerInfo();
				timer.setApp(info.getApp());
				timer.setAppVnos(info.getAppVnos());
				timer.setImageTotal(info.getImageTotal());
				timer.setLastTask(info.getLastTask());
				timer.setResidueRes(info.getResidueRes());
				timer.setTotalRes(info.getTotalRes());
				appls.add(timer);
				
				appIds[i] = info.getApp().getId();
			}
			
			CPcAppImage imgcdt = new CPcAppImage();
			imgcdt.setAppIds(appIds);
			imgcdt.setSetupNum(9);
			List<PcAppImage> appImageList = appImageSvc.queryList(imgcdt, null);
			
			Map<Long, PcAppImage> map = BinaryUtils.toObjectMap(appImageList, "appId");
			for(int i=0; i<appls.size(); i++) {
				AppTimerInfo info = appls.get(i);
				Long appId = info.getApp().getId();
				info.setAppImage(map.get(appId));
			}
			
		}
		return timerinfo;
	}
	
	
	@Override
	public List<AppZoneResInfo> queryAppNetZoneResInfo(Long appId, Long appVnoId) {
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(appVnoId, "appVnoId");
		userAuth.verifyUserAppAuth(appId);
		return appSvc.queryAppNetZoneResInfo(appId, appVnoId, null);
	}
	
	
	@Override
	public PcAppRes queryAppResidueRes(Long appId, Long appVnoId, Long netZoneId) {
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(appVnoId, "appVnoId");
		BinaryUtils.checkEmpty(netZoneId, "netZoneId");
		userAuth.verifyUserAppAuth(appId);
		return appSvc.queryAppResidueRes(appId, appVnoId, netZoneId);
	}
	
	
	
	@Override
	public Long saveOrUpdate(PcApp record) {
		BinaryUtils.checkEmpty(record, "record");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		record.setMntId(user.getMerchent().getId());
		
		boolean isadd = record.getId() == null;
		if(isadd) {
			BinaryUtils.checkEmpty(record.getAppCode(), "record.appCode");
			BinaryUtils.checkEmpty(record.getAppName(), "record.appName");
			BinaryUtils.checkEmpty(record.getDataCenterId(), "record.dataCenterId");
			BinaryUtils.checkEmpty(record.getResCenterId(), "record.resCenterId");
			if(record.getStatus() == null) record.setStatus(1); 	//1=未部署  2=运行中  3=停止
		}else {
			if(record.getAppCode() != null) BinaryUtils.checkEmpty(record.getAppCode(), "record.appCode");
			if(record.getAppName() != null) BinaryUtils.checkEmpty(record.getAppName(), "record.appName");
			if(record.getDataCenterId() != null) BinaryUtils.checkEmpty(record.getDataCenterId(), "record.dataCenterId");
			if(record.getResCenterId() != null) BinaryUtils.checkEmpty(record.getResCenterId(), "record.resCenterId");
			userAuth.verifyUserAppAuth(record.getId());
		}
		
		return appSvc.saveOrUpdate(record);
	}
	
	
	

	@Override
	public int removeById(Long id) {
		BinaryUtils.checkEmpty(id, "id");
		userAuth.verifyUserAppAuth(id);
		return appSvc.removeById(id);
	}

	
	
	
	@Override
	public void setAppMgrs(Long appId, Long[] mgrIds) {
		BinaryUtils.checkEmpty(appId, "appId");
		userAuth.verifyUserAppAuth(appId);
		appSvc.setAppMgrs(appId, mgrIds);
	}



	@Override
	public int queryAppImageCount(Long appId) {
		
		return appImageSvc.getAppImageCount(appId);
	}
	
	
	
	

}
