package org.unasat.listerner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OwnerContextListener implements ServletContextListener {
	private ServletContext context;

	public OwnerContextListener() {
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("Context Initialized");
		context = servletContextEvent.getServletContext();
		context.setAttribute("owner", "Jozua");
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		//remove
		System.out.println("Context Destroyed");
	}

}
