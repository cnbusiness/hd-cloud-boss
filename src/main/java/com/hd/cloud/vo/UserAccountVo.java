package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName UserAccountVo.java
 * @Description 用户列表VO
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月14日 下午12:12:40
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountVo {
	
	private int userId;
	
	private String nickName;
	
	private String phone;
	
	private int offset;
	
	private int pageSize;
}
