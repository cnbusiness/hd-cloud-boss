package com.hd.cloud.dao.moment.mapper;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.dao.moment.sql.TopicProvider;
import com.hd.cloud.domain.TopicHome;
import com.hd.cloud.domain.TopicSection;
import com.hd.cloud.vo.TopicVo;

@Mapper
public interface TopicMapper {
	
	/**
	 * @Title: getTopicSectionList
	 * @Description: 摇一摇绑定话题 查询话题列表
	 * @Table: topic_topic_section_bd 话题栏目字典表
	 */
	@SelectProvider(type = TopicProvider.class, method = "getTopicSectionList")
	@Results(value = {
			@Result(property = "id", column = "topic_topic_section_bd_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "topicName", column = "topic_section_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "topicUrl", column = "topic_section_icon_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "homeUrl", column = "topic_section_home_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "topicDesc", column = "topic_section_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "favoriteCnt", column = "topic_section_favorite_cnt", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "reviewCnt", column = "topic_section_comment_cnt", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "browseCnt", column = "topic_section_browse_cnt", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "storeCnt", column = "topic_section_store_cnt", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "displayType", column = "topic_section_display_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "createSource", column = "topic_section_source_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "sourceType", column = "source_type", javaType = String.class, jdbcType = JdbcType.VARCHAR) })
	List<TopicSection> getTopicSectionList(TopicVo topicVo);
	
	/**
	 * @Title: getTopicSectionCount
	 * @Description: 查询话题总数
	 * @Table: topic_topic_section_bd 话题栏目字典表
	 */
	@SelectProvider(type = TopicProvider.class, method = "getTopicSectionCount")
	Integer getTopicSectionCount(TopicVo topicVo);

	/**
	 * @Title: save
	 * @Description: 保存话题
	 * @Table: topic_topic_section_bd 话题栏目字典表
	 */
	@InsertProvider(type = TopicProvider.class, method = "save")
	@SelectKey(statement = { "SELECT LAST_INSERT_ID() AS id  " }, keyProperty = "id", before = false, resultType = long.class)
	int save(TopicSection topicSection);

	/**
	 * @Title: update
	 * @Description: 编辑话题
	 * @Table: topic_topic_section_bd 话题栏目字典表
	 */
	@UpdateProvider(type = TopicProvider.class, method = "update")
	int update(TopicSection topicSection);
	
	/**
	 * @Title: getTopicSectionList
	 * @Description:查询话题
	 * @Table: topic_topic_section_bd 话题栏目字典表
	 */
	@SelectProvider(type = TopicProvider.class, method = "findById")
	@Results(value = {
			@Result(property = "id", column = "topic_topic_section_bd_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "topicName", column = "topic_section_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "topicUrl", column = "topic_section_icon_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "countryCode", column = "city_dict_country_code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "backgroudUrl", column = "topic_section_backgroud_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "homeUrl", column = "topic_section_home_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "topicDesc", column = "topic_section_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "favoriteCnt", column = "topic_section_favorite_cnt", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "reviewCnt", column = "topic_section_comment_cnt", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "browseCnt", column = "topic_section_browse_cnt", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "storeCnt", column = "topic_section_store_cnt", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "sort", column = "topic_section_order", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "displayType", column = "topic_section_display_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "createSource", column = "topic_section_source_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "createBy", column = "create_by", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "mxUserId", column = "user_user_base_sb_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "createTime", column = "create_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "sourceType", column = "source_type", javaType = String.class, jdbcType = JdbcType.VARCHAR) 
	})
	TopicSection findById(@Param("id") long id);
	
	/** 
	* @Title: getTopicCountByTopicName 
	* @param: 
	* @Description: 是否存在主题
	* @return int
	*/
	@Select("select count(1) from topic_topic_section_bd where topic_section_name=#{topicName} and topic_topic_section_bd_seq!=#{id} and active_flag='y'") 
	int getTopicCountByTopicName(@Param(value = "topicName") String topicName,@Param(value = "id") long id);

	/**
	 * 
	* @Title: update 
	* @param: 
	* @Description: 创建首页话题
	* @return int
	 */
	@UpdateProvider(type = TopicProvider.class, method = "saveTopicHome")
	@SelectKey(statement = { "SELECT LAST_INSERT_ID() AS topicHomeId  " }, keyProperty = "topicHomeId", before = false, resultType = long.class)
	int saveTopicHome(TopicHome topicHome);
	
	/**
	 * 
	* @Title: getCountByTopicId 
	* @param: 
	* @Description: 验证首页是否已推荐 
	* @return int
	 */
	@Select("select count(1) from home_hot_topic_br where topic_topic_section_bd_seq = #{topicId} and active_flag = 'y'")
	int getCountByTopicId(@Param("topicId") long topicId);
	
	/**
	 * 
	* @Title: deleteTopicHome 
	* @param: 
	* @Description: 删除首页推荐
	* @return int
	 */
	@Delete("delete from home_hot_topic_br where topic_topic_section_bd_seq = #{topicId}")
	int deleteTopicHome(@Param("topicId")long topicId);
}
