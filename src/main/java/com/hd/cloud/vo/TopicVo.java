package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName TopicVo.java
 * @Description 话题列表VO
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月14日 下午12:13:28
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicVo {
	
	// 话题主题
	private String topicName;

	// 话题来源，1魔线用户;3后台
	private int createSource;

	private int offset;

	private int pageSize;
}