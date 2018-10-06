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

import com.hd.cloud.bo.Topic;
import com.hd.cloud.service.HotTopicService;
import com.hd.cloud.vo.HotTopicVo;
import com.hlb.cloud.bo.BoUtil;

 
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName HotTopicResource.java
 * @Description 热门话题管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月4日 下午12:20:26
 *
 */
@RefreshScope
@RestController
@RequestMapping("hottopic")
public class HotTopicResource {
	
	@Inject
	private HotTopicService hotTopicService;
	
	/**
	 * 
	 * @Title:getHotTopicBoList
	 * @Description:热门话题列表
	 * @param page
	 * @param pageSize
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "GET",value = "HotTopicList" ,notes="HotTopicList")
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getHotTopicBoList(@QueryParam("page") Integer page,@QueryParam("pageSize") Integer pageSize){
		page = page == null ? 1 :page;
		pageSize = pageSize == null ? 10 :pageSize; 
		int offset = (page - 1 ) * pageSize;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		HotTopicVo topicVo = HotTopicVo.builder().offset(offset).pageSize(pageSize).build();
		int total = hotTopicService.getHotTopicBoCount(topicVo);
		List<Topic> topicBos = hotTopicService.getHotTopicBoList(topicVo);
		Map<String,Object> map = new HashMap<String , Object>();
		map.put("list",topicBos);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
}