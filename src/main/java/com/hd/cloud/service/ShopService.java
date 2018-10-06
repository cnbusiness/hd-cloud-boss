package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.vo.ShopVo;

public interface ShopService {
	
	public List<ShopBo> getShopList(ShopVo shopVo);
	
	public int getShopCount(ShopVo shopVo);
}
