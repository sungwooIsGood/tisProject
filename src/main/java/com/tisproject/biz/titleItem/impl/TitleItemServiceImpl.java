package com.tisproject.biz.titleItem.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisproject.biz.titleItem.TitleItemService;
import com.tisproject.biz.titleItem.TitleItemVO;

@Service("TitleItemService")
public class TitleItemServiceImpl implements TitleItemService {

	@Autowired
	private TitleItemDAOMybatis titleItemDAO;

	@Override
	public void insertTitleItem(TitleItemVO vo) {
		titleItemDAO.insertTitleItem(vo);
	}

	@Override
	public void deleteTitleItemByItem(TitleItemVO vo) {
		titleItemDAO.deleteTitleItemByItem(vo);
	}

	@Override
	public void deleteTitleItemByTitle(TitleItemVO vo) {
		titleItemDAO.deleteTitleItemByTitle(vo);
	}

	@Override
	public List<TitleItemVO> getTitleItemListByTitle(TitleItemVO vo) {
		return titleItemDAO.getTitleItemListByTitle(vo);
	}
}
