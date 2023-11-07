package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("InformController.java")
@RequestMapping("/user/inform")
public class InformController {
	
	@GetMapping(value = {"/notice"})
	public String modifyContentsPage(Model model) {
		model.addAttribute("title", "공지사항");
		return "user/inform/notice";
	}
	
	@GetMapping(value = {"/promotion"})
	public String contentsRegPage(Model model) {
		model.addAttribute("title", "지역홍보");
		return "user/inform/promotion";
	}
	
	@GetMapping(value={"/userReview"})
	public String contentsViewDetail(Model model) {
		model.addAttribute("title", "이용자 후기");
		return "user/inform/userReview";
	}
}
