package ksmart.ks48team01.admin.controller;

import ksmart.ks48team01.dto.Contents;
import ksmart.ks48team01.service.ContentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller("AdminContentsController")
@RequestMapping("/admin/contents")
public class AdminContentsController {

	private final ContentsService contentsService;

	public AdminContentsController(ContentsService contentsService) {
		this.contentsService = contentsService;
	}

	@GetMapping(value={"/contentsInfoUpdate"})
	public String contentsUpdatePage(Model model) {
		model.addAttribute("title", "컨텐츠 수정");
		return "admin/contents/contentsInfoUpdate";
	}
	
	@GetMapping(value={"/contentsInfoRegist"})
	public String contentsRegistPage(Model model) {
		model.addAttribute("title", "컨텐츠 등록");
		return "admin/contents/contentsInfoRegist";
	}
	
	
	@GetMapping(value={"/contentsInfoDelete"})
	public String contentsDeletePage(Model model) {
		model.addAttribute("title", "컨텐츠 삭제");
		return "admin/contents/contentsInfoDelete";
	}
	
	
	@GetMapping(value={"/contentsInfoSpecific"})
	public String contentsSpecificPage(Model model) {
		model.addAttribute("title", "컨텐츠 검색");
		return "admin/contents/contentsInfoSpecific";
	}
	
	
	@GetMapping(value={"/contentsInfoList"})
	public String contentsListPage(Model model) {
		List<Contents> contentsList = contentsService.getAdminContentsList();
		model.addAttribute("title", "컨텐츠 목록");
		model.addAttribute("contentsList", contentsList);
		return "admin/contents/contentsList";
	}
}
