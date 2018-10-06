package com.hd.cloud.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.PicBo;
import com.hd.cloud.dao.moment.FeedDao;
import com.hd.cloud.domain.FeedPost;
import com.hd.cloud.service.FeedPostService;
import com.hd.cloud.vo.FeedPostVo;

@Service
public class FeedPostServiceImpl implements FeedPostService{
	
	@Inject
	public FeedDao feedDao;

	@Override
	public List<FeedPost> getFeedList(FeedPostVo feedVo) {
		return feedDao.getFeedList(feedVo);
	}

	@Override
	public int getFeedCount(FeedPostVo feedVo) {
		return feedDao.getFeedCount(feedVo);
	}

	@Override
	public int shieldPost(FeedPost feedPost) {
		return feedDao.shieldPost(feedPost);
	}

	@Override
	public FeedPost findById(long id) {
		return feedDao.findById(id);
	}

	@Override
	public List<PicBo> getFeedPictures(long id) {
		return feedDao.getFeedPictures(id);
	}
	
	
}
