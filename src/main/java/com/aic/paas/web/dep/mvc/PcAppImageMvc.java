package com.aic.paas.web.dep.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.frame.cross.bean.DropRecord;
import com.aic.paas.frame.util.ComponentUtil;
import com.aic.paas.web.dep.bean.AppImageCallServiceRlt;
import com.aic.paas.web.dep.bean.AppImageDepends;
import com.aic.paas.web.dep.bean.AppImageFormInit;
import com.aic.paas.web.dep.bean.AppImageSettings;
import com.aic.paas.web.dep.bean.AppImageSvcInfo;
import com.aic.paas.web.dep.bean.CPcApp;
import com.aic.paas.web.dep.bean.CPcAppImage;
import com.aic.paas.web.dep.bean.CPcImage;
import com.aic.paas.web.dep.bean.PcApp;
import com.aic.paas.web.dep.bean.PcAppImage;
import com.aic.paas.web.dep.bean.PcAppImageInfo;
import com.aic.paas.web.dep.bean.PcImage;
import com.aic.paas.web.dep.bean.PcKvPair;
import com.aic.paas.web.dep.bean.PcService;
import com.aic.paas.web.dep.bean.PcServiceInfo;
import com.aic.paas.web.dep.peer.PcAppImagePeer;
import com.aic.paas.web.dep.peer.PcAppPeer;
import com.aic.paas.web.dep.peer.PcImagePeer;
import com.aic.paas.web.dep.peer.PcServicePeer;
import com.aic.paas.web.res.bean.CPcNetZone;
import com.aic.paas.web.res.bean.PcAppRes;
import com.aic.paas.web.res.bean.PcComputerTag;
import com.aic.paas.web.res.bean.PcNetZone;
import com.aic.paas.web.res.peer.PcComputerPeer;
import com.aic.paas.web.res.peer.PsResPeer;
import com.binary.core.http.HttpClient;
import com.binary.core.lang.Conver;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;
import com.binary.json.JSON;

@Controller
@RequestMapping("/dep/appimage")
public class PcAppImageMvc {
	
	@Autowired
	PcAppImagePeer appImagePeer;
	
	@Autowired
	PcAppPeer appPeer;
	
	@Autowired
	PcImagePeer imagePeer;
	
	@Autowired
	PsResPeer resPeer;
	
	@Autowired
	PcComputerPeer computerPeer;
	
	@Autowired
	PcServicePeer servicePeer;
	
	
	@Value("${project.task.root}")
	String taskRoot;
	
	@RequestMapping("/getAppImageFormInit")
	public void getAppImageFormInit(HttpServletRequest request,HttpServletResponse response, Long appId) {
		BinaryUtils.checkEmpty(appId, "appId");
		
		AppImageFormInit init = new AppImageFormInit();
		
		CPcApp appcdt = new CPcApp();
		appcdt.setId(appId);
		List<PcApp> apps = appPeer.queryMgrList(appcdt, null);
		if(apps.size() > 0) {
			PcApp app = apps.get(0);
			
			CPcImage imgcdt = new CPcImage();
			imgcdt.setResCenterId(app.getResCenterId());
			List<PcImage> imageList = imagePeer.queryImageList(imgcdt, " IMAGE_FULL_NAME ");
			
			CPcNetZone zonecdt = new CPcNetZone();
			zonecdt.setResCenterId(app.getResCenterId());
			zonecdt.setStatus(1);
			List<PcNetZone> zonels = resPeer.queryNetZoneList(zonecdt, " ZONE_CODE ");
			
			List<DropRecord> imageDropList = ComponentUtil.toDropList(imageList, "id", "imageFullName", true, true);
			List<DropRecord> netZoneDropList = ComponentUtil.toDropList(zonels, "id", "zoneName", true, true);
			
			init.setApp(app);
			init.setImageDropList(imageDropList);
			init.setNetZoneDropList(netZoneDropList);
			ControllerUtils.returnJson(request, response, init);
		}else {
			ControllerUtils.returnJson(request, response, null);
		}
	}
	
	
	
	@RequestMapping("/getNetZoneChangeData")
	public void getNetZoneChangeData(HttpServletRequest request,HttpServletResponse response, Long appId, Long appVnoId, Long netZoneId) {
		List<PcComputerTag> list = computerPeer.queryComputerTagsByNetZoneId(netZoneId);
		PcAppRes appResidueRes = appPeer.queryAppResidueRes(appId, appVnoId, netZoneId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("targs", list);
		map.put("res", appResidueRes);
		
		ControllerUtils.returnJson(request, response, map);
	}
	
	
	
	@RequestMapping("/queryComputerTagsByNetZoneId")
	public void queryComputerTagsByNetZoneId(HttpServletRequest request,HttpServletResponse response, Long netZoneId){
		List<PcComputerTag> list = computerPeer.queryComputerTagsByNetZoneId(netZoneId);
		ControllerUtils.returnJson(request, response, list);
	}
	
	
	@RequestMapping("/queryAppImageInfoList")
	public void queryAppImageInfoList(HttpServletRequest request,HttpServletResponse response, Long appId, Long appVnoId, CPcAppImage cdt, String orders){
		List<PcAppImageInfo> list = appImagePeer.queryAppImageInfoList(appId, appVnoId, cdt, orders);
		ControllerUtils.returnJson(request, response, list);
	}
	
	@RequestMapping("/queryAppImageInfoById")
	public void queryAppImageInfoById(HttpServletRequest request,HttpServletResponse response, Long appImageId){
		PcAppImageInfo p = appImagePeer.queryAppImageInfoById(appImageId);
		ControllerUtils.returnJson(request, response, p);
	}
	
	@RequestMapping("/queryAppImageById")
	public void queryAppImageById(HttpServletRequest request,HttpServletResponse response, Long appImageId){
		PcAppImage p = appImagePeer.queryAppImageById(appImageId);
		ControllerUtils.returnJson(request, response, p);
	}
	
	@RequestMapping("/saveAppImage")
	public void saveAppImage(HttpServletRequest request,HttpServletResponse response, PcAppImage record){
		//record.setImageId(1l);
		if(record.getImageId()==null){
			record.setImageId(0L);
		}
		Long id = appImagePeer.saveAppImage(record);
		ControllerUtils.returnJson(request, response, id);
	} 
	
	@RequestMapping("/removeAppImage")
	public void removeAppImage(HttpServletRequest request,HttpServletResponse response, Long appImageId){
		int c = appImagePeer.removeAppImage(appImageId);
		ControllerUtils.returnJson(request, response, c);
	} 
	
	
	@RequestMapping("/getAppImageOpenService")
	public void getAppImageOpenService(HttpServletRequest request,HttpServletResponse response, Long appImageId){
		AppImageSvcInfo info = appImagePeer.getAppImageOpenService(appImageId);
		ControllerUtils.returnJson(request, response, info);
	}
	
	@RequestMapping("/saveAppImageOpenService")
	public void saveAppImageOpenService(HttpServletRequest request,HttpServletResponse response, Integer isOpen, Long appImageId,
			Long isAccess, PcService svc, String strParams){
		List<PcKvPair> params = new ArrayList<PcKvPair>();
		if(!BinaryUtils.isEmpty(strParams)){
			params = JSON.toList(strParams, PcKvPair.class);
		}
		Long id = appImagePeer.saveAppImageOpenService(isOpen, appImageId, svc, params);
		appImagePeer.updateAppImage(isOpen, appImageId, isAccess, svc, params);
		ControllerUtils.returnJson(request, response, id);
	}
	
	@RequestMapping("/getAppImageParams")
	public void getAppImageParams(HttpServletRequest request,HttpServletResponse response, Long appImageId){
		List<PcKvPair> list = appImagePeer.getAppImageParams(appImageId);
		ControllerUtils.returnJson(request, response, list);
	}
	
	
	@RequestMapping("/saveAppImageParams")
	public void saveAppImageParams(HttpServletRequest request,HttpServletResponse response, Long appImageId,  String strParams){
		List<PcKvPair> params = new ArrayList<PcKvPair>();
		if(!BinaryUtils.isEmpty(strParams)){
			params = JSON.toList(strParams, PcKvPair.class);
		}
		try{
		appImagePeer.saveAppImageParams(appImageId, params);
		ControllerUtils.returnJson(request, response, null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
	
	
	@RequestMapping("/queryAppImageDependsSelectData")
	public void queryAppImageDependsSelectData(HttpServletRequest request,HttpServletResponse response, Long appId, Long appVnoId, Long appImageId) {
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(appVnoId, "appVnoId");
		BinaryUtils.checkEmpty(appImageId, "appImageId");
		
//		List<PcAppImage> imgls = appImagePeer.queryAppImageList(appId, appVnoId, null, " CONTAINER_NAME ");
		List<PcAppImageInfo> imgls = appImagePeer.queryAppImageParamList(appId, appVnoId, null, " CONTAINER_NAME ");
		for(int i=0; i<imgls.size(); i++) {
			PcAppImageInfo img = imgls.get(i);
			if(img.getAppImage().getId().equals(appImageId)) {
				imgls.remove(i);
				break;
			}
		}
		
		List<PcServiceInfo> svcs = appImagePeer.querySelectServiceInfoList(appImageId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("imgs", imgls);
		map.put("svcs", svcs);
		
		ControllerUtils.returnJson(request, response, map);
	}
	
	
	
	
	
	@RequestMapping("/getAppImageDepends")
	public void getAppImageDepends(HttpServletRequest request,HttpServletResponse response, Long appImageId) {
		AppImageDepends depends = appImagePeer.getAppImageDepends(appImageId);
		ControllerUtils.returnJson(request, response, depends);
	}
	
	
	@RequestMapping("/saveAppImageDepends")
	public void saveAppImageDepends(HttpServletRequest request,HttpServletResponse response, Long appImageId, String jsonRlts, String imgrlts) {
		List<AppImageCallServiceRlt> rlts = null;
		List<AppImageCallServiceRlt> imgrls = null;
//		Long[] dependAppImageIds = null;
		if(!BinaryUtils.isEmpty(jsonRlts)) {
			rlts = JSON.toList(jsonRlts, AppImageCallServiceRlt.class);
		}
		if(rlts == null){
			rlts = new ArrayList<AppImageCallServiceRlt>();
		}
		if(!BinaryUtils.isEmpty(imgrlts)) {
			imgrls = JSON.toList(imgrlts, AppImageCallServiceRlt.class);
		}
		if(imgrls == null){
			imgrls = new ArrayList<AppImageCallServiceRlt>();
		}
		
//		if(!BinaryUtils.isEmpty(strDependAppImageIds)) {
//			dependAppImageIds = Conver.to(strDependAppImageIds.split(","), Long.class);
//		}
		
		
		appImagePeer.saveAppImageDepends(appImageId, rlts, imgrls);
		ControllerUtils.returnJson(request, response, true);
	}
	
	
	
	
	@RequestMapping("/getAppImageSettings")
	public void getAppImageSettings(HttpServletRequest request,HttpServletResponse response, Long appImageId) {
		AppImageSettings settings = appImagePeer.getAppImageSettings(appImageId);
		ControllerUtils.returnJson(request, response, settings);
	}
	
	
	
	@RequestMapping("/finishAppImageSettings")
	public void finishAppImageSettings(HttpServletRequest request,HttpServletResponse response, Long appImageId) {
		appImagePeer.finishAppImageSettings(appImageId);
		ControllerUtils.returnJson(request, response, true);
	}
	
	

}
