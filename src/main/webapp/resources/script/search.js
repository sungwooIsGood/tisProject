$(document).ready(function() {
   $('ul.tabs li').click(function() {
      var tab_id = $(this).attr('data-tab');

      $('ul.tabs li').removeClass('current');
      $('.tab-content').removeClass('current');

      $(this).addClass('current');
      $("#" + tab_id).addClass('current');
   })
})

// 검색하는 곳에 공란으로 두고 검색을 누를 경우
function checkSearch() {
   let formController = $(".form-control").val();

   if (formController == "") {
      alert("다시 작성해주세요.");
      return false;
   }
}