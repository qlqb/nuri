package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminPurchaseController")
@RequestMapping("/admin/purchase")
public class AdminPurchaseController {


	@GetMapping("reservationInfo")
	public String reservationInfo(Model model) {

		return "admin/purchase/reservationInfo";
	}
	

	@GetMapping(value={"purchaseInfo"})
	public String purchaseInfo(Model model) {

		return "admin/purchase/purchaseInfo";
	}

	@GetMapping(value={"adjInfo"})
	public String adjInfo(Model model) {

		return "admin/purchase/adjInfo";
	}

}
