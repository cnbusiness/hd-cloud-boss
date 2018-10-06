package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName HotTopicVo.java
 * @Description 热门话题Vo
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月14日 下午12:14:49
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotTopicVo {
	
	private int offset;
	
	private int pageSize;
}