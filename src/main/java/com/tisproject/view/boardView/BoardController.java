package com.tisproject.view.boardView;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.tisproject.biz.board.boardDto.BoardService;
import com.tisproject.biz.board.boardDto.BoardVO;
import com.tisproject.biz.board.boardDto.Criteria;
import com.tisproject.biz.board.boardDto.PageDTO;
import com.tisproject.utils.UploadFileUtils;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	// 각자 경로 수정
	private String realPath = "C:\\tisProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\tisproject4_1\\";
	
	//검색 조건 목록 항목 설정
	@ModelAttribute("conditionMap")
	public Map<String ,String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String,String>();
		conditionMap.put("제목","TITLE");
		conditionMap.put("내용","CONTENT");
		return conditionMap;
	}
//======================================================================================================	
			
	// 글 등록	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, Model model) {
		System.out.println("글 등록 처리");
		
		String boardUploadPath = uploadPath + File.separator + 
				"upload" + File.separator + "boardUpload";
		String boardYmdPath = UploadFileUtils.calcPath(boardUploadPath);
		String fileName = null;
		String bFile = null;
		
		MultipartFile uploadFile = vo.getBoardFile();
		
		if(!uploadFile.isEmpty()) {
			try {
				fileName = UploadFileUtils.fileUpload(boardUploadPath, uploadFile.getOriginalFilename(),
						   uploadFile.getBytes(), boardYmdPath);
				System.out.println(fileName.toString());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			bFile = "resources" + File.separator + "upload" + File.separator +
					"boardUpload" + boardYmdPath + File.separator + fileName;
		}else {
			bFile = null;
		}
		
		vo.setbFile(bFile);
		
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/modifyBoard.do")
	public String updateBoard(BoardVO vo, Model model) {
		System.out.println("게시물 수정");
		
		String boardUploadPath = uploadPath + File.separator + 
				"upload" + File.separator + "boardUpload";
		String boardYmdPath = UploadFileUtils.calcPath(boardUploadPath);
		String fileName = null;
		String bFile = null;
		
		MultipartFile uploadFile = vo.getBoardFile();
		
		String beforeBoardUpload = boardService.getBoard(vo).getbFile();
		String beforeBoardUploadPath = null;
		
		if(beforeBoardUpload != null) {
			beforeBoardUploadPath = realPath + beforeBoardUpload;
		}
		
		if(!uploadFile.isEmpty()) {
			try {
				fileName = UploadFileUtils.fileUpload(boardUploadPath, uploadFile.getOriginalFilename(),
						   uploadFile.getBytes(), boardYmdPath);
				System.out.println(fileName.toString());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(beforeBoardUploadPath != null) {
				File deleteFile = new File(beforeBoardUploadPath);
				
				if(deleteFile.exists()) {
					deleteFile.delete();
				}
			}
			
			bFile = "resources" + File.separator + "upload" + File.separator +
					"boardUpload" + boardYmdPath + File.separator + fileName;
		}else {
			bFile = beforeBoardUpload;
		}
		
		vo.setbFile(bFile);
		
		model.addAttribute("board", boardService.modifyBoard(vo));
		return "redirect:getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard";
	}	
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	
//	// 글 목록 검색
//	@RequestMapping("/getBoardList.do")
//	public String getBoardList(BoardVO vo, Model model) {
//		model.addAttribute("boardList", boardService.getBoardList(vo));
//		return "getBoardList";
//	}
	
	// 페이징 처리된 글 목록
	@RequestMapping("/getBoardList.do")
	public String getBoardList(Criteria cri, Model model) {
		
		model.addAttribute("boardList", boardService.getList(cri) );
		model.addAttribute("pageMaker", new PageDTO(cri, boardService.getTotal(cri))); 
		return "getBoardList";
	}
	

}
