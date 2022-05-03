
		var vopassword = $('#userpassword').val();
		var password;
		var password1;
		var password2;

	$('#passwordinput').on("propertychange change keyup paste input", function(){
		password = $(this).val();

		
		if(password!=vopassword){
			document.querySelector("#passwordinput").className="updateinputNo";
		}else if(password==vopassword){
			document.querySelector("#passwordinput").className="updateinput";
		}
	})
		
	$('#password1').on("propertychange change keyup paste input", function(){
		password1 = $(this).val();	
	});
	$('#password2').on("propertychange change keyup paste input", function(){
		password2 = $(this).val();
		
		if(password1!=password2){
			document.querySelector("#password2").className="updateinputNo";
		}else if(password1==password2){
			document.querySelector("#password2").className="updateinput";
		}	
	});


    function leavepop(){
        window.open("leavepop.do","leavepop","width=400,height=341px,top=10,left=10");
    }
	
	function pawclick(){
		if(vopassword!=password){
			alert("기존 비밀번호가 일치하지 않습니다.");
			return false;
		}else if(password1!=password2){
			alert("변경된 비밀번호가 일치하지 않습니다.");
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
		
		alert("개인정보 수정이 완료되었습니다.")
		console.log(genre1);
		
	
		
	}
