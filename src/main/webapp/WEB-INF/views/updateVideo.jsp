<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/headerManager.css">
	<link rel="stylesheet" href="resources/css/footer.css">
	<link rel="stylesheet" href="resources/css/updateVideo.css">
	<script src="resources/script/jquery.min.js"></script>
	<script src="resources/script/footer.js" defer></script>
	<script src="resources/script/videoValidation.js" defer></script>
	
	<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.9/css/select2.min.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.9/js/select2.min.js"></script>

<title>왓챠</title>
</head>
<body>
	
	<div id="wrap">
	<%@ include file="/WEB-INF/views/includes/headerManager.jsp" %>
		<main>
			<h1>
			    <a href="#">관리자 페이지 - 영상 수정</a>
			</h1>
			<br>
			<form id="videoForm" name="videoForm" action="updateVideoOk.do"
			method="post" encType="multipart/form-data">
				<input type="hidden" name="videoNo" value="${video.videoNo}" id="videoNo"/>
				<div class="updateVideo">
					<div class="titleNoBox clear updateVideoRow">
						<h3 class="left">타이틀</h3>
						<select name="titleNo" class="searchSelect" id="titleNo" class="right">
							<c:forEach var="titles" items="${titleList}">
								<c:if test="${titles.titleNo == title.titleNo}">
									<option value="${titles.titleNo }" selected>${titles.title }</option>
								</c:if>
								<c:if test="${titles.titleNo != title.titleNo}">
									<option value="${titles.titleNo }">${titles.title }</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div class="videoTitleBox clear updateVideoRow">
						<h3 class="left">에피소드 이름</h3>
						<input type="text" name="videoTitle" id="videoTitle"
						value="${video.videoTitle}" class="right"/>
					</div>
					<div class="videoEpisodeNoBox clear updateVideoRow">
						<h3 class="left">에피소드 화수</h3>
						<input type="text" name="videoEpisodeNo" id="videoEpisodeNo" class="right"
						value="${video.videoEpisodeNo}">
						<button type="button" id="episodeNoCheckButton" class="right">중복체크</button>
						<input type="hidden" name="episodeNoCheck" id="episodeNoCheck" value="0">
					</div>
					<div class="videoThumbnailBox clear updateVideoRow">
						<h3 class="left">동영상 섬네일</h3>
						<div class="right" id="videoThumbnail">
							<input type="file" name="videoThumbnailFile" accept="image/*" id="videoThumbnailFile">
							<c:if test="${video.videoThumbnail != null }">
								<p>기존경로 : ${video.videoThumbnail }</p>
							</c:if>
							<c:if test="${video.videoThumbnail == null }">
								<p>기존 동영상 썸네일 이미지 파일이 없습니다</p>
							</c:if>
						</div>
					</div>
					<div class="videoBox clear updateVideoRow">
						<h3 class="left">동영상</h3>
						<div class="right" id="video">
							<input type="file" name="videoFile" accept="video/*" id="videoFile">
							<c:if test="${video.video != null }">
								<p>기존경로 : ${video.video }</p>
							</c:if>
							<c:if test="${video.video == null }">
								<p>기존 동영상 파일이 없습니다</p>
							</c:if>
						</div>
					</div>
					<div class="submitBox clear updateVideoRow">
						<input type="submit" value="등록" id="submit">
						<a href="getVideo.do?videoNo=${video.videoNo}" class="cancel">취소</a>
					</div>
				</div>
			</form>
		</main>
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
	</div>
	<div class="loadingImageBackground">
		<img alt="loading" src="resources/img/loadingImage.gif">
	</div>
</body>
</html>