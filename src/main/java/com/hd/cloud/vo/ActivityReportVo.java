package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName ActivityReportVo.java
 * @Description 活动举报列表Vo
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月14日 下午12:16:10
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityReportVo {
	
	private int offset;
	
	private int pageSize;
}
