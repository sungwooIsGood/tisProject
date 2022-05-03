<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/headerManager.css">
	<link rel="stylesheet" href="resources/css/footer.css">
	<link rel="stylesheet" href="resources/css/getVideo.css"> 
	<script src="resources/script/jquery.min.js"></script>
	<script src="resources/script/footer.js" defer></script>
<meta charset="UTF-8">
<title>왓챠</title>
</head>
<body>
	
	<div id="wrap">
	<%@ include file="/WEB-INF/views/includes/headerManager.jsp" %>
		<h1>영상 관리 - 영상 상세보기</h1>
		<main>
			<div class="getVideo">
				<div class="titleBox clear getVideoRow">
					<h3 class="left">타이틀 제목</h3>
					<p class="right" id="title">${title.title }</p>
				</div>
				<div class="videoNoBox clear getVideoRow">
					<h3 class="left">번호</h3>
					<p class="right" id="videoNo">${video.videoNo }</p>
				</div>
				<div class="videoTitleBox clear getVideoRow">
					<h3 class="left">영상 제목</h3>
					<p class="right" id="videoTitle">${video.videoTitle }</p>
				</div>
				<div class="videoEpisodeNoBox clear getVideoRow">
					<h3 class="left">영상 에피소드 번호</h3>
					<p class="right" id="videoEpisodeNo">${video.videoEpisodeNo }화</p>
				</div>
				<div class="videoWatchTimeBox clear getVideoRow">
					<h3 class="left">영상 재생시간</h3>
					<p class="right" id="videoWatchTime">${video.videoWatchTimeMin }분 ${video.videoWatchTimeSec }초</p>
				</div>
				<div class="videoThumbnailBox clear getVideoRow">
					<h3 class="left">영상 썸네일</h3>
					<div class="right" id="videoThumbnail">
						<c:if test="${video.videoThumbnail == null}">
							<img alt="noImage" src="resources/img/noImage.jpg">
						</c:if>
						<c:if test="${video.videoThumbnail != null}">
							<img alt="${video.videoTitle}" src="${video.videoThumbnail}">
						</c:if>
					</div>
				</div>
				<div class="videoBox clear getVideoRow">
					<h3 class="left">영상</h3>
					<video src="${video.video }" controls class="right" id="video"></video>
				</div>
				<div class="linkBox getVideoRow">
					<a href="updateVideo.do?videoNo=${video.videoNo }">수정하기</a>
					&nbsp;
					<a href="getVideoList.do?titleNo=${title.titleNo}">영상 목록</a>
					&nbsp;
					<a href="deleteVideo.do?videoNo=${video.videoNo }">삭제하기</a>
				</div>
			</div>
		</main>
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
	</div>
</body>
</html>