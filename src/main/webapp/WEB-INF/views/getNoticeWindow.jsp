<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/xhtml+xml;charset=utf-8" />
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="resources/script/getNoticeWindow.js" ></script>
	<link rel="stylesheet" href="resources/css/getNoticeWindow.css?after">
</head>
<body>
	<div class="noticeImg">
		<img alt="${notice.title}" src="${notice.nFile }">
		<div class="closeDay">
			<input type="checkbox" name="Notice" onClick="closeWin()">
	  		<font style="font-size:12pt">오늘 하루 동안 열지 않음</font>
  		</div>
  		<div class="close">
			<form name="form1" class="form1">
				<input type="button" name="btn1" value="닫기" />  
			</form>
		</div>
	</div>
</body>
</html>