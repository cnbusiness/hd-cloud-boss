package com.hd.cloud;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hd.cloud.service.AuthService;
import com.hlb.cloud.bo.BoUtil;
import com.hlb.cloud.util.BaseUtil;
import com.hlb.cloud.util.CommonErrorCode;
import com.hlb.cloud.util.ValidateUtil;

@Slf4j
public class CompetenceInteceptor extends HandlerInterceptorAdapter {

	@Autowired
	private AuthService authService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("=============start call obo =============");
		String requestUri = request.getRequestURI();
		boolean bool = false;
		String id = request.getHeader("userId");
		String token = request.getHeader("token");
		log.info("requestUri : {}, id : {}, token : {}", requestUri, id, token);
		long userId = 0;
		if (id != null && token != null && ValidateUtil.isNumber(id)) {
			userId = Long.parseLong(id);
			bool = authService.isValidTokenPare(userId, token);
		}
		// 过滤掉不需要验证的模块
		if (requestUri.indexOf("nofilter") >= 0 || requestUri.indexOf(".html") >= 0) {
			bool = true;
		}
		if (!bool) {
			BoUtil boUtil = BoUtil.getDefaultFalseBo();
			boUtil.setCode(CommonErrorCode.TOKEN_INVALID);
			response.getWriter().write(JSONObject.fromObject(boUtil).toString());
			// 验证不通过 返回401
			response.setStatus(401);
			return false;
		} else {
			response.addHeader(BaseUtil.LOGIN_USERID, String.valueOf(userId));
			response.addHeader(BaseUtil.LOGIN_TOKEN, token);
		}
		log.info("=============end call obo=============");
		return true;
	}
}
