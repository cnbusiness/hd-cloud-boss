package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.ActivityComment;
import com.hd.cloud.vo.ActivityCommentVo;

public interface ActivityCommentService {
	
	public List<ActivityComment> getActivityCommentList(ActivityCommentVo activityCommentVo);
	
	public int getActivityCommentCount(ActivityCommentVo activityCommentVo);
}
