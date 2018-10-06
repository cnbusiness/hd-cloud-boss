package com.hd.cloud.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
  * @ClassName: PicBo
  * @Description: 图片
  * @author yaojie yao.jie@hadoop-tech.com
  * @Company hadoop-tech
  * @date 2018年6月22日 下午3:36:41
  *
 */
@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PicBo {

	/** 图片主键 **/
	private String id;

	/** 图片url **/
	private String picUrl;

}
