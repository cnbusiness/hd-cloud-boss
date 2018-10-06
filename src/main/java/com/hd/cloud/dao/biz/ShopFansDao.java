package com.hd.cloud.dao.biz;

import java.util.List;

import com.hd.cloud.bo.ShopFans;
import com.hd.cloud.vo.ShopFansVo;

public interface ShopFansDao {
	
	public List<ShopFans> getShopFansList(ShopFansVo shopFansVo);
	
	public int getShopFansCount(ShopFansVo shopFansVo);
}
