package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.ShopFans;
import com.hd.cloud.vo.ShopFansVo;

public interface ShopFansService {
	
	public List<ShopFans> getShopFansList(ShopFansVo shopFansVo);
	
	public int getShopFansCount(ShopFansVo shopFansVo);
}	
