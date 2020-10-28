package com.jsp.service;

import java.sql.SQLException;

import com.jsp.dto.MemberVO;

public class MemberServiceImpl implements MemberService {

	@Override
	public MemberVO getMember(String id) throws SQLException {
		
//		MemberVO member = memberDAO.selectMemberById(id);
		MemberVO member = new MemberVO();
		member.setEmail("jun@123.12");
		member.setId("jun");
		member.setPwd("jun");
		member.setName("jun");
		member.setPhone("010-1234-1234");
		
		return id.equals(member.getId()) ? member : null;
	}

	@Override
	public void regist(MemberVO member) throws SQLException {
		// TODO Auto-generated method stub

	}

}
