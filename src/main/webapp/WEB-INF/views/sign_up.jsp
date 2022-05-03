<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head profile = "http://www.w3.org/2005/10/profile">

    <meta charset="UTF-8">
    <link rel = "stylesheet" href="resources/css/sign_up.css?after">
    <title>sign_up</title>

    <script  type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script async src ="resources/script/sign_up.js"></script>

</head>
	

<body>
    <div class = "header" >
            <ul class="logo" >
                <img src="resources/img/wtch_logo.png" alt="wtch_logo"  width= "104px" height= "52px">
            </ul>
        <a href="index.do">
        	<button class = "login"  style="text-decoration:none">로그인</button>
        </a>
    </div>
    

	<main class = "main">
	    <img src = "resources/img/login_back.jpg" class = "back" >
	
	    <main class = "sign_up">
	    <div class = "sign_up_2">
	        <span class = "title">회원가입</span>
	          
	    </div> 
	     <form action="signUp.do" method="post" id="regForm">
	    
	    <input placeholder="닉네임(2자 이상)" type="text" class = "nickname" id = "nickname" name = "nickname"/>
	    <button class = "nameCheck" type = "button" id = "nameCheck" value="0">중복확인</button>
	    <input type = "hidden" name = "nameCheckResult" value = "">
	    <button class = "idCheck" type = "button" id = "idCheck" value="0">중복확인</button>
	    <input type = "hidden" name = "idCheckResult" value = "">
	    <input placeholder="아이디" type="text" class = "userId" name = "userid" id = "userId"/>
	   
	    <input placeholder="이메일(example@gmail.com)" type="email" class = "email"name = "email" id = "email"/>
	    <input placeholder="비밀번호" type="password" class = "password" name = "password" id = "password"/> 
	    <input placeholder="비밀번호 확인" type="password" class = "password" name = "passwordChk" id = "passwordChk"/> 
	    <input data-placeholder="생년월일" type="date" class = "birthday" name = "birthday" id = "birthday"  />
	    <span class = "gender" id = "gender">성별
	        <input type = "radio" class="male" name="gender" id = "genderm" value="m"> 남자
			<input type = "radio" class="female" name="gender" id = "genderf" value="f"> 여자
	    </span>
	    <div>
	    <!-- 신동인 수정 -->
	        <span class = "genre">선호하는 장르 선택</span>
				<select name = "favorite_genre1" id = "favorite_genre1" class="oo">
					<option value="none">=== 장르1 선택 ===</option>
					<c:forEach var="genre" items="${genreItemList}">
					<option value="${genre.itemNo }">${genre.itemName}</option>
					</c:forEach>
				</select> &nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        &nbsp;&nbsp;&nbsp;&nbsp;
				<select name = "favorite_genre2" id = "favorite_genre2" class="oo">
					<option value="none">=== 장르2 선택 ===</option>
					<c:forEach var="genre" items="${genreItemList}">
					<option value="${genre.itemNo }">${genre.itemName}</option>
					</c:forEach>
				</select> <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        &nbsp;&nbsp;&nbsp;&nbsp;
					<select name = "favorite_genre3" id = "favorite_genre3" class="oo">
					<option value="none">=== 장르3 선택 ===</option>
					<c:forEach var="genre" items="${genreItemList}">
					<option value="${genre.itemNo }">${genre.itemName}</option>
				</c:forEach>
				</select>
		<!-- 여기까지 -->
	    </div>
	    
	    
	     <div class = "sign_up_check" >
	        <input type = "checkbox" id = "check_all"/> 전체 약관에 동의합니다 <br>
	        <input type = "checkbox" name = "check" id="check1"> 만 14세 이상입니다 <br>
	        <input type = "checkbox" name = "check" id="check2"> 왓챠피디아 서비스 이용약관에 동의합니다(필수) <br>
	        <input type = "checkbox" name = "check" id="check3"> 왓챠 서비스 이용약관에 동의합니다(필수) <br>
	        <input type = "checkbox" name = "check" id="check4"> 개인정보 수집 및 이용에 대한 안내에 동의합니다(필수) <br>
	        <input type = "checkbox" name = "check" id="check5"> 신작 알림 이벤트 정보 수신에 동의합니다(선택)
	    </div>
	    <div id = "clifrm" class="sign_up_btn" onclick="return pawcheck()">
	        계정 생성하기
	        <br>
	    </div>
	    </form>
	    <p class="text">결제 정보요? 충분히 둘러보시고 입력해도 늦지 않아요</p>
	</main>

	<footer>
	    <span class="top">
	        <a>고객센터(이용 및 결제 문의) cs@watcha.co.kr </a> &nbsp;&nbsp;
	    </span>
	    <span>  •  </span>
	    "02-515-9985 (유료)"
	    &nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;
	    "제휴 및 대외 협력"  &nbsp;&nbsp;
	    <a>http://watcha.team/contact </a> <br>
	    <span class="bottom">
	        <a>주식회사 왓챠 / 대표 박태훈 / 서울특별시 서초구 강남대로 343 신덕빌딩 3층 / 사업자 등록번호 211-88-66013 
	        / 통신판매업 신고번호 제 2019-서울서초-0965호 / 대표번호 02-515-9985 / 개인정보 처리 방침 / 청소년 보호정책
	    </a></span>
	</footer>
</body>
</html>