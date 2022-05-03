<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/headerManager.css">
	<link rel="stylesheet" href="resources/css/footer.css">
	<link rel="stylesheet" href="resources/css/titleOption.css">
	<script src="resources/script/jquery.min.js"></script>
	<script src="resources/script/footer.js" defer></script>
    <script src="resources/script/titleOption.js" defer></script> 
<meta charset="UTF-8">
<title>왓챠</title>
</head>
<body>
	
	<div id="wrap">
	<%@ include file="/WEB-INF/views/includes/headerManager.jsp" %>
		<table>
			<tr>
				<th class="tableTitle">장르</th>
				<td class="clear">
					<div class="item" >
						장르1
						<a class="edit">
							수정
						</a>
						<a class="delete">
							삭제
						</a>
					</div>
					<div class="item" >
						장르2
						<a class="edit">
							수정
						</a>
						<a class="delete">
							삭제
						</a>
					</div>
				</td>
			</tr>
			<tr>
				<th class="tableTitle">국가</th>
				<td class="clear">
					<div class="item" >
						국가1
						<a class="edit">
							수정
						</a>
						<a class="delete">
							삭제
						</a>
					</div>
					<div class="item" >
						국가2
						<a class="edit">
							수정
						</a>
						<a class="delete">
							삭제
						</a>
					</div>
				</td>
			</tr>
			<tr>
				<th class="tableTitle">특징</th>
				<td class="clear">
					<div class="item" >
						특징1
						<a class="edit">
							수정
						</a>
						<a class="delete">
							삭제
						</a>
					</div>
					<div class="item" >
						특징2
						<a class="edit">
							수정
						</a>
						<a class="delete">
							삭제
						</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<form action="" method="post" name="itemAdd">
						<select class="" id="type" name="type">
							<option value="T">--항목--</option>
							<option value="G">장르</option>
							<option value="N">국가</option>
							<option value="P">특징</option>
						</select>
						<button class="save" type="submit">
							저장
						</button>
						<a href="#" class="cancel">
							취소
						</a>
					</form>
				</td>
			</tr>
		</table>
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>	
	</div>
</body>
</html>