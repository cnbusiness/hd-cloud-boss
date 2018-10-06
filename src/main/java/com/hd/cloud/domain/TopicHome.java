package com.hd.cloud.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
  * @ClassName: TopicHome
  * @Description: 首页话题
  * @author yaojie yao.jie@hadoop-tech.com
  * @Company hadoop-tech
  * @date 2018年6月20日 上午11:22:03
  *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicHome {
	// 首页话题主键id
	private long topicHomeId;
	// 城市id
	private long cityId;
	// 国家简码
	private String countryCode;
	// 话题id
	private long topicId;
	// 排序
	private long sort;
	// 创建人
	private long createBy;
	// 创建时间
	private Date createTime;
	// 更新人
	private long updateBy;
	// 更新时间
	private Date updateTime;
	// 标识
	private String active = "y";

}
