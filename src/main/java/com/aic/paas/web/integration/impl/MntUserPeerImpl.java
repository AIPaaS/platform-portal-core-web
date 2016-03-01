package com.aic.paas.web.integration.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.comm.util.SystemUtil;
import com.aic.paas.frame.cross.bean.CSysOp;
import com.aic.paas.frame.cross.bean.CSysRole;
import com.aic.paas.frame.cross.bean.SysOp;
import com.aic.paas.frame.cross.bean.SysOpInfo;
import com.aic.paas.frame.cross.bean.SysRole;
import com.aic.paas.frame.cross.integration.PaasWebSsoLoginUser;
import com.aic.paas.frame.cross.integration.RoleAuth;
import com.aic.paas.frame.cross.rest.MerchentSvc;
import com.aic.paas.frame.cross.rest.SysOpRoleSvc;
import com.aic.paas.frame.cross.rest.SysRoleSvc;
import com.aic.paas.web.integration.MntUserPeer;
import com.aic.paas.web.rest.SysOpSvc;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.exception.ServiceException;
import com.binary.jdbc.Page;

public class MntUserPeerImpl implements MntUserPeer {
	
	
	
	@Autowired
	SysOpSvc sysOpSvc;

	
	@Autowired
	SysOpRoleSvc sysOpRoleSvc;
	
	@Autowired
	SysRoleSvc sysRoleSvc;
	
	@Autowired
	MerchentSvc merchentSvc;
	

	
	/**
	 * 验证当前用的合法性
	 */
	private void verifyLegitimacy(Long opId) {
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		Long orgId = user.getOrg().getAuthOrgId();
		
		//验证当前操作用户是否跟被操作用户在同一组织下
		CSysOp cdt = new CSysOp();
		cdt.setId(opId);
		cdt.setOpKind(2);
		List<SysOp> ls = sysOpSvc.queryListByOrg(orgId, null, null, cdt, null);
		if(ls.size() == 0) {
			throw new ServiceException(" You don't have permission to change user ["+opId+"] information ");
		}
	}
	
	
	
	@Override
	public Page<SysOp> queryOpPage(Integer pageNum, Integer pageSize, CSysOp cdt, String orders) {
		if(cdt == null) cdt = new CSysOp();
		cdt.setOpKind(2);
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		return sysOpSvc.queryPageByOrg(pageNum, pageSize, user.getOrg().getAuthOrgId(), null, false, cdt, orders);
	}

	
	
	@Override
	public List<SysOp> queryOpList(CSysOp cdt, String orders) {
		if(cdt == null) cdt = new CSysOp();
		cdt.setOpKind(2);
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		return sysOpSvc.queryListByOrg(user.getOrg().getAuthOrgId(), null, false, cdt, orders);
	}

	
	
	
	@Override
	public Page<SysOpInfo> queryOpInfoPage(Integer pageNum, Integer pageSize, CSysOp cdt, String orders) {
		if(cdt == null) cdt = new CSysOp();
		cdt.setOpKind(2);
		cdt.setSuperUserFlag(0);
		return merchentSvc.queryOpInfoPage(pageNum, pageSize, cdt, orders);
	}


	@Override
	public List<SysOpInfo> queryOpInfoList(CSysOp cdt, String orders) {
		if(cdt == null) cdt = new CSysOp();
		cdt.setOpKind(2);
		return merchentSvc.queryOpInfoList(cdt, orders);
	}
	
	
	
	@Override
	public long queryOpCount(CSysOp cdt) {
		return sysOpSvc.queryCount(cdt);
	}

	@Override
	public SysOp queryOpById(Long id) {
		BinaryUtils.checkEmpty(id, "id");
		return sysOpSvc.queryById(id);
	}
	
	
	@Override
	public Long saveOrUpdateOp(SysOp record) {
		BinaryUtils.checkEmpty(record, "record");
		
		BinaryUtils.checkEmpty(record.getOpCode(), "record.opCode");
		BinaryUtils.checkEmpty(record.getOpName(), "record.opName");
		BinaryUtils.checkEmpty(record.getEmailAdress(), "record.emailAdress");
		BinaryUtils.checkEmpty(record.getStatus(), "record.status");
		if(record.getId() == null) {
			BinaryUtils.checkEmpty(record.getLoginPasswd(), "record.loginPasswd");
		}
		
		PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
		Long mntId = user.getMerchent().getId();
		Long orgId = user.getOrg().getAuthOrgId();
		
		Long id = record.getId();
		if(id != null) verifyLegitimacy(id);
		
		String code = record.getOpCode();
		record.setOpCode(code);
		
		CSysOp cdt = new CSysOp();
		cdt.setOpCode(code);
		cdt.setOpKind(2);
		List<SysOp> ls = sysOpSvc.queryListByOrg(orgId, null, null, cdt, null);
		
		if(ls.size()>0 && (id==null || ls.size()>1 || ls.get(0).getId().longValue()!=id.longValue())) {
			throw new ServiceException(" is exists code '"+code+"'! ");
		}
		
		return merchentSvc.saveOrUpdateUser(mntId, record);
	}
	

	
	@Override
	public Integer removeOpById(Long opId) {
		BinaryUtils.checkEmpty(opId, "opId");
		verifyLegitimacy(opId);
		return merchentSvc.removeUser(opId);
	}
	

	
	
	@Override
	public List<SysRole> querySysRoleList(CSysRole cdt, String orders) {
		if(cdt == null) cdt = new CSysRole();
		cdt.setRoleType(2);		//1=平台角色    2=租户角色
		return sysRoleSvc.queryList(cdt, orders);
	}
	
	
	
	@Override
	public void setUserRoles(Long opId, Long[] roleIds) {
		BinaryUtils.checkEmpty(opId, "opId");
//		BinaryUtils.checkEmpty(roleIds, "roleIds");
		verifyLegitimacy(opId);
		merchentSvc.setUserRoles(opId, roleIds);
	}



	
	@Override
	public List<RoleAuth> queryRoleAuthView(CSysRole cdt, String orders) {
		if(cdt == null) cdt = new CSysRole();
		cdt.setRoleType(2);		//1=平台角色    2=租户角色
		return merchentSvc.queryRoleAuthView(cdt, orders);
	}
	
	
	
}
