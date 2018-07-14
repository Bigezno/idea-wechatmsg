package com.plusmoney.wechat.init;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.cmf.ec.framework.rpc.connector.server.ServiceHandlerHolder;
import com.plusmoney.jdbc.util.DBUtils;

public class RpcServerInit extends HttpServlet {

	private static final long serialVersionUID = -3385738912449159283L;

	public RpcServerInit() {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void init() throws ServletException {

		try {

			System.out.println("*********** init DBUtils start *************");
			DBUtils.getInstance();
			System.out.println("*********** init DBUtils end *************");

			System.out
					.println("*********** init rpc server services start *************");
			Properties properties = new Properties();
			String path = RpcServerInit.class.getResource("/").getPath()
					+ "server.properties";
//			String path = "E:/raidenone/wechatnew/wechatgate-service-impl/target/wechatgate-service-impl-1.0.0/WEB-INF/classes/server.properties";
			System.out.println("init file : " + path);
			properties.load(new FileInputStream(path));
			Set<String> keys = properties.stringPropertyNames();
			Map<String, Object> handlerMap = new HashMap<String, Object>();
			for (String key : keys) {
				String value = properties.getProperty(key);
				Class<?> cls = Class.forName(value);
				Object obj = cls.newInstance();
				handlerMap.put(key, obj);
				System.out
						.println(" key: " + key + ", value: " + cls.getName());
			}
			ServiceHandlerHolder.setHandlerMap(handlerMap);
			System.out
					.println("*********** init rpc server services end *************");

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
