package com.hd.cloud.bo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedReport {
	
	private long id;//主键ID
	
	private String content;//举报内容
	
	private long feedId;//动态ID
	
	private String reportTypeIds;//举报类型ID
	
	private long userId;//举报用户主id
	
	private int reportSourceId;//举报来源，1.用户2商家
	
	private int reportDealItype;//处理状态，1.已处理2.未处理
	
	private int reportAgreeItype;//处理结果1.已通过2.未通过
	
	private String feedBack;//处理意见
	
	private int reportDoId;// 处理方式id

	private long creater;

	private Timestamp createTime;

	private long updater;

	private Timestamp updateTime;

	private char activeFlag;
}
