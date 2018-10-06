package com.hd.cloud.dao.boss;

import com.hd.cloud.bo.Auth;

public interface UserTokenDao {
	
	/**
	 * 
	 * @Title:save
	 * @Description:传入auth对象，存入redis缓存
	 * @param auth void
	 */
	public void save(final Auth auth);
	
	/**
	 * 
	 * @Title:read
	 * @Description:传入userId,查询redis缓存的auth对象
	 * @param userId
	 * @return Auth
	 */
	public Auth read(final long userId);
	
	/**
	 * 
	 * @Title:destroyAuth
	 * @Description:传入userId，销毁redis缓存中对应的auth对象
	 * @return void
	 */
	public void destroyAuth(final long userId);
	
	/**
	 * 
	 * @Title:refreshAuthExpire
	 * @Description:刷新auth过期时间
	 * @param userId void
	 */
	public void refreshAuthExpire(final long userId);
}
