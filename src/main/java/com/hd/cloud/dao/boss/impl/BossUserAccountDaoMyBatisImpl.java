package com.hd.cloud.dao.boss.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.BossUserAccount;
import com.hd.cloud.dao.boss.BossUserAccountDao;
import com.hd.cloud.dao.boss.mapper.BossUserAccountMapper;

@Repository
public class BossUserAccountDaoMyBatisImpl implements BossUserAccountDao{
	
	@Inject
	private BossUserAccountMapper bossUserAccountMapper;
	
	@Override
	public int save(BossUserAccount bossUserAccount){
		return bossUserAccountMapper.save(bossUserAccount);
	}
	

	
	@Override
	public BossUserAccount getBossUserAccountById(long id){
		return bossUserAccountMapper.getBossUserAccountById(id);
	}
	
	@Override
	public int update(BossUserAccount bossUserAccount){
		return bossUserAccountMapper.update(bossUserAccount);
	}

	@Override
	public Long findUserId(long userId, String password) {
		
		return bossUserAccountMapper.findUserId(userId,password);
	}
	
}
