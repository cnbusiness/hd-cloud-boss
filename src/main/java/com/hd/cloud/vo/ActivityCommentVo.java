package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName ActivityCommentVo.java
 * @Description 活动评论Vo
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月14日 下午12:16:22
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityCommentVo {
	
	private int offset;
	
	private int pageSize;
}
