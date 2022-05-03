package com.tisproject.biz.grade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisproject.biz.grade.GradeService;
import com.tisproject.biz.grade.GradeVO;

@Service("GradeService")
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDAOMybatis gradeDAO;
	
	@Override
	public void insertGrade(GradeVO vo) {
		gradeDAO.insertGrade(vo);
	}

	@Override
	public void updateGrade(GradeVO vo) {
		gradeDAO.updateGrade(vo);
	}

	@Override
	public GradeVO getGrade(GradeVO vo) {
		return gradeDAO.getGrade(vo);
	}

	@Override
	public Float getTitleAvg(GradeVO vo) {
		return gradeDAO.getTitleAvg(vo);
	}

	@Override
	public void deleteGradeByTitle(GradeVO vo) {
		gradeDAO.deleteGradeByTitle(vo);
	}

	@Override
	public void deleteGradeByUser(GradeVO vo) {
		gradeDAO.deleteGradeByUser(vo);
	}
}
