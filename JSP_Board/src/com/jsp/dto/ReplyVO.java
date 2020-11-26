package com.jsp.dto;

import java.util.Date;

public class ReplyVO {

private int rno;
private int bno;
private int replyer;
private String replyText;
private Date regDate;
private Date updateDate;
public int getRno() {
	return rno;
}
public void setRno(int rno) {
	this.rno = rno;
}
public int getBno() {
	return bno;
}
public void setBno(int bno) {
	this.bno = bno;
}
public int getReplyer() {
	return replyer;
}
public void setReplyer(int replyer) {
	this.replyer = replyer;
}
public String getReplyText() {
	return replyText;
}
public void setReplyText(String replyText) {
	this.replyText = replyText;
}
public Date getRegDate() {
	return regDate;
}
public void setRegDate(Date regDate) {
	this.regDate = regDate;
}
public Date getUpdateDate() {
	return updateDate;
}
public void setUpdateDate(Date updateDate) {
	this.updateDate = updateDate;
}
}
