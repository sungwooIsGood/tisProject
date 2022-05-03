package com.tisproject.biz.viewList;

import java.sql.Date;

public class ViewListVO {
	private int viewNo;
	private int userNo;
	private int titleNo;
	private Date viewDate;
	private Date lastViewDate;
	
	public int getViewNo() {
		return viewNo;
	}
	public void setViewNo(int viewNo) {
		this.viewNo = viewNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getTitleNo() {
		return titleNo;
	}
	public void setTitleNo(int titleNo) {
		this.titleNo = titleNo;
	}
	public Date getViewDate() {
		return viewDate;
	}
	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}
	public Date getLastViewDate() {
		return lastViewDate;
	}
	public void setLastViewDate(Date lastViewDate) {
		this.lastViewDate = lastViewDate;
	}
	
	@Override
	public String toString() {
		return "ViewListVO [viewNo=" + viewNo + ", userNo=" + userNo + ", titleNo=" + titleNo + ", viewDate=" + viewDate
				+ ", lastViewDate=" + lastViewDate + "]";
	}
}
