package ksmart.ks48team01.admin.controller;

import ksmart.ks48team01.dto.Budget;
import ksmart.ks48team01.service.BudgetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("AdminBudgetController")
@RequestMapping("/admin/budget")
public class AdminBudgetController {

	private final BudgetService budgetService;
	public AdminBudgetController(BudgetService budgetService) {
		this.budgetService = budgetService;
	}

	@GetMapping("budgetRegist")
	public String budgetRegist(Model model) {

		return "admin/budget/budgetRegist";
	}
	

	@GetMapping(value={"budgetInfo"})
	public String budgetInfo(Model model) {

		List<Budget> budgetTotalList = budgetService.getBudgetTotalList();
		return "admin/budget/budgetInfo";
	}
	
	
	@GetMapping(value={"budgetInfoRegion"})
	public String budgetInfoRegion(Model model) {

		List<Budget> budgetRegionList = budgetService.getBudgetRegionList();
		return "admin/budget/budgetInfoRegion";
	}
	

	@GetMapping(value={"budgetUpdate"})
	public String budgetUpdate(Model model) {

		return "admin/budget/budgetUpdate";
	}
	@GetMapping(value={"budgetUpdateRegion"})
	public String budgetUpdateRegion(Model model) {

		return "admin/budget/budgetUpdateRegion";
	}

}
