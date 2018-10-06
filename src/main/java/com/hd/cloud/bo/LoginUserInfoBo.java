package com.hd.cloud.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName: LoginUserInfoBo
 * @Description: 登录用户信息
 * @author Shenghaohao sheng.haohao@moxiangroup.com
 * @Company moxian
 * @date 2017年5月15日 下午2:37:35
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserInfoBo {
	// 登陆用户名
	private String loginName;
	// 用户userId
	private long userId;
	// 登录后生成的token
	private String token; 
	
	private String url;
}
