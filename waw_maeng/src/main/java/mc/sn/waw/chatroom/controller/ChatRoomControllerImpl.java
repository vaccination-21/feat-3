package mc.sn.waw.chatroom.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import mc.sn.waw.chatroom.service.ChatRoomService;

import mc.sn.waw.chatroom.vo.ChatRoomJoinVO;
import mc.sn.waw.chatroom.vo.ChatRoomVO;
import mc.sn.waw.member.vo.MemberVO;

@Controller("chatRoomController")
public class ChatRoomControllerImpl   implements ChatRoomController {
	@Autowired
	private ChatRoomService ChatRoomService;
	@Autowired
	private ChatRoomVO ChatRoomVO;
	@Autowired
	private ChatRoomJoinVO ChatRoomJoinVO;
	
	//전체 채팅방 리스트
	@Override
	@RequestMapping(value="/chat/listChatRoom.do" ,method = RequestMethod.GET)
	public ModelAndView listChatRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List chatRoomsList = ChatRoomService.listChatRoom();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("chatRoomsList", chatRoomsList);
		return mav;
	}
	//채팅방 리스트 삭제(모든 리스트)
	@Override
	@RequestMapping(value="/chat/removeChatRoom.do" ,method = RequestMethod.GET)
	public ModelAndView removeChatRoom(@RequestParam("roomTid") Integer roomTid, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ChatRoomService.removeChatRoom(roomTid);
		ModelAndView mav = new ModelAndView("redirect:/chat/listChatRoom.do");
		return mav;
	}
	
	//분야별 채팅 리스트
	@Override
	@RequestMapping(value="/chat/listFieldChatRoom.do" ,method = RequestMethod.GET)
	public ModelAndView listFieldChatRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		String field = request.getParameter("field");
		List chatRoomsFieldList = ChatRoomService.listFieldChatRoom(field);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("chatRoomsFieldList", chatRoomsFieldList);
		return mav;
	}
	//채팅방 만들기
	@Override
	@RequestMapping(value="/chat/addChatRoom.do" ,method = RequestMethod.GET)
	public ModelAndView addChatRoom(@ModelAttribute("info") ChatRoomVO ChatRoom,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = ChatRoomService.addChatRoom(ChatRoom);
		ModelAndView mav = new ModelAndView("forward:/chat/chatForm.do");
		return mav;
	}
	
	//분야별 채팅방 삭제(이것도 사람이 0명일 떄 사라져야 되네 -> 추후)
	@Override
	@RequestMapping(value="/chat/removeFieldChatRoom.do" ,method = RequestMethod.GET)
	public ModelAndView removeFieldChatRoom(@RequestParam("roomTid") Integer roomTid, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String field = request.getParameter("field");
		ChatRoomService.removeChatRoom(roomTid);
		ModelAndView mav = new ModelAndView("redirect:/chat/listFieldChatRoom.do");
		mav.addObject("field", field);
		return mav;
	}
	//특정 채팅방 불러오기(검색)->추후
//	@Override
//	@RequestMapping(value="/chat/searchChatRoom.do" ,method = RequestMethod.GET)
//	public ModelAndView searchChatRoom(@RequestParam("roomTid") Integer roomTid, 
//			           HttpServletRequest request, HttpServletResponse response) throws Exception{
//		request.setCharacterEncoding("utf-8");
//		ChatRoomVO vo = ChatRoomService.searchChatRoom(roomTid);
//		System.out.println(vo.getRoomTid());
//		ModelAndView mav = new ModelAndView("forward:/chat/chatForm.do");
//		mav.addObject("chatRoom",vo);
//		return mav;
//	}
	
	//채팅방 들어가기(조인)
	@Override
	@RequestMapping(value="/chat/addChatRoomJoin.do" ,method = RequestMethod.GET)
	public ModelAndView addChatRoomJoin(@ModelAttribute("info") ChatRoomJoinVO ChatRoomJoin,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		String roomTid = request.getParameter("roomTid");
		ChatRoomJoin.setRoomtid(Integer.parseInt(roomTid));
		result = ChatRoomService.addChatRoomJoin(ChatRoomJoin);
		ModelAndView mav = new ModelAndView("forward:/chat/chatForm.do");
		return mav;
	}
	//채팅방
	@Override
	@RequestMapping(value = "/chat/chatForm.do", method =  RequestMethod.GET)
	public ModelAndView chatForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		String tid = "";
		String roomTid = "";
		String title = request.getParameter("title");
		
		//룸 데이터 불러오기
		ChatRoomVO = ChatRoomService.selectChatRoomVO(title);
		if(ChatRoomVO != null) {
		    HttpSession session = request.getSession();
		    session.setAttribute("ChatRoomVO", ChatRoomVO);
		} else {
			System.out.println(ChatRoomVO.getRoomTid() + "," + ChatRoomVO.getTitle() + "," + ChatRoomVO.getField());
		}
		//조인 데이터 불러오기
		if(request.getParameter("roomTid") != null) {
			tid = request.getParameter("tid");
			roomTid = request.getParameter("roomTid");
			ChatRoomJoinVO ChatRoomJoin = new ChatRoomJoinVO();
			ChatRoomJoin.setTid(Integer.parseInt(tid));
			ChatRoomJoin.setRoomtid(Integer.parseInt(roomTid));
			ChatRoomJoinVO = ChatRoomService.selectChatRoomJoinVO(ChatRoomJoin);
			if(ChatRoomJoinVO != null) {
			    HttpSession session = request.getSession();
			    session.setAttribute("ChatRoomJoinVO", ChatRoomJoinVO);
			} else {
				System.out.println(ChatRoomJoinVO.getTid() + "," + ChatRoomJoinVO.getRoomTid());
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	//채팅방 나가기(+조인 삭제)
	@Override 
	@RequestMapping(value="/chat/removeChatRoomJoin.do" ,method = RequestMethod.GET)
	public ModelAndView removeChatRoomJoin(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String tid = "";
		String roomTid = "";
		String field = request.getParameter("field");
		
		//방을 만들고 들어왔을 때
		ModelAndView mav = new ModelAndView("redirect:/chat/listFieldChatRoom.do");
		mav.addObject("field", field);

		//조인으로 들어왔을 때
		if(request.getParameter("tid") != null) {
			tid = request.getParameter("tid");
			roomTid = request.getParameter("roomTid");
			ChatRoomJoinVO.setRoomtid(Integer.parseInt(tid));
			ChatRoomJoinVO.setRoomtid(Integer.parseInt(roomTid));
			ChatRoomService.removeChatRoomJoin(ChatRoomJoinVO);
			mav.setViewName("redirect:/chat/listFieldChatRoom.do");
		}
		return mav;
	}
	
	@RequestMapping(value = "/chat/chatRoomForm.do", method =  RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}

}
