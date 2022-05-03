<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/headerManager.css">
	<link rel="stylesheet" href="resources/css/footer.css">
	<link rel="stylesheet" href="resources/css/getItem.css">
	<script src="resources/script/jquery.min.js"></script>
	<script src="resources/script/footer.js" defer></script>
    <script src="resources/script/getItem.js" defer></script> 
<meta charset="UTF-8">
<title>왓챠</title>
</head>
<body>
	
	<div id="wrap">
	<%@ include file="/WEB-INF/views/includes/headerManager.jsp" %>
		<h1>항목 등록, 수정, 삭제</h1>
		<table>
			<tr class="tableRow">
				<th class="tableTitle">장르</th>
				<td class="genre clear">
					<c:forEach var="genre" items="${genreItemList}">
						<div class="item"
						data-itemNo="${genre.itemNo}"
						data-itemName="${genre.itemName}">
							<div class="itemName">
								${genre.itemName }
							</div>
							<button class="updateItem">
								수정
							</button>
							<button class="deleteItem">
								삭제
							</button>
						</div>
					</c:forEach>
				</td>
			</tr>
			<tr class="tableRow">
				<th class="tableTitle">국가</th>
				<td class="nation clear i">
					<c:forEach var="nation" items="${nationItemList}">
						<div class="item"
						data-itemNo="${nation.itemNo}"
						data-itemName="${nation.itemName}">
							<div class="itemName" >
								${nation.itemName }
							</div>
							<button class="updateItem">
								수정
							</button>
							<button class="deleteItem">
								삭제
							</button>
						</div>
					</c:forEach>
				</td>
			</tr>
			<tr class="tableRow">
				<th class="tableTitle">특징</th>
				<td class="point clear">
					<c:forEach var="point" items="${pointItemList}">
						<div class="item clear"
						data-itemNo="${point.itemNo}"
						data-itemName="${point.itemName}">
							<div class="itemName">
								${point.itemName }
							</div>
							<button class="updateItem">
								수정
							</button>
							<button class="deleteItem">
								삭제
							</button>
						</div>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="inputBox clear">
						<h2>항목</h2>
						<select class="insertItemOption">
							<option value="G">장르</option>
							<option value="N">국가</option>
							<option value="P">특징</option>
						</select>
						<input type="text" class="insertItemName">
						<button class="insertItem">등록</button>
					</div>
				</td>
			</tr>
		</table>
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>	
	</div>
</body>
</html>