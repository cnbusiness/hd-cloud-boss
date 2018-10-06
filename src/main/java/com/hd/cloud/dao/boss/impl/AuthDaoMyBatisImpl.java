package com.hd.cloud.dao.boss.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.BossUserAccount;
import com.hd.cloud.dao.boss.AuthDao;
import com.hd.cloud.dao.boss.mapper.AuthMapper;

@Repository
public class AuthDaoMyBatisImpl implements AuthDao{
	
	@Inject
	private AuthMapper authMapper;
	
	@Override
	public Long login(long userId,String userPassword){
		Long userIdInDb = authMapper.login(userId,userPassword);
		return userIdInDb;
		}
	
	@Override
	public long getIdByPhone(String phone) {
		BossUserAccount user=authMapper.getIdByPhone(phone);
		return user.getUserId();
	}

	@Override
	public BossUserAccount getUserById(long userId) {
		return authMapper.getUserById(userId);
	}

}
