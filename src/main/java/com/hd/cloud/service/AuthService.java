package com.hd.cloud.service;

import com.hd.cloud.bo.Auth;
import com.hd.cloud.bo.BossUserAccount;

public interface AuthService {
		
	

		
	/**
	 * 
	 * @Title:isValidTokenPare
	 * @Description:验证UserId与token
	 * @param userId
	 * @param token
	 * @return boolean
	 */
	public boolean isValidTokenPare(long userId,String token);
	
	/**
	 * 
	 * @Title:isValiddatePassPare
	 * @Description:根据userId、密码、登录app类型、验证登录
	 * @param id
	 * @param userpass
	 * @return UserToken
	 */
	Auth isValidatePassPare(long id ,String userpass);
	
	/**
	 * 
	 * @Title:passwordValidation
	 * @Description:验证用户id，密码正确性
	 * @param id
	 * @param userpass
	 * @return boolean
	 */
	boolean passwordValidation(long id , String userpass);
	/**
	 * 
	 * @Title:getIdByAccount
	 * @Description:根据账户（邮箱或者手机号）获取ID
	 * @param bossUserAccount
	 * @return long
	 */
	long getUserIdByAccount(String userAccount);
	
	/**
	 * 
	 * @Title:saveAndGetToken
	 * @Description:根据出入userId生成token
	 * @param userId
	 * @return Auth
	 */
	Auth saveAndGetToken(long userId);
	
	/**
	 * 
	 * @Title:detoryAuthRedis
	 * @Description:传入userId清除redis中的token，即踢下线
	 * @param userId void
	 */
	public void detoryAuthRedis(long userId);
	
	/**
	 * 
	 * @Title: getUserById
	 * @param:
	 * @Description: 查询用户详情
	 * @return User
	 */
	public BossUserAccount getUserById(long userId);
	
}

