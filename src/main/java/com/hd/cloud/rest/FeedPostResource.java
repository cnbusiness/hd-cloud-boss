package com.hd.cloud.rest;

import io.swagger.annotations.ApiOperation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.QueryParam;

import lombok.NonNull;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hd.cloud.BossServiceApplication.FileConfig;
import com.hd.cloud.bo.PicBo;
import com.hd.cloud.domain.FeedPost;
import com.hd.cloud.service.FeedPostService;
import com.hd.cloud.util.StringUtil;
import com.hd.cloud.vo.FeedPostVo;
import com.hlb.cloud.bo.BoUtil;

/**
 * 
 * @ClassName feedResource.java
 * @Description 动态管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年6月19日 下午3:43:43
 *
 */
@RefreshScope
@RestController
@RequestMapping("feed")
public class FeedPostResource {
	
	@Inject
	private FileConfig fileConfig;
	
	public FeedPostService feedPostService;
	
	@Inject
	public FeedPostResource(final @NonNull FeedPostService feedPostService) {
		this.feedPostService = feedPostService;
	}

	/**
	 * 
	* @Title: getFeedList 
	* @param: 
	* @Description: 动态列表
	* @return BoUtil
	 * @throws ParseException 
	 */
	@ApiOperation(httpMethod = "GET",value = "list" ,notes="list")
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getFeedList(@QueryParam("page") Integer page,
			@QueryParam("pageSize") Integer pageSize,
			@QueryParam("dispalyType") Integer dispalyType,
			@QueryParam("content") String content) throws ParseException{
		page = page == null ? 1 :page;
		pageSize = pageSize == null ? 10 :pageSize;
		int offset = (page - 1 ) * pageSize;
		dispalyType = dispalyType == null ? 0 : dispalyType;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		FeedPostVo feedPostVo = FeedPostVo.builder()
				.offset(offset).pageSize(pageSize)
				.dispalyType(dispalyType)
				.content(content).build();
		int total = feedPostService.getFeedCount(feedPostVo);
		List<FeedPost> feedPostBos = feedPostService.getFeedList(feedPostVo);
		for (FeedPost feedPost : feedPostBos) {
			if(feedPost.getPicUrl()!=null){
			feedPost.setPicUrl(fileConfig.getDomain() + feedPost.getPicUrl());
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			long time = dateFormat.parse(feedPost.getCreateTime()).getTime();
			time = time + 8 * 60 * 60 * 1000;
			feedPost.setCreateTime(dateFormat.format(new Date(time)));
		}
		Map<String,Object> map = new HashMap<String , Object>();
		map.put("list",feedPostBos);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
	
	/**
	 * 
	* @Title: getFeedList 
	* @param: 
	* @Description: 动态详情
	* @return BoUtil
	 * @throws ParseException 
	 */
	@ApiOperation(httpMethod = "GET",value = "detail" ,notes="detail")
	@ResponseBody
	@RequestMapping(value = "/detail",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getFeedList(@QueryParam("id") Long id) throws ParseException{
		BoUtil bo = BoUtil.getDefaultTrueBo();
		id = id == null ? 0 : id;
		FeedPost feedPost = feedPostService.findById(id);
		if(feedPost != null){
			List<PicBo> list = feedPostService.getFeedPictures(id);
			feedPost.setList(list);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			long time = dateFormat.parse(feedPost.getCreateTime()).getTime();
			time = time + 8 * 60 * 60 * 1000;
			feedPost.setCreateTime(dateFormat.format(new Date(time)));
			List<PicBo> picList = feedPost.getList();
			for (PicBo picBo : picList) {
				picBo.setPicUrl(fileConfig.getDomain() + picBo.getPicUrl());
			}
		}
		bo.setData(feedPost);
		return bo;
	}
	
	/**
	 * 
	* @Title: shieldPost 
	* @param: 
	* @Description: 屏蔽动态
	* @return BoUtil
	 */
	@ApiOperation(httpMethod = "PUT",value = "shield" ,notes="shield")
	@ResponseBody
	@RequestMapping(value = "/shield",method = RequestMethod.PUT,produces = "application/json",consumes = "application/json")
	public BoUtil shieldPost(@RequestBody FeedPost feedPost){
		BoUtil bo = BoUtil.getDefaultFalseBo();
		feedPost.setUpdateBy(10000);
		int result = feedPostService.shieldPost(feedPost);
		if (result > 0) {
			bo = BoUtil.getDefaultTrueBo();
			bo.setMsg("屏蔽动态成功");
		} else {
			bo.setMsg("屏蔽动态失败");
		}
		return bo;
	}
}
