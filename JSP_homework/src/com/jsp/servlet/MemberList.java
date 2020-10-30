package com.jsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberList
 */
@WebServlet("/member/list")
public class MemberList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/member/list.jsp";
		
		MemberService service = MemberServiceImpl.getInstance();
		
		try {
			List<MemberVO> memberList = service.getMemberList();
			request.setAttribute("memberList", memberList);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		request.getRequestDispatcher(url).forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
