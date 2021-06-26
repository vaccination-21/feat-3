<%@page import="mc.sn.waw.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
Result
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
</body>
</html>