package com.tisproject.biz.title;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class TitleVO {
	private int titleNo;
	private String title;
	private String synopsis;
	private String actor;
	private String director;
	private Date releaseDate;
	private Date updateDate;
	private int age;
	private char series;
	private String poster;
	private String backImg;
	
	
	/************************Table 이외**************************/
	private char searchType;
	private int userId;
	private int genreId;
	
	// 포스터 파일
	private MultipartFile posterFile;
	
	// 백그라운드 이미지 파일
	private MultipartFile backImgFile;
	
	// 페이징
	private int startTitle;
	private int stepTitle;
	
	// 검색
	private String inputSearch;
	private char keywordSearch;
	
	/***********************************************************/
	
	public int getTitleNo() {
		return titleNo;
	}
	public void setTitleNo(int titleNo) {
		this.titleNo = titleNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSeries() {
		return series;
	}
	public void setSeries(char series) {
		this.series = series;
	}	
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getBackImg() {
		return backImg;
	}
	public void setBackImg(String backImg) {
		this.backImg = backImg;
	}
	
	/************************Table 이외**************************/
	public char getSearchType() {
		return searchType;
	}
	public void setSearchType(char searchType) {
		this.searchType = searchType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	
	// 포스터 파일
	public MultipartFile getPosterFile() {
		return posterFile;
	}
	public void setPosterFile(MultipartFile posterFile) {
		this.posterFile = posterFile;
	}
	
	// 백그라운드 이미지 파일
	public MultipartFile getBackImgFile() {
		return backImgFile;
	}
	public void setBackImgFile(MultipartFile backImgFile) {
		this.backImgFile = backImgFile;
	}
	
	// 페이징
	
	public int getStartTitle() {
		return startTitle;
	}
	public void setStartTitle(int startTitle) {
		this.startTitle = startTitle;
	}
	public int getStepTitle() {
		return stepTitle;
	}
	public void setStepTitle(int stepTitle) {
		this.stepTitle = stepTitle;
	}
	
	// 검색
	public String getInputSearch() {
		return inputSearch;
	}
	public void setInputSearch(String inputSearch) {
		this.inputSearch = inputSearch;
	}
	
	public char getKeywordSearch() {
		return keywordSearch;
	}
	public void setKeywordSearch(char keywordSearch) {
		this.keywordSearch = keywordSearch;
	}
	/***********************************************************/
	
	@Override
	public String toString() {
		return "TitleVO [titleNo=" + titleNo + ", title=" + title + ", synopsis=" + synopsis + ", actor=" + actor
				+ ", director=" + director + ", releaseDate=" + releaseDate + ", updateDate=" + updateDate + ", age="
				+ age + ", series=" + series + ", poster=" + poster + ", backImg=" + backImg + "]";
	}
}
