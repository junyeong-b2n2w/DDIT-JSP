package com.jsp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.MemberVO;

public class MemberServiceImpl implements MemberService{
	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> memberList = null;
		
		//처리
		
		//memberList = memberDAO.selectMemberList();
		memberList = new ArrayList<MemberVO>();
		
		memberList.add(new MemberVO("jun", "junpw" ,"junna","010-1234-1234","jun@jun.com"));
		memberList.add(new MemberVO("kol", "kolpw" ,"kolna","010-4321-4321","kol@kol.com"));
		
		
		return memberList;
	}
	
	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO member = null; 
		if(id.equals("jun")) {
			member = new MemberVO("jun", "junpw" ,"junna","010-1234-1234","jun@jun.com");
		}
		return member;
	}
	
	
}
