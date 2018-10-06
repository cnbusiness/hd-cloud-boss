package com.hd.cloud.dao.biz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.OrderGoods;
import com.hd.cloud.dao.biz.sql.OrderGoodsProvider;
import com.hd.cloud.vo.OrderGoodsVo;

@Mapper
public interface OrderGoodsMapper {
	
	@SelectProvider(type = OrderGoodsProvider.class,method = "getOrderGoodsList")
	@Results(value = {
			@Result(property = "id",column = "order_goods_order_bt_seq",javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "shopId",column = "biz_mobiz_shop_bd_seq",javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "userId",column = "user_user_base_sb_seq",javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "statusItype",column = "goods_order_status_itype",javaType = int.class, jdbcType = JdbcType.TINYINT),
			@Result(property = "priceAmt",column = "goods_order_price_amt",javaType = double.class, jdbcType = JdbcType.DECIMAL),
			@Result(property = "payItype",column = "goods_order_pay_itype",javaType = int.class, jdbcType = JdbcType.TINYINT),
			@Result(property = "remark",column = "goods_order_remark",javaType = String.class, jdbcType = JdbcType.VARCHAR),
	})
	List<OrderGoods> getOrderGoodsList(OrderGoodsVo orderGoodsVo);
	
	@SelectProvider(type = OrderGoodsProvider.class,method = "getOrderGoodsCount")
	int getOrderGoodsCount(OrderGoodsVo orderGoodsVo);

}
