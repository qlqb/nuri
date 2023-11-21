package ksmart.ks48team01.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import ksmart.ks48team01.dto.*;
import ksmart.ks48team01.service.AreaService;
import ksmart.ks48team01.service.ContentsService;
import ksmart.ks48team01.service.OfficerService;
import ksmart.ks48team01.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller("registerController")
@RequestMapping("/user/register")
public class RegisterController {


    private final AreaService areaService;
    private final UserService userService;
    private final ContentsService contentsService;

    public RegisterController (AreaService areaService,
                               UserService userService,
                               ContentsService contentsService) {
        this.areaService = areaService;
        this.userService = userService;
        this.contentsService = contentsService;
    }

    // 가입 할 회원 권한을 선택할 수 있는 페이지
    // 권한 버튼에 따라서 쿼리스트링의 값이 바뀌고, 그 입력값에 따라 다른 가입 Form을 가져온다.
    @GetMapping("/registerType")
    public String registerType(Model model) {

        model.addAttribute("title", "회원선택 - 누리컬쳐");
        model.addAttribute("bannerTitle", "회원가입");

        return "user/register/registerType";
    }

    @ResponseBody
    @GetMapping("/districtList")
    public String getDistrictList(Model model, @RequestParam(name = "regionCode") String regionCode) {
        Gson gson = new Gson();
        List<District> districtList = areaService.getDistrictListByRegion(regionCode);

        return gson.toJson(districtList);
    }

    @ResponseBody
    @PostMapping("/userIdCheck")
    public String getUserIdCheck(@RequestBody Map<String, String> userIdCheckMap) {
        Gson gson = new Gson();
        String userId = userIdCheckMap.get("checkId");
        System.out.println(userId);
        Boolean checkedValue = userService.userIdCheck(userId);
        Map<String, Boolean> checkedMap = new HashMap<>();
        if(checkedValue == false) {
            checkedMap.put("checkedValue", true);
        } else {
            checkedMap.put("checkedValue", false);
        }
        System.out.println(checkedMap);

        return gson.toJson(checkedMap);
    }


    // Nuriculture 웹 애플리케이션을 이용하는 사용자(User) 권한의 가입 Form
    @GetMapping("/memberRegister")
    public String memberRegister(Model model) {
        // 지역 1 Select option 시 RegionList 출력
        List<Region> regionList = areaService.getRegionList();

        model.addAttribute("title", "회원가입 - 누리컬쳐");
        model.addAttribute("regionList", regionList);

        return "user/register/memberRegister";
    }


    // JavaScript에서 비동기처리로, user를 insert를 먼저 해야 제약조건에 위배가 되지 않는다.
    @ResponseBody
    @PostMapping("/memberRegister")
    public int memberRegister(@RequestBody User user) {
        int registerResult = userService.memberRegister(user);
        System.out.println(registerResult);

        return registerResult;
    }


    // Nuriculture 웹 애플리케이션에서 상품을 판매, 게시하는 가맹점(store) 권한의 가입 Form
    @GetMapping("/storeRegister")
    public String storeRegister(Model model) {
        List<Region> regionList = areaService.getRegionList();
        List<StoreCategory> storeCategoryList = contentsService.getStoreCategory();

        model.addAttribute("title", "회원가입 - 누리컬쳐");
        model.addAttribute("regionList", regionList);
        model.addAttribute("storeCategoryList", storeCategoryList);

        return "user/register/storeRegister";
    }

    // JavaScript에서 비동기처리로, user를 insert를 먼저 해야 제약조건에 위배가 되지 않는다.
    @ResponseBody
    @PostMapping("/storeUserRegister")
    public int storeUserRegister(@RequestBody User user) {
        int registerResult = userService.storeUserRegister(user);
        System.out.println(registerResult);

        return registerResult;
    }

    // Nuriculture 웹 애플리케이션을 이용, 관리하는 공무원(officer) 권한의 가입 Form
    @GetMapping("/officerRegister")
    public String officerRegister(Model model) {
        List<Region> regionList = areaService.getRegionList();
        List<DistrictDep> districtDepList = areaService.getDistrictDepList();

        model.addAttribute("title", "회원가입 - 누리컬쳐");
        model.addAttribute("regionList", regionList);
        model.addAttribute("districtDepList", districtDepList);

        return "user/register/officerRegister";
    }

    @ResponseBody
    @PostMapping("/officerUserRegister")
    public int officerUserRegister(@RequestBody User user) {
        int registerResult = userService.officerUserRegister(user);
        System.out.println(registerResult);

        return registerResult;
    }



    @ResponseBody
    @GetMapping("/departmentList")
    public String getDepartmentList(@RequestParam(value = "regionCode") String regionCode) {
        Gson gson = new Gson();
        List<DistrictDep> departmentList = areaService.departmentListByRegion(regionCode);

        return gson.toJson(departmentList);
    }



    // 회원가입이 완료되었다는 것을 표시하는 페이지
    @GetMapping("/registerConfirm")
    public String registerConfirm(Model model) {

        model.addAttribute("title", "회원가입 - 누리컬쳐");

        return "user/register/registerConfirm";
    }
}