<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/forgot_pw.css?after">
<title>forgot_pw</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
	$(document).ready(function() {

		// 비밀번호 찾기를 위한 함수
		$(".srch_pw_btn").click(function() {
			
			let email = $(".email").val();
			let userid = $(".userId").val();
			
			let searchEmail = {"email": email, "userid": userid};
			
 	 		$.ajax({
				url: 'sendEmail.do',
				type: 'POST',
				data: JSON.stringify(searchEmail),
				dataType: "text",
				contentType: 'application/json; charset=UTF-8',
				// 이메일 찾기 성공 시
				success: function(result){
					
					if(result == "success"){
						alert("등록된 이메일로 임시 비밀번호를 보내드렸습니다.");
					} else{
						alert("등록된 이메일 혹은 아이디가 없습니다. 다시 확인해주세요.");
					}
				}

			})  
		})	
		
	}); 

</script>
</head>
<body>
	<div class="header">
		<ul class="logo">
			<a href="index.do">
				<img src="resources/img/wtch_logo.png" alt="wtch_logo" width="104px" height="52px">
			</a>
		</ul>
		<ul class="login" style="text-decoration: none">
			<li><a style="text-decoration: none;" href="index.do">로그인</a></li>
		</ul>
	</div>


	<main class="main"> <img src="resources/img/login_back.jpg" class="back"></img> 
		<main class="srch_pwd" >
			<div class="srch_pwd_2">
				<ul class="other">
					<li class="back"><img class="back" src="resources/img/back.png"></img>
					</li>
				</ul>
		
			</div>
			<p class="title">비밀번호 찾기</p>
			<input placeholder="이메일(example@gmail.com)" name="email" type="email" class="email" />
			<input placeholder="아이디" type="text" name="userid" class="userId" />
 			<button id="submit" class="srch_pw_btn" type="button" style="text-decoration: none;">확인</button>
			<p class="txt">기존에 가입하신 이메일 주소, 아이디, 성함을 입력해주시면 설정하신 비밀번호가 뜹니다.</p>
		</main>
	</main> 
	<footer>
		<span class="top"> <a>고객센터(이용 및 결제 문의) cs@watcha.co.kr </a>
			&nbsp;&nbsp;
		</span> <span> • </span> "02-515-9985 (유료)"
		&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp; "제휴 및 대외 협력"
		&nbsp;&nbsp; <a>http://watcha.team/contact </a> <br> <span
			class="bottom"> <a>주식회사 왓챠 / 대표 박태훈 / 서울특별시 서초구 강남대로 343
				신덕빌딩 3층 / 사업자 등록번호 211-88-66013 / 통신판매업 신고번호 제 2019-서울서초-0965호 /
				대표번호 02-515-9985 / 개인정보 처리 방침 / 청소년 보호정책 </a></span>
	</footer>
</body>
</html>