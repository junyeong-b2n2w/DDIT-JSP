package com.jsp.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class MemberModify
 */
@WebServlet("/member/modify")
public class MemberModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/detail";
		
		
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
			
					
			int cnt = service.modify(member);
			
			
			if(cnt > 0) {
				message = member.getName() + "님 수정 성공 입니다.";
				request.setAttribute("member", member);
			}else {
				
				message = "회원수정에 실패하였습니다.";
			}
			
			request.setAttribute("message", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		ViewResolver.view(url, request, response);
				
				
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
