package com.tisproject.biz.boardReply.boardDto;

import java.util.List;

public interface BoardReplyService {
		
	// 댓글 등록
	public void insertBoardReply(BoardReplyVO vo);
	
	// 댓글 수정
	public void updateBoardReply(BoardReplyVO vo);

	// 댓글 삭제
	public void deleteBoardReply(BoardReplyVO vo);

	// 댓글 상세 조회
	public BoardReplyVO getBoardReply(BoardReplyVO vo);

	// 댓글 목록 조회
	public List<BoardReplyVO> getBoardReplyList(BoardReplyVO vo);
}
