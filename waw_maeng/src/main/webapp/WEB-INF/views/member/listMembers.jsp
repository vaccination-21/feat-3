<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>아이디</b></td>
      <td><b>비밀번호</b></td>
      <td><b>비밀번호확인</b></td>
      <td><b>이름</b></td>
      <td><b>닉네임</b></td>
      <td><b>생년월일</b></td>
      <td><b>성별</b></td>
      <td><b>휴대폰번호</b></td>
      <td><b>생성일</b></td>
      <td><b>수정일</b></td>
      <td><b>삭제</b></td>
   </tr>
   
 <c:forEach var="member" items="${membersList}" >     
   <tr align="center">
      <td>
      	<a href="${contextPath}/member/searchMember.do?tid=${member.tid }">${member.id}</a>
      </td>
      <td>${member.pwd}</td>
      <td>${member.pwdRe}</td>
      <td>${member.name}</td>
      <td>${member.nickname}</td>
      <td>${member.birth}</td>
      <td>${member.gender}</td>
      <td>${member.phone}</td>
      <td>${member.creationDate}</td>
      <td>${member.modDate}</td>
      <td><a href="${contextPath}/member/removeMember.do?tid=${member.tid }">삭제하기</a></td>
    </tr>
  </c:forEach>   
</table>
<a href="${contextPath}/member/memberForm.do"><h1 style="text-align:center">회원가입</h1></a>
<br><br>
<a href="../">index 페이지로 이동</a>
</body>
</html>
