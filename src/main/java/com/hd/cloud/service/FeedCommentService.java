package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.FeedComment;
import com.hd.cloud.vo.FeedCommentVo;

public interface FeedCommentService {
	
	public List<FeedComment> getFeedCommentList(FeedCommentVo feedCommentVo);
	
	public int getFeedCommentCount(FeedCommentVo feedCommentVo);
}
