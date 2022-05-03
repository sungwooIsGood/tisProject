package com.tisproject.biz.item;

public class ItemVO {
	private int itemNo;
	private char itemOption;
	private String itemName;

	/************************Table 이외**************************/
	private int titleNo;
	
	/***********************************************************/
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public char getItemOption() {
		return itemOption;
	}
	public void setItemOption(char itemOption) {
		this.itemOption = itemOption;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/************************Table 이외**************************/
	public int getTitleNo() {
		return titleNo;
	}
	public void setTitleNo(int titleNo) {
		this.titleNo = titleNo;
	}
	/***********************************************************/
	
	@Override
	public String toString() {
		return "ItemVO [itemNo=" + itemNo + ", itemOption=" + itemOption + ", itemName=" + itemName + "]";
	}
}
