package com.hd.cloud.dao.moment;

import java.util.List;

import com.hd.cloud.bo.Topic;
import com.hd.cloud.vo.HotTopicVo;

public interface HotTopicDao {
	
	/**
	 * 
	 * @Title:getHotTopicBoList
	 * @Description:热门话题列表
	 * @param hotTopicVo
	 * @return List<TopicBo>
	 */
	public List<Topic> getHotTopicBoList(HotTopicVo hotTopicVo);
	
	/**
	 * 
	 * @Title:getHotTopicBoListCount
	 * @Description:热门话题列表总数
	 * @param hotTopicVo
	 * @return int
	 */
	public int getHotTopicBoListCount(HotTopicVo hotTopicVo);
}
