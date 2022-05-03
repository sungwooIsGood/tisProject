<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search</title>
	<link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/header.css">
	<link rel="stylesheet" href="resources/css/footer.css">
	<link rel="stylesheet" href="resources/css/search.css">
	<script src="resources/script/footer.js" defer></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="resources/script/search.js" ></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp"%>
	<div id="wrap">
	

		<div class="search-bar input-group mb-3">
			<form action="inputSearch.do" method="get" onsubmit="return checkSearch()">
				<input type="text" class="form-control rounded-pill"
					placeholder="제목,감독,배우로 검색" aria-label="Recipient's username"
					aria-describedby="button-addon2" name="inputSearch">
				<!-- <button onclick="location.href='inputSearch.do'" class="top_button">검색</button> -->
				<input type="submit" value="검색" class="top_button" />
			</form>
		</div>

		<div class="top_banner">
			<th colspan="5"><h1 class="topname">카테고리 둘러보기</h1></th>
		</div>

		<div class="container">

			<ul class="category tabs clear">
				<li class="categoryli tab-link current" data-tab="tab-1"><a href="#">장르</a></li>
				<li class="categoryli tab-link" data-tab="tab-2"><a href="#">국가</a></li>
				<li class="categoryli tab-link" data-tab="tab-3"><a href="#">특징</a></li>
			</ul>
			<div id="tab-1" class="tab-content current">
				<table class="lockerbox">
					<!-- 5개 이상이면 tr하기 -->
					<c:set var="i" value="0" />
					<c:set var="j" value="5" />
					<c:set var="k" value="1" />
					<c:forEach items="${itemListG}" var="item">
						<c:if test="${i % j == 0}">
							<tr>
						</c:if>
						<!-- 이미지 숫자는 임의로 해논 것 증감시켜야함. -->
						<td><a href="result.do?itemNo=${item.itemNo}"><img id="a${k}" src='resources/img/search${k}.png'><h4>${item.itemName}</h4></a></td>
						<c:set var="k" value="${k+1}" />
						<c:if test="${i % j == j-1}">
							</tr>
						</c:if>
						<c:if test="${k > 9}">
							<c:set var="k" value="1" />
						</c:if>
						<c:set var="i" value="${i+1}" />
					</c:forEach>
				</table>
			</div>
			<div id="tab-2" class="tab-content">
				<table class="lockerbox">
					<!-- 5개 이상이면 tr하기 -->
					<c:set var="i" value="0" />
					<c:set var="j" value="5" />
					<c:set var="k" value="1" /> 
					<c:forEach items="${itemListN}" var="item">
						<c:if test="${i % j == 0}">
							<tr>
						</c:if>
						<!-- 이미지 숫자는 임의로 해논 것 증감시켜야함. -->
						<td><a href="result.do?itemNo=${item.itemNo}"><img id="a${k}" src='resources/img/search${k}.png'><h4>${item.itemName}</h4></a></td>
						<c:set var="k" value="${k+1}" />
						<c:if test="${i % j == j-1}">
							</tr>
						</c:if>
						<c:if test="${k > 9}">
							<c:set var="k" value="1" />
						</c:if>
						<c:set var="i" value="${i+1}" />
					</c:forEach>
				</table>
			</div>
			<div id="tab-3" class="tab-content">
				<table class="lockerbox">

					<!-- 5개 이상이면 tr하기 -->
					<c:set var="i" value="0" />
					<c:set var="j" value="5" />
					<c:set var="k" value="1" />
					<c:forEach items="${itemListP}" var="item">
						<c:if test="${i % j == 0}">
							<tr>
						</c:if>
						<!-- 이미지 숫자는 임의로 해논 것 증감시켜야함. -->
						<td><a href="result.do?itemNo=${item.itemNo}"><img id="a${k}" src='resources/img/search${k}.png'><h4>${item.itemName}</h4></a></td>
						<c:set var="k" value="${k+1}" />
						<c:if test="${i % j == j-1}">
							</tr>
						</c:if>
						<c:if test="${k > 9}">
							<c:set var="k" value="1" />
						</c:if>
						<c:set var="i" value="${i+1}" />
					</c:forEach>
				</table>
			</div>
			<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
		</div>
	</div>
</body>
</html>