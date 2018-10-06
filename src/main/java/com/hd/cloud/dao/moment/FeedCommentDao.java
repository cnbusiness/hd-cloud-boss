package com.hd.cloud.dao.moment;

import java.util.List;

import com.hd.cloud.bo.FeedComment;
import com.hd.cloud.vo.FeedCommentVo;

public interface FeedCommentDao {
	
	
	public List<FeedComment> getFeedCommentList(FeedCommentVo feedCommentVo);
	
	public int getFeedCommentCount(FeedCommentVo feedCommentVo);
}
