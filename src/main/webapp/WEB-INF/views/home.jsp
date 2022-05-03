<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/header.css">
	<link rel="stylesheet" href="resources/css/footer.css">
	<link rel="stylesheet" href="resources/css/home.css"> 
	<script src="resources/script/jquery.min.js"></script>
	<script src="resources/script/footer.js" defer></script>
    <script src="resources/script/home.js" defer></script>
<meta charset="UTF-8">
<title>왓챠</title>
<style>
.footer{
	padding-left:15%;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp" %>
	<div id="wrap">
		<main>
			<h1>홈</h1>
			<ul class="headContent clear">
				<li>
					<a href="videoInfo.do?titleNo=${bestGradeTitle.titleNo}">
						<div>
							<p class="headType">제일 평점이 높은 영상!</p>
							<h3 class="headTitle">${bestGradeTitle.title}</h3>
							<div class="headImgBox">
								<c:if test="${bestGradeTitle.poster == null}">
									<img alt="noImage" src="resources/img/noImage.jpg">
								</c:if>
								<c:if test="${bestGradeTitle.poster != null}">
									<img alt="${bestGradeTitle.title}" src="${bestGradeTitle.poster}">
								</c:if>
							</div>
						</div>
					</a>
				</li>
				<li>
					<a href="videoInfo.do?titleNo=${lastestTitle.titleNo}">
						<div>
							<p class="headType">최신 영상!</p>
							<h3 class="headTitle">${lastestTitle.title}</h3>
							<div class="headImgBox">
								<c:if test="${lastestTitle.poster == null}">
									<img alt="noImage" src="resources/img/noImage.jpg">
								</c:if>
								<c:if test="${lastestTitle.poster != null}">
									<img alt="${lastestTitle.title}" src="${lastestTitle.poster}">
								</c:if>
							</div>
						</div>
					</a>
				</li>
				<li>
					<a href="videoInfo.do?titleNo=${bestViewTitle.titleNo}">
						<div>
							<p class="headType">제일 많이 본 영상!</p>
							<h3 class="headTitle">${bestViewTitle.title}</h3>
							<div class="headImgBox">
								<c:if test="${bestViewTitle.poster == null}">
									<img alt="noImage" src="resources/img/noImage.jpg">
								</c:if>
								<c:if test="${bestViewTitle.poster != null}">
									<img alt="${bestViewTitle.title}" src="${bestViewTitle.poster}">
								</c:if>
							</div>
						</div>
					</a>
				</li>
			</ul>
			<ul class="category clear">
				<li class="categoryAll on">
					전체
				</li>
				<li class="categoryMovie">
					영화
				</li>
				<li class="categoryTV">
					TV 프로그램
				</li>
			</ul>
			<ul class="selectContent">
				<li class="mainContent contentAll">
					<h2 class="mainIntro">최고 평점 5</h2>
					<ul class="bestGradeVideo videoList clear">
						<c:forEach var="bestGradeTitlesAll" items="${bestGradeTitleFiveAll}">
							<li>
								<a href="videoInfo.do?titleNo=${bestGradeTitlesAll.titleNo}">
									<h3 class="headTitle">${bestGradeTitlesAll.title}</h3>
									<c:if test="${bestGradeTitlesAll.poster == null}">
										<img alt="noImage" src="resources/img/noImage.jpg">
									</c:if>
									<c:if test="${bestGradeTitlesAll.poster != null}">
										<img alt="${bestGradeTitlesAll.title}" src="${bestGradeTitlesAll.poster}">
									</c:if>
								</a>
							</li>
						</c:forEach>
					</ul>
					<h2 class="mainIntro">최신 영상 5</h2>
					<ul class="newVideo videoList clear">
						<c:forEach var="lastestTitlesAll" items="${lastestTitleFiveAll}">
							<li>
								<a href="videoInfo.do?titleNo=${lastestTitlesAll.titleNo}">
									<h3 class="headTitle">${lastestTitlesAll.title}</h3>
									<c:if test="${lastestTitlesAll.poster == null}">
										<img alt="noImage" src="resources/img/noImage.jpg">
									</c:if>
									<c:if test="${lastestTitlesAll.poster != null}">
										<img alt="${lastestTitlesAll.title}" src="${lastestTitlesAll.poster}">
									</c:if>
								</a>
							</li>
						</c:forEach>
					</ul>
					
					<h2 class="mainIntro">많이 본 영상 5</h2>
					<ul class="bestViewVideo videoList clear">
						<c:forEach var="bestViewTitlesAll" items="${bestViewTitleFiveAll}">
							<li>
								<a href="videoInfo.do?titleNo=${bestViewTitlesAll.titleNo}">
									<h3 class="headTitle">${bestViewTitlesAll.title}</h3>
									<c:if test="${bestViewTitlesAll.poster == null}">
										<img alt="noImage" src="resources/img/noImage.jpg">
									</c:if>
									<c:if test="${bestViewTitlesAll.poster != null}">
										<img alt="${bestViewTitlesAll.title}" src="${bestViewTitlesAll.poster}">
									</c:if>
								</a>
							</li>
						</c:forEach>
					</ul>
					<c:if test="${user.favorite_genre1 != 0 }">
						<h2 class="mainIntro">${userGenre_0.itemName} 장르 영상 5</h2>
						<ul class="recommandVideo1 videoList clear">
							<c:forEach var="genreTitlesAll_0" items="${genreTitleFiveAll_0}">
								<li>
									<a href="videoInfo.do?titleNo=${genreTitlesAll_0.titleNo}">
										<h3 class="headTitle">${genreTitlesAll_0.title}</h3>
										<c:if test="${genreTitlesAll_0.poster == null}">
											<img alt="noImage" src="resources/img/noImage.jpg">
										</c:if>
										<c:if test="${genreTitlesAll_0.poster != null}">
											<img alt="${genreTitlesAll_0.title}" src="${genreTitlesAll_0.poster}">
										</c:if>
									</a>
								</li>
							</c:forEach>
						</ul>
					</c:if>
					<c:if test="${user.favorite_genre2 != 0 }">
						<h2 class="mainIntro">${userGenre_1.itemName} 장르 영상 5</h2>
						<ul class="recommandVideo2 videoList clear">
							<c:forEach var="genreTitlesAll_1" items="${genreTitleFiveAll_1}">
								<li>
									<a href="videoInfo.do?titleNo=${genreTitlesAll_1.titleNo}">
										<h3 class="headTitle">${genreTitlesAll_1.title}</h3>
										<c:if test="${genreTitlesAll_1.poster == null}">
											<img alt="noImage" src="resources/img/noImage.jpg">
										</c:if>
										<c:if test="${genreTitlesAll_1.poster != null}">
											<img alt="${genreTitlesAll_1.title}" src="${genreTitlesAll_1.poster}">
										</c:if>
									</a>
								</li>
							</c:forEach>
						</ul>
					</c:if>
					<c:if test="${user.favorite_genre3 != 0 }">
						<h2 class="mainIntro">${userGenre_2.itemName} 장르 영상 5</h2>
						<ul class="recommandVideo3 videoList clear">
							<c:forEach var="genreTitlesAll_2" items="${genreTitleFiveAll_2}">
								<li>
									<a href="videoInfo.do?titleNo=${genreTitlesAll_2.titleNo}">
										<h3 class="headTitle">${genreTitlesAll_2.title}</h3>
										<c:if test="${genreTitlesAll_2.poster == null}">
											<img alt="noImage" src="resources/img/noImage.jpg">
										</c:if>
										<c:if test="${genreTitlesAll_2.poster != null}">
											<img alt="${genreTitlesAll_2.title}" src="${genreTitlesAll_2.poster}">
										</c:if>
									</a>
								</li>
							</c:forEach>
						</ul>
					</c:if>
				</li>
				
				<!-- 영화만 표시 -->
				<li class="mainContent contentMovie">
					<h2 class="mainIntro">최고 평점 5</h2>
					<ul class="bestGradeVideo videoList clear">
						<c:forEach var="bestGradeTitlesMovie" items="${bestGradeTitleFiveMovie}">
							<li>
								<a href="videoInfo.do?titleNo=${bestGradeTitlesMovie.titleNo}">
									<h3 class="headTitle">${bestGradeTitlesMovie.title}</h3>
									<c:if test="${bestGradeTitlesMovie.poster == null}">
										<img alt="noImage" src="resources/img/noImage.jpg">
									</c:if>
									<c:if test="${bestGradeTitlesMovie.poster != null}">
										<img alt="${bestGradeTitlesMovie.title}" src="${bestGradeTitlesMovie.poster}">
									</c:if>
								</a>
							</li>
						</c:forEach>
					</ul>
					<h2 class="mainIntro">최신 영상 5</h2>
					<ul class="newVideo videoList clear">
						<c:forEach var="lastestTitlesMovie" items="${lastestTitleFiveMovie}">
							<li>
								<a href="videoInfo.do?titleNo=${lastestTitlesMovie.titleNo}">
									<h3 class="headTitle">${lastestTitlesMovie.title}</h3>
									<c:if test="${lastestTitlesMovie.poster == null}">
										<img alt="noImage" src="resources/img/noImage.jpg">
									</c:if>
									<c:if test="${lastestTitlesMovie.poster != null}">
										<img alt="${lastestTitlesMovie.title}" src="${lastestTitlesMovie.poster}">
									</c:if>
								</a>
							</li>
						</c:forEach>
					</ul>
					
					<h2 class="mainIntro">많이 본 영상 5</h2>
					<ul class="bestViewVideo videoList clear">
						<c:forEach var="bestViewTitlesMovie" items="${bestViewTitleFiveMovie}">
							<li>
								<a href="videoInfo.do?titleNo=${bestViewTitlesMovie.titleNo}">
									<h3 class="headTitle">${bestViewTitlesMovie.title}</h3>
									<c:if test="${bestViewTitlesMovie.poster == null}">
										<img alt="noImage" src="resources/img/noImage.jpg">
									</c:if>
									<c:if test="${bestViewTitlesMovie.poster != null}">
										<img alt="${bestViewTitlesMovie.title}" src="${bestViewTitlesMovie.poster}">
									</c:if>
								</a>
							</li>
						</c:forEach>
					</ul>
					<c:if test="${user.favorite_genre1 != 0 }">
						<h2 class="mainIntro">${userGenre_0.itemName} 장르 영상 5</h2>
						<ul class="recommandVideo1 videoList clear">
							<c:forEach var="genreTitlesMovie_0" items="${genreTitleFiveMovie_0}">
								<li>
									<a href="videoInfo.do?titleNo=${genreTitlesMovie_0.titleNo}">
										<h3 class="headTitle">${genreTitlesMovie_0.title}</h3>
										<c:if test="${genreTitlesMovie_0.poster == null}">
											<img alt="noImage" src="resources/img/noImage.jpg">
										</c:if>
										<c:if test="${genreTitlesMovie_0.poster != null}">
											<img alt="${genreTitlesMovie_0.title}" src="${genreTitlesMovie_0.poster}">
										</c:if>
									</a>
								</li>
							</c:forEach>
						</ul>
					</c:if>
					<c:if test="${user.favorite_genre2 != 0 }">
						<h2 class="mainIntro">${userGenre_1.itemName} 장르 영상 5</h2>
						<ul class="recommandVideo2 videoList clear">
							<c:forEach var="genreTitlesMovie_1" items="${genreTitleFiveMovie_1}">
								<li>
									<a href="videoInfo.do?titleNo=${genreTitlesMovie_1.titleNo}">
										<h3 class="headTitle">${genreTitlesMovie_1.title}</h3>
										<c:if test="${genreTitlesMovie_1.poster == null}">
											<img alt="noImage" src="resources/img/noImage.jpg">
										</c:if>
										<c:if test="${genreTitlesMovie_1.poster != null}">
											<img alt="${genreTitlesMovie_1.title}" src="${genreTitlesMovie_1.poster}">
										</c:if>
									</a>
								</li>
							</c:forEach>
						</ul>
					</c:if>
					<c:if test="${user.favorite_genre3 != 0 }">
						<h2 class="mainIntro">${userGenre_2.itemName} 장르 영상 5</h2>
						<ul class="recommandVideo3 videoList clear">
							<c:forEach var="genreTitlesMovie_2" items="${genreTitleFiveMovie_2}">
								<li>
									<a href="videoInfo.do?titleNo=${genreTitlesMovie_2.titleNo}">
										<h3 class="headTitle">${genreTitlesMovie_2.title}</h3>
										<c:if test="${genreTitlesMovie_2.poster == null}">
											<img alt="noImage" src="resources/img/noImage.jpg">
										</c:if>
										<c:if test="${genreTitlesMovie_2.poster != null}">
											<img alt="${genreTitlesMovie_2.title}" src="${genreTitlesMovie_2.poster}">
										</c:if>
									</a>
								</li>
							</c:forEach>
						</ul>
					</c:if>
				</li>
				
				<!-- TV만 표시 -->
				<li class="mainContent contentTV">
					<h2 class="mainIntro">최고 평점 5</h2>
					<ul class="bestGradeVideo videoList clear">
						<c:forEach var="bestGradeTitlesTV" items="${bestGradeTitleFiveTV}">
							<li>
								<a href="videoInfo.do?titleNo=${bestGradeTitlesTV.titleNo}">
									<h3 class="headTitle">${bestGradeTitlesTV.title}</h3>
									<c:if test="${bestGradeTitlesTV.poster == null}">
										<img alt="noImage" src="resources/img/noImage.jpg">
									</c:if>
									<c:if test="${bestGradeTitlesTV.poster != null}">
										<img alt="${bestGradeTitlesTV.title}" src="${bestGradeTitlesTV.poster}">
									</c:if>
								</a>
							</li>
						</c:forEach>
					</ul>
					<h2 class="mainIntro">최신 영상 5</h2>
					<ul class="newVideo videoList clear">
						<c:forEach var="lastestTitlesTV" items="${lastestTitleFiveTV}">
							<li>
								<a href="videoInfo.do?titleNo=${lastestTitlesTV.titleNo}">
									<h3 class="headTitle">${lastestTitlesTV.title}</h3>
									<c:if test="${lastestTitlesTV.poster == null}">
										<img alt="noImage" src="resources/img/noImage.jpg">
									</c:if>
									<c:if test="${lastestTitlesTV.poster != null}">
										<img alt="${lastestTitlesTV.title}" src="${lastestTitlesTV.poster}">
									</c:if>
								</a>
							</li>
						</c:forEach>
					</ul>
					
					<h2 class="mainIntro">많이 본 영상 5</h2>
					<ul class="bestViewVideo videoList clear">
						<c:forEach var="bestViewTitlesTV" items="${bestViewTitleFiveTV}">
							<li>
								<a href="videoInfo.do?titleNo=${bestViewTitlesTV.titleNo}">
									<h3 class="headTitle">${bestViewTitlesTV.title}</h3>
									<c:if test="${bestViewTitlesTV.poster == null}">
										<img alt="noImage" src="resources/img/noImage.jpg">
									</c:if>
									<c:if test="${bestViewTitlesTV.poster != null}">
										<img alt="${bestViewTitlesTV.title}" src="${bestViewTitlesTV.poster}">
									</c:if>
								</a>
							</li>
						</c:forEach>
					</ul>
					<c:if test="${user.favorite_genre1 != 0 }">
						<h2 class="mainIntro">${userGenre_0.itemName} 장르 영상 5</h2>
						<ul class="recommandVideo1 videoList clear">
							<c:forEach var="genreTitlesTV_0" items="${genreTitleFiveTV_0}">
								<li>
									<a href="videoInfo.do?titleNo=${genreTitlesTV_0.titleNo}">
										<h3 class="headTitle">${genreTitlesTV_0.title}</h3>
										<c:if test="${genreTitlesTV_0.poster == null}">
											<img alt="noImage" src="resources/img/noImage.jpg">
										</c:if>
										<c:if test="${genreTitlesTV_0.poster != null}">
											<img alt="${genreTitlesTV_0.title}" src="${genreTitlesTV_0.poster}">
										</c:if>
									</a>
								</li>
							</c:forEach>
						</ul>
					</c:if>
					<c:if test="${user.favorite_genre2 != 0 }">
						<h2 class="mainIntro">${userGenre_1.itemName} 장르 영상 5</h2>
						<ul class="recommandVideo2 videoList clear">
							<c:forEach var="genreTitlesTV_1" items="${genreTitleFiveTV_1}">
								<li>
									<a href="videoInfo.do?titleNo=${genreTitlesTV_1.titleNo}">
										<h3 class="headTitle">${genreTitlesTV_1.title}</h3>
										<c:if test="${genreTitlesTV_1.poster == null}">
											<img alt="noImage" src="resources/img/noImage.jpg">
										</c:if>
										<c:if test="${genreTitlesTV_1.poster != null}">
											<img alt="${genreTitlesTV_1.title}" src="${genreTitlesTV_1.poster}">
										</c:if>
									</a>
								</li>
							</c:forEach>
						</ul>
					</c:if>
					<c:if test="${user.favorite_genre3 != 0 }">
						<h2 class="mainIntro">${userGenre_2.itemName} 장르 영상 5</h2>
						<ul class="recommandVideo3 videoList clear">
							<c:forEach var="genreTitlesTV_2" items="${genreTitleFiveTV_2}">
								<li>
									<a href="videoInfo.do?titleNo=${genreTitlesTV_2.titleNo}">
										<h3 class="headTitle">${genreTitlesTV_2.title}</h3>
										<c:if test="${genreTitlesTV_2.poster == null}">
											<img alt="noImage" src="resources/img/noImage.jpg">
										</c:if>
										<c:if test="${genreTitlesTV_2.poster != null}">
											<img alt="${genreTitlesTV_2.title}" src="${genreTitlesTV_2.poster}">
										</c:if>
									</a>
								</li>
							</c:forEach>
						</ul>
					</c:if>
				</li>
			</ul>
			
		</main>	
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>	
	</div>
</body>
</html>