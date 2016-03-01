package com.aic.paas.web.dep.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.comm.util.SystemUtil;
import com.aic.paas.frame.cross.integration.PaasWebSsoLoginUser;
import com.aic.paas.web.dep.bean.CPcService;
import com.aic.paas.web.dep.bean.PcKvPair;
import com.aic.paas.web.dep.bean.PcService;
import com.aic.paas.web.dep.bean.ServiceType;
import com.aic.paas.web.dep.peer.PcServicePeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;
import com.binary.json.JSON;

@Controller
@RequestMapping("/external/service")
public class PcExternalServiceMvc {

	
	@Autowired
	PcServicePeer servicePeer;
	
	
	@RequestMapping("/queryPage")
	public void queryPage(HttpServletRequest request,HttpServletResponse response, Integer pageNum, Integer pageSize, CPcService cdt, String orders) {
		Page<PcService> page = servicePeer.queryPage(pageNum, pageSize, ServiceType.EXTERNAL, cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	
	@RequestMapping("/queryParams")
	public void queryParams(HttpServletRequest request,HttpServletResponse response, Long svcId,String orders) {
		List<PcKvPair> list = servicePeer.queryParams(svcId, orders);
		ControllerUtils.returnJson(request, response, list);
	}
	
	@RequestMapping("/queryById")
	public void queryById(HttpServletRequest request,HttpServletResponse response, Long id) {
		PcService p = servicePeer.queryById(ServiceType.EXTERNAL, id);
		ControllerUtils.returnJson(request, response, p);
	}
	
	
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletRequest request,HttpServletResponse response, PcService record,String paramsStr) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		record.setUserId(user.getId());
		record.setUserName(user.getUserName());
		Long id = servicePeer.saveOrUpdate(ServiceType.EXTERNAL, record);
		
		List<PcKvPair> params = new ArrayList<PcKvPair>();
		if(!BinaryUtils.isEmpty(paramsStr)){
			params = JSON.toList(paramsStr, PcKvPair.class);
		}
		servicePeer.resetParams(ServiceType.EXTERNAL, id, params);
		
		ControllerUtils.returnJson(request, response, id);
	}
	
	@RequestMapping("/removeById")
	public void removeById(HttpServletRequest request,HttpServletResponse response, Long id) {
		int c = servicePeer.removeById(ServiceType.EXTERNAL, id);
		ControllerUtils.returnJson(request, response, c);
	}
	
	@RequestMapping("/resetParams")
	public void resetParams(HttpServletRequest request,HttpServletResponse response, Long svcId, String paramsStr) {
		List<PcKvPair> params = new ArrayList<PcKvPair>();
		if(!BinaryUtils.isEmpty(paramsStr)){
			params = JSON.toList(paramsStr, PcKvPair.class);
		}
		servicePeer.resetParams(ServiceType.EXTERNAL, svcId, params);
		ControllerUtils.returnJson(request, response, true);
	}
	
}
