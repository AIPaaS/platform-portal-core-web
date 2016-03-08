package com.aic.paas.web.dep.peer.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.comm.util.SystemUtil;
import com.aic.paas.frame.cross.integration.PaasWebSsoLoginUser;
import com.aic.paas.web.dep.bean.CPcService;
import com.aic.paas.web.dep.bean.ExternalServiceReq;
import com.aic.paas.web.dep.bean.ExternalServiceReq.Check;
import com.aic.paas.web.dep.bean.PcKvPair;
import com.aic.paas.web.dep.bean.PcService;
import com.aic.paas.web.dep.bean.PcServiceInfo;
import com.aic.paas.web.dep.bean.ServiceType;
import com.aic.paas.web.dep.peer.PcServicePeer;
import com.aic.paas.web.res.bean.CPcDataCenter;
import com.aic.paas.web.res.bean.PcDataCenter;
import com.aic.paas.web.rest.IExternalServiceManager;
import com.aic.paas.web.rest.PcDataCenterSvc;
import com.aic.paas.web.rest.PcServiceSvc;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.exception.ServiceException;
import com.binary.jdbc.Page;
import com.binary.json.JSON;

public class PcServicePeerImpl implements PcServicePeer {
	
	
	@Autowired
	PcServiceSvc serviceSvc;
	@Autowired
	PcDataCenterSvc pcDataCenterSvc;
	@Autowired
	IExternalServiceManager iExternalServiceManager;

	
	
	@Override
	public Page<PcService> queryPage(Integer pageNum, Integer pageSize, ServiceType svcType, CPcService cdt, String orders) {
		BinaryUtils.checkEmpty(svcType, "svcType");
		if(cdt == null) cdt = new CPcService();
		cdt.setSvcType(svcType.getValue());
		if(svcType != ServiceType.PLATFORM) {
			PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
			cdt.setMntId(user.getMerchent().getId());
		}
		return serviceSvc.queryPage(pageNum, pageSize, cdt, orders);
	}
	
	
	

	@Override
	public List<PcService> queryList(ServiceType svcType, CPcService cdt, String orders) {
		BinaryUtils.checkEmpty(svcType, "svcType");
		if(cdt == null) cdt = new CPcService();
		cdt.setSvcType(svcType.getValue());
		if(svcType != ServiceType.PLATFORM) {
			PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
			cdt.setMntId(user.getMerchent().getId());
		}
		return serviceSvc.queryList(cdt, orders);
	}

	
	
	@Override
	public PcService queryById(ServiceType svcType, Long id) {
		BinaryUtils.checkEmpty(svcType, "svcType");
		BinaryUtils.checkEmpty(id, "id");
		CPcService cdt = new CPcService();
		cdt.setId(id);
		cdt.setSvcType(svcType.getValue());
		if(svcType != ServiceType.PLATFORM) {
			PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
			cdt.setMntId(user.getMerchent().getId());
		}
		List<PcService> ls = serviceSvc.queryList(cdt, null);
		return ls.size()>0 ? ls.get(0) : null;
	}

	
	
	@Override
	public Page<PcServiceInfo> queryInfoPage(Integer pageNum, Integer pageSize, ServiceType svcType, CPcService cdt, String orders) {
		BinaryUtils.checkEmpty(svcType, "svcType");
		if(cdt == null) cdt = new CPcService();
		cdt.setSvcType(svcType.getValue());
		if(svcType != ServiceType.PLATFORM) {
			PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
			cdt.setMntId(user.getMerchent().getId());
		}
		return serviceSvc.queryInfoPage(pageNum, pageSize, cdt, orders);
	}


	@Override
	public List<PcServiceInfo> queryInfoList(ServiceType svcType, CPcService cdt, String orders) {
		BinaryUtils.checkEmpty(svcType, "svcType");
		if(cdt == null) cdt = new CPcService();
		cdt.setSvcType(svcType.getValue());
		if(svcType != ServiceType.PLATFORM) {
			PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
			cdt.setMntId(user.getMerchent().getId());
		}
		return serviceSvc.queryInfoList(cdt, orders);
	}
	
	
	
	@Override
	public PcServiceInfo queryInfoById(ServiceType svcType, Long id) {
		BinaryUtils.checkEmpty(svcType, "svcType");
		BinaryUtils.checkEmpty(id, "id");
		CPcService cdt = new CPcService();
		cdt.setId(id);
		cdt.setSvcType(svcType.getValue());
		if(svcType != ServiceType.PLATFORM) {
			PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
			cdt.setMntId(user.getMerchent().getId());
		}
		List<PcServiceInfo> ls = serviceSvc.queryInfoList(cdt, null);
		return ls.size()>0 ? ls.get(0) : null;
	}
	
	
	
	@Override
	public Long saveOrUpdate(ServiceType svcType, PcService record) {
		BinaryUtils.checkEmpty(svcType, "svcType");
		BinaryUtils.checkEmpty(record, "record");
		
		record.setSvcType(svcType.getValue());
		if(svcType != ServiceType.PLATFORM) {
			PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
			record.setMntId(user.getMerchent().getId());
		}
		
		boolean isadd = record.getId() == null;
		String svcCode = record.getSvcCode();
		if(isadd) {
			BinaryUtils.checkEmpty(svcCode, "record.svcCode");
			BinaryUtils.checkEmpty(record.getSvcName(), "record.svcName");
			BinaryUtils.checkEmpty(record.getDataCenterId(), "record.dataCenterId");
			BinaryUtils.checkEmpty(record.getResCenterId(), "record.resCenterId");
			
			switch(record.getSvcType().intValue()) {
				case 1 : {
					BinaryUtils.checkEmpty(record.getDutierId(), "record.dutierId");
					BinaryUtils.checkEmpty(record.getDutierName(), "record.dutierName");
					BinaryUtils.checkEmpty(record.getDutierPhone(), "record.dutierPhone");
					BinaryUtils.checkEmpty(record.getDutierEmail(), "record.dutierEmail");
					BinaryUtils.checkEmpty(record.getDepTime(), "record.depTime");
					break;
				}
				case 2 : {
//					BinaryUtils.checkEmpty(record.getAppId(), "record.appId");
					BinaryUtils.checkEmpty(record.getUserId(), "record.userId");
					BinaryUtils.checkEmpty(record.getUserName(), "record.userName");
					PcDataCenter dc = queryExternalDomainByDataCenterId(record.getDataCenterId());
					record.setDomainName(svcCode + "." + dc.getExternalDomain());
					break;
				}
				case 3 : {
					BinaryUtils.checkEmpty(record.getAppImageId(), "record.appImageId");
					PcDataCenter dc = queryExternalDomainByDataCenterId(record.getDataCenterId());
					record.setDomainName(svcCode + "." + dc.getDomain());
					break;
				}
			}
		}else {
			if(svcCode != null) BinaryUtils.checkEmpty(svcCode, "record.svcCode");
			if(record.getSvcName() != null) BinaryUtils.checkEmpty(record.getSvcName(), "record.svcName");
			if(record.getDataCenterId() != null) BinaryUtils.checkEmpty(record.getDataCenterId(), "record.dataCenterId");
			if(record.getResCenterId() != null) BinaryUtils.checkEmpty(record.getResCenterId(), "record.resCenterId");
			if(record.getDutierId() != null) BinaryUtils.checkEmpty(record.getDutierId(), "record.dutierId");
			if(record.getDutierName() != null) BinaryUtils.checkEmpty(record.getDutierName(), "record.dutierName");
			if(record.getDutierPhone() != null) BinaryUtils.checkEmpty(record.getDutierPhone(), "record.dutierPhone");
			if(record.getDutierEmail() != null) BinaryUtils.checkEmpty(record.getDutierEmail(), "record.dutierEmail");
			if(record.getDepTime() != null) BinaryUtils.checkEmpty(record.getDepTime(), "record.depTime");
//			if(record.getAppId() != null) BinaryUtils.checkEmpty(record.getAppId(), "record.appId");
			if(record.getUserId() != null) BinaryUtils.checkEmpty(record.getUserId(), "record.userId");
			if(record.getUserName() != null) BinaryUtils.checkEmpty(record.getUserName(), "record.userName");
			if(record.getAppImageId() != null) BinaryUtils.checkEmpty(record.getAppImageId(), "record.appImageId");
		}
		registerToConsul(record);
		return serviceSvc.saveOrUpdate(record);
	}
	private PcDataCenter queryExternalDomainByDataCenterId(Long dataCenterId) {
		CPcDataCenter cdt = new CPcDataCenter();
		cdt.setId(dataCenterId);
		List<PcDataCenter> ls = pcDataCenterSvc.queryList(cdt, null);
		return ls.size()>0 ? ls.get(0) : null;
	}
	
	/**
	 * 调用辅助后场 将服务注册到consul
	 * @param record
	 */
	private void registerToConsul(PcService record) {
		
		ExternalServiceReq externalServiceReq = new ExternalServiceReq();
		externalServiceReq.setClusterId(record.getResCenterId().toString());
		externalServiceReq.setServiceId(record.getSvcCode());
		externalServiceReq.setServiceName(record.getSvcName());
		externalServiceReq.setAddress(record.getIp());
		externalServiceReq.setPort(record.getPort());
		
		List<Check> checks = new ArrayList<Check>();
		Check check = new Check();
		check.setScript(record.getCustom4());
		check.setInterval("30s");
		check.setTtl("60s");
		checks.add(check);
		externalServiceReq.setCheck(checks);
		
		iExternalServiceManager.add(JSON.toString(externalServiceReq));
	}
	private void deleteSrvFromConsul(PcService record) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		ExternalServiceReq externalServiceReq = new ExternalServiceReq();
		externalServiceReq.setClusterId(record.getResCenterId().toString());
		externalServiceReq.setServiceId(record.getSvcCode());
		iExternalServiceManager.delete(JSON.toString(externalServiceReq));
	}
	
	@Override
	public int removeById(ServiceType svcType, Long id) {
		BinaryUtils.checkEmpty(svcType, "svcType");
		BinaryUtils.checkEmpty(id, "svcId");
		
		PcService record = queryById(svcType, id);
		if(record != null) {
			deleteSrvFromConsul(record);
			return serviceSvc.removeById(id);
		}
		return 0;
	}
	
	
	

	@Override
	public void resetParams(ServiceType svcType, Long svcId, List<PcKvPair> params) {
		BinaryUtils.checkEmpty(svcType, "svcType");
		BinaryUtils.checkEmpty(svcId, "svcId");
		PcService record = queryById(svcType, svcId);
		if(record == null) {
			throw new ServiceException(" not found serivce by id '"+svcId+"'! ");
		}
		serviceSvc.resetParams(svcId, params);
	}




	@Override
	public List<PcKvPair> queryParams(Long svcId, String orders) {
		return serviceSvc.queryParams(svcId, orders);
	}
	
	@Override
	public Page<PcServiceInfo> queryPage4Info(Integer pageNum,
			Integer pageSize, ServiceType svcType, CPcService cdt, String orders) {
		BinaryUtils.checkEmpty(svcType, "svcType");
		if(cdt == null) cdt = new CPcService();
		cdt.setSvcType(svcType.getValue());
		if(svcType != ServiceType.PLATFORM) {
			PaasWebSsoLoginUser user = (PaasWebSsoLoginUser)SystemUtil.getLoginUser();
			cdt.setMntId(user.getMerchent().getId());
		}
		return serviceSvc.queryPage4Info(pageNum, pageSize, cdt, orders);	
	}

}
