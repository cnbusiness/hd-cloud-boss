package com.hd.cloud.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.ShopFans;
import com.hd.cloud.dao.biz.ShopFansDao;
import com.hd.cloud.service.ShopFansService;
import com.hd.cloud.vo.ShopFansVo;

@Service
public class ShopFansServiceImpl implements ShopFansService{
	
	@Inject
	private ShopFansDao shopFansDao;
	
	@Override
	public List<ShopFans> getShopFansList(ShopFansVo shopFansVo) {
		// TODO Auto-generated method stub
		return shopFansDao.getShopFansList(shopFansVo);
	}

	@Override
	public int getShopFansCount(ShopFansVo shopFansVo) {
		// TODO Auto-generated method stub
		return shopFansDao.getShopFansCount(shopFansVo);
	}
	


}
