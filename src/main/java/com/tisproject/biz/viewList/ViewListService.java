package com.tisproject.biz.viewList;

public interface ViewListService {

	// viewList 추가
	void inserViewList(ViewListVO vo);
	
	// user 삭제로 인해 viewList도 해당 유저 데이터 삭제
	void deleteViewListByUser(ViewListVO vo);
	
	// title 삭제로 인해 viewList도 해당 타이틀 데이터 삭제
	void deleteViewListByTitle(ViewListVO vo);
	
	// 해당 유저와 타이틀에 해당하는 viewList 데이터 get
	ViewListVO getViewList(ViewListVO vo);
	
	// 해당 타이틀의 조회 목록 카운트 get
	Integer getViewListCountByTitle(ViewListVO vo);
}
