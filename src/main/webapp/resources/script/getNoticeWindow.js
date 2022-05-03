//쿠키설정    
function setCookie( name, value, expiredays ) {
	var todayDate = new Date();
	todayDate.setDate( todayDate.getDate() + expiredays );
	document.cookie = name + '=' + escape( value ) + '; path=/; expires=' + todayDate.toGMTString() + ';'
}

function closeWin(){
	setCookie("close9999","close9999",1);
	window.close();
}

//그냥 닫기
var btn1;
window.onload = function(){
    btn1 = window.document.form1.btn1;
    
    btn1.onclick = function(){
        window.close();
    };
};