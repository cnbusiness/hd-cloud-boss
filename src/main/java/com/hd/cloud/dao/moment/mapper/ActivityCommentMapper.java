package com.hd.cloud.dao.moment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.ActivityComment;
import com.hd.cloud.dao.moment.sql.ActivityCommentProvider;
import com.hd.cloud.vo.ActivityCommentVo;

@Mapper
public interface ActivityCommentMapper {
	
	@SelectProvider(type = ActivityCommentProvider.class,method = "getActivityCommentList")
	@Results(value = {
			@Result(property = "id",column = "party_activity_comment_bt_seq", javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "activityId",column = "party_activity_base_bd_seq", javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "commentId",column = "user_user_entity_seq", javaType = long.class,jdbcType = JdbcType.BIGINT),
			@Result(property = "parentId",column = "activity_comment_parent_seq", javaType = long.class,jdbcType = JdbcType.BIGINT),
			@Result(property = "commentContent",column = "activity_comment_content", javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "commentItype",column = "activity_comment_itype", javaType = int.class,jdbcType = JdbcType.TINYINT),
			@Result(property = "picUrl",column = "activity_comment_urls", javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "appItype",column = "activity_comment_app_itype", javaType = int.class,jdbcType = JdbcType.TINYINT),
			@Result(property = "statusItype",column = "activity_comment_status_itype", javaType = int.class,jdbcType = JdbcType.TINYINT),
	
	})
	List<ActivityComment> getActivityCommentList(ActivityCommentVo activityCommentVo);
	
	@SelectProvider(type = ActivityCommentProvider.class,method = "getActivityCommentCount")
	int getActivityCommentCount(ActivityCommentVo activityCommentVo);
}
