package com.hd.cloud.dao.biz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.CompanyBo;
import com.hd.cloud.dao.biz.sql.CompanyProvider;
import com.hd.cloud.vo.CompanyVo;

@Mapper
public interface CompanyMapper {
	
	@SelectProvider(type = CompanyProvider.class,method = "getCompanyList")
	@Results(value = {
			@Result(property = "companyId", column = "biz_mobiz_company_bd_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "companyName", column = "mobiz_company_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "type", column = "mobiz_company_scale_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "status", column = "mobiz_company_check_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "contacter", column = "mobiz_company_contacter", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "contacterPhone", column = "mobiz_company_contact_phone", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "adress", column = "mobiz_company_address", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "commitDate", column = "mobiz_company_check_date", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "checkDate", column = "mobiz_company_commit_date", javaType = String.class, jdbcType = JdbcType.VARCHAR),
	})
	List<CompanyBo> getCompanyList(CompanyVo companyVo);
	
	@SelectProvider(type = CompanyProvider.class,method = "getCompanyCount")
	int getCompanyCount(CompanyVo companyVo);
}
