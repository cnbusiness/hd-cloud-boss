package com.hd.cloud.dao.moment;

import java.util.List;

import com.hd.cloud.bo.ActivityComment;
import com.hd.cloud.vo.ActivityCommentVo;

public interface ActivityCommentDao {
	
	public List<ActivityComment> getActivityCommentList(ActivityCommentVo activityCommentVo);
	
	public int getActivityCommentCount(ActivityCommentVo activityCommentVo);
}
