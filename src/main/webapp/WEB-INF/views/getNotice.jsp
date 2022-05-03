<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 상세보기</title>
	<link rel="stylesheet" href="resources/css/headerManager.css?after"> 
	<link rel="stylesheet" href="resources/css/footer.css?after">
	<link rel="stylesheet" href="resources/css/getNotice.css?after">
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script src="resources/script/footer.js" defer></script>
</head>
<body>
	  <div id="root">
      <div class="content">
        <!-- include header -->
        <%@ include file="/WEB-INF/views/includes/headerManager.jsp" %>
        <main class="maincontent">
          <h2>공지사항</h2>
		  <hr>
			
          <!-- <a class="logout" href="Login.do">Log-out</a> -->
          
          <div id="btn_detail">
            <%-- 관리자만 가능 --%>
            <c:set var="manager" value="${sessionScope.manager}" />
            <c:if test="${manager == 2}">
	            <a class="insert" href="insertNotice.jsp">공지 등록</a>
	            &nbsp;&nbsp;
	            <a class="modify" href="modifyNotice.jsp">공지 수정</a>
	            &nbsp;&nbsp;
	            <a class="delete" href="deleteNotice.do?seq=${notice.seq}">공지 삭제</a>
            </c:if>
            
            <!-- test -->
	        <%-- <a class="insert" href="insertNotice.jsp">공지 등록</a>
	        &nbsp;&nbsp;
	        <a class="modify" href="modifyNotice.jsp">공지 수정</a>
	        &nbsp;&nbsp;
	        <a class="delete" href="deleteNotice.do?seq=${notice.seq}">공지 삭제</a> --%>
           
          </div>

          <div id="selectNotice">
            <table class="getnotice">
              <tr>
                <!-- <th class="list1">제목</th> -->
                <!-- <td colspan="2">${notice.title}</td> -->
                <th colspan="4">${notice.title}</th>
              </tr>
              <tr class="list3">
                <!-- <th class="list1">내용</th> -->
                <td class="listborder" colspan="4">${notice.content}<br><br><br><img alt="${notice.title}" src="${notice.nFile }"></td>
              </tr>
              <tr>
                <th class="list4">등록일</th>
                <td><fmt:formatDate value="${notice.regDate}" pattern="yyyy-MM-dd" /></td>
                <th class="list1">조회수</th>
                <td class="list2">${notice.cnt}</td>
              </tr>
            </table>
			<br><br><br>
			<div class="list">
            	<a href="getNoticeList.do">목록</a>
            </div>
          </div>
        </main>
        <!-- footer -->
      	<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
      </div>
      
    </div>
</body>
</html>