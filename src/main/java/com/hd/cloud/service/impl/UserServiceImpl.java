package com.hd.cloud.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import com.google.common.collect.Lists;
import com.hd.cloud.bo.Auth;
import com.hd.cloud.bo.UserBo;
import com.hd.cloud.dao.boss.UserDao;
import com.hd.cloud.service.AuthService;
import com.hd.cloud.service.UserService;
import com.hd.cloud.vo.CreateUserVo;
import com.hd.cloud.vo.UserAccountVo;
import com.hlb.cloud.util.CommonConstantUtil;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Inject
	private UserDao userAccountDao;
	
	@Inject
	private AuthService authService;
	

		
	@Override
	public List<UserBo> getUserBoList(UserAccountVo userAccountVo){
		return userAccountDao.getUserBoList(userAccountVo);
	}
	
	@Override
	public int getUserBoCount(UserAccountVo userAccountVo){
		return userAccountDao.getUserBoCount(userAccountVo);
	}
	
	@Override
	public UserBo getUserBoByUserId(long userId) {
		return userAccountDao.getUserBoByUserId(userId);
	}
	
	@Override
	public UserBo getUserBoByPhone(String phone) {
		return userAccountDao.getUserBoByPhone(phone);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)  
	public Auth save(CreateUserVo createUserVo) {
		StopWatch swSaveUser = new StopWatch();
		swSaveUser.start();

		UserBo user = UserBo.builder().status(1).phone(createUserVo.getPhone()).sex(createUserVo.getSex()).birthday(createUserVo.getBirthday()).nickName(createUserVo.getNickName()).vip(createUserVo.getVip())
				.password(createUserVo.getPassword()).countryCode(createUserVo.getCountryCode()).activeFlag(CommonConstantUtil.ACTIVE_FLAG_Y).createBy(10000).build();
		userAccountDao.save(user);
		swSaveUser.stop();
		log.info("################################userAccountDao.saveUser   time:{}ms", swSaveUser.getTotalTimeMillis());

		// 生成token
		Auth auth = authService.saveAndGetToken(user.getUserId());
		
		// 更新到redis
		UserBo userProfile = UserBo.builder().userId(user.getUserId()).nickName("").status(1)
				.phone(createUserVo.getPhone()).build();
		log.info("#######userProfile:{}",userProfile);

		return auth;
	}
	

	@Override
	public Long findUserId(long userId, String password) {
		return userAccountDao.findUserId(userId,password);
	}


	
	@Override
	public int update(UserBo userBo) {
		return userAccountDao.update(userBo);
	}
	
	/**
	 * 批量冻结用户
	 */
	@Override
	public List<UserBo> updateUserBoListByUserIds(String userIds) {
		List<UserBo> list = Lists.newArrayList();
		String[] userIdArr = userIds.split(",");
		for (String id :userIdArr) {
			UserBo userBo = getUserBoByUserId(Long.valueOf(id));
			int result = freezeStatus(userBo);
			userBo = getUserBoByUserId(Long.valueOf(id));
			list.add(userBo);	
		}
		return list;
	}
	
	@Override
	public int freezeStatus(UserBo userBo){
		return userAccountDao.freezeStatus(userBo);
	}
	
	@Override
	public int updateStatus(UserBo userBo) {
		return userAccountDao.updateStatus(userBo);
	}
}
