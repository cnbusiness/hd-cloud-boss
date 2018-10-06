package com.hd.cloud.dao.moment.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.Activity;
import com.hd.cloud.bo.ActivityInfoBo;
import com.hd.cloud.dao.moment.ActivityDao;
import com.hd.cloud.dao.moment.mapper.ActivityMapper;
import com.hd.cloud.vo.ActivityVo;

@Repository
public class ActivityDaoMyBatisImpl implements ActivityDao{
	
	@Inject
	public ActivityMapper activitymapper;
	
	@Override
	public List<Activity> getActivityList(ActivityVo activityVo) {
		return activitymapper.getActivityList(activityVo);
	}
	
	@Override
	public int getActivityCnt(ActivityVo activityVo) {
		return activitymapper.getActivityCnt(activityVo);
	}


	@Override
	public void createActivity(Activity activity) {
		 activitymapper.createActivity(activity);
	}
//
//	@Override
//	public void deleteActivityById(int activityId) {
//		 activitymapper.deleteActivityById(activityId);
//	}
//
	@Override
	public Activity getActivityBaseById(int id) {
		// TODO Auto-generated method stub
		return activitymapper.getActivityBaseById(id);
	}

	@Override
	public ActivityInfoBo getActivityById(int id) {
		// TODO Auto-generated method stub
		return activitymapper.getActivityById(id);
	}

	@Override
	public void deleteActivityById(int id) {
		// TODO Auto-generated method stub
		activitymapper.deleteActivityById(id);
	}
}
