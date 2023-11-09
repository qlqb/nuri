package ksmart.ks48team01.admin.controller;

import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.dto.User;
import ksmart.ks48team01.service.AreaService;
import ksmart.ks48team01.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 회원 관련 CRUD 처리
 * 사용자, 가맹점, 공무원의 회원 정보를 수정 및 등급에 따른 회원 삭제 처리
 */

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

	// 의존성 주입
	private final UserService userService;
	private final AreaService areaService;
	public AdminUserController (UserService userService, AreaService areaService) {
		this.userService = userService;
		this.areaService = areaService;
	}



	/**
	 * 유저 정보 조회 페이지
	 * @param model
	 * @return
	 */
	@GetMapping("/userInfoList")
	public String userInfoList(Model model) {
		// 조건문을 사용
		// 전체 회원 페이지를 조회하는 경우 기존 목록조회 Model을 실행
		// 검색을 사용할 경우의 특정회원을 조회하는 Model을 실행

		List<User> userList = userService.getUserList();

		model.addAttribute("userList", userList);

		return "admin/user/userInfoList";
	}

	/**
	 * 사용자 정보 수정
	 * @param model select해서 해당 회원의 정보 가지고 와서 출력
	 *              회원가입 Form과 같이, Category에 해당하는 정보는 <select>와 반복문 사용
	 * @return
	 */
	@GetMapping("/userInfoUpdate")
	public String userInfoUpdate(Model model, @RequestParam(name= "userId") String userId) {
		User specificUserList = userService.getSpecificUserList(userId);
		List<Region> regionList = areaService.getRegionList();
		model.addAttribute("specificUserList", specificUserList);
		model.addAttribute("regionList", regionList);

		return "admin/user/userInfoUpdate";
	}

	@GetMapping("/manualRegister")
	public String manualRegister() {


		return "admin/user/manualRegister";
	}

	/**
	 * 회원정보 수정 전송
	 * @param model
	 * @return
	 */
	@PostMapping("/userInfoUpdate")
	public String userInfoUpdate(Model model) {

		return "redirect:/admin/user/userInfoList";
	}


	/**
	 * 아이디 중복검사를 위한 Ajax 응답
	 * @param userId -> Mapper에서 #{memberId}를 조회, count를 통해 boolean 값으로 전송
	 * @return
	 */
	@PostMapping("/userIdCheck")
	@ResponseBody
	public boolean userIdCheck(@RequestParam(name = "userId") String userId) {
		// String으로 입력받은 Id 매개변수를 Service 단에서 중복검사
		// Mapper 단에서 Id 매개변수를 조회, SELECT의 count를 사용하여 boolean 값을 return
		// Return 받은 Boolean 값을 Controller에 전송, View에서 JS를 통해 중복유무를 응답

		boolean isDuplicate = true;

		return isDuplicate;
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
