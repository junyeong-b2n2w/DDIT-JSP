package com.jsp.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.dto.NoticeVO;
import com.jsp.service.BoardService;

public class BoardModifyAction implements Action {

	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String url = "redirect:/board/detail.do?bno=";
			
			
			String  title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			int bno = Integer.parseInt(request.getParameter("bno"));
			
			
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);
			board.setBno(bno);
			
			url+= bno + "&from=modify";
			
			try {
				boardService.modify(board);
				
				
			} catch (Exception e) {
				e.printStackTrace();
				url=null;
		}
		

		return url;
	}

}
