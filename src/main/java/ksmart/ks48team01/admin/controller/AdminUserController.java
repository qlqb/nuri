package ksmart.ks48team01.admin.controller;

import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.dto.User;
import ksmart.ks48team01.service.AreaService;
import ksmart.ks48team01.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

	@GetMapping("/adminRegister")
	public String adminRegister(Model model) {
		// 사용자 가입 시, Form에 들어갈 카테고리의 데이터를 조회하여 전송
		// 조회한 데이터를 Model를 통해 View로 전송, Thymeleaf의 each 등을 통해 도메인을 출력
		List<Region> regionList = areaService.getRegionList();

		model.addAttribute("regionList", regionList);

		return "admin/user/adminRegister";
	}


	/**
	 * 관리자 회원가입 페이지 Form POST 전송
	 * @param user 입력받은 회원가입 양식의 값
	 */
	@PostMapping("/adminRegister")
	public String adminRegister(User user) {
		userService.adminRegister(user);

		return "redirect:/admin/user/userInfoList";
	}



	/**
	 * 사용자 정보 수정 Form 페이지
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

	/**
	 * 회원정보 수정 전송
	 * @param model
	 * @return
	 */
	@PostMapping("/userInfoUpdate")
	public String userInfoUpdate(Model model) {

		return "redirect:/admin/user/userInfoList";
	}



	@PostMapping("/userDeleteByAdmin")
	public String userDeleteByAdmin(@RequestParam(value = "deleteTarget", required = true) String deleteTarget,
									@RequestParam(value = "targetLevel", required = true) int targetLevel) {

		// switch 이용해서 회원 권한 별 삭제 실행
		userService.userDeleteByAdmin(deleteTarget, targetLevel);

		return "redirect:/admin/user/userInfoDelete";
	}
}
