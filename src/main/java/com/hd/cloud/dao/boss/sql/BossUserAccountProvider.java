package com.hd.cloud.dao.boss.sql;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.bo.BossUserAccount;
import com.hlb.cloud.util.CommonConstantUtil;

public class BossUserAccountProvider {
		
	//保存
	public String save(BossUserAccount bossUserAccount) {
		return new SQL() {
			{
			INSERT_INTO("user_boss_user_sb");
			VALUES("user_base_phone", "#{phone}");
			VALUES("user_base_password", "{password}");
			VALUES("user_base_status_itype","#{status}");
			VALUES("create_by","#{createBy}");
			VALUES("create_time","sysdate");
			VALUES("update_time","sysdate");
			VALUES("active_flag","'"+CommonConstantUtil.ACTIVE_FLAG_Y + "'");
		}
	}.toString();
	}
	
	/**
	 * 
	 * @Title:update
	 * @Description:更改BOSS用户信息
	 * @param bossUserAccount
	 * @return String
	 */
	public String update(final BossUserAccount bossUserAccount) {
		return new SQL(){
			{
				UPDATE("user_boss_user_sb");
				if (bossUserAccount.getPassword() != null) {
				SET("user_base_password = #{password}");
				}
				if(bossUserAccount.getUpdateBy() !=0) {
				SET("update_by = #{updateBy}");
				}
				WHERE("user_boss_user_sb_seq = #{userId}");
			}
		}.toString();
	}
}
