package com.aic.paas.web.res.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.web.dep.bean.CPcApp;
import com.aic.paas.web.res.bean.AppResInfo;
import com.aic.paas.web.res.bean.CPcAppRes;
import com.aic.paas.web.res.bean.CPcAppResApply;
import com.aic.paas.web.res.bean.CPcAppResFlow;
import com.aic.paas.web.res.bean.PcAppRes;
import com.aic.paas.web.res.bean.PcAppResApply;
import com.aic.paas.web.res.bean.PcAppResApplyInfo;
import com.aic.paas.web.res.bean.PcAppResFlow;
import com.aic.paas.web.res.peer.PcAppResPeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;



@Controller
@RequestMapping("/res/appres")
public class AppResMvc {
	
	
	
	@Autowired
	PcAppResPeer appResPeer;
	
	
	@RequestMapping("/queryAppResInfoPage")
	public void queryAppResInfoPage(HttpServletRequest request, HttpServletResponse response, Integer pageNum, Integer pageSize, CPcApp cdt, String orders) {
		Page<AppResInfo> page = appResPeer.queryAppResInfoPage(pageNum, pageSize, cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	
	
	
	@RequestMapping("/queryAppResInfoList")
	public void queryAppResInfoList(HttpServletRequest request, HttpServletResponse response, CPcApp cdt, String orders) {
		List<AppResInfo> ls = appResPeer.queryAppResInfoList(cdt, orders);
		ControllerUtils.returnJson(request, response, ls);
	}
	
	
	
	@RequestMapping("/queryAppResInfoById")
	public void queryAppResInfoById(HttpServletRequest request, HttpServletResponse response, Long appId) {
		AppResInfo info = appResPeer.queryAppResInfoById(appId);
		ControllerUtils.returnJson(request, response, info);
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/getAppResList")
	public void getAppResList(HttpServletRequest request, HttpServletResponse response, Long appId, CPcAppRes cdt, String orders) {
		List<PcAppRes> ls = appResPeer.getAppResList(appId, cdt, orders);
		ControllerUtils.returnJson(request, response, ls);
	}
	
	
	
	@RequestMapping("/queryResFlowPage")
	public void queryResFlowPage(HttpServletRequest request, HttpServletResponse response, Integer pageNum, Integer pageSize, CPcAppResFlow cdt, String orders) {
		BinaryUtils.checkEmpty(cdt, "Condition");
		BinaryUtils.checkEmpty(cdt.getResId(), "Condition.resId");
		Page<PcAppResFlow> page = appResPeer.queryResFlowPage(pageNum, pageSize, cdt.getResId(), cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	
	
	
	@RequestMapping("/queryApplyPage")
	public void queryApplyPage(HttpServletRequest request, HttpServletResponse response, Integer pageNum, Integer pageSize, CPcAppResApply cdt, String orders) {
		Page<PcAppResApply> page = appResPeer.queryApplyPage(pageNum, pageSize, cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	
	
	
	
	@RequestMapping("/queryApplyById")
	public void queryApplyById(HttpServletRequest request, HttpServletResponse response, Long applyId) {
		PcAppResApply apply = appResPeer.queryApplyById(applyId);
		ControllerUtils.returnJson(request, response, apply);
	}
	
	
	
	@RequestMapping("/queryApplyInfoPage")
	public void queryApplyInfoPage(HttpServletRequest request, HttpServletResponse response, Integer pageNum, Integer pageSize, CPcAppResApply cdt, String orders) {
		Page<PcAppResApplyInfo> page = appResPeer.queryApplyInfoPage(pageNum, pageSize, cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	
	
	
	
	@RequestMapping("/queryApplyInfoById")
	public void queryApplyInfoById(HttpServletRequest request, HttpServletResponse response, Long applyId) {
		PcAppResApplyInfo apply = appResPeer.queryApplyInfoById(applyId);
		ControllerUtils.returnJson(request, response, apply);
	}
	
	
	
	
	@RequestMapping("/saveOrUpdateApply")
	public void saveOrUpdateApply(HttpServletRequest request, HttpServletResponse response, PcAppResApply record) {
		Long id = appResPeer.saveOrUpdateApply(record);
		ControllerUtils.returnJson(request, response, id);
	}
	
	
	
	@RequestMapping("/cannelApply")
	public void cannelApply(HttpServletRequest request, HttpServletResponse response, Long applyId) {
		appResPeer.cannelApply(applyId);
		ControllerUtils.returnJson(request, response, true);
	}
	
	
	
	@RequestMapping("/checkApplyPass")
	public void checkApplyPass(HttpServletRequest request, HttpServletResponse response, Long applyId, String checkDesc) {
		appResPeer.checkApply(applyId, true, checkDesc);
		ControllerUtils.returnJson(request, response, true);
	}
	
	
	@RequestMapping("/checkApplyBack")
	public void checkApplyBack(HttpServletRequest request, HttpServletResponse response, Long applyId, String checkDesc) {
		appResPeer.checkApply(applyId, false, checkDesc);
		ControllerUtils.returnJson(request, response, true);
	}
	
	
	
	

}
