package ksmart.ks48team01.admin.controller;

import ksmart.ks48team01.dto.Contents;
import ksmart.ks48team01.dto.StoreCategory;
import ksmart.ks48team01.service.ContentsService;
import ksmart.ks48team01.user.controller.ContentsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller("AdminContentsController")
@RequestMapping("/admin/contents")
public class AdminContentsController {


	private static final Logger log = LoggerFactory.getLogger(ContentsController.class);
	private final ContentsService contentsService;

	public AdminContentsController(ContentsService contentsService) {
		this.contentsService = contentsService;
	}

	@GetMapping(value={"/contentsInfoUpdate"})
	public String contentsUpdatePage(Model model,
									 @RequestParam(name="contentsId") String contentsId) {
		Map<String, Object> contentsDetailInfo = contentsService.getContentsDetailInfo(contentsId);
		log.info("contentsDetailInfo: {}", contentsDetailInfo.get("contentsSellEndDate"));
		List<StoreCategory> storeCategory = contentsService.getStoreCategory();
		model.addAttribute("title", "컨텐츠 수정");
		model.addAttribute("contentsDetailInfo", contentsDetailInfo);
		model.addAttribute("storeCategory", storeCategory);
		return "admin/contents/contentsInfoUpdate";
	}

	@PostMapping(value={"/contentsInfoUpdate"})
	public String updateContent(Contents contents) {

		return "admin/contents/contentsInfoUpdate";
	}
	
	@GetMapping(value={"/contentsInfoRegist"})
	public String contentsRegistPage(Model model) {
		model.addAttribute("title", "컨텐츠 등록");
		return "admin/contents/contentsInfoRegist";
	}
	
	
	@GetMapping(value={"/contentsInfoDelete"})
	public String contentsDeletePage(Model model) {
		model.addAttribute("title", "컨텐츠 삭제");
		return "admin/contents/contentsInfoDelete";
	}
	
	
	@GetMapping(value={"/contentsInfoSpecific"})
	public String contentsSpecificPage(Model model) {
		model.addAttribute("title", "컨텐츠 검색");
		return "admin/contents/contentsInfoSpecific";
	}
	
	
	@GetMapping(value={"/contentsInfoList"})
	public String contentsListPage(Model model,
								   @RequestParam(name="contentsName", required = false, defaultValue = "") String contentsName,
								   @RequestParam(name="storeCategory", required = false, defaultValue = "") String storeCategory,
								   @RequestParam(name="storeName", required = false, defaultValue = "") String storeName,
								   @RequestParam(name="contentsPg", required = false, defaultValue = "") String contentsPg,
								   @RequestParam(name="startDate", required = false, defaultValue = "") String startDate,
								   @RequestParam(name="endDate", required = false, defaultValue = "") String endDate) {

		List<Contents> contentsList = contentsService.getAdminContentsList();
		List<StoreCategory> storeCategoryList = contentsService.getStoreCategory();

		

		model.addAttribute("storeCategoryList", storeCategoryList);
		model.addAttribute("title", "컨텐츠 목록");
		model.addAttribute("contentsList", contentsList);
		return "admin/contents/contentsList";
	}
}
