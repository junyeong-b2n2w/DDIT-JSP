package com.jsp.dto;

import java.util.Date;

public class BoardVO {

private int	 bno     ;   
private String title ;
private String writer;     // 작성자 (회원)
private String content;   // 내용 (html)
private int viewcnt;      // 조회수
private Date regDate;     // 등록날짜
private Date  updateDate;
private String dist;

public int getBno() {
	return bno;
}
public void setBno(int bno) {
	this.bno = bno;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getViewcnt() {
	return viewcnt;
}
public void setViewcnt(int viewcnt) {
	this.viewcnt = viewcnt;
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
public String getDist() {
	return dist;
}
public void setDist(String dist) {
	this.dist = dist;
}
	
}
