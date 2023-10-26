package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminBudgetController")
@RequestMapping("/admin/budget")
public class AdminBudgetController {

	@GetMapping("budgetRegist")
	public String budgetRegist(Model model) {

		return "admin/budget/budgetRegist";
	}
	

	@GetMapping(value={"budgetInfo"})
	public String budgetInfo(Model model) {

		return "admin/budget/budgetInfo";
	}
	
	
	@GetMapping(value={"budgetInfoRegion"})
	public String budgetInfoRegion(Model model) {

		return "admin/budget/budgetInfoRegion";
	}
	

	@GetMapping(value={"budgetUpdate"})
	public String budgetUpdate(Model model) {

		return "admin/budget/budgetUpdate";
	}
	

}
