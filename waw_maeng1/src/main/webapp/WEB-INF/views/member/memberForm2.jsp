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
<title>회원 가입창 수정중</title>
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
	      <td width="400"><input type="text" name="id"></td>
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
	       <td width="200"><p><input  id="signup-birth-yy" type="text" name="birth" placeholder="년(4자)"></td>
	       <td width="100"><p>
	       		<select id="signup-birth-mm" class="selectbox" name="month" onchange="">
  				<option value="month">월</option>
  				<option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
				</select> 
		   </td>
	       <td width="100"><p><input id="signup-birth-dd" type="text" name="day" placeholder="일"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">성별</td>
	       <td width="400"><p>
	       <select id="signup-gender" class="selectbox" name="gender" onchange="">
                 <option value="gender">성별</option>
                 <option value="man">남자</option>
                 <option value="woman">여자</option>
                 <option value="no">선택 안함</option>
           </select>
	       </td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">휴대폰번호</td>
	       <td width="400"><p><input type="text" name="phone"></td>
	    </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="가입하기"><input type="reset" value="다시입력"></td>
	    </tr>
	</table>
	</form>
</body>
