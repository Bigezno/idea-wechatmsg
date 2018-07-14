package com.plusmoney.wechat.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.UnixCrypt;

public class WechatAccountHelper {
	/**
	 * ΢�����뷽��
	 * ���룺weixin+openidǰ8λ
	 * ���ص��Ǽ��ܺ��password
	 * @param openid
	 * @return
	 */
	public static String randomWxPwd(String openid){
	//	return "8bZl5OHiUPejY";
		StringBuilder weixinPwd = new StringBuilder();
		weixinPwd.append("weixin");
		weixinPwd.append(openid.substring(0, 8));
		String pwd = weixinPwd.toString();
		return pwd;
	}
	/**
	 * ΢������˻�����
	 * �߼����˺�:weixin+openidǰʮλ
	 * 
	 */
	public static String randomWxAccount(String openid){
		StringBuilder weixinAccount = new StringBuilder();
		String weixin = "weixin";
		weixinAccount.append(weixin);
		weixinAccount.append(openid.substring(0, 10));
		//��������
		String password = UnixCrypt.crypt(randomWxPwd(openid),
				DigestUtils.sha256Hex(randomWxPwd(openid)));
		return password;
	}
}
