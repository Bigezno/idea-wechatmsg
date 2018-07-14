package com.plusmoney.wechat.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.plusmoney.jdbc.util.DBUtils;
import com.plusmoney.wechat.dao.WechatAtDao;
import com.plusmoney.wechat.dao.impl.WechatAtDaoImpl;
import com.plusmoney.wechat.entity.MsgBody;
import com.plusmoney.wechat.entity.MsgTemplateId;
import com.plusmoney.wechat.service.SendNotificationMsg;

public class SendNotificationMsgImpl implements SendNotificationMsg {
	
	private Logger logger = Logger.getLogger(SendNotificationMsgImpl.class);
	
	private Connection getConnection(String conName) throws Throwable {
		try {
			return DBUtils.getConnection(conName);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			if (SQLException.class.isAssignableFrom(e.getClass())) {
				throw new Throwable("10005", e);
			} else {
				throw new Throwable("60006", e);
			}
		}
	}		
	
	/**
	 * 发送充值成功消息
	 * @param accountid
	 * @param amount
	 * @param saveTransNo 充值单号
	 * @param saveTime	充值时间
	 * @return
	 */
	public String saveSuccess(int accountId, String amount, String saveTransNo,
			String saveTime) throws Throwable  {
		String params = String.valueOf(accountId)+amount+saveTransNo+saveTime;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(accountId);
			if(openid!=null){
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5front/index.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
				MsgBody mb = new MsgBody();
				mb.setUserOpenId(openid);
				mb.setFirst("您好，您已成功充值");
				mb.setKeyword1(amount);
				mb.setKeyword2(saveTime);
				mb.setRemark("\n点击详情查看投资列表，开始投资之路！");
				String f = String.format("sending saveSuccess msg with data accountId ===%s", accountId);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				logger.info("first: 您好，您已成功充值");
				String s = String.format("充值金额:%s \n充值时间：%s", amount,saveTime);
				logger.info(s);
				logger.info("remark：点击详情查看投资列表，开始投资之路！");
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.SAVE_SUCCESS, mb,url,"saveSuccess");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
	}
	/**
	 * 订单提交成功
	 * @param accountId
	 * @param bidName 标名称
	 * @param amount 投资金额
	 * @param time 下单时间
	 * @param bidNo 订单编号
	 * @return
	 */
	public String bidTransSuccess(int accountId,String bidName,String amount,String time,String bidNo)  throws Throwable {
		String params = String.valueOf(accountId)+bidName+amount+time+bidNo;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(accountId);
			if(openid!=null){
				MsgBody mb = new MsgBody();
				//String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5/index.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
				mb.setUserOpenId(openid);
				mb.setFirst("尊敬的加号财富用户，您有一笔新的投标记录:");
				mb.setKeyword1(bidName);
				mb.setKeyword2(amount);
				mb.setKeyword3(time);
				mb.setKeyword4(bidNo);
				mb.setRemark("");
				//mb.setRemark("\n恭喜您！您已投标成功！点击查看详情。");
				
				
				String f = String.format("sending bidTransSuccess msg with data accountId ===%s", accountId);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				logger.info("first: 尊敬的加号财富用户，您有一笔新的投标记录:");
				String s = String.format("标名称：%s \n投资金额：%s \n下单时间：%s \n订单编号：%s ", bidName,amount,time,bidNo);
				logger.info(s);
				logger.info("remark：");
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.BID_TRANS_SUCCESS, mb,null,"bidTransSuccess");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
	}
	/**
	 * 提现成功
	 * @param accountId 
	 * @param poundage 手续费
	 * @param withdrawAmount 提现金额
	 * @param acctAmount 实际到账金额
	 * @param withdrawTime 提现时间
	 * @return
	 */
	public String withdrawSuccess(int accountId,String withdrawAmount,String poundage,String acctAmount,String withdrawTime) throws Throwable  {
		String params = String.valueOf(accountId)+withdrawAmount+poundage+acctAmount+withdrawTime;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(accountId);
			if(openid!=null){
				MsgBody mb = new MsgBody();
				mb.setUserOpenId(openid);
				mb.setFirst("您好，您于"+withdrawTime+"成功申请提现");
				mb.setKeyword1(withdrawAmount);
				mb.setKeyword2(poundage);
				mb.setKeyword3(acctAmount);
				mb.setRemark("\n申请已提交，将在48小时内审核放款。如遇节假日将延迟至工作日统一处理。");
				
				
				String f = String.format("sending withdrawSuccess msg with data accountId ===%s", accountId);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				String s =String.format("您好，您于%s成功申请提现\n申请提现金额: %s\n扣取提现手续费：%s \n实际到账金额:%s", withdrawTime,withdrawAmount,poundage,acctAmount);
				logger.info(s);
				logger.info("remark：申请已提交，将在48小时内审核放款。如遇节假日将延迟至工作日统一处理。");
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.WITHDRAW, mb,null,"withdrawSuccess");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
	}
	/**
	 * 收益到账通知
	 * @param accountId
	 * @param benefitTime 到账时间
	 * @param amount	到账金额
	 * @return
	 */
	
	public String friendsInvitationBanefit(int accountId, String benefitTime,
			String amount)  throws Throwable {
		String params = String.valueOf(accountId)+benefitTime+amount;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(accountId);
			if(openid!=null){
				MsgBody mb = new MsgBody();
				mb.setUserOpenId(openid);
				mb.setFirst("您有一笔推荐收益已到账");
				mb.setKeyword1(amount);
				mb.setKeyword2(benefitTime);
				mb.setRemark("\n点击查看更多详情");
				
				
				String f = String.format("sending friendsInvitationBanefit msg with data accountId ===%s", accountId);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				logger.info("first: 您有一笔推荐收益已到账");
				String s =String.format("充值金额: %s\n充值时间：%s", amount,benefitTime);
				logger.info(s);
				logger.info("remark：点击查看更多详情");
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.FRIENDS_BANEFIT, mb,null,"friendsInvitationBanefit");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
	}
	
	
	/**
	 * 项目还款
	 * @param bidName 项目名称
	 * @param principal 还款本金
	 * @param interest 还款利息
	 * @param repayTime 还款时间
	 */
	
	public String repay(int accountId,String amount,String benefitThisTime,String benefitAll,String repayTime,String bidName) throws Throwable {
		String params = String.valueOf(accountId)+amount+bidName;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(accountId);
			if(openid!=null){
				MsgBody mb = new MsgBody();
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5/index.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
				mb.setUserOpenId(openid);
				mb.setFirst("尊敬的加号财富用户，您的投资项目  "+bidName+" 已还款");
				if("-1".equals(benefitThisTime)){
					mb.setKeyword1(amount+" + 提前还款利息");
				}else{
					mb.setKeyword1(amount+"（本次收益 "+benefitThisTime+"元）");
				}
				mb.setKeyword2("投标还款");
				mb.setKeyword3(repayTime);
				if("-1".equals(benefitThisTime)){
					mb.setRemark("\n本次投资收益按照实际借款天数计算，点击详情查看到账情况");
				}else{
					mb.setRemark("\n您在加号赚得的总收益是 "+benefitAll+" 元，点击详情查看到账情况");
				}
				
				String f = String.format("sending repay msg with data accountId ===%s", accountId);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				logger.info("first: 尊敬的加号财富用户，您的投资项目  "+bidName+" 已还款");
				String s = "";
				if("-1".equals(benefitThisTime)){
					s =String.format("到账金额: %s\n金额类型: 投标还款\n还款时间：%s", amount+" + 提前还款利息",repayTime);
				}else{
					s =String.format("到账金额: %s\n金额类型: 投标还款\n还款时间：%s", amount+"(本次收益 "+benefitThisTime+" 元)",repayTime);
				}
				logger.info(s);
				if("-1".equals(benefitThisTime)){
					logger.info("remark：\n本次投资收益按照实际借款天数计算，点击详情查看到账情况");
				}else{
					logger.info("remark：您在加号赚得的总收益是 "+benefitAll+" 元，点击详情查看到账情况");
				}
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.REPAY, mb,url,"repay");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
		
	}
	
	/**
	 * 项目提前还款
	 * @param bidName 项目名称
	 * @param principal 还款本金
	 * @param interest 还款利息
	 * @param repayTime 还款时间(yyyy-MM-dd)
	 */
	public String repayEarlier(int accountId,String amount,String benefitAll,String repayTime,String bidName) throws Throwable {
		String params = String.valueOf(accountId)+amount+bidName;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(accountId);
			if(openid!=null){
				MsgBody mb = new MsgBody();
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5/index.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
				mb.setUserOpenId(openid);
				mb.setFirst("尊敬的加号财富用户，您的投资项目  "+bidName+" 已还款");
				mb.setKeyword1(amount+"（提前还款）");
				mb.setKeyword2("投标还款");
				mb.setKeyword3(repayTime);
				mb.setRemark("\n本次投资收益按照实际借款天数计算，点击详情查看到账情况");
				
				String f = String.format("sending repay msg with data accountId ===%s", accountId);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				logger.info("first: 尊敬的加号财富用户，您的投资项目  "+bidName+" 已还款");
				String s =String.format("到账金额: %s\n金额类型: 投标还款\n还款时间：%s", amount+"（提前还款）",repayTime);
				logger.info(s);
				logger.info("remark：本次投资收益按照实际借款天数计算，点击详情查看到账情况");
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.REPAY, mb,url,"repayEarlier");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
	}
	/**
	 * 优惠券使用
	 * @param accountId
	 * @param couponName 券名称
	 * @param howMany 数量
	 * @param amount 金额
	 * @param time 使用时间
	 * @return
	 */
	public String couponUsed(int accountId,String couponName,String howMany,String amount,String time){
//		MsgBody mb = new MsgBody();
//		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5/index.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
//		mb.setAccountId(accountId);
//		mb.setFirst("尊敬的加人，您的"+couponName+"券已消费成功");
//		mb.setKeyword1(couponName);
//		mb.setKeyword2(howMany);
//		mb.setKeyword3(amount);
//		mb.setKeyword4(time);
//		mb.setRemark("\n如有疑问请拨打客服电话400-036-6023。");
//
//		String f = String.format("sending repay msg with data accountId ===%s", accountId);
//		logger.info(f);
//		logger.info("msgBody:");
//		logger.info("------------------------------------------");
//		logger.info("first: 尊敬的加人，您的"+couponName+"券已消费成功");
//		String s =String.format("券名称: %s\n数量：%s\n金额: %s\n使用时间：%s", couponName,howMany,amount,time);
//		logger.info(s);
//		logger.info("remark：如有疑问请拨打客服电话400-036-6023。");
//		logger.info("------------------------------------------");
//		String result = sender.sendMsg(MsgTemplateId.COUPON, mb,url);
		return "";
		
	}
	/**
	 * 优惠券获得
	 * @param accountId
	 * @param couponName 券名称
	 * @param couponNumber 优惠码
	 * @param howMany 数量
	 * @return
	 */
	public String couponGot(int accountId,String couponName,String couponNumber,String howMany){
//		MsgBody mb = new MsgBody();
//		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5/index.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
//		mb.setAccountId(accountId);
//		mb.setFirst("尊敬的加号财富用户，您已成功获得"+couponName);
//		mb.setKeyword1(couponName);
//		mb.setKeyword2(couponNumber);
//		mb.setKeyword3(howMany);
//		mb.setRemark("\n点击这里立即使用！");
//
//		String f = String.format("sending repay msg with data accountId ===%s", accountId);
//		logger.info(f);
//		logger.info("msgBody:");
//		logger.info("------------------------------------------");
//		logger.info("first: 尊敬的加号财富用户，您已成功获得"+couponName);
//		String s =String.format("券名称: %s\n优惠码：%s\n数量: %s", couponName,couponNumber,howMany);
//		logger.info(s);
//		logger.info("remark：点击这里立即使用！");
//		logger.info("------------------------------------------");
//		String result = sender.sendMsg(MsgTemplateId.COUPON_GOT, mb,url);
		return null;
	}
	/**
	 * 满标通知
	 * @param accountId
	 * @param moneyPaid 认购金额
	 * @param bidName 产品名称
	 * @param bidLast 投资期限
	 * @param startBenefitTime 起息时间
	 * @return
	 */
	public String financeFinished(int accountId,String moneyPaid,String bidName,String bidLast,String startBenefitTime) throws Throwable {
		String params = String.valueOf(accountId)+moneyPaid+bidName+bidLast+startBenefitTime;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(accountId);
			if(openid!=null){
				MsgBody mb = new MsgBody();
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5front/index.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
				mb.setUserOpenId(openid);
				mb.setFirst("尊敬的加号财富用户，您有一笔投资已满标");
				mb.setKeyword1(moneyPaid);
				mb.setKeyword2(bidName);
				mb.setKeyword3(bidLast);
				mb.setKeyword4(startBenefitTime);
				mb.setRemark("\n点击这里查看更多标的");
				
				
				String f = String.format("sending repay msg with data accountId ===%s", accountId);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				logger.info("first: 尊敬的加号财富用户，您有一笔投资已满标");
				String s =String.format("认购金额: %s\n产品名称：%s\n投资期限: %s\n起息时间: %s", moneyPaid,bidName,bidLast,startBenefitTime);
				logger.info(s);
				logger.info("remark：点击这里查看更多标的");
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.FINANCE_FINISHED, mb,url,"financeFinished");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
	}
	/**
	 * 获赠红包通知(被邀请人)
	 * @param accountId
	 * @param present_income
	 * @return
	 */
	
	public String getLuckymoneyGuest(String openid, String present_income) throws Throwable  {
		String params = openid+present_income;
		if(isMsgRepeat(params)){
			MsgBody mb = new MsgBody();
			String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5/coupon/plusCoinCenter.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
			
			mb.setUserOpenId(openid);
			mb.setFirst("感谢您关注加号财富！关注奖励现已加入您的账户。\n");
			//变成加米
			double amountDouble = Double.parseDouble(present_income);
			int amountInteger = (int)(amountDouble*10);
			String amountString = String.valueOf(amountInteger);
			mb.setKeyword1(amountString+" 加米（"+String.valueOf((double)amountInteger/10)+" 元）");
			mb.setRemark("\n点击详情查看可用加米或去兑现加米。邀请更多好友关注，还可获得更多加米！");
			
			String f = String.format("sending getLuckymoneyGuest msg with data openid ===%s", openid);
			logger.info(f);
			logger.info("msgBody:");
			logger.info("------------------------------------------");
			logger.info("first: 感谢您关注加号财富！关注奖励现已加入您的账户。\n");
			String s =String.format("获赠金额: %s\n", present_income);
			logger.info(s);
			logger.info("\n点击详情查看可用加米或去兑现加米。邀请更多好友关注，还可获得更多加米！");
			logger.info("------------------------------------------");
			Sender sender = new Sender();
			String result = sender.sendMsg(MsgTemplateId.GET_LUCKEYMONEY, mb,url,"getLuckymoneyGuest");
			return result;
		}else{
			return "msg repeated";
		}
	}
	/**
	 * 获赠红包通知
	 * @param accountId
	 * @param present_income
	 * @return
	 */
	public String getLuckymoney(String openid, String present_income,String nickname) throws Throwable {
		
		if(nickname==null){
			nickname="";
		}
		String params = openid+present_income+nickname;
		if(isMsgRepeat(params)){
			String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5/coupon/plusCoinCenter.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
			
			MsgBody mb = new MsgBody();
			mb.setUserOpenId(openid);
			mb.setFirst("恭喜您获得邀请奖励！\n");
			//变成加米
			double amountDouble = Double.parseDouble(present_income);
			int amountInteger = (int)(amountDouble*10);
			String amountString = String.valueOf(amountInteger);
			mb.setKeyword1(amountString+" 加米（"+String.valueOf((double)amountInteger/10)+" 元）");
			mb.setRemark("\n您的好友"+nickname+"已成功关注加号财富，点击详情查看可用加米或去兑现加米。邀请更多好友关注，还可获得更多加米！");
			
			String f = String.format("sending getLuckymoney msg with data openid ===%s", openid);
			logger.info(f);
			logger.info("msgBody:");
			logger.info("------------------------------------------");
			logger.info("first: 恭喜您获得邀请奖励！\n");
			String s =String.format("获赠金额: %s\n", present_income);
			logger.info(s);
			logger.info("remark：\n您的好友"+nickname+"已成功关注加号财富，点击详情查看可用加米或去兑现加米。邀请更多好友关注，还可获得更多加米！");
			logger.info("------------------------------------------");
			Sender sender = new Sender();
			String result = sender.sendMsg(MsgTemplateId.GET_LUCKEYMONEY, mb,url,"getLuckymoney");
			return result;
		}else{
			return "msg repeated";
		}
	}
	/**
	 * 获赠红包通知
	 * @param accountId
	 * @param present_income
	 * @return
	 */
	public String getLuckymoneyFromMp(String openid, String present_income,String nickname) throws Throwable {
		if(nickname==null){
			nickname="";
		}
		String params = openid+present_income+nickname;
		if(isMsgRepeat(params)){
			String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5/coupon/plusCoinCenter.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
			
			MsgBody mb = new MsgBody();
			mb.setUserOpenId(openid);
			mb.setFirst("恭喜您获得邀请奖励！\n");
			//变成加米
			double amountDouble = Double.parseDouble(present_income);
			int amountInteger = (int)(amountDouble*10);
			String amountString = String.valueOf(amountInteger);
			mb.setKeyword1(amountString+" 加米（"+String.valueOf((double)amountInteger/10)+" 元）");
			mb.setRemark("\n您的好友"+nickname+"已受邀加入大管加，点击详情查看加米到账情况。邀请更多好友使用大管加，还可获得更多加米！");
			
			String f = String.format("sending getLuckymoney msg with data openid ===%s", openid);
			logger.info(f);
			logger.info("msgBody:");
			logger.info("------------------------------------------");
			logger.info("first: 恭喜您获得邀请奖励！\n");
			String s =String.format("获赠金额: %s\n", present_income);
			logger.info(s);
			logger.info("remark：\n您的好友"+nickname+"已受邀加入大管加，点击详情查看加米到账情况。邀请更多好友使用大管加，还可获得更多加米！");
			logger.info("------------------------------------------");
			Sender sender = new Sender();
			String result = sender.sendMsg(MsgTemplateId.GET_LUCKEYMONEY, mb,url,"getLuckymoney");
			return result;
		}else{
			return "msg repeated";
		}
	}
	/**
	 * 获赠红包通知(好友投资奖励)
	 * @param accountId
	 * @param present_income
	 * @return
	 */
	public String friendsInvested(String openid, String present_income,
			String nickname) throws Throwable  {
		if(nickname==null){
			nickname="";
		}
		String params = openid+present_income+nickname;
		if(isMsgRepeat(params)){
			String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5/coupon/plusCoinCenter.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
			
			MsgBody mb = new MsgBody();
			mb.setUserOpenId(openid);
			mb.setFirst("恭喜您获得好友投资奖励！ \n");
			//变成加米
			double amountDouble = Double.parseDouble(present_income);
//			int amountInteger = (int)(amountDouble*10);
//			String amountString = String.valueOf(amountInteger);
			mb.setKeyword1(present_income+"  加米（"+String.valueOf((double)amountDouble/10)+"元）");
			mb.setRemark("\n您的好友"+nickname+"已投资成功，点击详情查看加米到账情况。\n好友投资越多，加米奖励越多喔！");
			
			String f = String.format("sending friendsInvested msg with data openid ===%s", openid);
			logger.info(f);
			logger.info("msgBody:");
			logger.info("------------------------------------------");
			logger.info("first: 恭喜您获得好友投资奖励！ \n");
			String s =String.format("获赠金额: %s\n", present_income);
			logger.info(s);
			logger.info("remark：\n您的好友"+nickname+"已投资成功，您获得的加米奖励等值于好友新增投资所获收益的5%,点击详情查看加米到账情况。\n好友投资越多，加米奖励越多喔！");
			logger.info("------------------------------------------");
			Sender sender = new Sender();
			String result = sender.sendMsg(MsgTemplateId.GET_LUCKEYMONEY, mb,url,"friendsInvested");
			return result;
		}else{
			return "msg repeated";
		}
	}
	
	public String transPmc(int toAccountid, String present_income,String fromNickname) throws Throwable  {
		if(fromNickname==null){
			fromNickname="";
		}
		String params = toAccountid+present_income+fromNickname;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(toAccountid);
			if(openid!=null){
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5/coupon/plusCoinCenter.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
				MsgBody mb = new MsgBody();
				mb.setUserOpenId(openid);
				mb.setFirst(fromNickname+"向您转赠加米。\n");
				//变成加米
				mb.setKeyword1(present_income);
				mb.setRemark("\n点击详情查看可用加米。");
				
				String f = String.format("sending transPmc msg with data accountId ===%s", toAccountid);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				logger.info("first: "+fromNickname+"向您转赠加米。\n");
				String s =String.format("获赠金额: %s\n", present_income);
				logger.info(s);
				logger.info("remark：\n点击详情查看可用加米。");
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.GET_LUCKEYMONEY, mb,url,"transPmc");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
	}
	/**
	 * 资金变动通知
	 * @param accountId
	 * @param dealTime 交易时间
	 * @param dealType 交易类型
	 * @param dealAmount 交易金额
	 * @param moneyLeft 资金账户余额
	 * @return
	 */
	
	public String moneyChanged(int accountId, String dealTime, String dealType,
			String dealAmount, String moneyLeft) throws Throwable  {
		String params = String.valueOf(accountId)+dealTime+dealType+dealAmount+moneyLeft;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(accountId);
			if(openid!=null){
				MsgBody mb = new MsgBody();
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5/index.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
				mb.setUserOpenId(openid);
				mb.setFirst("您好，您的加号账户最新变动信息：");
				mb.setKeyword1(dealTime);
				mb.setKeyword2(dealType);
				mb.setKeyword3(dealAmount);
				mb.setKeyword4(moneyLeft);
				mb.setRemark("\n点击“我的账户”了解更多");
				
				
				String f = String.format("sending repay msg with data accountId ===%s", accountId);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				logger.info("first: 您好，您的加号账户最新变动信息：");
				String s =String.format("交易时间: %s\n交易类型：%s\n交易金额: %s\n资金账户余额: %s", dealTime,dealType,dealAmount,moneyLeft);
				logger.info(s);
				logger.info("remark：点击“我的账户”了解更多");
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.MONEY_CHANGED, mb,url,"moneyChanged");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
	}
	
	
	public String autoBidTransSuccess(int accountId, String bidName,
			String amount, String time, String bidNo)  throws Throwable {
		String params = String.valueOf(accountId)+bidName+amount+time+bidNo;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(accountId);
			if(openid!=null){
				MsgBody mb = new MsgBody();
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5/index.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
				mb.setUserOpenId(openid);
				mb.setFirst("尊敬的加号财富用户，您有一笔新的投标记录:");
				mb.setKeyword1(bidName);
				mb.setKeyword2(amount);
				mb.setKeyword3(time);
				mb.setKeyword4(bidNo);
				mb.setRemark("本次投标由系统根据您的自动投标设置匹配。点击查看详情。");
				//mb.setRemark("\n恭喜您！您已投标成功！点击查看详情。");
				
				
				String f = String.format("sending bidTransSuccess msg with data accountId ===%s", accountId);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				logger.info("first: 尊敬的加号财富用户，您有一笔新的投标记录:");
				String s = String.format("标名称：%s \n投资金额：%s \n下单时间：%s \n订单编号：%s ", bidName,amount,time,bidNo);
				logger.info(s);
				logger.info("remark：本次投标由系统根据您的自动投标设置匹配。点击查看详情。");
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.BID_TRANS_SUCCESS, mb,url,"autoBidTransSuccess");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
	}
	
	/*public void jPush(String ftoken,MsgBody mb,String methodName){
		JPushClient jpushClient = new JPushClient("b9db3bc1d3daed9b36d58d1a", "fc740d56796d12247b4407a8", 3);
		// For push, all you need do is to build PushPayload object.
		PushPayload payload = buildPushObject_all_alias_alert(ftoken,mb,methodName);
		try {
			PushResult result = jpushClient.sendPush(payload);
			serviceResource.log("Got result - " + result);

		} catch (APIConnectionException e) {
			// Connection error, should retry later
			serviceResource.log(String.format(
							"Connection error, should retry later  %s",
							e.getMessage()));

		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			serviceResource.log(String.format(
					"Should review the error, and fix the request %s",
					e.getMessage()));
			serviceResource.log("HTTP Status: " + e.getStatus());
			serviceResource.log("Error Code: " + e.getErrorCode());
			serviceResource.log("Error Message: " + e.getErrorMessage());
		}
				
	}*/
	
	public String financeToConfirm(int accountId, String bidName,
			String comName, String dealAmount, String days,int loanId) throws Throwable  {
		String params = String.valueOf(accountId)+bidName+comName+dealAmount+days;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(accountId);
			if(openid!=null){
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=https://www.plusmoney.cn/h5/index.html&response_type=code&scope=snsapi_base&state="+loanId+"#wechat_redirect";
				MsgBody mb = new MsgBody();
				mb.setUserOpenId(openid);
				mb.setFirst("恭喜您借款申请提交成功，具体信息如下\n");
				mb.setKeyword1(bidName);
				mb.setKeyword2(comName);
				mb.setKeyword3(dealAmount);
				mb.setKeyword4(days);
				mb.setKeyword5("借款协议待确认");
				mb.setRemark("\n点击详情即可查看借款协议内容并确认");
				
				String f = String.format("sending friendsInvitationBanefit msg with data accountId ===%s", accountId);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				logger.info("first: 恭喜您借款申请提交成功，具体信息如下");
				String s =String.format("借款编号: %s\n借款人：%s\n借款金额：%s\n借款期限：%s\n当前进度：借款协议待确认", bidName,comName,dealAmount,days);
				logger.info(s);
				logger.info("remark：\n点击详情即可查看借款协议内容并确认");
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.FINANCE_TO_CONFIRM, mb,url,"financeToConfirm");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
	}
	
	
	public String releaseMoney(int accountId, String bidName, String comName,
			String dealAmount, String days,int loanId) throws Throwable  {
		String params = String.valueOf(accountId)+bidName+comName+dealAmount+days;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(accountId);
			if(openid!=null){
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=https://www.plusmoney.cn/h5/index.html&response_type=code&scope=snsapi_base&state="+loanId+"#wechat_redirect";
				MsgBody mb = new MsgBody();
				mb.setUserOpenId(openid);
				mb.setFirst("恭喜您借款项目已满标放款，具体信息如下\n");
				mb.setKeyword1(bidName);
				mb.setKeyword2(comName);
				mb.setKeyword3(dealAmount);
				mb.setKeyword4(days+"天");
				mb.setKeyword5("满标放款");
				mb.setRemark("\n点击详情即可查看完整借款协议内容");
				
				String f = String.format("sending friendsInvitationBanefit msg with data accountId ===%s", accountId);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				logger.info("first: 恭喜您借款项目已满标放款，具体信息如下");
				String s =String.format("借款编号: %s\n借款人：%s\n借款金额：%s\n借款期限：%s\n当前进度：满标放款", bidName,comName,dealAmount,days);
				logger.info(s);
				logger.info("remark：\n点击详情即可查看完整借款协议内容");
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.FINANCE_TO_CONFIRM, mb,url,"releaseMoney");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
	}
	

	public String newBidAlert(String openid, String projectName,
			String benefitRate, int days, String howToRepay, String coreCorp) throws Throwable  {
		String params = String.valueOf(openid)+projectName+benefitRate+days+howToRepay+coreCorp;
		if(isMsgRepeat(params)){
			String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5front/index.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
			MsgBody mb = new MsgBody();
			mb.setUserOpenId(openid);
			mb.setFirst("尊敬的加号财富用户，"+coreCorp+"供应商借款项目现已上线！\n");
			mb.setKeyword1(projectName);
			mb.setKeyword2(benefitRate+"%");
			mb.setKeyword3(String.valueOf(days)+" 天");
			mb.setKeyword4(howToRepay);
			mb.setRemark("\n该项目由"+coreCorp+"直接还款，具有稳收益、低风险的特点，数量有限，欲投从速！如有疑问，也可在下方直接输入您的问题，我们将会尽快给你回复。");
			
			String f = String.format("sending newBidAlert msg with data accountId ===%s", openid);
			logger.info(f);
			logger.info("msgBody:");
			logger.info("------------------------------------------");
			logger.info("first: 尊敬的加号财富用户，"+coreCorp+"供应商借款项目现已上线！\n");
			String s =String.format("项目名称: %s\n年化收益率：%s\n项目期限：%s\n还款方式：%s", projectName,benefitRate,String.valueOf(days),howToRepay);
			logger.info(s);
			logger.info("remark：\n该项目由"+coreCorp+"直接还款，具有稳收益、低风险的特点，数量有限，欲投从速！如有疑问，也可在下方直接输入您的问题，我们将会尽快给你回复。");
			logger.info("------------------------------------------");
			Sender sender = new Sender();
			String result = sender.sendMsg(MsgTemplateId.NEW_BID, mb,url,"newBidAlert");
			return result;
		}else{
			return "msg repeated";
		}
	}
	
	public String newBidAlert(String openid, String projectName,
			String benefitRate, int days, String howToRepay) throws Throwable  {
		String params = String.valueOf(openid)+projectName+benefitRate+days+howToRepay;
		if(isMsgRepeat(params)){
			String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5front/index.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
			MsgBody mb = new MsgBody();
			mb.setUserOpenId(openid);
			mb.setFirst("尊敬的加号财富用户，最新投资项目现已上线！\n");
			mb.setKeyword1(projectName);
			mb.setKeyword2(benefitRate+"%");
			mb.setKeyword3(String.valueOf(days)+" 天");
			mb.setKeyword4(howToRepay);
			mb.setRemark("\n点击详情即可开始投资！回复“TDXB”可退订新标上线通知。\n如有其他疑问，也可在下方直接输入您的问题，我们将会尽快给您回复。");
			
			String f = String.format("sending newBidAlert msg with data accountId ===%s", openid);
			logger.info(f);
			logger.info("msgBody:");
			logger.info("------------------------------------------");
			logger.info("first: 尊敬的加号财富用户，最新投资项目现已上线！\n");
			String s =String.format("项目名称: %s\n年化收益率：%s\n项目期限：%s\n还款方式：%s", projectName,benefitRate,String.valueOf(days),howToRepay);
			logger.info(s);
			logger.info("remark：\n点击详情即可开始投资！回复“TDXB”可退订新标上线通知。\n如有其他疑问，也可在下方直接输入您的问题，我们将会尽快给您回复。");
			logger.info("------------------------------------------");
			Sender sender = new Sender();
			String result = sender.sendMsg(MsgTemplateId.NEW_BID, mb,url,"newBidAlert");
			return result;
		}else{
			return "msg repeated";
		}
	}
	
	public String newBidAlertManually(String openid, String projectName,
			String benefitRate, int days, String howToRepay) throws Throwable  {
		String params = String.valueOf(openid)+projectName+benefitRate+days+howToRepay;
		if(isMsgRepeat(params)){
			String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5front/index.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
			MsgBody mb = new MsgBody();
			mb.setUserOpenId(openid);
			mb.setFirst("尊敬的加号财富用户，最新投资项目现已上线！\n");
			mb.setKeyword1(projectName);
			mb.setKeyword2(benefitRate+"%");
			mb.setKeyword3(String.valueOf(days)+" 天");
			mb.setKeyword4(howToRepay);
			mb.setRemark("\n点击这里开始投资！\n如有疑问，也可在下方直接输入您的问题，我们将会尽快给您回复。");
			
			String f = String.format("sending newBidAlert msg with data accountId ===%s", openid);
			logger.info(f);
			logger.info("msgBody:");
			logger.info("------------------------------------------");
			logger.info("first: 尊敬的加号财富用户，最新投资项目现已上线！\n");
			String s =String.format("项目名称: %s\n年化收益率：%s\n项目期限：%s\n还款方式：%s", projectName,benefitRate,String.valueOf(days),howToRepay);
			logger.info(s);
			logger.info("remark：\n点击这里开始投资！\n如有疑问，也可在下方直接输入您的问题，我们将会尽快给您回复。");
			logger.info("------------------------------------------");
			Sender sender = new Sender();
			String result = sender.sendMsg(MsgTemplateId.NEW_BID, mb,url,"newBidAlert");
			return result;
		}else{
			return "msg repeated";
		}
	}
	/*public static PushPayload buildPushObject_all_alias_alert(String ftoken,MsgBody mb,String methodName) {
		String alert = "";
		switch (methodName){
		case "corpInvitationBanefit":alert="您的推荐收益已到账";
		case "repayWithCoupon":alert="优惠券投资项目已还款";
		case "autoBidTransSuccess":alert="自动投标成功";
		case "findPwdBack":alert="找回密码";
		case "moneyChanged":alert="您的资金有变动";
		case "transPmc":alert="加米转让通知";
		case "getLuckymoney":alert="您获得了一枚红包";
		case "getLuckymoneyGuest":alert="您获得了一枚红包";
		case "financeFinished":alert="您的投资项目已满标";
		case "repay":alert="您的投资项目已还款";
		case "withdrawSuccess":alert="提现成功";
		case "bidTransSuccess":alert="投标成功";
		case "saveSuccess":alert="充值成功";
		case "repayEarlier":alert="您的投资项目已还款";
		case "newBidAlert":alert="新标上线啦";
		case "friendsInvested":alert="好友投资奖励";
		}
		return PushPayload.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.alias(ftoken))
				.setNotification(Notification.newBuilder()
						.addPlatformNotification(IosNotification.newBuilder()
							                        .setAlert(alert)
							                        .setBadge(1)
							                        .setSound("happy.caf")
							                        .build())
							    .build())
				.setMessage(Message.content("感谢选择加号财富"))
				.build();
	}*/
	
	public boolean isMsgRepeat(String params) throws Throwable{
		Connection conn = getConnection("masterTest3306");
		try {
			WechatAtDao wamd = new WechatAtDaoImpl(conn);
			return wamd.isMsgRepeat(params);
		} catch ( Throwable e) {
			logger.error("isMsgRepeat SQLException",e);
			return true;
		} finally{
			DBUtils.release(conn);
			logger.info("isMsgRepeat close conn "+conn);
		}
	}
	
	public String getOpenIdByAccountId(int accountid) throws Throwable{
		Connection conn = getConnection("masterTest3306");
		try {
			WechatAtDao wamd = new WechatAtDaoImpl(conn);
			return wamd.getOpenIdByAccountId(accountid);
		} catch ( Throwable e) {
			logger.error("getOpenIdByAccountId SQLException",e);
			return null;
		} finally{
			DBUtils.release(conn);
			logger.info("getOpenIdByAccountId close conn "+conn);
		}
	}
	
	public String repayWithCoupon(int accountId, String amount,
			String couponBenifit, String repayTime, String bidName) throws Throwable {
		String params = String.valueOf(accountId)+amount+bidName;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(accountId);
			if(openid!=null){
				MsgBody mb = new MsgBody();
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c43adce631b24d3&redirect_uri=http://www.plusmoney.cn/h5/index.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
				mb.setUserOpenId(openid);
				mb.setFirst("尊敬的加号财富用户，您的投资项目  "+bidName+" 已还款");
				mb.setKeyword1(String.format("%s + %s (券)", amount,couponBenifit));
				mb.setKeyword2("投标还款");
				mb.setKeyword3(repayTime);
				mb.setRemark("\n点击详情查看到账情况");
				
				String f = String.format("sending repay msg with data accountId ===%s", accountId);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				logger.info("first: 尊敬的加号财富用户，您的投资项目  "+bidName+" 已还款");
				String s =String.format("到账金额: %s\n金额类型: 投标还款\n还款时间：%s", amount,repayTime);
				logger.info(s);
				logger.info("remark：点击详情查看到账情况");
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.REPAY, mb,url,"repayWithCoupon");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
	}
	public String financeConfirmed(int accountId, String bidName,
			String comName, String dealAmount, String days, int loanId)  throws Throwable {
		String params = String.valueOf(accountId)+bidName+comName+dealAmount+days;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(accountId);
			if(openid!=null){
				MsgBody mb = new MsgBody();
				mb.setUserOpenId(openid);
				mb.setFirst("商户已确认借款协议\n");
				mb.setKeyword1(bidName);
				mb.setKeyword2(comName);
				mb.setKeyword3(dealAmount);
				mb.setKeyword4(days);
				mb.setKeyword5("商户已确认");
				mb.setRemark("\n");
				
				String f = String.format("sending friendsInvitationBanefit msg with data accountId ===%s", accountId);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				logger.info("first: 恭喜您借款申请提交成功，具体信息如下");
				String s =String.format("借款编号: %s\n借款人：%s\n借款金额：%s\n借款期限：%s\n当前进度：借款协议待确认", bidName,comName,dealAmount,days);
				logger.info(s);
//				logger.info("remark：\n点击详情即可查看借款协议内容并确认");
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.FINANCE_TO_CONFIRM, mb,null,"financeConfirmed");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
	}

	public String corpInvitationBanefit(int accountId, String benefitTime,
			String amount) throws Throwable {
		String params = String.valueOf(accountId)+benefitTime+amount;
		if(isMsgRepeat(params)){
			String openid = getOpenIdByAccountId(accountId);
			if(openid!=null){
				MsgBody mb = new MsgBody();
				mb.setUserOpenId(openid);
				mb.setFirst("您的推荐收益已到账");
				mb.setKeyword1(amount);
				mb.setKeyword2(benefitTime);
				mb.setRemark("\n您好，您推荐的企业借款项目已回款成功，推荐收益已到账请注意查收。感谢您支持加号财富。");
				
				String f = String.format("sending friendsInvitationBanefit msg with data accountId ===%s", accountId);
				logger.info(f);
				logger.info("msgBody:");
				logger.info("------------------------------------------");
				logger.info("first: 您的推荐收益已到账");
				String s =String.format("充值金额: %s\n充值时间：%s", amount,benefitTime);
				logger.info(s);
				logger.info("remark：您好，您推荐的企业借款项目已回款成功，推荐收益已到账请注意查收。感谢您支持加号财富。");
				logger.info("------------------------------------------");
				Sender sender = new Sender();
				String result = sender.sendMsg(MsgTemplateId.FRIENDS_BANEFIT, mb,null,"corpInvitationBanefit");
				return result;
			}else{
				return "fail";
			}
		}else{
			return "msg repeated";
		}
	}
}
