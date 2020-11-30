package com.jsp.request;

import java.util.Date;

import com.jsp.dto.ReplyVO;

public class ModifyReplyRequset {

	private String replyText;
	private int rno;
	
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	
	public ReplyVO toReplyVO() {
		ReplyVO reply = new ReplyVO();
		reply.setRno(rno);
		reply.setReplyText(replyText);
		reply.setUpdateDate(new Date());
		return reply;
	}
	
	
}
