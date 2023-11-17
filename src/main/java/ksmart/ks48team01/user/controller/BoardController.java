package ksmart.ks48team01.user.controller;

import com.google.gson.Gson;
import ksmart.ks48team01.dto.Board;
import ksmart.ks48team01.dto.BoardCategory;
import ksmart.ks48team01.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller("BoardController")
@RequestMapping("/user/board")
public class BoardController {

    private static final Logger log = LoggerFactory.getLogger(BoardController.class);

    private final BoardService boardService;

    public BoardController(BoardService boardService) {this.boardService = boardService;}

    //게시판 분류 조회
    @ResponseBody
    @PostMapping("/boardSearchCate")
    public String boardSearchCate(@RequestBody Map<String, Object> paramMap) {
        Gson gson = new Gson();
        List<Board> boardSearchCate;

        System.out.println(paramMap);
        String searchKey = (String) paramMap.get("searchKey");

        if (searchKey != null) {
            boardSearchCate = boardService.boardSearchCate(searchKey);
        } else {
            boardSearchCate = boardService.getBoardList();
        }
        return gson.toJson(boardSearchCate);
    }


    //게시판 조회
    @GetMapping("boardList")
    public String boardList(Model model){
        List<Board> boardList = boardService.getBoardList();
        List<BoardCategory> boardCategoryList = boardService.getBoardCategoryList();


        model.addAttribute("title", "게시글목록");
        model.addAttribute("boardList", boardList);
        model.addAttribute("boardCategoryList", boardCategoryList);

        return "user/board/boardList";
    }
    //게시글 상세조회
    @GetMapping("boardView")
    public String boardView(@RequestParam(name="boardCode") String boardCode, Model model){
        List<BoardCategory> boardCategoryList = boardService.getBoardCategoryList();

        Board boardInfo = boardService.getBoardInfoById(boardCode);

        model.addAttribute("title", "게시판컨텐츠상세조회");
        model.addAttribute("boardInfo", boardInfo);
        model.addAttribute("boardCategoryList", boardCategoryList);

        return "user/board/boardView";
    }
}
