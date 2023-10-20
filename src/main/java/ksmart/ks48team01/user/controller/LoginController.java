package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userLoginController")
@RequestMapping("/user")
public class LoginController {

	@GetMapping(value = { "/login"})
	public String userLoginPage(Model model) {

		return "user/login";
	}

}
