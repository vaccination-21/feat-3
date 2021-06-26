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
	
	@Override
	@RequestMapping(value="/chat/listChatRoom.do" ,method = RequestMethod.GET)
	public ModelAndView listChatRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List chatRoomsList = ChatRoomService.listChatRoom();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("chatRoomsList", chatRoomsList);
		return mav;
	}
	
	//챗 방 만들기
	@Override
	@RequestMapping(value="/chat/addChatRoom.do" ,method = RequestMethod.GET)
	public ModelAndView addChatRoom(@ModelAttribute("info") ChatRoomVO ChatRoom,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		//add
		result = ChatRoomService.addChatRoom(ChatRoom);
		//select
		ChatRoomVO = ChatRoomService.selectChatRoomVO(ChatRoom);
		if(ChatRoomVO != null) {
		    HttpSession session = request.getSession();
		    session.setAttribute("ChatRoomVO", ChatRoomVO);
		} else {
			System.out.println(ChatRoomVO.getRoomTid() + "," + ChatRoomVO.getTitle());
		}
		ModelAndView mav = new ModelAndView("redirect:/chat/chatForm.do");
		return mav;
	}
	
	//챗방 삭제하기 이것도 사람이 0명일 떄 사라져야 되네 -> 추후
	@Override
	@RequestMapping(value="/chat/removeChatRoom.do" ,method = RequestMethod.GET)
	public ModelAndView removeChatRoom(@RequestParam("roomTid") Integer roomTid, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ChatRoomService.removeChatRoom(roomTid);
		ModelAndView mav = new ModelAndView("redirect:/chat/listChatRoom.do");//여기도 /chat/removeChatRoomJoin.do가야된다.
		return mav;
	}
	//특정 챗방 불러오기 -> 추후
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
	
	//나머지 폼 형식도 모두 컨트롤러가 존재해야 view와 연결된다!!
	@RequestMapping(value = "/chat/*Form.do", method =  RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	//챗방 참가 조인(조인테이블 추가 후 select하여 joinVO에 넣어줌) 
	@Override
	@RequestMapping(value="/chat/addChatRoomJoin.do" ,method = RequestMethod.GET)
	public ModelAndView addChatRoomJoin(@ModelAttribute("info") ChatRoomJoinVO ChatRoomJoin,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String viewName = getViewName(request);
		int result = 0;
		String roomTid = request.getParameter("roomTid");
		ChatRoomJoin.setRoomtid(Integer.parseInt(roomTid));
		result = ChatRoomService.addChatRoomJoin(ChatRoomJoin);
		
		ChatRoomJoinVO = ChatRoomService.selectChatRoomJoinVO(ChatRoomJoin);

		if(ChatRoomJoinVO != null) {
		    HttpSession session = request.getSession();
		    session.setAttribute("ChatRoomJoinVO", ChatRoomJoinVO);
		} else {
			System.out.println(ChatRoomJoinVO.getTid() + "," + ChatRoomJoinVO.getRoomTid());
		}
		ModelAndView mav = new ModelAndView("forward:/chat/chatForm.do");
		return mav;
	}
	
	//챗방 조인 삭제하기 및 방삭제 호출
	@Override 
	@RequestMapping(value="/chat/removeChatRoomJoin.do" ,method = RequestMethod.GET)
	public ModelAndView removeChatRoomJoin(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String viewName = getViewName(request);
		String tid = "";
		String roomTid = "";
		if(request.getParameter("tid").equals("")) {
			ModelAndView mav = new ModelAndView("redirect:/chat/listChatRoom.do");
			return mav;
		}
		else {
			tid = request.getParameter("tid");
			roomTid = request.getParameter("roomTid");
			ChatRoomJoinVO.setRoomtid(Integer.parseInt(tid));
			ChatRoomJoinVO.setRoomtid(Integer.parseInt(roomTid));
			ChatRoomService.removeChatRoomJoin(ChatRoomJoinVO);
			ModelAndView mav = new ModelAndView("redirect:/chat/listChatRoom.do");
			return mav;
		}	
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
