package ksmart.ks48team01.admin.controller;

import ksmart.ks48team01.dto.Board;
import ksmart.ks48team01.dto.BoardCategory;
import ksmart.ks48team01.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("AdminBoardController")
@RequestMapping("/admin/board")
public class AdminBoardController {
	private static final Logger log = LoggerFactory.getLogger(AdminBoardController.class);

	private final BoardService boardService;

	public AdminBoardController(BoardService boardService) {
		this.boardService = boardService;
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

	//게시판 컨텐츠 등록 처리
	@PostMapping("/boardCateInfo")
	public String boardContentRegist(Board board){
		log.info("게시글 등록 Board: {}", board);

		boardService.boardContentRegist(board);

		return "redirect:/admin/board/boardCateInfo";
	}


	//게시판 컨텐츠 등록 폼
	@GetMapping("/boardContentRegist")
	public String boardContentRegist(Model model){
		List<BoardCategory> boardCategoryList = boardService.getBoardCategoryList();

		model.addAttribute("title","게시판 등록");
		model.addAttribute("boardCategoryList", boardCategoryList);

		return "admin/board/boardContentRegist";
	}


	//게시판 컨텐츠 목록 조회
	@GetMapping("/boardCateInfo")
	public String boardCateInfo(Model model) {

		List<Board> boardList = boardService.getBoardList();

		model.addAttribute("title","게시글 목록");
		model.addAttribute("boardList", boardList);

		return "admin/board/boardCateInfo";
	}


}
