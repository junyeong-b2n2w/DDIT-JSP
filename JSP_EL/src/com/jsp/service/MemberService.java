package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.MemberVO;

public interface MemberService {
	
	List<MemberVO> getMemberList() throws SQLException;
	
	MemberVO getMember(String id) throws SQLException;
}
