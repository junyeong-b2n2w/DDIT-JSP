package com.jsp.service;

import java.sql.SQLException;

import com.jsp.dao.MemberDao;
import com.jsp.dao.MemberDaoImpl;
import com.jsp.dto.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDao dao;
	private static MemberService service;
	
	public MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberService getInstance() {
		if(service == null) service = new MemberServiceImpl();
		
		return service;
	}
	
	@Override
	public MemberVO getMember(String id) throws SQLException {
		
		
		
		return dao.getMember(id);
	}

	@Override
	public int regist(MemberVO member) throws SQLException {
		
		return dao.regist(member);
	}

}
