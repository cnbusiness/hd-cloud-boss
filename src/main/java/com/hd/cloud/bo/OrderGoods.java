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
public class OrderGoods {
	
	private int id;//主键ID
	
	private String code;//内码
	
	private int companyId;//公司Id
	
	private int shoperId;//商家Id
	
	private int shopId;//店铺ID
	
	private long userId;//用户id
	
	private int statusItype;//订单状态1、成功，2、处理中，3、失败
	
	private double priceAmt;//订单总金额
	
	private int payItype;//*支付状态，1.未支付，2.支付成功，3.支付失败
	
	private String remark;//备注
	
	private long creater;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	private long updater;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	private String activeFlag;
}
