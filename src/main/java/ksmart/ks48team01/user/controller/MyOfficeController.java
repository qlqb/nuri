package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("myOfficeController")
@RequestMapping("/user/myoffice")
public class MyOfficeController {

    @GetMapping("/officerBudget")
    public String officerMyPageBudget(Model model) {

        return "user/myoffice/officerBudget";
    }

    @GetMapping("/officerRegion")
    public String officerMyPageRegion(Model model) {

        return "user/myoffice/officerRegion";
    }
}
