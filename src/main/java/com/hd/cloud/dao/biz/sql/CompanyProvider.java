package com.hd.cloud.dao.biz.sql;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.vo.CompanyVo;

public class CompanyProvider {
	
	public String getCompanyList(CompanyVo companyVo){
		
		String sql = new SQL(){
			{
				SELECT("biz_mobiz_company_bd_seq,mobiz_company_name,mobiz_company_scale_itype,mobiz_company_check_itype,mobiz_company_contacter,mobiz_company_contact_phone,mobiz_company_address,mobiz_company_check_date,mobiz_company_commit_date");
				FROM("biz_mobiz_company_bd");
				WHERE("active_flag = 'y'");
				ORDER_BY("biz_mobiz_company_bd_seq desc limit #{offset},#{pageSize}");
				}
			}.toString();
			return sql;
	 	}
		
		public String getCompanyCount(CompanyVo companyVo){
			String sql = new SQL(){
				{
					SELECT("COUNT(1)");
					FROM("biz_mobiz_company_bd");
					WHERE("active_flag = 'y'");
				}
			}.toString();
			return sql;
					
		}
}

