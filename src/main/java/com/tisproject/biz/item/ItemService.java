package com.tisproject.biz.item;

import java.util.List;

import com.tisproject.biz.title.TitleVO;

public interface ItemService {
	// 아이템 등록
	void insertItem(ItemVO vo);
	
	// 아이템 수정
	void updateItem(ItemVO vo);
	
	// 아이템 삭제
	void deleteItem(ItemVO vo);
	
	// 아이템 상세 조회
	ItemVO getItem(ItemVO vo);
	
	// 아이템 '장르' 목록 조회
	List<ItemVO> getGenreItemList(ItemVO vo);
	
	// 아이템 '국가' 목록 조회
	List<ItemVO> getNationItemList(ItemVO vo);
	
	// 아이템 '특징' 목록 조회
	List<ItemVO> getPointItemList(ItemVO vo);
	
	// 해당 타이틀의 '장르' 아이템 목록 조회
	List<ItemVO> getGenreItemListByTitle(ItemVO vo);
	
	// 해당 타이틀의 '국가' 아이템 목록 조회
	List<ItemVO> getNationItemListByTitle(ItemVO vo);
	
	// 해당 타이틀의 '특징' 아이템 목록 조회
	List<ItemVO> getPointItemListByTitle(ItemVO vo);
	
	// 장르, 국가, 특징 선택 시 알맞은 영화 및 드라마 가져오기
	List<TitleVO> getTitleItem(ItemVO vo);
}
