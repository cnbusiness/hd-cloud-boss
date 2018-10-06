package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.CompanyBo;
import com.hd.cloud.vo.CompanyVo;

public interface CompanyService {
	
	public List<CompanyBo> getCompanyList(CompanyVo companyVo);
	
	public int getCompanyCount(CompanyVo companyVo);
}
