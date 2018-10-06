package com.hd.cloud.dao.biz.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.ShopFans;
import com.hd.cloud.dao.biz.ShopFansDao;
import com.hd.cloud.dao.biz.mapper.ShopFansMapper;
import com.hd.cloud.vo.ShopFansVo;

@Repository
public class ShopFansMapperMyBatisImpl implements ShopFansDao{
	
	@Inject
	private ShopFansMapper shopFansMapper;

	@Override
	public List<ShopFans> getShopFansList(ShopFansVo shopFansVo) {
		// TODO Auto-generated method stub
		return shopFansMapper.getShopFansList(shopFansVo);
	}

	@Override
	public int getShopFansCount(ShopFansVo shopFansVo) {
		// TODO Auto-generated method stub
		return shopFansMapper.getShopFansCount(shopFansVo);
	}
	
	
}
