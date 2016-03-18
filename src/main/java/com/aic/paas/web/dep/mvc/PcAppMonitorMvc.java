package com.aic.paas.web.dep.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.web.dep.bean.CPcAppDepHistory;
import com.aic.paas.web.dep.bean.CPcAppDepInstance;
import com.aic.paas.web.dep.bean.PcAppDepHistory;
import com.aic.paas.web.dep.bean.PcAppDepInstance;
import com.aic.paas.web.dep.peer.PcAppMonitorPeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;


@Controller
@RequestMapping("/dep/appmonitor")
public class PcAppMonitorMvc {

	
	@Autowired
	PcAppMonitorPeer peer;
	
	
	@Value("${integration.monitor.docker.instance.url}")
	String monitorDockerInstanceUrl;
	
	@Value("${integration.monitor.docker.instance.logurl}")
	String monitorDockerInstanceLogurl;
	
	
	
	
	@RequestMapping("/queryDepHistoryPage")
	public void queryDepHistoryPage(HttpServletRequest request,HttpServletResponse response, Integer pageNum, Integer pageSize, CPcAppDepHistory cdt, String orders) {
		Page<PcAppDepHistory> page = peer.queryDepHistoryPage(pageNum, pageSize, cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	
	
	@RequestMapping("/queryDepInstance")
	public void queryDepInstance(HttpServletRequest request,HttpServletResponse response, Long depHistoryId,CPcAppDepInstance cdt, String orders) {
		List<PcAppDepInstance> list = peer.queryDepInstance(depHistoryId, cdt, orders);
		ControllerUtils.returnJson(request, response, list);
	}
	
	@RequestMapping("/queryDepInstancePage")
	public void queryDepInstancePage(HttpServletRequest request,HttpServletResponse response, Integer pageNum, Integer pageSize, Long depHistoryId, CPcAppDepInstance cdt, String orders) {
		Page<PcAppDepInstance> page = peer.queryDepInstancePage(pageNum, pageSize, depHistoryId, cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	
	
	@RequestMapping("/forward2MonitorDockerInstance")
	public String forward2MonitorDockerInstance(HttpServletRequest request,HttpServletResponse response, String dockerName) {
		BinaryUtils.checkEmpty(dockerName, "dockerName");
		String url = monitorDockerInstanceUrl + dockerName;
		return "redirect:"+url;
	}
	
	
	@RequestMapping("/forward2MonitorDockerInstanceLog")
	public String forward2MonitorDockerInstanceLog(HttpServletRequest request,HttpServletResponse response, String dockerName) {
		BinaryUtils.checkEmpty(dockerName, "dockerName");
		String url = monitorDockerInstanceLogurl + dockerName;
		return "redirect:"+url;
	}
	
	
}
