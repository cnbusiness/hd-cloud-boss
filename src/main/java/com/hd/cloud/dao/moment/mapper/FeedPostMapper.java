package com.hd.cloud.dao.moment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.PicBo;
import com.hd.cloud.dao.moment.sql.FeedPostProvider;
import com.hd.cloud.domain.FeedPost;
import com.hd.cloud.vo.FeedPostVo;

@Mapper
public interface FeedPostMapper {
	
	@SelectProvider(type = FeedPostProvider.class, method = "getFeedList")
	@Results(value = {
			@Result(property = "id", column = "feed_post_base_bb_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "postType", column = "feed_post_entity_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "topicId", column = "topic_topic_section_bd_seq", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "content", column = "post_base_content", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "forwardId", column = "post_base_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "title", column = "post_base_title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "recommend", column = "post_base_recommend", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "longitude", column = "post_base_longitude", javaType = double.class, jdbcType = JdbcType.DECIMAL),
			@Result(property = "latitude", column = "post_base_latitude", javaType = double.class, jdbcType = JdbcType.DECIMAL),
			@Result(property = "area", column = "post_base_phone_area", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "cityId", column = "pub_city_dict_sd_seq", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "type", column = "post_base_types", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "friends", column = "post_base_friends", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "groups", column = "post_base_groups", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "userItype", column = "post_user_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "commentItype", column = "post_comment_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "company", column = "biz_mobiz_company_bd_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "shopId", column = "biz_mobiz_shop_bd_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "shopStatus", column = "mobiz_shop_status_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "address", column = "post_base_address", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "favoriteCnt", column = "post_base_favorite_cnt", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "commentCnt", column = "post _base_review_cnt", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "browseCnt", column = "post _base_browse_cnt", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "storeCnt", column = "post _base_store_cnt", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "shareCnt", column = "post _base_share_cnt", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "author", column = "user_user_base_sb_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "picUrl", column = "post_base_pic_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "dispalyType", column = "post_base_display_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "shieldReason", column = "post_base_mask_reason", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "createTime", column = "create_time", javaType = String.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "updateTime", column = "update_time", javaType = String.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "createBy", column = "create_by", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "updateBy", column = "update_by", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "activeFlag", column = "active_flag", javaType = String.class, jdbcType = JdbcType.VARCHAR)
	})
	List<FeedPost> getFeedList(FeedPostVo feedPostVo);
	
	@SelectProvider(type = FeedPostProvider.class,method = "getFeedCount")
	int getFeedCount(FeedPostVo feedVo);
	
	/**
	 * 
	* @Title: findById 
	* @param: 
	* @Description: 动态详情
	* @return FeedPost
	 */
	@SelectProvider(type = FeedPostProvider.class,method = "findById")
	@Results(value = {
			@Result(property = "id", column = "feed_post_base_bb_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "postType", column = "feed_post_entity_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "topicId", column = "topic_topic_section_bd_seq", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "content", column = "post_base_content", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "forwardId", column = "post_base_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "title", column = "post_base_title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "recommend", column = "post_base_recommend", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "longitude", column = "post_base_longitude", javaType = double.class, jdbcType = JdbcType.DECIMAL),
			@Result(property = "latitude", column = "post_base_latitude", javaType = double.class, jdbcType = JdbcType.DECIMAL),
			@Result(property = "area", column = "post_base_phone_area", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "cityId", column = "pub_city_dict_sd_seq", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "type", column = "post_base_types", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "friends", column = "post_base_friends", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "groups", column = "post_base_groups", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "userItype", column = "post_user_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "commentItype", column = "post_comment_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "company", column = "biz_mobiz_company_bd_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "shopId", column = "biz_mobiz_shop_bd_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "shopStatus", column = "mobiz_shop_status_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "address", column = "post_base_address", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "favoriteCnt", column = "post_base_favorite_cnt", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "commentCnt", column = "post _base_review_cnt", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "browseCnt", column = "post _base_browse_cnt", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "storeCnt", column = "post _base_store_cnt", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "shareCnt", column = "post _base_share_cnt", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "author", column = "user_user_base_sb_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "picUrl", column = "post_base_pic_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "dispalyType", column = "post_base_display_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "shieldReason", column = "post_base_mask_reason", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "createTime", column = "create_time", javaType = String.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "updateTime", column = "update_time", javaType = String.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "createBy", column = "create_by", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "updateBy", column = "update_by", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "activeFlag", column = "active_flag", javaType = String.class, jdbcType = JdbcType.VARCHAR)
	})
	public FeedPost findById(@Param("id") long id);
	
	/**
	 * 
	* @Title: shield 
	* @param: 
	* @Description: 屏蔽动态 
	* @return int
	 */
	@UpdateProvider(type = FeedPostProvider.class,method = "shield")
	public int shield(FeedPost feedPost);
	
	/**
	 * 
	* @Title: getFeedPictures 
	* @param: 
	* @Description: 获取动态所有图片
	* @return List<String>
	 */
	@Select("select post_resource_path from feed_post_resource_br where active_flag = 'y' and feed_post_base_bb_seq = #{id}")
	@Results(value = {
			@Result(property = "picUrl", column = "post_resource_path", javaType = String.class, jdbcType = JdbcType.VARCHAR)
	})
	public List<PicBo> getFeedPictures(@Param("id") long id);
}
