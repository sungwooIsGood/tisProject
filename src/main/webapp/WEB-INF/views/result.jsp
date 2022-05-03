<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/header.css">
<link rel="stylesheet" href="resources/css/footer.css">
<link rel="stylesheet" href="resources/script/footer.js">
<link rel="stylesheet" href="resources/css/result.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	(function() {
		var num = 0;
		$(window).scroll(
				function() {
					// 조건식에서 == 보다 >= 를 사용 한 이유
					// == 스크롤 높이가 뭐빼기 뭐해서 같으면 끝까지 왔다라고 생각하는건데 >= 는 스크롤높이가 뭐빼기 뭐보다 더 커도(더 밑으로 내려가있어도) 끝까지 간거다 
					// 브라우저마다 특성이 다르기 때문에 같다보다는 크거나 같음으로 진행
					if ($(window).scrollTop() >= $(document).height()
							- $(window).height()) { // 스크롤의 마지막 값을 인식한다.
						var $clone = $('.lockerbox').eq(num).first().clone()
						num++
						$('.infiniteScroll').append($clone)
						console.log(num);
					}
				})
	});
</script>
<meta charset="UTF-8">
<title>왓챠</title>

</head>
<body>
	<div id="wrap">
	<%@ include file="/WEB-INF/views/includes/header.jsp"%>
	<main>
	<h1 class="mainTitle">검색 결과</h1>
		<div class="infiniteScroll clear">
			<c:forEach items="${titleList}" var="title">
				<div class="resultItem">
					<div class="resultValue">
						<a href="videoInfo.do?titleNo=${title.titleNo}">
							<div class="imgBox">
								<c:if test="${title.poster == null}">
									<img alt="noImage" src="resources/img/noImage.jpg">
								</c:if>
								<c:if test="${title.poster != null}">
									<img alt="${title.title}" src="${title.poster}">
								</c:if>
								
							</div>
							<h2 class="resultTitle">${title.title}</h2>
						</a>
						
					</div>
				</div>
			</c:forEach>
		</div>
		
		</main>
		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	</div>
	
</body>
</html>