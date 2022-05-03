package com.tisproject.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisproject.biz.board.boardDto.BoardService;
import com.tisproject.biz.board.boardDto.BoardVO;
import com.tisproject.biz.board.boardDto.Criteria;


@Service("BoardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private  BoardDAOMybatis boardDAO;


	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);

	}

	@Override
	public int modifyBoard(BoardVO vo) {
		return boardDAO.modifyBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return  boardDAO.getBoardList(vo);
	}


	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		return boardDAO.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		
		return boardDAO.getTotalCount(cri);
	}

}
