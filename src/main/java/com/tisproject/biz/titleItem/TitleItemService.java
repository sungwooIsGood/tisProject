package com.tisproject.biz.titleItem;

import java.util.List;

public interface TitleItemService {
	
	// 타이틀아이템 연결 등록
	void insertTitleItem(TitleItemVO vo);
	
	// 타이틀아이템 연결 아이템에 의해 삭제
	void deleteTitleItemByItem(TitleItemVO vo);
		
	// 타이틀아이템 연결 타이틀에 의해 삭제
	void deleteTitleItemByTitle(TitleItemVO vo);
	
	// 타이틀아이템 리스트 타이틀에 의해 조회
	List<TitleItemVO> getTitleItemListByTitle(TitleItemVO vo);
}
