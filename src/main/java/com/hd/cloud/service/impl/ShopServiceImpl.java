package com.hd.cloud.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.dao.biz.ShopDao;
import com.hd.cloud.service.ShopService;
import com.hd.cloud.vo.ShopVo;

@Service
public class ShopServiceImpl implements ShopService{
	
	@Inject
	private ShopDao shopDao;
	
	@Override
	public List<ShopBo> getShopList(ShopVo shopVo) {
		return shopDao.getShopList(shopVo);
	}

	@Override
	public int getShopCount(ShopVo shopVo) {
		return shopDao.getShopCount(shopVo);
	}
	

	
	
}
