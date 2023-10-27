package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("customerController")
@RequestMapping("/user/customerService")
public class CustomerController {
	
	@GetMapping(value = {"/FAQ"})
	public String modifyContentsPage(Model model) {
		model.addAttribute("title", "자주 묻는 질문");
		return "user/customerService/FAQ";
	}
	
	@GetMapping(value = {"/inquery"})
	public String contentsRegPage(Model model) {
		model.addAttribute("title", "문의하기");
		return "user/customerService/inquery";
	}
	
	@GetMapping(value={"/inqueryGuide"})
	public String contentsViewDetail(Model model) {
		model.addAttribute("title", "문의 및 신고안내");
		return "user/customerService/inqueryGuide";
	}
}
