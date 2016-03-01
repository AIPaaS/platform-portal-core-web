package com.aic.paas.web.integration;

import java.util.List;

import com.aic.paas.frame.cross.bean.CSysOp;
import com.aic.paas.frame.cross.bean.CSysRole;
import com.aic.paas.frame.cross.bean.SysOp;
import com.aic.paas.frame.cross.bean.SysOpInfo;
import com.aic.paas.frame.cross.bean.SysRole;
import com.aic.paas.frame.cross.integration.RoleAuth;
import com.binary.jdbc.Page;

public interface MntUserPeer {
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员表[SYS_OP]分页列表对象
	 */
	public Page<SysOp> queryOpPage(Integer pageNum, Integer pageSize, CSysOp cdt, String orders);


	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员表[SYS_OP]查询列表
	 */
	public List<SysOp> queryOpList(CSysOp cdt, String orders);
	
	
	

	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员表[SYS_OP]分页列表对象
	 */
	public Page<SysOpInfo> queryOpInfoPage(Integer pageNum, Integer pageSize, CSysOp cdt, String orders);


	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员表[SYS_OP]查询列表
	 */
	public List<SysOpInfo> queryOpInfoList(CSysOp cdt, String orders);


	/**
	 * 查询数据行数
	 * @param cdt : 条件对象
	 * @return 查询行数
	 */
	public long queryOpCount(CSysOp cdt);


	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public SysOp queryOpById(Long id);

	

	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : SysOp数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdateOp(SysOp record);

	
	
	/**
	 * 删除用户
	 * @param opId
	 * @return
	 */
	public Integer removeOpById(Long opId);
	
	
	
	
	/**
	 * 查询系统角色
	 * @param cdt
	 * @param orders
	 * @return
	 */
	public List<SysRole> querySysRoleList(CSysRole cdt, String orders);
	

	
	/**
	 * 设置用户角色
	 * @param opId
	 * @param roleIds
	 */
	public void setUserRoles(Long opId, Long[] roleIds);
	
	
	
	
	
	/**
	 * 查询角色权限清单
	 * @param cdt
	 * @param orders
	 * @return
	 */
	public List<RoleAuth> queryRoleAuthView(CSysRole cdt, String orders);
	
	
	
	
}
