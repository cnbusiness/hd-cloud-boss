package com.hd.cloud.dao.biz.sql;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.vo.OrderGoodsVo;

public class OrderGoodsProvider {
	
	public String getOrderGoodsList(OrderGoodsVo orderGoodsVo){
		String sql = new SQL(){
			{
			SELECT("order_goods_order_bt_seq,biz_mobiz_shop_bd_seq,user_user_base_sb_seq,goods_order_status_itype,goods_order_price_amt,goods_order_pay_itype,goods_order_remark");
			FROM("order_goods_order_bt");
			WHERE("active_flag = 'y'");
			ORDER_BY("order_goods_order_bt_seq desc limit #{offset},#{pageSize}");
			}
		}.toString();
		return sql;
	}
	
	public String getOrderGoodsCount(OrderGoodsVo orderGoodsVo){
		String sql = new SQL(){
			{
				SELECT("COUNT(1)");
				FROM("order_goods_order_bt");
				WHERE("active_flag = 'y'");
			}
		}.toString();
		return sql;
	}
}
