package com.hd.cloud.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName FeedComment.java
 * @Description 动态评论
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月4日 上午10:42:14
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedComment {
	
	private int id;//主键id
	
	private String commentContent;//动态内容
	
	private int commentId;//回复评论ID
	
	private int feedId;//动态ID
	
	private long userId;//用户id
	
	private int statusItype;//状态1.正常，2.屏蔽，3.关闭
	
	private long creater;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	private long updater;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	private String activeFlag;
}
