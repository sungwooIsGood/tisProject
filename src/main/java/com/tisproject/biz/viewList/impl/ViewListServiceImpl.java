package com.tisproject.biz.viewList.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisproject.biz.viewList.ViewListService;
import com.tisproject.biz.viewList.ViewListVO;

@Service("ViewListService")
public class ViewListServiceImpl implements ViewListService {

	@Autowired
	private ViewListDAOMybatis viewListDAO;

	@Override
	public void inserViewList(ViewListVO vo) {
		viewListDAO.insertViewList(vo);
	}

	@Override
	public void deleteViewListByUser(ViewListVO vo) {
		viewListDAO.deleteViewListByUser(vo);
	}

	@Override
	public void deleteViewListByTitle(ViewListVO vo) {
		viewListDAO.deleteViewListByTitle(vo);
	}

	@Override
	public ViewListVO getViewList(ViewListVO vo) {
		return viewListDAO.getViewList(vo);
	}

	@Override
	public Integer getViewListCountByTitle(ViewListVO vo) {
		return viewListDAO.getViewListCountByTitle(vo);
	}
}
