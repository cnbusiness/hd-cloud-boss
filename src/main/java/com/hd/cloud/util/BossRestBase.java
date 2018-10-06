package com.hd.cloud.util;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.hlb.cloud.util.BaseUtil;

//import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Administrator
 *
 */
public class BossRestBase {
	@Context
	HttpHeaders header;

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;

	/**
	 * 
	 * @Title: getLoginUserID
	 * @param:
	 * @Description:
	 * @return long
	 */
	public long getLoginUserID() {
		Long loginUserId = (Long) request.getSession().getAttribute(
				BaseUtil.LOGIN_USERID);
		if (loginUserId == null) {
			loginUserId = 0L;
		}
		return loginUserId;
	}
	

	
	/**
	 * 
	 * @Title: getOutputStream
	 * @param:
	 * @Description:
	 * @return long
	 * @throws IOException
	 */
	public OutputStream getOutputStream() throws IOException {
		// 设置不缓存图片
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		// 指定生成的相应图片
		response.setContentType("image/jpeg");
		return response.getOutputStream();
	}

	
	/**
	 * 
	 * @Title: getOutputStream
	 * @param:
	 * @Description:
	 * @return long
	 * @throws IOException
	 */
	public HttpServletRequest getRequest() throws IOException {
		return request;
	}
}
