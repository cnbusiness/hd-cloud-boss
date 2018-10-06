package com.hd.cloud.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.QueryParam;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hd.cloud.bo.ActivityReport;
import com.hd.cloud.service.ActivityReportService;
import com.hd.cloud.vo.ActivityReportVo;
import com.hlb.cloud.bo.BoUtil;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName ActivityReportResource.java
 * @Description 活动举报管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月4日 下午12:20:52
 *
 */
@RefreshScope
@RestController
@RequestMapping("activityreport")
public class ActivityReportResource {
	
	@Inject
	private ActivityReportService activityReportService;
	
	@ApiOperation(httpMethod = "GET",value = "activityreportList" ,notes="activityreportList")
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getActivityList(@QueryParam("page") Integer page,@QueryParam("pageSize") Integer pageSize){
		page = page == null ? 1 :page;
		pageSize = pageSize == null ? 10 :pageSize;
		int offset = (page - 1 ) * pageSize;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		ActivityReportVo activityReportVo = ActivityReportVo.builder().offset(offset).pageSize(pageSize).build();
		int total = activityReportService.getActivityReportcount(activityReportVo);
		List<ActivityReport> activitys = activityReportService.getActivityReportList(activityReportVo);
		Map<String,Object> map = new HashMap<String , Object>();
		map.put("list",activitys);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
}
