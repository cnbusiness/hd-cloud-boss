package com.hd.cloud.vo;

import java.sql.Timestamp;

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
public class CreateAdModuleVo {
	
	// 广告模块名
	private String moduleName;
	// 广告模块描述或备注
	private String moduleRemark;
	// 最大广告数
	private int bannerTotals;
	// 1 手机端banner 广告，2 app推荐模块
	private int type;
	// banner索引标示符
	private String BannerCode;
	//1.永久有效 2.有段时间有效
	private int validType;
	// 仅对启动页有效
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp pageStartTime;

	// 仅对启动页有效
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp pageEndTime;

	// 创建者
	private int createBy;

	// 创建时间
	private Timestamp createTime;
}
