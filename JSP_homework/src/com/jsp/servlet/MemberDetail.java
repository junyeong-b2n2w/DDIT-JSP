package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberDetail
 */
@WebServlet("/member/detail")
public class MemberDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="/WEB-INF/views/member/detail.jsp";
		
		String id = request.getParameter("id");
		
		MemberService service = MemberServiceImpl.getInstance();
		
		try {
			MemberVO member = service.getMember(id);
			request.setAttribute("member", member);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher(url).forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
