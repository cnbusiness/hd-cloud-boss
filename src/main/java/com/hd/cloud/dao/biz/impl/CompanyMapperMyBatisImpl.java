package com.hd.cloud.dao.biz.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.CompanyBo;
import com.hd.cloud.dao.biz.CompanyDao;
import com.hd.cloud.dao.biz.mapper.CompanyMapper;
import com.hd.cloud.vo.CompanyVo;

@Repository
public class CompanyMapperMyBatisImpl implements CompanyDao{
	
	@Inject
	private CompanyMapper companyMapper;
	
	@Override
	public List<CompanyBo> getCompanyList(CompanyVo companyVo) {
		// TODO Auto-generated method stub
		return companyMapper.getCompanyList(companyVo);
	}

	@Override
	public int getCompanyCount(CompanyVo companyVo) {
		// TODO Auto-generated method stub
		return companyMapper.getCompanyCount(companyVo);
	}

}
