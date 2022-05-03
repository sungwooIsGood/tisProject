<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="resources/css/headerManager.css?after"> 
	<link rel="stylesheet" href="resources/css/footer.css?after">
	<link rel="stylesheet" href="resources/css/modifyNotice.css?after">
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script src="resources/script/footer.js" defer></script>
</head>
<body>
  <div id="root">
      <div class="content">
         <%@ include file="/WEB-INF/views/includes/headerManager.jsp" %>
        <div class="maincontent">
          <h2>공지사항</h2>
          <hr>
          <main>
            <form action="modifyNotice.do" method="post" enctype="multipart/form-data">
              <table class="notice_detail">
                <tr>
                  <th class="list1">제목</th>
                  <td>
                    <input style="height:60px" class="modifyinput" name="title" type="text" value="${notice.title}" />
                  </td>
                  <th class="list1">조회수</th>
                  <td>${notice.cnt}</td>
                </tr>
                <tr>
                  <th class="list2">내용</th>
                  <td colspan="3">
                    <textarea style="height:400px" class="modifyinput" name="content">${notice.content}</textarea>
                  </td>
                </tr>
                <tr>
					<th class="list2"> 첨부파일 </td>
					<td colspan="3" align="left">
						<img alt="${notice.title}" src="${notice.nFile }"><br><br>
						<input type="file" accept="image/*" name="noticeFile" id="noticeFile"/><br>
					</td>
				</tr>
                <tr>
                  <th class="list1">등록일</th>
                  <td colspan="3"><fmt:formatDate value="${notice.regDate}" pattern="yyyy-MM-dd" /></td>
                </tr>
              </table>
              <br />
              <a href="getNoticeList.do" class="list">글 목록</a>
              <input type="hidden" name="seq" value="${notice.seq}">
              <input class="list" type="submit" value="수정완료" />
            </form>
          </main>
        </div>
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
      </div>
    </div>
</body>
</html>