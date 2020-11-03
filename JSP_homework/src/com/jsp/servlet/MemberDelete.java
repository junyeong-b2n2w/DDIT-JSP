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
@WebServlet("/member/delete")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "redirect:/member/list";
		
		
		//입력
		String id = request.getParameter("id").trim();
		System.out.println(id);
		MemberService service = MemberServiceImpl.getInstance();
		
		try {
			
	
			int cnt = service.delete(id);

			
			
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
