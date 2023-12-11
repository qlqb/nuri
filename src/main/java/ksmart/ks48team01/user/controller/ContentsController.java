package ksmart.ks48team01.user.controller;

import com.sun.source.tree.MemberSelectTree;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ksmart.ks48team01.dto.*;
import ksmart.ks48team01.service.AreaService;
import ksmart.ks48team01.service.ContentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;

import javax.management.modelmbean.RequiredModelMBean;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller("contentsController")
@RequestMapping("/user/contents")
public class ContentsController {
	private static final Logger log = LoggerFactory.getLogger(ContentsController.class);
	private final ContentsService contentsService;

	@Value("/home/springboot")
	private String filePath;

	public ContentsController(ContentsService contentsService) {
		this.contentsService = contentsService;
	}

	@GetMapping("/bookInfoRegist")
	public String bookRegPage(Model model,
							  HttpSession session){
		String userId = (String) session.getAttribute("SID");
		List<ContentsCategory> contentsCategoryList = contentsService.getContentsCategoryOnReg("A04");
		if(userId != null) {
			Store storeInfo = contentsService.getSessionStoreInfo(userId);
			storeInfo.setUserId(userId);
			model.addAttribute("storeInfo", storeInfo);
		} else {
			return "redirect:/user";
		}

		model.addAttribute("title", "책 컨텐츠 등록");
		model.addAttribute("contentsCategoryList", contentsCategoryList);

		return "user/contents/contentsForm/bookInfoRegist";
	}

	@PostMapping("/contentsInfoRegist")
	public String contentsInfoRegist(Contents contents,
							  @RequestParam(name="sido", required = false, defaultValue = "alreadyInputOnJoin") String sido,
							  @RequestParam MultipartFile contentsFile, HttpServletRequest request,
							  @RequestParam(name="userId") String userId) {

		contentsService.addContents(contents, sido);
		String contentsId = contentsService.getContentsIdForFileAdd(contents.getStoreId());
		contentsService.fileUpload(contentsFile, contentsId, userId);

		return "redirect:/user/mypage/myContentsList";
	}

	// 책 컨텐츠 수정
	@GetMapping("/bookInfoUpdate")
	public String modifyBookContentsPage(Model model,
									 @RequestParam(name="contentsId") String contentsId) {

		List<ContentsCategory> contentsCategoryList = contentsService.getContentsCategoryOnReg("A04");
		Contents contentsInfo = contentsService.getContentsInfoByContentsId(contentsId);

		model.addAttribute("title", "책 컨텐츠 수정");
		model.addAttribute("contentsCategoryList", contentsCategoryList);
		model.addAttribute("contentsInfo", contentsInfo);

		return "user/contents/contentsForm/bookInfoUpdate";
	}
	@PostMapping("/contentsInfoUpdate")
	public String modifyContents(Contents contents) {

		contentsService.modifyContents(contents);

		return "redirect:/user/mypage/myContentsList";
	}

	@GetMapping("/performRegist")
	public String performRegPage(Model model,
							  HttpSession session) {
		String userId = (String) session.getAttribute("SID");
		List<ContentsCategory> contentsCategoryList = contentsService.getContentsCategoryOnReg("A01");
		if (userId != null) {
			Store storeInfo = contentsService.getSessionStoreInfo(userId);
			model.addAttribute("storeInfo", storeInfo);
		} else {
			return "redirect:/user";
		}
		model.addAttribute("title", "공연 컨텐츠 등록");
		model.addAttribute("contentsCategoryList", contentsCategoryList);

		return "user/contents/contentsForm/performRegist";
	}
	@GetMapping("/performUpdate")
	public String modifyPerformContentsPage(Model model,
									 @RequestParam(name="contentsId") String contentsId,
									 HttpSession session) {

		String userId = (String) session.getAttribute("SID");
		List<ContentsCategory> contentsCategoryList = contentsService.getContentsCategoryOnReg("A01");
		Contents contentsInfo = contentsService.getContentsInfoByContentsId(contentsId);

		if(userId != null) {
			Store storeInfo = contentsService.getSessionStoreInfo(userId);
			model.addAttribute("storeInfo", storeInfo);
		} else {
			return "redirect:/user";
		}

		model.addAttribute("title", "공연 컨텐츠 수정");
		model.addAttribute("contentsCategoryList", contentsCategoryList);
		model.addAttribute("contentsInfo", contentsInfo);

		return "user/contents/contentsForm/performUpdate";
	}

	@GetMapping("/exhibitionRegist")
	public String exhibitionRegPage(Model model,
								 HttpSession session){
		String userId = (String) session.getAttribute("SID");
		List<ContentsCategory> contentsCategoryList = contentsService.getContentsCategoryOnReg("A02");
		if(userId != null) {
			Store storeInfo = contentsService.getSessionStoreInfo(userId);
			model.addAttribute("storeInfo", storeInfo);
		} else {
			return "redirect:/user";
		}
		model.addAttribute("title", "전시 컨텐츠 등록");
		model.addAttribute("contentsCategoryList", contentsCategoryList);

		return "user/contents/contentsForm/exhibitionRegist";
	}

	@GetMapping("/exhibitionUpdate")
	public String modifyExhibitionContentsPage(Model model,
											@RequestParam(name="contentsId") String contentsId,
											HttpSession session) {

		String userId = (String) session.getAttribute("SID");
		Contents contentsInfo = contentsService.getContentsInfoByContentsId(contentsId);
		List<ContentsCategory> contentsCategoryList = contentsService.getContentsCategoryOnReg("A02");

		if(userId != null) {
			Store storeInfo = contentsService.getSessionStoreInfo(userId);
			model.addAttribute("storeInfo", storeInfo);
		} else {
			return "redirect:/user";
		}

		model.addAttribute("title", "전시 컨텐츠 수정");
		model.addAttribute("contentsInfo", contentsInfo);
		model.addAttribute("contentsCategoryList", contentsCategoryList);

		return "user/contents/contentsForm/exhibitionUpdate";
	}

	@GetMapping("/movieRegist")
	public String movieRegPage(Model model,
									HttpSession session){
		String userId = (String) session.getAttribute("SID");
		List<ContentsCategory> contentsCategoryList = contentsService.getContentsCategoryOnReg("A03");
		if(userId != null) {
			Store storeInfo = contentsService.getSessionStoreInfo(userId);
			model.addAttribute("storeInfo", storeInfo);
		} else {
			return "redirect:/user";
		}
		model.addAttribute("title", "영화 컨텐츠 등록");
		model.addAttribute("contentsCategoryList", contentsCategoryList);

		return "user/contents/contentsForm/movieRegist";
	}

	@GetMapping("/movieUpdate")
	public String modifyMovieContentsPage(Model model,
											   @RequestParam(name="contentsId") String contentsId,
											   HttpSession session) {

		String userId = (String) session.getAttribute("SID");
		List<ContentsCategory> contentsCategoryList = contentsService.getContentsCategoryOnReg("A03");
		Contents contentsInfo = contentsService.getContentsInfoByContentsId(contentsId);

		if(userId != null) {
			Store storeInfo = contentsService.getSessionStoreInfo(userId);
			model.addAttribute("storeInfo", storeInfo);
		} else {
			return "redirect:/user";
		}

		model.addAttribute("title", "영화 컨텐츠 수정");

		model.addAttribute("contentsCategoryList", contentsCategoryList);
		model.addAttribute("contentsInfo", contentsInfo);

		return "user/contents/contentsForm/movieUpdate";
	}
	
	//컨텐츠 상세 설명 -> view 에서 클릭 하면 들어 가는 경로로
	@GetMapping("/contentsDetail")
	public String contentsDetail(Model model,
								 @RequestParam(name="contentsId") String contentsId) {

		Map<String, Object> contentsDetailInfo = contentsService.getContentsDetailInfo(contentsId);

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

		List<StoreCategory> storeCategory = contentsService.getStoreCategory();

		List<ContentsCategory> contentsCategory = contentsService.getContentsCategory();

		Map<String, Object> resultMap = contentsService.getContentsInfoListByTabValueAndSearch(currentPage, tabValue, performanceGenre, area, startDate, endDate, searchValue);

		List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");

		int lastPage = (int) resultMap.get("lastPage");
		int startPageNum = (int) resultMap.get("startPageNum");
		int endPageNum = (int) resultMap.get("endPageNum");
		int contentsCnt = ((Double) resultMap.get("contentsCnt")).intValue();

		model.addAttribute("title", "컨텐츠 조회");
		model.addAttribute("storeCategory", storeCategory);
		model.addAttribute("contentsCategory", contentsCategory);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("contentsInfoList", contentsInfoList);
		model.addAttribute("contentsCnt", contentsCnt);
		model.addAttribute("tabValue", tabValue);
		model.addAttribute("performanceGenre", performanceGenre);

		return "user/contents/contentsInfoList";
	}

	@GetMapping("/form")
	public String addFile(Model model,
						HttpSession session) {
		String userId = (String) session.getAttribute("SID");

		if(userId != null) {
			Store storeInfo = contentsService.getSessionStoreInfo(userId);
			storeInfo.setUserId(userId);
			model.addAttribute("storeInfo", storeInfo);
		} else {
			return "redirect:/user";
		}
		return "user/contents/contentsForm/temporaryAddFile";
	}

	@PostMapping("/form")
	public String addFile(@RequestParam MultipartFile contentsFile) {
		contentsService.fileUpload(contentsFile, "CNT202311220001", "id034");
		return "redirect:/user/contents/form";
	}
}
