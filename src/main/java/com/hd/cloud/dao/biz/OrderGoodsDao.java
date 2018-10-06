package com.hd.cloud.dao.biz;

import java.util.List;

import com.hd.cloud.bo.OrderGoods;
import com.hd.cloud.vo.OrderGoodsVo;

public interface OrderGoodsDao {
	
	public List<OrderGoods> getOrderGoodsList(OrderGoodsVo orderGoodsVo);
	
	public int getOrderGoodsCount(OrderGoodsVo orderGoodsVo);

}
