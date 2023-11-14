package ksmart.ks48team01.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ksmart.ks48team01.dto.Budget;
import ksmart.ks48team01.service.BudgetService;
import java.util.List;

@Controller("AdminBudgetController")
@RequestMapping(value = "/admin/budget")
public class AdminBudgetController {

	private static final Logger log = LoggerFactory.getLogger(AdminBudgetController.class);

	private final BudgetService budgetService;
	public AdminBudgetController(BudgetService budgetService) {
		this.budgetService = budgetService;
	}

	/**
	 * 연도 중복체크 (ajax 요청 응답)
	 * @param applyYear (입력받은 연도)
	 * @return @ResponseBody 응답시 body 영역에 응답한 데이터를 전달
	 */
	@PostMapping("/yearCheck")
	@ResponseBody
	public boolean yearCheck(@RequestParam(name="applyYear") String applyYear) {

		log.info("applyYear : {}", applyYear);
        return budgetService.yearCheck(applyYear);
	}

	/**
	 * 전국 단위 예산 등록 처리
	 * @param budget
	 * @return redirect:/admin/budget/budgetTotalList
	 */
	@PostMapping("/budgetInfo")
	public String budgetRegist(Budget budget){

		log.info("예산 등록 Budget : {}", budget);
		System.out.println(budget);
		budgetService.addBudgetTotal(budget);

		return "redirect:/admin/budget/budgetInfo";
	}

	/**
	 * 지역 단위 예산 등록 처리
	 * @param budget
	 * @return 각 지역 예산 조회 페이지로 이동
	 */
	@PostMapping("/budgetInfoRegion")
	public String addBudgetRegion(Budget budget){

		log.info("예산 등록 Budget : {}", budget);

		return "redirect:/admin/budget/budgetInfoRegion";
	}

	/**
	 * 예산 등록 페이지(전국단위)
	 * @param model
	 * @return view -> budget/budgetRegist
	 */
	@GetMapping("/budgetRegist")
	public String budgetRegist(Model model) {
		model.addAttribute("title", "예산 등록");
		return "admin/budget/budgetRegist";
	}

	/**
	 * 전국 단위 예산 조회
	 * @param model
	 * @return view => budget/budgetInfo 예산 목록 페이지
	 */
	@GetMapping(value={"budgetInfo"})
	public String budgetInfo(Model model,
							 @RequestParam(name="searchYear", required = false) String searchYear) {

		List<Budget> budgetTotalList = null;
		log.info("searchYear : {}", searchYear);

		if(searchYear != null) {
			budgetTotalList = budgetService.getBudgetTotalSearch(searchYear);
		}else{
			budgetTotalList = budgetService.getBudgetTotalList();
		}

		model.addAttribute("budgetTotalList", budgetTotalList);
		model.addAttribute("title", "예산조회");

		return "admin/budget/budgetInfo";
	}

	/**
	 * 지역 단위 예산 조회
	 * @param model
	 * @return
	 */
	@GetMapping(value={"budgetInfoRegion"})
	public String budgetInfoRegion(Model model) {

		List<Budget> budgetRegionList = budgetService.getBudgetRegionList();
		return "admin/budget/budgetInfoRegion";
	}

	/**
	 * 전국 단위 예산 수정
	 * @param model
	 * @return
	 */
	@GetMapping(value={"budgetUpdate"})
	public String budgetUpdate(Model model) {

		return "admin/budget/budgetUpdate";
	}

	/**
	 * 지역 단위 예산 수정
	 * @param model
	 * @return
	 */
	@GetMapping(value={"budgetUpdateRegion"})
	public String budgetUpdateRegion(Model model) {

		return "admin/budget/budgetUpdateRegion";
	}

}
