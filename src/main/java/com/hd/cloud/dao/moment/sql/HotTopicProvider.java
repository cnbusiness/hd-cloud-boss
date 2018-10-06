package com.hd.cloud.dao.moment.sql;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.vo.HotTopicVo;

public class HotTopicProvider {
	
	public String getHotTopicBoList(HotTopicVo hotTopicVo){
		String sql = new SQL(){
			{
				SELECT("topic_section_name,topic_section_icon_url,topic_section_home_url,topic_section_desc,topic_section_favorite_cnt,topic_section_review_cnt,topic_section_browse_cnt,topic_section_store_cnt");
				FROM("topic_topic_section_bd");
				WHERE("active_flag = 'y' and topic_section_top_itype = '1' ");
				ORDER_BY("topic_topic_section_bd_seq desc limit #{offset},#{pageSize}");
			}
		}.toString();
		return sql;
	}
	
	public String getHotTopicBoCount(HotTopicVo hotTopicVo){
		String sql = new SQL(){
			{
				SELECT("COUNT(1)");
				FROM("topic_topic_section_bd");
				WHERE("active_flag = 'y' and topic_section_top_itype = '1'");
			}
		}.toString();
		return sql;
	}
}
