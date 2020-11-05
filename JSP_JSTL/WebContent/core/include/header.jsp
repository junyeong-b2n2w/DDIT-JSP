<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>${param.title }</title>
         <style type="text/css">
         div#google, div#naver{
            width: 800px;
            height: 300px;
            margin-bottom: 10px;
            
            border: 1px solid black;
         }
      
      </style>
   </head>
   
   <body>
      <h1>Header</h1>      
      <p>${param.message }</p>
      <hr>
   