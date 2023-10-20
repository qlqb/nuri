package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminOfficerController")
@RequestMapping("/admin/officer")
public class AdminOfficerController {

	//사용자 정보 목록 조회
	@GetMapping("depInfoList")
	public String depInfoList(Model model) {

		return "admin/officer/depInfoList";
	}
	
	//사용자 상세 정보 조회
	@GetMapping(value={"officerInfoList"})
	public String officerInfoList(Model model) {

		return "admin/officer/officerInfoList";
	}
	
	//사용자 가입
	@GetMapping(value={"officerInfoSpecific"})
	public String officerInfoSpecific(Model model) {

		return "admin/officer/officerInfoSpecific";
	}
	
	//사용자 정보 수정
	@GetMapping(value={"officerInfoRegist"})
	public String officerInfoRegist(Model model) {

		return "admin/officer/officerInfoRegist";
	}
	
	//사용자 정보 삭제
	@GetMapping(value={"officerInfoUpdate"})
	public String officerInfoUpdate(Model model) {

		return "admin/officer/officerInfoUpdate";
	}
	//사용자 정보 삭제
		@GetMapping(value={"officerInfoDelete"})
		public String officerInfoDelete(Model model) {

			return "admin/officer/officerInfoDelete";
		}

}
