package ksmart.ks48team01.user.controller;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team01.dto.MunhwaCard;
import ksmart.ks48team01.dto.Payment;
import ksmart.ks48team01.service.ContentsService;
import ksmart.ks48team01.service.MunhwaCardService;
import ksmart.ks48team01.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//로그인 세션 가져오기


@Controller
@RequestMapping("/user/payment")
public class PaymentController {

	public static final Logger log = LoggerFactory.getLogger(PaymentController.class);

		private final PaymentService paymentService;
		private final ContentsService contentsService;
		private final MunhwaCardService munhwaCardService;

		public PaymentController(PaymentService paymentService, ContentsService contentsService, MunhwaCardService munhwaCardService){
		this.paymentService = paymentService;
		this.contentsService = contentsService;
		this.munhwaCardService = munhwaCardService;
	}

	//결제 등록 처리
	@PostMapping("/user/mypage/myOrder")
	public String paymentRegist(Payment payment){

		paymentService.paymentRegist(payment);

		return "redirect:/user/mypage/myOrder";
	}


	//DB 카드 비밀번호 확인
	@PostMapping("/cardPwCheck")
	@ResponseBody
	public boolean cardPwCheck(HttpSession session,
							   @RequestParam(name="cardPw") String cardPw){
		//세션 가져오기
		String userId = (String) session.getAttribute("SID");

		log.info("cardPw: {}", cardPw);
		log.info("userId: {}", userId);
		return munhwaCardService.cardPwCheck(userId, cardPw);
	}



	@PostMapping("/payment")
	public String paymentPage(Model model,
							  HttpSession session,
							  @RequestParam(name="contentsId") String contentsId,
							  @RequestParam(name="paymentQuantity") String paymentQuantity,
							  @RequestParam(name="contentsPrice") String contentsPrice){

		//세션 가져오기
		String userId = (String) session.getAttribute("SID");

		//컨텐츠 리스트 들고와서 결제(예매)버튼 클릭하면 해당 컨텐츠 내용 전송
		Map<String, Object> contentsDetailInfo = contentsService.getContentsDetailInfo(contentsId);

		//문화 카드 개별 조회
		MunhwaCard MunhwaCardInfo = munhwaCardService.getMunhwaCardInfoById(userId);

		log.info("contentsDetailInfo: {}",  contentsDetailInfo);
		log.info("getMunhwaCardInfoById: {}", MunhwaCardInfo);

		model.addAttribute("title", "결제 정보 페이지");
		model.addAttribute("contentsDetailInfo", contentsDetailInfo);
		model.addAttribute("paymentQuantity", paymentQuantity);
		model.addAttribute("contentsPrice", contentsPrice);
		model.addAttribute("MunhwaCardInfo", MunhwaCardInfo);


		return "user/payment/payment";
	}
}
