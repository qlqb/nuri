package ksmart.ks48team01.user.controller;

import ksmart.ks48team01.dto.ContentsCategory;
import ksmart.ks48team01.dto.StoreCategory;
import ksmart.ks48team01.service.ContentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller("userMainController")
@RequestMapping("/user")
public class MainController {
		private static final Logger log = LoggerFactory.getLogger(ContentsController.class);
		private final ContentsService contentsService;
		public MainController(ContentsService contentsService) {
		this.contentsService = contentsService;
	}

		@GetMapping(value = {"", "/"})
		public String userMainPage(Model model,
									@RequestParam(name="currentPage", required=false, defaultValue = "1") int currentPage,
									@RequestParam(name="tabValue", defaultValue = "all") String tabValue,
									@RequestParam(name="performanceGenre", defaultValue = "allGenre") String performanceGenre,
									@RequestParam(name="area", defaultValue = "allArea") String area,
									@RequestParam(name="startDate", defaultValue = "allDate") String startDate,
									@RequestParam(name="endDate", defaultValue = "allDate") String endDate,
									@RequestParam(name="searchValue", defaultValue = "searchAll") String searchValue) {

			log.info("tabValue: {}", tabValue);
			log.info("performanceGenre: {}", performanceGenre);
			log.info("area: {}", area);
			log.info("startDate: {}", startDate);
			log.info("endDate: {}", endDate);
			log.info("searchValue: {}", searchValue);

			List<StoreCategory> storeCategory = contentsService.getStoreCategory();

			List<ContentsCategory> contentsCategory = contentsService.getContentsCategory();

			Map<String, Object> resultMap = null;

			if(performanceGenre.equals("allGenre")) {
				resultMap = contentsService.getContentsInfoListByTabValue(currentPage, tabValue);
				List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");
				model.addAttribute("contentsInfoList", contentsInfoList);
			} else {
				resultMap = contentsService.getContentsInfoListByTabValueAndSearch(currentPage, tabValue, performanceGenre, area, startDate, endDate, searchValue);
				List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");
				model.addAttribute("contentsInfoList", contentsInfoList);
			}

			int lastPage = (int) resultMap.get("lastPage");
			int startPageNum = (int) resultMap.get("startPageNum");
			int endPageNum = (int) resultMap.get("endPageNum");
			int contentsCnt = ((Double) resultMap.get("contentsCnt")).intValue();

			model.addAttribute("contentsCnt", contentsCnt);

			model.addAttribute("storeCategory", storeCategory);

			model.addAttribute("contentsCategory", contentsCategory);

			model.addAttribute("title", "컨텐츠 조회");
			model.addAttribute("tabValue", tabValue);
			model.addAttribute("currentPage", currentPage);

			model.addAttribute("lastPage", lastPage);
			model.addAttribute("startPageNum", startPageNum);
			model.addAttribute("endPageNum", endPageNum);

			model.addAttribute("performanceGenre", performanceGenre);

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
