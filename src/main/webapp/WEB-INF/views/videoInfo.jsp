<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/header.css">
	<link rel="stylesheet" href="resources/css/footer.css">
	<link rel="stylesheet" href="resources/css/videoInfo.css">
	<script src="resources/script/jquery.min.js"></script>
	<script src="resources/script/footer.js" defer></script>
    <script src="resources/script/videoInfo.js" defer></script>
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
			<div class="backImgBox">	
				<h1>${title.title}</h1>
				<input type="hidden" id="titleNo" value="${title.titleNo}">
				<input type="hidden" id="userNo" value="${user.id}">
				<input type="hidden" id="userGrade" value="${grade.grade }">
				<input type="hidden" id="backImg" value="${title.backImg }">
				<!-- 신동인 결제유저 검사 추가 -->
				<input type="hidden" id="rank" value="${rank }">
				<div class="headBox clear">
					<div class="avgGradeBox clear">
						<p class="avgGradeLeft">평균 별점</p>
						<p class="avgGradeRight">
							<c:choose>
								<c:when test="${titleAvg == null }">
									0
								</c:when>
								<c:otherwise>
									${titleAvg}
								</c:otherwise>
							</c:choose>		
						<p>
					</div>
					<div class="ageEpisode">
						<p>
							<c:choose>
								<c:when test="${title.age == 0}">
									전체 이용가
								</c:when>
								<c:otherwise>
									${title.age}세 이상 이용가
								</c:otherwise>
							</c:choose>
							· 에피소드 
							<c:choose>
								<c:when test="${videoCount == null}">
									0
								</c:when>
								<c:otherwise>
									${videoCount}
								</c:otherwise>
							</c:choose>
							개
						</p>
					</div>
				</div>
				<div class="infoBox selectBox">	
					<p class="synopsis">
						 ${title.synopsis}
					</p>
					<ul class="summary">
						<li>
							<span class="summaryLeft">감독</span>
							<span class="director">${title.director}</span>
						</li>
						<li>
							<span class="summaryLeft">출연</span>
							<span class="actor">${title.actor}</span>
						</li>
						<li>
							<span class="summaryLeft">개요</span>
							<c:forEach var="genreItem" items="${genreItemList}" varStatus="i">
								<span class="genre">
									<a href="result.do?itemNo=${genreItem.itemNo}">
										${genreItem.itemName}
									</a>
								</span>
								<c:if test="${!i.last}">
								·
								</c:if>
							</c:forEach>
							&nbsp;|&nbsp;
							<span class="nation">
								<a href="result.do?itemNo=${nationItemList[0].itemNo}">
									${nationItemList[0].itemName}
								</a>
							</span>
							&nbsp;|&nbsp;
							<span class="releseDate">${title.releaseDate }</span>
						</li>
					</ul>
					<div class="playBox clear">
					 	<div class="play">
					 		<a href="videoShow.do?videoNo=${videoList[0].videoNo }">재생</a>
					 	</div>
						<div class="mylist">
							<button class="myListBtn">+보고싶어요</button>
						</div>
						<div class="shareBox">
							<button class="shareBtn">공유하기</button>
						</div>
					</div>
					<div class="setGradeBox clear">
						<div class="setGradeWordBox">
							<span class="setGradeWord">
								이미 본 작품인가요?
							</span>
						</div>
						<div class="starBoxOut">
							<div class="starBoxIn">
								<div class="emptyStar">
									☆☆☆☆☆
								</div>
								<div class="fullStar">
									★★★★★
								</div>						
							</div>
						</div>
					</div>
				</div>
				<div class="episodeBox selectBox">
					<div class="slideBox">
						<ul class="episodeList clear">
							<c:forEach var="video" items="${videoList}">
								<li>
									<div class="thumbImgBox">
										<a href="videoShow.do?videoNo=${video.videoNo }">
											<c:if test="${video.videoThumbnail == null}">
												<img alt="noImage" src="resources/img/noImage.jpg">
											</c:if>
											<c:if test="${video.videoThumbnail != null}">
												<img alt="${video.videoTitle}" src="${video.videoThumbnail}">
											</c:if>
										</a>
									</div>
									<div class="thumbInfo">
										<div class="thumbNo">에피소드 ${video.videoEpisodeNo}</div>
										<div class="thumbMinute">${video.videoWatchTimeMin}분 ${video.videoWatchTimeSec}초</div>
										<div class="thumbTitle">${video.videoTitle}</div>
									</div>
								</li>
							</c:forEach>	
						</ul>
						<div class="slidePrev">
							Prev
						</div>
						<div class="slideNext">
							Next
						</div>
					</div>
				</div>
				<c:if test="${title.series == 84}">
					<div class="buttonListBox">
						<ul class="buttonList clear">
							<li class="infoBoxBtn on">기본정보</li>
							<li class="episodeBoxBtn">에피소드</li>
						</ul>
					</div>
				</c:if>
			</div>
		</main>
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>		
	</div>
</body>
</html>