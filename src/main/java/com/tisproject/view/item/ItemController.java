package com.tisproject.view.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tisproject.biz.item.ItemService;
import com.tisproject.biz.item.ItemVO;
import com.tisproject.biz.title.TitleVO;
import com.tisproject.biz.titleItem.TitleItemService;
import com.tisproject.biz.titleItem.TitleItemVO;

@Controller
@SessionAttributes({"item", "titleItem"})
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private TitleItemService titleItemService;
	
	@RequestMapping(value = "/getItem.do")
	public String getItem(ItemVO itemVo, Model model) {
		// 각 타입별 아이템들을 get
		
		model.addAttribute("genreItemList", itemService.getGenreItemList(itemVo));
		model.addAttribute("nationItemList", itemService.getNationItemList(itemVo));
		model.addAttribute("pointItemList", itemService.getPointItemList(itemVo));
		
		return "getItem";
	}
	
	@RequestMapping(value = "/insertItem.do",
			produces = "application/json",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Integer> insertItem(@RequestBody ItemVO itemVo) {
		
		// 해당 아이템 추가
		itemService.insertItem(itemVo);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("itemNo", itemVo.getItemNo());
		
		return map;
	}
	
	@RequestMapping(value = "/updateItem.do",
			produces = "application/json",
			method=RequestMethod.POST)
	@ResponseBody
	public String updateItem(@RequestBody ItemVO itemVo) {
		
		// 해당 아이템 업데이트
		itemService.updateItem(itemVo);
		
		return null;
	}
	
	@RequestMapping(value = "/deleteItem.do",
			produces = "application/json",
			method=RequestMethod.POST)
	@ResponseBody
	public String deleteItem(@RequestBody ItemVO itemVo,
			TitleItemVO titleItemVo) {
		
		int itemNo = itemVo.getItemNo();
		
		titleItemVo.setItemNo(itemNo);
		
		// 해당 아이템 번호의 모든 타이틀 연결 삭제
		titleItemService.deleteTitleItemByItem(titleItemVo);
		
		// 해당 아이템 삭제
		itemService.deleteItem(itemVo);
		
		return null;
	}
	
	/* 22-03-17, 검색 기능 추가하였음, 안성우 */
	@RequestMapping(value = "/search.do")
	public String searchItem(ItemVO itemVo, Model model) {
		// 장르별로 영화 및 드라마 가져오는 것(G:장르, N:국가, P:특징)
		model.addAttribute("itemListG",itemService.getGenreItemList(itemVo));
		model.addAttribute("itemListN",itemService.getNationItemList(itemVo));
		model.addAttribute("itemListP",itemService.getPointItemList(itemVo));
		return "search";
	}
	   
	// 장르, 국가, 특징안에 속성을 선택 했을 시 조건에 맞는 페이지 이동
	@RequestMapping(value="/result.do")
	public String resultItem(ItemVO itemVo, TitleVO titleVo, Model model) {
		List<TitleVO> list = itemService.getTitleItem(itemVo);
      
		model.addAttribute("titleList", itemService.getTitleItem(itemVo)); 
		return "result";
	}
}
