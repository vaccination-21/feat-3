package mc.sn.waw.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import mc.sn.waw.member.vo.ChatRoomVO;
import mc.sn.waw.member.vo.MemberVO;


public interface MemberDAO {
	 public List selectAllMemberList() throws DataAccessException;
	 //회원가입
	 public int insertMember(MemberVO memberVO) throws DataAccessException;
	 //로그인
	 public MemberVO loginById(MemberVO memberVO) throws DataAccessException;
	 //탈퇴하기
	 public int deleteMember(Integer tid) throws DataAccessException;
	 //멤버찾기
	 public MemberVO searchMember(Integer tid) throws DataAccessException;
	 //정보 업데이트
	 public int updateMember(MemberVO memberVO) throws DataAccessException;
	 
	 //채팅방리스트
//	 public List selectAllRoomList() throws DataAccessException;
	 //채팅방 생성
	 public int insertChatRoom(ChatRoomVO ChatRoomVO) throws DataAccessException;
	 //챗방 불러오기
	 public ChatRoomVO searchChatRoom(Integer roomTid) throws DataAccessException;
	 //챗방 나가기
//	 public int deleteChatRoom(Integer roomTid) throws DataAccessException;
}
