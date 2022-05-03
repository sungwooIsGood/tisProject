package com.tisproject.biz.notice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisproject.biz.notice.noticeDto.Criteria;
import com.tisproject.biz.notice.noticeDto.NoticeService;
import com.tisproject.biz.notice.noticeDto.NoticeVO;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private  NoticeDAOMybatis noticeDAO;
	
	@Override
	public void insertNotice(NoticeVO vo) {
		
		noticeDAO.insertNotice(vo);
	}

	@Override
	public int modifyNotice(NoticeVO vo) {
		
		return noticeDAO.modifyNotice(vo);
	}

	@Override
	public void deleteNotice(NoticeVO vo) {
		
		noticeDAO.deleteNotice(vo);
	}

	@Override
	public NoticeVO getNotice(NoticeVO vo) {
		
		return noticeDAO.getNotice(vo);
	}

	@Override
	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		
		return noticeDAO.getNoticeList(vo);
	}

	@Override
	public List<NoticeVO> getList(Criteria cri) {
		return noticeDAO.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return noticeDAO.getTotalCount(cri);
	}

	@Override
	public NoticeVO getNoticeWindow(NoticeVO vo) {
		return noticeDAO.getNoticeWindow(vo);
	}

}
