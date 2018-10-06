package com.hd.cloud.dao.moment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.ActivityReport;
import com.hd.cloud.dao.moment.sql.ActivityReportProvider;
import com.hd.cloud.vo.ActivityReportVo;

@Mapper
public interface ActivityReportMapper {
	
	@SelectProvider(type = ActivityReportProvider.class,method="getActivityReportList")
	@Results(value = {
			@Result(property = "id",column = "party_activity_report_br_seq",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "userId",column = "user_user_base_sb_seq",javaType = long.class,jdbcType = JdbcType.BIGINT),
			@Result(property = "activityId",column = "party_activity_base_bd_seq",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "reportContent",column = "activity_report_content",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "reportTypeIds",column = "activity_report_type",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "sourceType",column = "activity_report_source_itype",javaType = int.class,jdbcType = JdbcType.TINYINT),
			@Result(property = "dealType",column = "activity_report_deal_itype",javaType = int.class,jdbcType = JdbcType.TINYINT),
			@Result(property = "agreeType",column = "activity_report_agree_itype",javaType = int.class,jdbcType = JdbcType.TINYINT),
			@Result(property = "feedBack",column = "activity_report_feedback",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "reportDoId",column = "pub_report_do_bd_seq",javaType = int.class,jdbcType = JdbcType.INTEGER),
	})
	List<ActivityReport> getActivityReportList(ActivityReportVo activityReportVo);
	
	@SelectProvider(type = ActivityReportProvider.class,method = "getActivityReportCount")
	int getActivityReportCount(ActivityReportVo activityReportVo);
	
	
}
