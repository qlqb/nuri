package ksmart.ks48team01.admin.controller;

import com.google.gson.Gson;
import ksmart.ks48team01.dto.Board;
import ksmart.ks48team01.dto.BoardCategory;
import ksmart.ks48team01.dto.User;
import ksmart.ks48team01.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller("AdminBoardController")
@RequestMapping("/admin/board")
public class AdminBoardController {
	private static final Logger log = LoggerFactory.getLogger(AdminBoardController.class);

	private final BoardService boardService;

	public AdminBoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	//게시판 페이징 처리 미완


	//게시글 삭제 처리
	@PostMapping("/removeBoardContents")
	public String removeBoardContents(Board board, RedirectAttributes reAttr) {
		String boardCode = board.getBoardCode();
		boardService.removeBoardContents((boardCode));

		return "redirect:/admin/board/boardCateInfo";
	}


	//게시판 컨텐츠 상세 조회
	@GetMapping("/boardContentDetail")
	public String boardContentDetail(@RequestParam(name="boardCode") String boardCode, Model model){
		List<BoardCategory> boardCategoryList = boardService.getBoardCategoryList();

		Board boardInfo = boardService.getBoardInfoById(boardCode);

		model.addAttribute("title","게시판컨텐츠상세조회");
		model.addAttribute("boardInfo", boardInfo);
		model.addAttribute("boardCategoryList", boardCategoryList);

		return "admin/board/boardContentDetail";
	}

	//json으로 게시글 검색
	@ResponseBody
	@PostMapping("/boardSearchList")
	public String boardSearchList(@RequestBody Map<String, Object> paramMap){
		Gson gson = new Gson();
		List<Board> boardSearchList;

		System.out.println(paramMap);
		String searchKey = (String) paramMap.get("searchKey");
		searchKey = switch(searchKey){
			case "boardCateCode" -> "c.BOARD_CATE_CODE";
			case "boardCateName" -> "c.BOARD_CATE_NAME";
			case "userId" -> "u.USER_ID";
			case "boardWritingTitle" -> "b.BOARD_WRITING_TITLE";
			default -> searchKey;
		};

		String searchValue = (String) paramMap.get("searchValue");
		System.out.println(searchKey + "/" + searchValue);

		if(searchValue != null){
			boardSearchList = boardService.boardSearchList(searchKey, searchValue);
		}else {
			boardSearchList = boardService.getBoardList();
		}

		return gson.toJson(boardSearchList);
	}


	//게시판 컨텐츠 수정 처리
	@PostMapping("/boardContentModify")
	public String modifyBoardContents(Board board){

		boardService.modifyBoardContents(board);

		log.info("게시글 수정 Board:{}", board);
		return "redirect:/admin/board/boardCateInfo";
	}

	//게시판 컨텐츠 수정 폼
	@GetMapping("/boardContentModify")
	public String modifyBoardContents(@RequestParam(name="boardCode") String boardCode, Model model){
		List<BoardCategory> boardCategoryList = boardService.getBoardCategoryList();

		Board boardInfo = boardService.getBoardInfoById(boardCode);
		/*User userInfo = userService.getUserInfoById(userId)*/

		model.addAttribute("title","게시판수정");
		model.addAttribute("boardInfo", boardInfo);
		model.addAttribute("boardCategoryList", boardCategoryList);

		log.info("boardInfo:{}", boardInfo);

		return "admin/board/boardContentModify";
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
		List<BoardCategory> boardCategoryList = boardService.getBoardCategoryList();

		model.addAttribute("title","게시글 목록");
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCategoryList", boardCategoryList);

		model.addAttribute("startPageNum",1);
		model.addAttribute("endPageNum",1);

		return "admin/board/boardCateInfo";
	}


}
