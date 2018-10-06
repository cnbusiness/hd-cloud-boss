package com.hd.cloud.dao.boss.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.RedPacket;
import com.hd.cloud.dao.boss.sql.RedPacketProvider;
import com.hd.cloud.vo.RedPacketVo;

@Mapper
public interface RedPacketMapper {
	
	@SelectProvider(type = RedPacketProvider.class,method = "getRedPacketList")
	@Results(value = {
			@Result(property = "id",column = "user_redpacket_base_bd_seq",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "userId",column = "user_user_base_sb_seq",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "totalAmt",column = "redpacket_base_total_amt",javaType = double.class,jdbcType = JdbcType.DECIMAL),
			@Result(property = "redPacketCnt",column = "redpacket_base_cnt",javaType = int.class,jdbcType = JdbcType.TINYINT),
			@Result(property = "statusItype",column = "redpacket_base_status_itype",javaType = int.class,jdbcType = JdbcType.TINYINT),
			@Result(property = "beginTime",column = "redpacket_base_valid_bdate",javaType = Date.class,jdbcType = JdbcType.DATE),
	})
	List<RedPacket> getRedPacketList(RedPacketVo redPacketVo);
	
	@SelectProvider(type = RedPacketProvider.class,method = "getRedPacketCount")
	int getRedPacketCount(RedPacketVo redPacketVo);
}
