package com.hd.cloud.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName AdAdress.java
 * @Description 广告地址基础信息
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月21日 上午9:53:17
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdAdress {
	
	private int id;//主键
	
	private int adId;//广告Id
	
	private int adModuleId;//广告模块Id
	
	private int cityId;//广告关联城市
	
	public int order;//排序
	
	public String countryCode;//国家码
	
	public int showType;//展示级别：1.城市；2.国家；3.默认
	
	private long creater;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	private long updater;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	private String activeFlag;
}
