$(function() {
    $(".category li").on("click", function() {
    	let index = $(this).index();
    	
    	$(this).siblings().removeClass("on");
    	$(this).addClass("on")
    	
    	$(".selectContent > li").eq(index).show().siblings(".mainContent").hide();
    });
});