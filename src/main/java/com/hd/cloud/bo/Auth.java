package com.hd.cloud.bo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Auth implements Serializable{
	/**
	 * 主键
	 */
	private long id ;
	
	//用户userId
	private long userId ;
	
	//登录后生成的token
	private String token;
	
	//token的生成时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date authTime;
}
