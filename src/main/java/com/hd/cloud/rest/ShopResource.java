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

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.service.ShopService;
import com.hd.cloud.vo.ShopVo;
import com.hlb.cloud.bo.BoUtil;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName ShopResource.java
 * @Description 店铺管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月4日 下午12:19:59
 *
 */
@RefreshScope
@RestController
@RequestMapping("shop")
public class ShopResource {
	
	@Inject
	private ShopService shopService;

	@ApiOperation(httpMethod = "GET",value = "shopList" ,notes="shopList")
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getShopList(@QueryParam("page") Integer page,@QueryParam("pageSize") Integer pageSize){
		page = page == null ? 1 :page;
		pageSize = pageSize == null ? 10 :pageSize;
		int offset = (page - 1 ) * pageSize;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		ShopVo shopVo = ShopVo.builder().offset(offset).pageSize(pageSize).build();
		int total = shopService.getShopCount(shopVo);
		List<ShopBo> shopBos = shopService.getShopList(shopVo);
		Map<String,Object> map = new HashMap<String , Object>();
		map.put("list",shopBos);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
}
