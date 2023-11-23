package ksmart.ks48team01.admin.controller;

import com.google.gson.Gson;
import ksmart.ks48team01.dto.Officer;
import ksmart.ks48team01.service.OfficerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @ResponseBody
    @PostMapping("/officerSearchList")
    public String officerSearchList(@RequestBody Map<String, Object> officerKeyword) {
        Gson gson = new Gson();
        List<Officer> officerList;

        System.out.println(officerKeyword);
        String searchKey = (String) officerKeyword.get("searchKey");
        searchKey = switch (searchKey) {
            case "officerId" -> "OI.OFFICER_ID";
            case "officerUserName" -> "OI.OFFICE_USER_NAME";
            case "districtDepName" -> "DD.DISTRICT_DEP_NAME";
            case "workStartDate" -> "OI.WORK_START_DATE";
            case "officerRecentLogin" -> "OI.OFFICER_RECENT_LOGIN";
            case "officerAccountStat" -> "OI.OFFICER_ACCOUNT_STAT";
            default -> null;
        };
        String searchValue = (String) officerKeyword.get("searchValue");

        if(searchValue != null && searchKey != null) {
            officerList = officerService.officerSearchList(searchKey, searchValue);
        } else {
            officerList = officerService.getOfficerInfoList();
        }

        return gson.toJson(officerList);
    }

    @ResponseBody
    @PostMapping("/officerRegister")
    public int officerRegister(@RequestBody Officer officer) {
        int registerResult = officerService.officerRegister(officer);

        return registerResult;
    }

    @GetMapping("/officerInfoUpdate")
    public String officerInfoUpdate(Model model, @RequestParam (name = "officerId") String officerId) {
        Officer specificOfficerList = officerService.getSpecificOfficerList(officerId);
        model.addAttribute("officerUpdateList", specificOfficerList);

        return "admin/officer/officerInfoUpdate";
    }

    @PostMapping("/officerInfoUpdate")
    public String officerInfoUpdate(Officer officer) {
        officerService.getOfficerUpdate(officer);

        return "redirect:/admin/officer/officerInfoList";
    }
}
