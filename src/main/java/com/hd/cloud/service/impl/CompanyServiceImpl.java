package com.hd.cloud.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.CompanyBo;
import com.hd.cloud.dao.biz.CompanyDao;
import com.hd.cloud.service.CompanyService;
import com.hd.cloud.vo.CompanyVo;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Inject
	public CompanyDao companyDao;
	
	@Override
	public List<CompanyBo> getCompanyList(CompanyVo companyVo) {
		// TODO Auto-generated method stub
		return companyDao.getCompanyList(companyVo);
	}

	@Override
	public int getCompanyCount(CompanyVo companyVo) {
		// TODO Auto-generated method stub
		return companyDao.getCompanyCount(companyVo);
	}

}
