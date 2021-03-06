package mc.sn.waw.chatroom.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import mc.sn.waw.chatroom.vo.ChatRoomJoinVO;
import mc.sn.waw.chatroom.vo.ChatRoomVO;


public interface ChatRoomController {
	//전체 채팅방 리스트
	public ModelAndView listChatRoom(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//채팅방 리스트 삭제(모든 리스트)
	public ModelAndView removeChatRoom(@RequestParam("roomTid") Integer roomTid, HttpServletRequest request, HttpServletResponse response) throws Exception;
	//분야별 채팅 리스트
	public ModelAndView listFieldChatRoom(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//채팅방 만들기
	public ModelAndView addChatRoom(@ModelAttribute("info") ChatRoomVO ChatRoom,HttpServletRequest request, HttpServletResponse response) throws Exception;
	//분야별 채팅방 삭제
	public ModelAndView removeFieldChatRoom(@RequestParam("roomTid") Integer roomTid, HttpServletRequest request, HttpServletResponse response) throws Exception;	
	//특정 채팅방 불러오기(검색)->추후
	//public ModelAndView searchChatRoom(@RequestParam("roomTid") Integer roomTid, HttpServletRequest request, HttpServletResponse response) throws Exception;
	//채팅방 들어가기(조인)
	public ModelAndView addChatRoomJoin(@ModelAttribute("info") ChatRoomJoinVO ChatRoomJoin,HttpServletRequest request, HttpServletResponse response) throws Exception;
	//채팅방 나가기(+조인 삭제)
	public ModelAndView removeChatRoomJoin(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//채팅방
	public ModelAndView chatForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
