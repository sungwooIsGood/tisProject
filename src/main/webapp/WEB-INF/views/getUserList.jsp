<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="resources/css/headerManager.css?after"> 
	<link rel="stylesheet" href="resources/css/footer.css?after"> 
	<link rel="stylesheet" href="resources/css/getBoardList.css?after"> 
	<link rel="stylesheet" href="resources/css/getUserList.css?after"> 
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script src="resources/script/footer.js" defer></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "root">
		<div class="content" >
			<%@ include file="/WEB-INF/views/includes/headerManager.jsp" %>
			<div class="maincontent" align="center">
				<main>
					<h1>회원 목록</h1>

					<%-- <h3>
						${sessionScope.user} <a href="logout.do">Log-out</a>
					</h3> --%>
					
					<!-- 검색 시작 -->
					<form action="getUserList.do" id="getUserList" method="post">
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
					<table class="userList">
						<tr class="listTitle">
							<th class="list1">번호</th>
							<th class="list2">ID</th>
							<th class="list2">닉네임</th>
							<th class="list3">email</th>
							<th class="list2">생년월일</th>
							<th class="list1">성별</th>
							<th class="list2">선호장르</th>
							<th class="list4">결제여부</th>
						</tr>
						<c:forEach items="${list}" var="user">
							<tr class="listTitle">
								<td class="listvalue">${user.id}</td>
								<td class="listvalue">${user.userid}</td>
								<td class="listvalue">${user.nickname}</td>
								<td class="listvalue">${user.email}</td>
								<td class="listvalue"><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" /></td>
								<td class="listvalue">
									<c:if test="${user.gender == 102 || user.gender == 70 }">
										여자
									</c:if>
									<c:if test="${user.gender == 109 || user.gender == 77 }">
										남자
									</c:if>
								</td>
								<td class="listvalue">${user.genrename1}<br>${user.genrename2}<br>${user.genrename3}</td>
								<td class="listvalue">
									<c:if test="${user.rank == 1}">
										결제완료
									</c:if>
									<c:if test="${user.rank == 0}">
										미결제
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
					<br>
					<!-- Paging --> 
					<%-- <h3>${pageMaker }</h3> --%>
						<nav class="page navigation"> 
						    <ul class="pagination"> 
						        <c:if test="${pageMaker.prev}"> 
						        	<a class="page-link" href="getUserList.do?pageNum=${pageMaker.startPage - 1}" tabindex="-1"> < </a>
						        </c:if> 
						        <c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }"> 
						            <a class="page-link" href="getUserList.do?pageNum=${num}">${num}</a> 
						        </c:forEach>
						        <c:if test="${pageMaker.next}"> 
						        	<a class="page-link" href="getUserList.do?pageNum=${pageMaker.endPage + 1}" tabindex="-1"> > </a>
						        </c:if> 
						    </ul> 
						</nav>
					<!-- /.page -->
					<br>
				</main>
			</div>
			<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
		</div>
		
	</div>
</body>
</html>