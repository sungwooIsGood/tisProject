package com.tisproject.biz.grade;

public interface GradeService {

	// 평점 추가
	public void insertGrade(GradeVO vo);
	
	// 평점 수정
	public void updateGrade(GradeVO vo);
	
	// 평점 읽기
	public GradeVO getGrade(GradeVO vo);
	
	// 평점 평균 읽기
	public Float getTitleAvg(GradeVO vo);
	
	// 타이틀 삭제로 인해 평점 삭제
	public void deleteGradeByTitle(GradeVO vo);
	
	// 유저 삭제로 인해 평점 삭제
	public void deleteGradeByUser(GradeVO vo);
}
