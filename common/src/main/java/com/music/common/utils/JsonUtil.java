package com.music.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Ivan
 * @date 2020-10-11 20:15
 *
 * FastJson工具类
 */
public class JsonUtil {

	/**
	 *
	 * 功能描述: 转String类型
	 *
	 * @author Ivan
	 * @date 2020-10-11 20:20:29
	 * @param o
	 * @return java.lang.String
	 */
	public static String getString(Object o) {
		if(o == null){
			return null;
		}
		return JSONObject.toJSONString(o);
	}

	/**
	 *
	 * 功能描述: 字符串转json
	 *
	 * @author Ivan
	 * @date 2020-10-11 21:15:47
	 * @param str
	 * @return com.alibaba.fastjson.JSONObject
	 */
	public static JSONObject getJson(String str){
		if(StringUtils.isBlank(str)){
			return null;
		}
		return JSONObject.parseObject(str);
	}

	/**
	 *
	 * 功能描述: 字符串转Map
	 *
	 * @author Ivan
	 * @date 2020-10-11 21:16:21
	 * @param str
	 * @return java.util.Map
	 */
	public static Map getMap(String str){
		if(StringUtils.isBlank(str)){
			return null;
		}
		Map map = JSONObject.parseObject(str, Map.class);
		return map;
	}

}
