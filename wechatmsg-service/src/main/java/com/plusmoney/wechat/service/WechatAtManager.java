package com.plusmoney.wechat.service;

public interface WechatAtManager {
	/**
	 * ��ѯAT�����û������ֱ�ӷ��أ������򷵻�dead
	 * @return
	 * @throws Throwable 
	 */
	public String queryAt() throws Throwable;
	/**
	 * ����At
	 * @param At
	 * @return
	 */
	public int updateAt(String at) throws Throwable;
	/**
	 * ����At
	 * @param At
	 * @return
	 */
	public boolean insertAt(String at) throws Throwable;
}
