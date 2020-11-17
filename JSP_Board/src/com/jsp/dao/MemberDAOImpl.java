package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dto.MemberVO;
import com.jsp.request.SearchCriteria;

public class MemberDAOImpl implements MemberDAO {
	//SqlSessionFactory
	private SqlSessionFactory sqlSessionFactory;
	
	

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	
	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById",id);
		session.close();
		return member;
	}
	
	@Override
	public List<MemberVO> selectMemberList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		int offset = cri.getPageStartNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		
		List<MemberVO> memberList = null;
		
		
		memberList = session.selectList("Member-Mapper.selectSearchMemberList",cri, rowBounds);
		session.close();
		return memberList;
	}

	@Override
	public int selectMemberListCount(SearchCriteria cri) throws SQLException {
		int count = 0;
		SqlSession session = sqlSessionFactory.openSession();
		count = session.selectOne("Member-Mapper.selectMemberListCount",cri);
		session.close();
		return count;
	}

	
	@Override
	public void insertMember(MemberVO member) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.update("Member-Mapper.insertMember",member);
		session.close();
	}
	
	@Override
	public void updateMemeber(MemberVO member) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.update("Member-Mapper.updateMemeber",member);
		session.close();
	}
	
	@Override
	public void disabledMemeber(MemberVO member) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.update("Member-Mapper.disabledMemeber",member);
		session.close();
	}

	
	@Override
	public void enabledMemeber(MemberVO member) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.update("Member-Mapper.enabledMemeber",member);
		session.close();
	}

	@Override
	public void deleteMemeber(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.update("Member-Mapper.deleteMemeber",id);
		session.close();
	}

}
