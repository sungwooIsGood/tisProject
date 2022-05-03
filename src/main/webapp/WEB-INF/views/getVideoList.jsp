<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/headerManager.css">
	<link rel="stylesheet" href="resources/css/footer.css">
	<link rel="stylesheet" href="resources/css/getVideoList.css"> 
	<script src="resources/script/jquery.min.js"></script>
	<script src="resources/script/footer.js" defer></script>
<meta charset="UTF-8">
<title>왓챠</title>
</head>
<body>
	
	<div id="wrap">
	<%@ include file="/WEB-INF/views/includes/headerManager.jsp" %>
		<h1>영상 관리 - 영상 목록 (${title.title})</h1>
		<main>
			<div class="videoList">
				<div class="videoListRow clear">
					<p class="videoListHead videoNo">번호</p>
					<p class="videoListHead videoTitle">영상 제목</p>
					<p class="videoListHead videoEpisodeNo">영상 에피소드 번호</p>
					<p class="videoListHead videoWatchTime">영상 시간</p>
				</div>
				<c:forEach var="video" items="${videoList}">
					<div class="videoListRow videoListValue">
						<a class="videoListLink clear" href="getVideo.do?videoNo=${video.videoNo }">
							<p class="videoNo">${video.videoNo }</p>
							<p class="videoTitle">${video.videoTitle }</p>
							<p class="videoEpisodeNo">${video.videoEpisodeNo }화</p>
							<p class="videoWatchTime">${video.videoWatchTimeMin }분 ${video.videoWatchTimeSec }초</p>
						</a>
					</div>
				</c:forEach>
				<div class="videoLinkBox clear">
					<a href="insertVideo.do?titleNo=${title.titleNo}" class="insertVideo">영상 등록</a>
					<a href="getTitle.do?titleNo=${title.titleNo}" class="getTitle">타이틀 정보</a>
				</div>
				<div class="pageBox">
					<c:if test="${startPage > PAGE_STEP}">
						<a href="getVideoList.do?page=${startPage - PAGE_STEP}&titleNo=${title.titleNo}" class="pageArrow">◀</a>				
					</c:if>		
					<c:forEach begin="${startPage}" end="${endPage}" varStatus="status">
						<c:choose>
							<c:when test="${status.current == currentPage}">
								<span class="pageNumber">${status.current}</span>			
							</c:when>
							<c:otherwise>
								<a href="getVideoList.do?page=${status.current}&titleNo=${title.titleNo}" class="pageNumber">${status.current}</a>	
							</c:otherwise>
						</c:choose>			
					</c:forEach>
					<c:if test="${startPage + PAGE_STEP <= totalPage}">
						<a href="getVideoList.do?page=${startPage + PAGE_STEP }&titleNo=${title.titleNo}" class="pageArrow">▶</a>
					</c:if>
				</div>
			</div>
		</main>
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
	</div>
</body>
</html>