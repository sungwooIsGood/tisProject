package com.tisproject.biz.boardReply.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tisproject.biz.boardReply.boardDto.BoardReplyVO;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class BoardReplyDAO {

//	========SqlSessionTemplate방식=====	
	private SqlSessionTemplate boardReplyMybatis;
	
	// 댓글 등록
	public void insertBoardReply(BoardReplyVO vo) {
		System.out.println("==> Mybatis로 insertBoardReply() 기능 처리");
		boardReplyMybatis.insert("BoardReplyDAO.insertReply",vo);
	}
	
	// 댓글 조회
	public List<BoardReplyVO> getBoardReplyList(BoardReplyVO vo){
		System.out.println("==>Mybatis로 getBoardReplyList()기능처리");
		return boardReplyMybatis.selectList("BoardReplyDAO.getBoardReplyList", vo);
	}
	
	// 댓글 삭제
	public void deleteBoardReply(BoardReplyVO vo) {
		System.out.println("==>Mybatis로 deleteBoardReplyList()기능처리");
		boardReplyMybatis.delete("BoardReplyDAO.deleteReply",vo);
	}
	
	// 댓글 수정
	public void updateBoardReply(BoardReplyVO vo) {
		System.out.println("==>Mybatis로 updateBoardReplyList()기능처리");
		boardReplyMybatis.update("BoardReplyDAO.updateReply",vo);
	}
	
	// 댓글 총 갯수
	public BoardReplyVO getBoardReplyCount(BoardReplyVO vo) {
	   System.out.println("==>Mybatis로 getBoardCount()기능처리");
	   return boardReplyMybatis.selectOne("BoardReplyDAO.getBoardReplyCount", vo); // count함수는 selectOne메소드 사용
	}
}
