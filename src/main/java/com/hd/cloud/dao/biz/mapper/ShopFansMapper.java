package com.hd.cloud.dao.biz.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.ShopFans;
import com.hd.cloud.dao.biz.sql.ShopFansProvider;
import com.hd.cloud.vo.ShopFansVo;

@Mapper
public interface ShopFansMapper {
	
	@SelectProvider(type = ShopFansProvider.class,method = "getShopFansList")
	@Results(value = {
			@Result(property = "id", column = "biz_shop_fans_br_seq", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "merchantId", column = "biz_mobiz_base_bd_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "companyId", column = "biz_mobiz_company_bd_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "shopId", column = "biz_mobiz_shop_bd_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "groupIds", column = "biz_shop_fansgroup_br_seqs", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "userId", column = "user_user_base_sb_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "viewCount", column = "shop_fans_view_cnt", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "fansStatus", column = "shop_fans_status", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "lastViewTime", column = "last_view", javaType = Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "consumeFlag", column = "consume_flag", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "lastConsumeTime", column = "last_consume", javaType = Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "remark", column = "consume_remark", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "resourceType", column = "shop_fans_source_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "userStatus", column = "user_base_status_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "consumeCnt" , column = "shop_fans_consume_cnt" , javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "consumeAmt" , column = "shop_fans_consume_amt" , javaType = double.class,jdbcType = JdbcType.DECIMAL),
			 })
	List<ShopFans> getShopFansList(ShopFansVo shopFansVo);
	
	@SelectProvider(type = ShopFansProvider.class,method = "getShopFansCount")
	Integer getShopFansCount(ShopFansVo shopFansVo);
}
