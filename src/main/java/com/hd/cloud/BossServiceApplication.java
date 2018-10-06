package com.hd.cloud;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
  * @ClassName: BossServiceApplication
  * @Description: boss 管理
  * @author ShengHao shenghaohao@hadoop-tech.com
  * @Company hadoop-tech 
  * @date 2018年4月4日 下午12:26:39
  *
 */
@Slf4j
@EnableCaching
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class BossServiceApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(BossServiceApplication.class, args);
	}
	
	// 注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(competenceInteceptor());
	}

	// 自定义拦截器
	@Bean
	public CompetenceInteceptor competenceInteceptor() {
		return new CompetenceInteceptor();
	}


	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);

		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
				Object.class);
		ObjectMapper objectMapperm = new ObjectMapper();
		objectMapperm.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapperm.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapperm);
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.afterPropertiesSet();
		log.info("####redisConnectionFactory:{}", redisConnectionFactory);
		return redisTemplate;
	}

	@Bean
	public HttpMessageConverters faHttpMessageConverters() {
		FastJsonHttpMessageConverter faConverter = new FastJsonHttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(MediaType.APPLICATION_JSON);
		supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
		supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
		supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
		supportedMediaTypes.add(MediaType.APPLICATION_PDF);
		supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
		supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
		supportedMediaTypes.add(MediaType.APPLICATION_XML);
		supportedMediaTypes.add(MediaType.IMAGE_GIF);
		supportedMediaTypes.add(MediaType.IMAGE_JPEG);
		supportedMediaTypes.add(MediaType.IMAGE_PNG);
		supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
		supportedMediaTypes.add(MediaType.TEXT_HTML);
		supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
		supportedMediaTypes.add(MediaType.TEXT_PLAIN);
		supportedMediaTypes.add(MediaType.TEXT_XML);
		faConverter.setSupportedMediaTypes(supportedMediaTypes);
		return new HttpMessageConverters(faConverter);
	}
	
	@Component
	@ConfigurationProperties(prefix = "token.expire.time")
	@Data
	public static class ExpireTimeConfig {
		private int time;
	}
	
	@Data
	public static class RSAData {
		private String publicKey;
		private String privateKey;
	}

	@Component
	@ConfigurationProperties(prefix = "rsa.json")
	public static class RSAConfig extends RSAData {

	}
	
	@Component
	@ConfigurationProperties(prefix = "file.upload.config")
	@Data
	public static class FileConfig {
		private String domain;
		private String uploadDomain;
	}
}
