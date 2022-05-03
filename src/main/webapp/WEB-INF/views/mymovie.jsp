<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--jsp파일 내용 그대로 html로 옴긴 파일입니다.-->
<html>
<head>
	<link rel="stylesheet" href="resources/css/style.css?after"> 
	<link rel="stylesheet" href="resources/css/mymovie.css?after"> 
    <link rel="stylesheet" href="resources/css/mypage.css?after">
    <meta charset="UTF-8">
    <title>Insert title here</title>
    </head>
    <body>
    <script src="resources/script/jquery.min.js"></script>
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script src="resources/script/mymovie.js" defer></script>
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
			                    <a href="profile.do" class="profilea"> 개인정보수정</a>
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
                <table class="lockerbox">
                    <tr>
                        <th colspan="5"><h1>추천영상</h1></th>
                    </tr>
                    <tr>
                    	<c:forEach items="${TitleVO }" var ="titleVO">
                           	<td><a href="videoInfo.do?titleNo=${titleVO.titleNo}"><img src='${titleVO.poster}'></a></td> 
                    	</c:forEach>
                    </tr>
                </table>
                <table class="lockerbox">
                    <tr>
                        <th colspan="5"><h1>내 보관함 </h1></th>
                    </tr>
                    <tr>
                    	<td><h1 class="non">보관함에 등록된 영상이 없습니다! 보관함에 영상을 등록해 편리하게 사용해 보세요!</h1></td>
                        <c:forEach items="${TitleVO2 }" var ="titleVO2">
                       		<td class="count"><h1 class="non">보관함에 등록된 영상이 없습니다! 보관함에 영상을 등록해 편리하게 사용해 보세요!</h1>
                       		<a href="videoInfo.do?titleNo=${titleVO2.titleNo }">
                       		<img src='${titleVO2.poster}'></a><br>
                       		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       		<a href="delete.do?titleNo=${titleVO2.titleNo }">삭제</a></td> 
                    	</c:forEach>
                    </tr>
                </table>
			</main>		
		</div>
		<footer>
			<nav class="footbar">
                <div class="money">
				    <h5>첫 2주 무료체험 이벤트! 모든 작품, 무제한 감상하세요. 마음에 들지 않으면 클릭 한 번으로 언제든 해지할 수 있어요</h5>
                    <button id="payment">결제하기</button> <button id="close">닫 기</button> 
                </div>    
			</nav>
		</footer>
	</div>
	<script>
	var title = document.getElementsByClassName('count').length;
	console.log(title);
	if(title == 0 ){
		$('.non').css({
			"display":"block"
		});
	}else{
		$('.non').css({
			"display":"none"
		});
	}

    function closepop(){
        document.querySelector(".popupback").className="popupback";
    }

    function close(){
        document.querySelector(".footbar").className="footbar off";
    }
    


    
    //이미 결제한 유저는 결제 팝업창이 뜨지 않음
	if(${vo.rank}==1){
		close()
	}

    document.querySelector("#close").addEventListener("click", close);
    document.querySelector("#payment").addEventListener("click",close);
	
	</script>
</body>

</html>
