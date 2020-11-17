package com.jsp.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;

public class LoginCheckFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest)request;
		HttpServletResponse httpResp = (HttpServletResponse)response;
		
		//제외할 url확인
		String reqUrl = httpReq.getRequestURI().substring(httpReq.getContextPath().length());
		
		System.out.println("request URI : " + reqUrl);
		
		//url check
		if(excludeCheck(reqUrl)) {
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = httpReq.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		//login확인
		if(loginUser == null) { // 비로그인상태
			httpResp.setContentType("text/html;charset=utf-8");
			PrintWriter out = httpResp.getWriter();
			out.print("<script>");
			out.print("alert('로그인은 필수입니다.');");
			out.print("if(window.opener) {window.close();window.opener.parent.location.href='"
					+httpReq.getContextPath()
					+"/';}else{");
			out.print("window.parent.location.href='"+httpReq.getContextPath()+"/';");
			out.print("}");
			out.print("</script>");		
			out.print("}");
			
			out.close();
		}else {//로그인 상태
			chain.doFilter(request, response); // 통과
		}
		
		
	}

	private List<String> exURLs = new ArrayList<String>();
	
	public void init(FilterConfig fConfig) throws ServletException {
		
		String excludeURLNames=fConfig.getInitParameter("exclude");
		
		StringTokenizer st = new StringTokenizer(excludeURLNames , ",");
		
		while(st.hasMoreTokens()) {
			exURLs.add(st.nextToken());
		}
		System.out.println(exURLs);
	}

	private boolean excludeCheck(String url) {
		boolean result = false;
		
		if(url.length()<=1) result = result || true;
		
		for (String exURL:exURLs) {
			if(url.indexOf(exURL)==1) {
				result = result || true;
			}
		}
		return result;
	}
	
}
