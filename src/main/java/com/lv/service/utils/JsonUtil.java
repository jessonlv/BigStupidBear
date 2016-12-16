package com.lv.service.utils;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * 工具类
 * 
 * */

public class JsonUtil {

	static JSONObject json = new JSONObject();

	// 组装数据 返回给前端
	public static String toJsonString(List<?> list, int statusCode) {
		JSONArray array = new JSONArray();
		for (Object object : list) {
			array.add(object);
		}
		JSONObject obj = new JSONObject();

		obj.put("CurrentTime", System.currentTimeMillis());
		obj.put("Code", statusCode);
		obj.put("Total", list.size());
		obj.put("Rows", array);

		return obj.toJSONString();
	}

	public static  <T> T toObject(JSONObject json,Class<T> classOfT){
		return  json.toJavaObject(classOfT);
	}

	public static String toString(Object object){

		return json.toJSONString(object);
	}

}
