package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminStatisticController")
@RequestMapping("/admin/statistic")
public class AdminStatisticController {


	@GetMapping("storeStt")
	public String storeStt(Model model) {

		return "/admin/statistic/storeStt";
	}
	@GetMapping("cateStt")
	public String cateStt(Model model) {

		return "/admin/statistic/cateStt";
	}
	@GetMapping("regionStt")
	public String regionStt(Model model) {

		return "/admin/statistic/regionStt";
	}
	@GetMapping("districtStt")
	public String districtStt(Model model) {

		return "/admin/statistic/districtStt";
	}
	@GetMapping("regionCateStt")
	public String regionCateStt(Model model) {

		return "/admin/statistic/regionCateStt";
	}

	@GetMapping("budgetUseage")
	public String budgetUseage(Model model) {

		return "/admin/statistic/budgetUseage";
	}
}
