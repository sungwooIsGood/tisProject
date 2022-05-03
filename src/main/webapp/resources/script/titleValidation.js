$(function () {

	let imageFileForm = /(.*?)\.(jpg|jpeg|png|gif|bmp|pdf)$/;
	
	$("#submit").on("click", function() {
		// 제목 공백 확인
		if($("#title").val() == ""){
			alert("제목을 입력해 주세요");
			$("#title").focus();
			    return false;
		}
		
		// 시놉시스 공백 확인
		if($("#synopsis").val() == ""){
			alert("시놉시스를 입력해 주세요");
			$("#synopsis").focus();
		    return false;
		}
		
		// 배우 공백 확인
		if($("#actor").val() == ""){
			alert("출연을 입력해 주세요");
			$("#actor").focus();
		    return false;
		}
		
		// 감독 공백 확인
		if($("#director").val() == ""){
			alert("감독를 입력해 주세요");
			$("#director").focus();
		    return false;
		}
		
		// 개봉일자 공백 확인
		if($("#releaseDate").val() == ""){
			alert("개봉일을 입력해 주세요");
			$("#releaseDate").focus();
		    return false;
		}
		
		// 연령제한 선택 확인
		if(!$(".age").is(":checked")){
			alert("연령제한을 선택해 주세요");
		    return false;
		}
		
		// TV, 영화 구분 선택 확인
		if (!$(".series").is(":checked")) {
			alert("TV, 영화 구분을 선택해 주세요");
			return false;
		}
		
		// 장르 선택 확인
		if (!$(".genre").is(":checked")) {
			alert("장르를 선택해 주세요");
			return false;
		}
		
		// 국가 선택 확인
		if (!$(".nation").is(":checked")) {
			alert("국가를 선택해 주세요");
			return false;
		}
		
		// 특징 선택 확인
		if (!$(".point").is(":checked")) {
			alert("특징을 선택해 주세요");
			return false;
		}
		
		// 포스터 이미지 파일 확인
		let posterFile = $("#posterFile").val();
		
		if (posterFile != null && posterFile != "") {
			if (!posterFile.match(imageFileForm)) {
				alert("이미지 파일을 선택해 주세요");
				$("#posterFile").focus();
			    return false;
			}
		}
		
		// 배경 이미지 파일 확인
		let backImgFile = $("#backImgFile").val();
		
		if (backImgFile != null && backImgFile != "") {
			if (!backImgFile.match(imageFileForm)) {
				alert("이미지 파일을 선택해 주세요");
				$("#backImgFile").focus();
			    return false;
			}
		}		
	});
});