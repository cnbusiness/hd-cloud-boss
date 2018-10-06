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

import com.hd.cloud.bo.FeedComment;
import com.hd.cloud.service.FeedCommentService;
import com.hd.cloud.vo.FeedCommentVo;
import com.hlb.cloud.bo.BoUtil;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName FeedCommentResource.java
 * @Description 动态评论管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月4日 下午12:19:33
 *
 */
@RefreshScope
@RestController
@RequestMapping("feedcomment")
public class FeedCommentResource {
	
	@Inject 
	private FeedCommentService feedCommentService;
	
	@ApiOperation(httpMethod = "GET",value = "feedcommentList" ,notes="feedcommentList")
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getFeedCommentList(@QueryParam("page") Integer page,@QueryParam("pageSize") Integer pageSize){
		page = page == null ? 1 :page;
		pageSize = pageSize == null ? 10 :pageSize;
		int offset = (page - 1 ) * pageSize;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		FeedCommentVo feedCommentVo = FeedCommentVo.builder().offset(offset).pageSize(pageSize).build();
		int total = feedCommentService.getFeedCommentCount(feedCommentVo);
		List<FeedComment> feedComments = feedCommentService.getFeedCommentList(feedCommentVo);
		Map<String,Object> map = new HashMap<String , Object>();
		map.put("list",feedComments);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
}
