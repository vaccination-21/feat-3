<%@page import="mc.sn.waw.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>챗봇창</title>
<style>
   .text_center{
     text-align:center;
   }
</style>
</head>
<body>
<%-- <%
	MemberVO vo = (MemberVO)session.getAttribute("member");
	String result = "로그인 정보가 정확하지 않습니다.";
	
	if (vo != null){
		result = "Data: "+ vo.getId() + "님 login ok."+"\\n"+"Status: Success!!!";
	} 
	
	String alertMessage = "<script>alert('"+ result +"')</script>";
	out.print(alertMessage);
%> --%>
<c:if test="${msg == 'success'}">
    <h2>${member.nickname}님 환영합니다.</h2>
    <a href="${contextPath}/waw/login/logout.do">로그아웃</a>
</c:if>
<form method="GET"   action="${contextPath}/waw/chat/listFieldChatRoom.do">
	<h1  class="text_center">WAW chatbot</h1>
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right">분야</td>
	      <td width="400">
	      	<select id="field" name="field">
        		<option value="1">취미</option>
        		<option value="2">취업</option> 
   		 	</select>
   		 </td>
	   </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="바로가기"></td>
	    </tr>
	</table>
	</form>
</body>
</html>