package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName AdvertVo.java
 * @Description 广告列表VO
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月3日 上午9:56:46
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertVo {
	
	private String title;//广告标题
	
	private int status;//状态
	
	private int adModuleId;//广告模块Id
	
	private int offset;
	
	private int pageSize;
}
