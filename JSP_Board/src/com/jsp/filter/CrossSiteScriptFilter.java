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
import javax.servlet.http.HttpServletRequest;

import com.jsp.request.XSSRequestWrapper;

public class CrossSiteScriptFilter implements Filter {

	private List<String> crossParamNames = new ArrayList<String>();
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		XSSRequestWrapper requestWrapper = new XSSRequestWrapper( (HttpServletRequest)request);
		requestWrapper.inputXSSFilter(crossParamNames);
		
		chain.doFilter(requestWrapper, response);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String paramNames = config.getInitParameter("XSSParameter");
		
		StringTokenizer token = new StringTokenizer(paramNames, ",");
		
		while(token.hasMoreTokens()) {
			crossParamNames.add(token.nextToken());
		}
		
		System.out.println(crossParamNames);
	}

}
