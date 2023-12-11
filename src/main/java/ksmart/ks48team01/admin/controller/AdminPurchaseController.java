package ksmart.ks48team01.admin.controller;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team01.dto.Payment;
import ksmart.ks48team01.service.PaymentService;
import ksmart.ks48team01.user.controller.MyPageController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller("AdminPurchaseController")
@RequestMapping("/admin/purchase")
public class AdminPurchaseController {

	private static final Logger log = LoggerFactory.getLogger(MyPageController.class);

	private final PaymentService paymentService;

	public AdminPurchaseController(PaymentService paymentService){
		this.paymentService = paymentService;
	}

	@PostMapping("/searchPurchases")
	@ResponseBody
	public List<Payment> purchaseInfo(@RequestBody List<Map<String, Object>> searchList){
		log.info("searchList:{}", searchList);

		List<Payment> paymentList = paymentService.getPaymentList(searchList);
		return paymentList;
	}


	@GetMapping(value={"/purchaseInfo"})
	public String purchaseInfo(Model model, HttpSession session,
							   				@RequestParam(name="searchKey", required = false) String searchKey,
							   				@RequestParam(name="searchValue", required = false, defaultValue = "") String searchValue) {

		String userId = (String) session.getAttribute("SID");

		String paymentCnt = paymentService.getPaymentCount(userId);
		String paymentAmount = paymentService.getPaymentAmount(userId);
		List<Payment> paymentList = paymentService.getPaymentList();

		/*if(searchKey != null){
			paymentList = paymentService.getPaymentList(searchKey, searchValue);
		}else {
			paymentList = paymentService.getPaymentList();
		}*/

		log.info("PaymentList: {}", paymentList);

		model.addAttribute("title", "결제내역 조회");

		model.addAttribute("paymentList", paymentList);
		model.addAttribute("paymentCnt", paymentCnt);
		model.addAttribute("paymentAmount", paymentAmount);


		return "admin/purchase/purchaseInfo";
	}

	@GetMapping(value={"/purchaseInfoModify"})
	public String purchaseInfoModify(Model model) {

		return "admin/purchase/purchaseInfoModify";
	}
	
	@GetMapping(value={"/adjInfoRegion"})
	public String adjInfoRegion(Model model) {

		return "admin/purchase/adjInfoRegion";
	}
	
	@GetMapping(value={"/adjInfoCate"})
	public String adjInfoCate(Model model) {

		return "admin/purchase/adjInfoCate";
	}
	@GetMapping(value={"/adjInfoRegionCate"})
	public String adjInfoRegionCate(Model model) {

		return "admin/purchase/adjInfoRegionCate";
	}
	
	/*@GetMapping(value={"/adjInfoStore"})
	public String adjInfoStore(Model model) {

		return "admin/purchase/adjInfoStore";
	}
*/

}
