package com.hd.cloud;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BizDataSourceConfig {
	
	@Bean(name = "bizDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.asc_biz")
	public DataSource bizDataSource() {
		return DataSourceBuilder.create().build();
	}
}
