package com.hd.cloud;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MomentDataSourceConfig {
	


	@Bean(name = "momentDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.asc_service")
	public DataSource momentDataSource() {
		return DataSourceBuilder.create().build();
	}
}
