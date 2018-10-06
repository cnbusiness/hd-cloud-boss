package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.RedPacket;
import com.hd.cloud.vo.RedPacketVo;

public interface RedPacketService {
	
	public List<RedPacket> getRedPacketList(RedPacketVo redPacketVo);
	
	public int getRedPacketCount(RedPacketVo redPacketVo);
}
