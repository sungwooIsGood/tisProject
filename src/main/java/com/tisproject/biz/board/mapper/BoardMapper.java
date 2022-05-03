package com.tisproject.biz.board.mapper;

import java.util.List;

import com.tisproject.biz.board.boardDto.BoardVO;
import com.tisproject.biz.board.boardDto.Criteria;

public interface BoardMapper {
	
	public List<BoardVO> getBoardList();
	
	List<BoardVO> getListWithPaging(Criteria cri);
}
