<%@page import="mc.sn.waw.member.vo.MemberVO"%>
<%@page import="mc.sn.waw.chatroom.vo.ChatRoomVO"%>
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
<title>채팅방 리스트 출력창/메인화면</title>
</head>
<body>
<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>방번호</b></td>
      <td><b>방이름</b></td>
      <td><b>분야</b></td>
      <td><b>생성시간</b></td>
      <td><b>삭제하기</b></td>
   </tr>

 <c:forEach var="chatRoom" items="${chatRoomsList}">
   <tr align="center">
      <td>
      	<a href="${contextPath}/chat/addChatRoomJoin.do?tid=${member.tid}&roomTid=${chatRoom.roomTid}&title=${chatRoom.title}">${chatRoom.roomTid}</a> 
      </td>
      <td>${chatRoom.title}</td>
      <c:choose> 
		<c:when test="${chatRoom.field eq '1'}">
			<td>취미</td>
		</c:when> 
	 	<c:when test="${chatRoom.field eq '2'}">
			<td>취업</td>
		</c:when>
	  </c:choose>
      <td>${chatRoom.roomCreationDate}</td>
      <td><a href="${contextPath}/chat/removeChatRoom.do?roomTid=${chatRoom.roomTid }">삭제하기</a></td>
    </tr>
  </c:forEach>   
</table>
<a href="${contextPath}/chat/chatRoomForm.do?tid=${member.tid}"><h1 style="text-align:center">방만들기</h1></a>
<br><br>
<a href="${contextPath}/login/chatbotForm.do">챗봇으로 가기</a>
</body>
</html>
