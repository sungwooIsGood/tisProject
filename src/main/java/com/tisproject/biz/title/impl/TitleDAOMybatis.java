package com.tisproject.biz.title.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tisproject.biz.title.TitleVO;

@Repository
public class TitleDAOMybatis { 
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertTitle(TitleVO vo) {
		System.out.println("===> Mybatis로 insertTitle() 실행");
		mybatis.insert("TitleDAO.insertTitle", vo);
	}
	
	public void updateTitle(TitleVO vo) {
		System.out.println("===> Mybatis로 updateTitle() 실행");
		mybatis.update("TitleDAO.updateTitle", vo);
	}
	
	public void deleteTitle(TitleVO vo) {
		System.out.println("===> Mybatis로 deleteTitle() 실행");
		mybatis.delete("TitleDAO.deleteTitle", vo);
	}
	
	public TitleVO getTitle(TitleVO vo) {
		System.out.println("===> Mybatis로 getTitle() 실행");
		return mybatis.selectOne("TitleDAO.getTitle", vo);
	}
	
	public List<TitleVO> getLastestTitleFive(TitleVO vo) {
		System.out.println("===> Mybatis로 getLastestTitleFive() 실행");
		return mybatis.selectList("TitleDAO.getLastestTitleFive", vo);	
	}
	
	public TitleVO getLastestTitle(TitleVO vo) {
		System.out.println("===> Mybatis로 getLastestTitle() 실행");
		return mybatis.selectOne("TitleDAO.getLastestTitle", vo);
	}
	
	public List<TitleVO> getBestGradeTitleFive(TitleVO vo) {
		System.out.println("===> Mybatis로 getBestGradeTitleFive() 실행");
		return mybatis.selectList("TitleDAO.getBestGradeTitleFive", vo);	
	}
	
	public TitleVO getBestGradeTitle(TitleVO vo) {
		System.out.println("===> Mybatis로 getBestGradeTitle() 실행");
		return mybatis.selectOne("TitleDAO.getBestGradeTitle", vo);
	}
	
	public List<TitleVO> getBestViewTitleFive(TitleVO vo) {
		System.out.println("===> Mybatis로 getBestViewTitleFive() 실행");
		return mybatis.selectList("TitleDAO.getBestViewTitleFive", vo);	
	}
	
	public TitleVO getBestViewTitle(TitleVO vo) {
		System.out.println("===> Mybatis로 getBestViewTitle() 실행");
		return mybatis.selectOne("TitleDAO.getBestViewTitle", vo);
	}
	
	public List<TitleVO> getGenreTitleFive(TitleVO vo) {
		System.out.println("===> Mybatis로 getGenreTitleFive() 실행");
		return mybatis.selectList("TitleDAO.getGenreTitleFive", vo);
	}
	
	public List<TitleVO> getTitleList(TitleVO vo) {
		System.out.println("===> Mybatis로 getTitleList() 실행");
		return mybatis.selectList("TitleDAO.getTitleList", vo);
	}
	
	public List<TitleVO> getTitleListPage(TitleVO vo) {
		System.out.println("===> Mybatis로 getTitleListPage() 실행");
		return mybatis.selectList("TitleDAO.getTitleListPage", vo);
	}
	
	public Integer getTotalTitleCount(TitleVO vo) {
		System.out.println("===> Mybatis로 getTotalTitleCount() 실행");
		return mybatis.selectOne("TitleDAO.getTotalTitleCount", vo);
	}
	
	public List<TitleVO>inputSearch(TitleVO vo){
		System.out.println("===> Mybatis로 inputSearch() 실행");
		return mybatis.selectList("TitleDAO.inputSearch", vo);
	}
}
