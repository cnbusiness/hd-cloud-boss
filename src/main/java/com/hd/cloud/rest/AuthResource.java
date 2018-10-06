package com.hd.cloud.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hd.cloud.bo.Auth;
import com.hd.cloud.bo.LoginUserInfoBo;
import com.hd.cloud.service.AuthService;
import com.hd.cloud.util.BossRestBase;
import com.hd.cloud.util.ErrorCode;
import com.hd.cloud.util.Md5Util;
import com.hd.cloud.vo.LoginVo;
import com.hlb.cloud.bo.BoUtil;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName BossUserResource.java
 * @Description BOSS登录退出 管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年4月10日
 *
 */
@RefreshScope
@RestController
@RequestMapping("boss")
public class AuthResource extends BossRestBase{
	
	@Inject
	private AuthService authService;
	
	/**
	 * 
	 * @Title: checkUser
	 * @param:
	 * @Description: 登录
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "POST", value = "login", notes = "login")
	@ResponseBody
	@RequestMapping(value = "nofilter/login", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public BoUtil login(final @RequestBody LoginVo loginVo) {
		BoUtil bo = BoUtil.getDefaultFalseBo();
		String userAccount = loginVo.getAccount();
		if (StringUtils.isBlank(loginVo.getAccount())) {
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("用户名不能为空");
			return bo;
		}
		if (StringUtils.isBlank(loginVo.getPassword())) {
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("密码不能为空");
			return bo; 
		}
		
		String password = Md5Util.encryption(loginVo.getPassword());//md5加密
		long userId = authService.getUserIdByAccount(userAccount);

		// 用户名错误
		if (userAccount == null) {
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("用户名或密码错误");
			bo.setCode(ErrorCode.USERNAME_OR_PASSWORD_ERROR);
			return bo;
		}
		Auth auth = authService.isValidatePassPare(userId, password);
		if (auth == null) {
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("用户名或密码错误");
			bo.setCode(ErrorCode.USERNAME_OR_PASSWORD_ERROR);
			return bo;
		}
		bo = BoUtil.getDefaultTrueBo();
		LoginUserInfoBo loginUserInfoBo = LoginUserInfoBo.builder().userId(userId)
				.token(auth.getToken()).url("/moment/topic.html").loginName(userAccount).build();
		bo.setData(loginUserInfoBo);
		return bo;
	}


	
	//退出
	@ApiOperation(httpMethod = "GET",value = "退出" , notes = "退出")
	@ResponseBody
	@RequestMapping(value = "/logout" , method=RequestMethod.GET,produces = "application/json", consumes = "application/*")
	public BoUtil UserLogout() {
		
		authService.detoryAuthRedis(getLoginUserID());
		BoUtil bo = BoUtil.getDefaultTrueBo();
		bo.setMsg("logout Success!");
		return bo;
	}
	
	private long dateDiffHour(String endTime) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long diff;
		long hour = 0;
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		try {
			diff = sd.parse(endTime).getTime() - sd.parse(sd.format(System.currentTimeMillis())).getTime();
			hour = diff % nd / nh;// 计算差多少小时
		} catch (ParseException e) {
			// TODDAuto-generated catch block
			e.printStackTrace();
		}
		return hour;
	}

	/**
	 * 
	 * @Title: dateDiffMin
	 * @param:
	 * @Description: 时间相差分钟数
	 * @return long
	 */
	private long dateDiffMin(String endTime) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long diff;
		long min = 0;
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		try {
			diff = sd.parse(endTime).getTime() - sd.parse(sd.format(System.currentTimeMillis())).getTime();
			min = diff % nd % nh / nm;// 计算差多少分钟
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return min;
	}
}
