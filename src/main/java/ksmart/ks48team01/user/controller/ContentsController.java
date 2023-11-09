package ksmart.ks48team01.user.controller;

import com.sun.source.tree.MemberSelectTree;
import ksmart.ks48team01.service.ContentsService;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.modelmbean.RequiredModelMBean;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller("contentsController")
@RequestMapping("/user/contents")
public class ContentsController {

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
	
	//컨텐츠 상세설명 -> view에서 클릭하면 들어가는 경로로
	@GetMapping(value={"/contentsDetail"})
	public String contentsDetail(Model model) {
		
		model.addAttribute("title", "컨텐츠 상세설명");
		
		return "user/contents/contentsDetail";
	}
	
	//컨텐츠 전체 목록 조회
		@GetMapping("/contentsInfoList")
		public String contentsListPage(Model model,
									   @RequestParam(name="currentPage", required=false, defaultValue = "1") int currentPage) {

			Map<String, Object> resultMap = contentsService.getContentsInfoList(currentPage);
			System.out.println(resultMap.get("contentsInfoList").getClass().getName());
			List<Map<String, Object>> contentsInfoList = (List<Map<String, Object>>) resultMap.get("contentsInfoList");
			List<Map.Entry<String, Object>> contentsMap = resultMap.entrySet().stream().toList();
			System.out.println("3333333333333333" + contentsInfoList);
//			contentsMap.
			int lastPage = (int) resultMap.get("lastPage");
			int startPageNum = (int) resultMap.get("startPageNum");
			int endPageNum = (int) resultMap.get("endPageNum");

			model.addAttribute("title", "컨텐츠 조회");
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("lastPage", lastPage);
			model.addAttribute("startPageNum", startPageNum);
			model.addAttribute("endPageNum", endPageNum);
			model.addAttribute("contentsInfoList", contentsInfoList);

			return "user/contents/contentsInfoList";
		}

		@GetMapping(value = {"reservation"})
		public String reservation(Model model) {
			model.addAttribute("title", "예약 화면");
			return "user/contents/reservation";
		}

}
