package ksmart.ks48team01.admin.controller;


import ksmart.ks48team01.dto.Board;
import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ksmart.ks48team01.dto.Budget;
import ksmart.ks48team01.dto.BudgetRegion;
import com.google.gson.Gson;
import ksmart.ks48team01.service.BudgetService;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("AdminBudgetController")
@RequestMapping(value = "/admin/budget")
public class AdminBudgetController {

	private static final Logger log = LoggerFactory.getLogger(AdminBudgetController.class);

	private final BudgetService budgetService;
	private final AreaService areaService;
	public AdminBudgetController(BudgetService budgetService, AreaService areaService) {
		this.budgetService = budgetService;
		this.areaService = areaService;
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
	 * 연도/지역 중복체크 (ajax 요청 응답)
	 * @param applyYear (입력받은 연도)
	 * @return @ResponseBody 응답시 body 영역에 응답한 데이터를 전달
	 */
	@PostMapping("/yearRegionCheck")
	@ResponseBody
	public boolean yearRegionCheck(@RequestParam(name="applyYear") String applyYear,
								   @RequestParam(name="regionCode") int regionCode) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("applyYear", applyYear);
		map.put("regionCode", regionCode);
		return budgetService.yearRegionCheck(map);
	}

	/**
	 * 전국 단위 예산 등록 처리
	 * @param budget
	 * @return redirect:/admin/budget/budgetTotalList
	 */
	@PostMapping("/budgetInfo")
	public String budgetRegist(Budget budget){

		budgetService.addBudgetTotal(budget);

		return "redirect:/admin/budget/budgetInfo";
	}

	/**
	 * 지역 단위 예산 등록 처리
	 * @param budgetRegion
	 * @return 각 지역 예산 조회 페이지로 이동
	 */
	@PostMapping("/budgetInfoRegion")
	public String addBudgetRegion(BudgetRegion budgetRegion){

		log.info("budgetRegion : {}", budgetRegion);
		List<Region> regionList = areaService.getRegionList();
		budgetService.addBudgetRegion(budgetRegion);

		return "redirect:/admin/budget/budgetInfoRegion";
	}

	/**
	 * 예산 등록 페이지
	 * @param model
	 * @return view -> budget/budgetRegist
	 */
	@GetMapping("/budgetRegist")
	public String budgetRegist(Model model) {
		List<Region> regionList = areaService.getRegionList();
		model.addAttribute("title", "예산 등록");
		model.addAttribute("regionList", regionList);
		return "admin/budget/budgetRegist";
	}

	/**
	 * 전국 단위 예산 조회
	 * @param model
	 * @return view => budget/budgetInfo 예산 목록 페이지
	 */
	@GetMapping(value={"budgetInfo"})
	public String budgetInfo(Model model,
							 @RequestParam(name="applyYear", required = false) String applyYear) {

		List<Budget> budgetTotalList = null;
		log.info("applyYear : {}", applyYear);

		if(applyYear != null) {
			budgetTotalList = budgetService.getBudgetTotalSearch(applyYear);
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
	public String budgetInfoRegion(@RequestParam(name="searchKey", required = false) String searchKey,
								   @RequestParam(name="searchValue", required = false, defaultValue = "") String searchValue,
								   Model model) {

		List<BudgetRegion> budgetRegionList = null;
		if(searchKey != null){
			budgetRegionList = budgetService.getBudgetRegionListBySearch(searchKey, searchValue);
		}else{
			budgetRegionList = budgetService.getBudgetRegionList();
		}

		List<Region> regionList = areaService.getRegionList();
		model.addAttribute("budgetRegionList", budgetRegionList);
		model.addAttribute("title", "지역 예산 조회");
		model.addAttribute("regionList", regionList);
		return "admin/budget/budgetInfoRegion";
	}

	/**
	 * 전국 단위 예산 수정 화면
	 * @param @RequestParam String applyYear
	 * @return
	 */
	@GetMapping(value={"budgetUpdate"})
	public String budgetUpdate(@RequestParam(name="applyYear") String applyYear, Model model) {

		log.info("applyYear : {}", applyYear);

		Budget budget = budgetService.getBudgetTotalByYear(applyYear);

		model.addAttribute("title", "예산 수정");
		model.addAttribute("budget", budget);
		return "admin/budget/budgetUpdate";
	}

	/**
	 * 지역 단위 예산 수정 화면
	 * @param @RequestParam String applyYear
	 * @return
	 */
	@GetMapping(value={"budgetUpdateRegion"})
	public String budgetUpdateRegion(@RequestParam(name="budgetRegionNum") String budgetRegionNum,
									 Model model) {
		log.info("budgetRegionNum : {}", budgetRegionNum);

		BudgetRegion budgetRegion = budgetService.getBudgetRegionBySearch(budgetRegionNum);
		log.info("budgetRegion : {}", budgetRegion);

		model.addAttribute("title", "지역 예산 수정");
		model.addAttribute("budgetRegion", budgetRegion);
		return "admin/budget/budgetUpdateRegion";
	}

	/**
	 * 전국 단위 예산 수정 처리
	 */
	@PostMapping("budgetUpdate")
	public String updateBudgetTotal(Budget budget){
		budgetService.updateBudgetTotal(budget);
		return "redirect:/admin/budget/budgetInfo";
	}

	/**
	 * 지역 단위 예산 수정 처리
	 */
	@PostMapping("budgetUpdateRegion")
	public String updateBudgetRegion(BudgetRegion budgetRegion){
		log.info("budgetRegion : {}", budgetRegion);
		budgetService.updateBudgetRegion(budgetRegion);
		return "redirect:/admin/budget/budgetInfoRegion";
	}

	/**
	 * 전국 단위 예산 삭제
	 * @param applyYear, model
	 * @return
	 */
	@GetMapping(value={"removeBudgetTotal"})
	public String removeBudgetTotal(@RequestParam(name="applyYear") String applyYear, Model model){
		budgetService.removeBudgetTotal(applyYear);
		//나중에 사용률 통계 테이블에서도 삭제하는 거 추가
		return "redirect:/admin/budget/budgetInfo";
	}

	/**
	 * 지역 단위 예산 삭제
	 * @param budgetRegionNum, model
	 * @return
	 */
	@GetMapping(value={"removeBudgetRegion"})
	public String removeBudgetRegion(@RequestParam(name="budgetRegionNum") String budgetRegionNum, Model model){
		budgetService.removeBudgetRegion(budgetRegionNum);
		//나중에 사용률 통계 테이블에서도 삭제하는 거 추가
		return "redirect:/admin/budget/budgetInfoRegion";
	}

}
