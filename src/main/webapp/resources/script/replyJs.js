// 댓글 리스트 보기
   $(document).ready(function(){
         
      let startReply = 1; // 댓글 초기값 -> BoardReplyVO의 endReply를 알기 위해서 필요
      let replyStep = 3; // 3개씩 로딩
//      let total = $(".replyCount").val();
      
      getReplyList(startReply, replyStep/* , total */); // 자동 실행 되면 최초 3개

   
      
     $(document).on("click",'#nextReply',function(){ // 동적으로 생긴 버튼이 있을 경우 사용. => $('#nextReply').on클릭은 실행안됨
         startReply = $(this).attr("data-next"); // attr()이 속성 하나면 값불러오기.
/*           if(startReply > ) 
         //$(this).remove(); */
         
         getReplyList(startReply, replyStep);
      })  
      
      $('.insertReply-btn').on("click",addReply);
   });

   function getReplyList(startReply, replyStep){
      
      let reply_bno = $(".reply_bno").val(); // $.ajax()안에 data안에 넣어도 됨 클라이언트 -> 서버로 보내는 것
      
      let sendBno = {"bno": reply_bno, "startReply": startReply, "replyStep" : replyStep} // 키값인 "bno"와 VO 객체 필드명이 같아야 값을 가져온다.
      
      // 수정해봄
      let reply_id = "${sessionScope.nickname}";
     /* let reply_id = $(".replyer");*/
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
//            let replyData = JSON.stringify(result); // String 형식의 json타입으로 변환
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
                      comments += "&nbsp; <input type='button' class='updateReply-btn' onclick='updateReply(" +'"' + value.rno + '","' + value.replyDate + '","' + value.reply + '","' + value.replyer + '",' + startReply + ',' + replyStep + ")' value='댓글수정' />&nbsp;";
                      comments += "<input type='button' class='deleteReply-btn' onclick='deleteReply("  + value.rno +  ',' + startReply + ',' + replyStep +  ")' value='댓글삭제' name='rno' /></li>";
                   }
                   comments += "<br />";
                    comments += "<hr>"
                     comments += "<br />";
                     indexStore = index+1;
                    }); 
                // 페이지 3개씩 더보기 화면 단 구성 
                   if(indexStore >= 2  && indexStore >= (parseInt(startReply) + parseInt(replyStep))-1){     // 나중에 조건 다시 전체값을 가져올 데이터가 필요
                       comments += "<li style='text-align:center; border-color:blue; border:0.5px solid;' ><button id='nextReply' data-next='" + (parseInt(startReply) + parseInt(replyStep)) + "'>더보기</button></li>" // 3개씩 추가
                    } 
                
                
                // 만약 댓글이 끝까지 보여질 경우 더보기가 없어져야한다.
             };
             $(".reply-comments").html(comments);

         }
       });
    
   }    

// 댓글 추가 부분
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
   
   
   
// 댓글 삭제 부분
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
   
// 댓글 수정 부분
      function updateReply(reply_rno ,reply_replyDate,reply_content, reply_replyer, startReply, replyStep){

       let comments = "";
      comments += "<li><textarea class='reply_control'>" + reply_content + "</textarea> &nbsp;";
      comments += "&nbsp; <input type='button' class='updateComplete' onclick='updateComplete(" + reply_rno + "," + startReply + "," + replyStep + ")' value='수정완료' />&nbsp;";
      comments += "<input type='button' class='updateComplete' onclick='getReplyList("+ startReply + "," + replyStep + ")' value='취소' /></li>"; 
      comments += "<br />";
      
      $(".reply_rno" + reply_rno).html(comments);
//      $(".reply_rno" + reply_rno).replacewith(comments);
      
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