package com.hd.cloud.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName ActivityComment.java
 * @Description 活动评论
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月4日 下午3:21:06
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityComment {
	
	private int id;//主键ID
	
	private int activityId;//活动ID
	
	private long commentId;//评论者ID，店铺的话则是店铺ID，用户则为用户ID
	
	private long parentId;//评论的上级ID，1.评论活动的则为活动ID，2.评论用户则为用户id，3.评论店铺的则为店铺ID
	
	private String commentContent;//评论内容
	
	private int commentItype;//评论类型：1是对活动的评论，2.是对用户评论进行的评论，3.评论店铺
	
	private String picUrl;//评论图片，多个图片是用|分隔
	
	private int appItype;//版本来源：1.用户，2.商家
	
	private int statusItype;//状态，1.正常，2.屏蔽，3.关闭
	
	private long creater;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	private long updater;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	private String activeFlag;
	
}
