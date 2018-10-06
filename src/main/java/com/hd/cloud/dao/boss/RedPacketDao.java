package com.hd.cloud.dao.boss;

import java.util.List;

import com.hd.cloud.bo.RedPacket;
import com.hd.cloud.vo.RedPacketVo;

public interface RedPacketDao {
	
	/**
	 * 
	 * @Title:getRedPacketList
	 * @Description:获取红包列表
	 * @param redPacketVo
	 * @return List<RedPacket>
	 */
	public List<RedPacket> getRedPacketList(RedPacketVo redPacketVo);
	
	/**
	 * 
	 * @Title:getRedPacketCount
	 * @Description:获取红包列表总数
	 * @param redPacketVo
	 * @return int
	 */
	public int getRedPacketCount(RedPacketVo redPacketVo);
}
