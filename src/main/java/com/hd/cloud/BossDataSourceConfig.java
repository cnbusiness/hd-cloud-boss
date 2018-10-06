package com.hd.cloud;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @ClassName DataSourceConfig.java
 * @Description 数据源
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年4月25日 上午9:49:30
 *
 */
@Configuration
public class BossDataSourceConfig {

	@Bean(name = "bossDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.asc_user")
	public DataSource bossDataSource() {
		return DataSourceBuilder.create().build();
	}
}
