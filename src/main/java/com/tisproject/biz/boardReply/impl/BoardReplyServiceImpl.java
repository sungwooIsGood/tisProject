package com.tisproject.biz.boardReply.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tisproject.biz.boardReply.boardDto.BoardReplyService;
import com.tisproject.biz.boardReply.boardDto.BoardReplyVO;

import lombok.AllArgsConstructor;

@Service("boardReply")
@AllArgsConstructor
public class BoardReplyServiceImpl implements BoardReplyService {
	
	private BoardReplyDAO boardReplyDAO;
		
	@Override
	public void insertBoardReply(BoardReplyVO vo) {
		boardReplyDAO.insertBoardReply(vo);
	}

	@Override
	public void updateBoardReply(BoardReplyVO vo) {
		boardReplyDAO.updateBoardReply(vo);
	}	

	@Override
	public void deleteBoardReply(BoardReplyVO vo) {
		boardReplyDAO.deleteBoardReply(vo);
	}

	@Override
	public BoardReplyVO getBoardReply(BoardReplyVO vo) {
		return null;//boardReplyDAO.getBoardReply(vo);
	}

	@Override
	public List<BoardReplyVO> getBoardReplyList(BoardReplyVO vo) {
		return boardReplyDAO.getBoardReplyList(vo);
	}

}
