package com.hd.cloud.dao.moment.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.ActivityReport;
import com.hd.cloud.dao.moment.ActivityReportDao;
import com.hd.cloud.dao.moment.mapper.ActivityReportMapper;
import com.hd.cloud.vo.ActivityReportVo;

@Repository
public class ActivityReportDaoMyBatisImpl implements ActivityReportDao{
	
	@Inject
	public ActivityReportMapper activityReportMapper;
	
	@Override
	public List<ActivityReport> getActivityReportList(ActivityReportVo activityReportVo){
		return activityReportMapper.getActivityReportList(activityReportVo);
	}
	
	@Override
	public int getActivityReportCount(ActivityReportVo activityReportVo){
		return activityReportMapper.getActivityReportCount(activityReportVo);
	}
}
