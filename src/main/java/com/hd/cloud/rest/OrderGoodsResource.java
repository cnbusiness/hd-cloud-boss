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

import com.hd.cloud.bo.OrderGoods;
import com.hd.cloud.service.OrderGoodsService;
import com.hd.cloud.vo.OrderGoodsVo;
import com.hlb.cloud.bo.BoUtil;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
@RequestMapping("ordergoods")
public class OrderGoodsResource {
	
	@Inject
	private OrderGoodsService orderGoodsService;
	
	@ApiOperation(httpMethod = "GET",value = "redpakcetList" ,notes="redpacketList")
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getOrderGoodsList(@QueryParam("page") Integer page,@QueryParam("pageSize") Integer pageSize){
		page = page == null ? 1 :page;
		pageSize = pageSize == null ? 10 :pageSize;
		int offset = (page - 1 ) * pageSize;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		OrderGoodsVo orderGoodsVo = OrderGoodsVo.builder().offset(offset).pageSize(pageSize).build();
		int total = orderGoodsService.getOrderGoodsCount(orderGoodsVo);
		List<OrderGoods> redpackets = orderGoodsService.getOrderGoodsList(orderGoodsVo);
		Map<String,Object> map = new HashMap<String , Object>();
		map.put("list",redpackets);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
}
