package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userInformController")
@RequestMapping("/user/munhwa")
public class MunhwaInfoController {



	/**
	 * aboutMunhwa -> 문화누리카드 소개 및 문화누리카드 공식 페이지로 이동
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/aboutMunhwa")
	public String aboutMunhwa(Model model) {

		return "user/munhwa/aboutMunhwa";
	}

	/**
	 * Ajax 통신을 통해 등록된 문화누리카드 정보를 출력 및 새 문화누리카드를 등록하는 페이지
	 * @param model
	 * @return
	 */
	@GetMapping(value ="/munhwaRegist")
	public String munhwaRegist(Model model) {

		return "user/munhwa/munhwaRegist";
	}

	/**
	 * 결제를 통해 문화누리카드를 충전하여 사용을 할 수 있는 페이지
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/munhwaCharge")
	public String munhwaCharge(Model model) {

		return "user/munhwa/munhwaCharge";
	}

}
