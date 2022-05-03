$(function(){
	$(".searchSelect").select2();
	
	let imageFileForm = /(.*?)\.(jpg|jpeg|png|gif|bmp|pdf)$/;
	let videoFileForm = /(.*?)\.(mp4|m4v|avi|wmv|mwa|asf|mpg|mpeg|mkv|mov|3gp|3g2|webm)$/;
	let numberCheck = /^[0-9]+$/; 
	
	$("#submit").on("click", function() {
		// 타이틀 번호 확인
		if($("#titleNo").val() == ""){
			alert("타이틀을 선택해 주세요");
			$("#titleNo").focus();
			return false;
		}
		
		// 타이틀 번호 확인
		if($("#titleNo").val() == ""){
			alert("타이틀을 선택해 주세요");
			$("#titleNo").focus();
			return false;
		}
		
		// 제목 확인
		if($("#videoTitle").val() == ""){
			alert("에피소드 제목을 입력해 주세요");
			$("#videoTitle").focus();
			return false;
		}
		
		// 에피소드 화수 확인
		if($("#episodeNoCheck").val() != 1){
			alert("에피소드 화수를 중복체크 해주세요");
			$("#videoEpisodeNo").focus();
			return false;
		}	
		
		// 영상 썸네일 파일 확인
		let videoThumbnailFile = $("#videoThumbnailFile").val();
		
		if (videoThumbnailFile != null && videoThumbnailFile != "") {
			if (!videoThumbnailFile.match(imageFileForm)) {
				alert("이미지 파일을 선택해 주세요");
				$("#videoThumbnailFile").focus();
			    return false;
			}
		}
		
		// 영상 파일 확인
		let videoFile = $("#videoFile").val();
		
		if (videoFile != null && videoFile != "") {
			if (!videoFile.match(videoFileForm)) {
				alert("동영상 파일을 선택해 주세요");
				$("#videoFile").focus();
			    return false;
			}
		}
	});
	
	$("#episodeNoCheckButton").on("click", function() {
		
		// 에피소드 화수 확인
		if($("#videoEpisodeNo").val() == ""){
			alert("에피소드 화수를 입력해 주세요");
			$("#videoEpisodeNo").focus();
			$("#episodeNoCheck").val(0);
			return false;
		}
		
		// 에피소드 화수 숫자 확인
		if(!$("#videoEpisodeNo").val().match(numberCheck)){
			alert("에피소드 화수는 숫자만 입력 가능합니다.");
			$("#videoEpisodeNo").focus();
			$("#episodeNoCheck").val(0);
			return false;
		} 
		
		// 에피소드 화수 중복 확인
		let videoNo = $("#videoNo").val();
		
		if (videoNo == undefined) {
			videoNo = 0;
		}
		
		let titleNo = $("#titleNo").val();
		let videoEpisodeNo = $("#videoEpisodeNo").val();
		let episodeNoCheckResult = 0;
		
		let param = {"videoNo":videoNo, "titleNo":titleNo, "videoEpisodeNo":videoEpisodeNo};
		
		$.ajax({
			type: "POST",
			data: JSON.stringify(param),
            url: `episodeNoCheck.do`,
            contentType:"application/json; charset=utf-8",  
            dataType:"json",
            success: function(data) {
            	episodeNoCheckResult = data.result;
            	
            	if (episodeNoCheckResult == 0 ) {
        			alert("에피소드 화수는 중복되지 않은 숫자만 입력 가능합니다.");
        			$("#episodeNoCheck").val(0);
        			$("#videoEpisodeNo").focus();
        		}
            	
            	if (episodeNoCheckResult == 1) {
            		alert("입력할 수 있는 화수 입니다.");
            		$("#episodeNoCheck").val(1);
            		$("#episodeNoCheckButton").text("중복체크 완료");
            		$("#episodeNoCheckButton").addClass("complete");
            	}
            },
            error: function() {
                alert("통신 에러");
            }
		});
	});
	
	$("#videoEpisodeNo").on("propertychange change keyup paste input", function() {
		$("#episodeNoCheck").val(0);
		$("#episodeNoCheckButton").text("중복체크");
		$("#episodeNoCheckButton").removeClass("complete");
	});
	
	$("#videoForm").submit(function (){
		$(".loadingImageBackground").show();
	});
});