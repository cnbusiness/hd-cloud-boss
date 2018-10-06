package com.hd.cloud.dao.biz.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.OrderGoods;
import com.hd.cloud.dao.biz.OrderGoodsDao;
import com.hd.cloud.dao.biz.mapper.OrderGoodsMapper;
import com.hd.cloud.vo.OrderGoodsVo;

@Repository
public class OrderGoodsMapperMyBatisImpl implements OrderGoodsDao{
	
	@Inject
	private OrderGoodsMapper orderGoodsMapper;
	
	@Override
	public List<OrderGoods> getOrderGoodsList(OrderGoodsVo orderGoodsVo){
		return orderGoodsMapper.getOrderGoodsList(orderGoodsVo);
	}
	
	@Override
	public int getOrderGoodsCount(OrderGoodsVo orderGoodsVo){
		return orderGoodsMapper.getOrderGoodsCount(orderGoodsVo);
	}
}
