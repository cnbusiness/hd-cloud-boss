package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.domain.TopicHome;
import com.hd.cloud.domain.TopicSection;
import com.hd.cloud.vo.TopicVo;

/**
 * 
 * @ClassName TopicService.java
 * @Description 全部话题管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年4月24日 下午4:03:19
 *
 */
public interface TopicService {

	// 话题列表
	List<TopicSection> getTopicSectionList(TopicVo topicVo);

	// 话题总数
	Integer getTopicSectionCount(TopicVo topicVo);

	// 创建话题
	int save(TopicSection topicSection);

	// 编辑话题
	int update(TopicSection topicSection);

	// 话题详情
	TopicSection findById(long id);
	
	//验证话题是否存在
	int getTopicCountByTopicName(String topicName,long id);
	
	//创建首页话题
	int saveTopicHome(TopicHome topicHome);
	
	// 验证首页是否已推荐 
	int getCountByTopicId(long topicId);
	
	//删除首页推荐
	int deleteTopicHome(long topicId);

}
