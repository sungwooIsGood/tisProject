<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="resources/css/reset.css?after">
	<link rel="stylesheet" href="resources/css/header.css?after"> 
	<link rel="stylesheet" href="resources/css/footer.css?after"> 
	<link rel="stylesheet" href="resources/css/insertBoard.css?after"> 
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script src="resources/script/footer.js" defer></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "root">
		<div class="content">
			<%@ include file="/WEB-INF/views/includes/header.jsp" %>
			<div class="maincontent">
				<h1> 글 등록 </h1>
				<br>
				<form action="insertBoard.do" method="post" enctype="multipart/form-data">
					<table class="insertBoard">
						<tr>
							<th class="insert"> 제목 </th>
							<td align="left"><input type="text" name="title" style="color: #000;" class="insertinput"/> </td>
							<th class="insert"> 작성자 </th>
							<input type="hidden" name="writer" style="color: #000;" class="insertinput" value="${sessionScope.nickname}" />
							<td align="left">${sessionScope.nickname}</td>
						</tr>
						<tr>
							<th class="insertContent"> 내용 </th>
							<td colspan="3" align="left">
								<textarea name="content" style="color: #000;" class="insertinput"></textarea>	
							</td>
							
						</tr>
						<!-- file 업로드  -->
						<tr>
							<th class="insert"> 파일 첨부 </th>
							<td colspan="3" align="left">
								<input type="file" accept="image/*" name="boardFile" id="boardFile"/>
							</td>
						</tr>
						<!--  -->
						<!-- <tr>
							<td colspan="4" align="center"></td>
						</tr> -->
					</table><br><br>
					<button style="color: #000;" type="submit">등록</button>
				</form>
				<br>
				<a href="getBoardList.do">글 목록</a>
				
			</div>
			<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
		</div>
	</div>
</body>
</html>