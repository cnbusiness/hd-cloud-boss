package com.hd.cloud.dao.moment.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.Topic;
import com.hd.cloud.dao.moment.HotTopicDao;
import com.hd.cloud.dao.moment.mapper.HotTopicMapper;
import com.hd.cloud.vo.HotTopicVo;

@Repository
public class HotTopicDaoMyBatisImpl implements HotTopicDao{
	
	@Inject
	private HotTopicMapper hotTopicMapper;
	
	@Override
	public List<Topic> getHotTopicBoList(HotTopicVo hotTopicVo){
		return hotTopicMapper.getHotTopicBoList(hotTopicVo);
	}
	
	@Override
	public int getHotTopicBoListCount(HotTopicVo hotTopicVo){
		return hotTopicMapper.getHotTopicBoCount(hotTopicVo);
	}
}
