package ksmart.ks48team01.admin.controller;

import com.google.gson.Gson;
import ksmart.ks48team01.dto.District;
import ksmart.ks48team01.dto.DistrictDep;
import ksmart.ks48team01.dto.Region;
import ksmart.ks48team01.service.AreaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/area")
public class AdminAreaController {

    private final AreaService areaService;

    public AdminAreaController (AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping("/areaList")
    public String getAreaList(Model model) {
        List<DistrictDep> districtDepList = areaService.getDistrictDepList();

        model.addAttribute("districtDepList", districtDepList);

        return "admin/area/areaList";
    }

    @ResponseBody
    @PostMapping("/getAreaList")
    public String getAreaList() {
        Gson gson = new Gson();
        List<DistrictDep> districtDepList = areaService.getDistrictDepList();

        return gson.toJson(districtDepList);
    }
}
