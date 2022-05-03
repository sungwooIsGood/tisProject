package com.tisproject.view.noticeView;

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

import com.tisproject.biz.notice.noticeDto.Criteria;
import com.tisproject.biz.notice.noticeDto.NoticeService;
import com.tisproject.biz.notice.noticeDto.NoticeVO;
import com.tisproject.biz.notice.noticeDto.PageDTO;
import com.tisproject.utils.UploadFileUtils;

@Controller
@SessionAttributes("notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
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
	@RequestMapping(value="/insertNotice.do")
	public String insertNotice(NoticeVO vo) throws IllegalStateException, IOException {
		System.out.println("글 등록 처리");
		
		String noticeUploadPath = uploadPath + File.separator + 
				"upload" + File.separator + "noticeUpload";
		String noticeYmdPath = UploadFileUtils.calcPath(noticeUploadPath);
		String fileName = null;
		String nFile = null;
		
		MultipartFile uploadFile = vo.getNoticeFile();
		
		if(!uploadFile.isEmpty()) {
			try {
				fileName = UploadFileUtils.fileUpload(noticeUploadPath, uploadFile.getOriginalFilename(),
						   uploadFile.getBytes(), noticeYmdPath);
				System.out.println(fileName.toString());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			nFile = "resources" + File.separator + "upload" + File.separator +
					"noticeUpload" + noticeYmdPath + File.separator + fileName;
		}else {
			nFile = null;
		}
		
		vo.setnFile(nFile);
		
		noticeService.insertNotice(vo);
		return "redirect:getNoticeList.do";
	}
	
	// 글 수정
	@RequestMapping("/modifyNotice.do")
	public String updateNotice(NoticeVO vo, Model model) {
		System.out.println("공지사항 수정");
		
		String noticeUploadPath = uploadPath + File.separator + 
				"upload" + File.separator + "noticeUpload";
		String noticeYmdPath = UploadFileUtils.calcPath(noticeUploadPath);
		String fileName = null;
		String nFile = null;
		
		MultipartFile uploadFile = vo.getNoticeFile();
		
		String beforeNoticeUpload = noticeService.getNotice(vo).getnFile();
		String beforeNoticeUploadPath = null;
		
		if(beforeNoticeUpload != null) {
			beforeNoticeUploadPath = realPath + beforeNoticeUpload;
		}
		
		if(!uploadFile.isEmpty()) {
			try {
				fileName = UploadFileUtils.fileUpload(noticeUploadPath, uploadFile.getOriginalFilename(),
						   uploadFile.getBytes(), noticeYmdPath);
				System.out.println(fileName.toString());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(beforeNoticeUploadPath != null) {
				File deleteFile = new File(beforeNoticeUploadPath);
				
				if(deleteFile.exists()) {
					deleteFile.delete();
				}
			}
			
			nFile = "resources" + File.separator + "upload" + File.separator +
					"noticeUpload" + noticeYmdPath + File.separator + fileName;
		}else {
			nFile = beforeNoticeUpload;
		}
		
		vo.setnFile(nFile);
		
		model.addAttribute("notice", noticeService.modifyNotice(vo));
		return "redirect:getNoticeList.do";
	}

	// 글 상세 조회
	@RequestMapping("/getNotice.do")
	public String getNotice(NoticeVO vo, Model model) {
		model.addAttribute("notice", noticeService.getNotice(vo));
		return "getNotice";
	}
	
	// 글 삭제
	@RequestMapping("/deleteNotice.do")
	public String deleteNotice(NoticeVO vo) {
		
		noticeService.deleteNotice(vo);
		return "redirect:getNoticeList.do";
	}
	
	
	// 글 목록 검색
//	@RequestMapping("/getNoticeList.do")
//	public String getNoticeList(NoticeVO vo/* ,BoardDAO boardDAO */, Model model/*ModelAndView mav*/) {
//		
//		model.addAttribute("noticeList", noticeService.getNoticeList(vo) /* boardDAO.getBoardList(vo) */);
//		return "getNoticeList";
//	}
	
	// 페이징 처리된 글 목록
	@RequestMapping("/getNoticeList.do")
	public String getNoticeList(Criteria cri, Model model) {
		
		model.addAttribute("noticeList", noticeService.getList(cri) );
		model.addAttribute("pageMaker", new PageDTO(cri, noticeService.getTotal(cri))); 
		return "getNoticeList";
	}
	
	
	// 공지사항 최신 글 새창 띄우기
	@RequestMapping("/getNoticeWindow.do")
	public String windowNotice(NoticeVO vo, Model model) {
		model.addAttribute("notice", noticeService.getNoticeWindow(vo));
		return "getNoticeWindow";
	}

}
