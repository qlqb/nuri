package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userInformController")
@RequestMapping("/user/guide")
public class GuideController {

	@GetMapping(value = { "/serviceGuide"})
	public String userInformPage(Model model) {

		return "user/guide/serviceGuide";
	}

}
