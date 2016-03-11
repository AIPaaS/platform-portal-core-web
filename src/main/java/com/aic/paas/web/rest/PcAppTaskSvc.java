package com.aic.paas.web.rest;

import com.aic.paas.web.dep.bean.CPcAppTask;
import com.aic.paas.web.dep.bean.PcAppTask;
import com.aic.paas.web.dep.peer.bean.PcAppTaskInfo;
import com.binary.jdbc.Page;

public interface PcAppTaskSvc {

	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * 
	 * @param record
	 *            : PcAppTask数据记录
	 */
	public void save(PcAppTask record);

	public PcAppTask queryById(Long id);

	public Page<PcAppTask> queryPage(Integer pageNum, Integer pageSize, CPcAppTask cdt, String orders);

	public Page<PcAppTaskInfo> queryPcAppTaskInfo(Integer pageNum, Integer pageSize, CPcAppTask cdt, String orders);

}
