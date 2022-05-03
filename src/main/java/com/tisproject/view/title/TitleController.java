package com.tisproject.view.title;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.tisproject.biz.grade.GradeService;
import com.tisproject.biz.grade.GradeVO;
import com.tisproject.biz.item.ItemService;
import com.tisproject.biz.item.ItemVO;
import com.tisproject.biz.title.TitleService;
import com.tisproject.biz.title.TitleVO;
import com.tisproject.biz.titleItem.TitleItemService;
import com.tisproject.biz.titleItem.TitleItemVO;
import com.tisproject.biz.user.DTO.UserVO;
import com.tisproject.biz.video.VideoService;
import com.tisproject.biz.video.VideoVO;
import com.tisproject.biz.viewList.ViewListService;
import com.tisproject.biz.viewList.ViewListVO;
import com.tisproject.utils.UploadFileUtils;

@Controller
@SessionAttributes({"title", "item", "grade", "video", "titleItem", "viewList"})
public class TitleController {
	
	@Autowired
	private TitleService titleService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private GradeService gradeService;
	@Autowired
	private VideoService videoService;
	@Autowired
	private TitleItemService titleItemService;
	@Autowired
	private ViewListService viewListService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	// 각자 경로 수정
	private String realPath = "C:\\tisProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\tisproject4_1\\";
	
/**************************** home 화면*******************************/
	
	@RequestMapping(value = "/home.do")
	public String home(HttpServletRequest request, Model model) {
		
		// 시리즈에 따라 인스턴스 생성
		TitleVO allVo = new TitleVO();
		TitleVO movieVo = new TitleVO();
		TitleVO TVVo = new TitleVO();
		
		movieVo.setSearchType('M');
		TVVo.setSearchType('T');
		
		HttpSession session = request.getSession();
		UserVO userVo = (UserVO) session.getAttribute("user");
		
		if (userVo != null) {
			ItemVO getItemVo = new ItemVO();
			int userFavoriteGenre = 0;
			
			// 첫 번째 장르
			
			getItemVo.setItemNo(userVo.getFavorite_genre1());
			userFavoriteGenre = getItemVo.getItemNo();
			
			if (userFavoriteGenre != 0) {
				model.addAttribute("userGenre_0", itemService.getItem(getItemVo));
				
				allVo.setGenreId(userFavoriteGenre);
				movieVo.setGenreId(userFavoriteGenre);
				TVVo.setGenreId(userFavoriteGenre);
				
				model.addAttribute("genreTitleFiveAll_0", titleService.getGenreTitleFive(allVo));
				model.addAttribute("genreTitleFiveMovie_0", titleService.getGenreTitleFive(movieVo));
				model.addAttribute("genreTitleFiveTV_0", titleService.getGenreTitleFive(TVVo));
			}
			
			// 두 번째 장르
			
			getItemVo.setItemNo(userVo.getFavorite_genre2());
			userFavoriteGenre = getItemVo.getItemNo();
			
			if (userFavoriteGenre != 0) {
				model.addAttribute("userGenre_1", itemService.getItem(getItemVo));
				
				allVo.setGenreId(userFavoriteGenre);
				movieVo.setGenreId(userFavoriteGenre);
				TVVo.setGenreId(userFavoriteGenre);
				
				model.addAttribute("genreTitleFiveAll_1", titleService.getGenreTitleFive(allVo));
				model.addAttribute("genreTitleFiveMovie_1", titleService.getGenreTitleFive(movieVo));
				model.addAttribute("genreTitleFiveTV_1", titleService.getGenreTitleFive(TVVo));
			}
			
			// 두 번째 장르
			
			getItemVo.setItemNo(userVo.getFavorite_genre3());
			userFavoriteGenre = getItemVo.getItemNo();
			
			if (userFavoriteGenre != 0) {
				model.addAttribute("userGenre_2", itemService.getItem(getItemVo));
				
				allVo.setGenreId(userFavoriteGenre);
				movieVo.setGenreId(userFavoriteGenre);
				TVVo.setGenreId(userFavoriteGenre);
				
				model.addAttribute("genreTitleFiveAll_2", titleService.getGenreTitleFive(allVo));
				model.addAttribute("genreTitleFiveMovie_2", titleService.getGenreTitleFive(movieVo));
				model.addAttribute("genreTitleFiveTV_2", titleService.getGenreTitleFive(TVVo));
			}
		}
		
		// 최근 영상 1개 get
		model.addAttribute("lastestTitle", titleService.getLastestTitle(allVo));
		// 평점 높은 영상 1개 get
		model.addAttribute("bestGradeTitle", titleService.getBestGradeTitle(allVo));
		// 조회수 높은 영상 1개 get
		model.addAttribute("bestViewTitle", titleService.getBestViewTitle(allVo));
		
		// 최근 영상 5개 타입별로 get
		model.addAttribute("lastestTitleFiveAll", titleService.getLastestTitleFive(allVo));
		model.addAttribute("lastestTitleFiveMovie", titleService.getLastestTitleFive(movieVo));
		model.addAttribute("lastestTitleFiveTV", titleService.getLastestTitleFive(TVVo));
		
		// 평점 높은 영상 5개 타입별로 get
		model.addAttribute("bestGradeTitleFiveAll", titleService.getBestGradeTitleFive(allVo));
		model.addAttribute("bestGradeTitleFiveMovie", titleService.getBestGradeTitleFive(movieVo));
		model.addAttribute("bestGradeTitleFiveTV", titleService.getBestGradeTitleFive(TVVo));
		
		// 조회수 높은 영상 5개 타입별로 get
		model.addAttribute("bestViewTitleFiveAll", titleService.getBestViewTitleFive(allVo));
		model.addAttribute("bestViewTitleFiveMovie", titleService.getBestViewTitleFive(movieVo));
		model.addAttribute("bestViewTitleFiveTV", titleService.getBestViewTitleFive(TVVo));
		// 신동인 추가
		model.addAttribute("rank",session.getAttribute("rank"));
		return "home";	
	}	
	
/**************************** videoInfo 화면*******************************/
	
	
	@RequestMapping(value = "/videoInfo.do")
	public String videoInfo(HttpServletRequest request, int titleNo,
			TitleVO titleVo, VideoVO videoVo, GradeVO gradeVo,
			ItemVO itemVo, Model model) {
		
		HttpSession session = request.getSession();
		UserVO userVo = (UserVO) session.getAttribute("user");
		
		// titleNo 로 객체들을 get 하기 떄문에 titleNo Set
		titleVo.setTitleNo(titleNo);
		videoVo.setTitleNo(titleNo);
		gradeVo.setTitleNo(titleNo);
		itemVo.setTitleNo(titleNo);
		gradeVo.setUserNo(userVo.getId());
		
		// 해당 title 정보 get
		model.addAttribute("title", titleService.getTitle(titleVo));
		// 해당 title의 videoList get
		
		List<VideoVO> videoList = videoService.getVideoList(videoVo);
		
		for (VideoVO video : videoList) {
			if(video != null) {
				int videoWatchTime = video.getVideoWatchTime();
				int videoWatchTimeMin = (int) (videoWatchTime / 60);
				int videoWatchTimeSec = (int) (videoWatchTime % 60);
				
				video.setVideoWatchTimeMin(videoWatchTimeMin);
				video.setVideoWatchTimeSec(videoWatchTimeSec);
			}
		}
		
		model.addAttribute("videoList", videoList);
		// 해당 title의 현재 유저 별점 get
		model.addAttribute("grade", gradeService.getGrade(gradeVo));
		// 해당 title의 평균 별점 get
		model.addAttribute("titleAvg", gradeService.getTitleAvg(gradeVo));
		// 해당 title의 영상 갯수 get
		model.addAttribute("videoCount", videoService.getVideoCount(videoVo));
		// 해당 title의 장르 리스트 get
		model.addAttribute("genreItemList", itemService.getGenreItemListByTitle(itemVo));
		// 해당 title의 국가 리스트 get
		model.addAttribute("nationItemList", itemService.getNationItemListByTitle(itemVo));
		// 해당 title의 특징 리스트 get
		model.addAttribute("pointItemList", itemService.getPointItemListByTitle(itemVo));
		
		return "videoInfo";
	}
	
/**************************** getTitleList 화면*******************************/	
	
	@RequestMapping(value = "/getTitleList.do")
	public String getTitleList(Integer page, TitleVO titleVo, Model model) {
		
		char keywordSearch = titleVo.getKeywordSearch();
		String inputSearch = titleVo.getInputSearch();
		
		if(page == null) {
			page = 1;
		} else if (page <= 0) {
			page = 1;
		}
		
		final int TITLE_STEP = 10;
		int startTitle = (page - 1) * TITLE_STEP + 1;
		
		final int PAGE_STEP = 5;
		int startPage = (page - 1) / PAGE_STEP * PAGE_STEP + 1;
		int endPage = startPage + PAGE_STEP - 1;
		
		Integer totalTitleCount = titleService.getTotalTitleCount(titleVo);
		
		if (totalTitleCount == null) {
			totalTitleCount = 0;
		}
		
		int totalPage = totalTitleCount / TITLE_STEP;
		
		if (totalTitleCount % PAGE_STEP != 0) {
			totalPage++; 
		}
		
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		
		titleVo.setStartTitle(startTitle);
		titleVo.setStepTitle(TITLE_STEP);
		
		model.addAttribute("titleList", titleService.getTitleListPage(titleVo));
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("PAGE_STEP", PAGE_STEP);
		model.addAttribute("currentPage", page);
		model.addAttribute("keywordSearch", keywordSearch);
		model.addAttribute("inputSearch", inputSearch);
		
		return "getTitleList";
	}
	
/**************************** getTitle 화면*******************************/		
	
	@RequestMapping(value = "/getTitle.do")
	public String getTitle(int titleNo,
			TitleVO titleVo, VideoVO videoVo, GradeVO gradeVo,
			ItemVO itemVo, ViewListVO viewListVo, Model model) {
		
		titleVo.setTitleNo(titleNo);
		videoVo.setTitleNo(titleNo);
		gradeVo.setTitleNo(titleNo);
		itemVo.setTitleNo(titleNo);
		viewListVo.setTitleNo(titleNo);
		
		// 해당 title 정보 get
		model.addAttribute("title", titleService.getTitle(titleVo));
		// 해당 title의 평균 별점 get
		model.addAttribute("titleAvg", gradeService.getTitleAvg(gradeVo));
		// 해당 title의 영상 갯수 get
		model.addAttribute("videoCount", videoService.getVideoCount(videoVo));
		// 해당 title의 조회 유저 카운트 get
		model.addAttribute("viewListCountByTitle", viewListService.getViewListCountByTitle(viewListVo));
		// 해당 title의 장르 리스트 get
		model.addAttribute("genreItemList", itemService.getGenreItemListByTitle(itemVo));
		// 해당 title의 국가 리스트 get
		model.addAttribute("nationItemList", itemService.getNationItemListByTitle(itemVo));
		// 해당 title의 특징 리스트 get
		model.addAttribute("pointItemList", itemService.getPointItemListByTitle(itemVo));
		
		return "getTitle";
	}

/**************************** insertTitle 화면*******************************/	
	
	@RequestMapping(value = "/insertTitle.do")
	public String insertTitle(ItemVO itemVo, Model model) {
		
		// 각 타입별 아이템들을 get
		model.addAttribute("genreItemList", itemService.getGenreItemList(itemVo));
		model.addAttribute("nationItemList", itemService.getNationItemList(itemVo));
		model.addAttribute("pointItemList", itemService.getPointItemList(itemVo));
		
		return "insertTitle";
	}
	
/**************************** insertTitle *******************************/	
	
	@RequestMapping(value = "/insertTitleOk.do", method=RequestMethod.POST)
	public String insertTitleOk(TitleVO titleVo,
			@RequestParam(value = "genre", required = false) int[] genreItem,
			@RequestParam(value = "nation", required = false) int nationItem,
			@RequestParam(value = "point", required = false) int[] pointItem,
			TitleItemVO titleItemVo, Model model)  {
		
		// poster 파일 업로드
		String posterUploadPath = uploadPath + File.separator + 
				"upload" + File.separator + "posterUpload";
		String posterYmdPath = UploadFileUtils.calcPath(posterUploadPath);
		String posterFileName = null;
		String poster = null;
		
		MultipartFile posterFile = titleVo.getPosterFile();
		
		
		if (!posterFile.isEmpty()) {
			try {
				posterFileName = UploadFileUtils.fileUpload(posterUploadPath,
						posterFile.getOriginalFilename(), posterFile.getBytes(),
						posterYmdPath);
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 안됌 ;
//			poster = "posterUpload" + posterYmdPath +
//					File.separator + posterFileName;	
			
			poster = "resources" + File.separator + "upload" + 
					File.separator + "posterUpload" + posterYmdPath +
					File.separator + posterFileName;
			
		} else {
			poster = null;
		}
		
		titleVo.setPoster(poster);
		
		// backImg 파일 업로드
		String backImgUploadPath = uploadPath + File.separator + 
				"upload" + File.separator + "backImgUpload";
		String backImgYmdPath = UploadFileUtils.calcPath(backImgUploadPath);
		String backImgFileName = null;
		String backImg = null;
		
		MultipartFile backImgFile = titleVo.getBackImgFile();
	
		if (!backImgFile.isEmpty()) {
			try {
				backImgFileName = UploadFileUtils.fileUpload(backImgUploadPath,
						backImgFile.getOriginalFilename(), backImgFile.getBytes(),
						backImgYmdPath);
							
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();	
			}
			
			// 안됌 ;
//			backImg = "backImgUpload" + backImgYmdPath +
//			File.separator + backImgFileName;
			
			backImg = "resources" + File.separator + "upload" + 
					File.separator + "backImgUpload" + backImgYmdPath +
					File.separator + backImgFileName;
			
		} else {
			backImg = null;
		}
			
		titleVo.setBackImg(backImg);
		
		// insertTitle 실행
		titleService.insertTitle(titleVo);
		
		// inserTitle에서 titleNo 추출
		int titleNo = titleVo.getTitleNo();
		
		// titleItemVo에 titleNo Set
		titleItemVo.setTitleNo(titleNo);
		
		// 장르 연결
		for (int i=0; i<genreItem.length; i++) {
			titleItemVo.setItemNo(genreItem[i]);
			titleItemService.insertTitleItem(titleItemVo);
		}
		
		// 국가 연결
		titleItemVo.setItemNo(nationItem);
		titleItemService.insertTitleItem(titleItemVo);
		
		// 특징 연결
		for (int i=0; i<pointItem.length; i++) {
			titleItemVo.setItemNo(pointItem[i]);
			titleItemService.insertTitleItem(titleItemVo);
		}
		
		return "redirect:getTitleList.do";
	}

/**************************** updateTitle 화면*******************************/
	
	@RequestMapping(value = "/updateTitle.do")
	public String updateTitle(int titleNo, TitleVO titleVo,
			ItemVO itemVo, TitleItemVO titleItemVo, Model model) {
		
		System.out.println(titleNo);
		
		titleVo.setTitleNo(titleNo);
		titleItemVo.setTitleNo(titleNo);
		
		// 현재 title 정보를 get
		model.addAttribute("title", titleService.getTitle(titleVo));
		
		// 각 타입별 아이템들을 get
		model.addAttribute("genreItemList", itemService.getGenreItemList(itemVo));
		model.addAttribute("nationItemList", itemService.getNationItemList(itemVo));
		model.addAttribute("pointItemList", itemService.getPointItemList(itemVo));
		
		// 현재 title과 연결되어 있는 정보들을 titleItem을 통해 get
		model.addAttribute("titleItemList", titleItemService.getTitleItemListByTitle(titleItemVo));
		
		return "updateTitle";
	}
	
/**************************** updateTitle *******************************/
	
	@RequestMapping(value = "/updateTitleOk.do")
	public String updateTitleOk(TitleVO titleVo,
			@RequestParam(value = "genre", required = false) int[] genreItem,
			@RequestParam(value = "nation", required = false) int nationItem,
			@RequestParam(value = "point", required = false) int[] pointItem,
			TitleItemVO titleItemVo) {
		
		int titleNo = titleVo.getTitleNo();
		
		// poster 파일 업로드
		String posterUploadPath = uploadPath + File.separator + 
				"upload" + File.separator + "posterUpload";
		String posterYmdPath = UploadFileUtils.calcPath(posterUploadPath);
		String posterFileName = null;
		String poster = null;
		
		MultipartFile posterFile = titleVo.getPosterFile();
		
		String beforePoster = titleService.getTitle(titleVo).getPoster();
		String beforePosterPath = null;
		
		if (beforePoster != null) {
			beforePosterPath = realPath + beforePoster;
		}
		
		if (!posterFile.isEmpty()) {
			try {
				posterFileName = UploadFileUtils.fileUpload(posterUploadPath,
						posterFile.getOriginalFilename(), posterFile.getBytes(),
						posterYmdPath);	
			} catch (IOException e) {	
				e.printStackTrace();		
			} catch (Exception e) {		
				e.printStackTrace();	
			}
			
			if (beforePosterPath != null) {
				File deleteFile = new File(beforePosterPath);
				
				if (deleteFile.exists() ) {
					deleteFile.delete();
				}
			}
			
			poster = "resources" + File.separator + "upload" + 
					File.separator + "posterUpload" + posterYmdPath +
							File.separator + posterFileName;
			
		} else {
			poster = beforePoster;
		}
		
		titleVo.setPoster(poster);
		
		// backImg 파일 업로드
		String backImgUploadPath = uploadPath + File.separator + 
				"upload" + File.separator + "backImgUpload";
		String backImgYmdPath = UploadFileUtils.calcPath(backImgUploadPath);
		String backImgFileName = null;
		String backImg = null;
		
		MultipartFile backImgFile = titleVo.getBackImgFile();
		
		String beforeBackImg = titleService.getTitle(titleVo).getBackImg();
		String beforeBackImgPath = null;
		
		if (beforeBackImg != null) {
			beforeBackImgPath = realPath + beforeBackImg;
		}	
		
		if (!backImgFile.isEmpty()) {
			try {
				backImgFileName = UploadFileUtils.fileUpload(backImgUploadPath,
						backImgFile.getOriginalFilename(), backImgFile.getBytes(),
						backImgYmdPath);	
			} catch (IOException e) {	
				e.printStackTrace();		
			} catch (Exception e) {		
				e.printStackTrace();	
			}
			
			if (beforeBackImgPath != null) {
				File deleteFile = new File(beforeBackImgPath);
				
				if (deleteFile.exists()) {
					deleteFile.delete();
				}
			}
			
			backImg = "resources" + File.separator + "upload" + 
					File.separator + "backImgUpload" + backImgYmdPath +
					File.separator + backImgFileName;
			
		} else {
			backImg = beforeBackImg;
		}
		
		titleVo.setBackImg(backImg);

		// title 수정
		titleService.updateTitle(titleVo);
		
		// titleItemVo에 현재 titleNo Set
		titleItemVo.setTitleNo(titleNo);
		
		// 해당 타이틀 id가 들어있는 titleItem 전부 삭제
		titleItemService.deleteTitleItemByTitle(titleItemVo);
		
		// 장르 연결
		for (int i=0; i<genreItem.length; i++) {
			titleItemVo.setItemNo(genreItem[i]);
			titleItemService.insertTitleItem(titleItemVo);
		}
		
		// 국가 연결
		titleItemVo.setItemNo(nationItem);
		titleItemService.insertTitleItem(titleItemVo);
		
		// 특징 연결
		for (int i=0; i<pointItem.length; i++) {
			titleItemVo.setItemNo(pointItem[i]);
			titleItemService.insertTitleItem(titleItemVo);
		}
		
		return "redirect:getTitle.do?titleNo=" + titleNo;
	}
	
/**************************** deleteTitle *******************************/
	
	@RequestMapping(value = "/deleteTitle.do")
	public String deleteTitle(int titleNo, TitleVO titleVo,
			VideoVO videoVo, GradeVO gradeVo, ViewListVO viewListVo,
			TitleItemVO titleItemVo) {
		
		titleVo.setTitleNo(titleNo);
		videoVo.setTitleNo(titleNo);
		gradeVo.setTitleNo(titleNo);
		viewListVo.setTitleNo(titleNo);
		titleItemVo.setTitleNo(titleNo);
		
		titleVo = titleService.getTitle(titleVo);
		
		String poster = realPath + titleVo.getPoster();
		String backImg = realPath + titleVo.getBackImg();
		
		// 포스터 파일 삭제
		File deletePoster = new File(poster);
		
		if (deletePoster.exists()) {
			deletePoster.delete();
		}
		
		// 배경사진 삭제
		File deleteBackImg = new File(backImg);
		
		if (deleteBackImg.exists() ) {
			deleteBackImg.delete();
		}
		
		// 영상 파일들 삭제
		
		List<VideoVO> videoList = videoService.getVideoList(videoVo);
		
		for (VideoVO videoVos : videoList) {
			String videoThumbnail = realPath + videoVos.getVideoThumbnail();
			String video = realPath + videoVos.getVideo();
			
			// 썸네일 파일 삭제
			
			File deleteVideoThumbnail = new File(videoThumbnail);
			
			if (deleteVideoThumbnail.exists()) {
				deleteVideoThumbnail.delete();
			}
			
			// 영상 파일 삭제
			
			File deleteVideo = new File(video);
			
			if (deleteVideo.exists()) {
				deleteVideo.delete();
			}
		}
		
		
		// 타이틀아이템 연결 삭제
		titleItemService.deleteTitleItemByTitle(titleItemVo);
		// 해당 타이틀 영상 삭제
		videoService.deleteVideoByTitle(videoVo);
		// 해당 타이틀 평점 삭제
		gradeService.deleteGradeByTitle(gradeVo);
		// 해당 타이틀 조회 리스트 삭제
		viewListService.deleteViewListByTitle(viewListVo);
		// 해당 타이틀 삭제
		titleService.deleteTitle(titleVo);
		
		return "redirect:getTitleList.do";
	}
	
/**************************** Input 검색 *******************************/	
	// 검색버튼 클릭 시 조건에 맞는 영화 및 드라마르
	@RequestMapping(value="/inputSearch.do")
	public String inputSearch(TitleVO titleVo, Model model) {
	      
		titleVo.setTitle(titleVo.getInputSearch());
		titleVo.setActor(titleVo.getInputSearch());
		titleVo.setDirector(titleVo.getInputSearch());
		
		model.addAttribute("titleList", titleService.inputSearch(titleVo));
		return "result";
	}
	
/**************************** userSetGrade Ajax*******************************/
	
	@RequestMapping(value = "/userSetGrade.do",
			produces = "application/json",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Float> userSetGrade(@RequestBody GradeVO gradeVo) {
		
		int titleNo = gradeVo.getTitleNo();
		int userNo = gradeVo.getUserNo();
		int gradeNo = 0;
		
		GradeVO searchGradeVo = new GradeVO();
		searchGradeVo.setTitleNo(titleNo);
		searchGradeVo.setUserNo(userNo);
		
		System.out.println(gradeVo.toString());
		
		searchGradeVo = gradeService.getGrade(gradeVo);
		if (searchGradeVo != null ) {
			gradeNo = searchGradeVo.getGradeNo();
		}
		
		if (gradeNo == 0) {
			gradeService.insertGrade(gradeVo);
		} else {
			gradeVo.setGradeNo(gradeNo);
			gradeService.updateGrade(gradeVo);
		}
		
		Float gradeAvg = gradeService.getTitleAvg(gradeVo);
		
		Map<String, Float> map = new HashMap<String, Float>();
		map.put("gradeAvg", gradeAvg);
		
		return map;
	}
}
