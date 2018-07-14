package com.plusmoney.wechat.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.plusmoney.wechat.dao.GetAppPersonalMsgDao;
import com.plusmoney.wechat.entity.AppPersonalMsgBody;
import com.plusmoney.wechat.util.SqlLogger;

public class GetAppPersonalMsgDaoImpl implements GetAppPersonalMsgDao {

	private static Logger logger = Logger.getLogger(GetAppPersonalMsgDaoImpl.class);
			
	private Connection conn;

	public GetAppPersonalMsgDaoImpl(Connection con){
		this.conn = con;
	}
	
	public String getAppPersonalMsg(AppPersonalMsgBody amb)  throws Throwable{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
		JSONArray ja = new JSONArray();
		String sql = "select * from app.appprivatemsg where Fuser_ftoken = ? and Fmsgid > ? order by Fmsgid desc";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, amb.getUserFtoken());
		pstm.setInt(2, Integer.parseInt(amb.getMsgId()));
		logger.info(SqlLogger.logSql(sql, amb.getUserFtoken(),Integer.parseInt(amb.getMsgId())));
		rs = pstm.executeQuery();
		SimpleDateFormat sdfdd = new SimpleDateFormat("MM月dd日");
		SimpleDateFormat sdfmm = new SimpleDateFormat("hh:mm");
		while (rs.next()) {
			AppPersonalMsgBody apmbresult= new AppPersonalMsgBody();
			apmbresult.setMsgTemplateId(rs.getString("Fmsg_template_id"));
			apmbresult.setFirst(rs.getString("Ffirst"));
			apmbresult.setKeyword1(rs.getString("Fkeyword1"));
			apmbresult.setKeyword2(rs.getString("Fkeyword2"));
			apmbresult.setKeyword3(rs.getString("Fkeyword3"));
			apmbresult.setKeyword4(rs.getString("Fkeyword4"));
			apmbresult.setKeyword5(rs.getString("Fkeyword5"));
			apmbresult.setKeyword6(rs.getString("Fkeyword6"));
			apmbresult.setKeyword7(rs.getString("Fkeyword7"));
			apmbresult.setKeyword8(rs.getString("Fkeyword8"));
			apmbresult.setRemark(rs.getString("Fremark"));
			apmbresult.setUserFtoken(rs.getString("Fuser_ftoken"));
			apmbresult.setMsgId(rs.getString("Fmsgid"));
			Date d = new Date(rs.getTimestamp("Fcreatetime").getTime());
			apmbresult.setInsertTime(String.format("%s %s %s", sdfdd.format(d),getWeekOfDate(d),sdfmm.format(d)));
			ja.add(apmbresult);
		}
		JSONObject jo = new JSONObject();
		jo.put("msgs", ja);
		jo.put("badge", ja.size());
		if (ja.size() > 0) {
			jo.put("msgMaxId", ((AppPersonalMsgBody)ja.get(0)).getMsgId());
		}
		logger.info(jo.toJSONString());
		return jo.toJSONString();
		} catch(Throwable e){
			throw e;
		}
	}

	private String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
}
