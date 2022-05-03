<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/headerManager.css">
	<link rel="stylesheet" href="resources/css/footer.css">
	<link rel="stylesheet" href="resources/css/updateTitle.css">
	<script src="resources/script/jquery.min.js"></script>
	<script src="resources/script/footer.js" defer></script>
	<script src="resources/script/titleValidation.js" defer></script>
<meta charset="UTF-8">
<title>왓챠</title>
</head>
<body>
	
	<div id = "wrap">
	<%@ include file="/WEB-INF/views/includes/headerManager.jsp" %>
		<main>
			<h1>
			    <a href="#">관리자 페이지 - 영상 타이틀 수정</a>
			</h1>
			<br>
			<form id="titleForm" name="titleForm" action="updateTitleOk.do"
			method="post" encType="multipart/form-data">
			<input type="hidden" name="titleNo" value="${title.titleNo}">
				<div class="updateTitle">
				    <div class="titleBox clear updateTitleRow">
				        <h3 class="left">제목</h3>
				        	<input type="text" name="title" class="right"
				        	value="${title.title}" id="title"/>
				    </div>
				   <div class="synopsisBox clear updateTitleRow">
				        <h3 class="left">시놉시스</h3>
				        	<textarea name="synopsis" id="synopsis" class="right">${title.synopsis}</textarea>
				    </div>
				    <div class="directorBox clear updateTitleRow">
				        <h3 class="left">감독</h3>
				        	<input type="text" name="director" id="director"
				        	value="${title.director }" class="right"/>
				    </div>
					<div class="actorBox clear updateTitleRow">
				        <h3 class="left">출연</h3>
				        	<input type="text" name="actor" id="actor"
				        	value="${title.actor}" class="right"/>
				    </div>
					<div class="releaseDateBox clear updateTitleRow">
				        <h3 class="left">개봉일</h3>
				        <input type="date" min="1900-01-01" name="releaseDate"
				        value="${title.releaseDate}" id="releaseDate" class="right"/>
			        </div>
					<div class="ageBox clear updateTitleRow" >
				        <h3 class="left">시청연령</h3>
				        <div class="right clear">
				        	<div class="ageValue">
					       		<label>
				        			<c:if test="${title.age == 0}">
										<input type="radio" name="age" value="0" class="age" checked>
									</c:if>
									<c:if test="${title.age != 0}">
										<input type="radio" name="age" value="0" class="age">
									</c:if>
									연령 제한 없음
								</label>
							</div>
							<div class="ageValue">
								<label>
									<c:if test="${title.age == 12}">
										<input type="radio" name="age" value="12" class="age" checked>
									</c:if>
									<c:if test="${title.age != 12}">
										<input type="radio" name="age" value="12" class="age">
									</c:if>
									12세 제한
								</label>
							</div>
							<div class="ageValue">
								<label>
									<c:if test="${title.age == 15}">
										<input type="radio" name="age" value="15" class="age" checked>
									</c:if>
									<c:if test="${title.age != 15}">
										<input type="radio" name="age" value="15" class="age">
									</c:if>
									15세 제한
								</label>
							</div>
							<div class="ageValue">
								<label>
									<c:if test="${title.age == 18}">
										<input type="radio" name="age" value="18" class="age" checked>
									</c:if>
									<c:if test="${title.age != 18}">
										<input type="radio" name="age" value="18" class="age">
									</c:if>
									청소년 시청불가
								</label>
							</div>
						</div>
					</div>
					<div class="seriesBox clear updateTitleRow">
						<h3 class="left">TV, 영화 구분</h3>
						<div class="right clear">
							<div class="seriesValue">
								<label>
									<c:if test="${title.series ==  84}">
										<input type="radio" name="series" value="T" class="series" checked>
									</c:if>
									<c:if test="${title.series != 84}">
										<input type="radio" name="series" value="T" class="series">
									</c:if>
										TV
								</label>
							</div>
							<div class="seriesValue">
								<label>
									<c:if test="${title.series == 77}">
										<input type="radio" name="series" value="M" class="series" checked>
									</c:if>
									<c:if test="${title.series != 77}">
										<input type="radio" name="series" value="M" class="series">
									</c:if>
									영화
								</label>
							</div>
						</div>
					</div>
					<div class="genreBox clear updateTitleRow">
						<h3 class="left">장르</h3>
						<div class="right clear">
							<c:forEach var="genre" items="${genreItemList}">
								<c:forEach var="titleItem" items="${titleItemList}">
									<c:if test="${genre.itemNo == titleItem.itemNo}">
										<c:set var="titleItemChecked" value="checked" />
									</c:if>
								</c:forEach>
								<div class="genreValue">
									<label>
										<input type="checkbox" name="genre" class="genre"
										value="${genre.itemNo}" ${titleItemChecked}>
										${genre.itemName}
									</label>
								</div>
								<c:remove var="titleItemChecked" />
							</c:forEach>
						</div>
					</div>
					<div class="nationBox clear updateTitleRow">
						<h3 class="left">국가</h3>
						<div class="right clear">
							<c:forEach var="nation" items="${nationItemList}">
								<c:forEach var="titleItem" items="${titleItemList}">
									<c:if test="${nation.itemNo == titleItem.itemNo}">
										<c:set var="titleItemChecked" value="checked" />
									</c:if>
								</c:forEach>
									<div class="nationValue">
										<label>
											<input type="radio" name="nation" class="nation"
											value="${nation.itemNo}" ${titleItemChecked}>
											${nation.itemName}
										</label>
									</div>
									<c:remove var="titleItemChecked" />
							</c:forEach>
						</div>
					</div>
					<div class="pointBox clear updateTitleRow">
						<h3 class="left">특징</h3>
						<div class="right clear">
							<c:forEach var="point" items="${pointItemList}">
								<c:forEach var="titleItem" items="${titleItemList}">
									<c:if test="${point.itemNo == titleItem.itemNo}">
										<c:set var="titleItemChecked" value="checked" />
									</c:if>
								</c:forEach>
								<div class="pointValue">
									<label>
										<input type="checkbox" name="point" class="point"
										value="${point.itemNo}" ${titleItemChecked}>
										${point.itemName}
									</label>
								</div>
								<c:remove var="titleItemChecked" />
							</c:forEach>
						</div>
					</div>	
					<div class="posterBox clear updateTitleRow">
						<h3 class="left">포스터 이미지</h3>
						<div class="right">
							<input type="file" name="posterFile" accept="image/*" id="posterFile">
							<c:if test="${title.poster != null }">
								<p>기존경로 : ${title.poster }</p>
							</c:if>
							<c:if test="${title.poster == null }">
								<p>기존 포스터 파일이 없습니다</p>
							</c:if>
						</div>
					</div>
					<div class="backImgBox clear updateTitleRow">
						<h3 class="left">배경 이미지</h3>
						<div class="right">
							<input type="file" name="backImgFile" accept="image/*" id="backImgFile">
							<c:if test="${title.backImg != null }">
								<p>기존경로 : ${title.backImg }</p>
							</c:if>
							<c:if test="${title.backImg == null }">
								<p>기존 배경이미지 파일이 없습니다</p>
							</c:if>
						</div>
					</div>
					<div class="submitBox clear updateTitleRows">
							<input type="submit" value="등록" id="submit">
							<a href="getTitle.do?titleNo=${title.titleNo }" class="cancel">취소</a>
						
					</div>
				</div>
			</form>
		</main>
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
	</div>
</body>
</html>