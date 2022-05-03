package com.tisproject.biz.item.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tisproject.biz.item.ItemVO;
import com.tisproject.biz.title.TitleVO;

@Repository
public class ItemDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertItem(ItemVO vo) {
		System.out.println("===> Mybatis로 insertItem() 실행");
		mybatis.insert("ItemDAO.insertItem", vo);
	}
	
	public void updateItem(ItemVO vo) {
		System.out.println("===> Mybatis로 updateItem() 실행");
		mybatis.update("ItemDAO.updateItem", vo);
	}
	
	public void deleteItem(ItemVO vo) {
		System.out.println("===> Mybatis로 deleteItem() 실행");
		mybatis.delete("ItemDAO.deleteItem", vo);
	}
	
	public ItemVO getItem(ItemVO vo) {
		System.out.println("===> Mybatis로 getItem() 실행");
		return mybatis.selectOne("ItemDAO.getItem", vo);
	}
	
	public List<ItemVO> getGenreItemList(ItemVO vo) {
		System.out.println("===> Mybatis로 getGenreItemList() 실행");
		return mybatis.selectList("ItemDAO.getGenreItemList", vo);
	}
	
	public List<ItemVO> getNationItemList(ItemVO vo) {
		System.out.println("===> Mybatis로 getNationItemList() 실행");
		return mybatis.selectList("ItemDAO.getNationItemList", vo);
	}
	
	public List<ItemVO> getPointItemList(ItemVO vo) {
		System.out.println("===> Mybatis로 getPointItemList() 실행");
		return mybatis.selectList("ItemDAO.getPointItemList", vo);
	}
	
	public List<ItemVO> getGenreItemListByTitle(ItemVO vo) {
		System.out.println("===> Mybatis로 getGenreItemListByTitle() 실행");
		return mybatis.selectList("ItemDAO.getGenreItemListByTitle", vo);
	}
	
	public List<ItemVO> getNationItemListByTitle(ItemVO vo) {
		System.out.println("===> Mybatis로 getNationItemListByTitle() 실행");
		return mybatis.selectList("ItemDAO.getNationItemListByTitle", vo);
	}
	
	public List<ItemVO> getPointItemListByTitle(ItemVO vo) {
		System.out.println("===> Mybatis로 getPointListItemByTitle() 실행");
		return mybatis.selectList("ItemDAO.getPointItemListByTitle", vo);
	}
	
	/* 안성우 수정 */
	//////////////////////////// 장르, 국가, 특징 선택 시 알맞은 영화 및 드라마 가져오기
	public List<TitleVO> getTitleItem(ItemVO vo){
		System.out.println("===> Mybatis로 getTitleItem() 실행");
		return mybatis.selectList("ItemDAO.getTitleItem",vo);
	}
}
