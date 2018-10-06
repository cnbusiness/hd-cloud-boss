package com.hd.cloud.dao.biz;

import java.util.List;

import com.hd.cloud.bo.CompanyBo;
import com.hd.cloud.vo.CompanyVo;

public interface CompanyDao {
	
	/**
	 * 
	 * @Title:getCompanyList
	 * @Description:公司列表
	 * @param companyVo
	 * @return List<CompanyBo>
	 */
	public List<CompanyBo> getCompanyList(CompanyVo companyVo);
	
	/**
	 * 
	 * @Title:getCompanyCount
	 * @Description:公司总数
	 * @param companyVo
	 * @return int
	 */
	public int getCompanyCount(CompanyVo companyVo);
}
