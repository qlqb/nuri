package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("AdminUserController")
@RequestMapping("/admin/user")
public class AdminUserController {

	//사용자 정보 목록 조회
	@GetMapping("userInfoList")
	public String UserInfoList(Model model) {

		model.addAttribute("title", "관리자 페이지");
		model.addAttribute("head", "지역/행정기관");

		return "admin/user/userInfoList";
	}
	
	//사용자 상세 정보 조회
	@GetMapping(value={"userInfoSpecific"})
	public String UserInfoSpecific(Model model) {

		model.addAttribute("title", "관리자 페이지");
		model.addAttribute("head", "지역/행정기관");

		return "admin/user/userInfoSpecific";
	}

	
	//사용자 가입
	@GetMapping(value={"userInfoRegist"})
	public String UserInfoRegist(Model model) {

		return "admin/user/userInfoRegist";
	}


	/**
	 * 회원정보 수정 전송
	 * @param model
	 * @return
	 */
	@PostMapping("userInfoUpdate")
	public String userModifyUpdate(Model model) {

		return "redirect:/admin/user/userInfoList";
	}


	@GetMapping(value={"/userManualRegist"})
	public String userManualRegist(Model model) {

		return "admin/user/userManualRegist";
	}

	/**
	 * 사용자 정보 수정
	 * @param userId 정보 수정 시에 수정할 회원의 아이디
	 * @param model
	 * @return
	 */
	@GetMapping(value={"userInfoUpdate"})
	public String UserInfoUpdate(@RequestParam(name = "userId") String userId, Model model) {

		model.addAttribute("title", "사용자 정보 수정");

		return "admin/user/userInfoUpdate";
	}
	
	//사용자 정보 삭제
	@GetMapping(value={"userInfoDelete"})
	public String UserInfoDelete(Model model) {

		return "admin/user/userInfoDelete";
	}

}
