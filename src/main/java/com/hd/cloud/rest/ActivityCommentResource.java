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

import com.hd.cloud.bo.ActivityComment;
import com.hd.cloud.service.ActivityCommentService;
import com.hd.cloud.vo.ActivityCommentVo;
import com.hlb.cloud.bo.BoUtil;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
@RequestMapping("activitycomment")
public class ActivityCommentResource {
	
	@Inject
	private ActivityCommentService activityCommentService;
	
	@ApiOperation(httpMethod = "GET", value = "activityCommentList",notes="activityCommentList")
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getUserBoList(@QueryParam("page") Integer page,@QueryParam("pageSize") Integer pageSize ){
		page = page == null ? 1 :page;
		pageSize = pageSize == null ? 10 :pageSize;
		int offset = (page - 1 ) * pageSize;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		ActivityCommentVo activityCommentVo = ActivityCommentVo.builder().offset(offset).pageSize(pageSize)
				.build();
		int total = activityCommentService.getActivityCommentCount(activityCommentVo);
		List<ActivityComment> activityComments = activityCommentService.getActivityCommentList(activityCommentVo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", activityComments);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
}
