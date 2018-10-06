package com.hd.cloud.dao.moment.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.domain.TopicHome;
import com.hd.cloud.domain.TopicSection;
import com.hd.cloud.util.StringUtil;
import com.hd.cloud.vo.TopicVo;

public class TopicProvider {
	/**
	 * 
	 * @Title: getTopicSectionList
	 * @param:
	 * @Description: 获取话题列表
	 * @return String
	 */
	public String getTopicSectionList(TopicVo topicVo) {
		return new SQL() {
			{
				SELECT(" topic_topic_section_bd_seq,topic_section_name,topic_section_desc,topic_section_icon_url,"
						+ "topic_section_home_url,topic_section_favorite_cnt,topic_section_review_cnt,"
						+ "topic_section_browse_cnt,topic_section_store_cnt,topic_section_display_itype,"
						+ "(case topic_section_source_itype when 1 then 'APP' when 2 then '后台' else null end) source_type,topic_section_comment_cnt ");
				FROM("  topic_topic_section_bd ");
				WHERE(" active_flag = 'y' and (topic_section_news_itype != 1 or topic_section_news_itype is null)");
				if (!StringUtil.isBlank(topicVo.getTopicName())) {
					AND();
					WHERE(" topic_section_name  LIKE CONCAT('%', #{topicName},'%')");
				}
				if (topicVo.getCreateSource() > 0) {
					AND();
					WHERE(" topic_section_source_itype=#{createSource}");
				}

				ORDER_BY(" topic_section_order LIMIT #{offset},#{pageSize} ");
			}

		}.toString();
	}

	/**
	 * 
	 * @Title: getTopicSectionCount
	 * @param:
	 * @Description: 话题总数
	 * @return String
	 */
	public String getTopicSectionCount(TopicVo topicVo) {
		return new SQL() {
			{
				SELECT(" COUNT(1) ");
				FROM("  topic_topic_section_bd ");
				WHERE(" active_flag = 'y' and (topic_section_news_itype != 1 or topic_section_news_itype is null) ");
				if (!StringUtil.isBlank(topicVo.getTopicName())) {
					AND();
					WHERE(" topic_section_name  LIKE CONCAT('%', #{topicName},'%')");
				}
				if (topicVo.getCreateSource() > 0) {
					AND();
					WHERE(" topic_section_source_itype=#{createSource}");
				}
			}

		}.toString();
	}

	/**
	 * 
	 * @Title: save
	 * @param:
	 * @Description: 保存话题
	 * @return String
	 */
	public String save(TopicSection topicSection) {
		return new SQL() {
			{
				INSERT_INTO("topic_topic_section_bd");
				VALUES("topic_section_name", "#{topicName}");
				VALUES("topic_section_desc", "#{topicDesc}");
				VALUES("topic_section_icon_url", "#{topicUrl}");
				VALUES("topic_section_backgroud_url", "#{backgroudUrl}");
				VALUES("topic_section_home_url", "#{homeUrl}");
				VALUES("topic_section_order", "#{sort}");
				VALUES("topic_section_display_itype", "#{displayType}");
				VALUES("city_dict_country_code", "#{countryCode}");
				VALUES("topic_section_check_itype", "#{checkStatus}");
				VALUES("user_user_base_sb_seq", "#{mxUserId}");
				VALUES("topic_section_source_itype", "#{createSource}");
				VALUES("topic_section_favorite_cnt", "#{favoriteCnt}");
				VALUES("topic_section_review_cnt", "#{reviewCnt}");
				VALUES("topic_section_browse_cnt", "#{browseCnt}");
				VALUES("topic_section_store_cnt", "#{storeCnt}");
				VALUES("topic_section_hot_degree", "#{degree}");
				VALUES("topic_section_top_itype", "#{isTop}");
				VALUES("topic_section_top_date", "#{topDate}");
				VALUES("topic_section_comment_cnt", "#{commentCnt}");
				VALUES("create_by", "#{createBy}");
				VALUES("create_time", "NOW()");
				VALUES("update_by", "#{updateBy}");
				VALUES("update_time", "NOW()");
				VALUES("active_flag", "'y'");
			}
		}.toString();
	}

	/**
	 * 
	 * @Title: update
	 * @param:
	 * @Description: 编辑话题
	 * @return String
	 */
	public String update(TopicSection topicSection) {
		return new SQL() {
			{
				UPDATE("topic_topic_section_bd");
				if (!StringUtil.isBlank(topicSection.getTopicName())) {
					SET("topic_section_name =#{topicName}");
				}
				if (!StringUtil.isBlank(topicSection.getTopicDesc())) {
					SET("topic_section_desc =#{topicDesc}");
				}
				if (!StringUtil.isBlank(topicSection.getTopicUrl())) {
					SET("topic_section_icon_url =#{topicUrl}");
				}
				if (!StringUtil.isBlank(topicSection.getHomeUrl())) {
					SET("topic_section_home_url =#{homeUrl}");
				}
				if (topicSection.getDisplayType() > 0) {
					SET("topic_section_display_itype =#{displayType}");
				}

				if (!StringUtil.isBlank(topicSection.getCountryCode())) {
					SET("city_dict_country_code =#{countryCode}");
				}

				if (topicSection.getIsTop() > 0) {
					SET("topic_section_top_itype =#{topicDesc}");
					if (topicSection.getIsTop() == 1) {
						SET("topic_section_top_date =now()");
					}
				}
				if (topicSection.getSort() > 0) {
					SET("topic_section_order =#{sort}");
				}
				if (topicSection.getMxUserId() > 0) {
					SET("user_user_base_sb_seq =#{mxUserId}");
				}
				if (!StringUtil.isBlank(topicSection.getActive())) {
					SET("active_flag =#{active}");
				}
				SET("update_by = #{updateBy}");
				SET("update_time =now()");
				WHERE("topic_topic_section_bd_seq = #{id}");
			}
		}.toString();
	}

	//话题详情
	public String findById(Map<String, Object> para) {
		return new SQL() {
			{
				SELECT(" topic_topic_section_bd_seq,topic_section_name,topic_section_desc,topic_section_icon_url,"
						+ "city_dict_country_code,topic_section_backgroud_url,topic_section_home_url,"
						+ "topic_section_order,topic_section_display_itype,topic_section_favorite_cnt,"
						+ "topic_section_review_cnt,topic_section_browse_cnt,topic_section_store_cnt,"
						+ "(case topic_section_source_itype when 1 then 'APP' when 2 then '后台' else null end) "
						+ "source_type,user_user_base_sb_seq,create_by,create_time,user_user_base_sb_seq,"
						+ "topic_section_comment_cnt ");
				FROM("  topic_topic_section_bd ");
				WHERE(" active_flag = 'y' AND topic_topic_section_bd_seq="
						+ para.get("id"));
			}
		}.toString();
	}
	
	/**
	 * 
	 * @Title: save
	 * @param:
	 * @Description: 保存话题首页
	 * @return String
	 */
	public String saveTopicHome(TopicHome topicHome) {
		return new SQL() {
			{
				INSERT_INTO("home_hot_topic_br");
				VALUES("city_dict_country_code", "#{countryCode}");
				VALUES("topic_topic_section_bd_seq", "#{topicId}");
				VALUES("hot_topic_order", "#{sort}");
				VALUES("create_by", "#{createBy}");
				VALUES("update_by", "#{updateBy}");
				VALUES("create_time", "NOW()");
				VALUES("update_time", "NOW()");
				VALUES("active_flag", "'y'");
			}
		}.toString();
	}

}
