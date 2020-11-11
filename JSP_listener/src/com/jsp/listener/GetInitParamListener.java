package com.jsp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class GetInitParamListener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("Listenser 종료");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
     	
     	
     	ServletContext sc = sce.getServletContext();
    	
    	String message = sc.getInitParameter("message");
    	
    	System.out.println(message);
    }
	
}
