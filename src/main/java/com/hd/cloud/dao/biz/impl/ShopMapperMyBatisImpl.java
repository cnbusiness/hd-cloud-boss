package com.hd.cloud.dao.biz.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.dao.biz.ShopDao;
import com.hd.cloud.dao.biz.mapper.ShopMapper;
import com.hd.cloud.vo.ShopVo;

@Repository
public class ShopMapperMyBatisImpl implements ShopDao{
	
	@Inject
	private ShopMapper shopMapper;

	@Override
	public List<ShopBo> getShopList(ShopVo shopVo) {
		// TODO Auto-generated method stub
		return shopMapper.getShopList(shopVo);
	}

	@Override
	public int getShopCount(ShopVo shopVo) {
		// TODO Auto-generated method stub
		return shopMapper.getShopCount(shopVo);
	}
}
