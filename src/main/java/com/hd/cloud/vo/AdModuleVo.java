package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdModuleVo {
	
	private int offset;
	
	private int pageSize;
}
