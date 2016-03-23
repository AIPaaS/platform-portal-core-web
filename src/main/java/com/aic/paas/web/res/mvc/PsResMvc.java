package com.aic.paas.web.res.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.frame.cross.bean.DropRecord;
import com.aic.paas.frame.cross.bean.NodeProMapping;
import com.aic.paas.frame.cross.bean.TreeNode;
import com.aic.paas.frame.util.ComponentUtil;
import com.aic.paas.web.res.bean.CPcCompRoom;
import com.aic.paas.web.res.bean.CPcDataCenter;
import com.aic.paas.web.res.bean.CPcImageRepository;
import com.aic.paas.web.res.bean.CPcNetZone;
import com.aic.paas.web.res.bean.CPcResCenter;
import com.aic.paas.web.res.bean.PcCompRoom;
import com.aic.paas.web.res.bean.PcDataCenter;
import com.aic.paas.web.res.bean.PcImageRepository;
import com.aic.paas.web.res.bean.PcNetZone;
import com.aic.paas.web.res.bean.PcResCenter;
import com.aic.paas.web.res.peer.PcImageRepositoryPeer;
import com.aic.paas.web.res.peer.PsResPeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;



@Controller
@RequestMapping("/res/res")
public class PsResMvc {
	
	
	@Autowired
	PsResPeer resPeer;
	
	@Autowired
	PcImageRepositoryPeer imageRepositoryPeer;
	
	
	@RequestMapping("/getImageRespDropList")
    public void getImageRespDropList(HttpServletRequest request, HttpServletResponse response, Boolean addEmpty, Boolean addAttr, CPcImageRepository cdt, String orders) {
		if(BinaryUtils.isEmpty(orders)) orders = "IMG_RESP_CODE";
		List<PcImageRepository> list = imageRepositoryPeer.queryList(cdt, orders);
      
		List<DropRecord> dropList = ComponentUtil.toDropList(list, "ID", "imgRespCode", addAttr, addEmpty);
		ControllerUtils.returnJson(request, response, dropList);
    }
	
	
	@RequestMapping("/getCompRoomDropList")
    public void getCompRoomDropList(HttpServletRequest request, HttpServletResponse response, Boolean addEmpty, Boolean addAttr) {
		CPcCompRoom cdt = new CPcCompRoom();
        cdt.setStatus(1);
        List<PcCompRoom> list = resPeer.queryCompRoomList(cdt, "ROOM_CODE, ID");
      
        List<DropRecord> dropList = ComponentUtil.toDropList(list, "ID", "roomName", addAttr, addEmpty);
        ControllerUtils.returnJson(request, response, dropList);
    }
	
	
	/**
	 * @param opts dc|rc|nc
	 */
	@RequestMapping("/getResRegionDropListMap")
	public void getResRegionDropListMap(HttpServletRequest request, HttpServletResponse response, Boolean addEmpty, Boolean addAttr, String opts,Integer status) {
		Map<String, List<DropRecord>> map = getComputerRegionDropListMap(addEmpty, addAttr, opts,status);
		ControllerUtils.returnJson(request, response, map);
	}
	
	
	
	/**
	 * @param level 1=数据中心   2=数据中心+资源中心  3=数据中心+资源中心+网络区域
	 */
	@RequestMapping("/getResRegionTree")
	public void getComputerRegionTree(HttpServletRequest request, HttpServletResponse response, Boolean addAttr, Integer level,Integer status) {
		String opts = "dc|rc|nc";
		if(level != null) {
			switch (level.intValue()) {
				case 1: opts = "dc"; break;
				case 2: opts = "dc|rc"; break;
				default: opts = "dc|rc|nc"; break;
			}
		}
		
		Map<String, List<DropRecord>> map = getComputerRegionDropListMap(false, addAttr, opts,status);
		
		List<DropRecord> dclist = map.get("dc");
		List<DropRecord> rclist = map.get("rc");
		List<DropRecord> nclist = map.get("nc");
		if(rclist != null) dclist.addAll(rclist);
		if(nclist != null) dclist.addAll(nclist);
		
		List<TreeNode> nodes = null;
		if(dclist.size() > 0) {
			nodes = ComponentUtil.toTreeNodeList(dclist, true, false, new NodeProMapping[] {
					new NodeProMapping("id", "code", null),
					new NodeProMapping("text", "name", null),
					new NodeProMapping("parentid", "parentCode", null)
			});
		}else {
			nodes = new ArrayList<TreeNode>();
		}
		
		ControllerUtils.returnSimpleJson(request, response, nodes);
	}
	
	
	
	
	private Map<String, List<DropRecord>> getComputerRegionDropListMap(Boolean addEmpty, Boolean addAttr, String opts , Integer status )  {
		Map<String, List<DropRecord>> map = new HashMap<String, List<DropRecord>>();
		boolean adda = addAttr==null || addAttr.booleanValue();
		
		int fori = Boolean.TRUE.equals(addEmpty) ? 1 : 0;
		
		if(BinaryUtils.isEmpty(opts)) opts = null;
		
		if(opts==null || opts.indexOf("dc")>-1) {
			CPcDataCenter dccdt = new CPcDataCenter();
//			if(status == null){
//				status =1 ;
//			}
			dccdt.setStatus(status);
			List<PcDataCenter> dclist = resPeer.queryDataCenterList(dccdt, "CODE, ID");
			List<DropRecord> dcDropList = ComponentUtil.toDropList(dclist, "ID", "name", addAttr, addEmpty);
			for(int i=fori; i<dcDropList.size(); i++) {
				DropRecord r = dcDropList.get(i);
				r.setParam1("1");
				r.setParentCode("0");
			}
			map.put("dc", dcDropList);
			
			CPcDataCenter dccdts = new CPcDataCenter();
			List<PcDataCenter> dclists = resPeer.queryDataCenterList(dccdts, "CODE, ID");
			List<DropRecord> dcDropLists = ComponentUtil.toDropList(dclists, "ID", "name", addAttr, addEmpty);
			for(int i=fori; i<dcDropLists.size(); i++) {
				DropRecord r = dcDropLists.get(i);
				r.setParam1("1");
				r.setParentCode("0");
			}
			map.put("alldc", dcDropLists);
		}

		if(opts==null || opts.indexOf("rc")>-1) {
			CPcResCenter rccdt = new CPcResCenter();
			rccdt.setStatus(1);
			List<PcResCenter> rclist = resPeer.queryResCenterList(rccdt, "RES_CODE, ID");
			List<DropRecord> rcDropList = ComponentUtil.toDropList(rclist, "ID", "resName", true, addEmpty);
			for(int i=fori; i<rcDropList.size(); i++) {
				DropRecord r = rcDropList.get(i);
				r.setParam1("2");
				PcResCenter att = (PcResCenter)r.getAttributes();
				r.setParentCode(String.valueOf(att.getDataCenterId()));
				if(!adda) r.setAttributes(null);
			}
			map.put("rc", rcDropList);
			
			CPcResCenter rccdts = new CPcResCenter();
			List<PcResCenter> rclists = resPeer.queryResCenterList(rccdts, "RES_CODE, ID");
			List<DropRecord> rcDropLists = ComponentUtil.toDropList(rclists, "ID", "resName", true, addEmpty);
			for(int i=fori; i<rcDropLists.size(); i++) {
				DropRecord r = rcDropLists.get(i);
				r.setParam1("2");
				PcResCenter att = (PcResCenter)r.getAttributes();
				r.setParentCode(String.valueOf(att.getDataCenterId()));
				if(!adda) r.setAttributes(null);
			}
			map.put("allrc", rcDropLists);
		}
		
		if(opts==null || opts.indexOf("nc")>-1) {
			CPcNetZone nccdt = new CPcNetZone();
			nccdt.setStatus(1);
			List<PcNetZone> nclist = resPeer.queryNetZoneList(nccdt, "ZONE_CODE, ID");
			List<DropRecord> ncDropList = ComponentUtil.toDropList(nclist, "ID", "zoneName", addAttr, addEmpty);
			for(int i=fori; i<ncDropList.size(); i++) {
				DropRecord r = ncDropList.get(i);
				r.setParam1("3");
				PcNetZone att = (PcNetZone)r.getAttributes();
				r.setParentCode(String.valueOf(att.getResCenterId()));
				if(!adda) r.setAttributes(null);
			}
			map.put("nc", ncDropList);
			
			CPcNetZone nccdts = new CPcNetZone();
			List<PcNetZone> nclists = resPeer.queryNetZoneList(nccdts, "ZONE_CODE, ID");
			List<DropRecord> ncDropLists = ComponentUtil.toDropList(nclists, "ID", "zoneName", addAttr, addEmpty);
			for(int i=fori; i<ncDropLists.size(); i++) {
				DropRecord r = ncDropLists.get(i);
				r.setParam1("3");
				PcNetZone att = (PcNetZone)r.getAttributes();
				r.setParentCode(String.valueOf(att.getResCenterId()));
				if(!adda) r.setAttributes(null);
			}
			map.put("allnc", ncDropLists);
		}
		
		return map;
	}
	
	

}
