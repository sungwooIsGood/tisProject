package com.tisproject.biz.board.boardDto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


//@Getter
//@Setter
//@ToString
public class BoardVO {
	private Integer bno;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private Integer cnt;
	private String searchCondition;
	private String searchKeyword;
	private String bFile;
	
	private MultipartFile boardFile;
	
	
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getbFile() {
		return bFile;
	}
	public void setbFile(String bFile) {
		this.bFile = bFile;
	}
	public MultipartFile getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(MultipartFile boardFile) {
		this.boardFile = boardFile;
	}

	
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + ", searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword
				+ ", bFile=" + bFile + ", boardFile=" + boardFile + "]";
	}
	
}
