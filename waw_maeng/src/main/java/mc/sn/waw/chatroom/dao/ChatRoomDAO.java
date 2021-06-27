package mc.sn.waw.chatroom.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mc.sn.waw.chatroom.vo.ChatRoomJoinVO;
import mc.sn.waw.chatroom.vo.ChatRoomVO;
import mc.sn.waw.member.vo.MemberVO;

public interface ChatRoomDAO {

	 //전체 채팅방 리스트
	 public List selectAllChatRoomList() throws DataAccessException;
	 //분야별 채팅 리스트
	 public List selectFieldChatRoomList(String field) throws DataAccessException;
	 //채팅방 생성
	 public int insertChatRoom(ChatRoomVO ChatRoomVO) throws DataAccessException;
	 //특정 챗방 불러오기
	 public ChatRoomVO searchChatRoom(Integer roomTid) throws DataAccessException;
	 //챗방 나가기
	 public int deleteChatRoom(Integer roomTid) throws DataAccessException;
	 //룸 데이터 불러오기
	 public ChatRoomVO selectByTitle(String title) throws DataAccessException;
	 //조인 데이타 불러오기
	 public ChatRoomJoinVO selectByTidRoomTid(ChatRoomJoinVO ChatRoomJoinVO) throws DataAccessException;
	 //채팅방 들어가기,조인
	 public int insertChatRoomJoin(ChatRoomJoinVO ChatRoomJoinVO) throws DataAccessException;
	 //조인 테이블 나가기
	 public int deleteChatRoomJoin(ChatRoomJoinVO ChatRoomJoinVO) throws DataAccessException;
}
