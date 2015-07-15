package com.eachedu.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebListener()
public class SimplerListener implements ServletContextListener {

	Log log = LogFactory.getLog(SimplerListener.class);
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		log.info("@@@@@ contextDestroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		log.info("##### contextInitialized");
	}

}
