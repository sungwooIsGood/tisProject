package com.tisproject.biz.title.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisproject.biz.title.TitleService;
import com.tisproject.biz.title.TitleVO;

@Service("TitleService")
public class TitleServiceImpl implements TitleService {

	@Autowired
	private TitleDAOMybatis titleDAO;
	
	@Override
	public void insertTitle(TitleVO vo) {
		titleDAO.insertTitle(vo);
	}

	@Override
	public void updateTitle(TitleVO vo) {
		titleDAO.updateTitle(vo);
	}

	@Override
	public void deleteTitle(TitleVO vo) {
		titleDAO.deleteTitle(vo);	
	}

	@Override
	public TitleVO getTitle(TitleVO vo) {
		return titleDAO.getTitle(vo);
	}

	@Override
	public List<TitleVO> getLastestTitleFive(TitleVO vo) {
		return titleDAO.getLastestTitleFive(vo);
	}

	@Override
	public TitleVO getLastestTitle(TitleVO vo) {
		return titleDAO.getLastestTitle(vo);
	}

	@Override
	public List<TitleVO> getBestGradeTitleFive(TitleVO vo) {
		return titleDAO.getBestGradeTitleFive(vo);
	}

	@Override
	public TitleVO getBestGradeTitle(TitleVO vo) {
		return titleDAO.getBestGradeTitle(vo);
	}

	@Override
	public List<TitleVO> getBestViewTitleFive(TitleVO vo) {
		return titleDAO.getBestViewTitleFive(vo);
	}

	@Override
	public TitleVO getBestViewTitle(TitleVO vo) {
		return titleDAO.getBestViewTitle(vo);
	}

	@Override
	public List<TitleVO> getGenreTitleFive(TitleVO vo) {
		return titleDAO.getGenreTitleFive(vo);
	}

	@Override
	public List<TitleVO> getTitleList(TitleVO vo) {
		return titleDAO.getTitleList(vo);
	}

	@Override
	public List<TitleVO> getTitleListPage(TitleVO vo) {
		return titleDAO.getTitleListPage(vo);
	}

	@Override
	public Integer getTotalTitleCount(TitleVO vo) {
		return titleDAO.getTotalTitleCount(vo);
	}
	
	@Override
	public List<TitleVO> inputSearch(TitleVO titleVo) {
		return titleDAO.inputSearch(titleVo);
	}
}
