package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.Activity;
import com.hd.cloud.vo.ActivityVo;
import com.hd.cloud.vo.CreateActivityVo;



public interface ActivityService {
	
	/**
	 * 
	 * @Title:getActivityList
	 * @Description:活动列表
	 * @param activityVo
	 * @return List<Activity>
	 */
	public List<Activity> getActivityList(ActivityVo activityVo);
	
	public int  getActivityCnt(ActivityVo activityVo);
	
	/**
	 * 
	 * @Title:createActivity
	 * @Description:创建活动
	 * @param activityVo
	 * @param userId
	 * @return String
	 */
	public String createActivity(CreateActivityVo createActivityVo,long userId);
	
	/**
	 * 
	 * @Title:getActivityById
	 * @Description:通过id获取活动信息
	 * @param id
	 * @return ActivityInfoBo
	 */
	Activity getActivityBaseById(int id);
	
	/**
	 * 
	 * @Title:deleteActivityById
	 * @Description:通过活动删除活动信息
	 * @param id void
	 */
	public void deleteActivityById(int id);
}
