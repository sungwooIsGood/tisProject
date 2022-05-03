<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="resources/css/style.css?after"> 
	<script src="resources/script/jquery.min.js"></script>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        .maincontent{
            text-align:center;
        }
        p{
            margin:0;
            padding-top:30px;
            color:white;

        }
    </style>

    </head>
    <body>
        <div id = "root">
            <div class="maincontent">
                <p>회원탈퇴 사유를 적어주세요</p><br>
				
                <textarea id="reason" name="leavereason" cols="35" rows="15" maxlength="200" width="230px" height="90px"
                 placeholder="탈퇴 사유를 적어주세요(최대 200자까지 입력 가능합니다.)"></textarea>

                <input type="submit" onClick="leaveDo()" value="탈퇴">
			
            </div>
        </div>

<script>
    function leaveDo(){
	let reason = document.getElementById('reason').value;
	console.log(reason);
    		$.ajax({
    			url: "reason.do",
    			type:"POST",
    			data:{"reason":reason},
    			
    	});
    		setTimeout(function(){
				window.opener.location.href="/leave.do";
				window.close(); 
    	},100);	
   }

</script>
</body>

</html>