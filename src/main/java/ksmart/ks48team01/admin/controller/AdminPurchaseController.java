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
	
	@GetMapping(value={"purchaseModify"})
	public String purchaseModify(Model model) {

		return "admin/purchase/purchaseModify";
	}

	@GetMapping(value={"purchaseInfoModify"})
	public String purchaseInfoModify(Model model) {

		return "admin/purchase/purchaseInfoModify";
	}
	
	@GetMapping(value={"adjInfoRegion"})
	public String adjInfoRegion(Model model) {

		return "admin/purchase/adjInfoRegion";
	}
	
	@GetMapping(value={"adjInfoCate"})
	public String adjInfoCate(Model model) {

		return "admin/purchase/adjInfoCate";
	}
	@GetMapping(value={"adjInfoRegionCate"})
	public String adjInfoRegionCate(Model model) {

		return "admin/purchase/adjInfoRegionCate";
	}
	
	@GetMapping(value={"adjInfoStore"})
	public String adjInfoStore(Model model) {

		return "admin/purchase/adjInfoStore";
	}

}
