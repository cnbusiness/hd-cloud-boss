package com.hd.cloud.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.ActivityReport;
import com.hd.cloud.dao.moment.ActivityReportDao;
import com.hd.cloud.service.ActivityReportService;
import com.hd.cloud.vo.ActivityReportVo;

@Service
public class ActivityReportServiceImpl implements ActivityReportService{

	@Inject
	private ActivityReportDao activityReportDao;
	
	@Override
	public List<ActivityReport> getActivityReportList(ActivityReportVo activityReportVo) {
		// TODO Auto-generated method stub
		return activityReportDao.getActivityReportList(activityReportVo);
	}

	@Override
	public int getActivityReportcount(ActivityReportVo activityReportVo) {
		// TODO Auto-generated method stub
		return activityReportDao.getActivityReportCount(activityReportVo);
	}

}
