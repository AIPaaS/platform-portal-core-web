package com.aic.paas.web.dep.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.comm.util.SystemUtil;
import com.aic.paas.frame.cross.integration.PaasWebSsoLoginUser;
import com.aic.paas.web.dep.bean.CPcAppAccess;
import com.aic.paas.web.dep.bean.CPcAppImage;
import com.aic.paas.web.dep.bean.PcAppAccess;
import com.aic.paas.web.dep.bean.PcAppAccessInfo;
import com.aic.paas.web.dep.bean.PcAppImageInfo;
import com.aic.paas.web.dep.peer.PcAppAccessPeer;
import com.aic.paas.web.dep.peer.PcAppImagePeer;
import com.binary.core.http.HttpClient;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;
import com.binary.json.JSON;

@Controller
@RequestMapping("/app/access")
public class PcAppAccessMvc {
	
	
	@Autowired
	PcAppAccessPeer appAccessPeer;
	
	@Autowired
	PcAppImagePeer appImagePeer;
	
	@Value("${project.task.root}")
	String taskRoot;
	
	//分页查
	@RequestMapping("/queryPage")
	public void queryPage(HttpServletRequest request,HttpServletResponse response, Integer pageNum, Integer pageSize, CPcAppAccess cdt, String orders) {
		Page<PcAppAccessInfo> page = appAccessPeer.queryPage4Info(pageNum, pageSize, cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	//根据ID查
	@RequestMapping("/queryById")
	public void queryById(HttpServletRequest request,HttpServletResponse response, Long id) {
		PcAppAccessInfo accessInfo = appAccessPeer.queryInfoById(id);
		ControllerUtils.returnJson(request, response, accessInfo);
	}
	
	//保存
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletRequest request,HttpServletResponse response, PcAppAccess record) {
		Long id = appAccessPeer.saveOrUpdate(record);
		
		HttpClient client = HttpClient.getInstance(taskRoot);
		String json = client.request("/interface/dep/appaccess/add?record=" + JSON.toString(record));
		json = ControllerUtils.toRemoteJsonObject(json, String.class);
		
		ControllerUtils.returnJson(request, response, id);
	}
	//删除
	@RequestMapping("/removeById")
	public void removeById(HttpServletRequest request,HttpServletResponse response, Long id) {
		int c = appAccessPeer.removeById(id);
		ControllerUtils.returnJson(request, response, c);
	}
	
	@RequestMapping("/queryAppImageInfoList")
	public void queryAppImageInfoList(HttpServletRequest request,HttpServletResponse response, Long appId, Long appImgId, CPcAppImage cdt, String orders){
		long	 appVnoId =  appImagePeer.queryAppImageById(appImgId).getAppVnoId();
		List<PcAppImageInfo> list = appImagePeer.queryAppImageInfoList(appId, appVnoId, cdt, orders);
		ControllerUtils.returnJson(request, response, list);
	}
	
}
