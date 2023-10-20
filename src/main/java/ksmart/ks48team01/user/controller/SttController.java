package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("SttController")
@RequestMapping("/user/statistic")
public class SttController {

	@GetMapping(value = {"mainSTT"})
	public String userMainPage(Model model) {
		
		return "user/statistic/mainSTT";
	}
}
