package com.music.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Ivan
 * @date 2020-10-11 22:23
 */
@Slf4j
@Component
public class RedisUtil {
	@Autowired
	private JedisPool jedisPool;

	/**
	 * 功能描述: 缓存String到redis中
	 *
	 * @param key
	 * @param value
	 * @return void
	 * @author Ivan
	 * @date 2020-10-11 22:41:19
	 */
	public void set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {
			log.error("redis exception:", e);
		} finally {
			close(jedis);
		}
	}

	/**
	 * 功能描述: 缓存String到redis seconds秒,
	 *
	 * @param key
	 * @param value
	 * @param seconds
	 * @return void
	 * @author Ivan
	 * @date 2020-10-11 22:44:32
	 */
	public void set(String key, String value, int seconds) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.setex(key, seconds, value);
		} catch (Exception e) {
			log.error("redis exception:", e);
		} finally {
			close(jedis);
		}
	}

	/**
	 * 功能描述: 根据key获取缓存数据
	 *
	 * @param key
	 * @return java.lang.String
	 * @author Ivan
	 * @date 2020-10-11 22:46:18
	 */
	public String get(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String str = jedis.get(key);
			return str;
		} catch (Exception e) {
			log.error("redis exception:", e);
			return null;
		} finally {
			close(jedis);
		}
	}

	/**
	 * 功能描述: 关闭jedis连接
	 *
	 * @param jedis
	 * @return void
	 * @author Ivan
	 * @date 2020-10-11 22:48:47
	 */
	private void close(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}
}
