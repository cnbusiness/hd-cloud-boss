package com.hd.cloud.dao.boss.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.BossUserAccount;
import com.hd.cloud.dao.boss.sql.BossUserAccountProvider;

@Mapper
public interface BossUserAccountMapper {
	

	/**
	 * 
	 * @Title:save
	 * @Description:保存
	 * @param payUserAccount
	 * @return int
	 */
	@InsertProvider(type = BossUserAccountProvider.class, method = "save")
	int save(BossUserAccount bossUserAccount);
	
	@Select("SELECT user_boss_user_seq,user_base_phone,user_base_password,user_base_status_itype from user_boss_user_sb where user_boss_user_sb_seq=#{userId} AND active_flag='y'")
	@Results(value = {
			@Result(property = "UserId", column = "user_boss_user_sb_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "phone", column = "user_base_phone", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "password", column = "user_base_password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "status", column = "user_base_status_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER)})
	BossUserAccount getBossUserAccountById(@Param("userId") long userId);
	
	@UpdateProvider(type = BossUserAccountProvider.class,method = "update")
	int update(BossUserAccount bossUserAccount);
	
	@Select("select user_boss_user_sb_seq from user_user_base_sb where user_boss_user_sb_seq=#{userId} and user_base_password=#{userPassword}")
	@Results(value = {
			@Result(property = "userId", column = "user_boss_user_sb_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT) })
	Long findUserId(@Param("userId") long userId, @Param("userPassword") String userPassword);
}
