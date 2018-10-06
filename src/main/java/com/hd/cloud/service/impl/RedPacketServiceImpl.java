package com.hd.cloud.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.RedPacket;
import com.hd.cloud.dao.boss.RedPacketDao;
import com.hd.cloud.service.RedPacketService;
import com.hd.cloud.vo.RedPacketVo;

@Service
public class RedPacketServiceImpl implements RedPacketService{
	
	@Inject
	private RedPacketDao redPacketDao;
	
	@Override
	public List<RedPacket> getRedPacketList(RedPacketVo redPacketVo) {
		// TODO Auto-generated method stub
		return redPacketDao.getRedPacketList(redPacketVo);
	}

	@Override
	public int getRedPacketCount(RedPacketVo redPacketVo) {
		// TODO Auto-generated method stub
		return redPacketDao.getRedPacketCount(redPacketVo);
	}
	
	
}
