package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("AdminStoreController")
@RequestMapping("/admin/store")
public class AdminStoreController {
	
	@GetMapping(value={"/storeInfoUpdate"})
	public String storeUpdatePage(Model model) {
		model.addAttribute("title", "가맹점 수정");
		return "admin/store/storeInfoUpdate2";
	}
	
	@GetMapping(value={"/storeInfoRegist"})
	public String storeRegistPage(Model model) {
		model.addAttribute("title", "가맹점 등록");
		return "admin/store/storeInfoRegist";
	}
	
	@GetMapping(value={"/storeInfoDelete"})
	public String storeDeletePage(Model model) {
		model.addAttribute("title", "가맹점 삭제");
		return "admin/store/storeInfoDelete";
	}
	
	
	@GetMapping(value={"/storeInfoSpecific"})
	public String storeSpecificPage(Model model) {
		model.addAttribute("title", "가맹점 검색");
		return "admin/store/storeInfoSpecific";
	}
	
	
	@GetMapping(value={"/storeInfoList"})
	public String storeListPage(Model model) {
		model.addAttribute("title", "가맹점 목록");
		return "admin/store/storeInfoList";
	}
}
