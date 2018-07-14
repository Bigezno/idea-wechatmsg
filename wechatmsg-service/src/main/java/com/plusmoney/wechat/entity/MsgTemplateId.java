package com.plusmoney.wechat.entity;

public class MsgTemplateId {
	/**
	 * 订单提交成功
	 * 
	 * @{{first.DATA
	 * @产品名称：{{keyword1.DATA
	 * @订单金额：{{keyword2.DATA
	 * @下单时间：{{keyword3.DATA
	 * @订单编号：{{keyword4.DATA
	 * @{{remark.DATA
	 */
	public final static String BID_TRANS_SUCCESS = "SdRBtjp-cU5EDWuvpT1OKr6NfYi2jemHxZnSr6904AU";
	/**
	 * 满标确认通知
	 * 
	 * @{{first.DATA
	 * @认购金额：{{keyword1.DATA
	 * @产品名称：{{keyword2.DATA
	 * @投资期限：{{keyword3.DATA
	 * @起息时间：{{keyword4.DATA
	 * @{{remark.DATA
	 * 
	 */
	public final static String FINANCE_FINISHED = "SmuPXnNA3dX0sEwqhf3zHhYJUeC1AhEDmQe-mb9kWoM";
	/**
	 * 优惠券
	 * 
	 * @{{first.DATA
	 * @券名称：{{keyword1.DATA
	 * @数量：{{keyword2.DATA
	 * @金额：{{keyword3.DATA
	 * @使用时间：{{keyword4.DATA
	 * @{{remark.DATA
	 * 
	 */
	public final static String COUPON = "hXNpzO2x-iCgI2scQOpyv4qog-J-Vx-726HeHremL3c";
	/**
	 * 提现
	 * 
	 * @{{first.DATA
	 * @申请提现金额：{{keyword1.DATA
	 * @扣取提现手续费：{{keyword2.DATA
	 * @实际到账金额：{{keyword3.DATA
	 * @{{remark.DATA
	 * 
	 */
	public final static String WITHDRAW = "0uH0mB1p7XY6o_7coFK7BTpJNCgJE1QaWIAJB1D5SMI";
	/**
	 * 充值成功 {{first.DATA}}
	 * 
	 * @充值金额：{{keyword1.DATA
	 * @充值时间：{{keyword2.DATA
	 * @{{remark.DATA
	 */
	public final static String SAVE_SUCCESS = "5Z6x_yN2GozIfJmJdEVek0_ZWqjEbIotVlpCpH3Ri80";
	/**
	 * 还款到账提醒
	 * 
	 * @{{first.DATA
	 * @到账金额：{{keyword1.DATA
	 * @金额类型：{{keyword2.DATA
	 * @时间：{{keyword3.DATA
	 * @{{remark.DATA
	 */
	public final static String REPAY = "QrqPLkthNrwiX4o8rMNk01twn7JGSnFF0nHGc5VGtDM";
	/**
	 * 收益到账通知（好友收益用）
	 * 
	 * @{{first.DATA
	 * @收益金额：{{income_amount.DATA
	 * @到账时间：{{income_time.DATA
	 * @{{remark.DATA
	 */
	public final static String FRIENDS_BANEFIT = "uc-uz_xXGSfD7Kj9X_YLrppmGl_8grJlv3jnb3HIRyY";
	/**
	 * 获赠红包通知
	 * 
	 * @{{first.DATA
	 * @获赠金额：{{present_income.DATA
	 * @{{remark.DATA
	 */
	public final static String GET_LUCKEYMONEY = "m28Yti4dzJ-vATni25xwyTwQCFQSxQYXvGZ5AvjbHus";
	/**
	 * 资金变动通知
	 * 
	 * @{{first.DATA
	 * @交易时间：{{keyword1.DATA
	 * @交易类型：{{keyword2.DATA
	 * @交易金额：{{keyword3.DATA
	 * @资金账户余额：{{keyword4.DATA
	 * @{{remark.DATA
	 */
	public final static String MONEY_CHANGED = "sYZBT3aYTsctRDOkSVhjQgVkfovOUWVXyhFHRa--IYc";
	/**
	 * @{{first.DATA
	 * @登录帐号：{{keyword1.DATA
	 * @密码：{{keyword2.DATA
	 * @{{remark.DATA 
	 */
	public final static String FIND_PWD_BACK = "HZCEHBBRkyzPBLc_eg9sx9EmUm0DOiLP1579J0Rlvg8";

	/**
	 * 恭喜您借款申请提交成功，具体信息如下
	*	借款编号：XXXXXXXXXXXX
	*	借款人：XX
	*	借款金额：X元
	*	借款期限：X天
	*	当前进度：借款协议待确认
	*	点击详情即可查看借款协议内容并确认
	 */
	public final static String FINANCE_TO_CONFIRM = "EzLlZDemmmnlkH8PGr5ibJf_XdSlKAvrzg7O7tLnNOA";
	/**
	 * 项目上线成功通知
	 * @{{first.DATA
	 * @项目名称
	 * @年化收益率
	 * @项目期限
	 * @还款方式
	 * @{{remark.DATA 
	 */
	public final static String NEW_BID = "D8LhnReLttgWfGS4aJ0Cs_M5YdlEN5eTW7q3pDwBV28";
	
	

}
