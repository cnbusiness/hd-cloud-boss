package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName RedPacketVo.java
 * @Description 红包发放列表VO
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月14日 下午12:14:05
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RedPacketVo {
	
	private int offset;
	
	private int pageSize;
}
