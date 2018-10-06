package com.hd.cloud.dao.boss.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.UserBo;
import com.hd.cloud.dao.boss.sql.UserProvider;
import com.hd.cloud.vo.UserAccountVo;

@Mapper
public interface UserMapper {
	
	/**
	 * 
	 * @Title:save
	 * @Description:新增用户
	 * @param createUserVo
	 * @return int
	 */
	@InsertProvider(type = UserProvider.class,method = "save")
	@SelectKey(keyProperty = "userId",before = false,resultType = int.class,statement = {"SELECT LAST_INSERT_ID() AS user_user_base_sb_seq" }) 
	int save(UserBo userBO);
	
	/**
	 * 
	 * @Title:findUserId
	 * @Description:查找用户ID
	 * @param userId
	 * @param password
	 * @return Long
	 */
	@Select("select user_user_base_sb_seq from user_user_base_sb where user_user_base_sb_seq=#{userId} and user_base_password=#{password}")
	@Results(value = {
			@Result(property = "userId", column = "user_user_base_sb_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT) })
	Long findUserId(@Param("userId") long userId, @Param("password") String password);
	
	/**
	 * 
	 * @Title:update
	 * @Description:更新用户信息
	 * @param userBo
	 * @return int
	 */
	@UpdateProvider(type = UserProvider.class,method = "update")
	int update(UserBo userBo);
	
	/**
	 * 
	 * @Title:getUserBoList
	 * @Description:用户列表
	 * @param userAccountVo
	 * @return List<UserBo>
	 */
	@SelectProvider(type=UserProvider.class,method="getUserBoList")
	@Results(value = {
			@Result(property = "userId", column = "user_user_base_sb_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "nickName", column = "user_base_alais_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "phone", column = "user_base_phone", javaType = String.class, jdbcType = JdbcType.VARCHAR),	
			@Result(property = "status", column = "user_base_status_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "sex", column = "user_base_sex_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "birthday" , column = "user_base_birth_date" , javaType= String.class , jdbcType=JdbcType.VARCHAR),
			@Result(property = "vip" , column = "user_base_vip_itype" , javaType= Integer.class , jdbcType=JdbcType.INTEGER),
	})
	List<UserBo> getUserBoList(UserAccountVo userAccountVo);
	
	/**
	 * 
	 * @Title:getUserBoCount
	 * @Description:用户总数
	 * @param userAccountvo
	 * @return Integer
	 */
	@SelectProvider(type = UserProvider.class,method = "getUserBoCount")
	int getUserBoCount(UserAccountVo userAccountvo);
	
	/**
	 * 
	 * @Title:getUserByPhone
	 * @Description:通过电话号码查询
	 * @param phone
	 * @return UserBo
	 */
	@Select("SELECT user_user_base_sb_seq,user_base_alais_name,city_dict_intl_code,user_base_phone,user_base_status_itype,user_base_password,user_base_birth_date FROM user_user_base_sb  WHERE  active_flag='y' AND user_base_phone =#{phone}")
	@Results(value = {
			@Result(property = "userId", column = "user_user_base_sb_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "countryCode", column = "city_dict_intl_code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "nickName", column = "user_base_alais_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "phone", column = "user_base_phone", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "sex", column = "user_base_sex_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "vip" , column = "user_base_vip_itype" , javaType= Integer.class , jdbcType=JdbcType.INTEGER),
			@Result(property = "birthday" , column = "user_base_birth_date" , javaType= String.class , jdbcType=JdbcType.VARCHAR),
			@Result(property = "status", column = "user_base_status_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
			})
	UserBo getUserBoByPhone(@Param("phone") String phone);
	
	/**
	 * 
	 * @Title:getUserBoByUserId
	 * @Description:通过用户ID查询
	 * @param userId
	 * @return UserBo
	 */
	@Select("SELECT user_user_base_sb_seq,city_dict_intl_code,user_base_alais_name,user_base_phone,user_base_status_itype,user_base_birth_date,user_base_sex_itype,user_base_vip_itype,user_base_password FROM user_user_base_sb WHERE  active_flag='y' AND user_user_base_sb_seq=#{userId} ")
	@Results(value = {
			@Result(property = "userId", column = "user_user_base_sb_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "countryCode", column = "city_dict_intl_code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "nickName", column = "user_base_alais_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "phone", column = "user_base_phone", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "status", column = "user_base_status_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "sex", column = "user_base_sex_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "vip" , column = "user_base_vip_itype" , javaType= Integer.class , jdbcType=JdbcType.INTEGER),
			@Result(property = "password", column = "user_base_password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "birthday" , column = "user_base_birth_date" , javaType= String.class , jdbcType=JdbcType.VARCHAR)})
	UserBo getUserBoByUserId(@Param("userId") long userId);
	
//	/**
//	 * 
//	 * @Title:getUserBoByEmail
//	 * @Description:通过邮箱查询
//	 * @param email
//	 * @return UserBo
//	 */
//	@Select("SELECT user_user_base_sb_seq,user_base_alais_name,city_dict_intl_code,user_base_phone,user_base_status_itype,user_base_password,user_base_email FROM user_user_base_sb WHERE  active_flag='y' AND user_base_email =#{email}")
//	@Results(value = {
//			@Result(property = "userId", column = "user_user_base_sb_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
//			@Result(property = "countryCode", column = "city_dict_intl_code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
//			@Result(property = "nickName", column = "user_base_alais_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
//			@Result(property = "phone", column = "user_base_phone", javaType = String.class, jdbcType = JdbcType.VARCHAR),
//			@Result(property = "password", column = "user_base_password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
//			@Result(property = "status", column = "user_base_status_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
//	})
//	UserBo getUserBoByEmail(@Param("email") String email);
	
	/**
	 * 
	 * @Title:updateUserBoListByUserIds
	 * @Description:批量冻结用户
	 * @param userIds
	 * @return List<UserBo>
	 */
	@Update("UPDATE user_user_base_sb SET user_base_status_itype = '3' WHERE user_user_base_sb_seq in (#userIds) AND active_falg = 'y' ")
	List<UserBo> updateUserBoListByUserIds( String userIds);
	
	@UpdateProvider(type = UserProvider.class,method = "freezeStatus")
	int freezeStatus(UserBo userBo);
	
	/**
	 * 
	 * @Title:updateStatus
	 * @Description:修改用户状态
	 * @param userBo
	 * @return int
	 */
	@UpdateProvider(type = UserProvider.class,method = "updateStatus")
	int updateStatus(UserBo userBo);
	
}
