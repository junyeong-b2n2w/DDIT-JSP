package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import com.config.BuildSqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.jsp.dto.MemberVO;



public class MemberDaoImpl implements MemberDao{
	private SqlMapClient client;
	private static MemberDao dao;
	public MemberDaoImpl() {
		client = BuildSqlMapClient.getSqlMapClient();
	}
	
	public static MemberDao getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
		
	}
	
	@Override
	public MemberVO getMember(String id) {
		MemberVO vo = null;
		
		try {
			vo = (MemberVO)client.queryForObject("member.getMember",id);
		} catch (Exception e) {
		}
		
		return vo;
		
	}@Override
	public int regist(MemberVO member) throws SQLException {
		int cnt = 0;
		try {
			Object obj = client.insert("member.regist",member);
			if (obj == null) cnt = 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return cnt;
	}
	
	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> memberList = null;
		
		try {
			memberList = client.queryForList("member.getMemberList");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return memberList;
	}
	
	@Override
	public int delete(String id) throws SQLException {
		int cnt = 0;
		try {
			cnt = client.delete("member.delete", id);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return cnt;
	}
	
	@Override
	public int modify(MemberVO member) throws SQLException {
		int cnt = 0;
		try {
			cnt = client.update("member.modify", member);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cnt;
	}
}
