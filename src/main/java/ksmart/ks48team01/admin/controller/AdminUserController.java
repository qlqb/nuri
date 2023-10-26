package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

	/**
	 * 유저 정보 조회 페이지
	 * @param model
	 * @return
	 */
	@GetMapping("/userInfoList")
	public String userInfoList(@RequestParam(name = "searchKey", required = false) String searchKey,
							   @RequestParam(name = "searchValue",  required = false) String searchValue,
							   Model model) {
		// 조건문을 사용
		// 전체 회원 페이지를 조회하는 경우 기존 목록조회 Model을 실행
		// 검색을 사용할 경우의 특정회원을 조회하는 Model을 실행

		model.addAttribute("title", "관리자 페이지");
		model.addAttribute("head", "지역/행정기관");

		return "admin/user/userInfoList";
	}

	
	
	/**
	 * 유저 가입 페이지
	 * @param model -> Form <Select>에 들어갈 데이터 전송 & Parsing (파싱에 해당되는지 모르겠음)
	 *              사용자 -> 판매자(클릭) -> 판매자에 해당하는 값(name = 2) 입력
	 * @return
	 */
	@GetMapping("/userInfoRegister")
	public String userInfoRegister(Model model) {
		// 사용자 가입 시, Form에 들어갈 카테고리의 데이터를 조회하여 전송
		// 조회한 데이터를 Model를 통해 View로 전송, Thymeleaf의 each 등을 통해 도메인을 출력
		


		return "admin/user/userInfoRegister";
	}

	

	/**
	 * 아이디 중복검사를 위한 Ajax 응답
	 * @param userId -> Mapper에서 #{memberId}를 조회, count를 통해 boolean 값으로 전송
	 * @return
	 */
	@PostMapping("/IdCheck")
	@ResponseBody
	public boolean userIdCheck(@RequestParam(name = "userId") String userId) {
		// String으로 입력받은 Id 매개변수를 Service 단에서 중복검사
		// Mapper 단에서 Id 매개변수를 조회, SELECT의 count를 사용하여 boolean 값을 return
		// Return 받은 Boolean 값을 Controller에 전송, View에서 JS를 통해 중복유무를 응답

		boolean isDuplicate = true;

		return isDuplicate;
	}



	@PostMapping("/userInfoRegister")
	public String userInfoRegister() {
		// DTO 타입으로 값 담아서 Mapper에서 Insert 실행

		return "redirect:/admin/user/userInfoList";
	}

	
	
	/**
	 * 사용자 정보 수정
	 * @param model select해서 해당 회원의 정보 가지고와서 출력
	 *              회원가입 Form과 같이, Category에 해당하는 정보는 <select>와 반복문 사용
	 * @return
	 */
	@GetMapping("/userInfoUpdate")
	public String userInfoUpdate(@RequestParam(name = "userId") String userId, Model model) {

		model.addAttribute("title", "사용자 정보 수정");

		return "admin/user/userInfoUpdate";
	}

	/**
	 * 회원정보 수정 전송
	 * @param model
	 * @return
	 */
	@PostMapping("/userInfoUpdate")
	public String userInfoUpdate(Model model) {
		// Mapper에서 Update 태그 이외에는 Insert와 동일?

		return "redirect:/admin/user/userInfoList";
	}



	@GetMapping("/userInfoDelete")
	public String userInfoDelete(@RequestParam(value = "userId") String userId,
								 Model model) {



		return "admin/user/userInfoDelete";
	}
	
	
	@PostMapping("/userInfoDelete")
	public String userInfoDelete(@RequestParam(value = "userId") String userId,
								 @RequestParam(value = "userPw") String userPw) {

		return "redirect:/admin/user/userInfoList";

	}



}
