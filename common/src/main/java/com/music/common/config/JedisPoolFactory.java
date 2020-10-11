package com.music.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Ivan
 * @date 2020-10-11 21:54
 *
 * jedisPool配置类
 */
@Configuration
public class JedisPoolFactory {
	@Value("${spring.redis.jedis.pool.max-active}")
	private int maxTotal;
	@Value("${spring.redis.jedis.pool.min-idle}")
	private int minIdle;
	@Value("${spring.redis.jedis.pool.max-idle}")
	private int maxIdle;
	@Value("${spring.redis.password}")
	private String password;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.redis.database}")
	private int database;
	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.jedis.pool.time-out}")
	private int timeout;


	@Bean
	public JedisPool getJedisPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setTestOnBorrow(true);
		config.setMaxTotal(maxTotal);
		config.setMinIdle(minIdle);
		config.setMaxIdle(maxIdle);
		JedisPool jedisPool = new JedisPool(config, host, port, timeout, password, database);
		return jedisPool;
	}
}
