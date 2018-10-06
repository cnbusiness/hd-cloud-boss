package com.hd.cloud.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.dao.moment.TopicDao;
import com.hd.cloud.domain.TopicHome;
import com.hd.cloud.domain.TopicSection;
import com.hd.cloud.service.TopicService;
import com.hd.cloud.vo.TopicVo;

@Service
public class TopicServiceImpl implements TopicService{
	
	@Inject
	private TopicDao topicDao;

	@Override
	public List<TopicSection> getTopicSectionList(TopicVo topicVo) {
		return topicDao.getTopicSectionList(topicVo);
	}

	@Override
	public Integer getTopicSectionCount(TopicVo topicVo) {
		return topicDao.getTopicSectionCount(topicVo);
	}

	@Override
	public int save(TopicSection topicSection) {
		return topicDao.save(topicSection);
	}

	@Override
	public int update(TopicSection topicSection) {
		return topicDao.update(topicSection);
	}

	@Override
	public TopicSection findById(long id) {
		return topicDao.findById(id);
	}

	@Override
	public int getTopicCountByTopicName(String topicName,long id) {
		return topicDao.getTopicCountByTopicName(topicName,id);
	}

	@Override
	public int saveTopicHome(TopicHome topicHome) {
		return topicDao.saveTopicHome(topicHome);
	}

	@Override
	public int getCountByTopicId(long topicId) {
		return topicDao.getCountByTopicId(topicId);
	}

	@Override
	public int deleteTopicHome(long topicId) {
		return topicDao.deleteTopicHome(topicId);
	}


}
