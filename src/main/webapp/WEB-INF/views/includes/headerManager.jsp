<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
				</li>
				
				<!-- 관리자만 보이게 -->
				<c:set var="manager" value="${sessionScope.manager}" />
				<c:if test="${manager == 2}">
					<li class="leftmenubuttonli">
						<a href="getTitleList.do">관리자페이지</a>
					</li>	
				</c:if>
				
				<!-- Test -->
				<!-- <li class="leftmenubuttonli">
					<a href="manager.jsp">관리자페이지</a>
				</li> -->	
			</ul>
		</section>
	</nav>
</header>
		<div class="main-content">
		
			<div class="userbar">
				<c:set var="manager" value="${sessionScope.manager}" />
				<c:if test="${manager == 2}">
					<div class="topmenu">
						<h1>관리자 페이지</h1>
					</div>
				</c:if>
				<div class="icon">
                	<a href="logout.do">Logout</a>
            	</div>
            </div>
            
            <c:set var="manager" value="${sessionScope.manager}" />
			<c:if test="${manager == 2}">
	            <div class="menubar">
	            	<nav class="clearfix">
						<ul class="clearfixul">
							<li><a href="getTitleList.do">영상 관리</a></li>
							<li><a href="getItem.do">항목 관리</a></li>
							<li><a href="getNoticeList.do">공지사항 관리</a></li>
							<li><a href="getUserList.do">회원 정보 관리</a></li>
						</ul>
					</nav>
	            </div>
	            </c:if>
            
            