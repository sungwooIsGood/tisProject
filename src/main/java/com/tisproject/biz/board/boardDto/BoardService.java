package com.tisproject.biz.board.boardDto;

import java.util.List;

public interface BoardService {
	//글 등록
	void insertBoard(BoardVO vo);
	
	// 글 수정
	int modifyBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);

	// 글 상세 조회
	BoardVO getBoard(BoardVO vo);

	// 글 목록 조회
	List<BoardVO> getBoardList(BoardVO vo);
	
//	List<BoardVO> getBoardList(Criteria cri);
	
	public List<BoardVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);

}
