package com.hd.cloud.dao.moment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.Topic;
import com.hd.cloud.dao.moment.sql.HotTopicProvider;
import com.hd.cloud.vo.HotTopicVo;

@Mapper
public interface HotTopicMapper {
	
	/**
	 * 
	 * @Title:getHotTopicBoList
	 * @Description:热门话题列表
	 * @param hotTopicVo
	 * @return List<TopicBo>
	 */
	@SelectProvider(type = HotTopicProvider.class,method="getHotTopicBoList")
	@Results(value = {
		@Result(property = "name",column = "topic_section_name",javaType = String.class,jdbcType = JdbcType.VARCHAR),
		@Result(property = "iconUrl",column = "topic_section_icon_url",javaType = String.class,jdbcType = JdbcType.VARCHAR),
		@Result(property = "homeUrl",column = "topic_section_home_url",javaType = String.class,jdbcType = JdbcType.VARCHAR),
		@Result(property = "desc",column = "topic_section_desc",javaType = String.class,jdbcType = JdbcType.VARCHAR),
		@Result(property = "reviewCnt",column = "topic_section_review_cnt",javaType = Integer.class,jdbcType = JdbcType.INTEGER),
		@Result(property = "commentCnt",column = "topic_section_comment_cnt",javaType = Integer.class,jdbcType = JdbcType.INTEGER),
		@Result(property = "storeCnt",column = "topic_section_store_cnt",javaType = Integer.class,jdbcType = JdbcType.INTEGER),
		@Result(property = "browseCnt",column = "topic_section_browse_cnt",javaType = Integer.class,jdbcType = JdbcType.INTEGER),
	})
	List<Topic> getHotTopicBoList(HotTopicVo hotTopicVo);
	
	/**
	 * 
	 * @Title:getHotTopicBoCount
	 * @Description:热门话题列表总数
	 * @param hotTopicVo
	 * @return int
	 */
	@SelectProvider(type = HotTopicProvider.class,method = "getHotTopicBoCount")
	int getHotTopicBoCount(HotTopicVo hotTopicVo);

}
