package com.tisproject.biz.user.DTO;

import java.sql.Date;
import java.util.Arrays;


public class UserVO {
	private int id;
	private String userid;
	private String password;
	private String email;
	private String nickname;
	
	private Date birthday;
	
	private char gender;
	private int rank;
	private int icon;
	private int favorite_genre1;
	private int favorite_genre2;
	private int favorite_genre3;
	
	private String genrename1;
	private String genrename2;
	private String genrename3;
	
	


	private int manager;

	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}


	//테이블에 없는 값
	private int click;
	private int lastmovie;
	
	

	public int getLastmovie() {
		return lastmovie;
	}
	public void setLastmovie(int lastmovie) {
		this.lastmovie = lastmovie;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	
	
	// 보관함
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
	private String locker;
	
	
	
	
	
	
	public String getLocker() {
		return locker;
	}
	public void setLocker(String locker) {
		this.locker = locker;
	}
	public int getFavorite_genre1() {
		return favorite_genre1;
	}
	public void setFavorite_genre1(int favorite_genre1) {
		this.favorite_genre1 = favorite_genre1;
	}
	public int getFavorite_genre2() {
		return favorite_genre2;
	}
	public void setFavorite_genre2(int favorite_genre2) {
		this.favorite_genre2 = favorite_genre2;
	}
	public int getFavorite_genre3() {
		return favorite_genre3;
	}
	public void setFavorite_genre3(int favorite_genre3) {
		this.favorite_genre3 = favorite_genre3;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date date) {
		this.birthday = date;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char c) {
		this.gender = c;
	}
	
	public String getGenrename1() {
		return genrename1;
	}
	public void setGenrename1(String genrename1) {
		this.genrename1 = genrename1;
	}
	public String getGenrename2() {
		return genrename2;
	}
	public void setGenrename2(String genrename2) {
		this.genrename2 = genrename2;
	}
	public String getGenrename3() {
		return genrename3;
	}
	public void setGenrename3(String genrename3) {
		this.genrename3 = genrename3;
	}


	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", userid=" + userid + ", password=" + password + ", email=" + email + ", nickname="
				+ nickname + ", birthday=" + birthday + ", gender=" + gender + ", rank=" + rank + ", icon=" + icon
				+ ", favorite_genre1=" + favorite_genre1 + ", favorite_genre2=" + favorite_genre2 + ", favorite_genre3="
				+ favorite_genre3 + ", genrename1=" + genrename1 + ", genrename2=" + genrename2 + ", genrename3="
				+ genrename3 + ", manager=" + manager + ", click=" + click + ", lastmovie=" + lastmovie + ", titleNo="
				+ titleNo + ", title=" + title + ", synopsis=" + synopsis + ", actor=" + actor + ", director="
				+ director + ", releaseDate=" + releaseDate + ", updateDate=" + updateDate + ", age=" + age
				+ ", series=" + series + ", poster=" + poster + ", backImg=" + backImg + ", locker=" + locker + "]";
	}
	
	
	
	
	

	

	
}
	
	
	

	
	
	

	
	
	
	
