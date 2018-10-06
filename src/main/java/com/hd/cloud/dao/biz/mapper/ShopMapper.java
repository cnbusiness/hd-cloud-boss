package com.hd.cloud.dao.biz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.dao.biz.sql.ShopProvider;
import com.hd.cloud.vo.ShopVo;

@Mapper
public interface ShopMapper {
	
	@SelectProvider(type = ShopProvider.class,method = "getShopList")
	@Results(value = {
			@Result(property = "shopId", column = "biz_mobiz_shop_bd_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "shopName", column = "mobiz_shop_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "address", column = "mobiz_shop_address", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "authType", column = "mobiz_shop_auth_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "authDate", column = "mobiz_shop_auth_date", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "shopPhone", column = "mobiz_shop_phone", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "companyId", column = "biz_mobiz_company_bd_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "tradeId", column = "biz_trade_dict_bd_seq", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
//			@Result(property = "", column = "", javaType = .class, jdbcType = JdbcType.),
//			@Result(property = "", column = "", javaType = .class, jdbcType = JdbcType.),
//			@Result(property = "", column = "", javaType = .class, jdbcType = JdbcType.),
			
	})
	List<ShopBo> getShopList(ShopVo shopVo);
	
	@SelectProvider(type = ShopProvider.class,method = "getShopCount")
	Integer getShopCount(ShopVo shopVo);
}
