package com.plusmoney.wechat.util;

import org.apache.log4j.Logger;

public class PlusLogger {
	public static void logNormal(Class clazz,String openId,String msg){
		Logger logger = Logger.getLogger("plus_all");
    	logger.info(String.format("[openid %s][clazz %s][ProgrammerRecord %s]%n",openId,clazz.getName(),msg));
	}
//	public static void logCatch(Class clazz,String msg,String routeid,Exception e){
//		Logger logger = Logger.getLogger(clazz);
//    	logger.error(String.format("[routeid %s] [ProgrammerRecord %s ]%n", routeid,msg),e);
//	}
	public static void LogError(Class clazz,String openId,String msg){
		Logger logger = Logger.getLogger("plus_error");
    	logger.error(String.format("[openid %s][clazz %s][ProgrammerRecord %s]%n",openId,clazz.getName(),msg));
	}
	public static void LogFinished(Class clazz){
		Logger logger = Logger.getLogger("plus_all");
    	logger.info(String.format("[clazz %s][ProgrammerOut logFinished ]%n%n",clazz.getName()));
	}
}
