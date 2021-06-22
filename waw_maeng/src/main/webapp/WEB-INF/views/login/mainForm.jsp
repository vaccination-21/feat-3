<%@page import="mc.sn.waw.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mainForm</title>
<style>
   .text_center{
     text-align:center;
   }
</style>
</head>
<body>
<%
	MemberVO vo = (MemberVO)session.getAttribute("member");
	String result = "로그인 정보가 정확하지 않습니다.";
	
	if (vo != null){
		result = "Data: "+ vo.getId() + "님 login ok."+"\\n"+"Status: Success!!!";
	} 
	
	String alertMessage = "<script>alert('"+ result +"')</script>";
	out.print(alertMessage);
	session.invalidate(); //log out 기능
%>
<form method="GET"   action="${contextPath}/waw/login/addChatRoom.do">
	<h1  class="text_center">방만들기</h1>
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right">방제목</td>
	      <td width="400"><input type="text" name="title" placeholder="방제목"></td>
	   </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="생성"></td>
	    </tr>
	</table>
	</form>
</body>
</html>