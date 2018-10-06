package com.hd.cloud.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.BossUserAccount;
import com.hd.cloud.dao.boss.BossUserAccountDao;
import com.hd.cloud.service.BossUserAccountService;


@Service
public class BossUserAccountServiceImpl implements BossUserAccountService{
	
	@Inject
	private BossUserAccountDao bossUserAccountDao;
	

	
	@Override
	public int save(BossUserAccount bossUserAccount) {
		return bossUserAccountDao.save(bossUserAccount);
	}

	@Override
	public BossUserAccount getBossUserAccountById(long id) {
		// TODO Auto-generated method stub
		return bossUserAccountDao.getBossUserAccountById(id);
	}

	@Override
	public int update(BossUserAccount bossUserAccount) {
		// TODO Auto-generated method stub
		return bossUserAccountDao.update(bossUserAccount);
	}

	@Override
	public Long findUserId(long userId, String password) {
		// TODO Auto-generated method stub
		return bossUserAccountDao.findUserId(userId, password);
	}

	
}
