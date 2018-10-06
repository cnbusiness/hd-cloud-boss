package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.ActivityReport;
import com.hd.cloud.vo.ActivityReportVo;

public interface ActivityReportService {
	
	public List<ActivityReport> getActivityReportList(ActivityReportVo activityReportVo);
	
	public int getActivityReportcount(ActivityReportVo activityReportVo);
}
