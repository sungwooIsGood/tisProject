<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="resources/css/header.css?after"> 
	<link rel="stylesheet" href="resources/css/footer.css?after"> 
	<link rel="stylesheet" href="resources/css/reset.css?after"> 
	<link href="resources/css/style.css?after" rel="stylesheet" type="text/css">
	<link href="resources/css/profile.css?after" rel="stylesheet" type="text/css">
	<link href="resources/css/getBoard.css?after" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script src="resources/script/footer.js" defer></script>
</head>
<body>
  <div id="root">
      <div class="content">
         <%@ include file="/WEB-INF/views/includes/header.jsp" %>
        <main class="maincontent">
          <div id="btn_detail">
            <a class="insert" href="insertBoard.jsp">게시물 등록</a>
            &nbsp;&nbsp;
            <a class="delete" href="deleteBoard.do?bno=${board.bno}">게시물 삭제</a>
          </div>

          <div id="selectBoard">
            <form action="modifyBoard.do" method="post" enctype="multipart/form-data">
              <table id="board_detail">
                <tr class="firstBoard">
                  <th>제목</th>
                  <td class="title">
                    <input class="modifyTitle"name="title" type="text" value="${board.title}" />
                  </td>
                  <th>조회수</th>
                  <td class="cnt">${board.cnt}</td>
                </tr>
                <tr class="secondBoard">
                  <th>작성자</th>
                  <td colspan="3">${board.writer}</td>
                </tr>
                <tr class="thirdBoard">
                  <th>내용</th>
                  <td colspan="3">
                    <textarea class="modifyContent" name="content" cols="40" rows="10">${board.content}</textarea>
                  </td>
                </tr>
                <tr class="thirdBoard">
					<td> 첨부파일 </td>
					<td colspan="3" align="left">
						<img alt="" src="${board.bFile }"><br><br>
						<input type="file" accept="image/*" name="boardFile" id="boardFile"/><br>
					</td>
				</tr>
                <tr class="fourthBoard">
                  <!-- 수정일로? -->
                  <th>등록일</th>
                  <td colspan="3"><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" /></td>
                </tr>
              </table>
              <br />
              <input type="hidden" name="bno" value="${board.bno}">
              <input class="list" type="submit" value="수정완료" />
            </form>
          </div>
        </main>
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
      </div>
    </div>
</body>
</html>