package com.aic.paas.web.dep.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.web.dep.bean.CPcAppTask;
import com.aic.paas.web.dep.bean.PcAppTask;
import com.aic.paas.web.dep.peer.PcAppTaskPeer;
import com.binary.core.http.HttpClient;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;
import com.binary.json.JSON;

@Controller
@RequestMapping("/dep/applog")
public class PcAppLogMvc {

	@Value("${project.task.root}")
	String taskRoot;

	@Autowired
	PcAppTaskPeer pcAppTaskPeer;

	@RequestMapping("/log")
	public void getLog(HttpServletRequest request, HttpServletResponse response, Long appId, Long reqId, Long lastTime) {
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(reqId, "reqId");
		BinaryUtils.checkEmpty(lastTime, "lastTime");

		HttpClient client = HttpClient.getInstance(taskRoot);
		String resp = client.request("/dep/log/query?appId=" + appId + "&reqId=" + reqId + "&lastTime=" + lastTime);
		String newResp = ControllerUtils.toRemoteJsonObject(resp, String.class);
		ControllerUtils.returnJson(request, response, JSON.toObject(newResp));
	}

	@RequestMapping("/log/task")
	public void getLog(HttpServletRequest request, HttpServletResponse response, Integer pageNum, Integer pageSize, CPcAppTask cdt, String orders) {
		Page<PcAppTask> page = pcAppTaskPeer.queryInfoPage(pageNum, pageSize, cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	
	@RequestMapping("/log/status")
	public void getStatus(HttpServletRequest request, HttpServletResponse response, Long appId) {
		HttpClient client = HttpClient.getInstance(taskRoot);
		String resp = client.request("/dep/log/status?appId=" + appId);
		String newResp = ControllerUtils.toRemoteJsonObject(resp, String.class);
		ControllerUtils.returnJson(request, response, JSON.toObject(newResp));
	}
}
