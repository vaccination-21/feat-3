<%@page import="mc.sn.waw.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅방</title>

</head>
<body>
	<h1  class="text_center">채팅방</h1>
<%
	MemberVO vo = (MemberVO)session.getAttribute("member");
	String result = "입장 실패";
	if (vo != null){
		result = "Data: "+ vo.getNickname() + "님이 입장하셨습니다!!";
	} 
	String alertMessage = "<script>alert('"+ result +"')</script>";
	out.print(alertMessage);
	//session.invalidate(); //log out 기능
%>
</body>
</html>