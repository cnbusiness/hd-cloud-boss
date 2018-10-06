package com.hd.cloud.dao.moment;

import java.util.List;

import com.hd.cloud.bo.ActivityReport;
import com.hd.cloud.vo.ActivityReportVo;

public interface ActivityReportDao {
	
	public List<ActivityReport> getActivityReportList(ActivityReportVo activityReportVo);
	
	public int getActivityReportCount(ActivityReportVo activityReportVo);
}
