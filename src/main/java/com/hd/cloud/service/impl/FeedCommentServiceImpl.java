package com.hd.cloud.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.FeedComment;
import com.hd.cloud.dao.moment.FeedCommentDao;
import com.hd.cloud.service.FeedCommentService;
import com.hd.cloud.vo.FeedCommentVo;

@Service
public class FeedCommentServiceImpl implements FeedCommentService{
	
	@Inject
	private FeedCommentDao feedCommentDao;
	
	
	@Override
	public List<FeedComment> getFeedCommentList(FeedCommentVo feedCommentVo) {
		// TODO Auto-generated method stub
		return feedCommentDao.getFeedCommentList(feedCommentVo);
	}

	@Override
	public int getFeedCommentCount(FeedCommentVo feedCommentVo) {
		// TODO Auto-generated method stub
		return feedCommentDao.getFeedCommentCount(feedCommentVo);
	}

}
