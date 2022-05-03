package com.tisproject.view.email;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tisproject.biz.email.EmailSender;
import com.tisproject.biz.email.EmailVO;
import com.tisproject.biz.user.DTO.UserVO;
import com.tisproject.biz.user.Service.UserService;

@Controller
public class EmailController {

	@Autowired
	private EmailSender emailSender;
	@Autowired
	private EmailVO email;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/sendEmail.do",
	produces = "application/json",
	method=RequestMethod.POST)
	@ResponseBody
	public String sendEamilAction(@RequestBody UserVO user) throws Exception {

		String receiver = "";
		String subject = "";
		String content = "";
		
		// DB에 이메일 혹은 아이디 정보가 없어, NullPointException 발생 시 처리하기 위한 구문
	    try {
	    	UserVO userEmail = userService.sendEmail(user);
	        receiver = userEmail.getEmail();
	        System.out.println(String.valueOf(receiver));
		} catch (NullPointerException e) {
			return "fail";
		} 	
        
//      자바 난수 6자리 부여
        Random random = new Random(); // 랜덤함수 선언
        int createNum = 0; // 1자리 난수
        String ranNum = ""; // createNum을 형변환 하려고 만든 변수
        int letter = 6; // 6자리 난수
        String resultNum = ""; // 결과 난수
        
        for(int i = 0; i < letter; i++) {
        	createNum = random.nextInt(9); // int형 난수 반환,  0~9까지 올 수 있는 1자리 난수 생성 
        	ranNum = Integer.toString(createNum); // String타입으로 형변환
        	resultNum += ranNum;
        }
		subject = "왓챠 임시 비밀번호 발송";
        content = receiver + " 회원님의 임시 비밀번호는" + resultNum + "입니다.";
        
//      DB에 임시 비밀번호 저장
        user.setPassword(resultNum);
        userService.changePassword(user);
        
//		EmailSender로 해당 내용 보내기
        email.setReceiver(receiver);
        email.setSubject(subject);
        email.setContent(content);
        emailSender.sendEmail(email);
        
        System.out.println("이메일 전송 성공");

        return "success"; // 임의 로 result.jsp로 보낸 것
		
	}

}
