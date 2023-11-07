package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userMainController")
@RequestMapping("/user")
public class MainController {



	@GetMapping(value = {"", "/"})
	public String userMainPage(Model model) {
		
		return "user/main";
	}

	@GetMapping("/devPageLSH")
	public String devPage(Model model) {

		model.addAttribute("title", "누리컬쳐");
		model.addAttribute("pageTitle", "개발자 링크 페이지");
		model.addAttribute("breadCrumb1", "메인페이지");
		model.addAttribute("breadCrumb2", "이승호");

		return "user/devPageLSH";
	}
}
