package com.hd.cloud.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName UserBo.java
 * @Description 用户基础信息
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年4月25日 上午11:03:42
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBo {
	
	// 用户id
	private long userId;

	// 昵称
	private String nickName;

	// 性别，1男2女
	private int sex;

	// 用户的状态，1正常 2待激活3冻结
	private int status;
	
	// 是否屏蔽动态
	private int feedStatus;

	// 国家区号 86
	private String countryCode;

	// 国际区号+手机号
	private String phone;

	// 密码
	private String password;
	
	//是否为VIP：1.是；2.否
	private int vip;
	
	//生日
	private String birthday;
	
	// ASCS
	private double ascCoin;

	// 冻结ASCS
	private double freezeAscCoin;

	// 游戏点
	private int gameAmout;

	// 头像
	private String avatar;

	// ynd
	private String activeFlag;

	private long createBy;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	private long updateBy;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
}
