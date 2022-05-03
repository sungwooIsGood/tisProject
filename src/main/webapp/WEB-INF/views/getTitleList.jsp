<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/headerManager.css">
	<link rel="stylesheet" href="resources/css/footer.css">
	<link rel="stylesheet" href="resources/css/getTitleList.css"> 
	<script src="resources/script/jquery.min.js"></script>
	<script src="resources/script/footer.js" defer></script>
<meta charset="UTF-8">
<title>왓챠</title>
</head>
<body>
	
	<div id="wrap">
		<%@ include file="/WEB-INF/views/includes/headerManager.jsp" %>
		<h1>타이틀 관리 - 타이틀 목록</h1>
		<main>
			<div class="titleList">	
				<div class="titleListBox">
					<div class="titleListRow clear">
						<p class="titleListHead titleNo">번호</p>
						<p class="titleListHead title">제목</p>
						<p class="titleListHead director">감독</p>
						<p class="titleListHead actor">배우</p>
						<p class="titleListHead releaseDate">개봉일자</p>
						<p class="titleListHead age">연령제한</p>
					</div>
					<c:forEach var="title" items="${titleList}">
					<div class="titleListRow titleListValue">
						<a class="titleListLink clear" href="getTitle.do?titleNo=${title.titleNo }">
							<p class="titleNo">${title.titleNo }</p>
							<p class="title">${title.title }</p>
							<p class="director">${title.director }</p>
							<p class="actor">${title.actor }</p>
							<p class="releaseDate">${title.releaseDate }</p>
							<p class="age">
								<c:choose>
									<c:when test="${title.age == 0}">
										전체이용가
									</c:when>
									<c:when test="${title.age == 18}">
										청소년 이용불가
									</c:when>
									<c:otherwise>
										${title.age }세 이상 이용가
									</c:otherwise>
								</c:choose>
							</p>
						</a>
					</div>
					</c:forEach>
				</div>
				<div class="insertTitleBox clear">
					<a class="insertTitle" href="insertTitle.do">타이틀 등록</a>
				</div>
				<div class="pageBox">
					<c:if test="${startPage > PAGE_STEP}">
						<a class="pageArrow" href="getTitleList.do?page=${startPage - PAGE_STEP}">◀</a>
					</c:if>	
					<c:forEach begin="${startPage}" end="${endPage}" varStatus="status">						
						<c:choose>
							<c:when test="${status.current == currentPage}">
								<span class="pageNumber">${status.current}</span>						
							</c:when>
							<c:otherwise>
								<a class="pageNumber" href="getTitleList.do?page=${status.current}&keywordSearch=${keywordSearch}&inputSearch=${inputSearch}">${status.current}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${startPage + PAGE_STEP <= totalPage}">
						<a class="pageArrow" href="getTitleList.do?page=${startPage + PAGE_STEP }">▶</a>
					</c:if>
				</div>
				<div class="inputBox">
					<form action="getTitleList.do" method="get">
						<select name="keywordSearch" id="keywordSearch">
							<option value="T">제목</option>
							<option value="D">감독</option>
							<option value="A">출연</option>
						</select>
						<input type="text" name="inputSearch" id="inputSearch">
						<input type="submit" value="검색" id="submit">
					</form>
				</div>
			</div>
		</main>
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
	</div>
</body>
</html>