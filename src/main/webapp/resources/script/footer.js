$(function(){
	$(".footerPopupBtn").on("click", function() {
		let index = $(this).index();
		let popupIndex = index;
		if (index == 2) {
			popupIndex = 1
		}
		$('html').css("overflow","hidden");
        $(".popup").eq(popupIndex).show();
	});
    $(".popupClose").on("click", popupHide);
    $(".popup").on("click", popupHide);
    $(".popupBox").on("click", function(e) {
        e.stopPropagation();
    });

    function popupHide() {
    	$('html').css("overflow","auto");
        $(".popup").hide();
    }
});