package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("SttController")
@RequestMapping("/user/statistic")
public class SttController {

	@GetMapping(value = {"sttInfo"})
	public String sttMainPage(Model model) {

		return "user/statistic/sttInfo";
	}

	@GetMapping("storeStt")
	public String StoreStt(Model model) {
		return "user/statistic/storeStt";
	}

	@GetMapping("cateStt")
	public String CateStt(Model model) {
		return "user/statistic/cateStt";
	}

	@GetMapping("regionStt")
	public String RegionStt(Model model) {
		return "user/statistic/regionStt";
	}

	@GetMapping("districtStt")
	public String DistrictStt(Model model) {
		return "user/statistic/districtStt";
	}

	@GetMapping("regionCateStt")
	public String regionCateStt(Model model) {
		return "user/statistic/regionCateStt";
	}
}
