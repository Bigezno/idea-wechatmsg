package com.plusmoney.wechat.dao;


import java.sql.SQLException;
import com.plusmoney.wechat.entity.AccessToken;
import com.plusmoney.wechat.entity.MsgBody;

public interface WechatAtDao {
	public AccessToken queryAt() throws Throwable;
	public int updateAt(String At) throws Throwable;
	public boolean insertAt(String At) throws Throwable;
	public boolean isMsgRepeat(String params) throws SQLException;
	public String getOpenIdByAccountId(int accountId) throws SQLException;
	public int insertPMAPPmsg(String touser,MsgBody mb,String methodName) throws Throwable;
}
