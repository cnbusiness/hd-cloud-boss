package com.hd.cloud.dao.moment.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.dao.moment.TopicDao;
import com.hd.cloud.dao.moment.mapper.TopicMapper;
import com.hd.cloud.domain.TopicHome;
import com.hd.cloud.domain.TopicSection;
import com.hd.cloud.vo.TopicVo;

@Repository
public class TopicDaoMyBatisImpl implements TopicDao{
	
	@Inject
	private TopicMapper topicMapper;

	@Override
	public List<TopicSection> getTopicSectionList(TopicVo topicVo) {
		return topicMapper.getTopicSectionList(topicVo);
	}

	@Override
	public Integer getTopicSectionCount(TopicVo topicVo) {
		return topicMapper.getTopicSectionCount(topicVo);
	}

	@Override
	public int save(TopicSection topicSection) {
		return topicMapper.save(topicSection);
	}

	@Override
	public int update(TopicSection topicSection) {
		return topicMapper.update(topicSection);
	}

	@Override
	public TopicSection findById(long id) {
		return topicMapper.findById(id);
	}

	@Override
	public int getTopicCountByTopicName(String topicName,long id) {
		return topicMapper.getTopicCountByTopicName(topicName,id);
	}

	@Override
	public int saveTopicHome(TopicHome topicHome) {
		return topicMapper.saveTopicHome(topicHome);
	}

	@Override
	public int getCountByTopicId(long topicId) {
		return topicMapper.getCountByTopicId(topicId);
	}

	@Override
	public int deleteTopicHome(long topicId) {
		return topicMapper.deleteTopicHome(topicId);
	} 
	
}
