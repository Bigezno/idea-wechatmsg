package com.plusmoney.wechat.dao;

import com.plusmoney.wechat.entity.AppPersonalMsgBody;

public interface GetAppPersonalMsgDao {

	public String getAppPersonalMsg(AppPersonalMsgBody amb) throws Throwable;
}
