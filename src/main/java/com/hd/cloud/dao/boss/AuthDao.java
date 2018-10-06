package com.hd.cloud.dao.boss;

import com.hd.cloud.bo.BossUserAccount;

public interface AuthDao {

	/**
	 * 
	 * @Title: login
	 * @param:
	 * @Description: 登录验证，返回userId
	 * @return Long
	 */
	Long login(long userId, String userPassword);
	
	/**
	 * 
	 * @Title:getIdByPhone
	 * @Description:根据手机号码返回userId
	 * @param phone
	 * @return BossUserAccount
	 */
	long getIdByPhone(String userAccount);
	
	/**
	 * 
	 * @Title:getUserById
	 * @Description:获取用户详情
	 * @param userId
	 * @return BossUserAccount
	 */
	BossUserAccount getUserById(long userId);
	
}
