package mc.sn.waw.member.vo;

import java.sql.Date;

//채팅방 
public class ChatRoomVO {
	// 프라이/방번호 
	 private Integer roomTid;
	 // 방이름 
	 private String title;
	 // 생성시간 
	 private Date roomCreationDate;
	 
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

	 public Date getRoomCreationDate() {
	     return roomCreationDate;
	 }

	 public void setRoomCreationDate(Date roomCreationDate) {
	     this.roomCreationDate = roomCreationDate;
	 }

}
