package com.tisproject.biz.video.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisproject.biz.video.VideoService;
import com.tisproject.biz.video.VideoVO;

@Service("VideoService")
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoDAOMybatis videoDAO;
	
	@Override
	public void insertVideo(VideoVO vo) {
		videoDAO.insertVideo(vo);
	}

	@Override
	public void updateVideo(VideoVO vo) {
		videoDAO.updateVideo(vo);
	}

	@Override
	public void deleteVideo(VideoVO vo) {
		videoDAO.deleteVideo(vo);
	}

	@Override
	public VideoVO getVideo(VideoVO vo) {
		return videoDAO.getVideo(vo);
	}

	@Override
	public List<VideoVO> getVideoList(VideoVO vo) {
		return videoDAO.getVideoList(vo);
	}

	@Override
	public void deleteVideoByTitle(VideoVO vo) {
		videoDAO.deleteVideoByTitle(vo);
	}

	@Override
	public Integer getVideoCount(VideoVO vo) {
		return videoDAO.getVideoCount(vo);
	}

	@Override
	public VideoVO getOtherVideo(VideoVO vo) {
		return videoDAO.getOtherVideo(vo);
	}
	
	@Override
	public VideoVO getLastVideo(VideoVO vo) {
		return videoDAO.getLastVideo(vo);
	}

	@Override
	public List<VideoVO> getVideoListPage(VideoVO vo) {
		return videoDAO.getVideoListPage(vo);
	}

	@Override
	public VideoVO getVideoByEpisodeNo(VideoVO vo) {
		return videoDAO.getVideoByEpisodeNo(vo);
	}
}
