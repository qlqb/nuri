package ksmart.ks48team01.user.controller;

import ksmart.ks48team01.dto.Contents;
import ksmart.ks48team01.service.ContentsService;
import ksmart.ks48team01.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user/payment")
public class PaymentController {

	public static final Logger log = LoggerFactory.getLogger(PaymentController.class);

	private final PaymentService paymentService;
	private final ContentsService contentsService;
	public PaymentController(PaymentService paymentService, ContentsService contentsService){
		this.paymentService = paymentService;
		this.contentsService = contentsService;
	}


	//DB 카드 정보확인
	/*@PostMapping("/cardCheck")
	@ResponseBody
	public boolean cardCheck(@RequestParam(name="munhwaCardNum") String munhwaCardNum){
		log.info("munhwaCardNum: ", munhwaCardNum);
		return paymentService.cardCheck(munhwaCardNum);
	}*/




	@PostMapping("/payment")
	public String paymentPage(Model model,
							  @RequestParam(name="contentsId") String contentsId,
							  @RequestParam(name="ticketNum") String ticketNum,
							  @RequestParam(name="contentsPrice") String contentsPrice){

		//컨텐츠 리스트 들고와서 결제(예매)버튼 클릭하면 해당 컨텐츠 내용 전송
		Map<String, Object> contentsDetailInfo = contentsService.getContentsDetailInfo(contentsId);

		log.info("contentsDetailInfo: {}",  contentsDetailInfo);
		log.info("");

		model.addAttribute("title", "결제 정보 페이지");
		model.addAttribute("contentsDetailInfo", contentsDetailInfo);
		model.addAttribute("ticketNum", ticketNum);
		model.addAttribute("contentsPrice", contentsPrice);


		return "user/payment/payment";
	}
}
