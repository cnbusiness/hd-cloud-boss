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

import com.hd.cloud.bo.CompanyBo;
import com.hd.cloud.service.CompanyService;
import com.hd.cloud.vo.CompanyVo;
import com.hlb.cloud.bo.BoUtil;

import io.swagger.annotations.ApiOperation;

/**
 * 公司管理
 * @ClassName CompanyResource.java
 * @Description 
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月4日 下午12:20:37
 *
 */
@RefreshScope
@RestController
@RequestMapping("company")
public class CompanyResource {
	
	@Inject
	private CompanyService companyService;
	
	/**
	 * 
	 * @Title:getCompanyList
	 * @Description:公司列表
	 * @param page
	 * @param pageSize
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "GET",value = "companyList" ,notes="companyList")
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json",consumes = "application/*")
	public BoUtil getCompanyList(@QueryParam("page") Integer page,@QueryParam("pageSize") Integer pageSize){
		page = page == null ? 1 :page;
		pageSize = pageSize == null ? 10 :pageSize; 
		int offset = (page - 1 ) * pageSize;
		BoUtil bo = BoUtil.getDefaultTrueBo();
		CompanyVo companyVo = CompanyVo.builder().offset(offset).pageSize(pageSize).build();
		int total = companyService.getCompanyCount(companyVo);
		List<CompanyBo> companyBos = companyService.getCompanyList(companyVo);
		Map<String,Object> map = new HashMap<String , Object>();
		map.put("list",companyBos);
		map.put("totalItems", total);
		bo.setData(map);
		return bo;
	}
}
