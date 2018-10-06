package com.hd.cloud.dao.boss.sql;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.bo.UserBo;
import com.hd.cloud.util.StringUtil;
import com.hd.cloud.vo.UserAccountVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserProvider {
	
	/**
	 * 
	 * @Title:getUserBoList
	 * @Description:用户列表
	 * @param userAccountVo
	 * @return String
	 */
	public String getUserBoList(UserAccountVo userAccountVo){
		String sql = new SQL(){
			{
				SELECT("user_user_base_sb_seq,user_base_alais_name,user_base_sex_itype,user_base_status_itype,user_base_phone,user_base_sex_itype,user_base_vip_itype,user_base_birth_date");
				FROM("user_user_base_sb");
				WHERE("active_flag = 'y'");
				if(userAccountVo.getUserId() != 0){
					AND();
					WHERE("user_user_base_sb_seq=#{userId}");
				}
				if(!StringUtil.isBlank(userAccountVo.getNickName())){
					AND();
					WHERE("user_base_alais_name LIKE CONCAT('%',#{nickName},'%')");
				}
				if(!StringUtil.isBlank(userAccountVo.getPhone())){
					AND();
					WHERE("user_base_phone LIKE CONCAT('%',#{phone},'%')");
				}
				ORDER_BY("user_user_base_sb_seq desc limit #{offset},#{pageSize}");
			}
		}.toString();
		return sql;
	}
	
	public String getUserBoCount(UserAccountVo userAccountVo){
		String sql = new SQL(){
			{
				SELECT("COUNT(1)");
				FROM("user_user_base_sb");
				WHERE("active_flag = 'y'");
				if(userAccountVo.getUserId() != 0){
					AND();
					WHERE("user_user_base_sb_seq=#{userId}");
				}
				if(!StringUtil.isBlank(userAccountVo.getNickName())){
					AND();
					WHERE("user_base_alais_name LIKE CONCAT('%',#{nickName},'%')");
				}
				if(!StringUtil.isBlank(userAccountVo.getPhone())){
					AND();
					WHERE("user_base_phone LIKE CONCAT('%',#{phone},'%')");
				}
			}
		}.toString();
		return sql;
	}
	
	/**
	 * 
	 * @Title: save
	 * @param:
	 * @Description: 保存
	 * @return String
	 */
	public String save(UserBo userBo) {
		String sql = new SQL() {
			{
				INSERT_INTO("user_user_base_sb");
				VALUES("user_base_alais_name", "#{nickName}");
				VALUES("user_base_sex_itype", "#{sex}");
				VALUES("user_base_status_itype", "#{status}");
				VALUES("city_dict_intl_code", "#{countryCode}");
				VALUES("user_base_phone", "#{phone}");
				VALUES("user_base_password", "#{password}");
				VALUES("user_base_vip_itype","#{vip}");
				VALUES("user_base_birth_date","#{birthday}");
				VALUES("create_time", "now()");
				VALUES("create_by", "#{createBy}");
				VALUES("active_flag", "#{activeFlag}");
			}
		}.toString();
		log.info("############sql:{}",sql);
		return sql;
	}

	/**
	 * 
	 * @Title: updateUser
	 * @param:
	 * @Description: 更新用户基本信息
	 * @return String
	 */
	public String update(final UserBo userBo) {
		return new SQL() {
			{
				UPDATE("user_user_base_sb");
				if (userBo.getPhone() != null) {
					SET("user_base_phone = #{phone},user_base_status_itype=#{status}");
				}
				if (userBo.getNickName() != null) {
					SET("user_base_alais_name = #{nickName}");
				}
				
				if(userBo.getSex()>0) {
					SET("user_base_sex_itype = #{sex}");
				}
				if(userBo.getBirthday()!=null){
					SET("user_base_birth_date = #{birthday}");
				}
				if (userBo.getPassword() != null) {
					SET("user_base_password = #{password}");
				}
				SET("update_by = #{updateBy}");
				SET("update_time =now()");
				WHERE("user_user_base_sb_seq = #{userId}");
			}
		}.toString();
	}
	
	public String freezeStatus(UserBo userBo){
		return new SQL(){
			{
				UPDATE("user_user_base_sb");
				SET("user_base_status_itype='3'");
				WHERE("user_user_base_sb_seq=#{userId}");
			}
		}.toString();
	}
	
	
	/**
	 * 
	 * @Title:updateStatus
	 * @Description:冻结或解冻用户
	 * @param userBo
	 * @return String
	 */
	public String updateStatus(UserBo userBo) {
		return new SQL(){
			{
				UPDATE("user_user_base_sb");
				if(userBo.getStatus()==3){
				SET("user_base_status_itype = '1'");}
				if(userBo.getStatus()==1){
				SET("user_base_status_itype = '3'");
				}
				WHERE("user_user_base_sb_seq = #{userId}");
			}
		}.toString();
	}

}
