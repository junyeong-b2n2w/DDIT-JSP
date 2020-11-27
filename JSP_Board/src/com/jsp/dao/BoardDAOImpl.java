package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dto.BoardVO;
import com.jsp.request.SearchCriteria;

public class BoardDAOImpl implements BoardDAO{
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<BoardVO> selectBoardCriteria(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		int offset=cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();		
		RowBounds rowBounds=new RowBounds(offset,limit);		
		
		List<BoardVO> boardList=
				session.selectList("Board-Mapper.selectSearchBoardList",cri,rowBounds);
		session.close();
		
		return boardList;
	}
	
	@Override
	public int selectBoardCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
				
		int count=session.selectOne("Board-Mapper.selectSearchBoardListCount",cri);
		session.close();
		return count;
	}
	
	@Override
	public BoardVO selectBoardByBno(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();		
		BoardVO board=
				session.selectOne("Board-Mapper.selectBoardByBno",bno);
		session.close();
		return board;
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(true);		
		session.update("Board-Mapper.insertBoard",board);
		session.close();
	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(true);		
		session.update("Board-Mapper.updateBoard",board);
		session.close();
	}

	@Override
	public void deleteBoard(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(true);		
		session.update("Board-Mapper.deleteBoard",bno);
		session.close();
	}

	@Override
	public void increaseViewCnt(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(true);		
		session.update("Board-Mapper.increaseViewCount",bno);
		session.close();
	}

	@Override
	public int selectBoardSeqNext() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		int seq_num=
				session.selectOne("Board-Mapper.selectBoardSeqNext");
		session.close();
		return seq_num;
	}
}
