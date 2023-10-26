package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("myOfficeController")
@RequestMapping("/user/myoffice")
public class MyOfficeController {

    @GetMapping("/myOffice")
    public String MyOffice(Model model) {

        return "user/myoffice/myoffice";
    }
    
    @GetMapping("/myOfficeModify")
    public String MyOfficeModify(Model model) {

        return "user/myoffice/myofficeModify";
    }
	
    @GetMapping("/officerBudget")
    public String officerMyPageBudget(Model model) {

        return "user/myoffice/officerBudget";
    }

    @GetMapping("/officerRegion")
    public String officerMyPageRegion(Model model) {

        return "user/myoffice/officerRegion";
    }
    
	@GetMapping("/myBoard")
	public String myBoard(Model model) {

		model.addAttribute("title", "나의 작성한 게시글");

		return "user/myoffice/myBoard";
	}
}
