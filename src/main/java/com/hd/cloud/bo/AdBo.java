package com.hd.cloud.bo;

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
public class AdBo {
	
	private int id;
	private String title;//标题
	private String desc;//备注或内容
	private String picUrl;//图片链接
	private int linkItype;//链接类型
	private String linkUrl;//跳转链接
	private int statusItype;//状态1.待上架；2.上架；3.下架
	private String countryCode;//国家简码
	private int adModuleId;//广告模块Id
	private int cityId;//城市Id
	private int showType;
	private int clickItype;//点击是否统计
	private int validItype;//1永久有效 2 时间段内有效
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date validBtime;//有效起始时间  	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date validEtime;//有效结束时间
	private int viewCnt;//浏览量
	private int clickCnt;//点击量
}
