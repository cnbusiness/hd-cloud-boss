package com.hd.cloud;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = { "com.hd.cloud.dao.biz.mapper" }, sqlSessionFactoryRef = "bizSqlSessionFactory" )
public class MybatisBizConfig {

	@Autowired
	@Qualifier("bizDataSource")
	private DataSource bizDataSource;

	@Bean
	public SqlSessionFactory bizSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(bizDataSource);
		return factoryBean.getObject();

	}

	@Bean
	public SqlSessionTemplate bizSqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(bizSqlSessionFactory());
		return template;
	}
}