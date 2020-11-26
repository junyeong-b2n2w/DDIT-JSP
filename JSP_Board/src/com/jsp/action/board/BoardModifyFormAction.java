package com.jsp.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.service.BoardService;
import com.jsp.utils.ExceptionLoggerHelper;

public class BoardModifyFormAction implements Action {
	
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/board/modify";
		
		try {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardVO board = boardService.getBoardModify(bno);
		
		request.setAttribute("board", board);
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionLoggerHelper.write(request, e, boardService);
			url=null;
		}
		return url;
	}
}
