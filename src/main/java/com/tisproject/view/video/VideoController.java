package com.tisproject.view.video;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.tisproject.biz.title.TitleService;
import com.tisproject.biz.title.TitleVO;
import com.tisproject.biz.user.DTO.UserVO;
import com.tisproject.biz.video.VideoService;
import com.tisproject.biz.video.VideoVO;
import com.tisproject.biz.viewList.ViewListService;
import com.tisproject.biz.viewList.ViewListVO;
import com.tisproject.utils.FFmpegWrapper;
import com.tisproject.utils.UploadFileUtils;

@Controller
@SessionAttributes({"video", "title", "viewList"})
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	@Autowired
	private TitleService titleService;
	@Autowired
	private ViewListService viewListService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	private String realPath = "C:\\tisProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\tisproject4_1\\";
	
/**************************** videoShow 화면*******************************/
	@RequestMapping(value = "/videoShow.do")
	public String videoShow(HttpServletRequest request, int videoNo,
			VideoVO videoVo, TitleVO titleVo,
			ViewListVO viewListVo, Model model) {
		
		HttpSession session = request.getSession();
		UserVO userVo = (UserVO) session.getAttribute("user");	
			
		VideoVO prevVideoVo = new VideoVO();
		VideoVO nextVideoVo = new VideoVO();
		VideoVO lastVideoVo = new VideoVO();
		
		videoVo.setVideoNo(videoNo);
		videoVo = videoService.getVideo(videoVo);
		
		int titleNo = videoVo.getTitleNo();
		int userNo = userVo.getId();
		
		int currentEpisodeNo = videoVo.getVideoEpisodeNo();
		int prevEpisodeNo = currentEpisodeNo - 1;
		int nextEpisodeNo = currentEpisodeNo + 1;
		int lastEpisodeNo = 0;
		
		prevVideoVo.setTitleNo(titleNo);
		nextVideoVo.setTitleNo(titleNo);
		lastVideoVo.setTitleNo(titleNo);
		
		lastVideoVo = videoService.getLastVideo(lastVideoVo);
		
		if (lastVideoVo != null) {
			lastEpisodeNo = lastVideoVo.getVideoEpisodeNo();
		}
		
		while(true) {
			VideoVO prevVideoResultVo = null;
			prevVideoVo.setVideoEpisodeNo(prevEpisodeNo);
			prevVideoResultVo = videoService.getOtherVideo(prevVideoVo);
			
			if(prevEpisodeNo <= 0 || prevVideoResultVo != null) {
				prevVideoVo = prevVideoResultVo;
				break;
			}
			
			prevEpisodeNo--;	
		}
		
		while(true) {
			VideoVO nextVideoResultVo = null;
			nextVideoVo.setVideoEpisodeNo(nextEpisodeNo);
			nextVideoResultVo = videoService.getOtherVideo(nextVideoVo);
			
			if(nextEpisodeNo == 0 || nextVideoResultVo != null
					|| nextEpisodeNo > lastEpisodeNo) {
				nextVideoVo = nextVideoResultVo;
				break;
			}
			
			nextEpisodeNo++;
		}
		
		viewListVo.setTitleNo(titleNo);
		viewListVo.setUserNo(userNo);
		
		ViewListVO searchViewList = viewListService.getViewList(viewListVo);
		
		if (searchViewList == null) {
			viewListService.inserViewList(viewListVo);
		}
		
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
		
		model.addAttribute("video", videoVo);
		model.addAttribute("videoList", videoList);
		model.addAttribute("title", titleService.getTitle(titleVo));
		model.addAttribute("videoCount", videoService.getVideoCount(videoVo));
		model.addAttribute("prevVideo", prevVideoVo);
		model.addAttribute("nextVideo", nextVideoVo);
		model.addAttribute("lastVideo", lastVideoVo);
		
		return "videoShow";
	}
	
/**************************** getVideoList 화면*******************************/
	@RequestMapping(value = "/getVideoList.do")
	public String getVideoList(int titleNo, Integer page, TitleVO titleVo, 
			VideoVO videoVo, Model model) {
		
		if(page == null) {
			page = 1;
		} else if (page <= 0) {
			page = 1;
		}
		
		titleVo.setTitleNo(titleNo);
		videoVo.setTitleNo(titleNo);
		
		final int VIDEO_STEP = 10;
		int startVideo = (page - 1) * VIDEO_STEP + 1;
		
		final int PAGE_STEP = 5;
		int startPage = (page - 1) / PAGE_STEP * PAGE_STEP + 1;
		int endPage = startPage + PAGE_STEP - 1;
		
		Integer totalVideoCount = videoService.getVideoCount(videoVo);
		
		if (totalVideoCount == null) {
			totalVideoCount = 0;
		}
		
		int totalPage = totalVideoCount / VIDEO_STEP;
		
		if (totalVideoCount % PAGE_STEP != 0) {
			totalPage++; 
		}
		
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		
		videoVo.setStartVideo(startVideo);
		videoVo.setStepVideo(VIDEO_STEP);
		
		List<VideoVO> videoList = videoService.getVideoListPage(videoVo);
		
		for (VideoVO video : videoList) {
			if(video != null) {
				int videoWatchTime = video.getVideoWatchTime();
				int videoWatchTimeMin = (int) (videoWatchTime / 60);
				int videoWatchTimeSec = (int) (videoWatchTime % 60);
				
				video.setVideoWatchTimeMin(videoWatchTimeMin);
				video.setVideoWatchTimeSec(videoWatchTimeSec);
			}
		}
		
		model.addAttribute("title", titleService.getTitle(titleVo));
		model.addAttribute("videoList", videoList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("PAGE_STEP", PAGE_STEP);
		model.addAttribute("currentPage", page);
		
		return "getVideoList";
	}
	
/**************************** getVideo 화면*******************************/
	@RequestMapping(value = "/getVideo.do")
	public String getVideo(int videoNo, TitleVO titleVo, VideoVO videoVo,
			Model model) {
		
		videoVo.setVideoNo(videoNo);
		videoVo = videoService.getVideo(videoVo);
		
		if(videoVo == null) {
			return "redirect:getTitleList.do";
		}
		
		int videoWatchTime = videoVo.getVideoWatchTime();
		int videoWatchTimeMin = (int) (videoWatchTime / 60);
		int videoWatchTimeSec = (int) (videoWatchTime % 60);
		
		videoVo.setVideoWatchTimeMin(videoWatchTimeMin);
		videoVo.setVideoWatchTimeSec(videoWatchTimeSec);
		
		int titleNo = videoVo.getTitleNo();
		
		titleVo.setTitleNo(titleNo);
		
		model.addAttribute("title", titleService.getTitle(titleVo));
		model.addAttribute("video", videoVo);
		
		return "getVideo";
	}
	
/**************************** insertVideo 화면*******************************/
	
	@RequestMapping(value = "/insertVideo.do")
	public String insertVideo(TitleVO titleVo,  Model model) {
		
		model.addAttribute("title", titleService.getTitle(titleVo));
		model.addAttribute("titleList", titleService.getTitleList(titleVo));
		
		return "insertVideo";
	}
	
/**************************** insertVideo *******************************/	
	@RequestMapping(value = "/insertVideoOk.do", method=RequestMethod.POST)
	public String insertVideoOk(TitleVO titleVo, VideoVO videoVo) {
		
		// Thumbnail 파일 업로드
		String videoThumbnailUploadPath = uploadPath + File.separator +
				"upload" + File.separator + "videoThumbnailUpload";
		String videoThumbnailYmdPath = UploadFileUtils.calcPath(videoThumbnailUploadPath);
		String videoThumbnailFileName = null;
		String videoThumbnail = null;
		
		MultipartFile videoThumbnailFile = videoVo.getVideoThumbnailFile();
		
		if (!videoThumbnailFile.isEmpty()) {
			try {
				videoThumbnailFileName = UploadFileUtils.fileUpload(videoThumbnailUploadPath,
						videoThumbnailFile.getOriginalFilename(), videoThumbnailFile.getBytes(),
						videoThumbnailYmdPath);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();	
			}
			
			videoThumbnail = "resources" + File.separator + "upload" +
					File.separator + "videoThumbnailUpload" + videoThumbnailYmdPath +
					File.separator + videoThumbnailFileName;
		} else {
			videoThumbnail = null;
		}
		
		videoVo.setVideoThumbnail(videoThumbnail);
		
		// Video 파일 업로드
		String videoUploadPath = uploadPath + File.separator +
				"upload" + File.separator + "videoUpload";
		String videoYmdPath = UploadFileUtils.calcPath(videoUploadPath);
		String videoFileName = null;
		String newVideoFileName = null;
		String video = null;

		String realPathVideo = uploadPath + File.separator + "upload" +
				File.separator + "videoUpload" + videoYmdPath +
				File.separator;
		
		MultipartFile videoFile = videoVo.getVideoFile();
		
		if (!videoFile.isEmpty()) {
			try {
				videoFileName = UploadFileUtils.fileUpload(videoUploadPath,
						videoFile.getOriginalFilename(), videoFile.getBytes(),
						videoYmdPath);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();	
			}
			
			video = "resources" + File.separator + "upload" +
					File.separator + "videoUpload" + videoYmdPath +
					File.separator + videoFileName;
			
			
			String videoExt = FilenameUtils.getExtension(video);
			newVideoFileName = videoFileName.replace("." + videoExt, ".mp4");
			
			if(!videoExt.equals("mp4")) {

				try {
					FFmpegWrapper.incodingVideo(videoFileName, realPathVideo, "mp4");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				String outputPath = video.replace("." + videoExt, ".mp4");
		
				File deleteFile = new File(realPathVideo + videoFileName);
				
				if (deleteFile.exists()) {
					deleteFile.delete();
				}
				
				video = outputPath;
				
				int videoWatchTime = 0;
				String realPathVideoFile = realPathVideo + newVideoFileName;
				
				try {
				videoWatchTime = FFmpegWrapper.returnWatchTime(realPathVideoFile);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				videoVo.setVideoWatchTime(videoWatchTime);
			}
				
		} else {
			video = null;
		}
		
		videoVo.setVideo(video);
		
		videoService.insertVideo(videoVo);
		
		int titleNo = videoVo.getTitleNo();
		
		return "redirect:getVideoList.do?titleNo=" + titleNo;
	}

/**************************** updateVideo 화면 *******************************/
	
	@RequestMapping("/updateVideo.do")
	public String updateVideo(int videoNo, VideoVO videoVo,
			TitleVO titleVo, Model model) {
		
		videoVo.setVideoNo(videoNo);
		videoVo = videoService.getVideo(videoVo);
		
		int titleNo = videoVo.getTitleNo();
		
		titleVo.setTitleNo(titleNo);
		
		model.addAttribute("video", videoVo);
		model.addAttribute("title", titleService.getTitle(titleVo));
		model.addAttribute("titleList", titleService.getTitleList(titleVo));
		
		return "updateVideo";
	}
	
/**************************** updateVideo *******************************/
	@RequestMapping(value = "/updateVideoOk.do", method=RequestMethod.POST)
	public String updateVideoOk(VideoVO videoVo) {
		int videoNo = videoVo.getVideoNo();
		
		// Thumbnail 파일 업로드
		String videoThumbnailUploadPath = uploadPath + File.separator +
				"upload" + File.separator + "videoThumbnailUpload";
		String videoThumbnailYmdPath = UploadFileUtils.calcPath(videoThumbnailUploadPath);
		String videoThumbnailFileName = null;
		String videoThumbnail = null;
		
		MultipartFile videoThumbnailFile = videoVo.getVideoThumbnailFile();
		
		String beforeVideoThumbnail = videoService.getVideo(videoVo).getVideoThumbnail();
		String beforeVideoThumbnailPath = null;
		
		if (beforeVideoThumbnail != null) {
			beforeVideoThumbnailPath = realPath + beforeVideoThumbnail;
		}
		
		if (!videoThumbnailFile.isEmpty()) {
			try {
				videoThumbnailFileName = UploadFileUtils.fileUpload(videoThumbnailUploadPath,
						videoThumbnailFile.getOriginalFilename(), videoThumbnailFile.getBytes(),
						videoThumbnailYmdPath);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();	
			}
			
			if (beforeVideoThumbnailPath != null) {
			
				File deleteFile = new File(beforeVideoThumbnailPath);
				
				if (deleteFile.exists()) {
					deleteFile.delete();
				}
			}
			
			videoThumbnail = "resources" + File.separator + "upload" +
					File.separator + "videoThumbnailUpload" + videoThumbnailYmdPath +
					File.separator + videoThumbnailFileName;
		} else {
			videoThumbnail = beforeVideoThumbnail;
		}
		
		videoVo.setVideoThumbnail(videoThumbnail);
		
		// Video 파일 업로드
		String videoUploadPath = uploadPath + File.separator +
				"upload" + File.separator + "videoUpload";
		String videoYmdPath = UploadFileUtils.calcPath(videoUploadPath);
		String videoFileName = null;
		String newVideoFileName = null;
		String video = null;
		
		MultipartFile videoFile = videoVo.getVideoFile();
		
		String realPathVideo = uploadPath + File.separator + "upload" +
				File.separator + "videoUpload" + videoYmdPath +
				File.separator;
		
		String beforeVideo = videoService.getVideo(videoVo).getVideo();
		String beforeVideoPath = null;
		
		// 기존 영상 경로가 null 이 아닐때만 실제 기존영상경로 값을 넣는다
		if (beforeVideo != null) {
			beforeVideoPath = realPath + beforeVideo;
		}
		
		// 현재 영상 파일을 등록할 때
		if (!videoFile.isEmpty()) {
			try {
				videoFileName = UploadFileUtils.fileUpload(videoUploadPath,
						videoFile.getOriginalFilename(), videoFile.getBytes(),
						videoYmdPath);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();	
			}
			
			if (beforeVideoPath != null) {
				File deleteBeforeVideo = new File(beforeVideoPath);
				
				if (deleteBeforeVideo.exists() ) {
					deleteBeforeVideo.delete();
				}
			}
			
			video = "resources" + File.separator + "upload" +
					File.separator + "videoUpload" + videoYmdPath +
					File.separator + videoFileName;
			
			String videoExt = FilenameUtils.getExtension(video);
			newVideoFileName = videoFileName.replace("." + videoExt, ".mp4");
			
			if(!videoExt.equals("mp4")) {

				try {
					FFmpegWrapper.incodingVideo(videoFileName, realPathVideo, "mp4");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				String outputPath = video.replace("." + videoExt, ".mp4");
		
				File deleteFile = new File(realPathVideo + videoFileName);
				
				if (deleteFile.exists()) {
					deleteFile.delete();
				}
				
				video = outputPath;
				
				int videoWatchTime = 0;
				String realPathVideoFile = realPathVideo + newVideoFileName;
				
				try {
				videoWatchTime = FFmpegWrapper.returnWatchTime(realPathVideoFile);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				videoVo.setVideoWatchTime(videoWatchTime);
				
			}
				
		} else {
			video = beforeVideo;
		}
		
		videoVo.setVideo(video);

		videoService.updateVideo(videoVo);
		
		return "redirect:getVideo.do?videoNo=" + videoNo;
	}
	
/**************************** deleteVideo *******************************/
	
	@RequestMapping(value = "/deleteVideo.do")
	public String deleteVideo(int videoNo, VideoVO videoVo) {
		
		videoVo.setVideoNo(videoNo);
		videoVo = videoService.getVideo(videoVo);
		
		String videoThumbnail = realPath + videoVo.getVideoThumbnail();
		String video = realPath + videoVo.getVideo();
		
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
		
		int titleNo = videoVo.getTitleNo();
		
		videoService.deleteVideo(videoVo);
		
		return "redirect:getVideoList.do?titleNo=" + titleNo;
	}

/************************* episodeNoCheck Ajax**************************/
	
	@RequestMapping(value = "/episodeNoCheck.do",
			produces = "application/json",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Integer> episodeNoCheck(@RequestBody VideoVO videoVo) {
		
		VideoVO checkVideoVo = new VideoVO();
		
		checkVideoVo = videoService.getVideoByEpisodeNo(videoVo);
		
		if (checkVideoVo != null) {
			System.out.println(checkVideoVo.toString());
		}
		
		int result = 0;
		
		if (checkVideoVo == null) {
			result = 1;
		} else if (checkVideoVo.getVideoNo() == videoVo.getVideoNo()) {
			result = 1;
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("result", result);
		
		return map;
	}
}
