package com.aic.paas.web.dep.peer.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.comm.util.SystemUtil;
import com.aic.paas.frame.cross.integration.PaasWebSsoLoginUser;
import com.aic.paas.web.dep.bean.AppImageCallServiceRlt;
import com.aic.paas.web.dep.bean.AppImageDepends;
import com.aic.paas.web.dep.bean.AppImageSettings;
import com.aic.paas.web.dep.bean.AppImageSvcInfo;
import com.aic.paas.web.dep.bean.CPcApp;
import com.aic.paas.web.dep.bean.CPcAppAccess;
import com.aic.paas.web.dep.bean.CPcAppImage;
import com.aic.paas.web.dep.bean.CPcImage;
import com.aic.paas.web.dep.bean.CPcService;
import com.aic.paas.web.dep.bean.PcApp;
import com.aic.paas.web.dep.bean.PcAppAccess;
import com.aic.paas.web.dep.bean.PcAppImage;
import com.aic.paas.web.dep.bean.PcAppImageInfo;
import com.aic.paas.web.dep.bean.PcImage;
import com.aic.paas.web.dep.bean.PcKvPair;
import com.aic.paas.web.dep.bean.PcService;
import com.aic.paas.web.dep.bean.PcServiceInfo;
import com.aic.paas.web.dep.peer.PcAppImagePeer;
import com.aic.paas.web.integration.UserAuthentication;
import com.aic.paas.web.rest.PcAppAccessSvc;
import com.aic.paas.web.rest.PcAppImageSvc;
import com.aic.paas.web.rest.PcAppSvc;
import com.aic.paas.web.rest.PcImageSvc;
import com.aic.paas.web.rest.PcServiceSvc;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.exception.ServiceException;
import com.binary.jdbc.Page;

public class PcAppImagePeerImpl implements PcAppImagePeer {
	
	
	@Autowired
	PcAppImageSvc appImageSvc;
	
	
	@Autowired
	PcAppSvc appSvc;
	
	@Autowired
	PcServiceSvc serviceSvc;
	
	@Autowired
	PcImageSvc imageSvc;
	
	@Autowired
	UserAuthentication userAuth;
	
	@Autowired
	PcAppAccessSvc appAccessSvc;
	

	@Override
	public Page<PcAppImage> queryAppImagePage(Integer pageNum, Integer pageSize, Long appId, Long appVnoId, CPcAppImage cdt, String orders) {
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(appVnoId, "appVnoId");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPcAppImage();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setAppId(appId);
		cdt.setAppVnoId(appVnoId);
		return appImageSvc.queryPage(pageNum, pageSize, cdt, orders);
	}
	
	
	
	@Override
	public List<PcAppImage> queryAppImageList(Long appId, Long appVnoId, CPcAppImage cdt, String orders) {
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(appVnoId, "appVnoId");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPcAppImage();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setAppId(appId);
		cdt.setAppVnoId(appVnoId);
		return appImageSvc.queryList(cdt, orders);
	}

	
	
	
	@Override
	public PcAppImage queryAppImageById(Long appImageId) {
		BinaryUtils.checkEmpty(appImageId, "appImageId");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		CPcAppImage cdt = new CPcAppImage();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setId(appImageId);
		List<PcAppImage> ls = appImageSvc.queryList(cdt, null);
		return ls.size()>0 ? ls.get(0) : null;
	}
	
	
	
	
	private List<PcAppImageInfo> fillInfo(List<PcAppImage> ls) {
		List<PcAppImageInfo> infos = new ArrayList<PcAppImageInfo>();
		if(ls!=null && ls.size()>0) {
			Set<Long> imageIds = new HashSet<Long>();
			
			for(int i=0; i<ls.size(); i++) {
				PcAppImage p = ls.get(i);
				PcAppImageInfo info = new PcAppImageInfo();
				info.setAppImage(p);
				infos.add(info);
				
				imageIds.add(p.getImageId());
			}
			
			CPcImage imagecdt = new CPcImage();
			imagecdt.setIds(imageIds.toArray(new Long[0]));
			List<PcImage> imgls = imageSvc.queryImageList(imagecdt, null);
			Map<Long, PcImage> imgmap = BinaryUtils.toObjectMap(imgls, "id");
			
			for(int i=0; i<infos.size(); i++) {
				PcAppImageInfo info = infos.get(i);
				Long imageId = info.getAppImage().getImageId();
				info.setImage(imgmap.get(imageId));
			}
		}
		
		return infos;
	}

	
	
	
	@Override
	public Page<PcAppImageInfo> queryAppImageInfoPage(Integer pageNum, Integer pageSize, Long appId, Long appVnoId, CPcAppImage cdt, String orders) {
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(appVnoId, "appVnoId");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPcAppImage();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setAppId(appId);
		cdt.setAppVnoId(appVnoId);
		
		Page<PcAppImage> page = appImageSvc.queryPage(pageNum, pageSize, cdt, orders);
		List<PcAppImage> ls = page.getData();
		List<PcAppImageInfo> infols = fillInfo(ls);
		return new Page<PcAppImageInfo>(page.getPageNum(), page.getPageSize(), page.getTotalRows(), page.getTotalPages(), infols);
	}
	
	
	
	
	@Override
	public List<PcAppImageInfo> queryAppImageInfoList(Long appId, Long appVnoId, CPcAppImage cdt, String orders) {
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(appVnoId, "appVnoId");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		if(cdt == null) cdt = new CPcAppImage();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setAppId(appId);
		cdt.setAppVnoId(appVnoId);
		
		List<PcAppImage> ls = appImageSvc.queryList(cdt, orders);
		return fillInfo(ls);
	}

	
	
	
	@Override
	public PcAppImageInfo queryAppImageInfoById(Long appImageId) {
		BinaryUtils.checkEmpty(appImageId, "appImageId");
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		CPcAppImage cdt = new CPcAppImage();
		cdt.setMntId(user.getMerchent().getId());
		cdt.setId(appImageId);
		
		List<PcAppImage> ls = appImageSvc.queryList(cdt, null);
		if(ls.size() > 0) {
			return fillInfo(ls).get(0);
		}
		return null;
	}
	
	

	
	@Override
	public Long saveAppImage(PcAppImage record) {
		BinaryUtils.checkEmpty(record, "record");
		BinaryUtils.checkEmpty(record.getAppId(), "record.appId");
		BinaryUtils.checkEmpty(record.getAppVnoId(), "record.appVnoId");
		BinaryUtils.checkEmpty(record.getContainerName(), "record.containerName");
		
		Long appId = record.getAppId();
		userAuth.verifyUserAppAuth(appId);
		PcApp app = appSvc.queryById(appId);
		if(app == null) {
			throw new ServiceException(" not found app by id '"+appId+"'! ");
		}
		
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		String cn = record.getContainerName().trim();
		record.setContainerName(cn);
		record.setContainerFullName(user.getMerchent().getMntCode()+"-"+app.getAppCode()+"-"+cn);		//租户代码-应用代码-容器名
		record.setDataCenterId(app.getDataCenterId());
		record.setResCenterId(app.getResCenterId());
		record.setMntId(user.getMerchent().getId());
		
		boolean isadd = record.getId() == null;
		if(isadd) {
			BinaryUtils.checkEmpty(record.getImageId(), "record.imageId");
			BinaryUtils.checkEmpty(record.getNetZoneId(), "record.netZoneId");
			BinaryUtils.checkEmpty(record.getCpuCount(), "record.cpuCount");
			BinaryUtils.checkEmpty(record.getMemSize(), "record.memSize");
			BinaryUtils.checkEmpty(record.getDiskSize(), "record.diskSize");
			BinaryUtils.checkEmpty(record.getInstanceCount(), "record.instanceCount");
			BinaryUtils.checkEmpty(record.getIsSupportFlex(), "record.isSupportFlex");
			if(record.getIsSupportFlex().intValue() == 1) {
//				BinaryUtils.checkEmpty(record.getFlexThreshold(), "record.flexThreshold");
				BinaryUtils.checkEmpty(record.getMaxInstanceCount(), "record.maxInstanceCount");
				BinaryUtils.checkEmpty(record.getMinInstanceCount(), "record.minInstanceCount");
			}
//			BinaryUtils.checkEmpty(record.getLogMpPath(), "record.logMpPath");
//			BinaryUtils.checkEmpty(record.getDataMpPath(), "record.dataMpPath");
			BinaryUtils.checkEmpty(record.getIsUniform(), "record.isUniform");
		}else {
			if(record.getImageId() != null) BinaryUtils.checkEmpty(record.getImageId(), "record.imageId");
			if(record.getNetZoneId() != null) BinaryUtils.checkEmpty(record.getNetZoneId(), "record.netZoneId");
			if(record.getCpuCount() != null) BinaryUtils.checkEmpty(record.getCpuCount(), "record.cpuCount");
			if(record.getMemSize() != null) BinaryUtils.checkEmpty(record.getMemSize(), "record.memSize");
			if(record.getDiskSize() != null) BinaryUtils.checkEmpty(record.getDiskSize(), "record.diskSize");
			if(record.getInstanceCount() != null) BinaryUtils.checkEmpty(record.getInstanceCount(), "record.instanceCount");
			if(record.getIsSupportFlex() != null) BinaryUtils.checkEmpty(record.getIsSupportFlex(), "record.isSupportFlex");
//			if(record.getFlexThreshold() != null) BinaryUtils.checkEmpty(record.getFlexThreshold(), "record.flexThreshold");
			if(record.getMaxInstanceCount() != null) BinaryUtils.checkEmpty(record.getMaxInstanceCount(), "record.maxInstanceCount");
			if(record.getMinInstanceCount() != null) BinaryUtils.checkEmpty(record.getMinInstanceCount(), "record.minInstanceCount");
//			if(record.getLogMpPath() != null) BinaryUtils.checkEmpty(record.getLogMpPath(), "record.logMpPath");
//			if(record.getDataMpPath() != null) BinaryUtils.checkEmpty(record.getDataMpPath(), "record.dataMpPath");
			if(record.getIsUniform() != null) BinaryUtils.checkEmpty(record.getIsUniform(), "record.isUniform");
		}

		//liwx3 add 该容器作为应用的访问入口
		if(record.getCustom1()==1){
			saveOrUpdateAppAccess(user,app,record,cn,isadd);
		}
		
		return appImageSvc.saveOrUpdate(record);
	}
	
	
	
	
	private void saveOrUpdateAppAccess(PaasWebSsoLoginUser user, PcApp app,
			PcAppImage record, String cn, boolean isadd) {
		PcAppAccess access = new PcAppAccess();
		access.setAppId(record.getAppId());
		access.setAccessCode(user.getMerchent().getMntCode()+"-"+app.getAppCode()+"-"+cn);
		access.setAppImageId(record.getId());
		access.setMntId(user.getMerchent().getId());
		access.setDataCenterId(app.getDataCenterId());
		access.setResCenterId(app.getResCenterId());
		access.setProtocol(record.getCustom2().intValue());
		if(isadd){
			appAccessSvc.saveOrUpdate(access);
		}else{
			CPcAppAccess cdt = new CPcAppAccess();
			cdt.setAppId(record.getAppId());
			cdt.setAppImageId(record.getId());
			List<PcAppAccess> pcaa = appAccessSvc.queryList(cdt, null);	
			if(pcaa!=null&&pcaa.size()>0){
				PcAppAccess appaccess = pcaa.get(0);
				appaccess.setAccessCode(user.getMerchent().getMntCode()+"-"+app.getAppCode()+"-"+cn);
				appaccess.setProtocol(record.getCustom2().intValue());
				appAccessSvc.saveOrUpdate(appaccess);
			}else{
				appAccessSvc.saveOrUpdate(access);
			}
		}
		
	}


	private void removeAppAccess(PcAppImage record){
		CPcAppAccess cdt = new CPcAppAccess();
		cdt.setAppId(record.getAppId());
		cdt.setAppImageId(record.getId());
		List<PcAppAccess> pcaa = appAccessSvc.queryList(cdt, null);	
		Long id = pcaa.get(0).getId();
		appAccessSvc.removeById(id);
	}

	@Override
	public Integer removeAppImage(Long appImageId) {
		PcAppImage appImg = queryAppImageById(appImageId);
		if(appImg != null) {
			//liwx3 add 删除容器时删除对应的应用访问入口
			removeAppAccess(appImg);
			return appImageSvc.removeById(appImageId);
		}
		return 0;
	}



	@Override
	public AppImageSvcInfo getAppImageOpenService(Long appImageId) {
		BinaryUtils.checkEmpty(appImageId, "appImageId");
		userAuth.verifyAppImageAuth(appImageId);
		return appImageSvc.getAppImageOpenService(appImageId);
	}

	

	@Override
	public Long saveAppImageOpenService(Integer isOpen, Long appImageId, PcService svc, List<PcKvPair> params) {
		BinaryUtils.checkEmpty(appImageId, "appImageId");
		userAuth.verifyAppImageAuth(appImageId);
		return appImageSvc.saveAppImageOpenService(isOpen, appImageId, svc, params);
	}

	
	
	@Override
	public List<PcServiceInfo> querySelectServiceInfoList(Long appImageId) {
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
		PcApp app = ls.get(0);
		
		//1=平台服务
		CPcService svccdt = new CPcService();
		svccdt.setSvcType(1);
		svccdt.setDataCenterId(app.getDataCenterId());
		svccdt.setResCenterId(app.getResCenterId());
		svccdt.setStatus(1);
		List<PcServiceInfo> ls1 = serviceSvc.queryInfoList(svccdt, " SVC_CODE ");
		
		//2=外部服务 
		svccdt = new CPcService();
		svccdt.setSvcType(2);
		svccdt.setDataCenterId(app.getDataCenterId());
		svccdt.setResCenterId(app.getResCenterId());
		svccdt.setMntId(user.getMerchent().getId());
		svccdt.setStatus(1);
		List<PcServiceInfo> ls2 = serviceSvc.queryInfoList(svccdt, " SVC_CODE ");
		
		//3=镜像服务
		svccdt = new CPcService();
		svccdt.setSvcType(3);
		svccdt.setMntId(user.getMerchent().getId());
		svccdt.setAppId(appId);
		svccdt.setStatus(1);
		List<PcServiceInfo> ls3 = serviceSvc.queryInfoList(svccdt, " SVC_CODE ");
		for(int i=0; i<ls3.size(); i++) {
			PcServiceInfo svc = ls3.get(i);
			Long imgid = svc.getSvc().getAppImageId();
			if(appImageId.equals(imgid)) {
				ls3.remove(i);
				break;
			}
		}
		
		if(ls2.size() > 0) ls1.addAll(ls2);
		if(ls3.size() > 0) ls1.addAll(ls3);
		
		return ls1;
	}
	
	
	


	@Override
	public AppImageDepends getAppImageDepends(Long appImageId) {
		BinaryUtils.checkEmpty(appImageId, "appImageId");
		userAuth.verifyAppImageAuth(appImageId);
		List<PcAppImage> dependImages = appImageSvc.getAppImageDependImages(appImageId);
		List<AppImageSvcInfo> dependSvcs = appImageSvc.getAppImageCallService(appImageId);
		
		AppImageDepends depends = new AppImageDepends();
		depends.setDependImages(dependImages);
		depends.setDependSvcs(dependSvcs);
		
		return depends;
	}





	@Override
	public void saveAppImageDepends(Long appImageId, List<AppImageCallServiceRlt> rlts, Long[] dependAppImageIds) {
		BinaryUtils.checkEmpty(appImageId, "appImageId");
		userAuth.verifyAppImageAuth(appImageId);
		appImageSvc.saveAppImageDependImages(appImageId, dependAppImageIds);
		appImageSvc.saveAppImageCallService(appImageId, rlts);
	}



	@Override
	public List<PcKvPair> getAppImageParams(Long appImageId) {
		BinaryUtils.checkEmpty(appImageId, "appImageId");
		userAuth.verifyAppImageAuth(appImageId);
		return appImageSvc.getAppImageParams(appImageId);
	}



	@Override
	public void saveAppImageParams(Long appImageId, List<PcKvPair> params) {
		BinaryUtils.checkEmpty(appImageId, "appImageId");
		userAuth.verifyAppImageAuth(appImageId);
		appImageSvc.saveAppImageParams(appImageId, params);
	}



	@Override
	public AppImageSettings getAppImageSettings(Long appImageId) {
		BinaryUtils.checkEmpty(appImageId, "appImageId");
		userAuth.verifyAppImageAuth(appImageId);
		AppImageSettings settings = appImageSvc.getAppImageSettings(appImageId);
		if(settings != null) {
			Long imageId = settings.getAppImage().getImageId();
			if(imageId != null) {
				PcImage image = imageSvc.queryImageById(imageId);
				settings.setImage(image);
			}
		}
		return settings;
	}



	@Override
	public void finishAppImageSettings(Long appImageId) {
		BinaryUtils.checkEmpty(appImageId, "appImageId");
		userAuth.verifyAppImageAuth(appImageId);
		appImageSvc.finishAppImageSettings(appImageId);
	}
	
	
	
	
	

}
