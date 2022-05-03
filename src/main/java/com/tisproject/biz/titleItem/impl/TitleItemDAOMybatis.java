package com.tisproject.biz.titleItem.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tisproject.biz.titleItem.TitleItemVO;

@Repository
public class TitleItemDAOMybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertTitleItem(TitleItemVO vo) {
		System.out.println("===> Mybatis로 insertTitleItem() 실행");
		mybatis.insert("TitleItemDAO.insertTitleItem", vo);
	}
	
	public void deleteTitleItemByItem(TitleItemVO vo) {
		System.out.println("===> Mybatis로 deleteTitleItemByItem() 실행");
		mybatis.delete("TitleItemDAO.deleteTitleItemByItem", vo);
	}
	
	public void deleteTitleItemByTitle(TitleItemVO vo) {
		System.out.println("===> Mybatis로 deleteTitleItemByTitle() 실행");
		mybatis.delete("TitleItemDAO.deleteTitleItemByTitle", vo);
	}
	
	List<TitleItemVO> getTitleItemListByTitle(TitleItemVO vo) {
		System.out.println("===> Mybatis로 getTitleItemListByTitle() 실행");
		return mybatis.selectList("TitleItemDAO.getTitleItemListByTitle", vo);
	}
}
