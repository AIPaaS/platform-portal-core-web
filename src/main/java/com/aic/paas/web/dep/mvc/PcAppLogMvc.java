package com.aic.paas.web.dep.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.binary.core.http.HttpClient;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;

@Controller
@RequestMapping("/dep/applog")
public class PcAppLogMvc {

	@Value("${project.task.root}")
	String taskRoot;
	
	@RequestMapping("/log")
	public void getLog(HttpServletRequest request, HttpServletResponse response, Long appId, Long reqId, Long lastTime) {
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(reqId, "reqId");
		BinaryUtils.checkEmpty(lastTime, "lastTime");

		HttpClient client = HttpClient.getInstance(taskRoot);
		String resp = client.request("/dep/log/query?appId=" + appId + "&reqId=" + reqId + "&lastTime=" + lastTime);
		String newResp = ControllerUtils.toRemoteJsonObject(resp, String.class);
		ControllerUtils.returnJson(request, response, newResp);
	}
}
