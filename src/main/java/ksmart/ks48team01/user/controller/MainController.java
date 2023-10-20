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
}
