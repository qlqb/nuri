package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("contentsController")
@RequestMapping("/user/contents")
public class ContentsController {
	
	//컨텐츠 수정
	@GetMapping(value = {"/contentsInfoUpdate"})
	public String modifyContentsPage(Model model) {
		
		return "user/contents/contentsInfoUpdate";
	}
	
	//컨텐츠 등록
	@GetMapping(value = {"/contentsInfoRegist"})
	public String contentsRegPage(Model model) {
		
		return "user/contents/contentsInfoRegist";
	}
	
	//컨텐츠 상세설명 -> view에서 클릭하면 들어가는 경로로
	@GetMapping(value={"/viewDetail"})
	public String contentsViewDetail(Model model) {
		
		model.addAttribute("title", "컨텐츠 상세설명");
		
		return "user/contents/viewDetail";
	}
	
	//컨텐츠 전체 목록 조회
		@GetMapping(value = {"/contentsInfoList"})
		public String contentsListPage(Model model) {
			model.addAttribute("title", "컨텐츠 조회");
			return "user/contents/contentsInfoList";
		}
}
