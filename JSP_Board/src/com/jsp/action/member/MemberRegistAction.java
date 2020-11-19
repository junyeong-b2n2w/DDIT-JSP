package com.jsp.action.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.service.MemberService;
import com.jsp.utils.ExceptionLoggerHelper;

public class MemberRegistAction implements Action {
   
   private MemberService memberService;

   public void setMemberService(MemberService memberService) {
      this.memberService = memberService;
   }

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      String url = "";
      
      MemberVO member = new MemberVO();
      
      String id = request.getParameter("id").trim();
      String pwd = request.getParameter("pwd").trim();
      String name = request.getParameter("name").trim();
      String email = request.getParameter("email").trim();
      String phone = "";
      String authority = request.getParameter("authority").trim();
      String picture = request.getParameter("picture").trim();
      
      for(String data : request.getParameterValues("phone")) {
         phone += data;
      }
      
      member.setId(id);
      member.setPwd(pwd);
      member.setName(name);
      member.setEmail(email);
      member.setPhone(phone);
      member.setAuthority(authority);
      member.setPicture(picture);

      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();
      
      try {
//          throw new SQLException("테스트");
    	 memberService.regist(member);
         
         out.println("<script>");
         out.println("alert('회원 등록이 정상적으로 되었습니다.');");
         out.println("window.opener.location.href='" + request.getContextPath() + "/member/list.do';");
         out.println("window.close();");
         out.println("</script>");
         

      }catch (SQLException e) {
         e.printStackTrace();
         ExceptionLoggerHelper.write(request, e, memberService);
         out.println("<script>");
         out.println("alert('회원등록이 실패했습니다.');");
         out.println("history.go(-1);");
         out.println("</script>");
      } finally {
         if(out != null) out.close();
      }
      
      return url;
   }

}