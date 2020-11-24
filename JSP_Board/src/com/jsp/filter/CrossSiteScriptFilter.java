package com.jsp.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.josephoconnell.html.HTMLInputFilter;

public class CrossSiteScriptFilter implements Filter {

	private List<String> crossParamList = new ArrayList<String>();
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest requset, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		for(String paramName : crossParamList) {
			Map<String, String[]> paramMap = requset.getParameterMap();
			if(paramMap!=null && requset.getParameter(paramName)!=null) {
				String[] paramValues = requset.getParameterMap().get(paramName);
				
				paramValues[0] = HTMLInputFilter.htmlSpecialChars(paramValues[0]);
				
				requset.getParameterMap().put(paramName, paramValues);
				
				System.out.println(HTMLInputFilter.htmlSpecialChars(paramValues[0]));
			}
		}
		
			chain.doFilter(requset, response);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String paramNames = config.getInitParameter("XSSParameter");
		
		StringTokenizer token = new StringTokenizer(paramNames, ",");
		
		while(token.hasMoreTokens()) {
			crossParamList.add(token.nextToken());
		}
		
		System.out.println(crossParamList);
	}

}
