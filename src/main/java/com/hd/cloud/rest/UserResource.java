package com.hd.cloud.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.ws.rs.QueryParam;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hd.cloud.bo.Auth;
import com.hd.cloud.bo.UserBo;
import com.hd.cloud.service.UserService;
import com.hd.cloud.util.ErrorCode;
import com.hd.cloud.util.Md5Util;
import com.hd.cloud.vo.AdStatusVo;
import com.hd.cloud.vo.CreateUserVo;
import com.hd.cloud.vo.UpdateUserVo;
import com.hd.cloud.vo.UserAccountVo;
import com.hd.cloud.vo.UserFreezeVo;
import com.hd.cloud.vo.UpdateUserPwdVo;
import com.hlb.cloud.bo.BoUtil;
import com.hlb.cloud.util.CommonErrorCode;
import com.hlb.cloud.util.ValidateUtil;

import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName UserResource.java
 * @Description 用户管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年4月12日 下午4:49:53
 *
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("user")
public class UserResource {
	
	private UserService userService;
	
	@Inject
	public UserResource(final @NonNull UserService userService){
		this.userService = userService;
	}
	
	/**
	 * 
	 * @Title:getUserBoList
	 * @Description:用户列表
	 * @param page
	 * @param pageSize
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "GET", value = "userList",notes="userList")
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getUserBoList(@QueryParam("userId") Integer userId,
			@QueryParam("nickName") String nickName,
			@QueryParam("phone") String phone,
			@QueryParam("page") Integer page,@QueryParam("pageSize") Integer pageSize ){
		page = page == null ? 1 :page;
		pageSize = pageSize == null ? 10 :pageSize;
		int offset = (page - 1 ) * pageSize;
		userId=userId==null ? 0 :userId;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		UserAccountVo userAccountVo = UserAccountVo.builder().offset(offset).pageSize(pageSize).nickName(nickName).phone(phone).userId(userId)
				.build();
		int total = userService.getUserBoCount(userAccountVo);
		List<UserBo> userBos = userService.getUserBoList(userAccountVo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", userBos);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
	
	/**
	 * 
	 * @Title:updateUserBoListByUserIds
	 * @Description:批量冻结用户
	 * @param userId
	 * @param userIds
	 * @return List<UserBo>
	 */
	@ApiOperation(httpMethod = "PUT",value = "批量冻结用户", notes = "批量冻结用户")
	@ResponseBody
	@RequestMapping(value = "/freezelist",method = RequestMethod.PUT,produces = "application/json; charset=UTF-8",consumes = "application/json; charset=UTF-8")
	public List<UserBo> updateUserBoListByUserIds(final @RequestBody UserFreezeVo userFreezeVo) {
		List<UserBo> list = userService.updateUserBoListByUserIds(userFreezeVo.getUserIds());
		log.info("###############list :{}", list);
		return list;
	}
	
	/**
	 * 
	 * @Title:save
	 * @Description:添加用户
	 * @param createUserVo
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "POST",value = "新增用户", notes = "新增用户")
	@ResponseBody
	@RequestMapping(value = "/add",method = RequestMethod.POST,produces = "application/json",consumes="application/json")
	public BoUtil save(final @RequestBody CreateUserVo createUserVo) {
		BoUtil bo = BoUtil.getDefaultFalseBo();
		log.info("############createUserVo: {}",createUserVo);
		String phone=createUserVo.getPhone();
		if(StringUtils.isBlank(createUserVo.getPhone())|| ValidateUtil.validatePhone(createUserVo.getCountryCode(), phone) == false){
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("the phone number format is incorrect!");
			bo.setCode(ErrorCode.PHONE_FORMAT_ERROR);
			return bo;
		}
		if(StringUtils.isBlank(createUserVo.getPassword())){
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("the phone number or password can't be blank.");
			bo.setCode(ErrorCode.ACCOUNT_PWD_EMPTY_ERROR);
			return bo;
		}
		if (Pattern.compile("[\u0391-\uFFE5]+", Pattern.CASE_INSENSITIVE).matcher(createUserVo.getPassword()).find()) { // 判断密码是否有中文和中文符号
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("Password is chinese error");
			bo.setCode(ErrorCode.PASSWORD_IS_CHINESE_ERROR);
			return bo;
		}
		StopWatch swHasRegByPhoneNo = new StopWatch();
		swHasRegByPhoneNo.start();
		UserBo basicUser = userService.getUserBoByPhone(createUserVo.getPhone());
		swHasRegByPhoneNo.stop();
		if(basicUser != null){
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("the phone has registed!");
			bo.setCode(ErrorCode.PHONE_IS_BINDING);
			return bo;
		}
		bo.setResult(true);
		String md5pwd="";
		md5pwd= DigestUtils.sha256Hex(createUserVo.getPassword());
		createUserVo.setPassword(md5pwd);
		Auth authBo;
		try{
			authBo = userService.save(createUserVo);
			log.info("UserBo={}",authBo);
		} catch(Exception e){
			e.printStackTrace();
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("register faild");
			bo.setCode(ErrorCode.ACCOUN_REGISTED_ERROR);
			return bo;
		}
		if(null == authBo){
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("register faild");
			bo.setCode(ErrorCode.ACCOUN_REGISTED_ERROR);
			return bo;
		}
		bo.setCode(CommonErrorCode.SUCCESS);
		bo.setMsg("success");
		// 改成直接返回authBo
		bo.setData(authBo);
		return bo;
	}
		
	/**
	 * 
	 * 
	 * @Title:getUserProfileByUserId
	 * @Description:查看用户详情
	 * @param userId
	 * @return UserProfile
	 */
	@ApiOperation(httpMethod = "GET",value = "查看用户详情",notes= "查看用户详情")
	@ResponseBody
	@RequestMapping(value = "/detail" , method= RequestMethod.GET,produces="application/json",consumes = "application/*")
	public BoUtil getUserBoByUserId(@QueryParam("userId") long userId) {
		BoUtil bo = BoUtil.getDefaultTrueBo();
		UserBo userBo = userService.getUserBoByUserId(userId);
		log.info("########用户详情userBo:{}" ,userBo);		
		bo.setData(userBo);
		System.out.println(userBo);
		return bo;
	}
	
	/**
	 * 
	 * @Title:update
	 * @Description:编辑用户信息
	 * @param userBo
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "PUT" ,value = "updateUser",notes = "updateUser")
	@ResponseBody
	@RequestMapping(value = "/edit",method = RequestMethod.PUT,produces="application/json",consumes = "application/json")
	public BoUtil update(@RequestBody UpdateUserVo payload){
		BoUtil bo = BoUtil.getDefaultFalseBo();
		log.info("##########payload:{}",payload);
		UserBo userBo= UserBo.builder().userId(payload.getUserId()).countryCode(payload.getCountryCode()).nickName(payload.getNickName()).birthday(payload.getBirthday()).status(payload.getStatus())
				.sex(payload.getSex()).phone(payload.getPhone()).updateBy(10000).build();
		log.info("##########userBo:{}",userBo);
		int  result = userService.update(userBo);
		if (result > 0){
			bo = BoUtil.getDefaultTrueBo();
			bo.setMsg("编辑成功");
		}else{
			bo.setMsg("编辑失败");
		}
		return bo;
		
	}
	
	/**
	 * 
	 * @Title:updateStatus
	 * @Description:修改用户状态
	 * @param userBo
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "PUT",value = "PUT", notes = "PUT")
	@ResponseBody
	@RequestMapping(value = "/status",method = RequestMethod.PUT,produces = "application/json",consumes = "application/json")
	public BoUtil updateStatus(final @RequestBody AdStatusVo adStatusVo){
		BoUtil bo = BoUtil.getDefaultTrueBo();
		log.info("########adStatusVo:{}" +adStatusVo);
		UserBo userBo= UserBo.builder().userId(adStatusVo.getUserId()).status(adStatusVo.getStatus()).build();
		int result = userService.updateStatus(userBo);
		if(result > 0) {
			bo.setMsg("更新成功");
		}else {
			bo = BoUtil.getDefaultFalseBo();
			bo.setMsg("更新失败");
		}
		return bo;
	}
	
	/**
	 * 
	 * @Title:updatepwd
	 * @Description:重置密码
	 * @param payload
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "PUT",value = "password",notes = "password")
	@ResponseBody
	@RequestMapping(value = "/password",method = RequestMethod.PUT,produces = "application/json",consumes = "application/json")
	public BoUtil updatepwd(final @RequestBody UpdateUserPwdVo payload) {
		BoUtil bo = BoUtil.getDefaultTrueBo();
		log.info("########payload:{}",payload);
		if(StringUtils.isBlank(payload.getNewPassword())){
			bo = BoUtil.getDefaultFalseBo();
			bo.setCode(ErrorCode.ACCOUNT_PWD_EMPTY_ERROR);
			bo.setMsg("The password can't be blank.");
			return bo;
		}
		if(StringUtils.isBlank(payload.getRePassword())){
			bo = BoUtil.getDefaultFalseBo();
			bo.setCode(ErrorCode.ACCOUNT_PWD_EMPTY_ERROR);
			bo.setMsg("The password can't be blank.");
			return bo;
		}
		if(Pattern.compile("[\u0391-\uFFE5]+", Pattern.CASE_INSENSITIVE).matcher(payload.getNewPassword()).find()){
			bo = BoUtil.getDefaultFalseBo();
			bo.setCode(ErrorCode.PASSWORD_IS_CHINESE_ERROR);
			bo.setMsg("Password is chinese error");
			return bo;
		}
		if (!payload.getNewPassword().equals(payload.getRePassword())) {
			bo = BoUtil.getDefaultFalseBo();
			bo.setCode(ErrorCode.PWD_NOT_SAME_ERROR);
			bo.setMsg("Confirm password inconsistency!");
			return bo;
		}
		
		String md5Pwd= "";
		md5Pwd = DigestUtils.sha256Hex(payload.getNewPassword());
		UserBo userBo = UserBo.builder().userId(payload.getUserId()).password(md5Pwd).build();
		int result = userService.update(userBo);
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
