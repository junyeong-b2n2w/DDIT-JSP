package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/common/regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/common/registForm.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String url = "/WEB-INF/views/common/regist_success.jsp";
		//입력
		String id = request.getParameter("id").trim();
		String pwd = request.getParameter("pwd").trim();
		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();
		String phone = request.getParameter("phone").trim();
		
		String message = null;
		//처리
		MemberService service = MemberServiceImpl.getInstance();
		
		try {
			
			
			MemberVO member = new MemberVO();
			
			member.setId(id);
			member.setPwd(pwd);
			member.setName(name);
			member.setEmail(email);
			member.setPhone(phone);
			
					
			int cnt = service.regist(member);
			
			
			if(cnt > 0) {
				message = member.getName() + "님 가입 성공 입니다.";
				request.setAttribute("member", member);
			}else {
				
				url ="/WEB-INF/views/common/regist_fail.jsp";  
				message = "회원가입에 실패하였습니다.";
			}
			
			request.setAttribute("message", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
		
	}

}
