package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName ShopFansVo.java
 * @Description 店铺粉丝Vo
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月14日 下午12:13:54
 *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopFansVo {
	
	private int offset;
	
	private int pageSize;
}
