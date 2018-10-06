package com.hd.cloud.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.ActivityComment;
import com.hd.cloud.dao.moment.ActivityCommentDao;
import com.hd.cloud.service.ActivityCommentService;
import com.hd.cloud.vo.ActivityCommentVo;

@Service
public class ActivityCommentServiceImpl implements ActivityCommentService{
	
	@Inject
	private ActivityCommentDao activityCommentDao;
	
	@Override
	public List<ActivityComment> getActivityCommentList(ActivityCommentVo activityCommentVo) {
		// TODO Auto-generated method stub
		return activityCommentDao.getActivityCommentList(activityCommentVo);
	}

	@Override
	public int getActivityCommentCount(ActivityCommentVo activityCommentVo) {
		// TODO Auto-generated method stub
		return activityCommentDao.getActivityCommentCount(activityCommentVo);
	}

}
