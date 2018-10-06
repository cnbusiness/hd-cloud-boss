package com.hd.cloud.dao.boss.sql;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.vo.RedPacketVo;

public class RedPacketProvider {
	
	public String getRedPacketList(RedPacketVo redPacketVo){
		String sql = new SQL(){
			{
				SELECT("user_redpacket_base_bd_seq,user_user_base_sb_seq,redpacket_base_total_amt,redpacket_base_cnt,redpacket_base_status_itype,redpacket_base_valid_bdate");
				FROM("user_redpacket_base_bd");
				WHERE("active_flag = 'y'");
				ORDER_BY("user_redpacket_base_bd_seq desc limit #{offset},#{pageSize}");
			}
		}.toString();
		return sql;
	}
	
	public String getRedPacketCount(RedPacketVo redPacketCo){
		String sql = new SQL(){
			{
				SELECT("COUNT(1)");
				FROM("user_redpacket_base_bd");
				WHERE("active_flag = 'y'");
			}
		}.toString();
		return sql;
	}
}
