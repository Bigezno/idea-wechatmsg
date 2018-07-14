package com.plusmoney.wechat.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

public class Formatter {
	
	private static Logger logger = Logger.getLogger(Formatter.class);
	/**
	 * 本方法会从前往后替换sentences中的?号 如 姓名 ？ 性别 ？，参数 张三 ，男
	 * 则返回String 姓名 张三 性别 男
	 * @param sentences
	 * @param params
	 * @return
	 */
	public static String aformat(String sentences,Object... params){
		int i = 0;
		String result = sentences;
		try {
			while(result.contains("?")){
				try {
					Object trya = params[i];
				} catch (Exception e) {
					i = 0;
				}
				String param = params[i]==null?"[paramsNull]":String.valueOf(params[i]);
				/*if(params[i] instanceof String){
					param = new String ("'"+param+"'");
				}*/
				try {
					result = result.replaceFirst("\\?", URLEncoder.encode(param, "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				i++;
			}
			result = URLDecoder.decode(result, "UTF-8");
		} catch (Exception e) {
			logger.info("打日志出错，原句为："+sentences);
		}
		return result;
	}
}
