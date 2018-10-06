package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@SuppressWarnings("deprecation")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedPostVo {
	
	private int offset;
	
	private int pageSize;
	
	private String content;
	
	private int dispalyType;
}
