package com.hd.cloud.dao.moment.sql;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.vo.ActivityCommentVo;

public class ActivityCommentProvider {
	
	public String getActivityCommentList(ActivityCommentVo activityCommentVo){
		String sql = new SQL(){
			{
				SELECT("party_activity_comment_bt_seq,party_activity_base_bd_seq,user_user_entity_seq,activity_comment_parent_seq,activity_comment_content,activity_comment_itype,activity_comment_urls,activity_comment_app_itype,activity_comment_status_itype");
				FROM("party_activity_comment_bt");
				WHERE("active_flag = 'y'");
				ORDER_BY("party_activity_comment_bt_seq desc limit #{offset},#{pageSize}");
			}
		}.toString();
		return sql ;
	}
	
	public String getActivityCommentCount(ActivityCommentVo activityCommentVo){
		String sql = new SQL(){
			{
				SELECT("COUNT(1)");
				FROM("party_activity_comment_bt");
				WHERE("active_flag = 'y'");
			}
		}.toString();
		return sql ;
	}
}
