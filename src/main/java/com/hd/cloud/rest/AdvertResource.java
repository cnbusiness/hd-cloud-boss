package com.hd.cloud.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.QueryParam;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hd.cloud.BossServiceApplication.FileConfig;
import com.hd.cloud.bo.AdAdress;
import com.hd.cloud.bo.AdBo;
import com.hd.cloud.bo.AdModule;
import com.hd.cloud.bo.Advertisement;
import com.hd.cloud.service.AdvertService;
import com.hd.cloud.util.StringUtil;
import com.hd.cloud.vo.AdModuleVo;
import com.hd.cloud.vo.AdvertVo;
import com.hd.cloud.vo.CreateAdModuleVo;
import com.hd.cloud.vo.CreateAdVo;
import com.hd.cloud.vo.UpdateAdVo;
import com.hlb.cloud.bo.BoUtil;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName AdvertResource.java
 * @Description 广告管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月3日 上午11:47:11
 *
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("advert")
public class AdvertResource {
	
	@Inject
	private AdvertService advertService;
	
	@Inject
	private FileConfig fileConfig;
	
	/**
	 * 
	 * @Title:getAdvertList
	 * @Description:广告列表
	 * @param page
	 * @param pageSize
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "GET",value = "list" ,notes="list")
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getAdvertList(@QueryParam("title") String title,
			@QueryParam("status") Integer status,
			@QueryParam("adModuleId") Integer adModuleId,
			@QueryParam("page") Integer page,
			@QueryParam("pageSize") Integer pageSize){
		page = page == null ? 1 :page;
		pageSize = pageSize == null ? 10 :pageSize;
		int offset = (page - 1 ) * pageSize;
		adModuleId = adModuleId == null ? 0 :adModuleId;
		status = status==null ? 0 : status;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		AdvertVo advertVo = AdvertVo.builder().offset(offset).pageSize(pageSize).title(title).status(status).adModuleId(adModuleId).build();
		int total = advertService.getAdvertCount(advertVo);
		List<Advertisement> adverts = advertService.getAdvertList(advertVo);
		for(Advertisement advertisement : adverts){
			if(!StringUtil.isBlank(advertisement.getPicUrl())){
				advertisement.setPicUrl(fileConfig.getDomain() + advertisement.getPicUrl());
			}
		}
		Map<String,Object> map = new HashMap<String , Object>();
		map.put("list",adverts);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
	

	@ApiOperation(httpMethod = "GET",value = "list" ,notes="list")
	@ResponseBody
	@RequestMapping(value = "/adModule/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getAdModuleList(@QueryParam("page") Integer pageIndex,
			@QueryParam("pageSize") Integer pageSize){
		pageIndex = pageIndex == null ? 1 :pageIndex;
		pageSize = pageSize == null ? 10 :pageSize;
		int offset = (pageIndex - 1 ) * pageSize;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		AdModuleVo adModuleVo = AdModuleVo.builder().offset(offset).pageSize(pageSize).build();
		int total = advertService.getAdModuleCount(adModuleVo);
		List<AdModule> adModules = advertService.getAdModuleList(adModuleVo);
		Map<String,Object> map = new HashMap<String , Object>();
		map.put("list",adModules);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
	
	/**
	 * 
	 * @Title:createAd
	 * @Description:创建广告
	 * @param payload
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "POST",value = "advertList" ,notes="advertList")
	@ResponseBody
	@RequestMapping(value = "/create",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
	public BoUtil createAd(final @RequestBody CreateAdVo createAdVo){
		log.info("#######createAdVo:{}",createAdVo);
		BoUtil bo = BoUtil.getDefaultTrueBo();
		if(StringUtil.isBlank(createAdVo.getTitle())){
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("请输入广告标题");
			return bo;
		}
		if(StringUtil.isBlank(createAdVo.getDesc())){
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("请输入广告描述");
			return bo;
		}
		if(StringUtil.isBlank(createAdVo.getPicUrl())){
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("请输入广告图片");
			return bo;
		}
		if(createAdVo.getShowType()==2){
			createAdVo.setCountryCode("CN");
		}
//		if(StringUtil.isBlank(createAdVo.getCountryCode())){
//			bo = BoUtil.getDefaultFalseBo();
//			bo.setMsg("请选择地区");
//			return bo;
//		}
//		if(createAdVo.getTitle().length()>14){
//			bo = BoUtil.getDefaultFalseBo();
//			bo.setMsg("广告主题最多28个字符");
//			return bo;
//		}
		if(createAdVo.getDesc().length()>500){
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("广告描述最多500个字符");
			return bo;
		}
		if(advertService.getAdByTitle(createAdVo.getTitle(), 0)>0){
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("广告已存在");
			return bo;
		}
		Advertisement ad = Advertisement.builder().internalCode(0).countryCode("CN").title(createAdVo.getTitle())
				.desc(createAdVo.getDesc()).picUrl(createAdVo.getPicUrl()).linkItype(1).linkUrl(createAdVo.getLinkUrl())
				.linkId(createAdVo.getLinkId()).fileItype(0).validItype(1).clickItype(2).statusItype(2).viewCnt(0).clickCnt(0).uploader(10000).creater(10000).build();
		advertService.createAd(ad);
		int adId = ad.getId();
		log.info("#########adId:{}",adId);
		
		
		AdAdress adAdress =AdAdress.builder().adId(adId).cityId(440300).adModuleId(2).countryCode("CN").showType(1).creater(10000).build();
		advertService.createAdAdress(adAdress);


				
		return bo;
	}
	
	/**
	 * 
	 * @Title:createAdModule
	 * @Description:创建广告模块
	 * @param payload
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "POST",value = "createrAdModulet" ,notes="createrAdModule")
	@ResponseBody
	@RequestMapping(value = "/createAdModule",method = RequestMethod.POST,produces = "application/json",consumes = "application/*")
	public BoUtil createAdModule(final @RequestBody CreateAdModuleVo createAdModuleVo){
		log.info("########createAdModule:{}",createAdModuleVo);
		BoUtil bo = BoUtil.getDefaultTrueBo();
		if(StringUtil.isBlank(createAdModuleVo.getModuleName())){
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("请输入广告模块名");
			return bo;
		}
		if(StringUtil.isBlank(createAdModuleVo.getModuleRemark())){
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("请输入广告模块描述");
			return bo;
		}
		if(createAdModuleVo.getBannerTotals()==0){
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("请输入最大广告数");
			return bo;
		}
		AdModule adModule = AdModule.builder().moduleName(createAdModuleVo.getModuleName()).moduleRemark(createAdModuleVo.getModuleRemark()).setType(1)
				.bannerTotals(createAdModuleVo.getBannerTotals()).type(createAdModuleVo.getType()).BannerCode(createAdModuleVo.getBannerCode())
				.validType(createAdModuleVo.getValidType()).pageStartTime(createAdModuleVo.getPageStartTime()).pageEndTime(createAdModuleVo.getPageEndTime())
				.createBy(10000).build();
		advertService.createAdModule(adModule);
		return bo;
	}
	
	/**
	 * 
	 * @Title:getAdBoById
	 * @Description:通过id获取广告详情
	 * @param id
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "GET",value = "id" ,notes="id")
	@ResponseBody
	@RequestMapping(value = "/detail",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getAdBoById(final @QueryParam("id") int id){
		BoUtil bo = BoUtil.getDefaultTrueBo();
		AdBo adBo = advertService.getAdBoById(id);
		log.info("########广告详情adBo:{}" ,adBo);
		bo.setData(adBo);
		System.out.println(adBo);
		return bo;
		
	}
	
	/**
	 * 
	 * @Title:updateAd
	 * @Description:修改广告
	 * @param payload
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "PUT",value = "getAdBoById" ,notes="getAdBoById")
	@ResponseBody
	@RequestMapping(value = "/edit",method = RequestMethod.PUT,produces = "application/json",consumes = "application/json")
	public BoUtil updateAd(final @RequestBody UpdateAdVo updateAdVo){
		BoUtil bo =BoUtil.getDefaultTrueBo();
//		if(updateAdVo.getTitle().length()>14){
//			bo = BoUtil.getDefaultFalseBo();
//			bo.setMsg("广告主题最多28个字符");
//			return bo;
//		}
		if(updateAdVo.getDesc().length()>75){
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("广告描述最多500个字符");
			return bo;
		}
		Advertisement ad = Advertisement.builder().id(updateAdVo.getId()).countryCode(updateAdVo.getCountryCode()).title(updateAdVo.getTitle())
				.desc(updateAdVo.getDesc()).picUrl(updateAdVo.getPicUrl()).linkItype(updateAdVo.getLinkItype()).linkUrl(updateAdVo.getLinkUrl()).statusItype(updateAdVo.getStatusItype())
				.linkId(updateAdVo.getLinkId()).fileItype(0).validItype(1).clickItype(updateAdVo.getClickItype()).viewCnt(0).clickCnt(0).uploader(10000).updater(10000).build();
		log.debug("********************修改广告基础信息开始********************", ad);
		advertService.updateAd(ad);
		log.debug("********************修改广告基础信息结束********************");
		int adId = ad.getId();
		log.info("#########adId:{}",adId);
		
		
//		AdAdress adAddress =AdAdress.builder().adId(adId).cityId(updateAdVo.getCityId()).adModuleId(updateAdVo.getAdModuleId()).countryCode(updateAdVo.getCountryCode()).showType(updateAdVo.getShowType()).updater(10000).activeFlag(updateAdVo.getActiveFlag()).build();
//		log.debug("********************修改广告地址信息开始********************", adAddress);
//		advertService.updateAdAdress(adAddress);
//		log.debug("********************修改广告地址信息结束********************");			
		return bo;
	}
	
	/**
	 * 
	 * @Title:deleteAd
	 * @Description:删除广告
	 * @param id
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "DELETE",value = "delete" ,notes="delete")
	@ResponseBody
	@RequestMapping(value = "/delete",method = RequestMethod.DELETE,produces = "application/json",consumes = "application/*")
	public BoUtil deleteAd(@QueryParam("id") int id){
		BoUtil bo = BoUtil.getDefaultTrueBo();
		log.info("#####id:{}",id);
		UpdateAdVo updateAdVo = UpdateAdVo.builder().activeFlag("d").id(id).build();
		Advertisement ad =Advertisement.builder().id(id).activeFlag(updateAdVo.getActiveFlag()).build();
		advertService.updateAd(ad);
		AdAdress adAddress = AdAdress.builder().id(id).activeFlag(updateAdVo.getActiveFlag()).build();
		advertService.updateAdAdress(adAddress);
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
