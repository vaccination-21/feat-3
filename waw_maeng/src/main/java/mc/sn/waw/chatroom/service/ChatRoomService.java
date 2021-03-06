package mc.sn.waw.chatroom.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import mc.sn.waw.chatroom.vo.ChatRoomJoinVO;
import mc.sn.waw.chatroom.vo.ChatRoomVO;
import mc.sn.waw.member.vo.MemberVO;

public interface ChatRoomService {
	 public List listChatRoom() throws DataAccessException;
	 public List listFieldChatRoom(String field) throws DataAccessException;
	 public int addChatRoom(ChatRoomVO ChatRoomVO) throws DataAccessException;
	 public int removeChatRoom(Integer roomTid) throws DataAccessException;
	 public ChatRoomVO searchChatRoom(Integer roomTid) throws DataAccessException;
	 public ChatRoomVO selectChatRoomVO(String title) throws Exception;
	 
	 public ChatRoomJoinVO selectChatRoomJoinVO(ChatRoomJoinVO ChatRoomJoinVO) throws Exception; 
	 public int addChatRoomJoin(ChatRoomJoinVO ChatRoomJoinVO) throws DataAccessException;
	 public int removeChatRoomJoin(ChatRoomJoinVO ChatRoomJoinVO) throws DataAccessException;
}
