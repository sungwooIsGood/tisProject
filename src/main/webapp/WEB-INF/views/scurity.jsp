<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--jsp파일 내용 그대로 html로 옴긴 파일입니다.-->
<html>
<head>
	<link rel="stylesheet" href="resources/css/reset.css?after">
	<link rel="stylesheet" href="resources/css/header.css?after"> 
	<link rel="stylesheet" href="resources/css/footer.css?after"> 
	<link rel="stylesheet" href="resources/css/style.css?after"> 
	<link rel="stylesheet" href="resources/css/mypage.css?after">
	<link rel="stylesheet" href="resources/css/scurity.css?after">
	<script src="resources/script/jquery.min.js"></script>
	
<style>
.userbar{
	background-color:#141517;
	height:80px;
	padding-right:20px;
	text-align:right;	
	margin-top:-16px;
	padding:50px 50px 50px 50px;
}



.userbar img{
	border-radius:100%;
	width:32px;
	height:32px;
	color:#fff;
	transform:translate(0%,-15%);
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "root">
		<div class="content">
			<header>
				<nav class="leftmenu">
					<a class="logolink" href="#">
						<img src="resources/img/logo.png" class="logoimg" >	
					</a>
					<section class="leftsction">
						<ul class="leftmenubuttonul">
							<li class="leftmenubuttonli">
								<a href="home.do">영상 보기</a>
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
							</li>
							<li class="leftmenubuttonli">
								<a href="#">관리자페이지</a>
							</li>					
						</ul>
					</section>
				</nav>
			</header>	
			<div class="userbar">
                <a href="logout.do"><img src = "resources/img/${vo.icon }.jpg"></a>
            </div>
				<main class="maincontent">
					<div class="back">
						<table class="profileupdate">
							<tr class="updatetr">
								<td>
									<h2>아이디</h2>
								</td>
								<td>
									<input type="text" id="userid" class="updateinput">
									<input type="hidden" id ="click2" value="1" name="click">
								</td>
	                               <td rowspan="2">
									<button id="click">로그인</button>
								</td>
							</tr>
							<tr class="updatetr">
								<td>
									<h2>비밀번호</h2>
								</td>
								<td>
									<input type="password" id="password" class="updateinput">
								</td>
							</tr>
						</table>
					</div>	
				</main>	
			
	
		</div>
			<%@ include file="/WEB-INF/views/includes/footer.jsp" %>	
		</div>

        <script>
        
           function click(){
                var userid = document.getElementById("userid").value;
                var password = document.getElementById("password").value
                console.log(userid)
                console.log(password)
                console.log('${vo.userid}');
            	console.log('${vo.password}');
            	var click2 = document.getElementById("click2").value;

                 if(userid == '${vo.userid}' && password == '${vo.password}'){
                	 	/* var click2 = document.getElementById("click2").value;
                	 	console.log(click2);
                	     $(location).attr('href','profile.do'); */

                	    $.ajax({
                	    	type:'post',
                	    	url:'/scurityDo.do',
                	    	data:{"click2": click2},
                	    	success: function(){
                	    		$(location).attr('href','profile.do');
                	    	}
                	    })
                	    

  
                 }else{
                	 alert("아이디 또는 비밀번호가 올바르지 않습니다.");
                 }

            }
            
            document.querySelector("#click").addEventListener("click",click);

            

        </script>
</body>
</html>