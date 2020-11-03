package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.ViewResolver;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/common/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/common/login";
		
		// request.getRequestDispatcher(url).forward(request, response);
		
		ViewResolver.view(url, request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "redirect:/common/main";
		//입력
		String id = request.getParameter("id").trim();
		String pwd = request.getParameter("pwd").trim();
		String message = null;
		//처리
		MemberService service = new MemberServiceImpl();
		
		try {
			MemberVO member = service.getMember(id);
			if(!(member != null && member.getPwd().equals(pwd))) {
				url = "/common/loginFail";  
				message = "아이디 혹은 패스워드가 일치하지 않습니다.";
				request.setAttribute("message", message);
			}else {
				request.getSession().setAttribute("loginUser", member);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		//request.getRequestDispatcher(url).forward(request, response);
		//response.sendRedirect(url);
		ViewResolver.view(url, request, response);
	}

}
