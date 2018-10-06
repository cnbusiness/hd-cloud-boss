package com.hd.cloud.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@SuppressWarnings("deprecation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RedPacket {
	
	private int id;//主键ID
	
	private int userId;//红包发放人ID
	
	private int groupId;//群组ID，一对一时为空
	
	private double totalAmt;//总金额
	
	private int redPacketCnt;//红包个数
	
	private int itype;//是否为固定金额，1是，2 否
	
	private double perAmt;//单个红包金额，如为随机时则为零
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date beginTime;//红包发放日期时间
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;//红包过期时间
	
	private int statusItype;//红包状态：1、未领完，2、领完，3.已过期
	
	private long creater;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	private long updater;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	private String activeFlag;
	
}
