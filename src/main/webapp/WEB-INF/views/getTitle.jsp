<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/headerManager.css">
	<link rel="stylesheet" href="resources/css/footer.css">
	<link rel="stylesheet" href="resources/css/getTitle.css"> 
	<script src="resources/script/jquery.min.js"></script>
	<script src="resources/script/footer.js" defer></script>
<meta charset="UTF-8">
<title>왓챠</title>
</head>
<body>
	
	<div id="wrap">
	<%@ include file="/WEB-INF/views/includes/headerManager.jsp" %>
		<h1>타이틀 관리 - 타이틀 상세보기</h1>
		<main>
			<div class="getTitle">
				<div class="titleNoBox clear getTitleRow">
					<h3 class="left">번호</h3>
					<p class="right" id="titleNo">${title.titleNo }</p>
				</div>
				<div class="titleBox clear getTitleRow">
					<h3 class="left">제목</h3>
					<p class="right" id="title">${title.title }</p>
				</div>
				<div class="synopsisBox clear getTitleRow">
		        	<h3 class="left">시놉시스</h3>
					<p class="right" id="synopsis">${title.synopsis }</p>
				</div>
				<div class="directorBox clear getTitleRow">
			        <h3 class="left">감독</h3>
					<p class="right" id="director">${title.director }</p>
				</div>
				<div class="actorBox clear getTitleRow">
					<h3 class="left">출연</h3>
					<p class="right" id="actor">${title.actor }</p>
				</div>
				<div class="releaseDateBox clear getTitleRow">
					<h3 class="left">개봉일</h3>
					<p class="right" id="releaseDate">${title.releaseDate }</p>
				</div>
				<div class="ageBox clear getTitleRow" >
			        <h3 class="left">시청연령</h3>
					<p class="right" id="age">
						<c:choose>
							<c:when test="${title.age  == 0}">
								전체 이용가
							</c:when>
							<c:when test="${title.age  == 18}">
								청소년 시청불가
							</c:when>
							<c:otherwise>
								${title.age }세 이용가
							</c:otherwise>
						</c:choose>
					</p>
				</div>
				<div class="genreBox clear getTitleRow">
					<h3 class="left">장르</h3>
					<p class="right" id="genre">
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
					</p>
				</div>
				<div class="nationBox clear getTitleRow">
					<h3 class="left">국가</h3>
					<p class="right" id="nation">
						<c:forEach var="nationItem" items="${nationItemList}" varStatus="i">
							<span class="nation">
								<a href="result.do?itemNo=${nationItem.itemNo}">
									${nationItem.itemName}
								</a>
							</span>
							<c:if test="${!i.last}">
							·
							</c:if>
						</c:forEach>
					</p>
				</div>
				<div class="pointBox clear getTitleRow">
					<h3 class="left">특징</h3>
					<p class="right" id="point">
						<c:forEach var="pointItem" items="${pointItemList}" varStatus="i">
							<span class="point">
								<a href="result.do?itemNo=${pointItem.itemNo}">
									${pointItem.itemName}
								</a>
							</span>
							<c:if test="${!i.last}">
							·
							</c:if>
						</c:forEach>
					</p>
				</div>
				<div class="seriesBox clear getTitleRow">
					<h3 class="left">TV, 영화 구분</h3>
					<p class="right" id="series">
						<c:choose>
							<c:when test="${title.series == 84 }">
								TV 프로그램
							</c:when>
							<c:when test="${title.series == 77 }">
								영화
							</c:when>
						</c:choose>
					</p>
				</div>
				<div class="gradeBox clear getTitleRow">
					<h3 class="left">평균 평점</h3>
					<p class="right" id="grade">${titleAvg }</p>
				</div>
				<div class="viewBox clear getTitleRow">
					<h3 class="left">조회 유저 수</h3>
					<p class="right" id="view">${viewListCountByTitle} 명</p>
				</div>
				<div class="getVideoBox clear getTitleRow">
					<h3 class="left">총 영상 갯수</h3>
					<p class="left" id="getVideo">${videoCount}개</p>
					<p class="getVideoList right">
						<a href="getVideoList.do?titleNo=${title.titleNo}">해당 영상목록 조회</a>
					</p>
				</div>
				<div class="posterBox clear getTitleRow">	
					<h3 class="left">포스터</h3>
					<div class="right" id="poster">
						<c:if test="${title.poster == null}">
							<img alt="noImage" src="resources/img/noImage.jpg">
						</c:if>
						<c:if test="${title.poster != null}">
							<img alt="${title.title}" src="${title.poster}">
						</c:if>
					</div>
				</div>
				<div class="backImgBox clear getTitleRow">
					<h3 class="left">배경이미지</h3>
					<div class="right" id="backImg">
						<c:if test="${title.backImg == null}">
							<img alt="noImage" src="resources/img/noImage.jpg">
						</c:if>
						<c:if test="${title.backImg != null}">
							<img alt="${title.title}" src="${title.backImg}">
						</c:if>
					</div>
				</div>
				<div class="linkBox getTitleRow">
					<a href="updateTitle.do?titleNo=${title.titleNo }">수정하기</a>
					&nbsp;
					<a href="getTitleList.do">타이틀 목록</a>
					&nbsp;
					<a href="deleteTitle.do?titleNo=${title.titleNo }">삭제하기</a>
				</div>
			</div>
		</main>
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
	</div>
</body>
</html>