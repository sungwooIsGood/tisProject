package com.tisproject.biz.notice.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tisproject.biz.notice.noticeDto.Criteria;
import com.tisproject.biz.notice.noticeDto.NoticeVO;

@Repository
public class NoticeDAOMybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	// 공지사항 등록
	public void insertNotice(NoticeVO vo) {
		System.out.println("==> Mybatis로 insertNotice() 기능 처리");
		mybatis.insert("NoticeDAO.insertNotice",vo);
	}
	
	// 공지사항 전체조회
	public List<NoticeVO> getNoticeList(NoticeVO vo){
		System.out.println("==>Mybatis로 getNoticeList()기능처리");
		return mybatis.selectList("NoticeDAO.getNoticeList_T", vo);
	}
	
	// 공지사항 상세조회
	public NoticeVO getNotice(NoticeVO vo) {
		// 조회수 올라가는 sql문
		mybatis.update("NoticeDAO.cntUpdate",vo);
		System.out.println("==>Mybatis로 getNotice()기능처리");
		return mybatis.selectOne("NoticeDAO.getNotice",vo);
	}
	
	// 공지사항 수정
	public int modifyNotice(NoticeVO vo) {
		System.out.println("==>Mybatis로 modifyNotice()기능처리");
		return mybatis.update("NoticeDAO.modityNotice",vo);
	}
	
	// 공지사항 삭제
	public void deleteNotice(NoticeVO vo) {
		System.out.println("==>Mybatis로 deleteNotice()기능처리");
		mybatis.delete("NoticeDAO.deleteNotice",vo);
	}

	// 페이징 처리
	public List<NoticeVO> getListWithPaging(Criteria cri) {
		return mybatis.selectList("NoticeDAO.getListWithPaging", cri);
	}
	
	public int getTotalCount(Criteria cri) {
		return mybatis.selectOne(("NoticeDAO.getTotalCount"));
	}

	// 최신 글 새창 띄우기
	public NoticeVO getNoticeWindow(NoticeVO vo) {
		System.out.println("==>Mybatis로 getNoticeWindow()기능처리");
		return mybatis.selectOne("NoticeDAO.getNoticeWindow",vo);
	}
	
	
}
