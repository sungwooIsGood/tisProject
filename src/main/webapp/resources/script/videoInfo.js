$(function() {
	// 탭 메뉴
    $(".buttonList li").on("click", function() {	
    	let index = $(this).index();
        $(this).addClass("on").siblings().removeClass("on");
        $(".selectBox").eq(index).show().siblings(".selectBox").hide();
    });
    
    // 별점 평가
    let firstWidth = $(".emptyStar").width();
    $(".starBoxIn").width(firstWidth);
    
    let userGrade = $("#userGrade").val()
    let star = userGrade * 20;
    let saveStar = star;
    
    let gradeWordArray = [
    	"이미 본 작품인가요?", "최악이에요!", "싫어요", "재미없어요",
    	"별로에요", "부족해요", "보통이에요", "볼만해요",
    	"재미있어요", "훌륭해요", "최고에요!"
    ];
    
    
    $(".starBoxIn").on({
    	"mousemove" :function(e){
    		let parentOffset = $(this).parent().offset();
			let relX = e.pageX - parentOffset.left;
			
			let parentWidth = $(".emptyStar").width();
			let starWidth = parentWidth/10;
			
			$(".starBoxIn").width(parentWidth);
			
			for (let i=0; i<10; i++) {
				let startStar = i * starWidth;
				let endStar = (i+1) * starWidth;
				if (relX >= startStar && relX < endStar) {
					star = (i+1) * 10;
				}
			}
			
			starChange(star);
    	},
    	"mouseleave" : function() {
    		star = saveStar;
    		starChange(star);
    	},
    	
    	"click" : function() {
    		saveStar = star;
    		titleNo = $("#titleNo").val();
    		userNo = $("#userNo").val();
    		grade = saveStar/20;
    		param = {"grade":grade, "titleNo":titleNo, "userNo":userNo};
    		
    		
    		$.ajax({
    			type: "POST",
    			data: JSON.stringify(param),
                url: `userSetGrade.do`,
                contentType:"application/json; charset=utf-8",  
                dataType:"json",
                success: function(data) {
                    gradeAvg = data.gradeAvg;
                    $(".avgGradeRight").text(gradeAvg);
                    
                },
                error: function() {
                    alert("통신 에러");
                }
    		});
    	}
    });
    
    function starChange(reciveStar) {
    	gradeWordIndex = reciveStar/10;
		$(".setGradeWord").text(gradeWordArray[gradeWordIndex]);
		$(".fullStar").width(reciveStar+"%");
    }
    
    starChange(star);
    
    // 슬라이더
    let videoTotalNum = $(".episodeList li").length;
    let slideTotalNum = 0;
    
    if (videoTotalNum % 4 == 0) {
    	slideTotalNum = videoTotalNum / 4;
    } else {
    	slideTotalNum = Math.floor(videoTotalNum / 4) + 1;
    }
    
    if (slideTotalNum == 1) {
    	$(".slideNext").hide();
    }
    
    let slideNowNum = 0;
    
    let slideWidth = $(".episodeList li").width() * 4;
    
    $(".slidePrev").on("click", slideSub);
    $(".slideNext").on("click", slideAdd);
    
    function slideSub() {
    	slideNowNum--;
    	if (slideNowNum <= 0) $(".slidePrev").hide();
    	$(".slideNext").show();
    	slideVideo();
    }
    
    function slideAdd() {
    	slideNowNum++;
    	if (slideNowNum >= slideTotalNum - 1) $(".slideNext").hide();
    	$(".slidePrev").show();
    	slideVideo();
    	
    	console.log(slideNowNum);
    	console.log(slideTotalNum);
    }
    
    function slideVideo() {
    	let moveSlide = -slideWidth * slideNowNum;
    	$(".episodeList").stop().animate({left: moveSlide}, 1000, "swing");
    }
    
    // 배경화면
    let backImg = $("#backImg").val();
    
    if (backImg == null || backImg == "") {
    	backImg = "resources\\img\\noImage.jpg";
    }
    
    let backImgReplace = backImg.replaceAll("\\","\\\\");
    $(".backImgBox").css({"background":"linear-gradient(to left, rgba(0, 0, 0, 0) 10%, rgba(0, 0, 0, 0.5) 25%, rgba(0, 0, 0, 1) 50%, rgba(0, 0, 0, 1) 75%, rgba(0, 0, 0, 1) 100%), url('"+ backImgReplace +"')",
    	"background-size": "cover"});
    
    // 현재 url 복사
    $(".shareBtn").on("click", function() {
    	let nowUrl = $(location).attr('href');
    	
    	let url = document.createElement("textarea");
        document.body.appendChild(url);
        url.value = nowUrl;
        url.select();
        document.execCommand('copy');
        document.body.removeChild(url);
        
        alert("주소가 복사되었습니다.");
    });
});

//보관함 추가(신동인)
$(".myListBtn").on("click", function(){
	let locker = $('#titleNo').val();
	
	$.ajax({
		url:"locker.do",
		type:"POST",
		data:{"locker":locker}
	});
	
	alert("내 보관함에 저장되었습니다.");
});

//신동인 결제유저 검사
$('.play a').on("click", function(){
	let rank = $('#rank').val();
	console.log(rank);
	
	if(rank != 1){
		alert("이용하실수 없는 컨텐츠입니다. 결제 후 이용해주세요")
		return false;
	}
})

