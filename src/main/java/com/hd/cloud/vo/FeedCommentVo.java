package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName FeedCommentVo.java
 * @Description 动态评论VO
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月4日 上午10:46:46
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedCommentVo {
	
	private int offset;
	
	private int pageSize;
}
