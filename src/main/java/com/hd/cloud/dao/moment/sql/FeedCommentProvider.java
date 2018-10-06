package com.hd.cloud.dao.moment.sql;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.vo.FeedCommentVo;

public class FeedCommentProvider {
	
	public String getFeedCommentList(FeedCommentVo feedCommnetVo){
		String sql = new SQL(){
			{
				SELECT("feed_comment_info_br_seq,comment_info_content,feed_post_base_bb_seq,comment_info_seq,user_user_base_sb_seq,comment_info_status_itype");
				FROM("feed_comment_info_br");
				WHERE("active_flag = 'y'");
				ORDER_BY("feed_comment_info_br_seq desc limit #{offset},#{pageSize}");
			}
		}.toString();
		return sql;
	}
	
	public String getFeedCommentCount(FeedCommentVo feedCommentVo){
		String sql = new SQL(){
			{
				SELECT("COUNT(1)");
				FROM("feed_comment_info_br");
				WHERE("active_flag = 'y'");
			}
		}.toString();
		return sql;
	}
}
