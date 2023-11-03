package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminBoardController")
@RequestMapping("/admin/board")
public class AdminBoardController {

	//게시판 카테고리 목록 조회
	@GetMapping("boardCateInfo")
	public String boardCateInfo(Model model) {

		return "admin/board/boardCateInfo";
	}

	//사용자 상세 정보 조회
	@GetMapping(value={"boardContentRegist"})
	public String boardContentRegist(Model model) {

		return "admin/board/boardContentRegist";
	}

}
