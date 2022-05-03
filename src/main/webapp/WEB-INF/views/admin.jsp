<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/header.css">
	<link rel="stylesheet" href="resources/css/footer.css">
	<link rel="stylesheet" href="resources/css/admin.css">
	<script src="resources/script/jquery.min.js"></script>
	<script src="resources/script/footer.js" defer></script>
<meta charset="UTF-8">
<title>왓챠</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp" %>
	<div id="wrap">
		<a href="getTitleList.do">타이틀 관리</a>
		<br>
		<a href="getItem.do">아이템 관리</a>
		<br>
		<a href="#">사용자 관리</a>
		<br>
		<a href="#">공지사항 관리</a>
	<%@ include file="/WEB-INF/views/includes/footer.jsp" %>	
	</div>
</body>
</html>