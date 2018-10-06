package com.hd.cloud.service;

import com.hd.cloud.bo.BossUserAccount;

/**
 * 
 * @ClassName BossUserAccountService.java
 * @Description Boss用户信息
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年4月11日 下午2:28:37
 *
 */
public interface BossUserAccountService {
	
	
	
	//保存
	public int save(BossUserAccount bossAccount);
		
	public BossUserAccount getBossUserAccountById(long id);
	
	public int update(BossUserAccount bossUSerAccount);

	Long findUserId(long userId, String password);
}
