package com.plusmoney.wechat.service;

/**
 * 发送模板消息类
 * @author Administrator
 *
 */
public interface SendNotificationMsg {
	/**
	 * 发送充值成功消息
	 * @param accountid
	 * @param amount
	 * @param saveTransNo 充值单号
	 * @param saveTime	充值时间
	 * @return
	 */
	public abstract String saveSuccess(int accountId,String amount,String saveTransNo,String saveTime) throws Throwable ;
	/**
	 * 订单提交成功
	 * @param accountId
	 * @param bidName 标名称
	 * @param amount 投资金额
	 * @param time 下单时间
	 * @param bidNo 订单编号
	 * @return
	 */
	public String bidTransSuccess(int accountId,String bidName,String amount,String time,String bidNo) throws Throwable ;
	/**
	 * 自动投标订单提交成功
	 * @param accountId
	 * @param bidName 标名称
	 * @param amount 投资金额
	 * @param time 下单时间
	 * @param bidNo 订单编号
	 * @return
	 */
	public String autoBidTransSuccess(int accountId,String bidName,String amount,String time,String bidNo) throws Throwable ;
	/**
	 * 提现成功
	 * @param accountId 
	 * @param poundage 手续费
	 * @param withdrawAmount 提现金额
	 * @param acctAmount 实际到账金额
	 * @param withdrawTime 提现时间
	 * @return
	 */
	public abstract String withdrawSuccess(int accountId,String withdrawAmount,String poundage,String acctAmount,String withdrawTime) throws Throwable ;
	/**
	 * 好友推荐收益
	 * @param accountId
	 * @param benefitTime 到账时间
	 * @param amount	到账金额
	 * @return
	 */
	public abstract String friendsInvitationBanefit(int accountId,String benefitTime,String amount) throws Throwable ;
	/**
	 * 企业推荐收益
	 * @param accountId 给谁推
	 * @param benefitTime 到账时间
	 * @param amount	到账金额
	 * @return
	 */
	public abstract String corpInvitationBanefit(int accountId,String benefitTime,String amount) throws Throwable ;
	/**
	 * 项目还款
	 * @param amount 到账金额
	 * @param type 金额类型(固定写死了“投标还款”)
	 * @param repayTime 还款时间
	 */
	public abstract String repay(int accountId,String amount,String benefitThisTime,String benefitAll,String repayTime,String bidName) throws Throwable ;
	/**
	 * 项目还款
	 * @param amount 到账金额
	 * @param type 金额类型(固定写死了“投标还款”)
	 * @param benefitThisTime(本次收益)
	 * @param benefitAll(在加号的总收益)
	 * @param bidName 标名字
	 * @param repayTime 还款时间(yyyy-MM-dd)
	 */
	public abstract String repayEarlier(int accountId,String amount,String benefitAll,String repayTime,String bidName) throws Throwable ;
	/**
	 * 使用优惠券投标的项目还款
	 * @param amount 到账金额
	 * @param couponBenifit 优惠券收益
	 * @param type 金额类型(固定写死了“投标还款”)
	 * @param repayTime 还款时间
	 */
	public abstract String repayWithCoupon(int accountId,String amount,String couponBenifit,String repayTime,String bidName) throws Throwable ;
	/**
	 * 优惠券使用
	 * @param accountId
	 * @param couponName 券名称
	 * @param howMany 数量
	 * @param amount 金额
	 * @param time 使用时间
	 * @return
	 */
	public abstract String couponUsed(int accountId,String couponName,String howMany,String amount,String time) throws Throwable ;
	/**
	 * 优惠券获得
	 * @param accountId
	 * @param couponName 券名称
	 * @param couponNumber 优惠码
	 * @param howMany 数量
	 * @return
	 */
	public abstract String couponGot(int accountId,String couponName,String couponNumber,String howMany) throws Throwable ;
	/**
	 * 满标通知
	 * @param accountId
	 * @param moneyPaid 认购金额
	 * @param bidName 产品名称
	 * @param bidLast 投资期限
	 * @param startBenefitTime 起息时间
	 * @return
	 */
	public abstract String financeFinished(int accountId,String moneyPaid,String bidName,String bidLast,String startBenefitTime) throws Throwable ;
	/**
	 * 获赠红包通知
	 * @param accountId
	 * @param present_income
	 * @return
	 */
	public abstract String getLuckymoney(String openid,String present_income,String nickname) throws Throwable ;
	/**
	 * 获赠Mp红包通知
	 * @param accountId
	 * @param present_income
	 * @return
	 */
	public abstract String getLuckymoneyFromMp(String openid,String present_income,String nickname) throws Throwable ;
	/**
	 * 获赠红包通知(好友投资奖励)
	 * @param accountId
	 * @param present_income
	 * @return
	 */
	public abstract String friendsInvested(String openid,String present_income,String nickname) throws Throwable ;
	/**
	 * 获赠红包通知(被邀请人)
	 * @param accountId
	 * @param present_income
	 * @return
	 */
	public abstract String getLuckymoneyGuest(String openid,String present_income) throws Throwable ;
	/**
	 * 转让加币
	 * @param accountId
	 * @param present_income
	 * @return
	 */
	public abstract String transPmc(int toAccountid,String present_income,String fromNickname) throws Throwable ;
	/**
	 * 资金变动通知
	 * @param accountId
	 * @param dealTime 交易时间
	 * @param dealType 交易类型
	 * @param dealAmount 交易金额
	 * @param moneyLeft 资金账户余额
	 * @return
	 */
	public abstract String moneyChanged(int accountId,String dealTime,String dealType,String dealAmount,String moneyLeft) throws Throwable ;
	/**
	 * 借款协议确认
	 * @param accountId
	 * @param bidName 借款编号
	 * @param comName 借款人
	 * @param dealAmount 借款金额
	 * @param days 借款期限
	 * @return
	 */
	public abstract String financeConfirmed(int accountId,String bidName,String comName,String dealAmount,String days,int loanId) throws Throwable ;
	/**
	 * 借款进度
	 * @param accountId
	 * @param bidName 借款编号
	 * @param comName 借款人
	 * @param dealAmount 借款金额
	 * @param days 借款期限
	 * @return
	 */
	public abstract String financeToConfirm(int accountId,String bidName,String comName,String dealAmount,String days,int loanId)throws Throwable ;
	/**
	 * 满标放款
	 * @param accountId 借款公司的bossid(S61.usercorprela的Fuser_id)
	 * @param bidName 标名称
	 * @param comName 公司名称
	 * @param dealAmount 借款金额
	 * @param days 借款期限
	 * @param loanId 标id
	 * @return
	 */
	public abstract String releaseMoney(int accountId,String bidName,String comName,String dealAmount,String days,int loanId)throws Throwable ;
	/**
	 * 新标上线提醒
	 * @param accountId
	 * @param projectName 项目名
	 * @param benefitRate 年化收益率
	 * @param days 项目期限(数字即可)
	 * @param howToRepay 还款方式
	 * @param coreCorp 核心企业(富士康或者MTS)
	 * @return
	 */
	public abstract String newBidAlert(String openid,String projectName,String benefitRate,int days,String howToRepay,String coreCorp)throws Throwable ;
	/**
	 * 新标上线提醒
	 * @param accountId
	 * @param projectName 项目名
	 * @param benefitRate 年化收益率
	 * @param days 项目期限(数字即可)
	 * @param howToRepay 还款方式
	 * @param coreCorp 核心企业(富士康或者MTS)
	 * @return
	 */
	public abstract String newBidAlert(String openid,String projectName,String benefitRate,int days,String howToRepay)throws Throwable ;
	/**
	 * 手动推新标上线提醒
	 * @param accountId
	 * @param projectName 项目名
	 * @param benefitRate 年化收益率
	 * @param days 项目期限(数字即可)
	 * @param howToRepay 还款方式
	 * @param coreCorp 核心企业(富士康或者MTS)
	 * @return
	 */
	public abstract String newBidAlertManually(String openid,String projectName,String benefitRate,int days,String howToRepay)throws Throwable ;
	
}
