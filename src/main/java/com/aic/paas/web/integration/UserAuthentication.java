package com.aic.paas.web.integration;



/**
 * 用户认证
 * @author wanwb
 */
public interface UserAuthentication {

	
	
	/**
	 * 验证当前系统用户是否具有操作指定镜像权限
	 * @param imageId
	 */
	public void verifyImageAuth(Long imageId);
	
	
	
	
	/**
	 * 验证当前系统用户是否具有操作指定APP权限
	 * @param appId
	 */
	public void verifyUserAppAuth(Long appId);
	
	
	
	
	
	/**
	 * 验证租户资源申请单的合法性
	 * @param applyId
	 */
	public void verifyMntResApply(Long applyId);
	
	
	
	
	
	/**
	 * 验证租户资源申请单的合法性
	 * @param applyId
	 */
	public void verifyAppResApply(Long applyId);
	
	
	
	
	/**
	 * 验证应用镜像的合法性
	 * @param appImageId
	 */
	public void verifyAppImageAuth(Long appImageId);
	
}
