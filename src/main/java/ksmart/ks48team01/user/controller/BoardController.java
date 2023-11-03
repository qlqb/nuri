package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("BoardController")
@RequestMapping("/user/board")
public class BoardController {

    //게시판 조회
    @GetMapping("boardList")
    public String boardList(Model model){
        return "user/board/boardList";
    }

    @GetMapping("boardView")
    public String boardView(Model model){
        return "user/board/boardView";
    }
}
