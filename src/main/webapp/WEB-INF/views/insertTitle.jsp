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
	<link rel="stylesheet" href="resources/css/insertTitle.css">
	<script src="resources/script/jquery.min.js"></script>
	<script src="resources/script/footer.js" defer></script>
	<script src="resources/script/titleValidation.js" defer></script>
<title>왓챠</title>
</head>
<body>
	
	<div id = "wrap">
	<%@ include file="/WEB-INF/views/includes/headerManager.jsp" %>
		<main>
			<h1>
			    <a href="#">관리자 페이지 - 영상 타이틀 등록</a>
			</h1>
			<br>
			<form id="titleForm" name="titleForm" action="insertTitleOk.do"
			method="post" encType="multipart/form-data">
				<div class="insertTitle">
				    <div class="titleBox clear insertTitleRow">
				        <h3 class="left">제목</h3>
				        <input type="text" name="title" id="title" class="right"/>
				    </div>
				    <div class="synopsisBox clear insertTitleRow">
				        <h3 class="left">시놉시스</h3>
				        <textarea name="synopsis" id="synopsis" class="right"></textarea>
				    </div>
				    <div class="directorBox clear insertTitleRow">
				        <h3 class="left">감독</h3>
				        <input type="text" name="director" id="director" class="right"/>
				    </div>
				    <div class="actorBox clear insertTitleRow">
				        <h3 class="left">출연</h3>
				        <input type="text" name="actor" id="actor" class="right"/>
				    </div>
				    <div class="releaseDateBox clear insertTitleRow">
				        <h3 class="left">개봉일</h3>
				        <input type="date" min="1900-01-01" name="releaseDate" id="releaseDate" class="right"/>
				    </div>
				    <div class="ageBox clear insertTitleRow" >
				        <h3 class="left">시청연령</h3>
				        <div class="right clear">
				        	<div class="ageValue">
					        	<label>
									<input type="radio" name="age" value="0" class="age">
									연령 제한 없음
								</label>
							</div>
							<div class="ageValue">
								<label>
									<input type="radio" name="age" value="12" class="age">
									12세 제한
								</label>
							</div>
							<div class="ageValue">
								<label>
									<input type="radio" name="age" value="15" class="age">
									15세 제한
								</label>
							</div>
							<div class="ageValue">
								<label>
									<input type="radio" name="age" value="18" class="age">
									청소년 시청불가
								</label>
							</div>
						</div>
					</div>
					<div class="seriesBox clear insertTitleRow">
						<h3 class="left">TV, 영화 구분</h3>
						<div class="right clear">
							<div class="seriesValue">
								<label>
									<input type="radio" name="series" value="T" class="series">
									TV
								</label>
							</div>
							<div class="seriesValue">
								<label>
									<input type="radio" name="series" value="M" class="series">
									영화
								</label>
							</div>
						</div>
					</div>
					<div class="genreBox clear insertTitleRow">
						<h3 class="left">장르</h3>
						<div class="right clear">
							<c:forEach var="genre" items="${genreItemList}">
								<div class="genreValue">
									<label>
										<input type="checkbox" name="genre" value="${genre.itemNo}" class="genre">
										${genre.itemName}
									</label>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="nationBox clear insertTitleRow">
						<h3 class="left">국가</h3>
						<div class="right clear">
							<c:forEach var="nation" items="${nationItemList}">
								<div class="nationValue">
									<label>
										<input type="radio" name="nation" value="${nation.itemNo}" class="nation">
										${nation.itemName}
									</label>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="pointBox clear insertTitleRow">
						<h3 class="left">특징</h3>
						<div class="right clear">
							<c:forEach var="point" items="${pointItemList}">
								<div class="pointValue">
									<label>
										<input type="checkbox" name="point" value="${point.itemNo}" class="point">
										${point.itemName}
									</label>
								</div>
							</c:forEach>
						</div>
					</div>	
					<div class="posterBox clear insertTitleRow">
						<h3 class="left">포스터 이미지</h3>
						<div class="right">
							<input type="file" name="posterFile" accept="image/*" id="posterFile">
						</div>
					</div>
					<div class="backImgBox clear insertTitleRow">
						<h3 class="left">배경 이미지</h3>
						<div class="right">
							<input type="file" name="backImgFile" accept="image/*" id="backImgFile">
						</div>
					</div>
					<div class="submitBox clear insertTitleRows">
						<input type="submit" value="등록" id="submit">
						<a href="admin.do" class="cancel">취소</a>	
					</div>
				</div>
			</form>
		</main>
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
	</div>
</body>
</html>