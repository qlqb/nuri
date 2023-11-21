package ksmart.ks48team01.admin.controller;


import ksmart.ks48team01.dto.MunhwaCard;
import ksmart.ks48team01.service.MunhwaCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller("AdminMunhwaCardController")
@RequestMapping(value = "/admin/user")
public class AdminMunhwaCardController {

	private static final Logger log = LoggerFactory.getLogger(AdminMunhwaCardController.class);

	private final MunhwaCardService munhwaCardService;
	public AdminMunhwaCardController(MunhwaCardService munhwaCardService) {
		this.munhwaCardService = munhwaCardService;
	}

	/**
	 * 문화누리카드 목록 조회
	 * @param model
	 * @param munhwaCardNum
	 * @return
	 */
    @GetMapping("/munhwaCardList")
    public String getMunhwaCardList(Model model, @RequestParam(name="munhwaCardNum", required = false) String munhwaCardNum){
        List<MunhwaCard> munhwaCardList = null;
		log.info("munhwaCardNum : {}", munhwaCardNum);

		if(munhwaCardNum != null) {
            munhwaCardList = munhwaCardService.getMunhwaCardList();
		}else{
            munhwaCardList = munhwaCardService.getMunhwaCardList();
		}

		model.addAttribute("munhwaCardList", munhwaCardList);
        model.addAttribute("title", "문화누리카드 정보 조회");
        return "admin/user/munhwaCardList";
    }

	/**
	 * 문화누리카드 등록 처리
	 * @param munhwaCard
	 * @return redirect:/admin/budget/budgetTotalList
	 */
	@ResponseBody
	@PostMapping("/munhwaCardRegist")
	public int munhwaCardRegist(@RequestBody MunhwaCard munhwaCard){
		log.info("munhwaCard : {}", munhwaCard);
		int insertResult = munhwaCardService.munhwaCardRegist(munhwaCard);
		System.out.println(insertResult);
		return insertResult;
	}

	/**
	 * 문화누리카드 등록 페이지 이동
	 * @param model
	 * @return
	 */
	@GetMapping("/munhwaCardRegist")
	public String munhwaCardRegist(Model model){
		log.info("카드 등록 페이지 이동");
		
		return "admin/user/munhwaCardRegist";
	}

	/**
	 * 문화누리카드 번호 중복 체크(ajax)
	 * @param munhwaCardNum
	 * @return
	 */
	@PostMapping("/cardCheck")
	@ResponseBody
	public boolean cardCheck(@RequestParam(name="munhwaCardNum") String munhwaCardNum){
		log.info("munhwaCardNum : {}", munhwaCardNum);
		return munhwaCardService.cardCheck(munhwaCardNum);
	}

//	/**
//	 * 전국 단위 예산 등록 처리
//	 * @param budget
//	 * @return redirect:/admin/budget/budgetTotalList
//	 */
//	@PostMapping("/budgetInfo")
//	public String budgetRegist(Budget budget){
//
//		budgetService.addBudgetTotal(budget);
//
//		return "redirect:/admin/budget/budgetInfo";
//	}
//
//	/**
//	 * 예산 등록 페이지
//	 * @param model
//	 * @return view -> budget/budgetRegist
//	 */
//	@GetMapping("/budgetRegist")
//	public String budgetRegist(Model model) {
//		List<Region> regionList = areaService.getRegionList();
//		model.addAttribute("title", "예산 등록");
//		model.addAttribute("regionList", regionList);
//		return "admin/budget/budgetRegist";
//	}
//
//	/**
//	 * 전국 단위 예산 조회
//	 * @param model
//	 * @return view => budget/budgetInfo 예산 목록 페이지
//	 */
//	@GetMapping(value={"budgetInfo"})
//	public String budgetInfo(Model model,
//							 @RequestParam(name="applyYear", required = false) String applyYear) {
//
//		List<Budget> budgetTotalList = null;
//		log.info("applyYear : {}", applyYear);
//
//		if(applyYear != null) {
//			budgetTotalList = budgetService.getBudgetTotalSearch(applyYear);
//		}else{
//			budgetTotalList = budgetService.getBudgetTotalList();
//		}
//
//		model.addAttribute("budgetTotalList", budgetTotalList);
//		model.addAttribute("title", "예산조회");
//
//		return "admin/budget/budgetInfo";
//	}
//
//
//
//	/**
//	 * 전국 단위 예산 수정 화면
//	 * @param @RequestParam String applyYear
//	 * @return
//	 */
//	@GetMapping(value={"budgetUpdate"})
//	public String budgetUpdate(@RequestParam(name="applyYear") String applyYear, Model model) {
//
//		log.info("applyYear : {}", applyYear);
//
//		Budget budget = budgetService.getBudgetTotalByYear(applyYear);
//
//		model.addAttribute("title", "예산 수정");
//		model.addAttribute("budget", budget);
//		return "admin/budget/budgetUpdate";
//	}
//
//	/**
//	 * 지역 단위 예산 수정 화면
//	 * @param @RequestParam String applyYear
//	 * @return
//	 */
//	@GetMapping(value={"budgetUpdateRegion"})
//	public String budgetUpdateRegion(@RequestParam(name="budgetRegionNum") String budgetRegionNum,
//									 Model model) {
//		log.info("budgetRegionNum : {}", budgetRegionNum);
//
//		BudgetRegion budgetRegion = budgetService.getBudgetRegionBySearch(budgetRegionNum);
//		log.info("budgetRegion : {}", budgetRegion);
//
//		model.addAttribute("title", "지역 예산 수정");
//		model.addAttribute("budgetRegion", budgetRegion);
//		return "admin/budget/budgetUpdateRegion";
//	}
//
//	/**
//	 * 전국 단위 예산 수정 처리
//	 */
//	@PostMapping("budgetUpdate")
//	public String updateBudgetTotal(Budget budget){
//		budgetService.updateBudgetTotal(budget);
//		return "redirect:/admin/budget/budgetInfo";
//	}
//
//
//	/**
//	 * 전국 단위 예산 삭제
//	 * @param applyYear, model
//	 * @return
//	 */
//	@GetMapping(value={"removeBudgetTotal"})
//	public String removeBudgetTotal(@RequestParam(name="applyYear") String applyYear, Model model){
//		budgetService.removeBudgetTotal(applyYear);
//		//나중에 사용률 통계 테이블에서도 삭제하는 거 추가
//		return "redirect:/admin/budget/budgetInfo";
//	}

}
