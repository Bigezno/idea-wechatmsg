package com.plusmoney.wechat.entity;

import java.sql.Timestamp;

public class AccessToken {
	private String at;
	private Timestamp time;
	public String getAt() {
		return at;
	}
	public void setAt(String at) {
		this.at = at;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
}
