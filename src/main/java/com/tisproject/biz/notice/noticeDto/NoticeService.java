package com.tisproject.biz.notice.noticeDto;

import java.util.List;

public interface NoticeService {
	// 글 등록
	void insertNotice(NoticeVO vo);
	
	// 글 수정
	int modifyNotice(NoticeVO vo);

	// 글 삭제
	void deleteNotice(NoticeVO vo);

	// 글 상세 조회
	NoticeVO getNotice(NoticeVO vo);

	// 글 목록 조회
	List<NoticeVO> getNoticeList(NoticeVO vo);
	
	public List<NoticeVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);
	
	// 최신 글 새창 띄우기
	NoticeVO getNoticeWindow(NoticeVO vo);

}
