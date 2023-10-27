package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("StoreController")
@RequestMapping("/user/store")
public class StoreController {
	
	//가맹점 수정
	@GetMapping("/storeModify")
	public String storeModify(Model model) {
		//storeInfo 해야함.
		return "user/store/storeModify";
	}
	
	//가맹점 등록
	@GetMapping("/storeRegist")
	public String storeRegist(Model model) {
		
		model.addAttribute("title", "가맹점 등록");
		return "user/store/storeRegist";
	}
	
	
	//가맹점 전체 조회
	@GetMapping("/storeList")
	public String getStoreList(Model model) {
		model.addAttribute("title", "가맹점 목록 조회");
		return "user/store/storeList";
	}
}
