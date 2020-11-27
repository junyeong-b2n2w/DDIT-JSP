package com.jsp.request;

import java.util.Date;

import com.jsp.dto.ReplyVO;

public class RegistReplyRequest {

	private int bno;
	private String replyer;
	private String replyText;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	
	public ReplyVO toReplyVO() {
		ReplyVO reply = new ReplyVO();
		reply.setBno(bno);
		reply.setReplyer(replyer);
		reply.setReplyText(replyText);
		reply.setRegDate(new Date());
		reply.setUpdateDate(new Date());
		
		return reply;
	}
}