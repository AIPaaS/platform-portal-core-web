package com.aic.paas.web.dep.peer;

import com.aic.paas.web.dep.bean.CPcAppTask;
import com.aic.paas.web.dep.bean.PcAppTask;
import com.binary.jdbc.Page;

public interface PcAppTaskPeer {

	public Page<PcAppTask> queryInfoPage(Integer pageNum, Integer pageSize, CPcAppTask cdt, String orders);

}
