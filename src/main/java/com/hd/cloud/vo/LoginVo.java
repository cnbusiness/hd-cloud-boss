package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName: AdminLoginVo
 * @Description: 登录vo
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2017年11月23日 下午4:42:26
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginVo {

	/**
	 * 用户账号（手机号或邮箱）
	 */
	private String account;

	/**
	 * 用户密码
	 */
	private String password;
	


}
