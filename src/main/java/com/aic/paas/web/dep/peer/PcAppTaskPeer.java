package com.aic.paas.web.dep.peer;

import com.aic.paas.web.dep.bean.CPcAppTask;
import com.aic.paas.web.dep.peer.bean.PcAppTaskInfo;
import com.binary.jdbc.Page;

public interface PcAppTaskPeer {

	public Page<PcAppTaskInfo> queryInfoPage(Integer pageNum, Integer pageSize, CPcAppTask cdt, String orders);

}
