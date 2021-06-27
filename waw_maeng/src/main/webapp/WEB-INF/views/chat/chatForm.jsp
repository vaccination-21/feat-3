<%@page import="mc.sn.waw.chatroom.vo.ChatRoomVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅방</title>

</head>
<body>
 	<h1>${ChatRoomVO.title}에 입장하셨습니다.</h1>
	 <tr>
      <td>${member.nickname}님이 입장하셨습니다.</td>
     </tr>
 <a href="${contextPath}/waw/chat/removeChatRoomJoin.do?tid=${ChatRoomJoinVO.tid}&roomTid=${ChatRoomJoinVO.roomTid}&field=${ChatRoomVO.field}"><h1>나가기</h1></a> 
</body>
</html>