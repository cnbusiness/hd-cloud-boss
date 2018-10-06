package com.hd.cloud.rest;

import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hd.cloud.bo.BossUserAccount;
import com.hd.cloud.service.AuthService;
import com.hd.cloud.service.BossUserAccountService;
import com.hd.cloud.util.BossRestBase;
import com.hd.cloud.util.ErrorCode;
import com.hd.cloud.util.Md5Util;
import com.hd.cloud.vo.UpdateBossUserPwdVo;
import com.hlb.cloud.bo.BoUtil;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName BossUserProfileResource.java
 * @Description 后台用户信息管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年4月11日 上午11:03:18
 *
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("bossuser")
public class BossUserResource extends BossRestBase{
	
	@Inject
	private BossUserAccountService bossUserAccountService;
	
	@Inject
	private AuthService authService;
	
	/**
	 * 
	 * @Title:getBossUserAccount
	 * @Description:BOSS账号信息
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "GET",value = "账号信息",notes = "账号信息")
	@ResponseBody
	@RequestMapping(value = "/bossuserprofile",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
	public BoUtil getBossUserAccount(final @RequestBody int userId){
		BoUtil bo = BoUtil.getDefaultTrueBo();
		log.info("userId:{}",userId);
		BossUserAccount bossUserAccount = bossUserAccountService.getBossUserAccountById(userId);
		log.info("##########bossUserAccount:{}",bossUserAccount);
		bo.setData(bossUserAccount);
		return bo;
	}
	
	/**
	 * 
	 * @Title:updatepwd
	 * @Description:修改BOSS账号密码
	 * @param payload
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "PUT",value = "password",notes = "password")
	@ResponseBody
	@RequestMapping(value = "/updatePwd",method = RequestMethod.PUT,produces = "application/json",consumes = "application/json")
	public BoUtil updatepwd(final @RequestBody UpdateBossUserPwdVo payload) {
		BoUtil bo = BoUtil.getDefaultTrueBo();
		String oldPassword = payload.getOldPassword();
		String newPassword = payload.getNewPassword();
		long userId = payload.getUserId();
		if(StringUtils.isBlank(payload.getOldPassword())){
			bo = BoUtil.getDefaultFalseBo();
			bo.setCode(ErrorCode.ACCOUNT_PWD_EMPTY_ERROR);
			bo.setMsg("Please enter you old password");
		}//旧密码为空
		if(StringUtils.isBlank(payload.getNewPassword())){
			bo = BoUtil.getDefaultFalseBo();
			bo.setCode(ErrorCode.ACCOUNT_PWD_EMPTY_ERROR);
			bo.setMsg("The password can't be blank.");
			return bo;
		}//新密码为空
		if(oldPassword.equals(newPassword)){
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("密码与原密码一致");
			return bo;
		}
		if(StringUtils.isBlank(payload.getRePassword())){
			bo = BoUtil.getDefaultFalseBo();
			bo.setCode(ErrorCode.ACCOUNT_PWD_EMPTY_ERROR);
			bo.setMsg("The username or password can't be blank.");
			return bo;
		}//确认新密码为空
		if(Pattern.compile("[\u0391-\uFFE5]+", Pattern.CASE_INSENSITIVE).matcher(payload.getNewPassword()).find()){
			bo = BoUtil.getDefaultFalseBo();
			bo.setCode(ErrorCode.PASSWORD_IS_CHINESE_ERROR);
			bo.setMsg("Password is chinese error");
			return bo;
		}//密码格式错误
		if (!payload.getNewPassword().equals(payload.getRePassword())) {
			bo = BoUtil.getDefaultFalseBo();
			bo.setCode(ErrorCode.PWD_NOT_SAME_ERROR);
			bo.setMsg("Confirm password inconsistency!");
			return bo;
		}//两次输入密码不一致
		
		oldPassword = Md5Util.encryption(oldPassword);
		boolean bool = authService.passwordValidation(userId, oldPassword);
		if(!bool) {
			bo.setMsg("Your current password is incorrect");
			bo.setCode(ErrorCode.PWD_NOT_SAME_ERROR);
			return bo;
		}//旧密码错误
		
		newPassword = Md5Util.encryption(newPassword);
		BossUserAccount busicUser = BossUserAccount.builder().userId(userId).password(newPassword).build();
		int result = bossUserAccountService.update(busicUser);
		if(result > 0 ) {
			bo = BoUtil.getDefaultTrueBo();
					return bo;
		} else {
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("update passWord fail");
			bo.setCode(ErrorCode.UPDATE_PASSWORDA_FAIL);
			return bo;
		}
	}
	
	
	
}
