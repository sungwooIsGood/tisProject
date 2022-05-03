<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!--jsp파일 내용 그대로 html로 옴긴 파일입니다.-->
<html>
<head>
	<link rel="stylesheet" href="resources/css/reset.css?after">
	<link rel="stylesheet" href="resources/css/header.css?after"> 
	<link rel="stylesheet" href="resources/css/footer.css?after"> 
	<link rel="stylesheet" href="resources/css/style.css?after"> 
	<link rel="stylesheet" href="resources/css/mypage.css?after">
	<link rel="stylesheet" href="resources/css/profile.css?after">
	<script src="resources/script/jquery.min.js"></script>
	<script async src="resources/script/profile.js"></script>
	<script async src="resources/script/footer.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.footer{
margin-top:500px;
}
</style>
</head>
<body>
	<div id = "root">
		<div class="content">
		<header>
			<nav class="leftmenu">
				<a class="logolink" href="home.do">
			<img src="resources/img/logo.png" class="logoimg" >	
		</a>
		<section class="leftsction">
			<ul class="leftmenubuttonul">
				<li class="leftmenubuttonli">
					<a href="home.do">영상 보기</a>
				</li>
				<li class="leftmenubuttonli">
					<a href="search.do">검색</a>
				</li>
				<li class="leftmenubuttonli">
					<a href="getBoardList.do">게시판</a>
				</li>
				<li class="leftmenubuttonli">
					<a href="getNoticeList.do">공지사항</a>
				</li>
				<li class="leftmenubuttonli">
					<a href="mymovie.do">마이페이지</a>
					<li class="mypagesub">
                           	<a href="profile.do" class="profilea"> 개인정보수정</a><br>
                          	<c:set var="manager" value="${vo.manager}" />
							<c:if test="${manager == 1}">
							<!-- 보안문제로 안됨. 개인 컴퓨터에서 보안 수정해야함. -->
                           		<a href="#" onclick="leavepop()" class="profilea">회원탈퇴</a>
                           	</c:if>
                </li>
				</li>
				
				<!-- 관리자만 보이게 -->
				<c:set var="manager" value="${vo.manager}" />
				<c:if test="${manager == 2}">
					<li class="leftmenubuttonli">
						<a href="getTitleList.do">관리자페이지</a>
					</li>	
				</c:if>				
			</ul>
		</section>
	</nav>
</header>	
			<div class="userbar">
                <a href="logout.do">Logout</a>
            </div>
			<main class="maincontent">
					<div class="update">
						<h1>개인정보수정</h1>
							<form action="profileupdate.do" id="profileupdate" method="post" onsubmit="return pawclick();">
								<div class="back">
								<table class="profileupdate">
									<tr class="updatetr">
										<td>
											<h2>아이디</h2>
										</td>
										<td>
											<input type="text" class="updateinput" value="${vo.userid }" disabled>
											<input type="hidden" name="userid" value="${vo.userid }">
										</td>
									</tr>
									<tr class="updatetr">
										<td>
											<h2>비밀번호</h2>
										</td>
										<td>
											<input type="password" name="clickpw" class="updateinput" id = "passwordinput">
											<input type="hidden" name="userpassword" id="userpassword" value="${vo.password }">
										</td>
									</tr>
									<tr class="updatetr">
										<td>
											<h2>비밀번호변경</h2>
										</td>
										<td>
											<input type="password" class="updateinput" id = "password1">
										</td>
									</tr>
									<tr class="updatetr">
										<td>
											<h2>확 인</h2>
										</td>
										<td>
											<input type="password" name="password" class="updateinput" id = "password2">
										</td>
									</tr>
									<tr class="updatetr">
										<td>
											<h2>닉네임</h2>
										</td>
										<td>
											<input type="text" name="nickname" class="updateinput" value="${vo.nickname }" >
										</td>
									</tr>
									<tr class="updatetr">
										<td>
											<h2>생년월일</h2>
										</td>
										<td>
											<input type="date" name="birthday" value="${vo.birthday }" min = "1900-01-01" class="updatedate" disabled>
										</td>
									</tr>
									<tr class="updatetr">
										<td>
											<h2>이메일</h2>
										</td>
										<td>
											<input type="text" name="email" class="updateinput" value="${vo.email }">
										</td>
									</tr>
									<tr class="updatetr">
										<td>
											<h2>선호 장르</h2>
										</td>
										<td class="checkboxtd">
											<select name = "favorite_genre1" id = "favorite_genre1" class="oo">
									            <option value="none">=== 장르1 선택 ===</option>
									        <c:forEach var="genre" items="${genreItemList}">
									            <option value="${genre.itemNo }">${genre.itemName}</option>
									        </c:forEach>
									        </select>
									        <select name = "favorite_genre2" id = "favorite_genre2" class="oo">
									            <option value="none">=== 장르2 선택 ===</option>
									        <c:forEach var="genre" items="${genreItemList}">
									            <option value="${genre.itemNo }">${genre.itemName}</option>
									        </c:forEach>
									        </select>
									        <select name = "favorite_genre3" id = "favorite_genre3" class="oo">
									            <option value="none">=== 장르3 선택 ===</option>
									        <c:forEach var="genre" items="${genreItemList}">
									            <option value="${genre.itemNo }">${genre.itemName}</option>
									        </c:forEach>
									        </select>
										</td>
									</tr>
								</table>
								
							</div>
							<div class="submitbt">
								<input type="submit" value="수정완료">
							</div>	
						</form>
	
					</div>
			</main>	
			</div>
			<%@ include file="/WEB-INF/views/includes/footer.jsp" %>	
	</div>
</body>
</html>