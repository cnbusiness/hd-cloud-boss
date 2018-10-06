package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName CreateActivityVo.java
 * @Description 创建活动Vo
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月14日 下午12:15:11
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateActivityVo {
	
	private long userId;
	private String pictureUrls;// 活动图片
	private String theme;// 活动主题
	private long startTime;// 活动开始时间
	private long endTime;// 活动结束时间
	private String address;// 活动地址
	private int cityId;// 活动城市Id
	private double latitude;// 经度
	private double longitude;// 纬度
	private String detail;// 活动详情
	private int userGroupId;// 活动群组Id
	private int activityTypeId;// 活动类型Id
	private int isNeedPhone;// 活动报名是否需要填写手机号码 1.是 2.否
}
