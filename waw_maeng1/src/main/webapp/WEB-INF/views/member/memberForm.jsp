<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>
<style>
   .text_center{
     text-align:center;
   }
</style>
</head>
<body>
	<form method="post"   action="${contextPath}/member/addMember.do">
	<h1  class="text_center">회원 가입창</h1>
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right">아이디</td>
	      <td width="400"><input type="text" name="id" placeholder="id@domain"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">비밀번호</td>
	      <td width="400"><input type="password" name="pwd"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">비밀번호 확인</td>
	       <td width="400"><p><input type="password" name="pwdRe"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이름</td>
	       <td width="400"><p><input type="text" name="name"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">닉네임</td>
	       <td width="400"><p><input type="text" name="nickname"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">생년월일</td>
	       <td width="400"><p><input type="text" name="birth" placeholder="yyyy-mm-dd"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">성별</td>
	       <td width="400"><p><input type="text" name="gender" placeholder="male/female"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">휴대폰번호</td>
	       <td width="400"><p><input type="text" name="phone" placeholder="00000000000"></td>
	    </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="가입하기"><input type="reset" value="다시입력"></td>
	    </tr>
	</table>
	</form>
</body>
</html>
