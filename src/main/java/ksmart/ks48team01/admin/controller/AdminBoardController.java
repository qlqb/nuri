package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminBoardController")
@RequestMapping("/admin/board")
public class AdminBoardController {

	//사용자 정보 목록 조회
	@GetMapping("boardCate")
	public String boardCate(Model model) {

		return "admin/board/boardCate";
	}
	
	//사용자 상세 정보 조회
	@GetMapping(value={"boardInfo"})
	public String boardInfo(Model model) {

		return "admin/board/boardInfo";
	}

}
