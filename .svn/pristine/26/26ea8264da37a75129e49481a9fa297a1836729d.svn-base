package com.plusmoney.wechat.util;

import com.alibaba.fastjson.JSONObject;
import com.plusmoney.wechat.entity.MsgBody;

public class MethodConstructor {
	public static String constractNormal(MsgBody mb,String toUser,String msgTemplateId,String url){
		JSONObject jo = new JSONObject();
		JSONObject data = new JSONObject();
		jo.put("topcolor", "#FF0000");
		jo.put("touser", toUser);
		jo.put("template_id", msgTemplateId);
		if(url!=null){
			jo.put("url", url);
		}
		JSONObject first = new JSONObject();
		first.put("value", mb.getFirst());
	    first.put("color", "#173177");
	    data.put("first", first);
	    
	    JSONObject keyword1 = new JSONObject();
	    keyword1.put("value", mb.getKeyword1());
	    keyword1.put("color", "#173177");
	    data.put("keyword1", keyword1);
	    
	    JSONObject keyword2 = new JSONObject();
	    keyword2.put("value", mb.getKeyword2());
	    keyword2.put("color", "#173177");
	    data.put("keyword2", keyword2);
	    
		JSONObject keyword3 = new JSONObject();
	    keyword3.put("value", mb.getKeyword3());
	    keyword3.put("color", "#173177");
	    data.put("keyword3", keyword3);
	    
		JSONObject keyword4 = new JSONObject();
		keyword4.put("value", mb.getKeyword4());
		keyword4.put("color", "#173177");
	    data.put("keyword4", keyword4);
	    
		JSONObject keyword5 = new JSONObject();
		keyword5.put("value", mb.getKeyword5());
		keyword5.put("color", "#173177");
	    data.put("keyword5", keyword5);
	    
	    JSONObject keyword6 = new JSONObject();
	    keyword6.put("value", mb.getKeyword6());
	    keyword6.put("color", "#173177");
	    data.put("keyword6", keyword6);
	    
	    JSONObject keyword7 = new JSONObject();
	    keyword7.put("value", mb.getKeyword7());
	    keyword7.put("color", "#173177");
	    data.put("keyword7", keyword7);
	    
	    JSONObject remark = new JSONObject();
	    remark.put("value", mb.getRemark());
	    remark.put("color", "#173177");
	    data.put("remark", remark);
		    
		jo.put("data", data);
		return jo.toJSONString();
	}
	
	public static String constractMoneyChanged(MsgBody mb,String toUser,String msgTemplateId,String url){
		JSONObject jo = new JSONObject();
		JSONObject data = new JSONObject();
		jo.put("topcolor", "#FF0000");
		jo.put("touser", toUser);
		jo.put("template_id", msgTemplateId);
		if(url!=null){
			jo.put("url", url);
		}
		
		JSONObject first = new JSONObject();
		first.put("value", mb.getFirst());
	    first.put("color", "#173177");
	    data.put("first", first);
	    
	    JSONObject keyword1 = new JSONObject();
	    keyword1.put("value", mb.getKeyword1());
	    keyword1.put("color", "#173177");
	    data.put("date", keyword1);
	    
	    JSONObject keyword2 = new JSONObject();
	    keyword2.put("value", mb.getKeyword2());
	    keyword2.put("color", "#173177");
	    data.put("tradetype", keyword2);
	    
	    JSONObject keyword3 = new JSONObject();
	    keyword3.put("value", mb.getKeyword3());
	    keyword3.put("color", "#173177");
	    data.put("tradenum", keyword3);
	    
	    JSONObject keyword4 = new JSONObject();
		keyword4.put("value", mb.getKeyword4());
		keyword4.put("color", "#173177");
	    data.put("traderemain", keyword4);
	    
	    JSONObject remark = new JSONObject();
	    remark.put("value", mb.getRemark());
	    remark.put("color", "#173177");
	    data.put("remark", remark);
	    
	    jo.put("data", data);
	    
	    return jo.toJSONString();
	}
	public static String constractFriendsBanefit(MsgBody mb,String toUser,String msgTemplateId,String url){
		JSONObject jo = new JSONObject();
		JSONObject data = new JSONObject();
		jo.put("topcolor", "#FF0000");
		jo.put("touser", toUser);
		jo.put("template_id", msgTemplateId);
		if(url!=null){
			jo.put("url", url);
		}
		
		JSONObject first = new JSONObject();
		first.put("value", mb.getFirst());
	    first.put("color", "#173177");
	    data.put("first", first);
	    
	    JSONObject keyword1 = new JSONObject();
	    keyword1.put("value", mb.getKeyword1());
	    keyword1.put("color", "#173177");
	    data.put("income_amount", keyword1);
	    
	    JSONObject keyword2 = new JSONObject();
	    keyword2.put("value", mb.getKeyword2());
	    keyword2.put("color", "#173177");
	    data.put("income_time", keyword2);
	    
	    JSONObject remark = new JSONObject();
	    remark.put("value", mb.getRemark());
	    remark.put("color", "#173177");
	    data.put("remark", remark);
	    
	    jo.put("data", data);
	    
	    return jo.toJSONString();
	}
	public static String constractGetLuckeyMoney(MsgBody mb,String toUser,String msgTemplateId,String url){
		JSONObject jo = new JSONObject();
		JSONObject data = new JSONObject();
		jo.put("topcolor", "#FF0000");
		jo.put("touser", toUser);
		jo.put("template_id", msgTemplateId);
		if(url!=null){
			jo.put("url", url);
		}
		JSONObject first = new JSONObject();
		first.put("value", mb.getFirst());
	    first.put("color", "#173177");
	    data.put("first", first);
	    
	    JSONObject keyword1 = new JSONObject();
	    keyword1.put("value", mb.getKeyword1());
	    keyword1.put("color", "#173177");
	    data.put("present_income", keyword1);
	    
	    JSONObject remark = new JSONObject();
	    remark.put("value", mb.getRemark());
	    remark.put("color", "#173177");
	    data.put("remark", remark);
	    
	    jo.put("data", data);
	    return jo.toJSONString();
	}
}
