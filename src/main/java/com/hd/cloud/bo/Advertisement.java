package com.hd.cloud.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName Advertisement.java
 * @Description 广告基础信息
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月3日 上午9:47:38
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Advertisement {
	
	private int id;//主键id
	
	private int adModuleId;//广告ID
	
	private String adModuleName;//广告模块
	
	private int internalCode;//内码
	
	private String countryCode;//国家简码
	
	private String title;//广告标题
	
	private String desc;//广告描述
	
	private String picUrl;//图片链接
	
	private int linkItype;//1.内部跳转，2.url跳转
	
	private String linkUrl;//跳转地址
	
	private int linkId;//app内部跳转模块ID
	
	private int fileItype;//1为图片 ，2为文字，3.为flash等
	
	private int validItype;//1永久有效 2 时间段内有效
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date validBtime;//有效起始时间 
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date validEtime;//有效结束时间
	
	private int clickItype;//点击是否统计
	
	private int statusItype;//状态，1.待上架 2上架，3.下架
	
	private int viewCnt;//浏览量
	
	private int clickCnt;//点击量
	
	private long creater;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	private long updater;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	private long uploader;//最近文件上传人
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date uploadTime;//最近文件上传时间

	private String activeFlag;
	
	
}
