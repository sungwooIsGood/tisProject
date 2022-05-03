package com.tisproject.biz.video;

import java.util.List;

public interface VideoService {
	
	// 비디오 등록
	void insertVideo(VideoVO vo);
	
	// 비디오 수정
	void updateVideo(VideoVO vo);
	
	// 비디오 삭제
	void deleteVideo(VideoVO vo);
	
	// 비디오 상세 조회
	VideoVO getVideo(VideoVO vo);
	
	// 비디오 목록 조회
	List<VideoVO> getVideoList(VideoVO vo);
	
	// 해당 타이틀의 비디오 모두 삭제
	void deleteVideoByTitle(VideoVO vo);
	
	// 해당 타이틀의 비디오 숫자 읽어오기
	Integer getVideoCount(VideoVO vo);
	
	// 해당 타이틀의 다른 에피소드 읽어오기
	VideoVO getOtherVideo(VideoVO vo);
	
	// 해당 타이틀의 마지막 에피소드 읽어오기
	VideoVO getLastVideo(VideoVO vo);
	
	// 해당 타이틀의 비디오를 페이징 처리 하여 조회
	List<VideoVO> getVideoListPage(VideoVO vo);
	
	// 해당 타이틀의 해당 에피소드번호가 중복되는지 확인
	VideoVO getVideoByEpisodeNo(VideoVO vo);
} 
