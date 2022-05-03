package com.tisproject.biz.grade;

public class GradeVO {
	private int gradeNo;
	private int userNo;
	private int titleNo;
	private float grade;
	
	/************************Table 이외**************************/
	private float gradeAvg;

	/***********************************************************/
	public int getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
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
	
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	/************************Table 이외**************************/
	public float getGradeAvg() {
		return gradeAvg;
	}
	public void setGradeAvg(float gradeAvg) {
		this.gradeAvg = gradeAvg;
	}
	/***********************************************************/
	@Override
	public String toString() {
		return "GradeVO [gradeNo=" + gradeNo + ", userNo=" + userNo + ", titleNo=" + titleNo + "]";
	}
}
