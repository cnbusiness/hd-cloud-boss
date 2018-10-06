package com.hd.cloud.service.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.Auth;
import com.hd.cloud.bo.BossUserAccount;
import com.hd.cloud.dao.boss.AuthDao;
import com.hd.cloud.dao.boss.UserTokenDao;
import com.hd.cloud.service.AuthService;
import com.hd.cloud.util.HashGenerator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService{
	
	@Inject
	private AuthDao authDao;
	
	@Inject
	private UserTokenDao userTokenDao;
	
	/**
	 * 传入userid与token，进行token有效性验证
	 */
	@Override
	public boolean isValidTokenPare(long userId, String token) {
		final Auth auth = userTokenDao.read(userId);
		log.debug("auth :{}" , auth);
		boolean isValid = false;
		if(auth == null || !token.equals(auth.getToken())){
			log.info("UserId = {} token validation failure!", userId);
			return isValid;
	}
	// 当token验证成功是，auth对象的过期时间刷新
		userTokenDao.refreshAuthExpire(userId);
		log.info("UserId = {} token validation success!", userId);
		return true;
	}
	
	/**
	 * 
	 * @Title:isValiddatePassPare
	 * @Description:根据用户userId与密码，进行登录验证
	 * @param id
	 * @param userpass
	 * @return Auth
	 */
	@Override
	public Auth isValidatePassPare(long userId, String userpass) {
		Long userIdInDb = authDao.login(userId, userpass);
		Auth auth = null;
		log.info("####userIdInDb:" + userIdInDb);
		if (userIdInDb != null) {
			String token = this.createToken(userIdInDb);
			auth = Auth.builder().userId(userId).token(token).id(userId).authTime(new Date()).build();
			userTokenDao.save(auth);
		}
		return auth;
	}
		
	/**
	 * 
	 * @Title:getUserIdByAccount
	 * @Description:根据传入的手机号查询userId
	 * @param bossUserAccount
	 * @return long
	 */
	@Override
	public long getUserIdByAccount(String userAccount) {
		long  userId = authDao.getIdByPhone(userAccount);
		return userId;
	}

	
	/**
	 * 根据用户userId生成token，并且吧auth对象存入redis
	 */
	@Override
	public Auth saveAndGetToken(long userId) {
		Auth auth;
		String token;
		token = this.createToken(userId);
		auth = Auth.builder().id(userId).userId(userId).token(token).authTime(new Date()).build();
		userTokenDao.save(auth);
		return auth;
	}
	/**
	 * 根据userID销毁redis缓存中的auth对象
	 */
	@Override
	public void detoryAuthRedis(long userId) {
		userTokenDao.destroyAuth(userId);
		
	}
	
	/**
	 * 根据用户UserId生成一个token
	 */
	public String createToken(long userId) {
		return HashGenerator.generateToken(String.valueOf(userId));
	}
	
	/**
	 * 密码验证
	 */
	@Override
	public boolean passwordValidation(long userId, String userpass) {
		Long userIdInDb = authDao.login(userId,userpass);
		if(userIdInDb != null){
			return true;
		}
		return false;
	}

	@Override
	public BossUserAccount getUserById(long userId) {

		return authDao.getUserById(userId);
	}	
}
