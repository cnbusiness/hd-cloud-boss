package com.hd.cloud.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.OrderGoods;
import com.hd.cloud.dao.biz.OrderGoodsDao;
import com.hd.cloud.service.OrderGoodsService;
import com.hd.cloud.vo.OrderGoodsVo;

@Service
public class OrderGoodsServiceImpl implements OrderGoodsService{
	
	@Inject
	private OrderGoodsDao orderGoodsDao;
	
	@Override
	public List<OrderGoods> getOrderGoodsList(OrderGoodsVo orderGoodsVo) {
		// TODO Auto-generated method stub
		return orderGoodsDao.getOrderGoodsList(orderGoodsVo);
	}

	@Override
	public int getOrderGoodsCount(OrderGoodsVo orderGoodsVo) {
		// TODO Auto-generated method stub
		return orderGoodsDao.getOrderGoodsCount(orderGoodsVo);
	}

}
