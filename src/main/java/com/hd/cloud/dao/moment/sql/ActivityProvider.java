package com.hd.cloud.dao.moment.sql;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.vo.ActivityVo;
import com.hd.cloud.vo.CreateActivityVo;
import com.hlb.cloud.util.CommonConstantUtil;

public class ActivityProvider {
	
	/**
	 * 
	 * @Title:getActivityList
	 * @Description:活动列表
	 * @param activityVo
	 * @return String
	 */
	public String getActivityList(ActivityVo activityVo){
		String sql = new SQL(){
			{
				SELECT("activity_base_topic,activity_pic_url,activity_base_status_itype,party_activity_type_bd_seq,pub_city_dict_sd_seq,activity_base_recommend_itype,activity_base_app_itype");
				FROM("party_activity_base_bd");
				WHERE("active_flag = 'y'");
				ORDER_BY("party_activity_base_bd_seq desc limit #{offset},#{pageSize}");
			}
		}.toString();
		return sql ;
	}
	
	/**
	 * 
	 * @Title:getActivityCnt
	 * @Description:总数
	 * @param activityVo
	 * @return String
	 */
	public String getActivityCnt(ActivityVo activityVo){
		String sql = new SQL(){
			{
				SELECT("COUNT(1)");
				FROM("party_activity_base_bd");
				WHERE("active_flag = 'y'");
			}
		}.toString();
		return sql;
	}
	
	/**
	 * 
	 * @Title:createActivity
	 * @Description:创建活动
	 * @param createActivityVo
	 * @return String
	 */
	public String createActivity(CreateActivityVo createActivityVo){
		String sql = new SQL(){
			{
				INSERT_INTO("party_activity_base_bd");
				VALUES("activity_base_app_itype"," #{type}");
				VALUES("activity_base_topic "," #{activityTopic} ");
				VALUES(" activity_base_desc","#{desc}");
				VALUES("activity_base_pic_url ", "#{picUrl} ");
				VALUES("activity_base_contact_itype", "#{contactType} ");
				VALUES(" party_activity_type_bd_seq" ," #{activityType}");
				VALUES("pub_city_dict_sd_seq"," #{city} ");
				VALUES(" activity_base_bdate "," #{begindate}");
				VALUES("activity_base_edate "," #{enddate}");
				VALUES(" activity_base_btime "," #{begintime}");
				VALUES("activity_base_etime "," #{endtime} ");
				VALUES("active_flag","'"+CommonConstantUtil.ACTIVE_FLAG_Y + "'");
			}
		}.toString();
		return sql;
	}
//	
//	public String getActivityById(int activityId){
//		String sql = new SQL(){
//			{
//				SELECT("activity_base_topic,activity_base_pic_url,activity_base_status_itype,party_activity_type_bd_seq,pub_city_dict_sd_seq,activity_base_recommend_itype,activity_base_app_itype");
//				FROM("party_activity_base_bd");
//				WHERE("party_activity_base_bd_seq = #{activityId}");
//			}
//		}.toString();
//		return sql;
//	}
}
