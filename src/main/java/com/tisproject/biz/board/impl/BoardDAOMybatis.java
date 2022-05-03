package com.tisproject.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tisproject.biz.board.boardDto.BoardVO;
import com.tisproject.biz.board.boardDto.Criteria;

@Repository
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;

	// 게시물 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("==> Mybatis로 insertBoard() 기능 처리");
		mybatis.insert("BoardDAO.insertBoard",vo);
	}
	
	// 게시물 전체조회
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("==>Mybatis로 getBoardList()기능처리");
		return mybatis.selectList("BoardDAO.getBoardList_T", vo);
	}
	
	// 게시물 상세조회
	public BoardVO getBoard(BoardVO vo) {
		// 조회수 올라가는 sql문
		mybatis.update("BoardDAO.cntUpdate",vo);
		System.out.println("==>Mybatis로 getBoard()기능처리");
		return mybatis.selectOne("BoardDAO.getBoard",vo);
	}
	
	// 게시물 수정
	public int modifyBoard(BoardVO vo) {
		System.out.println("==>Mybatis로 modifyBoard()기능처리");
		return mybatis.update("BoardDAO.modityBoard",vo);
	}

	// ======================================================================================
	
	// 게시물 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("==>Mybatis로 deleteBoard()기능처리");
		mybatis.delete("BoardDAO.deleteBoard",vo);
	}

	// 페이징 처리
	public List<BoardVO> getListWithPaging(Criteria cri) {
		
		return mybatis.selectList("BoardDAO.getListWithPaging", cri);
	}

	public int getTotalCount(Criteria cri) {
		
		return mybatis.selectOne(("BoardDAO.getTotalCount"));
	}

	
	// ======================================================================================
//	public List<BoardVO> getListWithPaging(Criteria cri) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
