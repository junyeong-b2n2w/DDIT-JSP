package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.BoardVO;
import com.jsp.request.SearchCriteria;

public interface BoardDAO {
	
	List<BoardVO> selectSearchBoardList(SearchCriteria cri) throws SQLException;

	int selectSearchBoardListCount(SearchCriteria cri) throws SQLException;

	BoardVO selectBoardByBno(int bno) throws SQLException;

	void insertBoard(BoardVO Board) throws SQLException;

	void updateBoard(BoardVO Board) throws SQLException;

	void deleteBoard(int bno) throws SQLException;

	// viewcnt 증가
	void increaseViewCount(int bno) throws SQLException;

	// Board_seq.nextval 가져오기
	int selectBoardSequenceNextValue() throws SQLException;
}