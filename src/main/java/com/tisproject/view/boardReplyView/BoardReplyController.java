package com.tisproject.view.boardReplyView;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tisproject.biz.boardReply.boardDto.BoardReplyService;
import com.tisproject.biz.boardReply.boardDto.BoardReplyVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class BoardReplyController {

	private BoardReplyService boardReplyService;

	// 게시판 댓글 기능 안성우 담당
	// 댓글 리스트보기
	@RequestMapping(value="/getBoardReplyList.do",
			produces = "application/json",
			method=RequestMethod.POST)
	@ResponseBody
	// ReponseBody를 쓰면 비동기 통신이 가능 하다. 자바 객체를 HTTP 요청의 body 내용으로 매핑하는 역할
	// jsp페이지로 보내 주는 것이 아닌 작성한 내용으로 매핑되어지는 것.
	public List<BoardReplyVO> getBoardReplyList(@RequestBody BoardReplyVO vo){ // vo에 bno, startReply, replyStep값이 들어 간것
		// mapping 전체리스트 갯수와 페이징을 위한 mapping 두개 가져오기
		// 더보기를 누를 시 3개씩 가져오기 위해서
		int setStartReply = vo.getStartReply() + vo.getReplyStep() - 1; 

		vo.setSetStartReply(setStartReply);
		System.out.println(vo);

		System.out.println("setStartReply: " + setStartReply);

		
		System.out.println("ajax 통신완료");
		System.out.println("getBoardReplyList: " + vo);

		List<BoardReplyVO> list = boardReplyService.getBoardReplyList(vo);		

		return list;// ResponseBody는 post방식에유리 body에 붙어서 가기 때문에. url에 정보가 있는 get은 비추천
	}
	
	
	// 댓글 등록
	@RequestMapping(value="/insertBoardReply.do",
	produces = "application/json",
	method=RequestMethod.POST)
	@ResponseBody
	public String insertBoardReply(@RequestBody BoardReplyVO vo) {

		boardReplyService.insertBoardReply(vo);
		System.out.println("insert ajax통신완료");
		return "success";
	}
	
	
	// 댓글 삭제
	@PostMapping("/deleteBoardReply.do")
	@ResponseBody
	public String deleteBoardReply(@RequestBody BoardReplyVO vo) {
		
		boardReplyService.deleteBoardReply(vo);
		System.out.println("delete ajax통신완료");
		return "success";
		
	}
	
	
	// 댓글 수정
	@PostMapping("/updateBoardReply.do")
	@ResponseBody
	public String updateBoardReply(@RequestBody BoardReplyVO vo) {
		System.out.println("update ajax통신완료");
		boardReplyService.updateBoardReply(vo);
		System.out.println(vo);
		return "success";
	}
}
