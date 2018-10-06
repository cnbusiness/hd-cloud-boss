package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName ActivityVo.java
 * @Description 活动列表Vo
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月14日 下午12:15:43
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityVo {
	
	private int pageSize;
	
	private int offset;
}
