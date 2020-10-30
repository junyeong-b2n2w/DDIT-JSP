package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.MemberVO;

public interface MemberService {
	
	MemberVO getMember(String id ) throws SQLException;
	
	int regist(MemberVO member) throws SQLException;
	
	List<MemberVO> getMemberList () throws SQLException;
}
