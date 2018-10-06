package com.hd.cloud.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName CreateUserVo.java
 * @Description 新增用户
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年4月16日 下午4:21:46
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserVo {
	
	/**
	 * 昵称
	 */
	private String nickName;
	
	/**
	 * 性别
	 */
	private int sex;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 国家码
	 */
	private String countryCode;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 是否为VIP
	 */
	private int vip;
	
	/**
	 * 出生年月
	 */
	private String birthday;
}
