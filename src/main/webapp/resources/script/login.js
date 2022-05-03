function getCookie( cookieName ) {
	var search = cookieName + "=";
	var cookie = document.cookie;
	
	/* 현재 쿠키가 존재할 경우 */
	if( cookie.length > 0 ) {
		/* 해당 쿠키명이 존재하는지 검색한 후 존재하면 위치를 리턴. */
		startIndex = cookie.indexOf( cookieName );
		/* 만약 존재한다면 */
		if( startIndex != -1 ) {
			/* 값을 얻어내기 위해 시작 인덱스 조절 */
			startIndex += cookieName.length;
			/* 값을 얻어내기 위해 종료 인덱스 추출 */
			endIndex = cookie.indexOf( ";", startIndex );
			/* 만약 종료 인덱스를 못찾게 되면 쿠키 전체길이로 설정 */
			if( endIndex == -1) endIndex = cookie.length;
			/* 쿠키값을 추출하여 리턴 */
			return unescape( cookie.substring( startIndex + 1, endIndex ) );
		} else {
			/* 쿠키 내에 해당 쿠키가 존재하지 않을 경우 */
			return false;
		}
	} else {
		/* 쿠키 자체가 없을 경우 */
		return false;
	}
} 

if( !getCookie("close9999") ){
	var btn1;
    window.onload = function(){
        btn1 = window.document.form1.btn1;
        
        btn1.onclick=function(){
            child = window.open("getNoticeWindow.do","child","width=617,height=650");
        };
    };
}