package com.hd.cloud.dao.biz.sql;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.vo.ShopFansVo;

public class ShopFansProvider {
	
	public String getShopFansList(ShopFansVo shopFansVo){
		String sql = new SQL(){
			{	SELECT("biz_shop_fans_br_seq,biz_mobiz_base_bd_seq,biz_mobiz_company_bd_seq,biz_mobiz_shop_bd_seq,biz_shop_fansgroup_br_seqs,user_user_base_sb_seq,shop_fans_view_cnt,shop_fans_status,last_view,consume_flag,last_consume,consume_remark,shop_fans_source_itype,user_base_status_itype，shop_fans_consume_cnt,shop_fans_consume_amt");
				FROM("biz_shop_frans_br");
				WHERE("biz_mobiz_shop_bd_seq=#{shopId} and active_flag='y'");
				ORDER_BY("biz_shop_fans_br_seq desc limit #{offset},#{pageSize}");
			}
		}.toString();
		return sql;
	}
	
	public String getShopFansCount(ShopFansVo shopFansVo){
		String sql = new SQL(){
			{
				SELECT("COUNT(1)");
				FROM("biz_shop_frans_br");
				WHERE("biz_mobiz_shop_bd_seq=#{shopId} and active_flag='y'");
			}
		}.toString();
		return sql;
	}
}
