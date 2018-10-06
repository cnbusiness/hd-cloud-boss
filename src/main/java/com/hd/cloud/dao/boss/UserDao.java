package com.hd.cloud.dao.boss;

import java.util.List;

import com.hd.cloud.bo.UserBo;
import com.hd.cloud.vo.UserAccountVo;

public interface UserDao {
	
	/**
	 * 
	 * @Title:getUserBoList
	 * @Description:用户列表
	 * @param userAccountVo
	 * @return List<UserBo>
	 */
	public List<UserBo> getUserBoList(UserAccountVo userAccountVo);
	
	/**
	 * 
	 * @Title:getUserBoCount
	 * @Description:总数
	 * @param userAccountVo
	 * @return int
	 */
	public int getUserBoCount(UserAccountVo userAccountVo);
	
	/**
	 * 
	 * @Title:save
	 * @Description:保存
	 * @param userBo
	 * @return int
	 */
	public int save(UserBo userBo);
	
	/**
	 * 
	 * @Title:getUserBoByUserId
	 * @Description:通过用户ID查询用户信息
	 * @param userId
	 * @return UserBo
	 */
	public UserBo getUserBoByUserId(long userId);
	
	/**
	 * 
	 * @Title:getUserByPhone
	 * @Description:通过电话号码查询
	 * @param phone
	 * @return UserBo
	 */
	public UserBo getUserBoByPhone(String phone);
	
	/**
	 * 
	 * @Title:findUserId
	 * @Description:查询用户ID
	 * @param userId
	 * @param password
	 * @return Long
	 */
	Long findUserId(long userId,String password);
	
	/**
	 * 
	 * @Title:updateUserBOListByUserIds
	 * @Description:批量冻结用户
	 * @param userIds
	 * @return List<UserBo>
	 */
	public List<UserBo> updateUserBoListByUserIds(String userIds);
	
	/**
	 * 
	 * @Title:updateStatus
	 * @Description:冻结或解冻用户
	 * @param userIds
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
	
	/**
	 * 
	 * @Title:update
	 * @Description:修改
	 * @param userBo
	 * @return int
	 */
	public int update(UserBo userBo);
}
