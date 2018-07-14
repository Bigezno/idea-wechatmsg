package com.plusmoney.wechat.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.plusmoney.exception.RpcServerLogicalException;
import com.plusmoney.jdbc.util.DBUtils;
import com.plusmoney.wechat.dao.GetAppPersonalMsgDao;
import com.plusmoney.wechat.dao.impl.GetAppPersonalMsgDaoImpl;
import com.plusmoney.wechat.entity.AppPersonalMsgBody;
import com.plusmoney.wechat.service.GetAppPersonalMsg;

public class GetAppPersonalMsgImpl implements GetAppPersonalMsg {

	private Logger logger = Logger.getLogger(GetAppPersonalMsgImpl.class);
	
	private Connection getConnection(String conName) throws SQLException {
		try {
			return DBUtils.getConnection(conName);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			if (SQLException.class.isAssignableFrom(e.getClass())) {
				throw new RpcServerLogicalException("10005", "数据库异常", e);
			} else {
				throw new RpcServerLogicalException("10005", "GetAppPersonalMsgImpl getConnection else错误", e);
			}
		}
	}	
	public String getAppPersonalMsg(AppPersonalMsgBody amb) throws Throwable {
		Connection connection = getConnection("masterTest3306");
		try {
			GetAppPersonalMsgDao wamd = new GetAppPersonalMsgDaoImpl(connection);
			return wamd.getAppPersonalMsg(amb);
		} catch (Throwable e) {
			logger.error(e.getMessage(), e);
			if (SQLException.class.isAssignableFrom(e.getClass())) {
				throw new RpcServerLogicalException("10005", "数据库异常", e);
			} else {
				throw new RpcServerLogicalException("10000", "系統异常", e);
			}
		} finally{
			DBUtils.release(connection);
		}
	}
}
