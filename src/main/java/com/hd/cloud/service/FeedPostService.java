package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.PicBo;
import com.hd.cloud.domain.FeedPost;
import com.hd.cloud.vo.FeedPostVo;

public interface FeedPostService {
	
	public List<FeedPost> getFeedList(FeedPostVo feedVo);
	
	public int getFeedCount(FeedPostVo feedVo);
	
	public int shieldPost(FeedPost feedPost);
	
	public FeedPost findById(long id);
	
	public List<PicBo> getFeedPictures(long id);

}
