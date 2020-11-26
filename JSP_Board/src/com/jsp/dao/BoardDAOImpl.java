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
	public List<BoardVO> selectSearchBoardList(SearchCriteria cri) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int offset=cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();		
		RowBounds rowBounds=new RowBounds(offset,limit);		
		
		List<BoardVO> boardList=
				sqlSession.selectList("Board-Mapper.selectSearchBoardList",cri,rowBounds);
		sqlSession.close();
		
		return boardList;
		
	}

	@Override
	public int selectSearchBoardListCount(SearchCriteria cri) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int count = sqlSession.selectOne("Board-Mapper.selectSearchBoardListCount",cri);
		sqlSession.close();
		
		return count;
	}

	@Override
	public BoardVO selectBoardByBno(int bno) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		BoardVO board=
				sqlSession.selectOne("Board-Mapper.selectBoardByBno",bno);
		sqlSession.close();
		return board;
	}

	@Override
	public void insertBoard(BoardVO Board) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);		
		sqlSession.update("Board-Mapper.insertBoard",Board);
		sqlSession.close();
		
	}

	@Override
	public void updateBoard(BoardVO Board) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);		
		sqlSession.update("Board-Mapper.updateBoard",Board);
		sqlSession.close();
		
	}

	@Override
	public void deleteBoard(int bno) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);		
		sqlSession.update("Board-Mapper.deleteBoard",bno);
		sqlSession.close();		
	}

	@Override
	public void increaseViewCount(int bno) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);		
		sqlSession.update("Board-Mapper.increaseViewCount",bno);
		sqlSession.close();		
	}

	@Override
	public int selectBoardSequenceNextValue() throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int seq_num=
				sqlSession.selectOne("Board-Mapper.selectBoardSequenceNextValue");
		sqlSession.close();
		return seq_num;
	}

}
