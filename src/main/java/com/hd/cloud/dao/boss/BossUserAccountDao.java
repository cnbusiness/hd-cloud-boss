package com.hd.cloud.dao.boss;

import com.hd.cloud.bo.BossUserAccount;

/**
 * 
 * @ClassName BossUserAccountDao.java
 * @Description BOSS用户账户信息
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年4月11日 上午10:16:22
 *
 */
public interface BossUserAccountDao {
	
	

	
	/**
	 * 
	 * @Title:save
	 * @Description:保存
	 * @param bossUserAccount
	 * @return int
	 */
	public int save(BossUserAccount bossUserAccount);
	
	/**
	 * 
	 * @Title:getBossUserAccountByUserId
	 * @Description:查询账户信息
	 * @param userId
	 * @return BossUserAccount
	 */
	public BossUserAccount getBossUserAccountById(long id);
	
	/**
	 * 
	 * @Title:update
	 * @Description:更新用户
	 * @param bossUserAccount
	 * @return int
	 */
	int update(BossUserAccount bossUserAccount);

	public Long findUserId(long userId, String password);
}
