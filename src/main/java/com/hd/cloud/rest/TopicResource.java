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
import com.hd.cloud.domain.TopicHome;
import com.hd.cloud.domain.TopicSection;
import com.hd.cloud.service.TopicService;
import com.hd.cloud.util.BossRestBase;
import com.hd.cloud.util.StringUtil;
import com.hd.cloud.vo.TopicVo;
import com.hlb.cloud.bo.BoUtil;

/**
 * 
 * @ClassName TopicResource.java
 * @Description 话题管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月4日 下午12:19:48
 *
 */
@RefreshScope
@RestController
@RequestMapping("topic")
public class TopicResource extends BossRestBase {
	
	private TopicService topicService;
	
	@Inject
	private FileConfig fileConfig;
	
	@Inject
	public TopicResource(final @NonNull TopicService topicService){
		this.topicService = topicService;
	}
	
	@ApiOperation(httpMethod = "GET",value = "list" ,notes="list")
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getTopicBoList(@QueryParam("topicName") String topicName,
			@QueryParam("createSource") Integer createSource,
			@QueryParam("page") Integer page,
			@QueryParam("pageSize") Integer pageSize){
		page = page == null ? 1 :page;
		pageSize = pageSize == null ? 10 :pageSize;
		int offset = (page - 1 ) * pageSize;
		createSource = createSource == null ? 0 : createSource;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		TopicVo topicVo = TopicVo.builder()
				.topicName(topicName).createSource(createSource).offset(offset)
				.pageSize(pageSize).build();
		List<TopicSection> topicSectionBos = topicService.getTopicSectionList(topicVo);
		for (TopicSection topicSection : topicSectionBos) {
			if(!StringUtil.isBlank(topicSection.getTopicUrl())){
				topicSection.setTopicUrl(fileConfig.getDomain() + topicSection.getTopicUrl());
			}
			if(!StringUtil.isBlank(topicSection.getHomeUrl())){
				topicSection.setHomeUrl(fileConfig.getDomain() + topicSection.getHomeUrl());
			}
			//查询是否是首页推荐
			int count = topicService.getCountByTopicId(topicSection.getId());
			topicSection.setIsHome(count > 0 ? 1 : 2);
		}
		int total = topicService.getTopicSectionCount(topicVo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", topicSectionBos);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
	
	/**
	 * 
	 * @Title: getTopicDetail
	 * @param:
	 * @Description: 话题详情
	 * @return BoUtil
	 * @throws ParseException 
	 */
	@ApiOperation(httpMethod = "GET",value = "detail" ,notes="detail")
	@ResponseBody
	@RequestMapping(value = "/detail",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getTopicDetail(final @QueryParam("id") long id) throws ParseException {
		BoUtil bo = BoUtil.getDefaultTrueBo();
		TopicSection topicSection = topicService.findById(id);
		//查询是否是首页推荐
		int count = topicService.getCountByTopicId(topicSection.getId());
		topicSection.setIsHome(count > 0 ? 1 : 2);
		topicSection.setDomain(fileConfig.getDomain());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long time = topicSection.getCreateTime().getTime();
		time = time + 8 * 60 * 60 * 1000;
		topicSection.setCreateTimeStr(dateFormat.format(new Date(time)));
		bo.setData(topicSection);
		System.out.println(topicSection);
		return bo;
	}
	
	/**
	 * 
	 * @Title: addTopic
	 * @param:
	 * @Description: 添加话题
	 * @return BoUtil
	 */
	
	@ApiOperation(httpMethod = "POST", value = "add", notes = "add")
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public BoUtil addTopic(final @RequestBody TopicSection topicSection) {
		BoUtil bo = BoUtil.getDefaultFalseBo();
		if (StringUtil.isBlank(topicSection.getTopicName())) {
			bo.setMsg("请输入话题主题");
			return bo;
		}
		if (StringUtil.isBlank(topicSection.getTopicUrl())) {
			bo.setMsg("请上传话题图片");
			return bo;
		}
//		if (StringUtil.isBlank(topicSection.getHomeUrl())) {
//			bo.setMsg("请上传首页图片");
//			return bo;
//		}
		if (StringUtil.isBlank(topicSection.getTopicDesc())) {
			bo.setMsg("请输入话题简介");
			return bo;
		}
//		if(StringUtil.isBlank(topicSection.getCountryCode())){
//			bo.setMsg("请选择地区");
//			return bo;
//		}
		if(topicSection.getTopicName().length()>14){
			bo.setMsg("话题主题最多28个字符");
			return bo;
		}
		if(topicSection.getTopicDesc().length()>250){
			bo.setMsg("话题简介最多500个字符");
			return bo;
		}
		if(topicService.getTopicCountByTopicName(topicSection.getTopicName(),0)>0) {
			bo.setMsg("话题已存在");
			return bo;
		}
		topicSection.setSort(0);
		topicSection.setCheckStatus(1);
		topicSection.setMxUserId(10000);
		topicSection.setCreateSource(2);
		topicSection.setIsTop(2);
		topicSection.setCreateBy(10000);
		topicSection.setCountryCode("86");
		int result = topicService.save(topicSection);
		if (result > 0 && topicSection.getIsHome() == 1) {
			// 保存到首页推荐
			TopicHome topicHome = TopicHome.builder()
					.countryCode(topicSection.getCountryCode())
					.sort(0).topicId(topicSection.getId()).build();
			topicService.saveTopicHome(topicHome);
		}
		if (result > 0) {
			bo = BoUtil.getDefaultTrueBo();
			bo.setMsg("话题创建成功");
		} else {
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("话题创建失败");
		}
		return bo;
	}

	/**
	 * 
	 * @Title: updateTopic
	 * @param:
	 * @Description: 编辑话题
	 * @return BoUtil
	 */
	
	@ApiOperation(httpMethod = "PUT", value = "update", notes = "update")
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public BoUtil updateTopic(final @RequestBody TopicSection topicSection) {
		BoUtil bo = BoUtil.getDefaultFalseBo();
		if (StringUtil.isBlank(topicSection.getTopicName())) {
			bo.setMsg("请输入话题主题");
			return bo;
		}
		if (StringUtil.isBlank(topicSection.getTopicUrl())) {
			bo.setMsg("请上传话题图片");
			return bo;
		}
//		if (StringUtil.isBlank(topicSection.getHomeUrl())) {
//			bo.setMsg("请上传首页图片");
//			return bo;
//		}
		if (StringUtil.isBlank(topicSection.getTopicDesc())) {
			bo.setMsg("请输入话题简介");
			return bo;
		}
//		if(StringUtil.isBlank(topicSection.getCountryCode())){
//			bo.setMsg("请选择地区");
//			return bo;
//		}
		if(topicSection.getTopicName().length()>14){
			bo.setMsg("话题主题最多28个字符");
			return bo;
		}
		if(topicSection.getTopicDesc().length()>75){
			bo.setMsg("话题简介最多150个字符");
			return bo;
		}
		if(topicService.getTopicCountByTopicName(topicSection.getTopicName(),topicSection.getId())>0) {
			bo.setMsg("话题已存在");
			return bo;
		}
		topicSection.setUpdateBy(10000);
		int result = topicService.update(topicSection);
		if (result > 0 && topicSection.getIsHome() == 2) {
			// 取消到首页推荐
			topicService.deleteTopicHome(topicSection.getId());
		}
		if (result > 0 && topicSection.getIsHome() == 1) {
			// 保存到首页推荐
			int count = topicService.getCountByTopicId(topicSection.getId());
			if(count == 0){
				TopicHome topicHome = TopicHome.builder()
						.countryCode(topicSection.getCountryCode())
						.sort(0).topicId(topicSection.getId()).build();
				topicService.saveTopicHome(topicHome);
			}
		}
		if (result > 0) {
			bo = BoUtil.getDefaultTrueBo();
			bo.setMsg("话题编辑成功");
		} else {
			bo.setMsg("话题编辑失败");
		}
		return bo;
	}
	
	/**
	 * 
	* @Title: deleteTopic 
	* @param: 
	* @Description: 删除话题
	* @return BoUtil
	 */
	@ApiOperation(httpMethod = "DELETE",value = "delete" ,notes="delete")
	@ResponseBody
	@RequestMapping(value = "/delete",method = RequestMethod.DELETE,produces = "application/json",consumes = "application/*")
	public BoUtil deleteTopic(final @QueryParam("id") long id) {
		BoUtil bo = BoUtil.getDefaultTrueBo();
		TopicSection topicSection = TopicSection.builder().id(id).active("d").updateBy(10000).build();
		//删除话题
		topicService.update(topicSection);
		//删除话题首页推荐
		topicService.deleteTopicHome(id);
		return bo;
	}

	/**
	 * 
	* @Title: getDomain 
	* @param: 
	* @Description: 获取上传图片接口
	* @return BoUtil
	 */
	@ApiOperation(httpMethod = "GET",value = "domain" ,notes="domain")
	@ResponseBody
	@RequestMapping(value = "/domain",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getDomain() {
		BoUtil bo = BoUtil.getDefaultTrueBo();
		bo.setData(fileConfig.getUploadDomain());
		return bo;
	}
}
