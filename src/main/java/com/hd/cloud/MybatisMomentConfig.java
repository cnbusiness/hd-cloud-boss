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
 * @ClassName MybatisServiceConfig.java
 * @Description service
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年4月26日 下午5:37:06
 *
 */

@Configuration
@MapperScan(basePackages = { "com.hd.cloud.dao.moment.mapper" }, sqlSessionFactoryRef = "momentSqlSessionFactory")
public class MybatisMomentConfig {

	@Autowired
	@Qualifier("momentDataSource")
	private DataSource momentDataSource;

	@Bean
	public SqlSessionFactory momentSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(momentDataSource);
		return factoryBean.getObject();

	}

	@Bean
	public SqlSessionTemplate momentSqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(momentSqlSessionFactory());
		return template;
	}
}
