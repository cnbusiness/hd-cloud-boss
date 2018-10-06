package com.hd.cloud.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName BossUserAccount.java
 * @Description boss用户信息
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年4月25日 上午11:04:24
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BossUserAccount {
	

	private long userId;
	
	//手机号
	private String phone;
	
	//密码
	private String password;
	
	//状态：1.正常，2.待激活，3.冻结
	private int status;
	
	private long createBy;
	
	private String createTime;
	
	private long updateBy;
	
	private String updateTime;
	
	private String activeFlag;
	
	
}
