package ksmart.ks48team01.admin.controller;

import ksmart.ks48team01.dto.Board;
import ksmart.ks48team01.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("AdminBoardController")
@RequestMapping("/admin/board")
public class AdminBoardController {

	private final BoardService boardService;

	public AdminBoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	//게시판 컨텐츠 등록
	@GetMapping("/boardContentRegist")
	public String boardContentRegist(Model model){
		model.addAttribute("title","게시판 등록");
		/*model.addAttribute("")*/

		return "admin/board/boardContentRegist";
	}

	//게시판 컨텐츠 수정
	@GetMapping("/boardContentsModify")
	public String modifyBoardContents(@RequestParam(name="boardCode") String boardCode, Model model){
		/*Board boardInfo = boardService.getBoardInfoById(boardCode);*/

		model.addAttribute("title","게시판수정");
		/*model.addAttribute("boardInfo", boardInfo);*/

		return "admin/board/boardContentsModify";
	}
	//게시판 컨텐츠 상세 조회
	@GetMapping("/boardContentDetail")
	public String boardContentDetail(Model model){
		model.addAttribute("title","게시판컨텐츠상세조회");

		return "admin/board/boardContentDetail";
	}

	//게시판 컨텐츠 목록 조회
	@GetMapping("boardCateInfo")
	public String boardCateInfo(Model model) {

		List<Board> boardList = boardService.getBoardList();

		model.addAttribute("title","게시글 목록");
		model.addAttribute("boardList", boardList);

		return "admin/board/boardCateInfo";
	}


}
