package com.hd.cloud.dao.boss.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.BossUserAccount;

@Mapper
public interface AuthMapper {
		
	/**
	 * 
	 * @Title:login
	 * @Description:用户登录userId与密码验证
	 * @param userId
	 * @param userPassword
	 * @return Long
	 */
	@Select("select user_boss_user_sb_seq from user_boss_user_sb where user_boss_user_sb_seq=#{userId} and user_base_password=#{userPassword} AND active_flag='y' ")
	@Results(value = {
			@Result(property = "userId", column = "user_boss_user_sb_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT) })
	Long login(@Param("userId") long userId, @Param("userPassword") String userPassword);
	
	/**
	 * 
	 * @Title:getIdByPhone
	 * @Description:根据phone查询用户ID
	 * @param phone
	 * @return BossUserAccount
	 */
	@Select("select user_boss_user_sb_seq,user_base_status_itype from user_boss_user_sb where user_base_phone=#{phone} AND active_flag='y'")
	@Results(value = {
			@Result(property = "userId", column = "user_boss_user_sb_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT) ,
			@Result(property = "status", column = "user_base_status_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER)})
	BossUserAccount getIdByPhone(@Param("phone") String phone);
	
	/**
	 * 
	 * @Title:getUserById
	 * @Description:查询用户详情
	 * @param userId
	 * @return BossUserAccount
	 */
	@Select("select user_boss_user_sb_seq,user_base_phone,user_base_password,user_base_status_itype from user_boss_user_sb where active_flag='y' and user_boss_user_sb_seq = #{userId} limit 1")
	@Results(value = {
			@Result(property = "userId", column = "user_boss_user_sb_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "phone", column = "user_base_phone", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "password", column = "user_base_password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "status", column = "user_base_status_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER) })
	BossUserAccount getUserById(long userId);

}
