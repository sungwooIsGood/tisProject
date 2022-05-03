$(function() {
    $(".openList").on("click", function() {
    	$(".menubar").stop().animate({
    		left: 0
    	}, 500);
    });
    
    $(".menubarClose").on("click", function() {
    	$(".menubar").stop().animate({
    		left: "-500px"
    	}, 500);
    });
});

