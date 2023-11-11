package ksmart.ks48team01.admin.controller;

import ksmart.ks48team01.dto.Officer;
import ksmart.ks48team01.service.OfficerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/officer")
public class AdminOfficerController {

    private OfficerService officerService;

    public AdminOfficerController (OfficerService officerService){
        this.officerService = officerService;
    }

    @GetMapping("officerInfoList")
    public String getOfficerInfoList(Model model)  {
        List<Officer> officerInfoList = officerService.getOfficerInfoList();

        model.addAttribute("officerList", officerInfoList);

        return "admin/officer/officerInfoList";
    }
}
