package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("myPageController")
@RequestMapping("/user/mypage")
public class MyPageController {

	public String mypage = "마이페이지";

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

	@GetMapping("/myInfoClose")
	public String myInfoClose(Model model) {

		model.addAttribute("title", "나의 계정 해지");
		model.addAttribute("head", mypage);

		return "user/mypage/myInfoClose";
	}

	@GetMapping("/myOrder")
	public String myOrder(Model model) {

		model.addAttribute("title", "나의 주문/예약 조회");
		model.addAttribute("head", mypage);

		return "user/mypage/myOrder";
	}

	@GetMapping("/myRefund")
	public String myRefund(Model model) {

		model.addAttribute("title", "주문 취소/환불 조회");
		model.addAttribute("head", mypage);

		return "user/mypage/myRefund";
	}

	@GetMapping("/myBoard")
	public String myBoard(Model model) {

		model.addAttribute("title", "나의 작성한 게시글");
		model.addAttribute("head", mypage);


		return "user/mypage/myBoard";
	}

	@GetMapping("/myContents")
	public String myContents(Model model) {

		model.addAttribute("title", "나의 컨텐츠 조회");
		model.addAttribute("head", mypage);


		return "user/mypage/myContents";
	}

	@GetMapping("/myStore")
	public String myStore(Model model) {

		model.addAttribute("title", "나의 가맹점 정보");
		model.addAttribute("head", mypage);


		return "user/mypage/myStore";
	}

	@GetMapping("/myStoreModify")
	public String myStoreModify(Model model) {

		model.addAttribute("title", "나의 가맹점 수정");
		model.addAttribute("head", mypage);


		return "user/mypage/myStoreModify";
	}




}