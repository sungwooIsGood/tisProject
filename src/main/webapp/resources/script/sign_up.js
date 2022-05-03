//비밀번호 확인
var password;
var password2;
var checkid = 0;
var checknick = 0;

   $('#password').on("propertychange change keyup paste input", function(){
      password = $(this).val();
      console.log(password);
   })
   
   
   $('#passwordChk').on("propertychange change keyup paste input", function(){
      password2 = $(this).val();
      console.log(password2);
   
      if(password != password2){
    	//입력해야됨 
      }

   });
   function pawclick(){
		if(password!=password2){
			alert("비밀번호가 일치하지 않습니다.");
			return false;
			
		}
	}

//체크박스 선택
	$(document).ready(function() {
    	$("#check_all").click(function() {
    		if($("#check_all").is(":checked")) $("input[name=check]").prop("checked", true);
    		else $("input[name=check]").prop("checked", false);
    	});

    	$("input[name=check]").click(function() {
    		var total = $("input[name=check]").length;
    		var checked = $("input[name=check]:checked").length;

    		if(total != checked) $("#check_all").prop("checked", false);
    		else $("#check_all").prop("checked", true); 
    	});
    });
   
	



//유효성
   /* $(document).ready(function(){
		$("#clifrm").on("click", */
	function pawcheck(){
			if($("#nickname").val()==""){
				alert("닉네임을 입력해주세요.");
				$("#nickname").focus();
				return false;
			}
			if($("#userId").val()==""){
				alert("아이디를 입력해주세요.");
				$("#userId").focus();
				return false;
			}
			if($("#email").val()==""){
				alert("이메일을 입력해주세요.");
				$("#email").focus();
				return false;
			}
			if($("#password").val()==""){
				alert("비밀번호를 입력해주세요.");
				$("#password").focus();
				return false;
			}
			if($("#passwordChk").val()==""){
				alert("비밀번호를 확인해주세요.");
				$("#password").focus();
				return false;
			}
			if($("#birthday").val()==""){
				alert("생일을 입력해주세요.");
				$("#birthday").focus();
				return false;
			}
			
			//성별 유효성
				if (!genderm.checked && !genderf.checked){
					alert("성별을 체크해주세요.");
					return false;
				}
				
				
//장르 유효성 검사 ID 추가하면 작성			
//				if($("#아이디값").val() == ""){
//				    alert("경고창입니다.");
//				    $("#아이디값").focus();
//				    return false;
//				}
			
			
//			var nameCheckResult = $("#nameCheck").val();
//			if(nameCheckResult == "1"){
//				alert("닉네임 중복확인 버튼을 눌러주세요.");
//				return false;
//			}else{
//				$("#regForm").submit();
//
//			}
//				if($("#nameCheck").val()==""){
//					alert("닉네임 중복확인 버튼을 눌러주세요.");
//					$("#nameCheck").focus();
//					return false;
//				}
				

				//$("input[name=nameCheckResult]").val('0');
				 
				 if(checknick==0){
				        alert('닉네임 중복 확인을 해주세요.');
				        $("input[name='nameCheckResult']").focus();
				        return false;
				    	}
				 
				 if(checkid==0){
				        alert('아이디 중복 확인을 해주세요.');
				        $("input[name='idCheckResult']").focus();
				        return false;
				    	}
			
		
				if(password!=password2){
					alert("비밀번호가 일치하지 않습니다.");
					return false;
				}
				
			
			//체크박스 필수
//			if($("#check2").is(":checked")){
//	               console.log("첫번째 통과");
//	           } else { 
//	               alert("왓챠피디아 서비스 이용약관에 동의 해주세요.")
//	               return false;
//	           }
			if (!$("input:checked[id='check2']").is(":checked")){
				alert("왓챠피디아 서비스 이용약관에 동의 해주세요."); 
				return false; 
				}

			if($("#check3").is(":checked")){
				console.log("두번째 통과");
	           } else { 
	               alert("왓챠 서비스 이용약관에 동의 해주세요.")
	               return false;
	           }
			if($("#check4").is(":checked")){
				console.log("세번째 통과");
	           } else { 
	               alert("개인정보 수집 및 이용에 대한 안내에 동의 해주세요.")
	               return false;
	           }
			var genre1 = document.getElementById("favorite_genre1");
			var genre2 = document.getElementById("favorite_genre2");
			var genre3 = document.getElementById("favorite_genre3");
			
			genre11 = genre1.options[genre1.selectedIndex].value;
			genre22 = genre1.options[genre2.selectedIndex].value;
			genre33 = genre1.options[genre3.selectedIndex].value;
			
			if(genre11 == null || genre22 == null || genre33 == null){
				alert("선택되지 않은 장르가 있습니다. 장르를 3개를 선택해 주세요!");
				return false;
			
			}else if(genre11 == genre22 || genre11 == genre33 || genre22 == genre33){
				alert("중복된 장르가 있습니다.");
				return false;
			
			}

			
			
			document.getElementById('regForm').submit();
	}
	
			
/*		});*/

		
		
		
		//이름 중복  (아이디 중복일 경우 = 1 , 중복이 아닐경우 = 0)
		$("#nameCheck").click(function() {
			
			if($("#nickname").val()==""){
				alert("닉네임을 입력해주세요.");
				$("#nickname").focus();
				return false;
			}
			
			var result = 0; 
			var nickname =  $("#nickname").val(); 
			var param = {"nickname": nickname};
			
			console.log(nickname);
			
			$.ajax({
				type : "POST",
				url : "/nameCheck.do",
				contentType:"application/json; charset=utf-8",
				dataType : "json",
				data :  JSON.stringify(param),
				success : function(data){
					if(data.result == 0){ 
						alert("사용가능한 닉네임입니다.");
						console.log("노중복");
						checknick = 1;
					}else{
						alert("중복된 닉네임입니다.");
						console.log("중복");
						return false;
					}
				},
	            error:function(){
	                alert("에러");
	            }
			});
		});
		
		
		//아이디 중복
		$("#idCheck").click(function() {
			
			if($("#userId").val()==""){
				alert("아이디를 입력해주세요.");
				$("#userId").focus();
				return false;
			}
			
			var result = 0;
			var userId =  $("#userId").val(); 
			var param = {"userid": userId};
			
			console.log(userId);
			
			$.ajax({
				type : "POST",
				url : "/idCheck.do",
				contentType:"application/json; charset=utf-8",
				dataType : "json",
				data :  JSON.stringify(param),
				success : function(data){
					if(data.result == 0){
						alert("사용가능한 아이디입니다.");
						console.log("노중복");
						checkid = 1;
					}else {
						alert("중복된 아이디입니다.");
						console.log("중복");	
						return false;
					}
				}
			});
		});
		
	
	


	
		
	
	 /* function clifrm(){
	document.getElementById('regForm').submit();
} 	*/
