package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName UpdateBossUserPwdVo.java
 * @Description BOSS密码修改
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月14日 下午12:13:12
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBossUserPwdVo {
	
	/**
	 * 用户ID
	 */
	private long userId;

	/**
	 * 原密码
	 */
	private String oldPassword;

	/**
	 * 新密码
	 */
	private String newPassword;

	/**
	 * 确认密码
	 */
	private String rePassword;

}
