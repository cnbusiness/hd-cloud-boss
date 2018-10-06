package com.hd.cloud.dao.biz;

import java.util.List;

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.vo.ShopVo;

public interface ShopDao {
	
	public List<ShopBo> getShopList(ShopVo shopVo);
	
	public int getShopCount(ShopVo shopVo);
}
