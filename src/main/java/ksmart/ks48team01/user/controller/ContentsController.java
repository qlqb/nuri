package ksmart.ks48team01.user.controller;

import com.sun.source.tree.MemberSelectTree;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	private final AreaService areaService;

	public ContentsController(ContentsService contentsService, AreaService areaService) {
		this.contentsService = contentsService;
		this.areaService = areaService;
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
	
	//컨텐츠 상세설명 -> view에서 클릭하면 들어가는 경로로
	@GetMapping(value={"/contentsDetail"})
	public String contentsDetail(Model model) {
		
		model.addAttribute("title", "컨텐츠 상세설명");
		
		return "user/contents/contentsDetail";
	}
	
	//컨텐츠 전체 목록 조회
		@GetMapping("/contentsInfoList")
		public String contentsListPage(Model model,
									   @RequestParam(name="currentPage", required=false, defaultValue = "1") int currentPage,
									   @RequestParam(name="tabValue", defaultValue = "전체") String tabValue) {

			List<StoreCategory> storeCategory = contentsService.getStoreCategory();

			List<ContentsCategory> contentsCategory = contentsService.getContentsCategory();

			List<Region> regionList = areaService.getRegionList();

			Map<String, Object> resultMap = contentsService.getContentsInfoList(currentPage, tabValue);

			List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");

			int lastPage = (int) resultMap.get("lastPage");
			int startPageNum = (int) resultMap.get("startPageNum");
			int endPageNum = (int) resultMap.get("endPageNum");
			int contentsCnt = ((Double) resultMap.get("contentsCnt")).intValue();

			model.addAttribute("storeCategory", storeCategory);

			model.addAttribute("contentsCategory", contentsCategory);

			model.addAttribute("regionList", regionList);

			model.addAttribute("title", "컨텐츠 조회");
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("lastPage", lastPage);
			model.addAttribute("startPageNum", startPageNum);
			model.addAttribute("endPageNum", endPageNum);
			model.addAttribute("contentsInfoList", contentsInfoList);
			model.addAttribute("contentsCnt", contentsCnt);


			log.info("contentsInfoList {}", contentsInfoList);

			return "user/contents/contentsInfoList";
		}

//		@GetMapping("/contentsInfoList/tab2")
//		public String contentsTab() {
//
//		}
//		@GetMapping("/contentsInfoList/tab3")
//		public String contentsTab() {
//
//		}
//		@GetMapping("/contentsInfoList/tab4")
//		public String contentsTab() {
//
//		}
//		@GetMapping("/contentsInfoList/tab5")
//		public String contentsTab() {
//
//		}
//		@GetMapping("/contentsInfoList/tab5")
//		public String contentsTab() {
//
//		}
//		@GetMapping("/contentsInfoList/tab7")
//		public String contentsTab() {
//
//		}
//		@GetMapping("/contentsInfoList/tab8")
//		public String contentsTab() {
//
//		}

		@GetMapping(value = {"reservation"})
		public String reservation(Model model) {
			model.addAttribute("title", "예약 화면");
			return "user/contents/reservation";
		}
}
