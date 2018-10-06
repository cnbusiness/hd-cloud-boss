package com.hd.cloud.dao.moment.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.PicBo;
import com.hd.cloud.dao.moment.FeedDao;
import com.hd.cloud.dao.moment.mapper.FeedPostMapper;
import com.hd.cloud.domain.FeedPost;
import com.hd.cloud.vo.FeedPostVo;

@Repository
public class FeedDaoMyBatisImpl implements FeedDao{
	
	@Inject
	public FeedPostMapper feedMapper;

	@Override
	public List<FeedPost> getFeedList(FeedPostVo feedVo) {
		return feedMapper.getFeedList(feedVo);
	}

	@Override
	public int getFeedCount(FeedPostVo feedVo) {
		return feedMapper.getFeedCount(feedVo);
	}

	@Override
	public int shieldPost(FeedPost feedPost) {
		return feedMapper.shield(feedPost);
	}

	@Override
	public FeedPost findById(long id) {
		return feedMapper.findById(id);
	}

	@Override
	public List<PicBo> getFeedPictures(long id) {
		return feedMapper.getFeedPictures(id);
	}
	

}
