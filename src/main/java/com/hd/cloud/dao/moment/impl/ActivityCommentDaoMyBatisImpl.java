package com.hd.cloud.dao.moment.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.ActivityComment;
import com.hd.cloud.dao.moment.ActivityCommentDao;
import com.hd.cloud.dao.moment.mapper.ActivityCommentMapper;
import com.hd.cloud.vo.ActivityCommentVo;

@Repository
public class ActivityCommentDaoMyBatisImpl implements ActivityCommentDao{
	
	@Inject
	private ActivityCommentMapper activityCommentMapper;
	
	@Override
	public List<ActivityComment> getActivityCommentList(ActivityCommentVo activityCommentVo) {
		// TODO Auto-generated method stub
		return activityCommentMapper.getActivityCommentList(activityCommentVo);
	}

	@Override
	public int getActivityCommentCount(ActivityCommentVo activityCommentVo) {
		// TODO Auto-generated method stub
		return activityCommentMapper.getActivityCommentCount(activityCommentVo);
	}

}
