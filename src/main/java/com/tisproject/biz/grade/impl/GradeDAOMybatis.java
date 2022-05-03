package com.tisproject.biz.grade.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tisproject.biz.grade.GradeVO;

@Repository
public class GradeDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertGrade(GradeVO vo) {
		System.out.println("===> Mybatis로 insertGrade() 실행");
		mybatis.insert("GradeDAO.insertGrade", vo);
	}
	
	public void updateGrade(GradeVO vo) {
		System.out.println("===> Mybatis로 updateGrade() 실행");
		mybatis.update("GradeDAO.updateGrade", vo);
	}
	
	public GradeVO getGrade(GradeVO vo) {
		System.out.println("===> Mybatis로 getGrade() 실행");
		return mybatis.selectOne("GradeDAO.getGrade", vo);
	}
	
	public Float getTitleAvg(GradeVO vo) {
		System.out.println("===> Mybatis로 getTitleAvg() 실행");
		return mybatis.selectOne("GradeDAO.getTitleAvg", vo);
	}
	
	public void deleteGradeByTitle(GradeVO vo) {
		System.out.println("===> Mybatis로 deleteGradeByTitle() 실행");
		mybatis.delete("GradeDAO.deleteGradeByTitle", vo);
	}
	
	public void deleteGradeByUser(GradeVO vo) {
		System.out.println("===> Mybatis로 deleteGradeByUser() 실행");
		mybatis.delete("GradeDAO.deleteGradeByUser", vo);
	}
} 
