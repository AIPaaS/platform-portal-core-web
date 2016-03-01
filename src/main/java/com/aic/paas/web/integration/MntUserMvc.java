package com.aic.paas.web.integration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.frame.cross.bean.CSysOp;
import com.aic.paas.frame.cross.bean.SysOp;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;


@Controller
@RequestMapping("/mnt/user")
public class MntUserMvc {
	
	
	
	@Autowired
	MntUserPeer mntUserPeer;
	
	
	
	/**
	 * 分页查询
	 */
	@RequestMapping("/queryOpPage")
	public void queryOpPage(HttpServletRequest request, HttpServletResponse response, Integer pageNum, Integer pageSize, CSysOp cdt, String orders){
		Page<SysOp> page = mntUserPeer.queryOpPage(pageNum, pageSize, cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	
	
}
