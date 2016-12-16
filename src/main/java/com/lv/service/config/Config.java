package com.lv.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Title: Config.java
 * @Package com.manboker.service.config
 * @author 吕国栋 JessonLv mail:okstack@gmail.com
 * @date 2015年9月24日 上午10:12:39
 * @Description: TODO
 * @version V1.0
 */

@Service
public class Config {

	/** test key  **/
	@Value("${key}")
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
