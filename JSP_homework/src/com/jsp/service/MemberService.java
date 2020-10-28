package com.jsp.service;

import java.sql.SQLException;

import com.jsp.dto.MemberVO;

public interface MemberService {
	
	MemberVO getMember(String id ) throws SQLException;
	
	int regist(MemberVO member) throws SQLException;
}
