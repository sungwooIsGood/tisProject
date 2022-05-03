package com.tisproject.biz.video;

import org.springframework.web.multipart.MultipartFile;

public class VideoVO {
	private int videoNo;
	private int titleNo;
	private String videoTitle;
	private int videoEpisodeNo;
	private String videoThumbnail;
	private int videoWatchTime;
	private String video;
	
	
	/************************Table 이외**************************/
	// 포스터 파일
	private MultipartFile videoFile;
	
	// 백그라운드 이미지 파일
	private MultipartFile videoThumbnailFile;
	
	// 시간 계산
	private int videoWatchTimeMin;
	private int videoWatchTimeSec;
	
	// 페이징
	private int startVideo;
	private int stepVideo;
	
	/***********************************************************/
	
	public int getVideoNo() {
		return videoNo;
	}
	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}
	public int getTitleNo() {
		return titleNo;
	}
	public void setTitleNo(int titleNo) {
		this.titleNo = titleNo;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public int getVideoEpisodeNo() {
		return videoEpisodeNo;
	}
	public void setVideoEpisodeNo(int videoEpisodeNo) {
		this.videoEpisodeNo = videoEpisodeNo;
	}
	public String getVideoThumbnail() {
		return videoThumbnail;
	}
	public void setVideoThumbnail(String videoThumbnail) {
		this.videoThumbnail = videoThumbnail;
	}
	public int getVideoWatchTime() {
		return videoWatchTime;
	}
	public void setVideoWatchTime(int videoWatchTime) {
		this.videoWatchTime = videoWatchTime;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	
	/************************Table 이외**************************/
	public MultipartFile getVideoFile() {
		return videoFile;
	}
	public void setVideoFile(MultipartFile videoFile) {
		this.videoFile = videoFile;
	}
	public MultipartFile getVideoThumbnailFile() {
		return videoThumbnailFile;
	}
	public void setVideoThumbnailFile(MultipartFile videoThumbnailFile) {
		this.videoThumbnailFile = videoThumbnailFile;
	}
	
	// 시간 계산
	public int getVideoWatchTimeMin() {
		return videoWatchTimeMin;
	}
	public void setVideoWatchTimeMin(int videoWatchTimeMin) {
		this.videoWatchTimeMin = videoWatchTimeMin;
	}
	public int getVideoWatchTimeSec() {
		return videoWatchTimeSec;
	}
	public void setVideoWatchTimeSec(int videoWatchTimeSec) {
		this.videoWatchTimeSec = videoWatchTimeSec;
	}
	
	// 페이징
	public int getStartVideo() {
		return startVideo;
	}
	public void setStartVideo(int startVideo) {
		this.startVideo = startVideo;
	}
	public int getStepVideo() {
		return stepVideo;
	}
	public void setStepVideo(int stepVideo) {
		this.stepVideo = stepVideo;
	}
	/***********************************************************/
	
	
	@Override
	public String toString() {
		return "VideoVO [videoNo=" + videoNo + ", titleNo=" + titleNo + ", videoTitle=" + videoTitle
				+ ", videoEpisodeNo=" + videoEpisodeNo + ", video=" + video + "]";
	}
	
}
