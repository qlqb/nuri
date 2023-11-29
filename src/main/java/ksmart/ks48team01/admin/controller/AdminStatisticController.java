package ksmart.ks48team01.admin.controller;

import ksmart.ks48team01.dto.Statistic;
import ksmart.ks48team01.service.StatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller("AdminStatisticController")
@RequestMapping("/admin/statistic")
public class AdminStatisticController {

	private static final Logger log = LoggerFactory.getLogger(AdminStatisticController.class);
	private final StatisticService statisticService;

	public AdminStatisticController(StatisticService statisticService) {
		this.statisticService = statisticService;
	}


	@PostMapping("/searchStoreStt")
	@ResponseBody
	public List<Statistic> storeSttInfo(@RequestBody List<Map<String, Object>> searchList){
		log.info("searchList:{}", searchList);
		List<Statistic> storeSttList = statisticService.getStoreSttList(searchList);
		return storeSttList;
	}

	@GetMapping("storeStt")
	public String storeStt(Model model, @RequestParam(name="searchKey",required = false) String searchKey,
						   				@RequestParam(name="searchValue", required = false, defaultValue = "") String searchValue) {
		List<Statistic> storeSttList = statisticService.getStoreSttList();


		log.info("StoreSttList:{}",storeSttList);
		model.addAttribute("title", "가맹점 통계 조회");
		model.addAttribute("storeSttList", storeSttList);


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
