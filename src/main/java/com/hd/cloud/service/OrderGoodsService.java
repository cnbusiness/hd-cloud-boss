package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.OrderGoods;
import com.hd.cloud.vo.OrderGoodsVo;

public interface OrderGoodsService {
	
	public List<OrderGoods> getOrderGoodsList(OrderGoodsVo orderGoodsVo);
	
	public int getOrderGoodsCount(OrderGoodsVo orderGoodsVo);
}
