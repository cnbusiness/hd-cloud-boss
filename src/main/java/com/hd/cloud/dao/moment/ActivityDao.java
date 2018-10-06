package com.hd.cloud.dao.moment;

import java.util.List;

import com.hd.cloud.bo.Activity;
import com.hd.cloud.bo.ActivityInfoBo;
import com.hd.cloud.vo.ActivityVo;

public interface ActivityDao {
	
	/**
	 * 
	 * @Title:getActivityList
	 * @Description:活动列表
	 * @param activityVo
	 * @return List<Activity>
	 */
	public List<Activity> getActivityList(ActivityVo activityVo);
	
	/**
	 * 
	 * @Title:getActivityCnt
	 * @Description:活动列表总数
	 * @param activityVo
	 * @return int
	 */
	public int getActivityCnt(ActivityVo activityVo);
	
	/**
	 * 
	 * @Title:createActivity
	 * @Description:创建活动
	 * @param activityVo
	 * @return int
	 */
	public void createActivity(Activity activity);
	
	/**
	 * 
	 * @Title:deleteActivityById
	 * @Description:通过活动ID删除活动
	 * @param activityId
	 * @return void
	 */
	public void deleteActivityById(int activityId);
	
	/**
	 * 
	 * @Title:getActivityById
	 * @Description:通过活动ID获取活动基本信息
	 * @param activityId
	 * @return Activity
	 */
	public Activity getActivityBaseById(int id);
	
	
	public ActivityInfoBo getActivityById(int id);

	
	
}
