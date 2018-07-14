package com.plusmoney.wechat.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSONObject;
import com.plusmoney.jdbc.util.DBUtils;
import com.plusmoney.wechat.dao.WechatAtDao;
import com.plusmoney.wechat.dao.impl.WechatAtDaoImpl;
import com.plusmoney.wechat.entity.AccessToken;
import com.plusmoney.wechat.entity.MsgBody;
import com.plusmoney.wechat.entity.MsgTemplateId;
import com.plusmoney.wechat.util.HttpUtils;
import com.plusmoney.wechat.util.MethodConstructor;

public class Sender {
	
	private static Logger logger = Logger.getLogger(Sender.class);
			
	private Connection getConnection(String conName) throws Throwable {
		try {
			return DBUtils.getConnection(conName);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			if (SQLException.class.isAssignableFrom(e.getClass())) {
				throw new Throwable("10005", e);
			} else {
				throw new Throwable("60006", e);
			}
		}
	}
	/**
	 * @发送模板消息
	 * 参数msgTemplateId用MsgTemplateId类里的常数。
	 * 根据类里的模板样式来决定用哪个。
	 * 返回微信返回消息的json字符串
	 * 格式如{"errcode":0,"errmsg":"ok","msgid":209249937}
	 * @param sendMethod
	 * @param mb
	 */
	public String sendMsg(String msgTemplateId,MsgBody mb,String url,String methodName)  throws Throwable {
		try {
			/**
			 * 初始化区域
			 */
			String result = null;
			String keywordChangeFlag = null;
			if(MsgTemplateId.MONEY_CHANGED.equals(msgTemplateId)){
				keywordChangeFlag = "money_changed";
			}else if(MsgTemplateId.FRIENDS_BANEFIT.equals(msgTemplateId)){
				keywordChangeFlag = "FRIENDS_BANEFIT";
			}else if(MsgTemplateId.GET_LUCKEYMONEY.equals(msgTemplateId)){
				keywordChangeFlag = "GET_LUCKEYMONEY";
			}
			 String touser = mb.getUserOpenId();
			/**
			 * 初始化区域
			 */
			if(keywordChangeFlag==null){
				String msg = MethodConstructor.constractNormal(mb,touser,msgTemplateId,url);
			    logger.info("发送微信消息 "+msg);
			    String at = getAccessToken();
			    result = HttpUtils.sendPostJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+at, msg);
			    logger.info("发送结果为 "+result);
			    String checkResult = checkRightOrWrong(result);
			    if(!checkResult.equals("ok")){
			    	logger.info("at过期，重发");
			    	result = HttpUtils.sendPostJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+checkResult, msg);
			        logger.info("重发结果为 "+result);
			    }
			    JSONObject resultJ = JSONObject.parseObject(result);
			    int errcode = resultJ.getInteger("errcode");
			    if(errcode==0){
			    	insertPMAPPmsg(touser, mb, methodName);
			    	return "ok";
			    }else{
			    	logger.info("*****************************************************");
			    	logger.info("send msg faile wechat said "+result);
			    	logger.info("*****************************************************");
			    	return "fail";
			    }
			}else if("money_changed".equals(keywordChangeFlag)){
				String msg = MethodConstructor.constractMoneyChanged(mb, touser, msgTemplateId, url);
			    logger.info("发送微信消息 "+msg);
			    String at = getAccessToken();
			    result = HttpUtils.sendPostJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+at, msg);
			    logger.info("发送结果为 "+result);
			    String checkResult = checkRightOrWrong(result);
			    if(!checkResult.equals("ok")){
			    	logger.info("at过期，重发");
			    	result = HttpUtils.sendPostJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+checkResult, msg);
			    	logger.info("重发结果为 "+result);
			    }
			    JSONObject resultJ = JSONObject.parseObject(result);
			    int errcode = resultJ.getInteger("errcode");
			    if(errcode==0){
			    	insertPMAPPmsg(touser, mb, methodName);
			    	return "ok";
			    }else{
			    	logger.info("*****************************************************");
			    	logger.info("send msg faile wechat said "+result);
			    	logger.info("*****************************************************");
			    	return "fail";
			    }
			}else if("FRIENDS_BANEFIT".equalsIgnoreCase(keywordChangeFlag)){
				String msg = MethodConstructor.constractFriendsBanefit(mb, touser, msgTemplateId, url);
				logger.info("发送微信消息 "+msg);
			    String at = getAccessToken();
			    result = HttpUtils.sendPostJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+at, msg);
			    logger.info("发送结果为 "+result);
			    String checkResult = checkRightOrWrong(result);
			    if(!checkResult.equals("ok")){
			    	logger.info("at过期，重发");
			    	result = HttpUtils.sendPostJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+checkResult, msg);
			    	logger.info("重发结果为 "+result);
			    }
			    JSONObject resultJ = JSONObject.parseObject(result);
			    int errcode = resultJ.getInteger("errcode");
			    if(errcode==0){
			    	insertPMAPPmsg(touser, mb, methodName);
			    	return "ok";
			    }else{
			    	logger.info("*****************************************************");
			    	logger.info("send msg faile wechat said "+result);
			    	logger.info("*****************************************************");
			    	return "fail";
			    }
			}else if("GET_LUCKEYMONEY".equals(keywordChangeFlag)){
				String msg = MethodConstructor.constractGetLuckeyMoney(mb, touser, msgTemplateId, url);
				logger.info("发送微信消息 "+msg);
			    String at = getAccessToken();
			    result = HttpUtils.sendPostJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+at, msg);
			    logger.info("发送结果为 "+result);
			    String checkResult = checkRightOrWrong(result);
			    if(!checkResult.equals("ok")){
			    	logger.info("after refresh at "+checkResult+" now resend msg!");
			    	result = HttpUtils.sendPostJson("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+checkResult, msg);
			        logger.info("wechat said "+result);
			    }
			    JSONObject resultJ = JSONObject.parseObject(result);
			    int errcode = resultJ.getInteger("errcode");
			    if(errcode==0){
			    	insertPMAPPmsg(touser, mb, methodName);
			    	return "ok";
			    }else{
			    	logger.info("*****************************************************");
			    	logger.info("send msg faile wechat said "+result);
			    	logger.info("*****************************************************");
			    	return "fail";
			    }
			    
			}else{
				return "fail";
			}
		} catch (Throwable e1) {
			logger.error("SendNotificationMsgImpl SQLException",e1);
			return "fail";
		}
	}
	
	public String checkRightOrWrong (String result) throws Throwable{
	    JSONObject checkMsgFromWechat = JSONObject.parseObject(result);
		if("40001".equals(checkMsgFromWechat.getString("errcode"))){
			System.out.println("40001 error");
			String atnew = manuallyRefresh();
			Connection conn = getConnection("masterTest3306");
			try {
				WechatAtDao wad = new WechatAtDaoImpl(conn);
				wad.updateAt(atnew);
			} finally{
				DBUtils.release(conn);
				logger.info("checkRightOrWrong release conn "+conn);
			}
			return atnew;
		}else{
			return "ok";
		}
	}
	
	public String manuallyRefresh(){
		try {
			String resultJson = HttpUtils.sendGet("https://api.weixin.qq.com/cgi-bin/token", "grant_type=client_credential&appid=wx3c43adce631b24d3&secret=c4de6541faa6d84841b5d1d3a73e3565");
			logger.info("手动刷新at的结果为"+resultJson);
			JSONObject token = JSONObject.parseObject(resultJson);
			return token.getString("access_token");
		}catch (Throwable e) {
			return "";
		}
	}
	public void insertPMAPPmsg(String touser,MsgBody mb,String methodName) throws Throwable{
		Connection conn = getConnection("masterTest3306");
		try {
			WechatAtDao wad = new WechatAtDaoImpl(conn);
			wad.insertPMAPPmsg(touser, mb, methodName);
		} finally{
			DBUtils.release(conn);
			logger.info("checkRightOrWrong release conn "+conn);
		}
	}
	public String getAccessToken() throws Throwable{
		Connection conn = getConnection("masterTest3306");
		try {
			WechatAtDao wamd = new WechatAtDaoImpl(conn);
			AccessToken atPojo = wamd.queryAt();
			if(atPojo!=null){
				Timestamp sqltime = atPojo.getTime();
				logger.info("数据库at到期时间为 "+sqltime);
				Timestamp now = new Timestamp(System.currentTimeMillis());
				logger.info("系统时间为 "+now);
				if((sqltime.getTime()-now.getTime())>5000){
					logger.info("返回 "+atPojo.getAt());
					return atPojo.getAt();
				}else{
					logger.info("已过期");
					//update
					String at = manuallyRefresh();
					wamd.updateAt(at);
					logger.info("返回新at "+at);
					return at;
				}
			}else{
				String at = manuallyRefresh();
				wamd.insertAt(at);
				return at;
			}
		}catch (Throwable e) {
			logger.error("getAccessToken 出错",e);
			return "";
		}finally{
			DBUtils.release(conn);
			logger.info("getAccessToken release conn "+ conn);
		}
	}
}
