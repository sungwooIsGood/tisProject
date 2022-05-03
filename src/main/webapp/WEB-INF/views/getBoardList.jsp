<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="resources/css/header.css?after"> 
	<link rel="stylesheet" href="resources/css/footer.css?after"> 
	<link rel="stylesheet" href="resources/css/getBoardList.css?after">
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script src="resources/script/footer.js" defer></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "root">
		<div class="content" >
			<%@ include file="/WEB-INF/views/includes/header.jsp" %>
			<div class="maincontent" align="center">
				<main>
					<h1>게시판</h1>

					<%-- <h3>
						${sessionScope.user} <a href="logout.do">Log-out</a>
					</h3> --%>
					
					<!-- 검색 시작 -->
					<form action="getBoardList.do" id="getBoardList" method="post">
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
					
					<!-- 게시판 목록 출력 -->
					<table class="boardList">
						<tr class="listTitle">
							<th class="list1">번호</th>
							<th class="list2">제목</th>
							<th class="list3">작성자</th>
							<th class="list4">작성일</th>
							<th class="list5">조회수</th>
						</tr>
						<c:forEach items="${boardList}" var="board">
						<tr class="listTitle">
							<td class="listvalue">${board.bno}</td>
							<td class="listvalue"><a href="getBoard.do?bno=${board.bno}">${board.title}</a></td>
							<td class="listvalue">${board.writer}</td>
							<td class="listvalue"><fmt:formatDate value="${board.regDate}" pattern="yyy-MM-dd" /></td>
							<td class="listvalue">${board.cnt}</td>
						</tr>
						</c:forEach>
					</table>
					<br>
					<!-- Paging --> 
					<%-- <h3>${pageMaker }</h3> --%>
						<nav class="page navigation"> 
						    <ul class="pagination"> 
						        <c:if test="${pageMaker.prev}"> 
						        	<a class="page-link" href="getBoardList.do?pageNum=${pageMaker.startPage - 1}" tabindex="-1"> < </a>
						        </c:if> 
						        <c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }"> 
						            <a class="page-link" href="getBoardList.do?pageNum=${num}">${num}</a> 
						        </c:forEach>
						        <c:if test="${pageMaker.next}"> 
						        	<a class="page-link" href="getBoardList.do?pageNum=${pageMaker.endPage + 1}" tabindex="-1"> > </a>
						        </c:if> 
						    </ul> 
						</nav>
					<!-- /.page -->
					<br>
					<a href="insertBoard.jsp">새글등록</a>
				</main>
			</div>
			<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
		</div>
		
	</div>
</body>
</html>










