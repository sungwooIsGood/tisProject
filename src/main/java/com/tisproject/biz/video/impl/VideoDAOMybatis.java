package com.tisproject.biz.video.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tisproject.biz.video.VideoVO;

@Repository
public class VideoDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertVideo(VideoVO vo) {
		System.out.println("===> Mybatis로 insertVideo() 실행");
		mybatis.insert("VideoDAO.insertVideo", vo);
	}
	
	public void updateVideo(VideoVO vo) {
		System.out.println("===> Mybatis로 updateVideo() 실행");
		mybatis.update("VideoDAO.updateVideo", vo);
	}
	
	public void deleteVideo(VideoVO vo) {
		System.out.println("===> Mybatis로 deleteVideo() 실행");
		mybatis.delete("VideoDAO.deleteVideo", vo);
	}
	
	public VideoVO getVideo(VideoVO vo) {
		System.out.println("===> Mybatis로 getVideo() 실행");
		return mybatis.selectOne("VideoDAO.getVideo", vo);
	}
	
	public List<VideoVO> getVideoList(VideoVO vo) {
		System.out.println("===> Mybatis로 getVideoList() 실행");
		return mybatis.selectList("VideoDAO.getVideoList", vo);
	}
	
	public void deleteVideoByTitle(VideoVO vo) {
		System.out.println("===> Mybatis로 deleteVideoByTitle() 실행");
		mybatis.delete("VideoDAO.deleteVideoByTitle", vo);
	}
	
	public Integer getVideoCount(VideoVO vo) {
		System.out.println("===> Mybatis로 getVideoCount() 실행");
		return mybatis.selectOne("VideoDAO.getVideoCount", vo);
	}
	
	public VideoVO getOtherVideo(VideoVO vo) {
		System.out.println("===> Mybatis로 getOtherVideo() 실행");
		return mybatis.selectOne("VideoDAO.getOtherVideo", vo);
	}
	
	public VideoVO getLastVideo(VideoVO vo) {
		System.out.println("===> Mybatis로 getLastVideo() 실행");
		return mybatis.selectOne("VideoDAO.getLastVideo", vo);
	}
	
	public List<VideoVO> getVideoListPage(VideoVO vo) {
		System.out.println("===> Mybatis로 getVideoListPage() 실행");
		return mybatis.selectList("VideoDAO.getVideoListPage", vo);
	}
	
	public VideoVO getVideoByEpisodeNo(VideoVO vo) {
		System.out.println("===> Mybatis로 getVideoByEpisodeNo() 실행");
		return mybatis.selectOne("VideoDAO.getVideoByEpisodeNo", vo);
	}
}
