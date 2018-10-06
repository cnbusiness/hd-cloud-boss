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

/**
 * 
 * @ClassName MybatisBossConfig.java
 * @Description  BOSS
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年4月26日 下午5:34:39
 *
 */
@Configuration
@MapperScan(basePackages = { "com.hd.cloud.dao.boss.mapper" }, sqlSessionFactoryRef = "bossSqlSessionFactory")
public class MybatisBossConfig {

	@Autowired
	@Qualifier("bossDataSource")
	private DataSource bossDataSource;

	@Bean
	public SqlSessionFactory bossSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(bossDataSource);
		return factoryBean.getObject();

	}

	@Bean
	public SqlSessionTemplate bossSqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(bossSqlSessionFactory());
		return template;
	}
}
