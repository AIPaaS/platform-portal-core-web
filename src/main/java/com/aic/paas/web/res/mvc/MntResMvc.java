package com.aic.paas.web.res.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.web.dep.bean.AppResInfo;
import com.aic.paas.web.res.bean.CPsMntRes;
import com.aic.paas.web.res.bean.CPsMntResApply;
import com.aic.paas.web.res.bean.CPsMntResFlow;
import com.aic.paas.web.res.bean.PsMntRes;
import com.aic.paas.web.res.bean.PsMntResApply;
import com.aic.paas.web.res.bean.PsMntResFlow;
import com.aic.paas.web.res.peer.MntResPeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;


@Controller
@RequestMapping("/res/mntres")
public class MntResMvc {

	
	
	@Autowired
	MntResPeer mntResPeer;
	
	
	
	@RequestMapping("/getMntResList")
	public void getMntResList(HttpServletRequest request, HttpServletResponse response, CPsMntRes cdt, String orders) {
		List<PsMntRes> ls = mntResPeer.getMntResList(cdt, orders);
		ControllerUtils.returnJson(request, response, ls);
	}
	
	
	
	@RequestMapping("/queryResFlowPage")
	public void queryResFlowPage(HttpServletRequest request, HttpServletResponse response, Integer pageNum, Integer pageSize, CPsMntResFlow cdt, String orders) {
		BinaryUtils.checkEmpty(cdt, "Condition");
		BinaryUtils.checkEmpty(cdt.getResId(), "Condition.resId");
		Page<PsMntResFlow> page = mntResPeer.queryResFlowPage(pageNum, pageSize, cdt.getResId(), cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	
	
	
	@RequestMapping("/queryApplyPage")
	public void queryApplyPage(HttpServletRequest request, HttpServletResponse response, Integer pageNum, Integer pageSize, CPsMntResApply cdt, String orders) {
		Page<PsMntResApply> page = mntResPeer.queryApplyPage(pageNum, pageSize, cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	
	
	
	
	@RequestMapping("/queryApplyById")
	public void queryApplyById(HttpServletRequest request, HttpServletResponse response, Long applyId) {
		PsMntResApply apply = mntResPeer.queryApplyById(applyId);
		ControllerUtils.returnJson(request, response, apply);
	}
	
	
	
	
	@RequestMapping("/saveOrUpdateApply")
	public void saveOrUpdateApply(HttpServletRequest request, HttpServletResponse response, PsMntResApply record) {
		Long id = mntResPeer.saveOrUpdateApply(record);
		ControllerUtils.returnJson(request, response, id);
	}
	
	
	
	@RequestMapping("/cannelApply")
	public void cannelApply(HttpServletRequest request, HttpServletResponse response, Long applyId) {
		mntResPeer.cannelApply(applyId);
		ControllerUtils.returnJson(request, response, true);
	}
	
	
	
	
	@RequestMapping("/queryUseState")
	public void queryUseState(HttpServletRequest request, HttpServletResponse response) {
		List<AppResInfo> ls = mntResPeer.queryUseStateList();
		ControllerUtils.returnJson(request, response, ls);
	}
	
	
}
