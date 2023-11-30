package ksmart.ks48team01.user.controller;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team01.dto.Contents;
import ksmart.ks48team01.dto.Payment;
import ksmart.ks48team01.service.ContentsService;
import ksmart.ks48team01.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("myPageController")
@RequestMapping("/user/mypage")
public class MyPageController {

	private static final Logger log = LoggerFactory.getLogger(MyPageController.class);

	private final PaymentService paymentService;
	private final ContentsService contentsService;

	public MyPageController(PaymentService paymentService, ContentsService contentsService){
		this.paymentService = paymentService;
		this.contentsService = contentsService;
	}

	public String mypage = "마이페이지";

	@GetMapping("/myContentsList")
	public String myContentsList(Model model,
								 HttpSession session) {

		String userId = (String) session.getAttribute("SID");
		if(userId != null) {
			List<Contents> contentsInfoList = contentsService.getContentsInfoByUserId(userId);
			model.addAttribute("contentsInfoList", contentsInfoList);
		}
		return "user/mypage/myContentsList";
	}

	@GetMapping("/mypageMain")
	public String myPageMain(Model model) {

		model.addAttribute("title", "마이페이지");
		model.addAttribute("head", mypage);

		return "/user/mypage/mypageMain";
	}	
	
	@GetMapping("/myInfo")
	public String myInfo(Model model) {

		model.addAttribute("title", "나의 정보");
		model.addAttribute("head", mypage);

		return "user/mypage/myInfo";
	}

	@GetMapping("/myInfoModify")
	public String myInfoModify(Model model) {

		model.addAttribute("title", "나의 정보 수정");
		model.addAttribute("head", mypage);

		return "user/mypage/myInfoModify";
	}

	@GetMapping("/myCard")
	public String myCard(Model model) {

		model.addAttribute("title", "내 카드");
		model.addAttribute("head", mypage);

		return "user/mypage/myCard";
	}

	@GetMapping("/myCardModify")
	public String myCardModify(Model model) {

		model.addAttribute("title", "내 카드");
		model.addAttribute("head", mypage);

		return "user/mypage/myCardModify";
	}

	@GetMapping("/myCardCharge")
	public String myCardCharge(Model model) {

		model.addAttribute("title", "내 카드");
		model.addAttribute("head", mypage);

		return "user/mypage/myCardCharge";
	}

	//결제내역 조회
	@GetMapping("/myOrder")
	public String myOrder(HttpSession session,
						  Model model) {
		//세션 가져오기
		String userId = (String) session.getAttribute("SID");

		String paymentCnt = paymentService.getPaymentCount(userId);
		String paymentAmount = paymentService.getPaymentAmount(userId);
		List<Payment> paymentListById = paymentService.paymentListById(userId);

		log.info("paymentAmount:{}", paymentAmount);
		log.info("paymentCnt:{}", paymentCnt);
		log.info("paymentListById: {}", paymentListById);

		model.addAttribute("title", "나의 주문/예약 조회");
		model.addAttribute("head", mypage);

		model.addAttribute("paymentListById", paymentListById);
		model.addAttribute("paymentCnt", paymentCnt);
		model.addAttribute("paymentAmount", paymentAmount);


		return "user/mypage/myOrder";
	}

	@GetMapping("/myStore")
	public String myStore(Model model) {

		model.addAttribute("title", "내 가맹점 정보");
		model.addAttribute("head", mypage);

		return "user/mypage/myStore";
	}

	@GetMapping("/myStoreModify")
	public String myStoreModify(Model model) {

		model.addAttribute("title", "내 가맹점 정보 수정");
		model.addAttribute("head", mypage);

		return "user/mypage/myStoreModify";
	}

	@GetMapping("/myStoreAdj")
	public String myStoreAdj(Model model) {

		model.addAttribute("title", "가맹점 정산 조회");
		model.addAttribute("head", mypage);

		return "user/mypage/myStoreAdj";
	}

	@GetMapping("/myStoreSaleHistory")
	public String myStoreSaleHistory(Model model) {

		model.addAttribute("title", "가맹점 정산 조회");
		model.addAttribute("head", mypage);

		return "user/mypage/myStoreSaleHistory";
	}

	@GetMapping("/myContentsRegist")
	public String myContentsRegist(Model model) {

		model.addAttribute("title", "컨텐츠 등록하기");
		model.addAttribute("head", mypage);

		return "user/mypage/myContentsRegist";
	}

	@GetMapping("/myContents")
	public String myContents(Model model) {

		model.addAttribute("title", "내 컨텐츠 상세");
		model.addAttribute("head", mypage);

		return "user/mypage/myContents";
	}

	@GetMapping("/myContentsModify")
	public String myContentsListModify(Model model) {

		model.addAttribute("title", "내 컨텐츠 수정");
		model.addAttribute("head", mypage);

		return "user/mypage/myContentsModify";
	}

}
