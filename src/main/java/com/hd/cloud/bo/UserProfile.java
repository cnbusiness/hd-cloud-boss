package com.hd.cloud.bo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName: UserProfile
 * @Description: 用户基础信息
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月8日 下午3:13:04
 *
 */

@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile implements Serializable {

	// 用户id
	private long userId;

	// 用户昵称
	private String nickName;

	// 性别
	private int sex;

	// 用户状态
	private int status;

	// 是否屏蔽动态
	private int feedStatus;

	// 国家区号 86
	private String countryCode;

	// 手机号码
	private String phone;

	// 生日
	private String birthday;

	// ASCS
	private double ascCoin;

	// 冻结ASCS
	private double freezeAscCoin;

	// 游戏点
	private int gameAmout;

	// 头像
	private String avatar;
}
