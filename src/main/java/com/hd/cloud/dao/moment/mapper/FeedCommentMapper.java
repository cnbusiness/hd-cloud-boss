package com.hd.cloud.dao.moment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.FeedComment;
import com.hd.cloud.dao.moment.sql.FeedCommentProvider;
import com.hd.cloud.vo.FeedCommentVo;

@Mapper
public interface FeedCommentMapper {
	
	@SelectProvider(type = FeedCommentProvider.class,method = "getFeedCommentList")
	@Results(value = {
			@Result(property = "id",column = "feed_comment_info_br_seq",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "userId",column = "user_user_base_sb_seq",javaType = Long.class,jdbcType = JdbcType.BIGINT),
			@Result(property = "commentContent",column = "comment_info_content",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "commentId",column = "comment_info_seq",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "feedId",column = "feed_post_base_bb_seq",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "statusItype",column = "comment_info_status_itype",javaType = int.class,jdbcType = JdbcType.TINYINT),
	})
	List<FeedComment> getFeedCommentList(FeedCommentVo feedCommentVo);
	
	@SelectProvider(type = FeedCommentProvider.class,method = "getFeedCommentCount")
	int getFeedCommentCount(FeedCommentVo feedCommentVo);
}
