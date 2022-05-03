package com.tisproject.biz.item.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisproject.biz.item.ItemService;
import com.tisproject.biz.item.ItemVO;
import com.tisproject.biz.title.TitleVO;

@Service("ItemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAOMybatis itemDAO;
	
	@Override
	public void insertItem(ItemVO vo) {
		itemDAO.insertItem(vo);
	}

	@Override
	public void updateItem(ItemVO vo) {
		itemDAO.updateItem(vo);
	}

	@Override
	public void deleteItem(ItemVO vo) {
		itemDAO.deleteItem(vo);
	}

	@Override
	public ItemVO getItem(ItemVO vo) {
		return itemDAO.getItem(vo);
	}

	@Override
	public List<ItemVO> getGenreItemList(ItemVO vo) {
		return itemDAO.getGenreItemList(vo);
	}

	@Override
	public List<ItemVO> getNationItemList(ItemVO vo) {
		return itemDAO.getNationItemList(vo);
	}

	@Override
	public List<ItemVO> getPointItemList(ItemVO vo) {
		return itemDAO.getPointItemList(vo);
	}

	@Override
	public List<ItemVO> getGenreItemListByTitle(ItemVO vo) {
		return itemDAO.getGenreItemListByTitle(vo);
	}

	@Override
	public List<ItemVO> getNationItemListByTitle(ItemVO vo) {
		return itemDAO.getNationItemListByTitle(vo);
	}

	@Override
	public List<ItemVO> getPointItemListByTitle(ItemVO vo) {
		return itemDAO.getPointItemListByTitle(vo);
	}

	@Override
	public List<TitleVO> getTitleItem(ItemVO vo) {
		return itemDAO.getTitleItem(vo);
	}
}
