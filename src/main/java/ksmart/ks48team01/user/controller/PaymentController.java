package ksmart.ks48team01.user.controller;

import ksmart.ks48team01.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user/payment")
public class PaymentController {

	public static final Logger log = LoggerFactory.getLogger(PaymentController.class);

	private final PaymentService paymentService;
	public PaymentController(PaymentService paymentService){this.paymentService = paymentService;}


	//DB 카드 정보확인
	/*@PostMapping("/cardCheck")
	@ResponseBody
	public boolean cardCheck(@RequestParam(name="munhwaCardNum") String munhwaCardNum){
		log.info("munhwaCardNum: ", munhwaCardNum);
		return paymentService.cardCheck(munhwaCardNum);
	}*/


	@GetMapping("/payment")
	public String paymentPage() {
		return "user/payment/payment";
	}
}
