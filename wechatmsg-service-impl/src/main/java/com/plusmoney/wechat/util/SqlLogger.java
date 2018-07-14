package com.plusmoney.wechat.util;

public class SqlLogger {
	public static String logSql(String sql,Object... params){
		int i = 0;
		String result = sql;
		while(result.contains("?")){
			try {
				Object trya = params[i];
			} catch (Exception e) {
				i = 0;
			}
			String param = params[i]==null?"[paramsNull]":String.valueOf(params[i]);
			if(params[i] instanceof String){
				param = new String ("'"+param+"'");
			}
			result = result.replaceFirst("\\?", param);
			i++;
		}
		return result;
	}
//	public static void main(String[] args) {
//		String sql = "INSERT INTO S61.wechat_info SET "
//				+ "Fopenid=?,Fnickname=?,Fsex=?,Flanguage=?,Fcity=?,"
//				+ "Fprovince=?,Fcountry=?,Fheadimgurl=?,Funionid=?,Fprivilege=?,"
//				+ "Fcreate_time = CURRENT_TIMESTAMP()"
//				+ "on duplicate key update"
//				+ "Fopenid=?,Fnickname=?,Fsex=?,Flanguage=?,Fcity=?,"
//				+ "Fprovince=?,Fcountry=?,Fheadimgurl=?,Funionid=?,Fprivilege=?,"
//				+ "Fedit_time = CURRENT_TIMESTAMP()";
//		String openid = "wpd.getOpenid()";
//		String nickname = "wpd.getNickname()";
//		int sex = 1;
//		String language = "wpd.getLanguage()";
//		String city = "wpd.getCity()";
//		String province = "wpd.getProvince()";
//		String country = "wpd.getCountry()";
//		String headimg = "wpd.getHeadimgurl()";
//		String unionid = "wpd.getUnionid()";
//		String privilege = "wpd.getPrivilege()";
//		System.out.println(logSql(sql, openid,nickname,sex,language,city,province,country,headimg,unionid,privilege));
//	}
}
