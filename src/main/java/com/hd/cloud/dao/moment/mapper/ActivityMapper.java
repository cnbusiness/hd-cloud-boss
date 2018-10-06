package com.hd.cloud.dao.moment.mapper;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.Activity;
import com.hd.cloud.bo.ActivityInfoBo;
import com.hd.cloud.dao.moment.sql.ActivityProvider;
import com.hd.cloud.vo.ActivityVo;

@Mapper
public interface ActivityMapper {
	
	/**
	 * 
	 * @Title:getActivityList
	 * @Description:活动列表
	 * @param activityVo
	 * @return List<Activity>
	 */
	@SelectProvider(type=ActivityProvider.class,method = "getActivityList")
	@Results(value= {
			@Result(property = "theme", column = "activity_base_topic",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "logoUrl", column = "activity_pic_url",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "cityId", column = "pub_city_dict_sd_seq",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "status", column = "activity_base_status_itype",javaType = Integer.class,jdbcType = JdbcType.TINYINT),
			@Result(property = "activityTypeId", column = "party_activity_type_bd_seq",javaType = Integer.class,jdbcType = JdbcType.TINYINT),
			@Result(property = "recommendItype", column = "activity_base_recommend_itype",javaType = Integer.class,jdbcType = JdbcType.TINYINT),
			@Result(property = "appType", column = "activity_base_app_itype",javaType = short.class,jdbcType = JdbcType.TINYINT),
//			@Result(property = "", column = "",javaType = .class,jdbcType = JdbcType.)
	})
	List<Activity> getActivityList(ActivityVo activityVo);
	
	/**
	 * 
	 * @Title:getActivityCnt
	 * @Description:获取活动列表总数
	 * @param activityVo
	 * @return int
	 */
    @SelectProvider(type = ActivityProvider.class,method = "getActivityCnt")
	int getActivityCnt(ActivityVo activityVo);
    
    /**
     * 
     * @Title:createActivity
     * @Description:创建活动
     * @param activity void
     */
	@Insert("insert into party_activity_base_bd "
			+ " (activity_base_internal_code,party_activity_type_bd_seq,activity_base_topic,activity_base_desc,activity_base_person_cnt,activity_base_bdate,activity_base_edate,activity_base_btime, "
			+ " activity_base_etime,activity_base_qrcode_url,activity_base_contact_itype,activity_base_fee_itype,activity_base_fee,activity_base_app_itype,mobiz_shop_auth_itype,"
			+ " activity_base_organizer,activity_base_phone,activity_base_status_itype,activity_base_cancle_reason,activity_pic_url,activity_base_delay_cnt,pub_city_dict_sd_seq,mobiz_shop_status_itype, "
			+ " activity_pic_urls,user_group_base_br_seq,goods_goods_base_bd_seq,activity_base_notice_itype,activity_base_shake_itype,create_by,create_time,update_by,update_time,active_flag) "
			+ " values (#{innerCode},#{activityTypeId},#{theme},#{detail},#{personNumber},#{startDate},#{endDate},#{startTime},#{endTime},"
			+ " #{qrcode},#{isNeedPhone},#{isFree},#{money},#{appType},#{authType},#{organizer},#{contactPhone},#{status},#{cancleReason},#{logoUrl},#{delayHour},#{cityId},#{shopShield},#{pictureUrls},#{userGroupId},#{couponId},#{isNeedNotice},#{hasShake},#{creater},now(),#{updater},now(),'y')")
	@SelectKey(keyProperty = "id", before = false, resultType = int.class, statement = {
			"SELECT LAST_INSERT_ID() AS id  " })
	void createActivity(Activity activity);
//	
//	/**
//	 * 
//	 * @Title:deleteActivityById
//	 * @Description:删除活动信息
//	 * @param activityId void
//	 */
//	@Delete("DELETE FROM party_activity_base_bd WHRER party_activity_base_bd_seq= #{activityId}")
//	void deleteActivityById(int activityId);
//	
	/**
	 * @Title: getActivityById
	 * @Description: 获取活动基础信息
	 * @Table party_activity_base_bd 活动基础表
	 */
	@Select("select *,CONCAT(activity_base_bdate,' ',activity_base_btime) beginTime,"
			+ " CONCAT(activity_base_edate,' ',activity_base_etime) finishTime "
			+ " from party_activity_base_bd where party_activity_base_bd_seq=#{id} and active_flag='y'")
	@Results(value = {
			@Result(property = "id", column = "party_activity_base_bd_seq", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "innerCode", column = "activity_base_internal_code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "activityTypeId", column = "party_activity_type_bd_seq", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "theme", column = "activity_base_topic", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "detail", column = "activity_base_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "personNumber", column = "activity_base_person_cnt", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "cityId", column = "pub_city_dict_sd_seq", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "startDate", column = "activity_base_bdate", javaType = Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "endDate", column = "activity_base_edate", javaType = Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "startTime", column = "activity_base_btime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "endTime", column = "activity_base_etime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "qrcode", column = "activity_base_qrcode_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "isNeedPhone", column = "activity_base_contact_itype", javaType = short.class, jdbcType = JdbcType.TINYINT),
			@Result(property = "isFree", column = "activity_base_fee_itype", javaType = short.class, jdbcType = JdbcType.TINYINT),
			@Result(property = "money", column = "activity_base_fee", javaType = double.class, jdbcType = JdbcType.DECIMAL),
			@Result(property = "appType", column = "activity_base_app_itype", javaType = short.class, jdbcType = JdbcType.TINYINT),
			@Result(property = "organizer", column = "activity_base_organizer", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "contactPhone", column = "activity_base_phone", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "status", column = "activity_base_status_itype", javaType = short.class, jdbcType = JdbcType.TINYINT),
			@Result(property = "cancleReason", column = "activity_base_cancle_reason", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "logoUrl", column = "activity_pic_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "pictureUrls", column = "activity_pic_urls", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "userGroupId", column = "user_group_base_br_seq", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "couponId", column = "goods_goods_base_bd_seq", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "isNeedNotice", column = "activity_base_notice_itype", javaType = short.class, jdbcType = JdbcType.TINYINT),
			@Result(property = "hasShake", column = "activity_base_shake_itype", javaType = short.class, jdbcType = JdbcType.TINYINT),
			@Result(property = "delayHour", column = "activity_base_delay_cnt", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "authType", column = "mobiz_shop_auth_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "shopShield", column = "mobiz_shop_status_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "creater", column = "create_by", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "createTime", column = "create_time", javaType = Timestamp.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "updater", column = "update_by", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "updateTime", column = "update_time", javaType = Timestamp.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "activeFlag", column = "active_flag", javaType = char.class, jdbcType = JdbcType.CHAR) })
	Activity getActivityBaseById(@Param("id") int id);
	
	/**
	 * 获取活动信息
	 * 
	 * @param activityId
	 * @return
	 */
	@Select("SELECT a.party_activity_base_bd_seq,a.activity_base_topic,a.activity_base_desc,a.activity_pic_url,a.activity_base_status_itype,a.activity_base_organizer, "
			+ " a.party_activity_type_bd_seq,b.activity_type_name,CONCAT(a.activity_base_bdate,' ',a.activity_base_btime) beginTime, "
			+ " CONCAT(a.activity_base_edate,' ',a.activity_base_etime) endTime,a.activity_base_app_itype, "
			+ " c.activity_address_latitude,c.activity_address_longitude,c.activity_address_detail FROM party_activity_base_bd a "
			+ " INNER JOIN party_activity_type_bd b ON a.party_activity_type_bd_seq = b.party_activity_type_bd_seq "
			+ " INNER JOIN party_activity_address_br c ON a.party_activity_base_bd_seq = c.party_activity_base_bd_seq AND "
			+ " a.activity_base_organizer = (CASE WHEN a.activity_base_app_itype in (1,3) THEN a.activity_base_organizer ELSE c.biz_mobiz_shop_bd_seq END) "
			+ " WHERE a.party_activity_base_bd_seq = #{id} AND a.active_flag = 'y' AND a.mobiz_shop_auth_itype = 3 AND a.mobiz_shop_status_itype = 1 "
			+ " AND b.active_flag = 'y' AND c.active_flag = 'y'")
	@Results(value = {
			@Result(property = "id", column = "party_activity_base_bd_seq", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "activityTheme", column = "activity_base_topic", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "activityDesc", column = "activity_base_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "activityPicture", column = "activity_pic_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "activityStatus", column = "activity_base_status_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "createBy", column = "activity_base_organizer", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "activityType", column = "party_activity_type_bd_seq", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "activityTypeName", column = "activity_type_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "activityOrganizerType", column = "activity_base_app_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "latitude", column = "activity_address_latitude", javaType = double.class, jdbcType = JdbcType.DOUBLE),
			@Result(property = "longitude", column = "activity_address_longitude", javaType = double.class, jdbcType = JdbcType.DOUBLE),
			@Result(property = "activityAddress", column = "activity_address_detail", javaType = String.class, jdbcType = JdbcType.VARCHAR) })
	ActivityInfoBo getActivityById(@Param("id") int id);
	
	@Delete("DELETE FROM party_activity_base_bd WHERE party_activity_base_bd_seq = #{id}")
	void deleteActivityById(@Param("id") int id);
}
