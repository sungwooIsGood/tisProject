package com.tisproject.biz.notice.noticeDto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class NoticeVO {
	
	private Integer seq;
	private String title;
	private String content;
	private Date regDate;
	private Integer cnt;
	private String searchCondition;
	private String searchKeyword;
	private String nFile;
	
	private MultipartFile noticeFile;
	
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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

	public String getnFile() {
		return nFile;
	}
	public void setnFile(String nFile) {
		this.nFile = nFile;
	}
	public MultipartFile getNoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(MultipartFile noticeFile) {
		this.noticeFile = noticeFile;
	}
	@Override
	public String toString() {
		return "NoticeVO [seq=" + seq + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", cnt="
				+ cnt + ", searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + ", nFile=" + nFile
				+ ", noticeFile=" + noticeFile + "]";
	}
}
