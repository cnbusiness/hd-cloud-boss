package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdVo {
	
	private int id;
	
	//广告标题
	private String title;
	
	//广告描述
	private String desc;
	
	//图片链接
	private String picUrl;
	
	private int statusItype;
	
	//连接类型
	private int linkItype;
	
	//跳转链接
	private String linkUrl;
	
	//app跳转模块Id
	private int linkId;
	
	//广告模块Id
	private int adModuleId;
	
	//展示级别
	private short showType;
	
	//点击是否 统计
	private int clickItype;
	
	//国家简码
	private String countryCode;
	
	//城市Id
	private int cityId;
	
	private String activeFlag;
	
	private int updater;
}
