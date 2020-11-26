package com.jsp.action.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeModifyAction implements Action{

	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "redirect:/notice/detail.do?nno=";
		
		String  title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		
		NoticeVO notice = new NoticeVO();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setWriter(writer);
		notice.setNno(nno);
		
		url+=nno + "&from=modify";
		
		try {
			noticeService.modify(notice);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			url=null;
		}
		
		return url;
	}
}
