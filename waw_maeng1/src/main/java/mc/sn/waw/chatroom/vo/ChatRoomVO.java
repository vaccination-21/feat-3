package mc.sn.waw.chatroom.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("ChatRoomVO")
//채팅방 
public class ChatRoomVO {
	 // 프라이/방번호 
	 private Integer roomTid;
	 // 방이름 
	 private String title;
	 // 분야 
	 private String field;
	 // 생성시간 
	 private Date roomCreationDate;
	 
	 
	 public ChatRoomVO() {
		 
	}

	public ChatRoomVO(Integer roomTid, String title, String field, Date roomCreationDate) {
		super();
		this.roomTid = roomTid;
		this.title = title;
		this.field = field;
		this.roomCreationDate = roomCreationDate;
	}

	public Integer getRoomTid() {
	     return roomTid;
	 }

	 public void setRoomTid(Integer roomTid) {
	     this.roomTid = roomTid;
	 }

	 public String getTitle() {
	     return title;
	 }

	 public void setTitle(String title) {
	     this.title = title;
	 }
	 
	 public String getField() {
		return field;
	 }

	 public void setField(String field) {
		this.field = field;
	 }
	 public Date getRoomCreationDate() {
	     return roomCreationDate;
	 }

	 public void setRoomCreationDate(Date roomCreationDate) {
	     this.roomCreationDate = roomCreationDate;
	 }

}
