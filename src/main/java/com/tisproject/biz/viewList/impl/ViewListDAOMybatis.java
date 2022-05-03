package com.tisproject.biz.viewList.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tisproject.biz.viewList.ViewListVO;

@Repository
public class ViewListDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertViewList(ViewListVO vo) {
		System.out.println("===> Mybatis로 insertViewList() 실행");
		mybatis.insert("ViewListDAO.insertViewList", vo);
	}
	
	public void deleteViewListByUser(ViewListVO vo) {
		System.out.println("===> Mybatis로 deleteViewListByUser() 실행");
		mybatis.delete("ViewListDAO.deleteViewListByUser", vo);
	}
	
	public void deleteViewListByTitle(ViewListVO vo) {
		System.out.println("===> Mybatis로 deleteViewListByTitle() 실행");
		mybatis.delete("ViewListDAO.deleteViewListByTitle", vo);
	}
	
	ViewListVO getViewList(ViewListVO vo) {
		System.out.println("===> Mybatis로 getViewList() 실행");
		return mybatis.selectOne("ViewListDAO.getViewList", vo);
	}
	
	Integer getViewListCountByTitle(ViewListVO vo) {
		System.out.println("===> Mybatis로 getViewListCountByTitle() 실행");
		return mybatis.selectOne("ViewListDAO.getViewListCountByTitle", vo);
	}
}
