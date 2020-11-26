package com.jsp.action.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.NoticeService;

public class NoticeRemoveAction implements Action {

	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		try {
			noticeService.remove(nno);
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("window.opener.location.reload(true);");
			
			out.println("window.close();");
			out.println("</script>");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return url;
	}

}
