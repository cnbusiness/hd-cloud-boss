package com.hd.cloud.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.Topic;
import com.hd.cloud.dao.moment.HotTopicDao;
import com.hd.cloud.service.HotTopicService;
import com.hd.cloud.vo.HotTopicVo;

@Service
public class HotTopicServiceImpl implements HotTopicService{

	@Inject
	private HotTopicDao hotTopicDao;
	
	@Override
	public List<Topic> getHotTopicBoList(HotTopicVo hotTopicVo) {
		return hotTopicDao.getHotTopicBoList(hotTopicVo);
	}

	@Override
	public int getHotTopicBoCount(HotTopicVo hotTopicVo) {
		// TODO Auto-generated method stub
		return hotTopicDao.getHotTopicBoListCount(hotTopicVo);
	}
	
}
