package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminSupportController")
@RequestMapping("/admin")
public class AdminSupportController {


	@GetMapping("support")
	public String support(Model model) {

		return "admin/support";
	}
}
