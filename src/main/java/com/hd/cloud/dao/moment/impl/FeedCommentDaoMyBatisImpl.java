package com.hd.cloud.dao.moment.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.FeedComment;
import com.hd.cloud.dao.moment.FeedCommentDao;
import com.hd.cloud.dao.moment.mapper.FeedCommentMapper;
import com.hd.cloud.vo.FeedCommentVo;

@Repository
public class FeedCommentDaoMyBatisImpl implements FeedCommentDao{
	
	@Inject
	private FeedCommentMapper feedCommentMapper;
	

	@Override
	public List<FeedComment> getFeedCommentList(FeedCommentVo feedCommentVo) {
		// TODO Auto-generated method stub
		return feedCommentMapper.getFeedCommentList(feedCommentVo);
				
	}

	@Override
	public int getFeedCommentCount(FeedCommentVo feedCommentVo) {
		// TODO Auto-generated method stub
		return feedCommentMapper.getFeedCommentCount(feedCommentVo);
	}

}
