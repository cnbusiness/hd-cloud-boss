package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName OrderGoodsVo.java
 * @Description 订单交易Vo
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月14日 下午12:14:26
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderGoodsVo {
	
	private int offset;
	
	private int pageSize;
}
