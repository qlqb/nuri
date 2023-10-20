package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminContentsController")
@RequestMapping("/admin/contents")
public class AdminContentsController {

	//사용자 정보 목록 조회
	@GetMapping("contentsInfoList")
	public String contentsInfoList(Model model) {

		return "admin/contents/contentsInfoList";
	}
	
	//사용자 상세 정보 조회
	@GetMapping(value={"contentsInfoSpecific"})
	public String contentsInfoSpecific(Model model) {

		return "admin/contents/contentsInfoSpecific";
	}
	
	//사용자 가입
	@GetMapping(value={"contentsInfoRegist"})
	public String contentsInfoRegist(Model model) {

		return "admin/contents/contentsInfoRegist";
	}
	
	//사용자 정보 수정
	@GetMapping(value={"contentsInfoUpdate"})
	public String contentsInfoUpdate(Model model) {

		return "admin/contents/contentsInfoUpdate";
	}
	
	//사용자 정보 삭제
	@GetMapping(value={"contentsInfoDelete"})
	public String contentsInfoDelete(Model model) {

		return "admin/contents/contentsInfoDelete";
	}

}
