package com.hd.cloud.dao.biz.sql;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.vo.ShopVo;

public class ShopProvider {
	
	public String getShopList(ShopVo shopVo){
		String sql = new SQL(){
			{
				SELECT("biz_mobiz_shop_bd_seq,mobiz_shop_name,mobiz_shop_address,mobiz_shop_auth_itype,mobiz_shop_auth_date,mobiz_shop_phone,biz_mobiz_company_bd_seq,biz_trade_dict_bd_seq");
				FROM("biz_mobiz_shop_bd");
				WHERE("active_flag = 'y'");
				ORDER_BY("biz_mobiz_shop_bd_seq desc limit #{offset},#{pageSize}");
			}
		}.toString();
		return sql;
	}
	
	public String getShopCount(ShopVo shopVo){
		String sql = new SQL(){
			{
				SELECT("COUNT(1)");
				FROM("biz_mobiz_shop_bd");
				WHERE("active_flag = 'y'");
			}
		}.toString();
		return sql;
	}
}
