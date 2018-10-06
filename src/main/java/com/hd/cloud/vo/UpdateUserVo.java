package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserVo {
	
	private int userId;
	
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
	private int vipType;
	
	/**
	 * 出生年月
	 */
	private String birthday;
	
	/**
	 * 状态：1.正常；2.待激活；3.冻结
	 */
	private int status;
}
