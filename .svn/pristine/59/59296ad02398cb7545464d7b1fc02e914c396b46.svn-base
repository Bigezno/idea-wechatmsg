package com.plusmoney.wechat.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.plusmoney.wechat.dao.WechatAtDao;
import com.plusmoney.wechat.entity.AccessToken;
import com.plusmoney.wechat.entity.MsgBody;
import com.plusmoney.wechat.util.SqlLogger;

public class WechatAtDaoImpl implements WechatAtDao {
	
	private static Logger logger = Logger.getLogger(WechatAtDaoImpl.class);
	
	private Connection conn;

	public WechatAtDaoImpl(Connection con){
		this.conn = con;
	}
	
	public AccessToken queryAt()  throws SQLException {
		String sql = "SELECT Fat,Ftime FROM	S11.wechatat";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		AccessToken at = null;
		pstm = conn.prepareStatement(sql);
		logger.info(SqlLogger.logSql(sql, ""));
		rs = pstm.executeQuery();
		while(rs.next()){
			at = new AccessToken();
			at.setAt(rs.getString("Fat"));
			at.setTime(rs.getTimestamp("Ftime"));
		}
		return at;
	}

	public int updateAt(String At) throws SQLException {
		String sql = "UPDATE S11.wechatat SET Fat = ?,Ftime = (SELECT TIMESTAMP(CURRENT_TIMESTAMP(), '02:00:00'))";
		PreparedStatement pstm = null;
		int result = 0;
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, At);
		logger.info(SqlLogger.logSql(sql, At));
		result = pstm.executeUpdate();
		return result;
	}

	public boolean insertAt(String At) throws SQLException {
		String sql = "INSERT INTO S11.wechatat (Fat,Ftime) VALUES (?,(SELECT TIMESTAMP(CURRENT_TIMESTAMP(), '02:00:00')))";
		PreparedStatement pstm = null;
		boolean result = false;
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, At);
		logger.info(SqlLogger.logSql(sql, At));
		result = pstm.execute();
		return result;
	}

	public boolean isMsgRepeat(String params) throws SQLException{
		String sql = "insert into S11.wechatmsgkeys set Fcreatetime = CURRENT_TIMESTAMP(), Fkey = ?";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, params);
			logger.info(SqlLogger.logSql(sql, params));
			pstm.executeUpdate();
		} catch (SQLException e){
			return false;
		}
		return true;
	}
	public String getOpenIdByAccountId(int accountId) throws SQLException{
		String openId =null;
		String sql = "SELECT Fopenid FROM S61.T6110 WHERE F01 = ?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, accountId);
		logger.info(SqlLogger.logSql(sql, accountId));
		rs = pstm.executeQuery();
		while(rs.next()){
			openId = rs.getString("Fopenid");
		}
		return openId;
		
	}
	public int insertPMAPPmsg(String touser,MsgBody mb,String methodName) throws Throwable{
		int result = 0;
		String ftoken = "";
		//通过openid找ftoken
		String sql = "select Ffinancetoken from S61.T6110 where Fopenid = '"+touser+"'";
		PreparedStatement ftokenPstm = conn.prepareStatement(sql);
		ResultSet rs = ftokenPstm.executeQuery();
		if(rs.next()){
			ftoken = rs.getString(1);
			//插入PMAPP消息数据
			String sql2 = "INSERT INTO app.appprivatemsg SET "
					+ "Fmsg_template_id = ?, "//1
					+ "Ffirst=?, "			//2
					+ "Fkeyword1=?, "		//3
					+ "Fkeyword2=?, "		//4
					+ "Fkeyword3=?, "		//5
					+ "Fkeyword4=?, "		//6
					+ "Fkeyword5=?, "		//7
					+ "Fkeyword6=?, "		//8
					+ "Fkeyword7=?, "		//9
					+ "Fremark=?, "			//10
					+ "Fuser_ftoken=?, "		//11
					+ "Fcreatetime=NOW() ";
			PreparedStatement insertPstm = conn.prepareStatement(sql2);
			insertPstm.setString(1, methodName);
			insertPstm.setString(2, mb.getFirst());
			insertPstm.setString(3, mb.getKeyword1());
			insertPstm.setString(4, mb.getKeyword2());
			insertPstm.setString(5, mb.getKeyword3());
			insertPstm.setString(6, mb.getKeyword4());
			insertPstm.setString(7, mb.getKeyword5());
			insertPstm.setString(8, mb.getKeyword6());
			insertPstm.setString(9, mb.getKeyword7());
			insertPstm.setString(10, mb.getRemark());
			insertPstm.setString(11, ftoken);
			result = insertPstm.executeUpdate();
			return result;
		}else{
			return 0;
		}
	}
}
