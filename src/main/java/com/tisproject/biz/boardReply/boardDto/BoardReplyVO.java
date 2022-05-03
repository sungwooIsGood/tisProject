package com.tisproject.biz.boardReply.boardDto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//@Getter
//@Setter
//@ToString
public class BoardReplyVO {
	private int rno; // 댓글 번호
	private int bno; // 게시물 번호
	private String replyer; // 댓글 작성자
	private String reply; // 댓글 내용
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd") // json으로 데이터를 보내 줄 때 json은 Date 타입을 읽지 못한다. 떄문에 어노테이션 필요
	private Date replyDate; // 댓글 작성일
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date updateDate; // 댓글 수정일

	private int startReply;
	private int replyStep;
	private int setStartReply; // 더보기를 눌렀을 때 첫 숫자, ex) 3개씩 보여진다면, 1,4,7 ---
	private int endReply; // 댓글 전체 갯수
	
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getStartReply() {
		return startReply;
	}
	public void setStartReply(int startReply) {
		this.startReply = startReply;
	}
	public int getReplyStep() {
		return replyStep;
	}
	public void setReplyStep(int replyStep) {
		this.replyStep = replyStep;
	}
	public int getSetStartReply() {
		return setStartReply;
	}
	public void setSetStartReply(int setStartReply) {
		this.setStartReply = setStartReply;
	}
	public int getEndReply() {
		return endReply;
	}
	public void setEndReply(int endReply) {
		this.endReply = endReply;
	}
	@Override
	public String toString() {
		return "BoardReplyVO [rno=" + rno + ", bno=" + bno + ", replyer=" + replyer + ", reply=" + reply
				+ ", replyDate=" + replyDate + ", updateDate=" + updateDate + ", startReply=" + startReply
				+ ", replyStep=" + replyStep + ", setStartReply=" + setStartReply + ", endReply=" + endReply + "]";
	}
	
	
	
	
}
