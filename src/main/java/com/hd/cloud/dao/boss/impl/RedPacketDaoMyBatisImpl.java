package com.hd.cloud.dao.boss.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.RedPacket;
import com.hd.cloud.dao.boss.RedPacketDao;
import com.hd.cloud.dao.boss.mapper.RedPacketMapper;
import com.hd.cloud.vo.RedPacketVo;

@Repository
public class RedPacketDaoMyBatisImpl implements RedPacketDao{
	
	@Inject
	private RedPacketMapper redPacketMapper;
	
	@Override
	public List<RedPacket> getRedPacketList(RedPacketVo redPacketVo) {
		// TODO Auto-generated method stub
		return redPacketMapper.getRedPacketList(redPacketVo);
	}

	@Override
	public int getRedPacketCount(RedPacketVo redPacketVo) {
		// TODO Auto-generated method stub
		return redPacketMapper.getRedPacketCount(redPacketVo);
	}
	
}
