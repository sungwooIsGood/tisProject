<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/videoShow.css">
	<script src="resources/script/jquery.min.js"></script>
    <script src="resources/script/videoShow.js" defer></script>
<meta charset="UTF-8">
<title>왓챠</title>
</head>
<body>
	<div class="wrap">
		<div class="menubar">
			<div class="menubarHead clear">
				<h1>${title.title }</h1>
				<button class="menubarClose">X</button>
			</div>
			<div class="menubarVideoCount clear">
				<p>
					<c:choose>
						<c:when test="${videoCount == null}">
							0
						</c:when>
						<c:otherwise>
							${videoCount}
						</c:otherwise>
					</c:choose>
					개 에피소드
				</p>
			</div>
			<div class="menubarBody">
				<ul class="menubarVideoList">
					<c:forEach var="videos" items="${videoList}">
						<li>
							<div class="clearBox clear">
								<div class="videoListImgBox">
									<a href="videoShow.do?videoNo=${videos.videoNo}">
										<c:if test="${videos.videoThumbnail == null}">
												<img alt="noImage" src="resources/img/noImage.jpg">
											</c:if>
											<c:if test="${videos.videoThumbnail != null}">
												<img alt="${videos.videoTitle}" src="${videos.videoThumbnail}">
											</c:if>
									</a>
								</div>
								<div class="videoListText">
									<h3 class="videoListTitle">에피소드 ${videos.videoEpisodeNo} 화</h3>
									<p class="videoListMinute">
										${videos.videoWatchTimeMin}분 ${videos.videoWatchTimeSec}초
									</p>
								</div>
							</div>	
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="videoHead clear">
			<button class="openList">List</button>
			<div class="videoTextBox">
				<h1 class="videoTitle">에피소드 ${video.videoEpisodeNo}</h1>
				<p class="videoText">${video.videoTitle}</p>
			</div>
			<a href="home.do" class="stopVideo">X</a>
		</div>
		<div class="video">
			<video src="${video.video}" controls autoplay>
			
			</video>
		</div>
		<div class="videoControlBtn clear">
			<c:if test="${prevVideo != null}">
				<a href="videoShow.do?videoNo=${prevVideo.videoNo}" class="prevVideo">
					이전화
				</a>
			</c:if>
			<c:if test="${nextVideo != null}">
				<a href="videoShow.do?videoNo=${nextVideo.videoNo}" class="nextVideo">
					다음화
				</a>
			</c:if>
		</div>
	</div>
</body>
</html>