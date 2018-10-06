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

import com.hd.cloud.bo.ShopFans;
import com.hd.cloud.service.ShopFansService;
import com.hd.cloud.vo.ShopFansVo;
import com.hlb.cloud.bo.BoUtil;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName ShopFansResource.java
 * @Description 店铺粉丝管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月4日 下午12:20:07
 *
 */
@RefreshScope
@RestController
@RequestMapping("shopFans")
public class ShopFansResource {
	
	@Inject
	private ShopFansService shopFansService;
	
	@ApiOperation(httpMethod = "GET",value = "shopList" ,notes="shopList")
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getShopFansList(@QueryParam("page") Integer page,@QueryParam("pageSize") Integer pageSize){
		page = page == null ? 1 :page;
		pageSize = pageSize == null ? 10 :pageSize;
		int offset = (page - 1 ) * pageSize;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		ShopFansVo shopFansVo = ShopFansVo.builder().offset(offset).pageSize(pageSize).build();
		int total = shopFansService.getShopFansCount(shopFansVo);
		List<ShopFans> shopFanss = shopFansService.getShopFansList(shopFansVo);
		Map<String,Object> map = new HashMap<String , Object>();
		map.put("list",shopFanss);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
}
