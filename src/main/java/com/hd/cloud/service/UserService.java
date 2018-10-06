package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.Auth;
import com.hd.cloud.bo.UserBo;
import com.hd.cloud.vo.CreateUserVo;
import com.hd.cloud.vo.UserAccountVo;

public interface UserService {

	public List<UserBo> getUserBoList(UserAccountVo userAccountVo);
	
	public int getUserBoCount(UserAccountVo userAccountVo);
	
	public Auth save(CreateUserVo createUserVo);

	Long findUserId(long userId, String password);

	public UserBo getUserBoByUserId(long userId);
	
	public UserBo getUserBoByPhone(String phone);
	
	public int update(UserBo userBo);

	public List<UserBo> updateUserBoListByUserIds(String userIds);
	
	/**
	 * 
	 * @Title:updateStatus
	 * @Description:冻结或解冻用户
	 * @param userBo
	 * @return int
	 */
	public int updateStatus(UserBo userBo);
	
	/**
	 * 
	 * @Title:freezeStatus
	 * @Description:冻结用户
	 * @param userBo
	 * @return int
	 */
	public int freezeStatus(UserBo userBo);
}
