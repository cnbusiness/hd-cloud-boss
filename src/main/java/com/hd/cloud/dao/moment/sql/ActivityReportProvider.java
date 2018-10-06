package com.hd.cloud.dao.moment.sql;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.vo.ActivityReportVo;

public class ActivityReportProvider {
	
	public String getActivityReportList(ActivityReportVo activityReportVo){
		String sql = new SQL(){
			{
				SELECT("party_activity_report_br_seq,user_user_base_sb_seq,party_activity_base_bd_seq,activity_report_content,activity_report_type,activity_report_source_itype,activity_report_deal_itype,activity_report_agree_itype,activity_report_feedback,pub_report_do_bd_seq");
				FROM("party_activity_report_br");
				WHERE("active_flag='y'");
				ORDER_BY("party_activity_report_br_seq desc limit #{offset},#{pageSize}");
			}
		}.toString();
		return sql;
	}
	
	public String getActivityReportCount(ActivityReportVo activityReportVo){
		String sql = new SQL(){
			{
				SELECT("COUNT(1)");
				FROM("party_activity_report_br");
				WHERE("active_flag = 'y'");
			}
		}.toString();
		return sql;
	}
}
