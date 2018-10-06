package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName ShopVo.java
 * @Description 店铺列表Vo
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月14日 下午12:13:38
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopVo {
	
	private int pageSize;
	
	private int offset;

}
