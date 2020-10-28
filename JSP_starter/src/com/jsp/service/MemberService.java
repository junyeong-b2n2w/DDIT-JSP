package com.jsp.service;

import java.sql.SQLException;

import com.jsp.dto.MemberVO;

public interface MemberService {
	
	MemberVO getMember(String id ) throws SQLException;
	
	void regist(MemberVO member) throws SQLException;
}
