<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
<!-- ?after을 붙이면 프로젝트 내에서 css가 변경된 것을 적용시킨다. -->
<link rel="stylesheet" href="resources/css/reset.css?after">
<link rel="stylesheet" href="resources/css/header.css?after"> 
<link rel="stylesheet" href="resources/css/footer.css?after"> 
<link href="resources/css/getBoard.css?after" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- 자바스크립트 파일을 분리 할 시 jstl이 안됨. -->
<!-- <script type="text/javascript" src="resources/script/replyJs.js" ></script> -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script src="resources/script/footer.js" defer></script>
<script type="text/javascript">
//댓글 리스트 보기
$(document).ready(function(){
      
   let startReply = 1; // 댓글 초기값 -> BoardReplyVO의 endReply를 알기 위해서 필요
   let replyStep = 3; // 3개씩 로딩
//   let total = $(".replyCount").val();
   
   getReplyList(startReply, replyStep); // 자동 실행 되면 최초 3개


   
  $(document).on("click",'#nextReply',function(){ // 동적으로 생긴 버튼이 있을 경우 사용. => $('#nextReply').on클릭은 실행안됨
      startReply = $(this).attr("data-next"); // attr()이 속성 하나면 값불러오기.
      
      getReplyList(startReply, replyStep);
   })  
   
   $('.insertReply-btn').on("click",addReply);
});

function getReplyList(startReply, replyStep){
   
   let reply_bno = $(".reply_bno").val(); // $.ajax()안에 data안에 넣어도 됨 클라이언트 -> 서버로 보내는 것
   
   let sendBno = {"bno": reply_bno, "startReply": startReply, "replyStep" : replyStep} // 키값인 "bno"와 VO 객체 필드명이 같아야 값을 가져온다.
   
   // 수정해봄
   let reply_id = "${sessionScope.nickname}";
  /*  let reply_id = $(".replyer"); */
   // 수정을 위해서 변수 생성함
   let reply_content = $(".replyContent").val();
   let indexStore = 0;
    $.ajax({
      url:"getBoardReplyList.do", // 절대경로 / 상대경로 주의!! /붙이면 절대경로 insertBoardReply.do쓰면 상대경로로 찾는다.
      type:'POST', // default는 get방식 post로 보낼 것이면 type를 설정해야함.
      data: JSON.stringify(sendBno), // .ajax는 데이터를 문자열화 해주지 않기 때문에 보낼 데이터를 JSON.stringify()로 감싸주어야 합니다.
      dataType: 'json',// dataType을 지정하지 않으면 jQuery가 알아서 판단, 
       contentType : 'application/json; charset=UTF-8', // 서버 -> 클라이언트  Map은 json형태? / text면 VO로 받는 것
      success: function(result){
//         let replyData = JSON.stringify(result); // String 형식의 json타입으로 변환
         let comments = "";
          if(result.length < 1){ // result.length => list 하나당 length는 1
         	comments += "<br /><br />"
             comments = "&nbsp;&nbsp;등록된 댓글이 없습니다.";
          } else{
              $.each(result, function(index, value) {
             	 comments += "<br /><br />"
                comments += "<li> 작성자: " + value.replyer + "&nbsp;&nbsp; 작성날짜: " + value.replyDate + "</li>";
                comments += "<br />";
                comments += "<li class='reply_rno" + value.rno + "'>" + value.reply; + "&nbsp;";
                if(reply_id == value.replyer){
                // onclick 안에도 변수는 쌍따옴표로 해야함 문자로 들어왔기 때문에.
                   comments += "&nbsp; <input type='button' style='color:#555;' class='updateReply-btn' onclick='updateReply(" +'"' + value.rno + '","' + value.replyDate + '","' + value.reply + '","' + value.replyer + '",' + startReply + ',' + replyStep + ")' value='댓글수정' />&nbsp;";
                   comments += "<input type='button' style='color:#555;' class='deleteReply-btn' onclick='deleteReply("  + value.rno +  ',' + startReply + ',' + replyStep +  ")' value='댓글삭제' name='rno' /></li>";
                }
                comments += "<br />";
                comments += "<hr>"
                comments += "<br />";
                indexStore = index+1;
                 }); 
             // 페이지 3개씩 더보기 화면 단 구성 
                if(indexStore >= 2  && indexStore >= (parseInt(startReply) + parseInt(replyStep))-1){     // 나중에 조건 다시 전체값을 가져올 데이터가 필요
                    comments += "<li style='text-align:center;' ><button id='nextReply' data-next='" + (parseInt(startReply) + parseInt(replyStep)) + "'>더보기</button></li>" // 3개씩 추가
                 } 
             
             
             // 만약 댓글이 끝까지 보여질 경우 더보기가 없어져야한다.
          };
          $(".reply-comments").html(comments);

      }
    });
 
}    

//댓글 추가 부분
function addReply() {

   // 댓글을 작성하면 맨 위 화면으로 올리기 위해서.
   let startReply = 1;
   let replyStep = 3;
   
   let reply_bno = $(".reply_bno").val();
   let reply_id = "${sessionScope.nickname}";
   let reply_content = $(".replyContent").val();
   
   let sendData = {"bno":reply_bno, "replyer":reply_id,"reply":reply_content}

   $.ajax({
        url:'insertBoardReply.do',
        type:'POST',
        data: JSON.stringify(sendData),
        dataType: 'text', // String 타입으로 넘어오기 때문에 text로해야한다.
        contentType : 'application/json; charset=UTF-8', //contentType은 보내는 데이터의 타입 예를 들어 mime타입,오디오타입 등 과 같은 형태
        success : function(result){
            getReplyList(startReply, replyStep); // insert한 후 list를 보여주어야 새로고침을 안해도 비동기적으로 바로 보여진다.
            
            // 내용 초기화
            $(".replyContent").val('');

            // total++;
            // if문 제대로 작동을 안함
             if(result =='success'){
               alert("댓글을 입력하셨습니다.");
            } 
            
        } 
    })   
} 



//댓글 삭제 부분
 function deleteReply(reply_rno ,startReply,replyStep){

    let sendData = {"rno" : reply_rno}
   
   $.ajax({
      url: 'deleteBoardReply.do',
      type:'POST',
      data: JSON.stringify(sendData),
      dataType: 'text',
      contentType : 'application/json; charset=UTF-8',
      success: function(result){
         getReplyList(startReply, replyStep/* , total */);
         
         if(result == 'success'){
            alert("댓글을 삭제하셨습니다.");
         }
      }
   })  
}

//댓글 수정 부분
   function updateReply(reply_rno ,reply_replyDate,reply_content, reply_replyer, startReply, replyStep){

    let comments = "";
   comments += "<li><textarea class='reply_control'>" + reply_content + "</textarea> &nbsp;";
   comments += "&nbsp; <input type='button' class='updateComplete' onclick='updateComplete(" + reply_rno + "," + startReply + "," + replyStep + ")' value='수정완료' />&nbsp;";
   comments += "<input type='button' class='updateComplete' onclick='getReplyList("+ startReply + "," + replyStep + ")' value='취소' /></li>"; 
   comments += "<br />";
   
   $(".reply_rno" + reply_rno).html(comments);
//   $(".reply_rno" + reply_rno).replacewith(comments);
   
}
 
  function updateComplete(reply_rno, startReply, replyStep){
   let updateReply = $(".reply_control").val();
     let sendData = {"rno" : reply_rno, "reply" : updateReply};
     
   $.ajax({
      url: "updateBoardReply.do",
      type:'POST',
      data: JSON.stringify(sendData),
      dataType: 'text',
      contentType : 'application/json; charset=UTF-8',
      success: function(){
         getReplyList(parseInt(startReply), parseInt(replyStep));
         alert("댓글을 수정하셨습니다.");
      }
   })
}   
</script>
</head>
<body>
	  <div id="root">
      <div class="content">
        <!-- include header -->
        <%@ include file="includes/header.jsp" %>
        <main class="maincontent">
          <div id="btn_detail">
            <!-- 세션 아이디와 글을 작성한 DB의 id가 같을 시 수정 가능하게 한다. -->
            <c:set var="userid" value="${sessionScope.nickname}" />
            <c:set var="manager" value="${sessionScope.manager}" />
            <c:set var="i" value="2" />
            <a class="insert" href="insertBoard.jsp">게시물 등록</a>
            &nbsp;&nbsp;
            <c:if test="${userid == board.writer or manager == i}">
              <a class="modify" href="modifyBoard.jsp">게시물 수정</a>
              &nbsp;&nbsp;
              <a class="delete" href="deleteBoard.do?bno=${board.bno}">게시물 삭제</a>
            </c:if>
          </div>

          <div id="selectBoard">
            <table id="board_detail">
              <tr class="firstBoard">
                <th colspan="4" class="title">${board.title}</th>
                
              </tr>
              <tr class="secondBoard">
                <th>작성자</th>
                <td colspan="3">${board.writer}</td>
              </tr>
              <tr class="thirdBoard">
                <!-- <th>내용</th> -->
                <td colspan="4">${board.content}<br><br><br><img src="${board.bFile }"></td>
              </tr>
              <tr class="fourthBoard">
                <th>등록일</th>
                <td ><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" /></td>
                <th>조회수</th>
                <td class="cnt">${board.cnt}</td>
              </tr>
            </table>
            <br><br>
            <!-- 댓글 시작 -->
            <div class="reply-box">
              <h3 class="reply-header">댓글</h3>
              <br />
              <br />
              <div class="reply-body">
                  <ul class="reply-comments"></ul>
                  <div class="form-group">
                    <input class ="reply_bno" type="hidden" name="bno" value="${board.bno}" />
                    <input class ="replyer" type="hidden" name="replyer" value="${sessionScope.nickname}" />
                    <br />
                    <br />
                    <textarea class="replyContent" placeholder="댓글을 입력해 주세요." name="content" rows="3" ></textarea>
                  </div>
                  <br />
                  <button type="button" class="insertReply-btn">댓글 작성</button>
                  <!-- 수정 시 댓글 작성이 댓글 수정 완료 버튼으로 바뀐다. -->
                  <input type='hidden' class='updateComplete' value='댓글 수정완료' name='rno' /> <!-- onclick='updateContent()' -->
              </div>
            </div>
            <!-- 댓글 끝 -->
            <a href="getBoardList.do" class="list">글 목록</a>
          </div>
        </main>
        <!-- footer -->
      <%@ include file="includes/footer.jsp" %>
      </div>
      
    </div>
</body>
</html>