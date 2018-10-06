package com.hd.cloud.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hd.cloud.bo.Activity;
import com.hd.cloud.service.ActivityService;
import com.hd.cloud.util.DateUtil;
import com.hd.cloud.util.StringUtil;
import com.hd.cloud.util.ActivityErrorCode;
import com.hd.cloud.vo.ActivityVo;
import com.hd.cloud.vo.CreateActivityVo;
import com.hlb.cloud.bo.BoUtil;
import com.hlb.cloud.util.CommonErrorCode;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName ActivityResource.java
 * @Description 活动管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月3日 上午11:46:58
 *
 */

@Slf4j
@RefreshScope
@RestController
@RequestMapping("activity")
public class ActivityResource {
	
	@Inject
	private ActivityService activityService;
	
	/**
	 * 
	 * @Title:getActivityList
	 * @Description:活动列表
	 * @param page
	 * @param pageSize
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "GET",value = "activityList" ,notes="activityList")
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getActivityList(@QueryParam("page") Integer page,@QueryParam("pageSize") Integer pageSize){
		page = page == null ? 1 :page;
		pageSize = pageSize == null ? 10 :pageSize;
		int offset = (page - 1 ) * pageSize;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		ActivityVo activityVo = ActivityVo.builder().offset(offset).pageSize(pageSize).build();
		int total = activityService.getActivityCnt(activityVo);
		List<Activity> activitys = activityService.getActivityList(activityVo);
		Map<String,Object> map = new HashMap<String , Object>();
		map.put("list",activitys);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
	
	
	/**
	 * 
	 * @Title:createActivity
	 * @Description:创建活动
	 * @param payload
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "POST",value = "createActivity" , notes="createActivity")
	@ResponseBody
	@RequestMapping(value="/createActivity",method=RequestMethod.POST,produces="application/json",consumes = "application/json")
	public BoUtil createActivity(final @RequestBody CreateActivityVo payload){
		BoUtil boUtil = BoUtil.getDefaultTrueBo();
		long userId = payload.getUserId();
		String pictureUrls = payload.getPictureUrls();
		String theme = payload.getTheme();
		long startTime = payload.getStartTime();
		long endTime = payload.getEndTime();
		String address = payload.getAddress();
		int cityId = payload.getCityId();
		double latitude = payload.getLatitude();
		double longitude = payload.getLongitude();
		String detail = payload.getDetail();
		int activityTypeId = payload.getActivityTypeId();
		int isNeedPhone = payload.getIsNeedPhone();
		log.debug("@payload{},@loginUserId{}", payload, userId);
		log.debug("**********************参数验证开始***************************");
		if (StringUtils.isBlank(pictureUrls)) {// 图片非空验证
			boUtil=BoUtil.getDefaultFalseBo();
			boUtil.setCode(ActivityErrorCode.PICTUREURLS_IS_EMPTY);
			return boUtil;
		}
		if (pictureUrls.trim().split("\\|").length > 9) {// 图片数量验证
			boUtil=BoUtil.getDefaultFalseBo();
			boUtil.setCode(ActivityErrorCode.NUMBER_OF_PICTURE);
			return boUtil;
		}
		if (StringUtils.isBlank(theme) || StringUtil.getWordCountRegex(theme.trim()) > 50) {// 活动主题验证有效性验证
			boUtil=BoUtil.getDefaultFalseBo();
			boUtil.setCode(ActivityErrorCode.LENGTH_OF_THEME);
			return boUtil;
		}
		if (startTime == 0) {// 活动开始时间非空验证
			boUtil=BoUtil.getDefaultFalseBo();
			boUtil.setCode(ActivityErrorCode.STARTTIME_IS_EMPTY);
			return boUtil;
		}
		if (endTime == 0) {// 活动结束时间非空验证
			boUtil=BoUtil.getDefaultFalseBo();
			boUtil.setCode(ActivityErrorCode.ENDTIME_IS_EMPTY);
			return boUtil;
		}
		if (startTime > endTime) {// 开始时间是否大于结束时间开始验证
			boUtil=BoUtil.getDefaultFalseBo();
			boUtil.setCode(ActivityErrorCode.STARTTIME_MORE_THAN_ENDTIME);
			return boUtil;
		}
		if (DateUtil.daysBetween(startTime, endTime) > 90) {// 活动时间是否大于90天验证
			boUtil=BoUtil.getDefaultFalseBo();
			boUtil.setCode(ActivityErrorCode.ACTIVITY_TIME);
			return boUtil;
		}
		if (StringUtils.isBlank(address)) {// 活动地址非空验证
			boUtil=BoUtil.getDefaultFalseBo();
			boUtil.setCode(ActivityErrorCode.ADDRESS_IS_EMPTY);
			return boUtil;
		}
		if (cityId == 0) {// 城市Id非空验证
			boUtil=BoUtil.getDefaultFalseBo();
			boUtil.setCode(ActivityErrorCode.CITYID_IS_EMPTY);
			return boUtil;
		}
		if (latitude == 0.0 || longitude == 0.0) {// 经纬度非空验证
			boUtil=BoUtil.getDefaultFalseBo();
			boUtil.setCode(ActivityErrorCode.COORDINATES_IS_EMPTY);
			return boUtil;
		}
		if (StringUtils.isBlank(detail) || StringUtil.getWordCountRegex(detail.trim()) > 800) {// 活动详情非空验证
			boUtil=BoUtil.getDefaultFalseBo();
			boUtil.setCode(ActivityErrorCode.DETAIL_IS_EMPTY);
			return boUtil;
		}
		if (activityTypeId == 0) {// 活动类型非空验证
			boUtil=BoUtil.getDefaultFalseBo();
			boUtil.setCode(ActivityErrorCode.ACTIVITYTYPEID_IS_EMPTY);
			return boUtil;
		}
		if (isNeedPhone != 2 && isNeedPhone != 1) {// 报名活动是否需要手机号码有效性验证
			boUtil=BoUtil.getDefaultFalseBo();
			boUtil.setCode(ActivityErrorCode.ISNEEDPHONE_FORMAT_ERROR);
			return boUtil;
		}
		log.debug("**********************参数验证结束***************************");

		log.debug("*************************发布魔线活动调用Service层开始**************************");
		String result = activityService.createActivity(payload, userId);
		log.debug("*************************发布魔线活动调用Service层结束**************************");
		boUtil.setCode(CommonErrorCode.SUCCESS);
		boUtil.setMsg("success");
		boUtil.setData(result);
		log.info("用户ID:{},发布了活动ID:{}", userId, result.split("\\|")[0]);
		return boUtil;
	}
	
	/**
	 * 
	 * @Title:getActivityById
	 * @Description:通过ID查询活动信息
	 * @param id
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "GET",value = "activityList" ,notes="activityList")
	@ResponseBody
	@RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json",consumes = "application/json")
	public BoUtil getActivityById(@PathVariable("id") int id){
		BoUtil bo = BoUtil.getDefaultTrueBo();
		Activity activity = activityService.getActivityBaseById(id);
		log.info("##########活动信息activity:{}",activity);
		 bo.setData(activity);
		 return bo;
	}
	
	@ApiOperation(httpMethod = "DELETE" , value = "deleteActivity",notes="deleteActivity")
	@ResponseBody
	@RequestMapping(value = "/delete/{id}",method=RequestMethod.DELETE,produces = "application/json" ,consumes="application/json")
	public BoUtil deleteActivityById(@PathVariable("id") int id ){
		BoUtil bo = BoUtil.getDefaultTrueBo();
		activityService.deleteActivityById(id);
		return bo;
	}
}
