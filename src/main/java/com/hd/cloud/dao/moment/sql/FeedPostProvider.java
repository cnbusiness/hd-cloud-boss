package com.hd.cloud.dao.moment.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.domain.FeedPost;
import com.hd.cloud.util.StringUtil;
import com.hd.cloud.vo.FeedPostVo;

public class FeedPostProvider {

	public String getFeedList(FeedPostVo feedVo) {
		String sql = new SQL() {
			{
				SELECT(" * ");
				FROM("feed_post_base_bb");
				WHERE("active_flag = 'y'");
				if (!StringUtil.isBlank(feedVo.getContent())) {
					AND();
					WHERE(" post_base_content  LIKE CONCAT('%', #{content},'%')");
				}
				if (feedVo.getDispalyType() > 0) {
					AND();
					WHERE(" post_base_display_itype=#{dispalyType}");
				}
				ORDER_BY(" feed_post_base_bb_seq desc limit #{offset},#{pageSize}");
			}
		}.toString();
		return sql;
	}

	public String getFeedCount(FeedPostVo feedVo) {
		String sql = new SQL() {
			{
				SELECT("COUNT(1)");
				FROM("feed_post_base_bb");
				WHERE("active_flag='y'");
				if (!StringUtil.isBlank(feedVo.getContent())) {
					AND();
					WHERE(" post_base_content  LIKE CONCAT('%', #{content},'%')");
				}
				if (feedVo.getDispalyType() > 0) {
					AND();
					WHERE(" post_base_display_itype=#{dispalyType}");
				}
			}
		}.toString();
		return sql;
	}

	// 动态详情
	public String findById(Map<String, Object> para) {
		return new SQL() {
			{
				SELECT(" * ");
				FROM("feed_post_base_bb");
				WHERE(" active_flag = 'y' AND feed_post_base_bb_seq="
						+ para.get("id"));
			}
		}.toString();
	}
	
	//屏蔽动态
	public String shield(FeedPost feedPost) {
		return new SQL() {
			{
				UPDATE("feed_post_base_bb");
				SET("post_base_display_itype =3");
				SET("post_base_mask_reason =#{shieldReason}");
				SET("update_by = #{updateBy}");
				SET("update_time =now()");
				WHERE("feed_post_base_bb_seq = #{id}");
			}
		}.toString();
	}

}
