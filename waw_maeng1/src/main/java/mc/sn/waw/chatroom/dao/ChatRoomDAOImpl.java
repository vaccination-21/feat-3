package mc.sn.waw.chatroom.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import mc.sn.waw.chatroom.vo.ChatRoomJoinVO;
import mc.sn.waw.chatroom.vo.ChatRoomVO;
import mc.sn.waw.member.vo.MemberVO;

@Repository("ChatRoomDAO")
public class ChatRoomDAOImpl implements ChatRoomDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//채팅방리스트
	@Override
	public List selectAllChatRoomList() throws DataAccessException {
		List<ChatRoomVO> ChatRoomVOList = null;
		ChatRoomVOList = sqlSession.selectList("mapper.chatRoom.selectAllChatRoomList");
		return ChatRoomVOList;
	}
	
	//분야별 채팅 리스트
	@Override
	public List selectFieldChatRoomList(String field) throws DataAccessException {
		List<ChatRoomVO> ChatRoomFieldVOList = null;
		ChatRoomFieldVOList = sqlSession.selectList("mapper.chatRoom.selectFieldChatRoomList", field);
		return ChatRoomFieldVOList;
	}
	//챗방만들기
	@Override
	public int insertChatRoom(ChatRoomVO ChatRoomVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.chatRoom.insertChatRoom", ChatRoomVO);
		return result;
	}
	//특정 챗방 불러오기
	@Override
	public ChatRoomVO searchChatRoom(Integer roomTid) throws DataAccessException {
		ChatRoomVO vo = (ChatRoomVO) sqlSession.selectOne("mapper.chatRoom.selectChatRoomByRoomTid", roomTid);
		return vo;
	}
	//챗방 나가기
	@Override
	public int deleteChatRoom(Integer roomTid) throws DataAccessException {
		int result = sqlSession.delete("mapper.chatRoom.deleteChatRoom", roomTid);
		return result;
	}
	//조인 데이타 불러오기
	@Override
	public ChatRoomVO selectByTitle(ChatRoomVO ChatRoomVO) throws DataAccessException{
		ChatRoomVO vo = sqlSession.selectOne("mapper.chatRoom.selectByTitle", ChatRoomVO);
		return vo;
	}
	//조인 데이타 불러오기
	@Override
	public ChatRoomJoinVO selectByTidRoomTid(ChatRoomJoinVO ChatRoomJoinVO) throws DataAccessException{
		ChatRoomJoinVO vo = sqlSession.selectOne("mapper.chatRoomJoin.selectByTidRoomTid", ChatRoomJoinVO);
		return vo;
	}
	//채팅방 들어가기,조인
	@Override
	public int insertChatRoomJoin(ChatRoomJoinVO ChatRoomJoinVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.chatRoomJoin.insertChatRoomJoin", ChatRoomJoinVO);
		return result;
	}
	//조인 테이블 삭제하기
	@Override
	public int deleteChatRoomJoin(ChatRoomJoinVO ChatRoomJoinVO) throws DataAccessException {
		int result = sqlSession.delete("mapper.chatRoomJoin.deleteChatRoomJoin", ChatRoomJoinVO);
		return result;
	}

}
