package ksmart.ks48team01.user.controller;

import com.sun.source.tree.MemberSelectTree;
import ksmart.ks48team01.dto.Contents;
import ksmart.ks48team01.dto.ContentsCategory;
import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.dto.StoreCategory;
import ksmart.ks48team01.service.AreaService;
import ksmart.ks48team01.service.ContentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;

import javax.management.modelmbean.RequiredModelMBean;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller("contentsController")
@RequestMapping("/user/contents")
public class ContentsController {

	private static final Logger log = LoggerFactory.getLogger(ContentsController.class);

	private final ContentsService contentsService;
	public ContentsController(ContentsService contentsService) {
		this.contentsService = contentsService;
	}

	//컨텐츠 검색
	@GetMapping(value = {"/contentsInfoSpecific"})
	public String contentsSpecificPage(Model model) {
		model.addAttribute("title", "컨텐츠 검색");
		return "user/contents/contentsInfoSpecific";
	}
	
	//컨텐츠 수정
	@GetMapping(value = {"/contentsInfoUpdate"})
	public String modifyContentsPage(Model model) {
		model.addAttribute("title", "컨텐츠 수정");
		return "user/contents/contentsInfoUpdate";
	}
	
	//컨텐츠 등록
	@GetMapping(value = {"/contentsInfoRegist"})
	public String contentsRegPage(Model model) {
		model.addAttribute("title", "컨텐츠 등록");
		return "user/contents/contentsInfoRegist";
	}

	@GetMapping(value = {"/bookInfoRegist"})
	public String bookRegPage(Model model){
		model.addAttribute("title", "책 컨텐츠 등록");
		return "/user/contents/contentsForm/bookInfoRegist";
	}

	@PostMapping(value = {"/bookInfoRegist"})
	public String bookRegPage(Contents contents) {

		contentsService.addBookContents(contents);
		return "redirect:/user/contents/contentsForm/bookInfoRegist";
	}

	
	//컨텐츠 상세설명 -> view에서 클릭하면 들어가는 경로로
	@GetMapping(value={"/contentsDetail"})
	public String contentsDetail(Model model,
								 @RequestParam(name="contentsId") String contentsId) {
		Map<String, Object> contentsDetailInfo = contentsService.getContentsDetailInfo(contentsId);

		log.info("contentsDetailInfo: {}", contentsDetailInfo);
		model.addAttribute("title", "컨텐츠 상세설명 페이지");
		model.addAttribute("contentsDetailInfo", contentsDetailInfo);

		return "user/contents/contentsDetail";
	}


	//컨텐츠 전체 목록 조회
		@GetMapping("/contentsInfoList")
		public String contentsListPage(Model model,
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

			return "user/contents/contentsInfoList";
		}

		@GetMapping(value = {"reservation"})
		public String reservation(Model model) {
			model.addAttribute("title", "예약 화면");
			return "user/contents/reservation";
		}
}
