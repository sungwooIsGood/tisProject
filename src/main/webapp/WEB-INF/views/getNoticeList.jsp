<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="resources/css/getNoticeList.css?after"> 
	<link rel="stylesheet" href="resources/css/headerManager.css?after"> 
	<link rel="stylesheet" href="resources/css/footer.css?after"> 
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script src="resources/script/footer.js" defer></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "root">
		<div class="content" >
			<%@ include file="/WEB-INF/views/includes/headerManager.jsp" %>
			<div class="maincontent">
				<main>
					<h2>공지사항</h2>
					<hr>			
					<!-- 게시판 목록 출력 -->
					<table class="noticeList">
						<tr class="listTitle">
							<th class="list1">번호</th>
							<th class="list2">제목</th>
							<th class="list3">작성일</th>
							<th class="list4">조회수</th>
						</tr>
						<c:forEach items="${noticeList}" var="notice">
						<tr class="listTitle">
							<td class="listvalue">${notice.seq}</td>
							<td class="listvalue"><a href="getNotice.do?seq=${notice.seq}">${notice.title}</a></td>
							<td class="listvalue"><fmt:formatDate value="${notice.regDate}" pattern="yyy-MM-dd" /></td>
							<td class="listvalue">${notice.cnt}</td>
						</tr>
						</c:forEach>
					</table>
					<br>
					<!-- 페이징 시작 -->
					<%-- <h3>${pageMaker }</h3> --%>
						<nav class="page navigation"> 
						    <ul class="pagination"> 
						        <c:if test="${pageMaker.prev}"> 
						        	<a class="page-link" href="getNoticeList.do?pageNum=${pageMaker.startPage - 1}" tabindex="-1"> < </a>
						        </c:if> 
						        <c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }"> 
						            <a class="page-link" href="getNoticeList.do?pageNum=${num}">${num}</a> 
						        </c:forEach>
						        <c:if test="${pageMaker.next}"> 
						        	<a class="page-link" href="getNoticeList.do?pageNum=${pageMaker.endPage + 1}" tabindex="-1"> > </a>
						        </c:if> 
						    </ul> 
						</nav>
					<!-- 페이징 끝 -->
					<br>
					<!-- 검색 시작 -->
					<form action="getNoticeList.do" id="getNoticeList" method="post">
						<table class="search">
							<tr>
								<td align="right">
									<select name="searchCondition">
										<c:forEach items="${conditionMap }" var="option">
											<option value="${option.value }">${option.key }
										</c:forEach>							
									</select> 
									<input name="searchKeyword" type="text" /> 
									<input type="submit" value="검색" />
								</td>
							</tr>
						</table>
					</form>
					<!-- 검색 끝 -->
					
					<!-- 관리자만 보이게 -->
            		<c:set var="manager" value="${sessionScope.manager}" />
            		<c:if test="${manager == 2}">
						<a href="insertNotice.jsp" class="insert">새글등록</a>
					</c:if>
				</main>
			</div>
			<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
		</div>
		
	</div>
</body>
</html>