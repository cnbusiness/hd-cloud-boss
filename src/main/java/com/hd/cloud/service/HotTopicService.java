package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.Topic;
import com.hd.cloud.vo.HotTopicVo;

public interface HotTopicService {
	
	/**
	 * 
	 * @Title:getTopicBoList
	 * @Description:热门话题列表
	 * @param hotTopicVo
	 * @return List<Topic>
	 */
	public List<Topic> getHotTopicBoList(HotTopicVo hotTopicVo);
	
	/**
	 * 
	 * @Title:getHotTopicBoCount
	 * @Description:热门话题列表总数
	 * @param hotTopicVo
	 * @return int
	 */
	public int getHotTopicBoCount(HotTopicVo hotTopicVo);
}
