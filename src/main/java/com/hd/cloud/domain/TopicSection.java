package com.hd.cloud.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
  * @ClassName: TopicSection
  * @Description: 话题实体
  * @author yaojie yao.jie@hadoop-tech.com
  * @Company hadoop-tech
  * @date 2018年6月20日 上午10:03:46
  *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicSection {
	
	// 话题id
	private long id;
	// 话题名称
	private String topicName;
	// 话题简介
	private String topicDesc;
	// 图标URL
	private String topicUrl;
	// topic背景
	private String backgroudUrl;
	// 首页url
	private String homeUrl;
	// 排序
	private int sort;
	// 是否是精选池标识,1是2不是
	private int displayType;
	// 国家简码
	private String countryCode;
	// 审核状态,1通过2不通过
	private int checkStatus;
	// 话题创建者id
	private long mxUserId;
	// 创建来源，1魔线用户;3后台
	private int createSource;
	// 创建来源
	private String sourceType;
	// 点赞数
	private long favoriteCnt;
	// 总动态数量
	private long reviewCnt;
	// 浏览量
	private long browseCnt;
	// 收藏量
	private String storeCnt;
	// 热度
	private double degree;
	// 是否置顶,1是2否
	private int isTop;
	// 置顶时间
	private Date topDate;
	//动态总评论数
	private long commentCnt;
	// 创建人
	private long createBy;
	// 创建时间
	private Date createTime;
	// 创建时间
	private String createTimeStr;
	// 更新人
	private long updateBy;
	// 更新时间
	private Date updateTime;
	// 标识
	private String active = "y";
	// 首页推荐 1 是 2 不是
	private int isHome;
	//图片域名
	private String domain;
}
