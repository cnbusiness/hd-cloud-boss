package com.hd.cloud.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;


/**
 * 
 * @ClassName UpdateUserPwdVo.java
 * @Description 重置用户密码
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月14日 下午12:12:56
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUserPwdVo {
	
	private int userId;
			
	private String newPassword;
	
	private String rePassword;
	
}
