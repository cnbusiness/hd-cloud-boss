package com.hd.cloud.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName UserToken.java
 * @Description token
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年4月25日 上午11:03:53
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserToken {
	
	private int tokenId;
	
	private long userId;
	
	private int appType;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tokenValidDate;
	
	private String token;
	
	private long createBy;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
	private Date Createtime;
	
	private long updateBy;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatetime;
	
	private String activeFlag;
	
}
