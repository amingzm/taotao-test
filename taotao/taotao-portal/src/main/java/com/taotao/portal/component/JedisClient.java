package com.taotao.portal.component;

import java.util.List;
import java.util.Map;

public interface JedisClient {

	public String set(String key, String value);
	public String get(String key);
	public Long hset(String key, String item, String value);
	public String hget(String key, String item);
	public Long incr(String key);
	public Long decr(String key);
	public Long expire(String key, int second);
	public Long ttl(String key);
	public Long hdel(String key, String item);
	public void del(String key);
	public Map<String, String> hgetAll(String key);
	
}