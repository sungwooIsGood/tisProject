<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="resources/css/headerManager.css?after"> 
	<link rel="stylesheet" href="resources/css/footer.css?after"> 
	<link rel="stylesheet" href="resources/css/insertNotice.css?after"> 
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script src="resources/script/footer.js" defer></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "root">
		<div class="content">
			<%@ include file="/WEB-INF/views/includes/headerManager.jsp" %>
			<div class="maincontent">
				<h2>공지사항</h2>
				<hr>
				<br><br>
				<main>
					<form action="insertNotice.do" method="post" enctype="multipart/form-data">
						<table class="insertBoard">
							<tr>
								<td class="inserttitle"> 제목 </td>
								<td align="left" class="insert"><input type="text" name="title" class="insertinput"/> </td>
								<td> 작성자 </td>
								<td align="left" class="insert"> 왓챠 팀 </td>
							</tr>
							<tr>
								<td class="insertcontent" colspan="4" align="left"><textarea name="content" class="insertinput"></textarea></td>
							</tr>
							<!-- file 업로드  -->
							<tr>
								<td> 파일 첨부 </td>
								<td colspan="3" align="left" class="insert">
									<input type="file" accept="image/*" name="noticeFile" id="noticeFile" />
								</td>
							</tr>
							<!--  -->
							<!-- <tr>
								<td colspan="4" align="center"></td>
							</tr> -->
						</table>
						<br><br><br>
						<a href="getNoticeList.do">공지사항 목록</a>
						<input type="submit" value="등록" />
					</form>
				</main>
			</div>
			<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
		</div>
	</div>
</body>
</html>
