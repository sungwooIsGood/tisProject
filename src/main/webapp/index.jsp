  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/screen.css">
<meta charset="UTF-8">
<title>왓챠</title>
</head>
<body>

	<nav>
		<a class="logolink" href="#"> <img src="resources/img/logo1.svg"
			class="logoimg">
		</a> <a class="buttonlink" href="index.do">
			<button class="btn1" style="color: deeppink;">로그인</button>
		</a>

		<div class="main_text">
			<h3 class="text1">
				<span> 영화, 드라마, 예능, 다큐멘터리를 무제한으로 </span> <br>

			</h3>
			<h4 class="text2">매주 5백 여편의 신작이 업데이트 되며, 추가 요금은 전혀 없어요.</h4>

		</div>
	</nav>



	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">


		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="3" aria-label="Slide 4"></button>

		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="resources/img/first1.jpg" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="resources/img/first2.jpg" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="resources/img/first3.jpg" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="resources/img/first4.jpg" class="d-block w-100" alt="...">
			</div>

		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

</body>
</html>