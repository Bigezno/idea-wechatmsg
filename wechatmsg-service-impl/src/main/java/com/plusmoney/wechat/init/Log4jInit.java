package com.plusmoney.wechat.init;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

public class Log4jInit extends HttpServlet {

	private static final long serialVersionUID = -8070522100072491814L;

	public Log4jInit() {
		super();
	}

	public void init() throws ServletException {
		String log4jDec = Log4jInit.class.getResource("/").getPath();
		String file = log4jDec + "conf-log/log4j.properties";
		if (file != null) {
			PropertyConfigurator.configure(file);
		}

	}

	public void destroy() {
		super.destroy();
	}
}
