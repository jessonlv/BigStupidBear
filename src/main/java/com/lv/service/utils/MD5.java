package com.lv.service.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import org.apache.http.protocol.HTTP;

/**
 * @Title: MD5.java
 * @Package com.service.express.util
 * @author 吕国栋 JessonLv mail:okstack@gmail.com
 * @date 2015年7月6日 下午1:56:51
 * @Description: TODO(用一句话描述该文件做什么)
 * @version V1.0
 */

public class MD5 {

	/***
	 * MD5加码 生成32位md5码
	 */
	public static String string2MD5(String pwd) throws UnsupportedEncodingException {
		// 将字符串转换为字节数组
		@SuppressWarnings("deprecation")
		byte[] toChapter = pwd.getBytes(HTTP.UTF_8);
		// md5str用来保存字节数组转换成的十六进制数
		StringBuffer md5str = new StringBuffer();
		try {
			// 得到一个实现特定摘要算法的消息摘要对象
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			// 将字节数组toChapter添加到待计算MD5值的字节序列中
			md5.update(toChapter);
			// 计算字节序列的MD5值，返回16个字节的字节数组，保存到toChapterDigest
			byte[] toChapterDigest = md5.digest();

			// 每个8位的二进制字节用十六进制表示的话，需要两个字符，每个十六进制字符对应四位二进制位
			// 故16个字节(128bit)转换后，变为了32个字符的字符串，将它们添加到md5str中

			int digital;
			for (int i = 0; i < toChapterDigest.length; i++) {
				digital = toChapterDigest[i];
				// 这里字节类型赋值给int类型，会按符号位扩展的
				// 如果字节的最高位是1，扩展为int时它的高位(9-32位)都会变为1
				if (digital < 0) {
					// 将8位字节之前的高位全变为0
					digital += 256;
				}
				if (digital < 16) {
					md5str.append("0");
				}
				// 经过判断之后的操作，能保证digtal转换为十六进制字符的时候只得到两位
				md5str.append(Integer.toHexString(digital).toUpperCase());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回十六进制字符串
		return md5str.toString();
	}
	
	
	public static boolean checkSign(String json, String sign) {
		boolean result = false;
		
		try {
			String signCheck = MD5.string2MD5(json);
			signCheck = signCheck + signCheck.substring(0, signCheck.length()/2);
			if(signCheck.equals(sign)) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 *获取魔漫逻辑的sign
	 * 
	 **/
	public static String getRequestSign(String json) {
		String signCheck = "";
		try {
			signCheck = MD5.string2MD5(json);
			signCheck = signCheck + signCheck.substring(0, signCheck.length()/2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return signCheck;
	}
	
	
	public static void main(String[] args) {
		checkSign("{\"userId\":\"102727729\",\"pageRecordNum\":10}", "");
		
		
		try {
			System.out.println(string2MD5("{}"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
