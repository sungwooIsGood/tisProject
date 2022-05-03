package com.tisproject.biz.title;

import java.util.List;

public interface TitleService {
	
	// 타이틀 등록
	void insertTitle(TitleVO vo);
	
	// 타이틀 수정
	void updateTitle(TitleVO vo);
	
	// 타이틀 삭제
	void deleteTitle(TitleVO vo);
	
	// 타이틀 상세 조회
	TitleVO getTitle(TitleVO vo);
	
	// 가장 최신 타이틀 5개 조회
	List<TitleVO> getLastestTitleFive(TitleVO vo);
	
	// 가장 최신 타이틀 조회
	TitleVO getLastestTitle(TitleVO vo);
	
	// 가장 평점이 높은 타이틀 5개 조회
	List<TitleVO> getBestGradeTitleFive(TitleVO vo);
	
	// 가장 평점이 높은 조회
	TitleVO getBestGradeTitle(TitleVO vo);
	
	// 가장 많이본 타이틀 5개 조회
	List<TitleVO> getBestViewTitleFive(TitleVO vo);
	
	// 가장 많이본 타이틀 조회
	TitleVO getBestViewTitle(TitleVO vo);
	
	// 해당 장르의 타이틀 조회
	List<TitleVO> getGenreTitleFive(TitleVO vo);
	
	// 모든 타이틀 조회
	List<TitleVO> getTitleList(TitleVO vo);
	
	// 페이징 처리하여 타이틀 조회
	List<TitleVO> getTitleListPage(TitleVO vo);
	
	// 총 타이틀 갯수 조회
	Integer getTotalTitleCount(TitleVO vo);
	
	// 검색란에 검색 시 조건에 맞는 영화 밑 드라마 조회
	List<TitleVO> inputSearch(TitleVO titleVo);
}
