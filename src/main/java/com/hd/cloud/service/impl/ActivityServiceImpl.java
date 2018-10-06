package com.hd.cloud.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hd.cloud.bo.Activity;
import com.hd.cloud.dao.moment.ActivityDao;

import com.hd.cloud.service.ActivityService;
import com.hd.cloud.util.ConstantActivityUtil;
import com.hd.cloud.vo.ActivityVo;
import com.hd.cloud.vo.CreateActivityVo;
import com.hlb.cloud.util.RandomUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ActivityServiceImpl implements ActivityService{
	
	@Inject
	private ActivityDao activityDao;
	
	@Inject
	private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public List<Activity> getActivityList(ActivityVo activityVo) {
		return activityDao.getActivityList(activityVo);
	}

	@Override
	public int getActivityCnt(ActivityVo activityVo) {
		return activityDao.getActivityCnt(activityVo);
	}
	
	/**
	 * 创建活动
	 */
	@Override
	@Transactional(rollbackFor = Exception.class) 
	public String createActivity(CreateActivityVo createActivityVo, long userId) {
		log.debug("@activityVo{},@userId{}", createActivityVo, userId);
		SimpleDateFormat dateFormart = new SimpleDateFormat("yyyy-MM-dd");// 日期格式
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");// 时间格式
		String random = System.currentTimeMillis() + RandomUtil.createRandCode(2) + "";// 活动内码规则未定，暂时用随机数代替
		long sTime = createActivityVo.getStartTime() * 1000l;
		long eTime = createActivityVo.getEndTime() * 1000l;
		String pictureUrls = createActivityVo.getPictureUrls();
		String[] pictures = pictureUrls.split("\\|");
		int cityId = createActivityVo.getCityId();

		Activity activityBase = Activity.builder().innerCode(random).theme(createActivityVo.getTheme())
				.detail(createActivityVo.getDetail()).personNumber(5000).shopShield(ConstantActivityUtil.SHOPSCREENING_NORMAL)
				.authType(ConstantActivityUtil.QUALIFICATION_PASS).activityTypeId(createActivityVo.getActivityTypeId())
				.isNeedPhone((short) createActivityVo.getIsNeedPhone()).appType((short) 1).organizer(userId).status((short) 0)
				.pictureUrls(pictureUrls).logoUrl(pictures[0]).couponId(0).cityId(cityId).isNeedNotice((short) 2)
				.delayHour(0).hasShake((short) 2).creater(userId).updater(userId).build();

		try {
			Date startDate = dateFormart.parse(dateFormart.format(sTime));
			Date endDate = dateFormart.parse(dateFormart.format(eTime));
			String startTime = timeFormat.format(sTime);
			String endTime = timeFormat.format(eTime);
			activityBase.setStartDate(startDate);
			activityBase.setEndDate(endDate);
			activityBase.setStartTime(startTime);
			activityBase.setEndTime(endTime);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		log.debug("********************创建活动基础信息开始********************", activityBase);
		activityDao.createActivity(activityBase);
		log.debug("********************创建活动基础信息结束********************");
		int activityId = activityBase.getId();

//		ActivityAddress activityAddress = ActivityAddress.builder().activityId(activityId)
//				.latitude(activityVo.getLatitude()).longitude(activityVo.getLongitude())
//				.address(activityVo.getAddress()).creater(userId).updater(userId).build();
//		log.debug("********************创建活动地址开始********************", activityAddress);
//		activityAddressDao.addActivityAddress(activityAddress);
//		log.debug("********************创建活动地址结束********************");
//
//		ActivityCount activityCount = ActivityCount.builder().activityId(activityId).forwardCount(0).commentPicCount(0)
//				.commentCount(0).favoriteCount(0).joinCount(0).viewCount(0).shareCount(0).creater(userId)
//				.updater(userId).build();
//		log.debug("********************创建活动统计信息开始********************", activityCount);
//		activityCountDao.addActivityCount(activityCount);
//		log.debug("********************创建活动统计信息结束********************");
		int hour = (int) (((sTime / 1000l) - System.currentTimeMillis() / 1000l) / 3600);
		if (hour >= 2) {
			redisTemplate.opsForList().leftPush("activity:time", activityId + "|" + sTime / 1000l + "|" + 1);
		}

		return activityId + "|" + 0;
	}

	@Override
	public Activity getActivityBaseById(int id) {
		log.info("activityId : {}", id);
		Activity activity= activityDao.getActivityBaseById(id);
		return activity;
	}

	@Override
	public void deleteActivityById(int id) {
		activityDao.deleteActivityById(id);
		
	}

}
