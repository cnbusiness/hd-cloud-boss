package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName UserFreezeVo.java
 * @Description 批量冻结用户
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月14日 下午12:12:17
 *
 */
@SuppressWarnings("deprecation")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFreezeVo {
		
	private String userIds;
}
