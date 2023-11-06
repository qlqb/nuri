package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("myPageController")
@RequestMapping("/user/mypage")
public class MyPageController {

	public String mypage = "마이페이지";

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

	@GetMapping("/myOrder")
	public String myOrder(Model model) {

		model.addAttribute("title", "나의 주문/예약 조회");
		model.addAttribute("head", mypage);

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

	@GetMapping("/myContentsList")
	public String myContentsList(Model model) {

		model.addAttribute("title", "내 컨텐츠 목록");
		model.addAttribute("head", mypage);

		return "user/mypage/myContentsList";
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
