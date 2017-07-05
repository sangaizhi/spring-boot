
package org.sangaizhi.springboot.redis.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

/**
 * 单节点 redis 配置
 * @author sangaizhi
 * @date 2017/7/4
 */

@Configuration
@EnableAutoConfiguration
public class RedisConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.redis")
	public JedisPoolConfig getJedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		return jedisPoolConfig;
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.redis")
	public JedisConnectionFactory getJedisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		JedisPoolConfig poolConfig = getJedisPoolConfig();
		factory.setPoolConfig(poolConfig);
		return factory;
	}

	@Bean
	public RedisTemplate<?, ?> getRedisTemplate() {
		RedisTemplate<?, ?> redisTemplate = new StringRedisTemplate(getJedisConnectionFactory());
		return redisTemplate;
	}
}
