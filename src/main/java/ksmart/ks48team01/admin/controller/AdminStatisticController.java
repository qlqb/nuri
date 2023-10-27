package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminStatisticController")
@RequestMapping("/admin/statistic")
public class AdminStatisticController {


	@GetMapping("sttInfo")
	public String sttInfo(Model model) {

		return "admin/statistic/sttInfo";
	}

	@GetMapping("budgetUseageInfo")
	public String budgetUseageInfo(Model model) {

		return "admin/statistic/budgetUseageInfo";
	}
}
