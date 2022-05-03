package com.tisproject.biz.titleItem;

public class TitleItemVO {

	private int titleItemNo;
	private int itemNo;
	private int titleNo;
	
	public int getTitleItemNo() {
		return titleItemNo;
	}
	public void setTitleItemNo(int titleItemNo) {
		this.titleItemNo = titleItemNo;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public int getTitleNo() {
		return titleNo;
	}
	public void setTitleNo(int titleNo) {
		this.titleNo = titleNo;
	}
	
	@Override
	public String toString() {
		return "TitleItemVO [titleItemNo=" + titleItemNo + ", itemNo=" + itemNo + ", titleNo=" + titleNo + "]";
	}
}
