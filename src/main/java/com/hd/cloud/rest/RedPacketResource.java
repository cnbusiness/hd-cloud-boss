package com.hd.cloud.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.QueryParam;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hd.cloud.bo.RedPacket;
import com.hd.cloud.service.RedPacketService;
import com.hd.cloud.vo.RedPacketVo;
import com.hlb.cloud.bo.BoUtil;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName RedPacketResource.java
 * @Description 红包管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月4日 下午12:20:17
 *
 */
@RefreshScope
@RestController
@RequestMapping("redpacket")
public class RedPacketResource {
	
	@Inject
	private RedPacketService redPakcteService;
	
	@ApiOperation(httpMethod = "GET",value = "redpakcetList" ,notes="redpacketList")
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getRedPacketList(@QueryParam("page") Integer page,@QueryParam("pageSize") Integer pageSize){
		page = page == null ? 1 :page;
		pageSize = pageSize == null ? 10 :pageSize;
		int offset = (page - 1 ) * pageSize;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		RedPacketVo redPacketVo = RedPacketVo.builder().offset(offset).pageSize(pageSize).build();
		int total = redPakcteService.getRedPacketCount(redPacketVo);
		List<RedPacket> redpackets = redPakcteService.getRedPacketList(redPacketVo);
		Map<String,Object> map = new HashMap<String , Object>();
		map.put("list",redpackets);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
}
