package com.hd.cloud.dao.boss.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.UserBo;
import com.hd.cloud.dao.boss.UserDao;
import com.hd.cloud.dao.boss.mapper.UserMapper;
import com.hd.cloud.vo.UserAccountVo;

@Repository
public class UserDaoMyBatisImpl implements UserDao{
	
	@Inject
	private UserMapper userMapper;
	
	@Override
	public int save(UserBo userBo){
		return userMapper.save(userBo);
	}
	
	@Override
	public List<UserBo> getUserBoList(UserAccountVo userAccountVo){
		
		return userMapper.getUserBoList(userAccountVo);
		
	}
	
	@Override
	public int getUserBoCount(UserAccountVo userAccountVo){
		Integer count = userMapper.getUserBoCount(userAccountVo);
		return count == null ? 0 : count;
	}

	@Override
	public UserBo getUserBoByUserId(long userId) {
		return userMapper.getUserBoByUserId(userId);
	}

	@Override
	public UserBo getUserBoByPhone(String phone) {
		return userMapper.getUserBoByPhone(phone);
	}

	@Override
	public Long findUserId(long userId, String password) {
		return userMapper.findUserId(userId, password);
	}
	
	@Override
	public int update(UserBo userBo){
		return userMapper.update(userBo);
	}

	@Override
	public List<UserBo> updateUserBoListByUserIds(String userIds) {
		return userMapper.updateUserBoListByUserIds(userIds);
	}

	@Override
	public int updateStatus(UserBo userBo) {
		return userMapper.updateStatus(userBo);
	}

	@Override
	public int freezeStatus(UserBo userBo) {
		// TODO Auto-generated method stub
		return userMapper.freezeStatus(userBo);
	}

}
